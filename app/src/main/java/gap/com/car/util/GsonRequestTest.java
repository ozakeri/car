package gap.com.car.util;

import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.HttpHeaderParser;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.UnsupportedEncodingException;

import gap.com.car.model.ErrorResponseBean;

public class GsonRequestTest<T> extends Request<T> {
    //private Gson mGson;
    private Gson mGson = new GsonBuilder().serializeNulls().create();
    private final Response.Listener<T> mListener;
    private Class<T> mClass;

    public GsonRequestTest(int method, String url, Class<T> clazz, Response.Listener<T> listener, Response.ErrorListener reeorlistener) {
        super(method, url, reeorlistener);
        mGson = new Gson();
        mClass = clazz;
        mListener = listener;
    }

    public GsonRequestTest(String url, Class<T> clazz, Response.Listener<T> listener, Response.ErrorListener errorlistener) {
        this(Method.GET, url, clazz, listener, errorlistener);

    }

    @Override
    protected Response<T> parseNetworkResponse(NetworkResponse networkResponse) {
        try {

            Util.printLogs("Response code = " + networkResponse.statusCode);
            System.out.println("Response code = " + networkResponse.statusCode);

            String jsonString = new String(networkResponse.data, HttpHeaderParser.parseCharset(networkResponse.headers));
            return Response.success(mGson.fromJson(jsonString, mClass), HttpHeaderParser.parseCacheHeaders(networkResponse));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return Response.error(new ParseError(e));
        }

    }

    @Override
    protected VolleyError parseNetworkError(VolleyError volleyError) {


        try {
            NetworkResponse response = volleyError.networkResponse;
            if (response == null) {
                return new CustomError(null, new ErrorResponseBean());
            }

            Util.printLogs("Error code = " + response.statusCode);
            System.out.println("Error code = " + response.statusCode);

            String json = new String(
                    response.data,
                    HttpHeaderParser.parseCharset(response.headers));

            Util.printLogs("Error json = " + json);
            System.out.println("Error json = " + json);

            ErrorResponseBean errorResponseBean = mGson.fromJson(json, ErrorResponseBean.class);
            return new CustomError(response, errorResponseBean);

        } catch (Exception e1) {

            Util.printAllStackTrace(e1);
        }
        return volleyError;

    }

    @Override
    protected void deliverResponse(T t) {
        mListener.onResponse(t);
    }
}








