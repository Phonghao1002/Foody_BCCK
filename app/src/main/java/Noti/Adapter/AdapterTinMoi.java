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

import Noti.TinMoi;


public class AdapterTinMoi  extends BaseAdapter {
    private Context context;
    int layout;
    List<TinMoi> tinMoiList;
    public AdapterTinMoi(Context context, int layout, List<TinMoi> danhsachList) {
        this.context = context;
        this.layout = layout;
        this.tinMoiList = danhsachList;
    }
    @Override
    public int getCount() {
        return  tinMoiList.size();
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
        TextView txtTieuDe=(TextView) view.findViewById(R.id.textTinmoi1);
        TextView txtNoiDung=(TextView) view.findViewById(R.id.textTinmoi2);
        ImageView imgImage=(ImageView) view.findViewById(R.id.imageTinMoi);

        TinMoi tinmoi = tinMoiList.get(i);

        txtTieuDe.setText(tinmoi.getTieuDe());
        txtNoiDung.setText(tinmoi.getNoiDung());
        imgImage.setImageResource(tinmoi.getImage());
        return view;
    }
}
