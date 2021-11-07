package gap.com.car.activity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.PointF;
import android.graphics.RectF;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONArray;
import org.json.JSONException;

import gap.com.car.R;
import gap.com.car.util.TouchImageView;

public class FullScreenActivity extends AppCompatActivity {
    private TouchImageView image_View;
    private RelativeLayout layoutToolbar;
    private ImageView img_close;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_screen);

        image_View = (TouchImageView) findViewById(R.id.image_View);
        layoutToolbar = (RelativeLayout) findViewById(R.id.layoutToolbar);
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.back_Icon);
        img_close =  findViewById(R.id.img_close);
        Bundle bundle = getIntent().getExtras();

        if (bundle != null) {
               String s = bundle.getString("attachFileJsonArrayJsonObject");
            JSONArray array = null;
            try {
                array = new JSONArray(s);
                byte[] bytes = new byte[0];
                bytes = new byte[array.length()];
                for (int j = 0; j < array.length(); j++) {
                    bytes[j] = Integer.valueOf(array.getInt(j)).byteValue();
                }
                Bitmap bitmap = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
                image_View.setImageBitmap(bitmap);
            } catch (JSONException e) {
                e.printStackTrace();
            }

            String res = bundle.getString("result");

        }

        image_View.setOnTouchImageViewListener(new TouchImageView.OnTouchImageViewListener() {
            @Override
            public void onMove() {
                PointF point = image_View.getScrollPosition();
                RectF rect = image_View.getZoomedRect();
                float currentZoom = image_View.getCurrentZoom();
                boolean isZoomed = image_View.isZoomed();
            }
        });

        relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        img_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    public Bitmap resizeBitmap(String photoPath) {
        BitmapFactory.Options bmOptions = new BitmapFactory.Options();
        bmOptions.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(photoPath, bmOptions);
        int scaleFactor = 1;
        bmOptions.inJustDecodeBounds = false;
        bmOptions.inSampleSize = scaleFactor;
        bmOptions.inPurgeable = true; //Deprecated API 21
        return BitmapFactory.decodeFile(photoPath, bmOptions);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
