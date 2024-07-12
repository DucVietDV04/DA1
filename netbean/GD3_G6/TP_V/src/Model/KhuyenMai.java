/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.Date;

/**
 *
 * @author admin
 */
public class KhuyenMai {

    private String MaKM;
    private String TenKM;
    private String DieuKien;
    private String NgayBatDau;
    private String NgayKetThuc;
    private String MucKhuyenMai;
    private String MoTa;

    public KhuyenMai() {
    }

    public KhuyenMai(String MaKM, String TenKM, String DieuKien, String NgayBatDau, String NgayKetThuc, String MucKhuyenMai, String MoTa) {
        this.MaKM = MaKM;
        this.TenKM = TenKM;
        this.DieuKien = DieuKien;
        this.NgayBatDau = NgayBatDau;
        this.NgayKetThuc = NgayKetThuc;
        this.MucKhuyenMai = MucKhuyenMai;
        this.MoTa = MoTa;
    }

    public String getMaKM() {
        return MaKM;
    }

    public void setMaKM(String MaKM) {
        this.MaKM = MaKM;
    }

    public String getTenKM() {
        return TenKM;
    }

    public void setTenKM(String TenKM) {
        this.TenKM = TenKM;
    }

    public String getDieuKien() {
        return DieuKien;
    }

    public void setDieuKien(String DieuKien) {
        this.DieuKien = DieuKien;
    }

    public String getNgayBatDau() {
        return NgayBatDau;
    }

    public void setNgayBatDau(String NgayBatDau) {
        this.NgayBatDau = NgayBatDau;
    }

    public String getNgayKetThuc() {
        return NgayKetThuc;
    }

    public void setNgayKetThuc(String NgayKetThuc) {
        this.NgayKetThuc = NgayKetThuc;
    }

    public String getMucKhuyenMai() {
        return MucKhuyenMai;
    }

    public void setMucKhuyenMai(String MucKhuyenMai) {
        this.MucKhuyenMai = MucKhuyenMai;
    }

    public String getMoTa() {
        return MoTa;
    }

    public void setMoTa(String MoTa) {
        this.MoTa = MoTa;
    }

    @Override
    public String toString() {
        return "KhuyenMai{" + "MaKM=" + MaKM + ", TenKM=" + TenKM + ", DieuKien=" + DieuKien + ", NgayBatDau=" + NgayBatDau + ", NgayKetThuc=" + NgayKetThuc + ", MucKhuyenMai=" + MucKhuyenMai + ", MoTa=" + MoTa + '}';
    }

    
    
   
   
    public Object[]toDataRow(){
        return new Object[]{
            this.MaKM,this.TenKM,this.DieuKien,this.NgayBatDau,this.NgayKetThuc,this.MucKhuyenMai,this.MoTa};   
    }
}
