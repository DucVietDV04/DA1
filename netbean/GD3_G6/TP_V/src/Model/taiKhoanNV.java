/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author puddi
 */
public class taiKhoanNV {
    private String tkNV;
    private String tenNV;
    private String matKhau;
    private boolean vaiTro;

    public taiKhoanNV() {
    }

    public taiKhoanNV(String tkNV, String tenNV, String matKhau, boolean vaiTro) {
        this.tkNV = tkNV;
        this.tenNV = tenNV;
        this.matKhau = matKhau;
        this.vaiTro = vaiTro;
    }

    public String getTkNV() {
        return tkNV;
    }

    public void setTkNV(String tkNV) {
        this.tkNV = tkNV;
    }

    public String getTenNV() {
        return tenNV;
    }

    public void setTenNV(String tenNV) {
        this.tenNV = tenNV;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public boolean isVaiTro() {
        return vaiTro;
    }

    public void setVaiTro(boolean vaiTro) {
        this.vaiTro = vaiTro;
    }

    @Override
    public String toString() {
        return "taiKhoanNV{" + "tkNV=" + tkNV + ", tenNV=" + tenNV + ", matKhau=" + matKhau + ", vaiTro=" + vaiTro + '}';
    }

    public Object[] todataRow(){
        return new Object[]{this.tkNV,this.tenNV,this.matKhau,this.vaiTro?"Quản lý":"Nhân viên"};
    }
}
