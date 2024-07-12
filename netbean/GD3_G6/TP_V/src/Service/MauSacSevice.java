/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import Model.MauSac;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author admin
 */
public class MauSacSevice {

    Connection con = null;
    PreparedStatement ps = null;
    String sql = null;
    ResultSet rs = null;

    public List<MauSac> getAllMS() {
        sql = "select*from MauSac";
        List<MauSac> ms = new ArrayList<>();
        try {
            con = DBconnect1.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                MauSac mauSac = new MauSac(rs.getString(1), rs.getString(2));
                ms.add(mauSac);
            }
            return ms;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    public int AddMS(MauSac mauSac) {
        sql = "Insert into MauSac(TenMS) Values(?)";
        try {
            con = DBconnect1.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, mauSac.getTenMS());
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int UpdateMS(MauSac mauSac) {
        sql = "Update MauSac set TenMS=? where STT=?";
        try {
            con = DBconnect1.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, mauSac.getTenMS());
            ps.setObject(2, mauSac.getMaMS());
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

}
