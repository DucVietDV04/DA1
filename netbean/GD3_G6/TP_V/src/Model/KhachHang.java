/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author PC
 */
public class KhachHang {
    private String MAKH,HoTen;
    private boolean GioiTinh;
    private String SoDienThoai,Email;
    private boolean LoaiKH;
    private Float TongChiTieu;

    public KhachHang() {
    }

    public KhachHang(String MAKH, String HoTen, boolean GioiTinh, String SoDienThoai, String Email, boolean LoaiKH, Float TongChiTieu) {
        this.MAKH = MAKH;
        this.HoTen = HoTen;
        this.GioiTinh = GioiTinh;
        this.SoDienThoai = SoDienThoai;
        this.Email = Email;
        this.LoaiKH = LoaiKH;
        this.TongChiTieu = TongChiTieu;
    }

    public String getMAKH() {
        return MAKH;
    }

    public void setMAKH(String MAKH) {
        this.MAKH = MAKH;
    }

    public String getHoTen() {
        return HoTen;
    }

    public void setHoTen(String HoTen) {
        this.HoTen = HoTen;
    }

    public boolean isGioiTinh() {
        return GioiTinh;
    }

    public void setGioiTinh(boolean GioiTinh) {
        this.GioiTinh = GioiTinh;
    }

    public String getSoDienThoai() {
        return SoDienThoai;
    }

    public void setSoDienThoai(String SoDienThoai) {
        this.SoDienThoai = SoDienThoai;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public boolean isLoaiKH() {
        return LoaiKH;
    }

    public void setLoaiKH(boolean LoaiKH) {
        this.LoaiKH = LoaiKH;
    }

    public Float getTongChiTieu() {
        return TongChiTieu;
    }

    public void setTongChiTieu(Float TongChiTieu) {
        this.TongChiTieu = TongChiTieu;
    }

    

    @Override
    public String toString() {
        return "KhachHang{" + "MAKH=" + MAKH + ", HoTen=" + HoTen + ", GioiTinh=" + GioiTinh + ", SoDienThoai=" + SoDienThoai + ", Email=" + Email + ", LoaiKH=" + LoaiKH + ", TongChiTieu=" + TongChiTieu + '}';
    }

    
    public Object[] toDataRow(){
        return new Object[]{this.MAKH,this.HoTen,this.GioiTinh?"Nữ":"Nam",this.SoDienThoai,this.Email,this.LoaiKH?"VIP":"Thường",this.TongChiTieu};
    }

}
