package bsi.pp_2016_1.easter.Services;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Map;

/**
 * Created by Lucas on 13/05/2016.
 */
public class SignUpServices {


    public static boolean signup(Map<String, String> params,final Context ct){

        params = formattedCredentials(params);

        //TODO: Implementar logica referente ao cadastro de usuario
        RestConnector.post(
                "/user/create",
                params,
                new Response.Listener<String>() {

                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject responseObj = new JSONObject(response);


                        } catch (JSONException e) {
                            Log.e("JSON Parse Error", response);
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(ct, error.getMessage(), Toast.LENGTH_SHORT).show();
                        Log.e("Connection Error", error.getMessage());
                        error.printStackTrace();
                    }
                },
                ct
        );

        return true;
    }

    private static Map<String, String> formattedCredentials(Map<String, String> params) {
        StringBuilder pwd = new StringBuilder();
        pwd.append(params.get("password"));
        pwd.append("AlanMoore");

        params.put("password", pwd.toString());

        return (params);
    }
}



