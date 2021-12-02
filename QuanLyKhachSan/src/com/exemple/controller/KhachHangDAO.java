/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.exemple.controller;

import com.exemple.entity.KhachHang;
import com.exemple.helper.JdbcHelper;
import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Minh Triet
 */
public class KhachHangDAO extends EduSysDAO<KhachHang, String> {

    @Override
    public void insert(KhachHang kh) {
        String sql = "insert into "
                + " KhachHang(SoCMTKhachHang,TenKhachHang,NgaySinh,GioiTinh,SoDienThoai,Email,QuocTich,SoLanThue) "
                + " values (?,?,?,?,?,?,?,?)";
        JdbcHelper.executeUpdate(sql, kh.getCMND(), kh.getTenKhachHang(), kh.getNgaySinh(), kh.isGioiTinh(),
                kh.getSoDienThoai(), kh.getEmail(), kh.getQuocTich(), kh.getSoLanThue());
    }

    @Override
    public void update(KhachHang kh) {
        String sql = "update KhachHang set SoCMTKhachHang=?,TenKhachHang=?,NgaySinh=?,GioiTinh=?,"
                + " SoDienThoai=?,Email=?,QuocTich=?,SoLanThue=? where SoCMTKhachHang=?";
        JdbcHelper.executeUpdate(sql, kh.getCMND(), kh.getTenKhachHang(), kh.getNgaySinh(), kh.isGioiTinh(),
                kh.getSoDienThoai(), kh.getEmail(), kh.getQuocTich(), kh.getSoLanThue(), kh.getCMND());
    }

    @Override
    public void delete(String soCMT) {
        String sql="delete from KhachHang where SoCMTKhachHang=?";
        JdbcHelper.executeUpdate(sql, soCMT);
    }

    @Override
    public List<KhachHang> selectAll() {
        String sql="Select * from KhachHang";
        return selectBySql(sql);
    }
    public List<KhachHang> selectKey(){
        String sql="Select SoCMTKhachHang from KhachHang";
        return selectBySql(sql);
    }
    @Override
    public KhachHang selectById(String key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected List<KhachHang> selectBySql(String sql, Object... args) {
        List<KhachHang> listKhachHang = new ArrayList<KhachHang>();
        ResultSet rs = null;
        try {
            rs = JdbcHelper.executeQuery(sql, args);
            while (rs.next()) {
                listKhachHang.add(readFromResultSet(rs));
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
        return listKhachHang;
    }
    public KhachHang readFromResultSet(ResultSet rs) throws SQLException {
        KhachHang kh = new KhachHang();
        kh.setCMND(rs.getString("SoCMTKhachHang"));
        kh.setTenKhachHang(rs.getString("TenKhachHang"));
        kh.setNgaySinh(rs.getDate("NgaySinh"));
        kh.setGioiTinh(rs.getBoolean("GioiTinh"));
        kh.setSoDienThoai(rs.getString("SoDienThoai"));
        kh.setEmail(rs.getString("Email"));
        kh.setQuocTich(rs.getString("QuocTich"));
        kh.setSoLanThue(rs.getInt("SoLanThue"));
        return kh;
    }
   

}
