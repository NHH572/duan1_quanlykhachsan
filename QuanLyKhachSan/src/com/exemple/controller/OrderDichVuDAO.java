/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.exemple.controller;

import com.exemple.entity.HoaDonLoadTable;
import com.exemple.helper.JdbcHelper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hp
 */
public class OrderDichVuDAO {
    public List<HoaDonLoadTable> selectBySoPhong1(Integer soPhong) {
String sql = "SELECT  HoaDon.MaHoaDon ,  KhachHang.SoCMTKhachHang ,  KhachHang.TenKhachHang ,  KhachHang.SoDienThoai ,  NhanVien.TaiKhoanNV , Phong.MaPhong, Phong.SoPhong  ,LoaiPhong.DonGiaTheoNgay ,  DichVu.MaDichVu  ,  COUNT(DichVu.MaDichVu) AS SOLAN,  DichVu.TenDichVu  ,  DichVu.GiaDichVu  ,  KhuyenMai.MaKhuyenMai ,  KhuyenMai.GiaTri ,  HoaDon.NgayTao ,  HoaDon.NgayNhanPhong,  HoaDon.NgayTraPhong ,  ChiTietHoaDon.TongTien,ChiTietHoaDon.MaChiTietHoaDon   FROM  dbo.DichVu DichVu INNER JOIN dbo.ChiTietHoaDon ChiTietHoaDon ON DichVu.MaDichVu = ChiTietHoaDon.MaDichVu  INNER JOIN dbo.HoaDon HoaDon ON ChiTietHoaDon.MaHoaDon = HoaDon.MaHoaDon  INNER JOIN dbo.Phong Phong ON ChiTietHoaDon.MaPhong = Phong.MaPhong INNER JOIN dbo.LoaiPhong LoaiPhong ON Phong.MaLoaiPhong = LoaiPhong.MaLoaiPhong  INNER JOIN dbo.NhanVien NhanVien ON HoaDon.TaiKhoanNV = NhanVien.TaiKhoanNV  INNER JOIN dbo.KhachHang KhachHang ON HoaDon.SoCMTKhachHang = KhachHang.SoCMTKhachHang  INNER JOIN dbo.KhuyenMai KhuyenMai ON HoaDon.MaKhuyenMai = KhuyenMai.MaKhuyenMai  WHERE  SoPhong = ? GROUP BY   HoaDon.MaHoaDon ,  KhachHang.SoCMTKhachHang ,  KhachHang.TenKhachHang ,  KhachHang.SoDienThoai , NhanVien.TaiKhoanNV,  Phong.MaPhong,Phong.SoPhong , LoaiPhong.DonGiaTheoNgay, DichVu.MaDichVu ,  DichVu.TenDichVu ,  DichVu.GiaDichVu ,  KhuyenMai.MaKhuyenMai ,  KhuyenMai.GiaTri,  HoaDon.NgayTao,  HoaDon.NgayNhanPhong ,  HoaDon.NgayTraPhong ,   ChiTietHoaDon.TongTien ,ChiTietHoaDon.MaChiTietHoaDon ";
          
          return this.selectBySql(sql, soPhong);
    }
    
    
    
    
    protected List<HoaDonLoadTable> selectBySql(String sql, Object... args) {
        List<HoaDonLoadTable> listDichVu = new ArrayList<>();
        ResultSet rs = null;
        try {
            rs = JdbcHelper.executeQuery(sql, args);
            while (rs.next()) {
                listDichVu.add(readFromResultSet(rs));
            }
        } catch (Exception e) {
            System.out.println("error"+e.getMessage());
            e.printStackTrace();
            
            throw new RuntimeException();
        } finally {
            if (rs != null) {
                try {
                    rs.getStatement().getConnection().close();
                } catch (SQLException ex) {

                }
            }
        }
        return listDichVu;
    }
    
    public HoaDonLoadTable readFromResultSet(ResultSet rs) throws SQLException {
        HoaDonLoadTable dv = new HoaDonLoadTable();
        dv.setSoPhong(rs.getInt("SoPhong"));
        dv.setTenKhachHang(rs.getString("TenKhachHang"));
        dv.setCMND_CCCD(rs.getString("SoCMTKhachHang"));
        dv.setGiaDichVu(rs.getFloat("GiaDichVu"));
        dv.setTienPhong(rs.getFloat("DonGiaTheoNgay"));
        dv.setGiamTien(rs.getFloat("GiaTri"));
        dv.setMaGiamGia(rs.getString("MaKhuyenMai"));
        dv.setMaHoaDon(rs.getInt("MaHoaDon"));
        dv.setNgayTao(rs.getDate("NgayTao"));
        dv.setNgayTraPhong(rs.getDate("NgayTraPhong"));
        dv.setNgaynhanPhong(rs.getDate("NgayNhanPhong"));
        dv.setSoDienThoai(rs.getString("SoDienThoai"));
        dv.setSoLan(rs.getInt("SoLan"));
        dv.setTenDichVu(rs.getString("TenDichVu"));
        dv.setThuNgan(rs.getString("TaiKhoanNV"));
        dv.setTongTien(rs.getString("TongTien"));
        dv.setMaDichVu(rs.getInt("MaDichVu"));
        dv.setMaPhong(rs.getInt("MaPhong"));
        dv.setMaChiTietHoaDon(rs.getInt("MaChiTietHoaDon"));
        return dv;
    }
}
