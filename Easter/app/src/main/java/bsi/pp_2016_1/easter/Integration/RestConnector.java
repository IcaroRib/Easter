package bsi.pp_2016_1.easter.Integration;

import android.content.Context;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.Map;

public abstract class RestConnector {

    private static final String url = "https://easter-netorodrigues.c9users.io/EasterServer/routes"; //url do servidor

    private static RequestQueue queue;

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
            setContext(ct);
            queue.add(request);

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
            setContext(ct);
            queue.add(request);

        } catch(RuntimeException e) {
            throw e;
        }
    }

    public static void post(String route, final Map<String, String> params, Response.Listener<String> response, Context ct) throws RuntimeException{

        try {
            Response.ErrorListener del = defaultErrorListener(ct);

            StringRequest request = new StringRequest(Request.Method.POST,
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
            setContext(ct);
            queue.add(request);

        } catch(RuntimeException e) {
            throw e;
        }
    }

    public static void post(String route, final Map<String, String> params, Response.Listener<String> response, Response.ErrorListener errorListener, Context ct) throws RuntimeException{
        System.out.println("POST");
        try {
            StringRequest request = new StringRequest(Request.Method.POST,
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
            setContext(ct);
            queue.add(request);

        } catch(RuntimeException e) {
            throw e;
        }


    }


    // Construção de um ErrorListener dependendo do Context
    private static Response.ErrorListener defaultErrorListener(final Context ct) {

        return new Response.ErrorListener(){

            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(ct, "Error: " + error.getMessage(), Toast.LENGTH_LONG).show();
            }
        };
    }

    private static void setContext(Context ct) {

        if (queue == null){
            queue = Volley.newRequestQueue(ct);
        }
    }

    public String getUrl() {
        return url;
    }
}
