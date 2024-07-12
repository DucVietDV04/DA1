/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import Model.taiKhoanNV;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author puddi
 */
public class taiKhoanNVService {

    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    String sql = null;

    String SELECT_BY_ID_SQL = "";

    public List<taiKhoanNV> getAllTK(String sql, Object... args) {
        sql = "select * from TaiKhoan ";
        List<taiKhoanNV> list = new ArrayList<>();
        try {
            con = DBconnect1.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                taiKhoanNV tk = new taiKhoanNV(rs.getString(1), rs.getString(2), rs.getString(3), rs.getBoolean(4));
                list.add(tk);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public taiKhoanNV selectByID(String id) {
        List<taiKhoanNV> list = this.getAllTK(SELECT_BY_ID_SQL, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.size() > 0 ? list.get(0) : null;
    }

    public int them(taiKhoanNV tk) {
        sql = "insert into TaiKhoan values(?,?,?,?)";
        try {
            con = DBconnect1.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, tk.getTkNV());
            ps.setObject(2, tk.getTenNV());
            ps.setObject(3, tk.getMatKhau());
            ps.setObject(4, tk.isVaiTro());
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public boolean checkMaTK(String TKNV) {
        try {
            con = DBconnect1.getConnection();
            sql = "Select TKNV from TaiKhoan where TKNV=?";
            ps = con.prepareStatement(sql);
            ps.setString(1, TKNV);
            rs = ps.executeQuery();
            while (rs.next()) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return false;
    }

    public boolean isCurrentPasswordValid(String TKNV, String MatKhau) {
        sql = "SELECT MatKhau FROM TaiKhoan WHERE TKNV = ?";
        try {
            con = DBconnect1.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, TKNV);
            rs = ps.executeQuery();
            if (rs.next()) {
                String currentPassword = rs.getString("PassWord");
                System.out.println("isCurrentPasswordValid : " + currentPassword);
                if (currentPassword.equals(MatKhau)) {
                    return true;
                }
            }
        } catch (Exception ex) {
            System.out.println("isCurrentPasswordValid(): " + ex.toString());
            return false;
        }
        return false;
    }

    public int updatePass(String TKNV, String MatKhau) {
        sql = "update TaiKhoan set MatKhau=? where TKNV=?";
        try {
            con = DBconnect1.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, MatKhau);
            ps.setString(2, TKNV);
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

//    public Object getAllTK() {
//        sql = "select * from TaiKhoan ";
//        List<taiKhoanNV> list = new ArrayList<>();
//        try {
//            con = DBconnect1.getConnection();
//            ps = con.prepareStatement(sql);
//            rs = ps.executeQuery();
//            while (rs.next()) {
//                taiKhoanNV tk = new taiKhoanNV(rs.getString(1), rs.getString(2), rs.getString(3), rs.getBoolean(4));
//                list.add(tk);
//            }
//            return list;
//        } catch (Exception e) {
//            e.printStackTrace();
//            return null;
//        }
//    }

}
