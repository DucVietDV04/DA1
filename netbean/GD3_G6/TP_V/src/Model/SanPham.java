/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

public class SanPham {
    private String maSP;
    private String tenSP;
    private String maDM;
    private String maNSX;
    private String donGia;
    private String trangThai;
    
    private String maSPCT;
    private String chatLieu;
    private String kichThuoc;
    private String mauSac;
    private String soLuong;
    private String nhaSX;
    private String xuatXu;
    private String moTa;
    public SanPham() {
    }

    public SanPham(String maSP, String tenSP, String maDM, String maNSX, String donGia, String trangThai, String maSPCT, String chatLieu, String kichThuoc, String mauSac, String soLuong, String nhaSX, String xuatXu, String moTa) {
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.maDM = maDM;
        this.maNSX = maNSX;
        this.donGia = donGia;
        this.trangThai = trangThai;
        this.maSPCT = maSPCT;
        this.chatLieu = chatLieu;
        this.kichThuoc = kichThuoc;
        this.mauSac = mauSac;
        this.soLuong = soLuong;
        this.nhaSX = nhaSX;
        this.xuatXu = xuatXu;
        this.moTa = moTa;
    }

    public SanPham(String maSP, String tenSP, String maDM, String donGia, String maSPCT, String chatLieu, String kichThuoc, String mauSac, String soLuong, String nhaSX, String xuatXu, String moTa) {
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.maDM = maDM;
        this.donGia = donGia;
        this.maSPCT = maSPCT;
        this.chatLieu = chatLieu;
        this.kichThuoc = kichThuoc;
        this.mauSac = mauSac;
        this.soLuong = soLuong;
        this.nhaSX = nhaSX;
        this.xuatXu = xuatXu;
        this.moTa = moTa;
    }

    
    public SanPham(String maSP, String tenSP, String maSPCT, String chatLieu, String kichThuoc, String mauSac, String soLuong, String nhaSX, String xuatXu, String moTa) {
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.maSPCT = maSPCT;
        this.chatLieu = chatLieu;
        this.kichThuoc = kichThuoc;
        this.mauSac = mauSac;
        this.soLuong = soLuong;
        this.nhaSX = nhaSX;
        this.xuatXu = xuatXu;
        this.moTa = moTa;
    }

    public SanPham(String maSP, String tenSP, String maDM, String maNSX, String donGia, String trangThai) {
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.maDM = maDM;
        this.maNSX = maNSX;
        this.donGia = donGia;
        this.trangThai = trangThai;
    }

    public String getMaSPCT() {
        return maSPCT;
    }

    public void setMaSPCT(String maSPCT) {
        this.maSPCT = maSPCT;
    }

    public String getChatLieu() {
        return chatLieu;
    }

    public void setChatLieu(String chatLieu) {
        this.chatLieu = chatLieu;
    }

    public String getKichThuoc() {
        return kichThuoc;
    }

    public void setKichThuoc(String kichThuoc) {
        this.kichThuoc = kichThuoc;
    }

    public String getMauSac() {
        return mauSac;
    }

    public void setMauSac(String mauSac) {
        this.mauSac = mauSac;
    }

    public String getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(String soLuong) {
        this.soLuong = soLuong;
    }

    public String getNhaSX() {
        return nhaSX;
    }

    public void setNhaSX(String nhaSX) {
        this.nhaSX = nhaSX;
    }

    public String getXuatXu() {
        return xuatXu;
    }

    public void setXuatXu(String xuatXu) {
        this.xuatXu = xuatXu;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
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

    public String getMaDM() {
        return maDM;
    }

    public void setMaDM(String maDM) {
        this.maDM = maDM;
    }

    public String getMaNSX() {
        return maNSX;
    }

    public void setMaNSX(String maNSX) {
        this.maNSX = maNSX;
    }

    public String getDonGia() {
        return donGia;
    }
    public  String getDonGia2(){
        return  donGia.substring(0, donGia.length()-5);
    }
    public void setDonGia(String donGia) {
        this.donGia = donGia;
    }

    public String getTrangThai() {
        return trangThai;
    }
    public String getStringTrangThai(){
        return Integer.parseInt(trangThai)>0?"Còn hàng":"Hết hàng";
    }
    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    @Override
    public String toString() {
        return "SanPham{" + "maSP=" + maSP + ", tenSP=" + tenSP + ", maDM=" + maDM + ", maNSX=" + maNSX + ", donGia=" + donGia + ", trangThai=" + trangThai + ", maSPCT=" + maSPCT + ", chatLieu=" + chatLieu + ", kichThuoc=" + kichThuoc + ", mauSac=" + mauSac + ", soLuong=" + soLuong + ", nhaSX=" + nhaSX + ", xuatXu=" + xuatXu + ", moTa=" + moTa + '}';
    }
    
    public Object[] todataRow(){
        return new Object[]{
            this.maSP,this.tenSP,this.maDM,this.maNSX,this.getDonGia2(),this.getStringTrangThai()
        };
    }

    public int updateSoLuongSP(int i) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    
}
