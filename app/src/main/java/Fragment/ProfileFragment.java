package Fragment;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import com.example.foody.HoaDonActivity;
import com.example.foody.ListViewBaseAdapter;
import com.example.foody.ListViewBaseAdapter_2;
import com.example.foody.ListViewBean;
import com.example.foody.ListViewBean_2;
import dangnhap_dangki.LoginActivity;
import com.example.foody.MoiBBActivity;
import com.example.foody.ProfileActivity;
import com.example.foody.R;
import com.example.foody.SettingActivity;
import com.example.foody.ThanhToanActivity;
import com.example.foody.TienThuongActivity;
import com.example.foody.VoucherActivity;

import java.util.ArrayList;

public class ProfileFragment extends Fragment {

    ListView lv, lv1, lv2, lv3;
    ListViewBaseAdapter adapter;
    ArrayList<ListViewBean> arr_bean;

    ListViewBaseAdapter_2 adapter_2;
    ArrayList<ListViewBean_2> arr_bean_2;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_profile,container,false);

        lv = (ListView) v.findViewById(R.id.list_user);
        arr_bean_2 = new ArrayList<ListViewBean_2>();
        arr_bean_2.add(new ListViewBean_2(R.drawable.avta_male, "Bình Nguyễn"));
        adapter_2 = new ListViewBaseAdapter_2(arr_bean_2, getActivity()) {
            @Override
            public long getItemId(int i) {
                return 0;
            }
        };
        lv.setAdapter(adapter_2);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getActivity(), ProfileActivity.class);
                startActivity(intent);
            }
        });

        lv1 = (ListView) v.findViewById(R.id.list_1);
        arr_bean = new ArrayList<ListViewBean>();
        arr_bean.add(new ListViewBean(R.drawable.icon_pay, "Thanh toán"));
        arr_bean.add(new ListViewBean(R.drawable.icon_history, "Lịch sử"));
        arr_bean.add(new ListViewBean(R.drawable.icon_bill, "Hóa đơn"));
        arr_bean.add(new ListViewBean(R.drawable.icon_bonus, "Tiền thưởng"));
        arr_bean.add(new ListViewBean(R.drawable.icon_voucher, "Ví Voucher"));
        arr_bean.add(new ListViewBean(R.drawable.icon_foody, "Ứng dụng cho chủ quán"));
        adapter = new ListViewBaseAdapter(arr_bean, getActivity()) {
            @Override
            public long getItemId(int i) {
                return 0;
            }
        };
        lv1.setAdapter(adapter);
        lv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i){
                    case 0:
                        Intent intent = new Intent(getActivity(), ThanhToanActivity.class);
                        startActivity(intent);
                        return;
                    //case 1:
                    //    FragmentTransaction fr = getFragmentManager().beginTransaction();
                    //    fr.replace(R.id.view_pager_main, new InvoiceFragment());
                    //    fr.commit();
                    //    return;
                    case 2:
                        Intent intent2 = new Intent(getActivity(), HoaDonActivity.class);
                        startActivity(intent2);
                        return;
                    case 3:
                        Intent intent3 = new Intent(getActivity(), TienThuongActivity.class);
                        startActivity(intent3);
                        return;
                    case 4:
                        Intent intent4 = new Intent(getActivity(), VoucherActivity.class);
                        startActivity(intent4);
                        return;
                    default:
                        return;
                }

            }
        });

        lv2 = (ListView) v.findViewById(R.id.list_2);
        arr_bean = new ArrayList<ListViewBean>();
        arr_bean.add(new ListViewBean(R.drawable.icon_add_friend,"Mời bạn bè"));
        arr_bean.add(new ListViewBean(R.drawable.icon_gop_y,"Góp ý"));
        adapter = new ListViewBaseAdapter(arr_bean, getActivity()) {
            @Override
            public long getItemId(int i) {
                return 0;
            }
        };
        lv2.setAdapter(adapter);

        lv2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i){
                    case 0:
                        Intent intent = new Intent(getActivity(), MoiBBActivity.class);
                        startActivity(intent);
                        return;
                }
            }
        });

        lv3 = (ListView) v.findViewById(R.id.list_3);
        arr_bean = new ArrayList<ListViewBean>();
        arr_bean.add(new ListViewBean(R.drawable.icon_cs_qd,"Chính sách quy định"));
        arr_bean.add(new ListViewBean(R.drawable.icon_settings,"Cài đặt ứng dụng"));
        arr_bean.add(new ListViewBean(R.drawable.icon_logout,"Đăng xuất"));
        adapter = new ListViewBaseAdapter(arr_bean, getActivity()) {
            @Override
            public long getItemId(int i) {
                return 0;
            }
        };
        lv3.setAdapter(adapter);

        lv3.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i){
                    case 1:
                        Intent intent1 = new Intent(getActivity(), SettingActivity.class);
                        startActivity(intent1);
                        return;
                    case 2:
                        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getActivity());
                        alertDialogBuilder.setTitle("Đăng xuất");
                        alertDialogBuilder.setMessage("Bạn có muốn đăng xuất khỏi Foody?");
                        // set dialog message
                        alertDialogBuilder
                                .setCancelable(false)
                                .setPositiveButton("ĐĂNG XUẤT",
                                        new DialogInterface.OnClickListener() {
                                            public void onClick(DialogInterface dialog,int id) {
                                                Intent intent2 = new Intent(getActivity(), LoginActivity.class);
                                                startActivity(intent2);
                                            }
                                        })
                                .setNegativeButton("HỦY",
                                        new DialogInterface.OnClickListener() {
                                            public void onClick(DialogInterface dialog,int id) {
                                                dialog.cancel();
                                            }
                                        });
                        // create alert dialog
                        AlertDialog alertDialog = alertDialogBuilder.create();

                        // show it
                        alertDialog.show();
                        return;
                }
            }
        });
        return v;
    }
}
