package Adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.foody.R;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.List;

public class SanPhamFoodAdapter extends BaseAdapter{

    private Context context;
    private List<SanPhamFood> sanPhamFoodList;

    public SanPhamFoodAdapter(Context context, List<SanPhamFood> sanPhamFoodList) {
        this.context = context;
        this.sanPhamFoodList = sanPhamFoodList;
    }

    @Override
    public int getCount() {
        return sanPhamFoodList.size();
    }

    @Override
    public Object getItem(int i) {
        return sanPhamFoodList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView mImg;
        TextView mTitle, mGia, mDiem, mGia2;
        public ViewHolder(View itemView){
            super(itemView);
        }
    }
    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {
        final ViewHolder holder;
        if (view == null){
            view = LayoutInflater.from(context).inflate(R.layout.item_sanpham, null);
            holder = new ViewHolder(view);
            holder.mImg = view.findViewById(R.id.img_sp);
            holder.mTitle = view.findViewById(R.id.title_sp);
            holder.mGia = view.findViewById(R.id.gia_sp);
            holder.mDiem = view.findViewById(R.id.diem_sp);
            view.setTag(holder);
        }
        else {
            holder = (ViewHolder) view.getTag();
        }
        try{
            SanPhamFood sp = sanPhamFoodList.get(i);
            String image = sp.getAnh();
            int resId = ((Activity)context).getResources().getIdentifier(image, "drawable", ((Activity)context).getPackageName());
            holder.mImg.setImageResource(resId);
            holder.mTitle.setText(sp.getTen());
            holder.mGia.setText(sp.getGia());
            holder.mDiem.setText(sp.getDiem());

            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    View bottomSheetView = null;
                    final ViewHolder holder1;
                    String Title = sanPhamFoodList.get(i).getTen();
                    final String Gia = sanPhamFoodList.get(i).getGia();
                    String Diemthg = sanPhamFoodList.get(i).getDiem();
                    int resId = ((Activity)context).getResources().getIdentifier(sanPhamFoodList.get(i).getAnh(), "drawable", ((Activity)context).getPackageName());

                    final BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(context, R.style.BottomSheetDialogTheme);
                    if(bottomSheetView == null){
                        bottomSheetView = LayoutInflater.from(context).inflate(R.layout.dialog_detail,null);
                        holder1 = new ViewHolder(bottomSheetView);

                        holder1.mTitle = bottomSheetView.findViewById(R.id.dialog_title);
                        holder1.mImg = bottomSheetView.findViewById(R.id.dialog_img);
                        holder1.mGia = bottomSheetView.findViewById(R.id.dialog_gia);
                        holder1.mDiem = bottomSheetView.findViewById(R.id.dialog_diemthg);
                        holder1.mGia2 = bottomSheetView.findViewById(R.id.dialog_giatong);

                        bottomSheetView.setTag(holder1);
                    }
                    else {
                        holder1 = (ViewHolder) bottomSheetView.getTag();
                    }
                    try {
                        holder1.mTitle.setText(Title);
                        holder1.mGia.setText(Gia);
                        holder1.mGia2.setText(Gia);
                        holder1.mDiem.setText(Diemthg);
                        holder1.mImg.setImageResource(resId);
                    } catch (Exception ex){
                    }
                    bottomSheetDialog.setContentView(bottomSheetView);
                    bottomSheetDialog.show();

                    final View finalBottomSheetView = bottomSheetView;
                    bottomSheetView.findViewById(R.id.dialog_removeslg).setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            String output1 = Gia;

                            TextView currentQuantityText = finalBottomSheetView.findViewById(R.id.dialog_slg);
                            int currentQuantity = Integer.parseInt((String) currentQuantityText.getText());
                            if(currentQuantity > 1) {
                                int newQuantity = currentQuantity - 1;
                                currentQuantityText.setText(String.valueOf(newQuantity));

                                int chuoi = Gia.length();
                                int x = 0;
                                if (chuoi == 8){
                                    x = 3;
                                }
                                else {
                                    x = 2;
                                }

                                TextView giaText = finalBottomSheetView.findViewById(R.id.dialog_giatong);
                                int gia = Integer.parseInt(output1.substring(0,x));
                                int newGia = gia * newQuantity;
                                String newGia1 = newGia +".000đ";
                                giaText.setText(newGia1);
                            }
                        }
                    });
                    bottomSheetView.findViewById(R.id.dialog_addslg);
                    bottomSheetView.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            String output2 = Gia;

                            int chuoi = Gia.length();
                            int x = 0;
                            if (chuoi == 8){
                                x = 3;
                            }
                            else {
                                x = 2;
                            }

                            TextView currentQuantityText = finalBottomSheetView.findViewById(R.id.dialog_slg);
                            int currentQuantity = Integer.parseInt((String) currentQuantityText.getText());
                            int newQuantity = currentQuantity + 1;
                            currentQuantityText.setText(String.valueOf(newQuantity));

                            TextView giaText = finalBottomSheetView.findViewById(R.id.dialog_giatong);
                            int gia = Integer.parseInt(output2.substring(0,x));
                            int newGia = gia * newQuantity;
                            String newGia1 = newGia +".000đ";
                            giaText.setText(newGia1);
                        }
                    });
                    bottomSheetView.findViewById(R.id.dialog_close).setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            bottomSheetDialog.hide();
                        }
                    });
                }
            });
        }catch (Exception ex){
        }
        return view;
    }
}
