/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.exemple.controller;

import com.exemple.entity.KhuyenMai;
import com.exemple.helper.JdbcHelper;
import java.util.List;

/**
 *
 * @author hp
 */
public class KhuyenMaiDAO extends EduSysDAO<KhuyenMai, String>{

    @Override
    public void insert(KhuyenMai kh) {
        String sql ="insert into KhuyenMai values(?,?,?,?,?)";
        JdbcHelper.executeUpdate(sql, 
                kh.getMaKhuyenMai(),
                kh.getTenKhuyenMai(),
                kh.getGiaTri(),
                kh.getNgayBatDau(),
                kh.getNgayKetThuoc());
    }

    @Override
    public void update(KhuyenMai entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(String key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<KhuyenMai> selectAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public KhuyenMai selectById(String key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected List<KhuyenMai> selectBySql(String sqlString, Object... args) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
