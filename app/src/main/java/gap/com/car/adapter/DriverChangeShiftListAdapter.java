package gap.com.car.adapter;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;
import gap.com.car.R;
import gap.com.car.model.DriverChangedEDAList;
import gap.com.car.widget.BTextView;

public class DriverChangeShiftListAdapter extends RecyclerView.Adapter<DriverChangeShiftListAdapter.CustomView> {

    private List<DriverChangedEDAList> driverChangedEDALists = new ArrayList<>();
    private Context context;

    public DriverChangeShiftListAdapter(Context context, List<DriverChangedEDAList> driverChangedEDALists) {
        this.driverChangedEDALists = driverChangedEDALists;
        this.context = context;
    }

    @NonNull
    @Override
    public CustomView onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.items_shift_layout, viewGroup, false);
        return new CustomView(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomView customView, int position) {

        final DriverChangedEDAList eda = driverChangedEDALists.get(position);
        customView.txt_hamShift.setText(eda.getPerson().getNameFv());
        customView.txt_code.setText(" ( " + eda.getDriverCode() + " ) ");

        List<Integer> integerList = eda.getPerson().getPictureBytes();
        JSONArray jsonArray = new JSONArray();
        for (int i = 0; i < integerList.size(); i++) {
            jsonArray.put(integerList.get(i));
        }

        byte[] bytes = new byte[jsonArray.length()];
        for (int i = 0; i < jsonArray.length(); i++) {
            try {
                bytes[i] = Integer.valueOf(jsonArray.getInt(i)).byteValue();
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        Bitmap bitmap = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
        customView.img_hamShift.setImageBitmap(bitmap);

        System.out.println("salaryAttribute=====" + eda.getMobileNo());

        customView.img_message.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent smsIntent = new Intent(Intent.ACTION_VIEW);
                smsIntent.setType("vnd.android-dir/mms-sms");
                smsIntent.putExtra("address", eda.getMobileNo());
                context.startActivity(smsIntent);

            }
        });

        customView.img_call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:" + eda.getMobileNo()));
// Here, thisActivity is the current activity
                if (ContextCompat.checkSelfPermission(context,
                        Manifest.permission.CALL_PHONE)
                        != PackageManager.PERMISSION_GRANTED) {

                    ActivityCompat.requestPermissions((Activity) context,
                            new String[]{Manifest.permission.CALL_PHONE},
                            1);

                    // MY_PERMISSIONS_REQUEST_CALL_PHONE is an
                    // app-defined int constant. The callback method gets the
                    // result of the request.
                } else {
                    //You already have permission
                    try {
                        context.startActivity(callIntent);
                    } catch (SecurityException e) {
                        e.printStackTrace();
                    }
                }
            }
        });


    }

    @Override
    public int getItemCount() {
        return driverChangedEDALists.size();
    }

    public class CustomView extends RecyclerView.ViewHolder {
        BTextView txt_hamShift, txt_code;
        ImageView img_message, img_call;
        CircleImageView img_hamShift;

        public CustomView(@NonNull View itemView) {
            super(itemView);
            img_message = itemView.findViewById(R.id.img_message);
            img_hamShift = itemView.findViewById(R.id.img_hamShift);
            img_call = itemView.findViewById(R.id.img_call);
            txt_hamShift = itemView.findViewById(R.id.txt_hamShift);
            txt_code = itemView.findViewById(R.id.txt_code);

        }
    }
}
