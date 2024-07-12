/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import Model.NhaSanXuat;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author admin
 */
public class NhaSanXuatSevice {

    Connection con = null;
    PreparedStatement ps = null;
    String sql = null;
    ResultSet rs = null;

    public List<NhaSanXuat> getAllNSX() {
        sql = "select * from NhaSanXuat";
        List<NhaSanXuat> nsx = new ArrayList<>();
        try {
            con = DBconnect1.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                NhaSanXuat nhaSanXuat = new NhaSanXuat(rs.getString(1), rs.getString(2));
                nsx.add(nhaSanXuat);
            }
            return nsx;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }
     public int AddNSX(NhaSanXuat nhaSanXuat){
        sql="Insert into NhaSanXuat (MaNSX,NSX) Values(?,?)";
        try {
            con = DBconnect1.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, nhaSanXuat.getMaNSX());
            ps.setObject(2, nhaSanXuat.getTenNSX());
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
      public NhaSanXuat getNSX(String MaNSX){
        sql = "Select MaNSX,NSX From NhaSanXuat where MaNSX = ?";
        NhaSanXuat nhaSanXuat = null;
        try {
            con = DBconnect1.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, MaNSX);
            rs = ps.executeQuery();
            while (rs.next()) {
                nhaSanXuat = new NhaSanXuat(rs.getString(1), rs.getString(2));
            }
            return nhaSanXuat;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
       public int UpdateNSX(NhaSanXuat nhaSanXuat) {
        sql = "Update NhaSanXuat set  NSX=? where MaNSX=?";
        try {
            con = DBconnect1.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, nhaSanXuat.getTenNSX());
            ps.setObject(2, nhaSanXuat.getMaNSX());
          
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
}
