package com.example.foody;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class TienThuongActivity extends AppCompatActivity {

    ListView lv1, lv2;
    com.example.foody.ListViewBaseAdapter adapter;
    ArrayList<ListViewBean> arr_bean;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tien_thuong);

        ImageButton bt_back = (ImageButton) findViewById(R.id.btn_back);
        bt_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                open(view);
            }
        });

        lv1 = (ListView) findViewById(R.id.list_tt_1);
        arr_bean = new ArrayList<ListViewBean>();
        arr_bean.add(new ListViewBean(R.drawable.icon_history,"Lịch sử giao dịch"));
        arr_bean.add(new ListViewBean(R.drawable.icon_doidiem,"Quy đổi điểm thưởng"));
        adapter = new ListViewBaseAdapter(arr_bean, this) {
            @Override
            public long getItemId(int i) {
                return 0;
            }
        };
        lv1.setAdapter(adapter);

        lv2 = (ListView) findViewById(R.id.list_tt_2);
        arr_bean = new ArrayList<ListViewBean>();
        arr_bean.add(new ListViewBean(R.drawable.icon_csdt,"Chính sách thưởng"));
        arr_bean.add(new ListViewBean(R.drawable.icon_loi,"Báo lỗi"));
        adapter = new ListViewBaseAdapter(arr_bean, this) {
            @Override
            public long getItemId(int i) {
                return 0;
            }
        };
        lv2.setAdapter(adapter);
    }
    void open(View v){
        Intent Intent = new Intent(this,MainActivity.class);
        startActivityForResult(Intent, RESULT_OK);
    }
}
