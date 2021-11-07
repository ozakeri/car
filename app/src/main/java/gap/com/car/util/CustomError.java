package gap.com.car.util;

import com.android.volley.NetworkResponse;
import com.android.volley.VolleyError;

import gap.com.car.model.ErrorResponseBean;

/**
 * Created by mahdi on 10/18/16.
 */

public class CustomError extends VolleyError {

    public ErrorResponseBean errorResponseBean;

    public CustomError(NetworkResponse response, ErrorResponseBean errorResponseBean) {
        super(response);
        this.errorResponseBean = errorResponseBean;
    }

}
