package com.example.foody;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;

import Adapter.CuaHangFood;
import Adapter.CuaHangFoodAdapter;
import DataBase.CuaHang;


public class F1 extends Fragment {

    GridView list;
    CuaHangFoodAdapter adapter;
    ArrayList<CuaHangFood> arrayList;
    TruyVan truyVan;
    @NonNull
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_blank1,container,false);

        truyVan = new TruyVan(getActivity());
        arrayList = truyVan.getAll();

        list = (GridView) v.findViewById(R.id.grid1);
        adapter = new CuaHangFoodAdapter(getActivity(), arrayList);
        list.setAdapter(adapter);
        return v;
    }
    public class TruyVan{
        CuaHang cuaHang;
        public TruyVan(Context context){
            cuaHang = new CuaHang(context);
        }
        public ArrayList<CuaHangFood> getAll(){
            ArrayList<CuaHangFood> ds = new ArrayList<>();
            SQLiteDatabase db = cuaHang.getReadableDatabase();
            Cursor cs = db.rawQuery("SELECT * FROM dsCuahang", null);
            cs.moveToFirst();
            while (!cs.isAfterLast()){
                int id = cs.getInt(0);
                String image = cs.getString(1);
                String title = cs.getString(2);
                String description = cs.getString(3);
                String diachi = cs.getString(4);
                String mucgia = cs.getString(5);
                CuaHangFood a = new CuaHangFood(id, image, title, description, diachi, mucgia);
                ds.add(a);
                cs.moveToNext();
            }
            cs.close();
            return ds;
        }
    }
}
