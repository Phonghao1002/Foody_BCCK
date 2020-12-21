package DataBase;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class CuaHang extends SQLiteOpenHelper {
    public CuaHang(@Nullable Context context) {
        super(context, "CuaHang", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql1 = "CREATE TABLE dsCuahang(id INTEGER PRIMARY KEY AUTOINCREMENT, anh text, ten text, mota text, diachi text, mucgia text)";
        sqLiteDatabase.execSQL(sql1);
        sql1 = "INSERT INTO dsCuahang(anh, ten, mota, diachi, mucgia) VALUES('ch1','Chasu - Sinh Tố Sửa Chua Nếp Cẩm','Sữa chua uống siêu ngon','188 Nguyễn Thái Sơn, P.4, Quận Gò Vấp','22.000 đồng - 35.000 đồng')";
        sqLiteDatabase.execSQL(sql1);
        sql1 = "INSERT INTO dsCuahang(anh, ten, mota, diachi, mucgia) VALUES('ch2','Nhà Hàng Parsley - Steak, Pasta!','Sẽ quay lại ủng hộ','130 Nguyễn Trãi, P.Bến Thành, Quận 1, TP.HCM','55.000 đồng - 249.000 đồng')";
        sqLiteDatabase.execSQL(sql1);
        sql1 = "INSERT INTO dsCuahang(anh, ten, mota, diachi, mucgia) VALUES('ch3','Bánh 9 Sạch - Bánh Sầu Riêng','Crepe ngàn lớp này đã có mặt ở Q2 bánh rất thơm và dể ăn','73 An Dương Vương, P.8, Quận 5, TP.HCM','30.000 đồng - 130.000 đồng')";
        sqLiteDatabase.execSQL(sql1);
        sql1 = "INSERT INTO dsCuahang(anh, ten, mota, diachi, mucgia) VALUES('ch4','Chic Chic - Gà Rán Hàn Quốc','Món ăn vĩa hè ngon chất lượng - độc, lạ','12 Xóm Chiếu, P.13, Quận 4, TP.HCM','23.000 đồng - 107.000 đồng')";
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
        sql2 = "INSERT INTO dsSanpham(anh, ten, cuahang, gia, diem) VALUES('sp2_1', 'Steak thăn ngoại bò Úc','2', '163.900đ','10')," +
                "('sp2_2','Mì Ý sốt bò bằm','2', '108.000đ','10')," +
                "('sp2_3','Súp kem bí đỏ','2', '60.000đ','10')," +
                "('sp2_4','Steak thăn lưng bò Úc','2', '203.000đ','10')," +
                "('sp2_5', 'Steak thăn nội bò Úc','2', '263.000đ','10')," +
                "('sp2_6', 'Salad giấm nho Ý','2', '65.000đ','10')," +
                "('sp2_7', 'Nachos phủ bò bằm phô mai','2', '94.000đ','10')";
        sqLiteDatabase.execSQL(sql2);
        sql2 = "INSERT INTO dsSanpham(anh, ten, cuahang, gia, diem) VALUES('sp3_1','Bánh crepe ngập sầu 6 cái','3','80.000đ','10')," +
                "('sp3_2','Bánh sầu riêng ngàn lớp','3','135.000đ','10')," +
                "('sp3_3','Combo Bánh sầu riêng + bánh crepe','3','155.000đ','10')," +
                "('sp3_4','Bánh crepe ngập sầu 4 cái','3','55.000đ','10')," +
                "('sp3_5','Bánh sầu riêng ngàn lớp size 16','3','170.000đ','10')," +
                "('sp3_6','Bánh crepe ngập sầu 8 cái','3','105.000đ','10')," +
                "('sp3_7','Bánh crepe ngập sầu 2 cái','3','30.000đ','10')";
        sqLiteDatabase.execSQL(sql2);
        sql2 = "INSERT INTO dsSanpham(anh, ten, cuahang, gia, diem) VALUES('sp4_1','Combo Gà BBQ + Com Rong Biển','4','31.000đ','8')," +
                "('sp4_2','Combo Gà BBQ 1/2 con','4','108.000đ','6')," +
                "('sp4_3','Combo Gà Truyền thống + Com Rong Biển','4','31.000đ','5')," +
                "('sp4_4','Trà cam đào','4','17.000đ','5')," +
                "('sp4_5','Combo Gà phô Mai + Com Rong Biển','4','31.000đ','2')," +
                "('sp4_6','Combo Gà phô Mai 1/2 con','4','107.000đ','2')," +
                "('sp4_7','Combo Gà BBQ + Com Rong Biển + nước','4','44.000đ','2')";
        sqLiteDatabase.execSQL(sql2);
    }
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
