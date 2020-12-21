package Adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.foody.ProducDetail;
import com.example.foody.R;

import java.util.List;

import DataBase.CuaHang;

public class CuaHangFoodAdapter extends BaseAdapter {

    private Context context;
    private List<CuaHangFood> cuaHangFoodList;

    public CuaHangFoodAdapter(Context context, List<CuaHangFood> cuaHangFoodList){
        this.context = context;
        this.cuaHangFoodList = cuaHangFoodList;
    }
    @Override
    public int getCount() {
        return cuaHangFoodList.size();
    }

    @Override
    public Object getItem(int i) {
        return cuaHangFoodList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView mImage;
        TextView mTen, mMota;
        public ViewHolder(View itemView){
            super(itemView);
        }
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {
        final ViewHolder holder;
        if (view == null){
            view = LayoutInflater.from(context).inflate(R.layout.list, null);
            holder = new ViewHolder(view);
            holder.mImage = view.findViewById(R.id.h);
            holder.mTen = view.findViewById(R.id.t1);
            holder.mMota = view.findViewById(R.id.t2);

            view.setTag(holder);
        }
        else {
            holder = (ViewHolder) view.getTag();
        }
        try {
            CuaHangFood ch = cuaHangFoodList.get(i);
            String image = ch.getAnh();
            int resId = ((Activity) context).getResources().getIdentifier(image, "drawable", ((Activity) context).getPackageName());
            holder.mImage.setImageResource(resId);
            holder.mTen.setText(ch.getTen());
            holder.mMota.setText(ch.getMota());
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context, ProducDetail.class);
                    intent.putExtra("id", cuaHangFoodList.get(i).getId());
                    context.startActivity(intent);
                }
            });
        }catch (Exception ex){
        }
        return view;
    }
}
