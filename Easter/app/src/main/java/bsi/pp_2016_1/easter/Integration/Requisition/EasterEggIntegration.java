package bsi.pp_2016_1.easter.Integration.Requisition;

import android.content.Context;

import com.google.gson.Gson;

import org.w3c.dom.Comment;

import java.util.HashMap;

import bsi.pp_2016_1.easter.Domain.Media;
import bsi.pp_2016_1.easter.Integration.Callback.EasterEggCallback;
import bsi.pp_2016_1.easter.Integration.Callback.MediaCallback;
import bsi.pp_2016_1.easter.Integration.ErrorListener;
import bsi.pp_2016_1.easter.Integration.ResponseListener;
import bsi.pp_2016_1.easter.Integration.RestConnector;

/**
 * Created by Icaro on 26/05/2016.
 */
public class EasterEggIntegration {

    private final String route = "/easteregg/";

    public void createComment(Comment comment, EasterEggCallback callback, Context context){

        HashMap<String,String> params = this.buildParams("createComment",comment);

        ResponseListener responseListener = new ResponseListener();
        responseListener.setCallback(callback);

        ErrorListener errorListener = new ErrorListener();
        this.createRequisition(params,responseListener,errorListener,context);

    }

    

    private HashMap<String,String> buildParams(String operation, Comment comment) {

        Gson formatter = new Gson();
        String jsonComment = formatter.toJson(comment, Comment.class);
        HashMap<String, String> params = new HashMap<String,String>();

        params.put("operation",operation);
        params.put("comment",jsonComment);

        return params;

    }


    public void createRequisition(HashMap params, ResponseListener responseListener, ErrorListener errorListener, Context context){
        RestConnector.post(this.route, params, responseListener, errorListener, context);
    }
}
