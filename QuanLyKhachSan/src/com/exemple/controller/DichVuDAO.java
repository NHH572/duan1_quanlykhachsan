/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.exemple.controller;

import com.exemple.entity.DichVu;
import com.exemple.helper.JdbcHelper;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Minh Triet
 */
public class DichVuDAO extends EduSysDAO<DichVu, Integer> {

    @Override
    public void insert(DichVu dv) {
        String sql = "insert into DichVu(TenDichVu,GiaDichVu,MoTa) values (?,?,?)";
        JdbcHelper.executeUpdate(sql, dv.getTenDichVu(), dv.getGiaDichVu(), dv.getMoTa());
    }

    @Override
    public void update(DichVu dv) {
        String sql = "update DichVu set TenDichVu=?,GiaDichVu=?,MoTa=? where MaDichVu=?";
        JdbcHelper.executeUpdate(sql, dv.getTenDichVu(), dv.getGiaDichVu(), dv.getMoTa(), dv.getMaDichVu());
    }

    @Override
    public void delete(Integer maDichVu) {
        String sql = "delete from DichVu where MaDichVu=?";
        JdbcHelper.executeUpdate(sql, maDichVu);
    }

    @Override
    public List<DichVu> selectAll() {
        String sql = "select * from DichVu";
        return selectBySql(sql);
    }

    public DichVu readFromResultSet(ResultSet rs) throws SQLException {
        DichVu dv = new DichVu();
        dv.setMaDichVu(rs.getInt("MaDichVu"));
        dv.setTenDichVu(rs.getString("TenDichVu"));
        dv.setGiaDichVu(rs.getFloat("GiaDichVu"));
        dv.setMoTa(rs.getString("MoTa"));
        return dv;
    }

    @Override
    public DichVu selectById(Integer maDichVu) {
        String sqlString = "select * from DichVu where MaDichVu=?";
        List<DichVu> list = selectBySql(sqlString, maDichVu);
        return list.size() > 0 ? list.get(0) : null;
    }

    @Override
    protected List<DichVu> selectBySql(String sql, Object... args) {
        List<DichVu> listDichVu = new ArrayList<DichVu>();
        ResultSet rs = null;
        try {
            rs = JdbcHelper.executeQuery(sql, args);
            while (rs.next()) {
                listDichVu.add(readFromResultSet(rs));
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
        return listDichVu;
    }
    public List<DichVu> selectSearch(String text){
        String sql="select * from DichVu where TenDichVu like ?";
        return selectBySql(sql, "%"+text+"%");
    }
}
