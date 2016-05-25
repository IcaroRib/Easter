package bsi.pp_2016_1.easter.Services;


import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by franc on 30/04/2016.
 */
public class LoginServices {

    private Context ct;
    private RequestQueue rq;

    public static boolean login(String username, String password, final Context ct){
        StringBuilder pwd = new StringBuilder();
        pwd.append(password);
        pwd.append("StanLee");

        Map<String, String> credentials = new HashMap<>();

        credentials.put("username", username);
        credentials.put("password", pwd.toString());

        //TODO: Implementar logica referente ao login do usuario
        RestConnector.get(
                "/user/login",
                credentials,
                new Response.Listener<String>() {

                    @Override
                    public void onResponse(String response) {

                        try {
                            JSONObject responseObj = new JSONObject(response);
                            Log.i("Response", response);

                        } catch(JSONException e) {
                            e.printStackTrace();
                            Log.e("JSON Parse Error", response);
                        }

                    }

                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(ct, error.getMessage(), Toast.LENGTH_LONG).show();
                    }
                },
                ct
        );

        return true;
    }
}
