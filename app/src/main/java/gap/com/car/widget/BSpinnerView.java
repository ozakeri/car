package gap.com.car.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;

import gap.com.car.R;


/**
 * Created by mahdi on 5/8/16 AD.
 */
public class BSpinnerView extends RelativeLayout {

    private ImageView line;
    private TextView text;
    private Context context;
    private Spinner spinner;


    public BSpinnerView(Context context) {
        super(context);
        this.context = context;
    }

    public BSpinnerView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
    }

    public BSpinnerView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        View root = LayoutInflater.from(context).inflate(R.layout.widget_spinnerview, this, true);
        line = (ImageView) root.findViewById(R.id.line);
        text = (TextView) root.findViewById(R.id.text);
        spinner = (Spinner) root.findViewById(R.id.spinner);

    }


    public void setText(String s)
    {
        text.setText(s);
    }

    public void setTextVisible(boolean visible)
    {
        text.setVisibility(visible ? VISIBLE : GONE);
    }

    public void setAdapter(SpinnerAdapter adapter)
    {
        spinner.setAdapter(adapter);
    }

    public void setOnItemSelectedListener(AdapterView.OnItemSelectedListener onItemClickListener)
    {
        spinner.setOnItemSelectedListener(onItemClickListener);
    }
    public Object getSelectedItem()
    {
        return spinner.getSelectedItem();
    }

    public void setSelection(int selection) {
        spinner.setSelection(selection);
    }

    public int getSelectedItemPosition()
    {
        return spinner.getSelectedItemPosition();
    }
}
