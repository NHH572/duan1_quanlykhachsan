/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.exemple.controller;

import com.exemple.entity.KhachHang;
import com.exemple.helper.JdbcHelper;
import java.util.List;

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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public KhachHang selectById(String key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected List<KhachHang> selectBySql(String sqlString, Object... args) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
