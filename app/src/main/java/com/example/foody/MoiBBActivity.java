package com.example.foody;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

import Fragment.ProfileFragment;

public class MoiBBActivity extends AppCompatActivity {

    ListView lv;
    ListViewBaseAdapter adapter;
    ArrayList<ListViewBean> arr_bean;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_friends);

        //ImageButton bt_back = (ImageButton) findViewById(R.id.btn_back);
        //bt_back.setOnClickListener(new View.OnClickListener() {
        //    @Override
        //        public void onClick(View view) {
        //        open(view);
        //    }
        //});

        lv = (ListView) findViewById(R.id.list_addfriends);
        arr_bean = new ArrayList<ListViewBean>();
        arr_bean.add(new ListViewBean(R.drawable.icon_email_2,"Chia sẻ qua Email"));
        arr_bean.add(new ListViewBean(R.drawable.icon_facebook,"Chia sẻ qua Facebook"));
        arr_bean.add(new ListViewBean(R.drawable.icon_messenger,"Chia sẻ qua Messenger"));
        arr_bean.add(new ListViewBean(R.drawable.icon_call,"Chia sẻ qua Viber"));
        arr_bean.add(new ListViewBean(R.drawable.icon_link,"Sao chép đường dẩn tải app"));
        adapter = new ListViewBaseAdapter(arr_bean, this) {
            @Override
            public long getItemId(int i) {
                return 0;
            }
        };
        lv.setAdapter(adapter);
    }
    //void open(View v){
    //    Intent Intent = new Intent(this, ProfileFragment.class);
    //    startActivity(Intent);
    //}
}
