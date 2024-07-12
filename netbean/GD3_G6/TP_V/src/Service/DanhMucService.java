/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import Model.DanhMuc;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author admin
 */
public class DanhMucService {

    Connection con = null;
    PreparedStatement ps = null;
    String sql = null;
    ResultSet rs = null;

    public List<DanhMuc> getAllDM() {
        sql = "select* from DanhMuc";
        List<DanhMuc> dm = new ArrayList<>();
        try {
            con = DBconnect1.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                DanhMuc danhMuc = new DanhMuc(rs.getString(1), rs.getString(2));
                dm.add(danhMuc);
            }
            return dm;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    public int AddDM(DanhMuc danhMuc) {
        sql = "Insert into DanhMuc (MaDM,TenDM) Values(?,?)";
        try {
            con = DBconnect1.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, danhMuc.getMaDM());
            ps.setObject(2, danhMuc.getTenDM());
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int UpdateDM(DanhMuc danhMuc) {
        sql = "Update DanhMuc set TenDM=? where MaDM=?";
        try {
            con = DBconnect1.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, danhMuc.getTenDM());
            ps.setObject(2, danhMuc.getMaDM());
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
}
