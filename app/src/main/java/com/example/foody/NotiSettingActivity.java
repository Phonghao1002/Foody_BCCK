package com.example.foody;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import Fragment.NotiFragment;

public class NotiSettingActivity extends AppCompatActivity {
    Context context;
    TextView textViewtb;
    TextView textViewdd,textViewdl;
    ImageView imageViewback;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_noti_setting);
        textViewtb=(TextView) findViewById(R.id.xahoi);
        textViewdd=(TextView) findViewById(R.id.diadiem);
        textViewdl=(TextView) findViewById(R.id.dialy);
        imageViewback=(ImageView) findViewById(R.id.imageback);
        imageViewback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               onBackPressed();
            }
        });

        textViewtb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openxh();
            }
        });
        textViewdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                opendd();
            }
        });
        textViewdl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                opendl();
            }
        });

    }
    public void openxh(){
        Intent intent=new Intent(this,xahoi.class);
        startActivity(intent);
    }
    public void opendd(){
        Intent intent=new Intent(this,diadiem.class);
        startActivity(intent);
    }
    public void opendl(){
        Intent intent=new Intent(this,dialy.class);
        startActivity(intent);
    }
}