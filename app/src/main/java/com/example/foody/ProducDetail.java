package com.example.foody;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

import Adapter.CuaHangFood;
import DataBase.CuaHang;
import DataBase.LuuTru;
import Fragment.BookmarkFragment;
import dangnhap_dangki.DangkiActivity;
import dangnhap_dangki.LoginActivity;

public class ProducDetail extends AppCompatActivity {
    ImageView img, back;
    TextView proName, proName1, proDC, proMGia;
    LinearLayout prodathang;
    CuaHang cuaHang;
    int id;
    Button button;
    LuuTru luuTru;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);


        prodathang = findViewById(R.id.dathang_detail);
        prodathang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplication(), SanPhamActivity.class);
                intent.putExtra("id", id);
                startActivity(intent);
            }
        });

        Intent i = getIntent();
        id = i.getIntExtra("id", 0);

        cuaHang = new CuaHang(this);
        luuTru= new LuuTru(this);

        proName1 = findViewById(R.id.title_1);
        proName = findViewById(R.id.title_2);
        img = findViewById(R.id.img_detail);
        proDC = findViewById(R.id.dc_detail);
        proMGia = findViewById(R.id.mucgia_detail);

        String selectQuery = "SELECT * FROM dsCuahang WHERE id = '" + id + "'";
        SQLiteDatabase db = cuaHang.getWritableDatabase();
        Cursor cs = db.rawQuery(selectQuery,null);
        if (cs.moveToFirst()){
            do {
                int id = cs.getInt(0);
                String image = cs.getString(1);
                String title = cs.getString(2);
                String des = cs.getString(3);
                String diachi = cs.getString(4);
                String mucgia = cs.getString(5);

                proName.setText(title);
                proName1.setText(des);
                int resId = getResources().getIdentifier(image, "drawable", getPackageName());
                img.setImageResource(resId);
                proDC.setText(diachi);
                proMGia.setText(mucgia);
            }while (cs.moveToNext());
        }
        db.close();

        back = findViewById(R.id.image_back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        button=findViewById(R.id.btn_luu);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String selectQuery = "SELECT * FROM dsCuahang WHERE id = '" + id + "'";
                SQLiteDatabase db = cuaHang.getWritableDatabase();
                Cursor cs = db.rawQuery(selectQuery, null);
                if (cs.moveToFirst()) {
                    do {
                        int id       = cs.getInt(0);
                        String anh   = cs.getString(1);
                        String ten   = cs.getString(2);
                        String mota  = cs.getString(3);
                        String diachi= cs.getString(4);
                        String mucgia= cs.getString(5);
                        String s=String.valueOf(id);
                        Boolean checkuser = luuTru.checkusername(s);
                        if(checkuser==false){
                            Boolean insert = luuTru.insertDataluu(id, anh, ten, mota, diachi, mucgia);
                            if (insert == true) {
                                Toast.makeText(ProducDetail.this, "Lưu thành công", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                                startActivity(intent);
                            }
                        }else {
                            Toast.makeText(ProducDetail.this, "Đã lưu", Toast.LENGTH_SHORT).show();
                        }

                     } while (cs.moveToNext()) ;
                 }
                db.close();


            }

        });
    }

}
