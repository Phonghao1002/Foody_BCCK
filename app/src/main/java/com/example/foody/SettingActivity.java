package com.example.foody;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

import Fragment.ProfileFragment;

public class SettingActivity extends AppCompatActivity {

    ListView lv1, lv2, lv3, lv4;
    ListViewBaseAdapter adapter;
    ArrayList<ListViewBean> arr_bean;

    ListViewBaseAdapter_1 adapter_1;
    ArrayList<ListViewBean_1> arr_bean_1;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        ImageButton bt_back = (ImageButton) findViewById(R.id.btn_back);
        bt_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                open(view);
            }
        });

        lv1 = (ListView) findViewById(R.id.list_setting_1);
        arr_bean = new ArrayList<ListViewBean>();
        arr_bean.add(new ListViewBean(R.drawable.avta_male,"Ảnh đại diện & bìa"));
        arr_bean.add(new ListViewBean(R.drawable.icon_pass,"Mật khẩu"));
        arr_bean.add(new ListViewBean(R.drawable.icon_user,"Thông tin & liên hệ"));
        adapter = new ListViewBaseAdapter(arr_bean, this) {
            @Override
            public long getItemId(int i) {
                return 0;
            }
        };
        lv1.setAdapter(adapter);

        lv2 = (ListView) findViewById(R.id.list_setting_4);
        arr_bean = new ArrayList<ListViewBean>();
        arr_bean.add(new ListViewBean(R.drawable.icon_information,"Về Foody"));
        arr_bean.add(new ListViewBean(R.drawable.icon_star,"Đánh giá app Foody"));
        arr_bean.add(new ListViewBean(R.drawable.icon_facebook,"Theo dõi chúng tôi trên Facebook"));
        arr_bean.add(new ListViewBean(R.drawable.icon_instagram,"Theo dõi chúng tôi trên Instagram"));
        arr_bean.add(new ListViewBean(R.drawable.icon_website,"Website"));
        arr_bean.add(new ListViewBean(R.drawable.icon_interlock,"Ứng dụng liên quan"));
        arr_bean.add(new ListViewBean(R.drawable.icon_send_mail,"Liên hệ"));
        adapter = new ListViewBaseAdapter(arr_bean, this) {
            @Override
            public long getItemId(int i) {
                return 0;
            }
        };
        lv2.setAdapter(adapter);

        lv3 = (ListView) findViewById(R.id.list_setting_2);
        arr_bean_1 = new ArrayList<ListViewBean_1>();
        arr_bean_1.add(new ListViewBean_1(R.drawable.icon_bill, "Hoãn xác nhận đơn hàng", "0 giây"));
        adapter_1 = new ListViewBaseAdapter_1(arr_bean_1, this) {
            @Override
            public long getItemId(int i) {
                return 0;
            }
        };
        lv3.setAdapter(adapter_1);

        lv4 = (ListView) findViewById(R.id.list_setting_3);
        arr_bean_1 = new ArrayList<ListViewBean_1>();
        arr_bean_1.add(new ListViewBean_1(R.drawable.icon_map, "Chọn Tỉnh/Thành phố", "Đà Nẵng"));
        arr_bean_1.add(new ListViewBean_1(R.drawable.icon_danhmuc, "Đổi danh mục", "Ăn uống"));
        arr_bean_1.add(new ListViewBean_1(R.drawable.icon_language, "Đổi ngôn ngữ", "Vietnamese-Tiếng Việt"));
        arr_bean_1.add(new ListViewBean_1(R.drawable.icon_bell, "Cài đặt thông báo", null));
        arr_bean_1.add(new ListViewBean_1(R.drawable.icon_wifi, "Tiết kiệm dử liệu di động", null));
        adapter_1 = new ListViewBaseAdapter_1(arr_bean_1, this) {
            @Override
            public long getItemId(int i) {
                return 0;
            }
        };
        lv4.setAdapter(adapter_1);
    }
    void open(View v){
        Intent Intent = new Intent(this, MainActivity.class);
        startActivity(Intent);
    }
}
