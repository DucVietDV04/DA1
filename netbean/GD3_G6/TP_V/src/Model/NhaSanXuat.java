/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author ducviet
 */
public class NhaSanXuat {
    private String MaNSX;
    private String TenNSX;

    public NhaSanXuat() {
    }

    public NhaSanXuat(String MaNSX, String TenNSX) {
        this.MaNSX = MaNSX;
        this.TenNSX = TenNSX;
    }

    public String getMaNSX() {
        return MaNSX;
    }

    public void setMaNSX(String MaNSX) {
        this.MaNSX = MaNSX;
    }

    public String getTenNSX() {
        return TenNSX;
    }

    public void setTenNSX(String TenNSX) {
        this.TenNSX = TenNSX;
    }
     public Object[]toDataRowNSX(){
        return new Object[]{
            this.MaNSX,this.TenNSX
        };
    }

    @Override
    public String toString() {
        return MaNSX;
    }
    
}
