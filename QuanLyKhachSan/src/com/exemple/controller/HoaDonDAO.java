/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.exemple.controller;

import com.exemple.entity.HoaDon;
import com.exemple.helper.JdbcHelper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hp
 */
public class HoaDonDAO extends EduSysDAO<HoaDon, String> {

    @Override
    public void insert(HoaDon entity) {
        String sql;
        if (entity.getMaKhuyenMai() != null) {
            sql = "INSERT INTO HOADON (NgayTao,NgayNhanPhong,NgayTraPhong,ThanhTien,TaiKhoanNV,SoCMTKhachHang,MaKhuyenMai) values(?,?,?,?,?,?,?)";
        JdbcHelper.executeUpdate(sql,
                entity.getNgayTao(),
                entity.getNgayNhanPhong(),
                entity.getNgayTraPhong(),
                entity.getThanhToan(),
                entity.getTaiKhoanNV(),
                entity.getCMND_CCCD(),
                entity.getMaKhuyenMai());
        } else {
             sql = "INSERT INTO HOADON (NgayTao,NgayNhanPhong,NgayTraPhong,ThanhTien,TaiKhoanNV,SoCMTKhachHang,MaKhuyenMai) values(?,?,?,?,?,?,?)";
       JdbcHelper.executeUpdate(sql,
                entity.getNgayTao(),
                entity.getNgayNhanPhong(),
                entity.getNgayTraPhong(),
                entity.getThanhToan(),
                entity.getTaiKhoanNV(),
                entity.getCMND_CCCD());
                entity.setMaKhuyenMai("NONE");
        }
        
    }
    @Override
    public void update(HoaDon entity) {
        String sql = "Update HoaDon set NgayTao=?,NgayNhanPhong=?,NgayTraPhong=?,ThanhTien=?,TaiKhoanNV=?,SoCMTKhachHang=?,MaKhuyenMai=? Where MaHoaDon =?";
        JdbcHelper.executeUpdate(sql,
                entity.getNgayTao(),
                entity.getNgayNhanPhong(),
                entity.getNgayTraPhong(),
                entity.getThanhToan(),
                entity.getTaiKhoanNV(),
                entity.getCMND_CCCD(),
                entity.getMaKhuyenMai(),
                entity.getMaHoaDon());
    }

    @Override
    public void delete(String key) {
        String sql = "Delete from HoaDon Where mahoadon =?";
        JdbcHelper.executeUpdate(sql, key);
    }

    public HoaDon readFormResultSet(ResultSet rs) throws SQLException {
        HoaDon hd = new HoaDon();
        hd.setMaHoaDon(rs.getInt("MaHoaDon"));
        Timestamp nhan = rs.getTimestamp("NgayNhanPhong");
        Timestamp tao = rs.getTimestamp("NgayTao");
        Timestamp tra = rs.getTimestamp("NgayTraPhong");
        hd.setNgayNhanPhong(nhan);
        hd.setNgayTao(tao);
        hd.setNgayTraPhong(tra);
        hd.setThanhToan(rs.getFloat("ThanhTien"));
        hd.setTaiKhoanNV(rs.getString("TaiKhoanNV"));
        hd.setCMND_CCCD(rs.getString("SoCMTKhachHang"));
        hd.setMaKhuyenMai(rs.getString("MaKhuyenMai"));
        return hd;
    }

    @Override
    public List<HoaDon> selectAll() {
        String sql = "SELECT * from HoaDon";
        return selectBySql(sql);

    }
    
    public HoaDon selectByCMND(String key) {
        String sql = "Select * from HoaDon where SoCMTKhachHang =?";
        selectBySql(sql, key);
        List<HoaDon> list = selectBySql(sql, key);
        return list.size() > 0 ? list.get(0) : null;
    }
    
    @Override
    public HoaDon selectById(String key) {
        String sql = "Select * from HoaDon where MaHoaDon =?";
        selectBySql(sql, key);
        List<HoaDon> list = selectBySql(sql, key);
        return list.size() > 0 ? list.get(0) : null;
    }

    @Override
    protected List<HoaDon> selectBySql(String sql, Object... args) {
        List<HoaDon> list = new ArrayList<>();
        ResultSet rs = null;
        try {
            rs = JdbcHelper.executeQuery(sql, args);
            while (rs.next()) {
                list.add(readFormResultSet(rs));
            }
        } catch (Exception e) {
            throw new RuntimeException();
        } finally {
            if (rs != null) {
                try {
                    rs.getStatement().getConnection().close();
                } catch (Exception e) {
                    Logger.getLogger(HoaDonDAO.class.getName()).log(Level.SEVERE, null, e);
                }
            }
        }

        return list;
    }

}
