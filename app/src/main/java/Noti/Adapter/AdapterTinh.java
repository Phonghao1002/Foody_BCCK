package Noti.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.foody.R;

import java.util.List;

import Noti.Tinh;

public class AdapterTinh  extends BaseAdapter {
    private Context context;
    int layout;
    List<Tinh> tinhList;
    public AdapterTinh(Context context, int layout, List<Tinh> tinhList) {
        this.context = context;
        this.layout = layout;
        this.tinhList = tinhList;
    }
    @Override
    public int getCount() {
        return  tinhList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater= (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        view=inflater.inflate(layout,null);
        TextView txtTinh=(TextView) view.findViewById(R.id.tinh);

        Tinh tinh = tinhList.get(i);

        txtTinh.setText(tinh.getTinh());
        return view;
    }
}
