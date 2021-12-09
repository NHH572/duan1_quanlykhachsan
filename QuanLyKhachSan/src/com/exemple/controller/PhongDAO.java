/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.exemple.controller;

import com.exemple.entity.Phong;
import com.exemple.helper.JdbcHelper;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;

/**
 *
 * @author ACER
 */
public class PhongDAO extends EduSysDAO<Phong, String> {

    String INSERT_SQL = "INSERT INTO Phong (SoPhong,Lau,TrangThai,MaLoaiPhong) VALUES (?,?,?,?)";
    String UPDATE_SQL = "UPDATE Phong SET TrangThai=?, MaLoaiPhong=? WHERE MaPhong=?";
    String DELETE_SQL = "DELETE from Phong Where MaPhong=?";
    String SELECT_ALL_SQL = "SELECT*from Phong";
    String SELECT_BY_TRANGTHAI = "select * from Phong where TrangThai =N'Đang thuê'";
    String SELECT_BY_ID_SQL = "select * from Phong where MaPhong= ?";

    @Override
    public void insert(Phong entity) {
        JdbcHelper.executeUpdate(INSERT_SQL, entity.getSoPhong(), entity.getLau(), entity.getTrangThai(), entity.getMaLoaiPhong());
    }

    @Override
    public void update(Phong entity) {
        JdbcHelper.executeUpdate(UPDATE_SQL, entity.getTrangThai(), entity.getMaLoaiPhong(), entity.getMaPhong());
    }

    @Override
    public void delete(String key) {
        JdbcHelper.executeUpdate(DELETE_SQL, key);
    }

    @Override
    public List<Phong> selectAll() {
        return this.selectBySql(SELECT_ALL_SQL);
    }
    
    public List<Phong> selectByTrangThai() {
        return this.selectBySql(SELECT_BY_TRANGTHAI);
    }


    @Override
    public Phong selectById(String key) {
        List<Phong> list = this.selectBySql(SELECT_BY_ID_SQL, Integer.valueOf(key));
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    protected List<Phong> selectBySql(String sqlString, Object... args) {
        List<Phong> list = new ArrayList<Phong>();
        try {
            ResultSet rs = JdbcHelper.executeQuery(sqlString, args);
            while (rs.next()) {
                Phong entity = new Phong();
                entity.setMaPhong(rs.getInt("MaPhong"));
                entity.setSoPhong(rs.getInt("SoPhong"));// chay thu di
                entity.setLau(rs.getInt("Lau"));
                entity.setTrangThai(rs.getString("TrangThai"));
                entity.setMaLoaiPhong(rs.getInt("MaLoaiPhong"));
                list.add(entity);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Phong selectById2(Integer key) {
        List<Phong> list = this.selectBySql(SELECT_BY_ID_SQL, key);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    public void delete(int mp) {
        JdbcHelper.executeUpdate(DELETE_SQL, mp);
    }

    public List<Phong> selectByMaLoaiPhong(String maLoaiPhong) {
        int maLoaiPhongInt = Integer.parseInt(maLoaiPhong);
        String sql = "Select * from Phong where MaLoaiPhong=? and TrangThai=?";
        return selectBySql(sql, maLoaiPhongInt, "Trống");
    }

    public void updateTrangThai(int maPhong) {
        String sql = "update Phong set TrangThai=? where MaPhong=?";
        JdbcHelper.executeUpdate(sql, "Đang thuê", maPhong);
    }

    public void updateTrangThaiTrong(int maPhong) {
        String sql = "update Phong set TrangThai=? where MaPhong=?";
        JdbcHelper.executeUpdate(sql, "Trống", maPhong);
    }
    public int selectLauCaoNhat(){
        String sql="select top 1 * from Phong Order by Lau DESC";
        List<Phong> list=selectBySql(sql);
        return !list.isEmpty()?list.get(0).getLau():-1;
    }
}
