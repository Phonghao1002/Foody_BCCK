package Noti;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.example.foody.R;

import java.util.ArrayList;

import Noti.Adapter.AdapterTinMoi;

public class TinmoiFragment extends Fragment {
    GridView gridView;
    ArrayList<TinMoi> mangTinMoi;
    AdapterTinMoi adapter;

    public TinmoiFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root =inflater.inflate(R.layout.fragment_tinmoi, container, false);
        Anhxa(root);

        return root;
    }

    private void Anhxa(View root) {
        gridView=(GridView) root.findViewById(R.id.grTinMoi);
        mangTinMoi =new ArrayList<>();
        mangTinMoi.add(new TinMoi("Giảm tới 30% Ritaki - Khoai Lang Mật - Nguyễn Văn Cừ chỉ từ 140K","Nguyễn hữu Thắng 18t3,giảm giá 50%",R.drawable.ch3));
        mangTinMoi.add(new TinMoi("Nguyễn Hữu Thắng","Nguyễn Hữu Thắng 18t3,giảm giá 50%",R.drawable.ch1));
        mangTinMoi.add(new TinMoi("Nguyễn Hữu Thắng","Nguyễn Hữu Thắng 18t3,giảm giá 70%",R.drawable.ch2));
        mangTinMoi.add(new TinMoi("Giảm tới 30% Ritaki - Khoai Lang Mật - Nguyễn Văn Cừ chỉ từ 140K","Nguyễn hữu Thắng 18t3,giảm giá 50%",R.drawable.ch3));
        mangTinMoi.add(new TinMoi("Giảm tới 30% Ritaki - Khoai Lang Mật - Nguyễn Văn Cừ chỉ từ 140K","Nguyễn hữu Thắng 18t3,giảm giá 50%",R.drawable.ch3));
        mangTinMoi.add(new TinMoi("Giảm tới 30% Ritaki - Khoai Lang Mật - Nguyễn Văn Cừ chỉ từ 140K","Nguyễn hữu Thắng 18t3,giảm giá 50%",R.drawable.ch3));
        mangTinMoi.add(new TinMoi("Giảm tới 30% Ritaki - Khoai Lang Mật - Nguyễn Văn Cừ chỉ từ 140K","Nguyễn hữu Thắng 18t3,giảm giá 50%",R.drawable.ch3));
        mangTinMoi.add(new TinMoi("Giảm tới 30% Ritaki - Khoai Lang Mật - Nguyễn Văn Cừ chỉ từ 140K","Nguyễn hữu Thắng 18t3,giảm giá 50%",R.drawable.ch3));
        adapter= new AdapterTinMoi(this.getActivity(),R.layout.row_tm, mangTinMoi);
        gridView.setAdapter(adapter);
    }
}