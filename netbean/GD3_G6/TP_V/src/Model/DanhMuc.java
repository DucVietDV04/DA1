/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author ducviet
 */
public class DanhMuc {
    private String MaDM;
    private String TenDM;

    public DanhMuc() {
    }

    public DanhMuc(String MaDM, String TenDM) {
        this.MaDM = MaDM;
        this.TenDM = TenDM;
    }

    public String getMaDM() {
        return MaDM;
    }

    public void setMaDM(String MaDM) {
        this.MaDM = MaDM;
    }

    public String getTenDM() {
        return TenDM;
    }

    public void setTenDM(String TenDM) {
        this.TenDM = TenDM;
    }
     public Object[]toDataRowDM(){
        return new Object[]{
            this.MaDM,this.TenDM
        };
    }
    
}
