package Adapter;

import android.content.Context;

public class SanPhamFood {
    int id;
    String anh, ten, cuahang, gia, diem;

    public SanPhamFood(int id, String anh, String ten, String cuahang, String gia, String diem) {
        this.id = id;
        this.anh = anh;
        this.ten = ten;
        this.cuahang = cuahang;
        this.gia = gia;
        this.diem = diem;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAnh() {
        return anh;
    }

    public void setAnh(String anh) {
        this.anh = anh;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getCuahang() {
        return cuahang;
    }

    public void setCuahang(String cuahang) {
        this.cuahang = cuahang;
    }

    public String getGia() {
        return gia;
    }

    public void setGia(String gia) {
        this.gia = gia;
    }

    public String getDiem() {
        return diem;
    }

    public void setDiem(String diem) {
        this.diem = diem;
    }
}
