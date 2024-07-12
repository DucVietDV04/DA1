/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

//import Interface.InF_SanPham;
import Model.SanPham;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ducviet
 */
public class SanPhamService {

    Connection con = null;
    PreparedStatement ps = null;
    String sql = null;
    ResultSet rs = null;

    public List<SanPham> getSPCTAll() {
        sql = "select MaSP, TenSP, MaCTSP, ChatLieu, KichThuoc, Mau,SoLuong, NhaSX, XuatXu, MoTa from ChiTietSanPham";
        List<SanPham> sp = new ArrayList<>();
        try {
            con = DBconnect1.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                SanPham sp1 = new SanPham(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getString(9),
                        rs.getString(10));
                sp.add(sp1);
            }
            return sp;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<SanPham> getAll() {
        sql = "select ct.MaSP, ct.TenSP, sp.MaDM, sp.MaNSX, sp.DonGia,\n"
                + "sp.TrangThai,ct.MaCTSP,ct.ChatLieu,ct.KichThuoc,ct.Mau,\n"
                + "ct.SoLuong,ct.NhaSX,ct.XuatXu,ct.MoTa\n"
                + "from SanPham sp\n"
                + "join ChiTietSanPham ct on sp.MaSP= ct.MaSP";
        List<SanPham> sanPhams = new ArrayList<>();
        try {
            con = DBconnect1.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                SanPham sp = new SanPham(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getString(9),
                        rs.getString(10),
                        rs.getString(11),
                        rs.getString(12),
                        rs.getString(13),
                        rs.getString(14));
                sanPhams.add(sp);
            }
            return sanPhams;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<SanPham> getAllSP() {
        sql = "select MaSP, TenSP, MaDM, MaNSX, DonGia, TrangThai from SanPham";

        List<SanPham> sanPhams = new ArrayList<>();
        try {
            con = DBconnect1.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                SanPham sanPham = new SanPham(rs.getString(1), rs.getString(2),
                        rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
                sanPhams.add(sanPham);
            }
            return sanPhams;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

//    public int SuaSP(SanPham sp) {
//        sql = "delete from ChiTietSanPham where MaSP =?;"
//                + "delete from SanPham where MaSP =?;";
//        try {
//            con = DBconnect1.getConnection();
//            ps = con.prepareStatement(sql);
//            ps.setObject(1, sp.getMaSP());
//            ps.setObject(2, sp.getMaSP());
//            return ps.executeUpdate();
//        } catch (Exception e) {
//            e.printStackTrace();
//            return 0;
//        }
//    }
    public int addSP(SanPham sp) {
        sql = "insert into SanPham (MaSP, TenSP, MaDM,MaNSX,DonGia,TrangThai) "
                + "values (?,?,?,?,?,?);"
                + "insert into ChiTietSanPham (MaSP, TenSP,MaCTSP,ChatLieu,KichThuoc,Mau,SoLuong,NhaSX,XuatXu,MoTa)"
                + "values (?,?,?,?,?,?,?,?,?,?)";
        try {
            con = DBconnect1.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, sp.getMaSP());
            ps.setObject(2, sp.getTenSP());
            ps.setObject(3, sp.getMaDM());
            ps.setObject(4, sp.getMaNSX());
            ps.setObject(5, sp.getDonGia());
            ps.setObject(6, sp.getTrangThai());
            ps.setObject(7, sp.getMaSP());
            ps.setObject(8, sp.getTenSP());
            ps.setObject(9, sp.getMaSPCT());
            ps.setObject(10, sp.getChatLieu());
            ps.setObject(11, sp.getKichThuoc());
            ps.setObject(12, sp.getMauSac());
            ps.setObject(13, sp.getSoLuong());
            ps.setObject(14, sp.getNhaSX());
            ps.setObject(15, sp.getXuatXu());
            ps.setObject(16, sp.getMoTa());
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }

    }

    public List<SanPham> findSP(String maSP) {
        sql = "select ct.MaCTSP, sp.MaSP, sp.TenSP,ct.ChatLieu, ct.KichThuoc, ct.Mau, ct.SoLuong,ct.NhaSX, ct.XuatXu,sp.MaDM,sp.DonGia,ct.MoTa  from SanPham sp\n"
                + "join ChiTietSanPham ct on sp.MaSP= ct.MaSP\n"
                + "where sp.MaSP =?";
        List<SanPham> listsp = new ArrayList<>();
        try {
            con = DBconnect1.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, maSP);
            rs = ps.executeQuery();
            while (rs.next()) {
                SanPham sp = new SanPham(
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(10),
                        rs.getString(11),
                        rs.getString(1),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getString(9),
                        rs.getString(12));
                listsp.add(sp);
            }
            return listsp;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public int xoaSP(String sp) {
        sql = "delete from ChiTietSanPham where MaSP =?;"
                + "delete from SanPham where MaSP =?;";
        try {
            con = DBconnect1.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, sp);
            ps.setObject(2, sp);
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int SuaSP(SanPham sp, String MaSP, String MaSPCT) {
        //Cần truyền vào: đối tượng mới, khóa chính của đối tượng cũ
        sql = "update SanPham set TenSP = ?, MaDM = ?,MaNSX = ?,DonGia = ?,TrangThai = ? where MaSP = ?;"
                + "update ChiTietSanPham set TenSP = ?, ChatLieu = ?,KichThuoc = ?,Mau=?,SoLuong = ?,NhaSX = ?,XuatXu = ?,MoTa = ? where MaCTSP = ? and MaSP=?";
        try {
            con = DBconnect1.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, sp.getTenSP());
            ps.setObject(2, sp.getMaDM());
            ps.setObject(3, sp.getMaNSX());
            ps.setObject(4, sp.getDonGia());
            ps.setObject(5, sp.getTrangThai());
            ps.setObject(6, MaSP);
            ps.setObject(7, sp.getTenSP());
            ps.setObject(8, sp.getChatLieu());
            ps.setObject(9, sp.getKichThuoc());
            ps.setObject(10, sp.getMauSac());
            ps.setObject(11, sp.getSoLuong());
            ps.setObject(12, sp.getNhaSX());
            ps.setObject(13, sp.getXuatXu());
            ps.setObject(14, sp.getMoTa());
            ps.setObject(15, MaSPCT);
            ps.setObject(16, MaSP);
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

}
