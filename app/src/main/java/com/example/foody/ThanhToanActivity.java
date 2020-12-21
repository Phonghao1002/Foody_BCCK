package com.example.foody;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ThanhToanActivity extends AppCompatActivity {

    ListView lv;
    ListViewBaseAdapter_1 adapter_1;
    ArrayList<ListViewBean_1> arr_bean;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thanh_toan);

        ImageButton bt_back = (ImageButton) findViewById(R.id.btn_back);
        bt_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                open(view);
            }
        });

        lv = (ListView) findViewById(R.id.list_tt);
        arr_bean = new ArrayList<ListViewBean_1>();
        arr_bean.add(new ListViewBean_1(R.drawable.icon_airpay,"Ví AirPay", null));
        arr_bean.add(new ListViewBean_1(R.drawable.icon_money,"Tiền mặt", "Mặc định"));
        arr_bean.add(new ListViewBean_1(R.drawable.icon_bank,"Thẻ Tín dụng/ Ghi nợ", null));
        arr_bean.add(new ListViewBean_1(R.drawable.icon_credit,"Now Credits", null));
        arr_bean.add(new ListViewBean_1(R.drawable.icon_atm,"ATM/ Internet Banking", null));

        adapter_1 = new ListViewBaseAdapter_1(arr_bean, this) {
            @Override
            public long getItemId(int i) {
                return 0;
            }
        };
        lv.setAdapter(adapter_1);

    }
    void open(View v){
        Intent Intent = new Intent(this, MainActivity.class);
        startActivity(Intent);
    }
}
