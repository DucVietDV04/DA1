/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author puddi
 */
public class ChatLieu {
    private String stt;
    private String tenCL;

    public ChatLieu() {
    }

    public ChatLieu(String stt, String tenCL) {
        this.stt = stt;
        this.tenCL = tenCL;
    }

    public String getStt() {
        return stt;
    }

    public void setStt(String stt) {
        this.stt = stt;
    }

    public String getTenCL() {
        return tenCL;
    }

    public void setTenCL(String tenCL) {
        this.tenCL = tenCL;
    }
    
}
