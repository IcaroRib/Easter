package bsi.pp_2016_1.easter.Services;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Lucas on 11/05/2016.
 */
abstract class RestConnector {

    private static final String url = "http://localhost:8080"; //url do servidor

    private static Map<Context, RequestQueue> queuePool = new HashMap<Context, RequestQueue>();

    public static void get(String route, final Map<String, String> params, Response.Listener<String> response, Context ct) throws RuntimeException{

        try {
            Response.ErrorListener del = defaultErrorListener(ct);

            StringRequest request = new StringRequest(
                    url + route,
                    response,
                    del
            ) {
                @Override
                public Map<String, String> getParams() throws AuthFailureError {

                    return (params);
                }
            };

            request.setTag("get");
            getQueue(ct).add(request);
        } catch(RuntimeException e) {
            throw e;
        }
    }

    public static void get(String route, final Map<String, String> params, Response.Listener<String> response, Response.ErrorListener errorListener, Context ct) throws RuntimeException{
        try {
            StringRequest request = new StringRequest(
                    url + route,
                    response,
                    errorListener
            ) {
                @Override
                public Map<String, String> getParams() throws AuthFailureError {

                    return (params);
                }
            };

            request.setTag("get");
            getQueue(ct).add(request);
        } catch(RuntimeException e) {
            throw e;
        }
    }

    public static void post(String route, final Map<String, String> params, Response.Listener<String> response, Context ct) throws RuntimeException{

        try {
            Response.ErrorListener del = defaultErrorListener(ct);

            StringRequest request = new StringRequest(
                    url + route,
                    response,
                    del
            ) {
                @Override
                public Map<String, String> getParams() throws AuthFailureError {

                    return (params);
                }
            };

            request.setTag("post");
            getQueue(ct).add(request);
        } catch(RuntimeException e) {
            throw e;
        }
    }

    public static void post(String route, final Map<String, String> params, Response.Listener<String> response, Response.ErrorListener errorListener, Context ct) throws RuntimeException{
        try {
            StringRequest request = new StringRequest(
                    url + route,
                    response,
                    errorListener
            ) {
                @Override
                public Map<String, String> getParams() throws AuthFailureError {
                    return (params);
                }
            };

            request.setTag("post");
            getQueue(ct).add(request);
        } catch(RuntimeException e) {
            throw e;
        }
    }


    // Construção de um ErrorListener dependendo do Context
    private static Response.ErrorListener defaultErrorListener(final Context ct) {

        return new Response.ErrorListener(){

            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(ct,"Error: " + error.getMessage() , Toast.LENGTH_LONG).show();
            }
        };
    }

    private static RequestQueue getQueue(Context ct) {
        if(!queuePool.containsKey(ct)) {
            queuePool.put(ct, Volley.newRequestQueue(ct));
        }
        return queuePool.get(ct);
    }

    public String getUrl() {
        return url;
    }
}
