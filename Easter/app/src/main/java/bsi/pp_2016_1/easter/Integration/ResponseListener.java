package bsi.pp_2016_1.easter.Integration;

import com.android.volley.Response;

import bsi.pp_2016_1.easter.Integration.Callback.CustomCallback;

/**
 * Created by Lucas on 25/05/2016.
 */
public class ResponseListener implements Response.Listener<String> {

    private CustomCallback callback;

    @Override
    public void onResponse(String response) {
        if(callback == null) {
            try {
                this.callbackFailure();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        if(!response.contains("id")) {
            System.out.println("AQUI: " + response);
            callback.onFailure(response);
        }

        else{
            callback.onSuccess(response);
        }
    }

    public void setCallback(CustomCallback callback){
        this.callback = callback;
    }

    private void callbackFailure() throws Exception {
        Exception ex = new Exception();
        throw ex;
    }
}
