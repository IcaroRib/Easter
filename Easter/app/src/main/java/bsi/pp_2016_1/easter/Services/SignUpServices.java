package bsi.pp_2016_1.easter.Services;

import android.content.Context;
import android.util.Log;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

import bsi.pp_2016_1.easter.Domain.User;
import bsi.pp_2016_1.easter.Domain.UserRequisition;

//compile 'com.squareup.retrofit:retrofit:1.9.0'

/**
 * Created by Lucas on 13/05/2016.
 */
public class SignUpServices {


    public static boolean signup(UserRequisition userReq, UserCallback cb, Context ct){

        final Gson formater = new Gson();
        String jsonUser = formater.toJson(userReq, UserRequisition.class);
        HashMap<String, String> params = new HashMap<String,String>();

        params.put("operation","create");
        params.put("user",jsonUser);
        params.put("profileType","native");

        User loggedUser = null;

        ResponseListener rl = new ResponseListener();
        rl.setCallback(cb);

        RestConnector.post(
            "/user/index.php",
            params,
            rl,
            new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {

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



