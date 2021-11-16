/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.exemple.controller;

import com.exemple.entity.NhanVien;
import com.exemple.helper.JdbcHelper;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ACER
 */
public class NhanVienDAO extends EduSysDAO<NhanVien, String> {

    String INSERT_SQL = "insert into NhanVien(TaiKhoanNV,MatKhauNV,HoTen,NgaySinh,GioiTinh,SoCMT,DiaChi,SoDienThoai,VaiTro,hinh) Values(?,?,?,?,?,?,?,?,?,?)";
    String UPDATE_SQL = "update NhanVien set MatKhauNV=?, HoTen=?,NgaySinh=?,GioiTinh=?"
            + "SoCMT=?,DiaChi=?,SoDienThoai=?,VaiTro=?,hinh=? where TaiKhoanNV=?";
    String DELETE_SQL = "delete from NhanVien where TaiKhoanNV=?";
    String SELECT_ALL_SQL = "select*from NhanVien";
    String SELECT_BY_ID_SQL = "select * from NhanVien where TaiKhoanNV = ?";

    @Override
    public void insert(NhanVien entity) {
        JdbcHelper.executeUpdate(INSERT_SQL, entity.getMaNV(), entity.getMatKhau(), entity.getHoTen(),
                entity.getNgaySinh(), entity.isGioiTinh(), entity.getCMND_CCCD(), entity.getDiaChi(), entity.getSoDienThoai(), entity.isVaiTro(),entity.getHinh());
    }

    @Override
    public void update(NhanVien entity) {
        JdbcHelper.executeUpdate(UPDATE_SQL, entity.getMatKhau(), entity.getHoTen(),
                entity.getNgaySinh(), entity.isGioiTinh(), entity.getCMND_CCCD(), entity.getDiaChi(), entity.getSoDienThoai(), entity.isVaiTro(),entity.getHinh(), entity.getMaNV());
    }

    @Override
    public void delete(String key) {
        JdbcHelper.executeUpdate(DELETE_SQL, key);
    }

    @Override
    public List<NhanVien> selectAll() {
        return this.selectBySql(SELECT_ALL_SQL);
    }

    @Override
    public NhanVien selectById(String key) {
        List<NhanVien> list = this.selectBySql(SELECT_BY_ID_SQL, key);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);

    }
@Override
        protected List<NhanVien> selectBySql(String sqlString, Object... args) {
   List<NhanVien> list = new ArrayList<NhanVien>();
        try {
            ResultSet rs = JdbcHelper.executeQuery(sqlString, args);
            while(rs.next()){
                NhanVien entity = new NhanVien();
                entity.setMaNV(rs.getString("TaiKhoanNV"));
                entity.setHoTen(rs.getString("HoTen"));// chay thu di
                entity.setMatKhau(rs.getString("MatKhauNV"));
                entity.setNgaySinh(rs.getDate("NgaySinh"));
                entity.setGioiTinh(rs.getBoolean("GioiTinh"));
                entity.setCMND_CCCD(rs.getString("SoCMT"));
                entity.setDiaChi(rs.getString("DiaChi"));
                entity.setSoDienThoai(rs.getString("SoDienThoai"));
                entity.setVaiTro(rs.getBoolean("VaiTro"));
                entity.setHinh(rs.getString("hinh"));
                
                
                list.add(entity);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }    }

}