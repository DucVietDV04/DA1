/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import Model.HoaDon;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author puddi
 */
public class HoaDonService {

    Connection con = null;
    PreparedStatement ps = null;
    String sql = null;
    ResultSet rs = null;

    public List<HoaDon> getAllHD() {
        sql = "select ct.MaHD,ct.MaHDCT,hd.MaKH,ct.TenKH,ct.MaSP,ct.TenSP,\n"
                + "ct.DonGia,ct.SoLuong,ct.GhiChu,hd.NgayTao,hd.TongTien\n"
                + "from HoaDon hd\n"
                + "join HoaDonCT ct on hd.MaHD= ct.MaHD";
        List<HoaDon> list = new ArrayList<>();
        try {
            con = DBconnect1.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                HoaDon hoaDon = new HoaDon(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getString(9),
                        rs.getDate(10),
                        rs.getString(11));
                list.add(hoaDon);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<HoaDon> getAllHDGoc() {
        sql = "select hd.MaHD, hd.NgayTao,hd.TongTien\n"
                + "from HoaDon hd";
        List<HoaDon> list = new ArrayList<>();
        try {
            con = DBconnect1.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                HoaDon hd = new HoaDon();
                hd.setMaHD(rs.getString("MaHD"));
                hd.setNgayTao(rs.getDate("NgayTao"));
                hd.setTongTien(rs.getString("TongTien"));

                list.add(hd);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<HoaDon> findHoaDonCT(String maHD) {
        sql = "select ct.MaHDCT,ct.MaHD,ct.TenKH,ct.MaSP,ct.TenSP,\n"
                + "ct.DonGia,ct.SoLuong,ct.GhiChu\n"
                + "from HoaDon hd\n"
                + "join HoaDonCT ct on hd.MaHD= ct.MaHD\n"
                + "where hd.maHD = ?";
        List<HoaDon> list = new ArrayList<>();
        try {
            con = DBconnect1.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, maHD);
            rs = ps.executeQuery();
            while (rs.next()) {
                HoaDon hoaDon = new HoaDon();
                hoaDon.setMaHDCT(rs.getString("MaHDCT"));
                hoaDon.setMaHD(rs.getString("MaHD"));
                hoaDon.setTenKH(rs.getString("TenKH"));
                hoaDon.setMaSP(rs.getString("MaSP"));
                hoaDon.setTenSP(rs.getString("TenSP"));
                hoaDon.setDonGia(rs.getString("DonGia"));
                hoaDon.setSoLuong(rs.getString("SoLuong"));
                hoaDon.setGhiChu(rs.getString("GhiChu"));
                list.add(hoaDon);

            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public int Them(HoaDon hd) {
        sql = "insert into HoaDon(MaHD,NgayTao,TongTien) "
                + "values(?,?,?)";
        try {
            con = DBconnect1.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, hd.getMaHD());
            ps.setObject(2, hd.getNgayTao());
            ps.setObject(3, hd.getTongTien());


            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int countHoaDon() {
        int tongHoaDon = 0;
        try {
            sql = "Select COUNT(*) From HoaDon";
            con = DBconnect1.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                tongHoaDon = rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
        return tongHoaDon;
    }

}
