package bsi.pp_2016_1.easter.Services;

import com.google.gson.Gson;

import java.io.ObjectInput;

import javax.security.auth.callback.*;

import bsi.pp_2016_1.easter.Domain.User;

/**
 * Created by Lucas on 25/05/2016.
 */
public class UserCallback implements CustomCallback{


    @Override
    public Object onSuccess(String response) {

        Gson formatter = new Gson();
        User loggedUser = formatter.fromJson(response,User.class);
        return loggedUser;
    }

    @Override
    public void onFailure(String response){
        try {
            throw new Exception(response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
