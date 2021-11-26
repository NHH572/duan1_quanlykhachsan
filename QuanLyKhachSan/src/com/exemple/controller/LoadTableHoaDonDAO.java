/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.exemple.controller;

import com.exemple.helper.JdbcHelper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hp
 */
public class LoadTableHoaDonDAO {
      public List<HoaDonLoadTable> selectBySoPhong(Integer soPhong) {
        String sqlString = "select Phong.SoPhong, DichVu.TenDichVu ,count(DichVu.MaDichVu) as 'So Lan', GiaDichVu from ChiTietHoaDon inner join Phong on ChiTietHoaDon.MaPhong = Phong.MaPhong inner join DichVu on ChiTietHoaDon.MaDichVu = DichVu.MaDichVu Where SoPhong = ? group by Phong.SoPhong, DichVu.TenDichVu ,GiaDichVu";
       return this.selectBySql(sqlString, soPhong);
    }
      
      
       protected List<HoaDonLoadTable> selectBySql(String sql, Object... args) {
        List<HoaDonLoadTable> listDichVu = new ArrayList<>();
        ResultSet rs = null;
        try {
            rs = JdbcHelper.executeQuery(sql, args);
            while (rs.next()) {
                listDichVu.add(readFromResultSet(rs));
            }
        } catch (Exception e) {
            e.printStackTrace();
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
       
    
    
     public HoaDonLoadTable readFromResultSet(ResultSet rs) throws SQLException {
        HoaDonLoadTable dv = new HoaDonLoadTable();
        dv.setSoPhong(rs.getInt("SoPhong"));
        dv.setTenDichVu(rs.getString("TenDichVu"));
        dv.setSoLan(rs.getInt("So Lan"));
        dv.setGiaDichVu(rs.getFloat("GiaDichVu"));
        return dv;
    }
}
