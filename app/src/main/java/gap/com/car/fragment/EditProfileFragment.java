package gap.com.car.fragment;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import gap.com.car.R;

public class EditProfileFragment extends Fragment {

    private ImageView img_driverImage, img_attach, img_electricBill, img_electricBillAttach;
    private TextView txt_address, txt_postCode, txt_mobileNo, txt_phoneNo;
    private Button btn_send;

    public EditProfileFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.edit_profile_fragment, container, false);
        img_driverImage = (ImageView) view.findViewById(R.id.img_driverImage);
        img_attach = (ImageView) view.findViewById(R.id.img_attach);
        img_electricBill = (ImageView) view.findViewById(R.id.img_electricBill);
        img_electricBillAttach = (ImageView) view.findViewById(R.id.img_electricBillAttach);

        txt_address = (TextView) view.findViewById(R.id.txt_address);
        txt_postCode = (TextView) view.findViewById(R.id.txt_postCode);
        txt_mobileNo = (TextView) view.findViewById(R.id.txt_mobileNo);
        txt_phoneNo = (TextView) view.findViewById(R.id.txt_phoneNo);

        btn_send = (Button) view.findViewById(R.id.btn_send);

        return view;
    }

}
