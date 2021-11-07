package gap.com.car.util;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

import gap.com.car.app.CarApplication;


public class RestClient {


    private static RestClient instance = null;
    private RequestQueue mRequestQueue;
    private static final String TAG = "MyTag";


    public static synchronized RestClient getInstance()
    {
        if (instance == null)
        {
            instance = new RestClient();
        }
        return instance;
    }

    private RestClient() {
        mRequestQueue = getRequestQueue();
    }

    private RequestQueue getRequestQueue() {
        if (mRequestQueue == null) {
            mRequestQueue = Volley.newRequestQueue(CarApplication.getInstance().getApplicationContext());
        }
        return mRequestQueue;
    }

    public void cancel()
    {
        if (mRequestQueue != null)
            mRequestQueue.cancelAll(TAG);
    }

    public <T> void addToRequestQueue(GsonRequest<T> req) {
        req.setTag(TAG);
        getRequestQueue().add(req);
    }

}