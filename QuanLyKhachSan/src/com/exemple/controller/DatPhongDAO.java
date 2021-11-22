/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.exemple.controller;

import com.exemple.entity.DatPhong;
import com.exemple.helper.JdbcHelper;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author Minh Triet
 */
public class DatPhongDAO extends EduSysDAO<DatPhong, String> {

    @Override
    public void insert(DatPhong entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(DatPhong entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(String key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<DatPhong> selectFollowSearch(String soCMT) {
        String sql = "SELECT dp.MaLoaiPhong, dp.NgayDat, dp.NgayHetHan, dp.NgayTraPhong, "
                + "DATEDIFF(day,dp.NgayHetHan,dp.NgayTraPhong) as 'TamTinh', kh.SoCMTKhachHang, "
                + "kh.TenKhachHang, kh.GioiTinh, kh.SoDienThoai, kh.Email, kh.QuocTich,"
                + "dp.MaPhong, dp.TaiKhoanNV "
                + "FROM DatPhong dp "
                + "join KhachHang kh on dp.SoCMTKhachHang=kh.SoCMTKhachHang "
                + "join LoaiPhong lp on lp.MaLoaiPhong=dp.MaLoaiPhong "
                + " where kh.SoCMTKhachHang like ?";
        return selectBySql(sql,"%"+soCMT+"%");
    }

    public List<DatPhong> selectFollowComboBox(String nullOrNotNull,String soCMT) {
        String sql = "SELECT "
                + " dp.MaLoaiPhong"
                + ", dp.NgayDat"
                + ", dp.NgayHetHan"
                + ", dp.NgayTraPhong"
                + ", DATEDIFF(day,dp.NgayHetHan,dp.NgayTraPhong) as 'TamTinh'"
                + ", kh.SoCMTKhachHang"
                + ", kh.TenKhachHang"
                + ", kh.GioiTinh"
                + ", kh.SoDienThoai"
                + ", kh.Email"
                + ", kh.QuocTich"
                + ", dp.MaPhong"
                + ", dp.TaiKhoanNV "
                + " FROM "
                + " DatPhong dp "
                + " join KhachHang kh on dp.SoCMTKhachHang=kh.SoCMTKhachHang "
                + " join LoaiPhong lp on lp.MaLoaiPhong=dp.MaLoaiPhong "
                + " WHERE dp.MaPhong IS " + nullOrNotNull 
                +" and kh.SoCMTKhachHang like ?";
        return selectBySql(sql,"%"+soCMT+"%");
    }

    @Override
    protected List<DatPhong> selectBySql(String sql, Object... args) {
        List<DatPhong> listDatPhong = new ArrayList<DatPhong>();
        ResultSet rs = null;
        try {
            rs = JdbcHelper.executeQuery(sql, args);
            while (rs.next()) {
                listDatPhong.add(readFromResultSet(rs));
            }
        } catch (Exception e) {
            throw new RuntimeException();
        } finally {
            if (rs != null) {
                try {
                    rs.getStatement().getConnection().close();
                } catch (SQLException ex) {

                }
            }
        }
        return listDatPhong;
    }

    public DatPhong readFromResultSet(ResultSet rs) throws SQLException {
        DatPhong dp = new DatPhong();
        dp.setMaLoaiPhong(rs.getInt("MaLoaiPhong"));
        Timestamp ngayDat = rs.getTimestamp("NgayDat");
        dp.setNgayDat(ngayDat);
        dp.setNgayNhanPhong(rs.getDate("NgayHetHan"));
        dp.setNgayMuonTra(rs.getDate("NgayTraPhong"));
        dp.setTamTinh(rs.getInt("TamTinh"));
        dp.setSoCMT(rs.getString("SoCMTKhachHang"));
        dp.setHoTen(rs.getString("TenKhachHang"));
        dp.setGioiTinh(rs.getBoolean("GioiTinh"));
        dp.setSoDienThoai(rs.getString("SoDienThoai"));
        dp.setEmail(rs.getString("Email"));
        dp.setQuocTich(rs.getString("QuocTich"));
        dp.setMaPhong(rs.getInt("MaPhong"));
        dp.setTaiKhoanNV(rs.getString("TaiKhoanNV"));
        return dp;
    }

    @Override
    public DatPhong selectById(String key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<DatPhong> selectAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
