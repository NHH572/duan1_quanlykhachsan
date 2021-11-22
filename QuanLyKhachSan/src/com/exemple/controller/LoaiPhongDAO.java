/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.exemple.controller;

import com.exemple.entity.LoaiPhong;
import com.exemple.helper.JdbcHelper;
import java.util.List;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Minh Triet
 */
public class LoaiPhongDAO extends EduSysDAO<LoaiPhong, Integer>{

    @Override
    public void insert(LoaiPhong entity) {
        
    }

    @Override
    public void update(LoaiPhong entity) {
    }

    @Override
    public void delete(Integer key) {
    }

    @Override
    public List<LoaiPhong> selectAll() {
        String sql = "select * from LoaiPhong";
        return selectBySql(sql);
    }

    @Override
    public LoaiPhong selectById(Integer maLoaiPhong) {
        String sql = "select * from LoaiPhong where MaLoaiPhong=?";
        List<LoaiPhong> list = selectBySql(sql, maLoaiPhong);
        return list.size() > 0 ? list.get(0) : null;
    }
    public String getTenLoaiPhong(Integer maLoaiPhong){
        String sql = "select * from LoaiPhong where MaLoaiPhong=?";
        List<LoaiPhong> list=selectBySql(sql, maLoaiPhong);
        return list.size() > 0 ? list.get(0).getTenLoaiPhong() : null;
    }
    @Override
    protected List<LoaiPhong> selectBySql(String sql, Object... args) {
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
}
