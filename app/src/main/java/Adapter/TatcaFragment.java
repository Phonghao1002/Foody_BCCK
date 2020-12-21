package Adapter;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.example.foody.R;

import java.util.ArrayList;

import DataBase.CuaHang;
import DataBase.LuuTru;


public class TatcaFragment extends Fragment {

    GridView list;
    CuaHangFoodAdapterLuu adapter;
    ArrayList<CuaHangFood> arrayList;
    TruyVan truyVan;
    @NonNull
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_tatca,container,false);

        truyVan = new TruyVan(getActivity());
        arrayList = truyVan.getAll();

        list = (GridView) v.findViewById(R.id.grid_luu);
        adapter = new CuaHangFoodAdapterLuu(getActivity(), arrayList);
        list.setAdapter(adapter);
        return v;
    }
    public class TruyVan{

        LuuTru luuTru;
        public TruyVan(Context context){
            luuTru = new LuuTru(context);
        }
        public ArrayList<CuaHangFood> getAll(){
            ArrayList<CuaHangFood> ds = new ArrayList<>();
            SQLiteDatabase db = luuTru.getReadableDatabase();
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