/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import Model.ChatLieu;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author puddi
 */
public class ChatLieuService {

    Connection con = null;
    PreparedStatement ps = null;
    String sql = null;
    ResultSet rs = null;

    public List<ChatLieu> getAllChatLieu() {
        sql = "select*from ChatLieu";
        List<ChatLieu> ms = new ArrayList<>();
        try {
            con = DBconnect1.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                ChatLieu chatLieu = new ChatLieu(rs.getString(1), rs.getString(2));
                ms.add(chatLieu);
            }
            return ms;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    public int AddChatLieu(ChatLieu chatLieu) {
        sql = "Insert into ChatLieu(TenCL) Values(?)";
        try {
            con = DBconnect1.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, chatLieu.getTenCL());
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int updateChatLieu(ChatLieu chatLieu) {
        sql = "Update ChatLieu set TenCL=? where STT=?";
        try {
            con = DBconnect1.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, chatLieu.getTenCL());
            ps.setObject(2, chatLieu.getStt());
           
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
}
