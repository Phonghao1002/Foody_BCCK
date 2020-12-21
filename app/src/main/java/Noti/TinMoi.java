package Noti;

public class TinMoi  {
    private String tieuDe;
    private String noiDung;
    private  int image;
    public TinMoi(String tieuDe, String noiDung, int image) {
        this.tieuDe = tieuDe;
        this.noiDung = noiDung;
        this.image = image;
    }

    public String getTieuDe() {
        return tieuDe;
    }

    public void setTieuDe(String tieuDe) {
        this.tieuDe = tieuDe;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }



}
