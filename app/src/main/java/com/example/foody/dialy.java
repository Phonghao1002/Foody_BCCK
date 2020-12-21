package com.example.foody;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageView;

import java.util.ArrayList;

import Noti.Adapter.AdapterTinh;
import Noti.Tinh;

public class dialy extends AppCompatActivity {
    GridView gridView;
    ArrayList<Tinh> mangTinh;
    AdapterTinh adapter;
    ImageView imageViewback;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialy);
        imageViewback=(ImageView) findViewById(R.id.imagebackdl);
        imageViewback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        Anhxa();

    }
    private void Anhxa() {
        gridView=(GridView) findViewById(R.id.grdl);
        mangTinh =new ArrayList<>();
        mangTinh.add(new Tinh("Hà Tĩnh"));
        mangTinh.add(new Tinh("Quảng Bình"));
        mangTinh.add(new Tinh("Quảng Trị"));
        mangTinh.add(new Tinh("Huế"));
        mangTinh.add(new Tinh("Đà Nẵng"));
        mangTinh.add(new Tinh("Hà Nội"));
        mangTinh.add(new Tinh("Hà Tĩnh"));
        mangTinh.add(new Tinh("Quảng Bình"));
        mangTinh.add(new Tinh("Quảng Trị"));
        mangTinh.add(new Tinh("Huế"));
        mangTinh.add(new Tinh("Đà Nẵng"));
        mangTinh.add(new Tinh("Hà Nội"));
        mangTinh.add(new Tinh("Hà Tĩnh"));
        mangTinh.add(new Tinh("Quảng Bình"));
        mangTinh.add(new Tinh("Quảng Trị"));
        mangTinh.add(new Tinh("Huế"));
        mangTinh.add(new Tinh("Đà Nẵng"));
        mangTinh.add(new Tinh("Hà Nội"));
        adapter= new AdapterTinh(this,R.layout.row_tinh, mangTinh);
        gridView.setAdapter(adapter);
    }
}