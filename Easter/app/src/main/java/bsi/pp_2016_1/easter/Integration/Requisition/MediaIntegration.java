package bsi.pp_2016_1.easter.Integration.Requisition;

import android.content.Context;

import com.google.gson.Gson;

import java.util.HashMap;
import java.util.List;

import bsi.pp_2016_1.easter.Domain.EasterEgg;
import bsi.pp_2016_1.easter.Domain.Media;
import bsi.pp_2016_1.easter.Domain.User;
import bsi.pp_2016_1.easter.Integration.Callback.MediaCallback;
import bsi.pp_2016_1.easter.Integration.ErrorListener;
import bsi.pp_2016_1.easter.Integration.ResponseListener;
import bsi.pp_2016_1.easter.Integration.RestConnector;

/**
 * Created by Icaro on 26/05/2016.
 */
public class MediaIntegration {

    private final String route = "/media/index.php";

    public void findById(Media media, MediaCallback callback, Context context){

        HashMap<String,String> params = this.buildParams("find",media,"id");

        ResponseListener responseListener = new ResponseListener();
        responseListener.setCallback(callback);

        ErrorListener errorListener = new ErrorListener();
        this.createRequisition(params,responseListener,errorListener,context);

    }

    public void fetchMedias(MediaCallback callback, Context context, String type,  List<String> categories, int startAt){

        HashMap<String,String> params = this.buildParams("findVarious",type, categories, startAt);

        ResponseListener responseListener = new ResponseListener();
        responseListener.setCallback(callback);

        ErrorListener errorListener = new ErrorListener();
        this.createRequisition(params,responseListener,errorListener,context);

    }

    public void evaluateEasterEgg(User user, EasterEgg easteregg, MediaCallback callback, Context context){

        HashMap<String,String> params = this.buildParams("evaluate", user, easteregg);

        ResponseListener responseListener = new ResponseListener();
        responseListener.setCallback(callback);

        ErrorListener errorListener = new ErrorListener();
        this.createRequisition(params,responseListener,errorListener,context);

    }

    public void findByTitle(Media media, MediaCallback callback, Context context){

        HashMap<String,String> params = this.buildParams("find",media,"title");

        ResponseListener responseListener = new ResponseListener();
        responseListener.setCallback(callback);

        ErrorListener errorListener = new ErrorListener();
        this.createRequisition(params,responseListener,errorListener,context);

    }

    public void fallowMedia(Media media, User user, MediaCallback callback, Context context){

        HashMap<String,String> params = this.buildParams("fallow",user,media);

        ResponseListener responseListener = new ResponseListener();
        responseListener.setCallback(callback);

        ErrorListener errorListener = new ErrorListener();
        this.createRequisition(params, responseListener, errorListener, context);

    }

    public void unfallowMedia(Media media, User user, MediaCallback callback, Context context) {
        HashMap<String,String> params = this.buildParams("unfallow",user,media);

        ResponseListener responseListener = new ResponseListener();
        responseListener.setCallback(callback);

        ErrorListener errorListener = new ErrorListener();
        this.createRequisition(params, responseListener, errorListener, context);
    }

    private void createRequisition(HashMap<String, String> params, ResponseListener responseListener, ErrorListener errorListener, Context context) {

       RestConnector.post(route, params, responseListener, errorListener, context);

    }

    private HashMap<String,String> buildParams(String operation, Media media, String typeFind) {

        Gson formatter = new Gson();
        String jsonMedia = formatter.toJson(media, Media.class);
        HashMap<String, String> params = new HashMap<String,String>();
        System.out.println(jsonMedia);

        params.put("operation",operation);
        params.put("media",jsonMedia);
        params.put("type", typeFind);

        return params;

    }

    private HashMap<String,String> buildParams(String operation,String typeFind,  List<String> categories, int startAt) {

        Gson formatter = new Gson();
        String stringCategories = formatter.toJson(categories);
        HashMap<String, String> params = new HashMap<String,String>();
        System.out.println(stringCategories);

        params.put("operation", operation);
        params.put("type", typeFind);
        params.put("categories",stringCategories);
        params.put("start", Integer.toString(startAt));

        return params;

    }

    private HashMap<String,String> buildParams(String operation, User user, EasterEgg easteregg) {

        Gson formatter = new Gson();
        String stringUser = formatter.toJson(user);
        String stringEasterEgg = formatter.toJson(easteregg);
        HashMap<String, String> params = new HashMap<String,String>();
        System.out.println(stringUser);
        System.out.println(stringEasterEgg);

        params.put("operation",operation);
        params.put("easteregg",stringEasterEgg);
        params.put("user", stringUser);

        return params;

    }

    private HashMap<String,String> buildParams(String operation, User user, Media media) {

        Gson formatter = new Gson();
        String stringUser = formatter.toJson(user);
        String stringMedia = formatter.toJson(media);
        HashMap<String, String> params = new HashMap<String,String>();

        params.put("operation",operation);
        params.put("media",stringMedia);
        params.put("user", stringUser);

        return params;

    }



}