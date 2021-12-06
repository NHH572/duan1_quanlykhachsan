/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.exemple.controller;

import com.exemple.entity.ChiTietHoaDon;
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
public class LoadTableHoaDonDAO {
    
      public List<HoaDonLoadTable> selectBySoPhong1(Integer soPhong) {
String sql = "SELECT  HoaDon.MaHoaDon ,  KhachHang.SoCMTKhachHang ,  KhachHang.TenKhachHang ,  KhachHang.SoDienThoai ,  NhanVien.TaiKhoanNV , Phong.MaPhong, Phong.SoPhong  ,LoaiPhong.DonGiaTheoNgay ,  DichVu.MaDichVu  ,  COUNT(DichVu.MaDichVu) AS SOLAN,  DichVu.TenDichVu  ,  DichVu.GiaDichVu  ,  KhuyenMai.MaKhuyenMai ,  KhuyenMai.GiaTri ,  HoaDon.NgayTao ,  HoaDon.NgayNhanPhong,  HoaDon.NgayTraPhong ,  ChiTietHoaDon.TongTien,ChiTietHoaDon.MaChiTietHoaDon   FROM  dbo.DichVu DichVu INNER JOIN dbo.ChiTietHoaDon ChiTietHoaDon ON DichVu.MaDichVu = ChiTietHoaDon.MaDichVu  INNER JOIN dbo.HoaDon HoaDon ON ChiTietHoaDon.MaHoaDon = HoaDon.MaHoaDon  INNER JOIN dbo.Phong Phong ON ChiTietHoaDon.MaPhong = Phong.MaPhong INNER JOIN dbo.LoaiPhong LoaiPhong ON Phong.MaLoaiPhong = LoaiPhong.MaLoaiPhong  INNER JOIN dbo.NhanVien NhanVien ON HoaDon.TaiKhoanNV = NhanVien.TaiKhoanNV  INNER JOIN dbo.KhachHang KhachHang ON HoaDon.SoCMTKhachHang = KhachHang.SoCMTKhachHang  INNER JOIN dbo.KhuyenMai KhuyenMai ON HoaDon.MaKhuyenMai = KhuyenMai.MaKhuyenMai  WHERE  SoPhong = ? GROUP BY   HoaDon.MaHoaDon ,  KhachHang.SoCMTKhachHang ,  KhachHang.TenKhachHang ,  KhachHang.SoDienThoai , NhanVien.TaiKhoanNV,  Phong.MaPhong,Phong.SoPhong , LoaiPhong.DonGiaTheoNgay, DichVu.MaDichVu ,  DichVu.TenDichVu ,  DichVu.GiaDichVu ,  KhuyenMai.MaKhuyenMai ,  KhuyenMai.GiaTri,  HoaDon.NgayTao,  HoaDon.NgayNhanPhong ,  HoaDon.NgayTraPhong ,   ChiTietHoaDon.TongTien ,ChiTietHoaDon.MaChiTietHoaDon ";
          
          return this.selectBySql(sql, soPhong);
    }
      
       
       
       public List<HoaDonLoadTable>selectAll(){
String sql = "SELECT  HoaDon.MaHoaDon ,  KhachHang.SoCMTKhachHang ,  KhachHang.TenKhachHang ,  KhachHang.SoDienThoai ,  NhanVien.TaiKhoanNV , Phong.MaPhong, Phong.SoPhong  ,LoaiPhong.DonGiaTheoNgay ,  DichVu.MaDichVu  ,  COUNT(DichVu.MaDichVu) AS SOLAN,  DichVu.TenDichVu  ,  DichVu.GiaDichVu  ,  KhuyenMai.MaKhuyenMai ,  KhuyenMai.GiaTri ,  HoaDon.NgayTao ,  HoaDon.NgayNhanPhong,  HoaDon.NgayTraPhong ,  ChiTietHoaDon.TongTien,ChiTietHoaDon.MaChiTietHoaDon   FROM  dbo.DichVu DichVu INNER JOIN dbo.ChiTietHoaDon ChiTietHoaDon ON DichVu.MaDichVu = ChiTietHoaDon.MaDichVu  INNER JOIN dbo.HoaDon HoaDon ON ChiTietHoaDon.MaHoaDon = HoaDon.MaHoaDon  INNER JOIN dbo.Phong Phong ON ChiTietHoaDon.MaPhong = Phong.MaPhong INNER JOIN dbo.LoaiPhong LoaiPhong ON Phong.MaLoaiPhong = LoaiPhong.MaLoaiPhong  INNER JOIN dbo.NhanVien NhanVien ON HoaDon.TaiKhoanNV = NhanVien.TaiKhoanNV  INNER JOIN dbo.KhachHang KhachHang ON HoaDon.SoCMTKhachHang = KhachHang.SoCMTKhachHang  INNER JOIN dbo.KhuyenMai KhuyenMai ON HoaDon.MaKhuyenMai = KhuyenMai.MaKhuyenMai  WHERE  SoPhong = ? GROUP BY   HoaDon.MaHoaDon ,  KhachHang.SoCMTKhachHang ,  KhachHang.TenKhachHang ,  KhachHang.SoDienThoai , NhanVien.TaiKhoanNV,  Phong.MaPhong,Phong.SoPhong , LoaiPhong.DonGiaTheoNgay, DichVu.MaDichVu ,  DichVu.TenDichVu ,  DichVu.GiaDichVu ,  KhuyenMai.MaKhuyenMai ,  KhuyenMai.GiaTri,  HoaDon.NgayTao,  HoaDon.NgayNhanPhong ,  HoaDon.NgayTraPhong ,   ChiTietHoaDon.TongTien ,ChiTietHoaDon.MaChiTietHoaDon ";

           return selectBySql(sql);
       }
       
     public HoaDonLoadTable selectById(String sophong) {
String sql = "SELECT  HoaDon.MaHoaDon ,  KhachHang.SoCMTKhachHang ,  KhachHang.TenKhachHang ,  KhachHang.SoDienThoai ,  NhanVien.TaiKhoanNV , Phong.MaPhong, Phong.SoPhong  ,LoaiPhong.DonGiaTheoNgay ,  DichVu.MaDichVu  ,  COUNT(DichVu.MaDichVu) AS SOLAN,  DichVu.TenDichVu  ,  DichVu.GiaDichVu  ,  KhuyenMai.MaKhuyenMai ,  KhuyenMai.GiaTri ,  HoaDon.NgayTao ,  HoaDon.NgayNhanPhong,  HoaDon.NgayTraPhong ,  ChiTietHoaDon.TongTien,ChiTietHoaDon.MaChiTietHoaDon   FROM  dbo.DichVu DichVu INNER JOIN dbo.ChiTietHoaDon ChiTietHoaDon ON DichVu.MaDichVu = ChiTietHoaDon.MaDichVu  INNER JOIN dbo.HoaDon HoaDon ON ChiTietHoaDon.MaHoaDon = HoaDon.MaHoaDon  INNER JOIN dbo.Phong Phong ON ChiTietHoaDon.MaPhong = Phong.MaPhong INNER JOIN dbo.LoaiPhong LoaiPhong ON Phong.MaLoaiPhong = LoaiPhong.MaLoaiPhong  INNER JOIN dbo.NhanVien NhanVien ON HoaDon.TaiKhoanNV = NhanVien.TaiKhoanNV  INNER JOIN dbo.KhachHang KhachHang ON HoaDon.SoCMTKhachHang = KhachHang.SoCMTKhachHang  INNER JOIN dbo.KhuyenMai KhuyenMai ON HoaDon.MaKhuyenMai = KhuyenMai.MaKhuyenMai  WHERE  SoPhong = ? GROUP BY   HoaDon.MaHoaDon ,  KhachHang.SoCMTKhachHang ,  KhachHang.TenKhachHang ,  KhachHang.SoDienThoai , NhanVien.TaiKhoanNV,  Phong.MaPhong,Phong.SoPhong , LoaiPhong.DonGiaTheoNgay, DichVu.MaDichVu ,  DichVu.TenDichVu ,  DichVu.GiaDichVu ,  KhuyenMai.MaKhuyenMai ,  KhuyenMai.GiaTri,  HoaDon.NgayTao,  HoaDon.NgayNhanPhong ,  HoaDon.NgayTraPhong ,   ChiTietHoaDon.TongTien ,ChiTietHoaDon.MaChiTietHoaDon ";
        List<HoaDonLoadTable> list = selectBySql(sql, sophong);
        return list.size() > 0 ? list.get(0) : null;
    }
     
     public HoaDonLoadTable selectById_2(String sophong) {
         String sql ="SELECT ChiTietHoaDon.MaChiTietHoaDon , ChiTietHoaDon.MaPhong, ChiTietHoaDon.MaHoaDon, ChiTietHoaDon.TongTien, HoaDon.MaHoaDon, HoaDon.NgayTao, HoaDon.NgayNhanPhong, HoaDon.NgayTraPhong, HoaDon.ThanhTien, KhachHang.SoCMTKhachHang, KhachHang.TenKhachHang, KhachHang.SoDienThoai, KhuyenMai.MaKhuyenMai, KhuyenMai.GiaTri, LoaiPhong.DonGiaTheoNgay, NhanVien.TaiKhoanNV, Phong.MaPhong, Phong.SoPhong FROM dbo.HoaDon HoaDon INNER JOIN dbo.ChiTietHoaDon ChiTietHoaDon ON HoaDon.MaHoaDon = ChiTietHoaDon.MaHoaDon INNER JOIN dbo.KhachHang KhachHang ON HoaDon.SoCMTKhachHang = KhachHang.SoCMTKhachHang INNER JOIN dbo.KhuyenMai KhuyenMai ON HoaDon.MaKhuyenMai = KhuyenMai.MaKhuyenMai INNER JOIN dbo.NhanVien NhanVien ON HoaDon.TaiKhoanNV = NhanVien.TaiKhoanNV INNER JOIN dbo.Phong Phong ON ChiTietHoaDon.MaPhong = Phong.MaPhong INNER JOIN dbo.LoaiPhong LoaiPhong ON Phong.MaLoaiPhong = LoaiPhong.MaLoaiPhong WHERE SoPhong = ?";
         
         List<HoaDonLoadTable> list = selectBySql_2(sql, sophong);
        return list.size() > 0 ? list.get(0) : null;
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
        dv.setCMND_CCCD(rs.getString("SoCMTKhachHang"));
        dv.setTienPhong(rs.getFloat("DonGiaTheoNgay"));
        dv.setGiamTien(rs.getFloat("GiaTri"));
        dv.setMaGiamGia(rs.getString("MaKhuyenMai"));
        dv.setMaHoaDon(rs.getInt("MaHoaDon"));
        dv.setNgayTao(rs.getDate("NgayTao"));
        dv.setNgayTraPhong(rs.getDate("NgayTraPhong"));
        dv.setNgaynhanPhong(rs.getDate("NgayNhanPhong"));
        dv.setSoDienThoai(rs.getString("SoDienThoai"));
        dv.setSoLan(rs.getInt("SoLan"));
        dv.setSoPhong(rs.getInt("SoPhong"));
        dv.setTenDichVu(rs.getString("TenDichVu"));
        dv.setTenKhachHang(rs.getString("TenKhachHang"));
        dv.setThuNgan(rs.getString("TaiKhoanNV"));
        dv.setTongTien(rs.getString("TongTien"));
        dv.setMaDichVu(rs.getInt("MaDichVu"));
        dv.setMaPhong(rs.getInt("MaPhong"));
        dv.setMaChiTietHoaDon(rs.getInt("MaChiTietHoaDon"));
        dv.setGiaDichVu(rs.getFloat("GiaDichVu"));
        return dv;
    }
     
     public void insertHoaDon(HoaDonLoadTable hd) {         
         String sql ="INSERT INTO HoaDon(NgayTao,NgayNhanPhong,NgayTraPhong,ThanhTien,TaiKhoanNV,SoCMTKhachHang,MaKhuyenMai) VALUES (?,?,?,?,?,?,?)";
        JdbcHelper.executeUpdate(sql,
                hd.getNgayTao(),
                hd.getNgaynhanPhong(),
                hd.getNgayTraPhong(),
                hd.getTienPhong(),
                hd.getThuNgan(),
                hd.getCMND_CCCD(),
                hd.getMaGiamGia()
                );
    }
    
     public void insertChiTietHoaDon(HoaDonLoadTable hd){
         String sql = "INSERT INTO ChiTietHoaDon(MaHoaDon,MaDichVu,MaPhong,SoLanThueDichVu,TongTien) VALUES (?,?,?,?,?)";
        JdbcHelper.executeUpdate(sql, 
                hd.getMaHoaDon(),
                hd.getMaDichVu(),
                hd.getMaPhong(),
                hd.getSoLan(),
                hd.getTongTien()
        );
     }
     
     public void updateHoaDon(HoaDonLoadTable hd) {
         String sql ="Update HoaDon set NgayTao = ?,NgayNhanPhong = ?,NgayTraPhong = ?,ThanhTien = ?,TaiKhoanNV = ?,SoCMTKhachHang = ?,MaKhuyenMai = ? Where MaHoaDon = ?";
        JdbcHelper.executeUpdate(sql,
                hd.getNgayTao(),
                hd.getNgaynhanPhong(),
                hd.getNgayTraPhong(),
                hd.getTienPhong(),
                hd.getThuNgan(),
                hd.getCMND_CCCD(),
                hd.getMaGiamGia(),
                hd.getMaHoaDon()
                );
    }
    
     public void updateChiTietHoaDon(HoaDonLoadTable hd){
         String sql = "update ChiTietHoaDon set TongTien = ? from ChiTietHoaDon inner join Phong on ChiTietHoaDon.MaPhong=Phong.MaPhong where SoPhong =?;                                  ";
        JdbcHelper.executeUpdate(sql, 
                hd.getTongTien(),
                hd.getSoPhong()
        );
     }
     
     public void insertChiTietHoaDon(ChiTietHoaDon cthd){
         String sql ="insert into ChiTietHoaDon(MaPhong,MaHoaDon) values(?,?)";
         JdbcHelper.executeUpdate(sql, 
                 cthd.getMaPhong(),
                 cthd.getMaHoaDon());
     }  
     
     
     protected List<HoaDonLoadTable> selectBySql_2(String sql, Object... args) {
        List<HoaDonLoadTable> listDichVu = new ArrayList<>();
        ResultSet rs = null;
        try {
            rs = JdbcHelper.executeQuery(sql, args);
            while (rs.next()) {
                listDichVu.add(readFromResultSet_2(rs));
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
     
     public HoaDonLoadTable readFromResultSet_2(ResultSet rs) throws SQLException {
        HoaDonLoadTable dv = new HoaDonLoadTable();
        dv.setCMND_CCCD(rs.getString("SoCMTKhachHang"));
        dv.setTienPhong(rs.getFloat("DonGiaTheoNgay"));
        dv.setGiamTien(rs.getFloat("GiaTri"));
        dv.setMaGiamGia(rs.getString("MaKhuyenMai"));
        dv.setMaHoaDon(rs.getInt("MaHoaDon"));
        dv.setNgayTao(rs.getDate("NgayTao"));
        dv.setNgayTraPhong(rs.getDate("NgayTraPhong"));
        dv.setNgaynhanPhong(rs.getDate("NgayNhanPhong"));
        dv.setSoDienThoai(rs.getString("SoDienThoai"));
        dv.setSoPhong(rs.getInt("SoPhong"));
        dv.setTenKhachHang(rs.getString("TenKhachHang"));
        dv.setThuNgan(rs.getString("TaiKhoanNV"));
        dv.setTongTien(rs.getString("TongTien"));
        dv.setMaPhong(rs.getInt("MaPhong"));
        dv.setMaChiTietHoaDon(rs.getInt("MaChiTietHoaDon"));
        return dv;
    }
}
