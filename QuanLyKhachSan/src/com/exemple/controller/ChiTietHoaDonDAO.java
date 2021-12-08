/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.exemple.controller;

import com.exemple.entity.ChiTietHoaDon;
import com.exemple.helper.JdbcHelper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class ChiTietHoaDonDAO {
    public ChiTietHoaDon selectById(int soPhong, int maDichVu) {
        String sql ="select MaChiTietHoaDon,ChiTietHoaDon.MaPhong,MaHoaDon,MaDichVu,SoLanThueDichVu,TongTien from ChiTietHoaDon inner join Phong on ChiTietHoaDon.MaPhong=Phong.MaPhong where SoPhong = ? and MaDichVu = ?";
        
        List<ChiTietHoaDon> list = selectBySql(sql, soPhong, maDichVu);
        return list.size() > 0 ? list.get(0) : null;
    }
    
     public void updateDichVuChiTietHoaDon(ChiTietHoaDon hd){
         String sql = "update ChiTietHoaDon set SoLanThueDichVu =? from ChiTietHoaDon inner join Phong on ChiTietHoaDon.MaPhong=Phong.MaPhong where SoPhong = ? and MaDichVu = ?";
        JdbcHelper.executeUpdate(sql, 
                hd.getSoLanThueDichVu(),
                hd.getMaPhong(),
                hd.getMaDichVu()
        );
     }
    
     public void delete(int soPhong, int maDichVu) {
        String sql="delete from ChiTietHoaDon where MaDichVu = ? and MaPhong in (select MaPhong from Phong where SoPhong = ?)";
     JdbcHelper.executeUpdate(sql,maDichVu,soPhong);
    }
     
    protected List<ChiTietHoaDon> selectBySql(String sql, Object... args) {
        List<ChiTietHoaDon> listDichVu = new ArrayList<>();
        ResultSet rs = null;
        try {
            rs = JdbcHelper.executeQuery(sql, args);
            while (rs.next()) {
                listDichVu.add(readFromResultSet(rs));
            }
        } catch (Exception e) {
            System.out.println("error"+e.getMessage());
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
     
     public ChiTietHoaDon readFromResultSet(ResultSet rs) throws SQLException {
        ChiTietHoaDon dv = new ChiTietHoaDon();
        dv.setMaChiTietHoaDon(rs.getInt("MaChiTietHoaDon"));
        dv.setTongTien(rs.getInt("TongTien"));
        dv.setSoLanThueDichVu(rs.getInt("SoLanThueDichVu"));
        dv.setMaPhong(rs.getInt("MaPhong"));
        dv.setMaHoaDon(rs.getInt("MaHoaDon"));
        dv.setMaDichVu(rs.getInt("MaDichVu"));
        return dv;
    }
}
