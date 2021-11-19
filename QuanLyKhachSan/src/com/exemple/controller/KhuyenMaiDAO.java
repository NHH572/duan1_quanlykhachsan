/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.exemple.controller;

import com.exemple.entity.KhuyenMai;
import com.exemple.helper.JdbcHelper;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;

/**
 *
 * @author hp
 */
public class KhuyenMaiDAO extends EduSysDAO<KhuyenMai, String>{
    String UPDATE_SQL = "update KhuyenMai set TenKhuyenMai=?, GiaTri=?,NgayBatDau=?,NgayHetHan=? where MaKhuyenMai=?";
    String DELETE_SQL = "delete from KhuyenMai where MaKhuyenMai=?";
    String SELECT_ALL_SQL = "select*from KhuyenMai";
    String SELECT_BY_ID_SQL = "select * from KhuyenMai where MaKhuyenMai = ?";
    @Override
    public void insert(KhuyenMai kh) {
        String sql ="insert into KhuyenMai values(?,?,?,?,?)";
        JdbcHelper.executeUpdate(sql, 
                kh.getMaKhuyenMai(),
                kh.getTenKhuyenMai(),
                kh.getGiaTri(),
                kh.getNgayBatDau(),
                kh.getNgayHetHan());
    }

    @Override
    public void update(KhuyenMai entity) {
          JdbcHelper.executeUpdate(UPDATE_SQL, entity.getTenKhuyenMai(), entity.getGiaTri(),
                entity.getNgayBatDau(), entity.getNgayHetHan(),entity.getMaKhuyenMai());
    }

    @Override
    public void delete(String key) {
JdbcHelper.executeUpdate(DELETE_SQL, key);
    }

    @Override
    public List<KhuyenMai> selectAll() {
 return this.selectBySql(SELECT_ALL_SQL);
    }

    @Override
    public KhuyenMai selectById(String key) {
  List<KhuyenMai> list = this.selectBySql(SELECT_BY_ID_SQL, key);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);   
    }

    @Override
    protected List<KhuyenMai> selectBySql(String sqlString, Object... args) {
List<KhuyenMai> list = new ArrayList<KhuyenMai>();
        try {
            ResultSet rs = JdbcHelper.executeQuery(sqlString, args);
            while(rs.next()){
                KhuyenMai entity = new KhuyenMai();
                entity.setMaKhuyenMai(rs.getString("MaKhuyenMai"));
                entity.setTenKhuyenMai(rs.getString("TenKhuyenMai"));
                entity.setGiaTri(rs.getInt("GiaTri"));
                entity.setNgayBatDau(rs.getDate("NgayBatDau"));
                entity.setNgayHetHan(rs.getDate("NgayBatDau"));

                list.add(entity);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }    }    
    
}