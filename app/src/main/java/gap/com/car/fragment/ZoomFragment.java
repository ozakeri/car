package gap.com.car.fragment;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.android.volley.Response;
import com.android.volley.VolleyError;

import org.json.JSONArray;
import org.json.JSONException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import gap.com.car.R;
import gap.com.car.common.CalendarUtil;
import gap.com.car.common.Constants;
import gap.com.car.database.DataBaseClint;
import gap.com.car.database.entity.Driver;
import gap.com.car.model.ServerDateTimeResponseBean;
import gap.com.car.model.carprofile.CarProfileResultBean;
import gap.com.car.services.ServerCoordinator;
import gap.com.car.util.DateUtils;
import gap.com.car.util.Globals;
import gap.com.car.util.Utils;
import gap.com.car.widget.CircularProgress;
import gap.com.car.widget.ZoomableImageView;

public class ZoomFragment extends Fragment {

    private Globals sharedData = Globals.getInstance();

    public ZoomFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.zoom_fragment, container, false);

        ZoomableImageView touch = view.findViewById(R.id.img_zoom);
        touch.setImageBitmap(sharedData.getBitmap());

        return view;
    }

}
