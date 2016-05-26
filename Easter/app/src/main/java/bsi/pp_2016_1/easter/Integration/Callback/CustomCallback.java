package bsi.pp_2016_1.easter.Integration.Callback;

/**
 * Created by Lucas on 25/05/2016.
 */
public interface CustomCallback {
    Object onSuccess(String response);
    void onFailure(String response);
}

