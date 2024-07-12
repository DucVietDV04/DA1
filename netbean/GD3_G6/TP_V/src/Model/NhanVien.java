/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author puddi
 */
public class NhanVien {

    private String MaNV;
    private String TenNV;
    private String sdt;
    private String Email;
    private String gioiTinh;
    private String chucVu;
    private String luongCB;
    private String diaChi;
    private String trangThai;
    private String tkNV;

    public NhanVien() {
    }

    public NhanVien(String MaNV, String TenNV, String sdt, String Email, String gioiTinh, String chucVu, String luongCB, String diaChi, String trangThai, String tkNV) {
        this.MaNV = MaNV;
        this.TenNV = TenNV;
        this.sdt = sdt;
        this.Email = Email;
        this.gioiTinh = gioiTinh;
        this.chucVu = chucVu;
        this.luongCB = luongCB;
        this.diaChi = diaChi;
        this.trangThai = trangThai;
        this.tkNV = tkNV;
    }

    public String getMaNV() {
        return MaNV;
    }

    public void setMaNV(String MaNV) {
        this.MaNV = MaNV;
    }

    public String getTenNV() {
        return TenNV;
    }

    public void setTenNV(String TenNV) {
        this.TenNV = TenNV;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getChucVu() {
        return chucVu;
    }

    public void setChucVu(String chucVu) {
        this.chucVu = chucVu;
    }

    public String getLuongCB() {
        return luongCB;
    }
    
    
    public String getLuongCB2() {
        return luongCB.substring(0, luongCB.length() - 5);
    }

    public void setLuongCB(String luongCB) {
        this.luongCB = luongCB;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public String getTkNV() {
        return tkNV;
    }

    public void setTkNV(String tkNV) {
        this.tkNV = tkNV;
    }

    public Object[] todataRow() {
        return new Object[]{
            this.MaNV, this.TenNV, this.sdt, this.Email, this.gioiTinh, this.chucVu, this.getLuongCB2(), this.diaChi, this.trangThai, this.tkNV
        };
    }

}
