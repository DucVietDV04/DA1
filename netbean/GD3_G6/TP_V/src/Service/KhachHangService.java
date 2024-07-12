/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import Model.KhachHang;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author PC
 */
public class KhachHangService {
    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    String sql = null;

    public List<KhachHang> getAllKH() {
        sql = "select * from KhachHang ";
        List<KhachHang> list = new ArrayList<>();
        try {
            con = DBconnect1.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                KhachHang kh = new KhachHang(rs.getString(1), rs.getString(2), rs.getBoolean(3), rs.getString(4), rs.getString(5), rs.getBoolean(6), rs.getFloat(7));
                list.add(kh);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public int Them(KhachHang kh) {
        sql = "insert into KhachHang values(?,?,?,?,?,?,?)";
        try {
            con = DBconnect1.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, kh.getMAKH());
            ps.setObject(2, kh.getHoTen());
            ps.setObject(3, kh.isGioiTinh());
            ps.setObject(4, kh.getSoDienThoai());
            ps.setObject(5, kh.getEmail());
            ps.setObject(6, kh.isLoaiKH());
            ps.setObject(7, kh.getTongChiTieu());
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
    public KhachHang getKH(String MaKH) {
        sql = "select * from KhachHang where MaKH=?";
        KhachHang kh = null;
        try {
            con = DBconnect1.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, MaKH);
            rs = ps.executeQuery();
            while (rs.next()) {
                kh = new KhachHang(rs.getString(1), rs.getString(2), rs.getBoolean(3), rs.getString(4), rs.getString(5), rs.getBoolean(6), rs.getFloat(7));
                

            }
            return kh;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
