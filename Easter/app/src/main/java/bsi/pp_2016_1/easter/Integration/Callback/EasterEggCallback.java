package bsi.pp_2016_1.easter.Integration.Callback;

import com.google.gson.Gson;

import bsi.pp_2016_1.easter.Domain.EasterEgg;
import bsi.pp_2016_1.easter.Domain.Media;

/**
 * Created by Icaro on 26/05/2016.
 */
public class EasterEggCallback implements CustomCallback{


    @Override
    public Object onSuccess(String response) {
        Gson formatter = new Gson();
        EasterEgg easteregg = formatter.fromJson(response,EasterEgg.class);
        return easteregg;
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
