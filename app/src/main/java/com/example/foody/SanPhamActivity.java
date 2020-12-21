package com.example.foody;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

import Adapter.CuaHangFood;
import Adapter.SanPhamFood;
import Adapter.SanPhamFoodAdapter;
import DataBase.CuaHang;

public class SanPhamActivity extends AppCompatActivity {
    ImageView img, back;
    TextView proName, proName1, proDC;
    CuaHang cuaHang;
    int id;
    ListView listView;
    SanPhamFoodAdapter adapter;
    ArrayList<SanPhamFood> arrayList;
    TruyVan truyVan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sanpham_dathang);

        Intent i = getIntent();
        id = i.getIntExtra("id", 0);

        cuaHang = new CuaHang(this);

        proName1 = findViewById(R.id.title_1);
        proName = findViewById(R.id.title_2);
        img = findViewById(R.id.img_detail);
        proDC = findViewById(R.id.dh_diachi);

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
                proName1.setText(title);
                int resId = getResources().getIdentifier(image, "drawable", getPackageName());
                img.setImageResource(resId);
                proDC.setText(diachi);
            }while (cs.moveToNext());
        }
        db.close();

        truyVan = new TruyVan(this);
        arrayList = truyVan.getAll();

        listView = findViewById(R.id.list_sanpham);
        adapter = new SanPhamFoodAdapter(SanPhamActivity.this, arrayList);
        listView.setAdapter(adapter);

        back = findViewById(R.id.image_back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }
    public class TruyVan{
        CuaHang cuaHang;
        public TruyVan(Context context){
            cuaHang = new CuaHang(context);
        }
        public ArrayList<SanPhamFood> getAll(){
            ArrayList<SanPhamFood> ds = new ArrayList<>();
            SQLiteDatabase db = cuaHang.getReadableDatabase();
            Cursor cs = db.rawQuery("SELECT * FROM dsSanpham WHERE cuahang = '" + id + "'", null);
            cs.moveToFirst();
            while (!cs.isAfterLast()){
                int id = cs.getInt(0);
                String image = cs.getString(1);
                String title = cs.getString(2);
                String cuahang = cs.getString(3);
                String gia = cs.getString(4);
                String diem = cs.getString(5);
                SanPhamFood a = new SanPhamFood(id, image, title, cuahang, gia, diem);
                ds.add(a);
                cs.moveToNext();
            }
            cs.close();
            return ds;
        }
    }
}
