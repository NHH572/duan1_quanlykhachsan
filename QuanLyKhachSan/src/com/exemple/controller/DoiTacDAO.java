/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.exemple.controller;

import com.exemple.entity.DoiTac;
import java.util.List;
import com.exemple.helper.JdbcHelper;
import static com.exemple.helper.JdbcHelper.con;
import static com.exemple.helper.JdbcHelper.dburl;
import static com.exemple.helper.JdbcHelper.password;
import static com.exemple.helper.JdbcHelper.username;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.PreparedStatement;

/**
 *
 * @author My PC
 */
public class DoiTacDAO extends EduSysDAO<DoiTac, String> {

    public static int SLHT;

    @Override
    public void insert(DoiTac entity) {
        String sql = "INSERT INTO DoiTac (MaDoiTac, TenDoiTac, SoDienThoai, DanhGiaKhachSan) VALUES (?, ?, ?, ?)";
        JdbcHelper.executeUpdate(sql,
                entity.getMaDoiTac(),
                entity.getTenDoiTac(),
                entity.getSoDienThoai(),
                entity.getDanhGia());
    }

    @Override
    public void update(DoiTac entity) {
        String sql = "UPDATE DoiTac SET TenDoiTac=?, SoDienThoai=?, DanhGiaKhachSan=? WHERE MaDoiTac=?";
        JdbcHelper.executeUpdate(sql,
                entity.getTenDoiTac(),
                entity.getSoDienThoai(),
                entity.getDanhGia(),
                entity.getMaDoiTac());
    }

    @Override
    public void delete(String key) {
        String sql = "DELETE FROM DoiTac WHERE MaDoiTac=?";
        JdbcHelper.executeUpdate(sql, key);
    }

    @Override
    public List<DoiTac> selectAll() {
        String sql = "SELECT * FROM DoiTac";
        return selectBySql(sql);
    }
    
    @Override
    public DoiTac selectById(String key) {
        String sql = "SELECT * FROM DoiTac WHERE MaDoiTac=?";
        List<DoiTac> list = selectBySql(sql, key);
        return list.size() > 0 ? list.get(0) : null;
    }
    
    public int SoLanHopTac(String key) {

        String sql = "select Count(kh.MaDoiTac) as SoLuong from HoaDon hd inner join KhachHang kh on hd.SoCMTKhachHang = kh.SoCMTKhachHang inner join DoiTac dt on kh.MaDoiTac = dt.MaDoiTac where kh.MaDoiTac = ? group by hd.SoCMTKhachHang";
        try {
            SLHT=0;
            con = DriverManager.getConnection(dburl, username, password);
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, key);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                SLHT = rs.getInt("SoLuong");
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return SLHT;
    }

    @Override
    protected List<DoiTac> selectBySql(String sql, Object... args) {
        List<DoiTac> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = JdbcHelper.executeQuery(sql, args);
                while (rs.next()) {
                    DoiTac model = readFromResultSet(rs);
                    list.add(model);
                }
            } finally {
                rs.getStatement().getConnection().close();
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return list;
    }

    private DoiTac readFromResultSet(ResultSet rs) throws SQLException {
        DoiTac model = new DoiTac();
        model.setMaDoiTac(rs.getString("MaDoiTac"));
        model.setTenDoiTac(rs.getString("TenDoiTac"));
        model.setSoDienThoai(rs.getString("SoDienThoai"));
        model.setDanhGia(rs.getString("DanhGiaKhachSan"));
        return model;
    }

}
