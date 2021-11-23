/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.exemple.controller;

import com.exemple.entity.LoaiPhong;
import com.exemple.helper.JdbcHelper;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author ACER
 */
public class LoaiPhongDAO extends EduSysDAO<LoaiPhong, String> {

    String INSERT_SQL = "INSERT INTO LoaiPhong(TenLoaiPhong,DonGiaTheoNgay,DonGiaTheoGio,GiaSauMotGio,MucTangNgayLe,MucTangCuoiTuan,MoTa)"
            + "Values(?,?,?,?,?,?,?)";
    String UPDATE_SQL = "UPDATE LoaiPhong set TenLoaiPhong=?, DonGiaTheoNgay=?, DonGiaTheoGio=?,GiaSauMotGio=?"
            + "MucTangNgayLe=?,MucTangCuoiTuan=?, MoTa=? WHERE MaLoaiPhong=?";
    String DELETE_SQL = "DELETE from LoaiPhong WHERE MaLoaiPhong=?";
        String SELECT_ALL_SQL = "select * from LoaiPhong";
    String SELECT_BY_ID_SQL = "select * from LoaiPhong where MaLoaiPhong= ?";
   

    @Override
    public void insert(LoaiPhong entity) {
        JdbcHelper.executeUpdate(INSERT_SQL, entity.getTenLoaiPhong(), entity.getDonGiaTheoNgay(), entity.getDonGiaTheoGio(),
                entity.getGiaSauMotGio(), entity.getMucTangNgayLe(), entity.getMucTangCuoiTuan(), entity.getMoTa());
    }

    @Override
    public void update(LoaiPhong entity) {
        JdbcHelper.executeUpdate(UPDATE_SQL, entity.getTenLoaiPhong(), entity.getDonGiaTheoNgay(), entity.getDonGiaTheoGio(),
                entity.getGiaSauMotGio(), entity.getMucTangNgayLe(), entity.getMucTangCuoiTuan(), entity.getMoTa(), entity.getMaLoaiPhong());
    }

    @Override
    public void delete(String key) {
        JdbcHelper.executeUpdate(DELETE_SQL, key);
    }

    @Override
    public List<LoaiPhong> selectAll() {
          return this.selectBySql(SELECT_ALL_SQL);
    }

    @Override
    public LoaiPhong selectById(String key) {
         List<LoaiPhong> list = this.selectBySql(SELECT_BY_ID_SQL, key);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    protected List<LoaiPhong> selectBySql(String sqlString, Object... args) {
        List<LoaiPhong> list = new ArrayList<LoaiPhong>();
        try {
            ResultSet rs = JdbcHelper.executeQuery(sqlString, args);
            while(rs.next()){
                LoaiPhong entity = new LoaiPhong();
                entity.setMaLoaiPhong(rs.getInt("MaLoaiPhong"));
                entity.setTenLoaiPhong(rs.getString("TenLoaiPhong"));// 
                entity.setDonGiaTheoNgay(rs.getInt("DonGiaTheoNgay"));
                entity.setDonGiaTheoGio(rs.getInt("DonGiaTheoGio"));
                entity.setGiaSauMotGio(rs.getInt("GiaSauMotGio")); 
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
    public List<LoaiPhong> getAll(){
        String sql="Select * from LoaiPhong";
        return findByCondition(sql);
    }
    public LoaiPhong findByID(Integer maLoaiPhong) {
        String sql = "select * from LoaiPhong where MaLoaiPhong=?";
        List<LoaiPhong> list = findByCondition(sql, maLoaiPhong);
        return list.size() > 0 ? list.get(0) : null;
    }
    public String getTenLoaiPhong(Integer maLoaiPhong){
        String sql = "select * from LoaiPhong where MaLoaiPhong=?";
        List<LoaiPhong> list=findByCondition(sql, maLoaiPhong);
        return list.size() > 0 ? list.get(0).getTenLoaiPhong() : null;
    }

    protected List<LoaiPhong> findByCondition(String sql, Object... args) {
       List<LoaiPhong> listLoaiPhong = new ArrayList<LoaiPhong>();
        ResultSet rs = null;
        try {
            rs = JdbcHelper.executeQuery(sql, args);
            while (rs.next()) {
                listLoaiPhong.add(readFromResultSet(rs));
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
        return listLoaiPhong;
    }
    
    private LoaiPhong readFromResultSet(ResultSet rs) throws SQLException {
        LoaiPhong lp = new LoaiPhong();
        lp.setMaLoaiPhong(rs.getInt("MaLoaiPhong"));
        lp.setTenLoaiPhong(rs.getString("TenLoaiPhong"));
        lp.setDonGiaTheoNgay(rs.getInt("DonGiaTheoNgay"));
        lp.setDonGiaTheoGio(rs.getInt("DonGiaTheoGio"));
        lp.setGiaSauMotGio(rs.getInt("GiaSauMotGio"));
        lp.setMucTangCuoiTuan(rs.getInt("MucTangCuoiTuan"));
        lp.setMucTangNgayLe(rs.getInt("MucTangNgayLe"));
        lp.setMoTa(rs.getString("MoTa"));
        return lp;
    }
    public int selectByDonGiaTheoNgay(int maLoaiPhong){
        String sql="Select * from LoaiPhong where MaLoaiPhong = ?";
        List<LoaiPhong> list=findByCondition(sql,maLoaiPhong);
        return list.size()>0?list.get(0).getDonGiaTheoNgay():-1;
    }
}


