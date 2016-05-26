package bsi.pp_2016_1.easter.Integration.Callback;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import bsi.pp_2016_1.easter.Domain.Media;
import bsi.pp_2016_1.easter.Domain.User;

/**
 * Created by Icaro on 26/05/2016.
 */
public class MediaCallback implements CustomCallback{

    @Override
    public Object onSuccess(String response) {
        Gson formatter = new Gson();
        if (response.substring(0,1).equals("L")){
            Media arrayMedias[] = formatter.fromJson(response.substring(1,response.length()), Media[].class);

            ArrayList<Media> listaMedias = new ArrayList<Media>();
            for (Media media: arrayMedias) {
                listaMedias.add(media);
            }

            return listaMedias;
        }
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
