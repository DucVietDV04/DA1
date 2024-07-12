/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import Interface.InF_KhuyenMai;
import Model.KhuyenMai;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author admin
 */
public class KhuyenMaiService implements InF_KhuyenMai {

    Connection con = null;
    PreparedStatement ps = null;
    String sql = null;
    ResultSet rs = null;

    public List<KhuyenMai> getAll() {
        sql = "select * from KhuyenMai";
        List<KhuyenMai> list = new ArrayList<>();
        try {
            con = DBconnect1.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                KhuyenMai khuyenMai = new KhuyenMai(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7));
                list.add(khuyenMai);

            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public int add(KhuyenMai khuyenMai) {
        sql = "Insert into KhuyenMai(MaKM, TenKM, DieuKien, NgayBatDau,NgayKetThuc, Mota, MucKhuyenMai) Values(?,?,?,?,?,?,?)";
        try {
            con = DBconnect1.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, khuyenMai.getMaKM());
            ps.setObject(2, khuyenMai.getTenKM());
            ps.setObject(3, khuyenMai.getDieuKien());
            ps.setObject(4, khuyenMai.getNgayBatDau());
            ps.setObject(5, khuyenMai.getNgayKetThuc());
            ps.setObject(6, khuyenMai.getMoTa());
            ps.setObject(7, khuyenMai.getMucKhuyenMai());
            return ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }

    }

    public KhuyenMai getKM(String MaKM) {
        sql = "select * from KhuyenMai where MaKM=?";
        KhuyenMai khuyenMai = null;
        try {
            con = DBconnect1.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, MaKM);
            rs = ps.executeQuery();
            while (rs.next()) {
                khuyenMai = new KhuyenMai(rs.getString(1), rs.getString(2),
                        rs.getString(3), rs.getString(4),
                        rs.getString(5), rs.getString(6), rs.getString(7));

            }
            return khuyenMai;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public int update(KhuyenMai khuyenMai, String MaKM) {
        sql = "Update KhuyenMai set MaKM=?,TenKM=?, DieuKien=?, NgayBatDau=?,NgayKetThuc=?, Mota=?, MucKhuyenMai=? where MaKM=?";
        try {
            con = DBconnect1.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, khuyenMai.getMaKM());
            ps.setObject(2, khuyenMai.getTenKM());
            ps.setObject(3, khuyenMai.getDieuKien());
            ps.setObject(4, khuyenMai.getNgayBatDau());
            ps.setObject(5, khuyenMai.getNgayKetThuc());
            ps.setObject(6, khuyenMai.getMoTa());
            ps.setObject(7, khuyenMai.getMucKhuyenMai());
            ps.setObject(8, MaKM);
            return ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

}
