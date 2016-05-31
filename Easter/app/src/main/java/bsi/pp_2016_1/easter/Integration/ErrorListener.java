package bsi.pp_2016_1.easter.Integration;

import android.util.Log;

import com.android.volley.Response;
import com.android.volley.VolleyError;

public class ErrorListener implements Response.ErrorListener {
    @Override
    public void onErrorResponse(VolleyError error) {
        Log.e("Connection Error", error.getMessage());
        error.printStackTrace();
    }
}