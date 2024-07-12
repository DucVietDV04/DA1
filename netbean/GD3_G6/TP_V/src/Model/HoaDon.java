/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.Date;

/**
 *
 * @author puddi
 */
public class HoaDon {
    private String maHD;
    private String maHDCT;
    private String maKH;
    private String tenKH;
    private String maSP;
    private String tenSP;
    private String donGia;
    private String soLuong;
    private String ghiChu;
    private Date ngayTao;
    private String tongTien;

    public HoaDon() {
    }

    public HoaDon(String maHD, String maHDCT, String maKH, String tenKH, String maSP, String tenSP, String donGia, String soLuong, String ghiChu, Date ngayTao, String tongTien) {
        this.maHD = maHD;
        this.maHDCT = maHDCT;
        this.maKH = maKH;
        this.tenKH = tenKH;
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.donGia = donGia;
        this.soLuong = soLuong;
        this.ghiChu = ghiChu;
        this.ngayTao = ngayTao;
        this.tongTien = tongTien;
    }

    public String getMaHD() {
        return maHD;
    }

    public void setMaHD(String maHD) {
        this.maHD = maHD;
    }

    public String getMaHDCT() {
        return maHDCT;
    }

    public void setMaHDCT(String maHDCT) {
        this.maHDCT = maHDCT;
    }

    public String getMaKH() {
        return maKH;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    public String getTenKH() {
        return tenKH;
    }

    public void setTenKH(String tenKH) {
        this.tenKH = tenKH;
    }

    public String getMaSP() {
        return maSP;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public String getDonGia() {
        return donGia;
    }

    public void setDonGia(String donGia) {
        this.donGia = donGia;
    }

    public String getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(String soLuong) {
        this.soLuong = soLuong;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public Date getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }

 

    public String getTongTien() {
        return tongTien;
    }

    public void setTongTien(String tongTien) {
        this.tongTien = tongTien;
    }


    
    public Object[] toDataRowHD(){
        return new Object[]{
            this.maHD,this.ngayTao,this.tongTien
        };
    }
    public Object[] toDataRowHDCT(){
        return new Object[]{
            this.maHDCT,this.maHD,this.tenKH,this.maSP,this.tenSP,this.donGia,this.soLuong,this.ghiChu
        };
    }

    @Override
    public String toString() {
        return "HoaDon{" + "maHD=" + maHD + ", maHDCT=" + maHDCT + ", maKH=" + maKH + ", tenKH=" + tenKH + ", maSP=" + maSP + ", tenSP=" + tenSP + ", donGia=" + donGia + ", soLuong=" + soLuong + ", ghiChu=" + ghiChu + ", ngayTao=" + ngayTao + ", tongTien=" + tongTien + '}';
    }


    
}
