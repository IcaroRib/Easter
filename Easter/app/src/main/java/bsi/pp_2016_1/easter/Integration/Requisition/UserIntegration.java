package bsi.pp_2016_1.easter.Integration.Requisition;

import android.content.Context;
import com.google.gson.Gson;
import java.util.HashMap;
import bsi.pp_2016_1.easter.Domain.UserRequisition;
import bsi.pp_2016_1.easter.Integration.Callback.UserCallback;
import bsi.pp_2016_1.easter.Integration.ErrorListener;
import bsi.pp_2016_1.easter.Integration.ResponseListener;
import bsi.pp_2016_1.easter.Integration.RestConnector;


/**
 * Created by Icaro on 25/05/2016.
 */
public class UserIntegration {

    private final String route = "/user/";

    public void signup(UserRequisition userReq, UserCallback callback, Context context){

        HashMap<String,String> params = this.buildParams("create",userReq,"native");

        ResponseListener responseListener = new ResponseListener();
        responseListener.setCallback(callback);

        ErrorListener errorListener = new ErrorListener();
        this.createRequisition(params,responseListener,errorListener,context);

    }

    public void login(UserRequisition userReq, UserCallback callback, Context context){

        HashMap<String,String> params = this.buildParams("login",userReq,"native");

        ResponseListener responseListener = new ResponseListener();
        responseListener.setCallback(callback);

        ErrorListener errorListener = new ErrorListener();
        this.createRequisition(params,responseListener,errorListener,context);

    }

    public void editUser(UserRequisition userReq, UserCallback callback, Context context){

            HashMap<String,String> params = this.buildParams("edit",userReq,"native");

            ResponseListener responseListener = new ResponseListener();
            responseListener.setCallback(callback);

            ErrorListener errorListener = new ErrorListener();
            this.createRequisition(params,responseListener,errorListener,context);

        }

    public HashMap<String,String> buildParams(String operation, UserRequisition user, String profileType){

        Gson formatter = new Gson();
        String jsonUser = formatter.toJson(user, UserRequisition.class);
        System.out.println(jsonUser);
        HashMap<String, String> params = new HashMap<String,String>();

        params.put("operation",operation);
        params.put("user",jsonUser);
        params.put("profileType", profileType);

        return params;
    }

    public void createRequisition(HashMap params, ResponseListener responseListener, ErrorListener errorListener, Context context){
        RestConnector.post(this.route, params, responseListener, errorListener, context);
    }


}
