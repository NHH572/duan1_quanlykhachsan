/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.exemple.controller;

import com.exemple.entity.HoaDonLoadTable;
import com.exemple.entity.TableHoaDon;
import com.exemple.helper.JdbcHelper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hp
 */
public class TableHoaDonDAO {
    public List<TableHoaDon>selectAll(){
           String sql = " SELECT HoaDon.MaHoaDon ,HoaDon.NgayTao ,HoaDon.NgayNhanPhong ,HoaDon.NgayTraPhong ,HoaDon.ThanhTien , HoaDon.TaiKhoanNV , HoaDon.SoCMTKhachHang , HoaDon.MaKhuyenMai AS MaKhuyenMai, Phong.SoPhong  FROM dbo.HoaDon HoaDon INNER JOIN dbo.ChiTietHoaDon ChiTietHoaDon ON HoaDon.MaHoaDon = ChiTietHoaDon.MaHoaDon INNER JOIN dbo.Phong Phong ON ChiTietHoaDon.MaPhong = Phong.MaPhong  GROUP BY  HoaDon.MaHoaDon ,  HoaDon.NgayTao ,  HoaDon.NgayNhanPhong ,  HoaDon.NgayTraPhong ,  HoaDon.ThanhTien ,  HoaDon.TaiKhoanNV ,  HoaDon.SoCMTKhachHang ,  HoaDon.MaKhuyenMai ,  Phong.SoPhong";

           return selectBySql(sql);
       }
    
    
    protected List<TableHoaDon> selectBySql(String sql, Object... args) {
        List<TableHoaDon> listDichVu = new ArrayList<>();
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
    
    public TableHoaDon readFromResultSet(ResultSet rs) throws SQLException {
        TableHoaDon dv = new TableHoaDon();
        dv.setSoCMND(rs.getString("SoCMTKhachHang"));
        dv.setMaKhuyenMai(rs.getString("MaKhuyenMai"));
        dv.setMaHoaDon(rs.getInt("MaHoaDon"));
        dv.setNgayTao(rs.getDate("NgayTao"));
        dv.setNgayTraPhong(rs.getDate("NgayTraPhong"));
        dv.setNgaynhanPhong(rs.getDate("NgayNhanPhong"));
        dv.setTaiKhoanNV(rs.getString("TaiKhoanNV"));
        dv.setThanhTien(rs.getFloat("ThanhTien"));
        dv.setSoPhong(rs.getInt("SoPhong"));
        return dv;
    }
}
