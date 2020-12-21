package DataBase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class LuuTru extends SQLiteOpenHelper {
    public LuuTru(@Nullable Context context) {
        super(context, "LuuTru", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql1 = "CREATE TABLE dsCuahang(id INTEGER PRIMARY KEY AUTOINCREMENT, anh text, ten text, mota text, diachi text, mucgia text)";
        sqLiteDatabase.execSQL(sql1);
        sql1 = "INSERT INTO dsCuahang(anh, ten, mota, diachi, mucgia) VALUES('ch1','Chasu - Sinh Tố Sửa Chua Nếp Cẩm','Sữa chua uống siêu ngon','188 Nguyễn Thái Sơn, P.4, Quận Gò Vấp','22.000 đồng - 35.000 đồng')";
        sqLiteDatabase.execSQL(sql1);


        String sql2 = "CREATE TABLE dsSanpham(id INTEGER PRIMARY KEY AUTOINCREMENT, anh text, ten text, cuahang text, gia text, diem text)";
        sqLiteDatabase.execSQL(sql2);
        sql2 = "INSERT INTO dsSanPham(anh, ten, cuahang, gia, diem) VALUES('sp1_1','Sinh Tố Sữa Chua Thơm Chanh Leo', '1', '24.000đ', '500')," +
                "('sp1_2','Sữa Chua nếp cẩm truyền thống', '1', '24.000đ', '100')," +
                "('sp1_3','Sinh tố Sữa chua dâu', '1', '24.000đ', '100')," +
                "('sp1_4','Sinh tố Sữa chua nếp cẩm', '1', '24.000đ', '100')," +
                "('sp1_5','Sinh tố Sữa chua Kiwi', '1', '28.000đ', '100')," +
                "('sp1_6','Sinh tố Sữa chua dưa lưới', '1', '28.000đ', '100')," +
                "('sp1_7','Sinh tố Sữa chua dâu Mix nếp cẩm', '1', '29.600đ', '100')";
        sqLiteDatabase.execSQL(sql2);

    }
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
    public Boolean insertDataluu(int id,String anh,String ten ,String mota , String diachi ,String mucgia  ){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues= new ContentValues();
        contentValues.put("id", id);
        contentValues.put("anh", anh);
        contentValues.put("ten", "N"+ten);
        contentValues.put("mota", "N"+mota);
        contentValues.put("diachi", "N"+diachi);
        contentValues.put("mucgia", "N"+mucgia);



        long result = MyDB.insert("dsCuahang", null, contentValues);
        if(result==-1)
            return false;
        else
            return true;

    }
    public Boolean checkusername(String id) {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from dsCuahang where id = ?", new String[]{id});
        if (cursor.getCount() > 0)
            return true;
        else
            return false;
    }
}
