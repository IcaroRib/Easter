package bsi.pp_2016_1.easter.Integration.Callback;

import com.google.gson.Gson;

import bsi.pp_2016_1.easter.Domain.Media;
import bsi.pp_2016_1.easter.Domain.User;

/**
 * Created by Icaro on 26/05/2016.
 */
public class MediaCallback implements CustomCallback{

    @Override
    public Object onSuccess(String response) {
        Gson formatter = new Gson();
        Media media = formatter.fromJson(response,Media.class);
        return media;
    }

    @Override
    public void onFailure(String response) {
        try {
            throw new Exception(response);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
