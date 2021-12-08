/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.exemple.controller;

import com.exemple.entity.KhachHang;
import com.exemple.helper.JdbcHelper;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Minh Triet
 */
public class KhachHangDAO extends EduSysDAO<KhachHang, String> {

    String SELECT_ALL_SQL = "select*from khachhang";
    String SELECT_BY_ID_SQL = "select * from khachhang where SoCMTKhachHang=?";
    String selectKhachChuaThue = "Select*from KhachHang where SoLanThue=0";
    String selectKhachTiemNang = "Select*from KhachHang where SoLanThue>0 and SoLanThue<5";
    String selectKhachViP = "select *from KhachHang where SoLanThue >=5";

    @Override
    public void insert(KhachHang kh) {
        String sql = "insert into "
                + " KhachHang(SoCMTKhachHang,TenKhachHang,NgaySinh,GioiTinh,SoDienThoai,Email,QuocTich,SoLanThue,MaDoiTac) "
                + " values (?,?,?,?,?,?,?,?,?)";
        JdbcHelper.executeUpdate(sql, kh.getCMND(), kh.getTenKhachHang(), kh.getNgaySinh(), kh.isGioiTinh(),
                kh.getSoDienThoai(), kh.getEmail(), kh.getQuocTich(), kh.getSoLanThue(), kh.getMaDoiTac());
    }

    @Override
    public void update(KhachHang kh) {
        String sql = "update KhachHang set SoCMTKhachHang=?,TenKhachHang=?,NgaySinh=?,GioiTinh=?,"
                + " SoDienThoai=?,Email=?,QuocTich=?,SoLanThue=?,MaDoiTac=? where SoCMTKhachHang=?";
        JdbcHelper.executeUpdate(sql, kh.getCMND(), kh.getTenKhachHang(), kh.getNgaySinh(), kh.isGioiTinh(),
                kh.getSoDienThoai(), kh.getEmail(), kh.getQuocTich(), kh.getSoLanThue(), kh.getMaDoiTac(), kh.getCMND());
    }

    @Override
    public void delete(String soCMT) {
        String sql = "delete from KhachHang where SoCMTKhachHang=?";
        JdbcHelper.executeUpdate(sql, soCMT);
    }

    @Override
    public List<KhachHang> selectAll() {
        return this.selectBySql(SELECT_ALL_SQL);
    }

    public List<KhachHang> selectKhachChuaThue() {
        return this.selectBySql(selectKhachChuaThue);
    }

    public List<KhachHang> selectKhachTiemNang() {
        return this.selectBySql(selectKhachTiemNang);
    }

    public List<KhachHang> selectKhachVip() {
        return this.selectBySql(selectKhachViP);
    }

    @Override
    public KhachHang selectById(String key) {
        List<KhachHang> list = this.selectBySql(SELECT_BY_ID_SQL, key);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    protected List<KhachHang> selectBySql(String sqlString, Object... args) {
        List<KhachHang> list = new ArrayList<KhachHang>();
        try {
            ResultSet rs = JdbcHelper.executeQuery(sqlString, args);
            while (rs.next()) {
                KhachHang entity = new KhachHang();
                entity.setCMND(rs.getString("SoCMTKhachHang"));
                entity.setTenKhachHang(rs.getString("TenKhachHang"));
                entity.setNgaySinh(rs.getDate("NgaySinh"));
                entity.setGioiTinh(rs.getBoolean("gioitinh"));
                entity.setSoDienThoai(rs.getString("sodienthoai"));
                entity.setEmail(rs.getString("Email"));
                entity.setQuocTich(rs.getString("QuocTich"));
                entity.setSoLanThue(rs.getInt("SoLanThue"));
                entity.setMaDoiTac(rs.getString("MaDoiTac"));

                list.add(entity);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<KhachHang> selectbySolanThue(String solanThue) {
        String sql = "Select * from khachhang where SoLanThue=?";
        return this.selectBySql(sql, solanThue);
    }

    protected List<KhachHang> selectBySqlKH_DT(String sqlString, Object... args) {
        List<KhachHang> list = new ArrayList<KhachHang>();
        try {
            ResultSet rs = JdbcHelper.executeQuery(sqlString, args);
            while (rs.next()) {
                KhachHang entity = new KhachHang();
                entity.setCMND(rs.getString("SoCMTKhachHang"));
                entity.setTenKhachHang(rs.getString("TenKhachHang"));
                entity.setGioiTinh(rs.getBoolean("gioitinh"));
                entity.setSoDienThoai(rs.getString("sodienthoai"));
                entity.setEmail(rs.getString("Email"));
                list.add(entity);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<KhachHang> selectKH_DT(String key) {
        String sql = "select SoCMTKhachHang,TenKhachHang,GioiTinh,Email,SoDienThoai from KhachHang \n"
                + "where MaDoiTac= ?";
        return this.selectBySqlKH_DT(sql, key);
    }

}
