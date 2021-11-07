package gap.com.car.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.appcompat.widget.AppCompatImageView;

import java.util.ArrayList;

import gap.com.car.R;
import gap.com.car.model.TypeBean;


public class TypeSpinnerAdapter extends BaseAdapter {
    private Activity mContext;
    private ArrayList<TypeBean> typeBeen;
    private ViewHolder holder;


    public TypeSpinnerAdapter(Activity mContext, ArrayList<TypeBean> typeBeen) {
        this.mContext = mContext;
        this.typeBeen = typeBeen;
    }

    @Override
    public int getCount() {
        return typeBeen.size();
    }

    @Override
    public Object getItem(int position) {
        return typeBeen.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            LayoutInflater mInflater = (LayoutInflater) mContext.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView = mInflater.inflate(R.layout.row_spinner, parent, false);

            holder = new ViewHolder();
            holder.number = (TextView) convertView.findViewById(R.id.textView1);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        TypeBean typeBean = typeBeen.get(position);

        holder.number.setText(typeBean.getType());

        return convertView;
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater mInflater = (LayoutInflater) mContext.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView = mInflater.inflate(R.layout.row_spinner, parent, false);

            holder = new ViewHolder();
            holder.number = (TextView) convertView.findViewById(R.id.textView1);
            holder.img_item = (AppCompatImageView) convertView.findViewById(R.id.img_item);

            convertView.setBackgroundColor(mContext.getResources().getColor(android.R.color.white));
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        TypeBean typeBean = typeBeen.get(position);

        holder.number.setText(typeBean.getType());

        if (position == 0){
            holder.img_item.setBackgroundResource(R.drawable.enteghad);
        }else if (position == 1){
            holder.img_item.setBackgroundResource(R.drawable.pishnehad);
        }else if (position == 2){
            holder.img_item.setBackgroundResource(R.drawable.rafe_moshkel);
        }

        return convertView;
    }

    private static class ViewHolder {
        private TextView number;
        private AppCompatImageView img_item;
    }
}