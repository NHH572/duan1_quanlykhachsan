/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.exemple.controller;

import com.exemple.entity.DanhMucSoDoPhong;
import com.exemple.entity.SoDoPhong;
import com.exemple.helper.JdbcHelper;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.event.MouseInputListener;

/**
 *
 * @author Minh Triet
 */
public class SoDoPhongDAO {

    public static Color colorDefault = new Color(102, 102, 102);
    public static Color colorChange = new Color(153, 153, 153);
    private List<DanhMucSoDoPhong> listDanhMucSoDoPhong = null;
    String sqlSoDoPhong = "select p.MaPhong,p.SoPhong,lp.TenLoaiPhong,p.TrangThai from LoaiPhong lp inner join Phong p on lp.MaLoaiPhong=p.MaLoaiPhong";

    public SoDoPhongDAO() {
    }

    public List<SoDoPhong> selectSoDoPhong() {
        return selectBySql(sqlSoDoPhong);
    }

    protected List<SoDoPhong> selectBySql(String sql, Object... args) {
        List<SoDoPhong> listSoDoPhong = new ArrayList<SoDoPhong>();
        ResultSet rs = null;
        try {
            rs = JdbcHelper.executeQuery(sql, args);
            while (rs.next()) {
                listSoDoPhong.add(readFromResultSet(rs));
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
        return listSoDoPhong;
    }

    public SoDoPhong readFromResultSet(ResultSet rs) throws SQLException {
        SoDoPhong sdp = new SoDoPhong();
        sdp.setMaPhong(rs.getInt("MaPhong"));
        sdp.setSoPhong(rs.getInt("SoPhong"));
        sdp.setTenLoaiPhong(rs.getString("TenLoaiPhong"));
        sdp.setTrangThai(rs.getString("TrangThai"));
        return sdp;
    }

    public void setInformationSoDoPhong(List<DanhMucSoDoPhong> listDanhMucSoDoPhong, List<SoDoPhong> listDataDanhMucSoDoPhong) {
        int i = 0;
        for (SoDoPhong item : listDataDanhMucSoDoPhong) {
            DanhMucSoDoPhong dmsdp = listDanhMucSoDoPhong.get(i);
            dmsdp.setTextSoPhong(String.valueOf(item.getSoPhong()));
            dmsdp.setTextLoaiPhong(item.getTenLoaiPhong());
            dmsdp.setTextTrangThai(item.getTrangThai());
            if (item.getTrangThai().equalsIgnoreCase("Trống")) {
                dmsdp.setBackgroundColorPanel(new Color(95, 184, 92));
            } else {
                dmsdp.setBackgroundColorPanel(new Color(217, 83, 79));
            }
            i++;
        }

    }

}
