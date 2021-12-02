/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.exemple.controller;

import com.exemple.entity.LoaiPhong;
import com.exemple.entity.Quanlyphong;
import com.exemple.helper.JdbcHelper;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;

/**
 *
 * @author ACER
 */
public class QuanLyPhongDAO extends EduSysDAO<Quanlyphong, String> {

    String selectPhong = "select p.MaPhong,lp.MaLoaiPhong,p.SoPhong,lp.TenLoaiPhong,p.Lau,lp.DonGiaTheoNgay,lp.DonGiaTheoGio,p.TrangThai,lp.MucTangCuoiTuan,lp.MucTangNgayLe,lp.MoTa from LoaiPhong lp inner join Phong p on lp.MaLoaiPhong=p.MaLoaiPhong";
    String selectByTen ="select p.MaPhong,lp.MaLoaiPhong,p.SoPhong,lp.TenLoaiPhong,p.Lau,lp.DonGiaTheoNgay,lp.DonGiaTheoGio,p.TrangThai,lp.MucTangCuoiTuan,lp.MucTangNgayLe,lp.MoTa from LoaiPhong lp inner join Phong p on lp.MaLoaiPhong=p.MaLoaiPhong where lp.TenLoaiPhong like ?";
    public List<Quanlyphong> selectPhong() {
        return selectBySql(selectPhong);
    }

    @Override
    public void insert(Quanlyphong entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Quanlyphong entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(String key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Quanlyphong> selectAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Quanlyphong selectByTen(String key) {
         List<Quanlyphong> list = this.selectBySql(selectByTen,key);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    protected List<Quanlyphong> selectBySql(String sqlString, Object... args) {
        List<Quanlyphong> list = new ArrayList<Quanlyphong>();
        try {
            ResultSet rs = JdbcHelper.executeQuery(sqlString, args);
            while (rs.next()) {
                Quanlyphong entity = new Quanlyphong();
                entity.setMaPhong(rs.getInt("MaPhong"));
                entity.setMaLoaiPhong(rs.getInt("MaLoaiPhong"));
                entity.setSoPhong(rs.getInt("SoPhong"));// chay thu di
                entity.setTenLoaiPhong(rs.getString("TenLoaiPhong"));// chay thu di
                entity.setLau(rs.getInt("Lau"));
                entity.setDonGiaTheoNgay(rs.getInt("DonGiaTheoNgay"));
                entity.setDonGiaTheoGio(rs.getInt("DonGiaTheoGio"));
                entity.setTrangThai(rs.getString("TrangThai"));
                entity.setMucTangNgayLe(rs.getInt("MucTangNgayLe"));
                entity.setMucTangCuoiTuan(rs.getInt("MucTangCuoiTuan"));
                entity.setMoTa(rs.getString("MoTa"));

                list.add(entity);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Quanlyphong selectById(String key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public List<Quanlyphong> selectBykeyword (String ten){
        return selectBySql(selectByTen,"%"+ten+"%");
    }
    public Quanlyphong selectByMaPhong(int maPhong) {
        String sql ="select p.MaPhong,lp.MaLoaiPhong,p.SoPhong,lp.TenLoaiPhong,p.Lau,lp.DonGiaTheoNgay,lp.DonGiaTheoGio,p.TrangThai,lp.MucTangCuoiTuan,lp.MucTangNgayLe,lp.MoTa from LoaiPhong lp inner join Phong p on lp.MaLoaiPhong=p.MaLoaiPhong where p.MaPhong=?";
        List<Quanlyphong> list = this.selectBySql(selectByTen,maPhong);
        return list.get(0);
    }
}
