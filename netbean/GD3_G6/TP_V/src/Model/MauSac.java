/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author ducviet
 */
public class MauSac {
    private String MaMS;
    private String TenMS;

    public MauSac() {
    }

    public MauSac(String MaMS, String TenMS) {
        this.MaMS = MaMS;
        this.TenMS = TenMS;
    }

    public String getMaMS() {
        return MaMS;
    }

    public void setMaMS(String MaMS) {
        this.MaMS = MaMS;
    }

    public String getTenMS() {
        return TenMS;
    }

    public void setTenMS(String TenMS) {
        this.TenMS = TenMS;
    }
    public String toString() {
        return getTenMS(); 
    }
    public Object[]toDataRowMS(){
        return new Object[]{
            this.MaMS,this.TenMS
        };
    }
    
}
