/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.exemple.controller;

import com.exemple.entity.DanhMucSoDoPhong;
import com.exemple.entity.SoDoPhong;
import com.exemple.helper.JdbcHelper;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagLayout;
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
    private JPanel panelPhong;
    private List<DanhMucSoDoPhong> listDanhMucSoDoPhong = null;
    String sqlSoDoPhong = "select p.SoPhong,lp.TenLoaiPhong,p.TrangThai from LoaiPhong lp inner join Phong p on lp.MaLoaiPhong=p.MaLoaiPhong";

    public SoDoPhongDAO() {
    }

    public SoDoPhongDAO(JPanel panelPhong) {
        this.panelPhong = panelPhong;
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
        sdp.setSoPhong(rs.getInt("SoPhong"));
        sdp.setTenLoaiPhong(rs.getString("TenLoaiPhong"));
        sdp.setTrangThai(rs.getString("TrangThai"));
        return sdp;
    }

    public void setInformationSoDoPhong(List<DanhMucSoDoPhong> listDanhMucSoDoPhong, List<SoDoPhong> listDataDanhMucSoDoPhong) {
        int i = 0;
        for (SoDoPhong item : listDataDanhMucSoDoPhong) {
            DanhMucSoDoPhong dmsdp = listDanhMucSoDoPhong.get(i);
//            dmsdp.setChuThich("T"+tang+"P"+phong);
//            i++;
//            if(i==4||i==9||i==14||i==19||i==24){
//                tang++;
//            }

            dmsdp.setTextSoPhong(String.valueOf(item.getSoPhong()));
            dmsdp.setTextLoaiPhong(item.getTenLoaiPhong());
            dmsdp.setTextTrangThai(item.getTrangThai());
            if (item.getTrangThai().equalsIgnoreCase("Trống")) {
                dmsdp.setBackgroundColorPanel(Color.green);
            } else {
                dmsdp.setBackgroundColorPanel(Color.red);
            }
            i++;
        }

    }

    public void setEvent(List<DanhMucSoDoPhong> listDanhMucSoDoPhong) {
        this.listDanhMucSoDoPhong = listDanhMucSoDoPhong;
        for (DanhMucSoDoPhong item : listDanhMucSoDoPhong) {
            item.getPanel().addMouseListener(new LabelEvent(item.getPanel(), item.getSoPhong(), item.getLoaiPhong(), item.getTrangThai()));
        }
    }

    class LabelEvent implements MouseInputListener {

        private JPanel node;
        private JLabel soPhong;
        private JLabel loaiPhong;
        private JLabel trangThai;
        private JPanel panelTam = new JPanel();

        public LabelEvent() {
        }

        public LabelEvent(JPanel node) {
            this.node = node;
        }
        
        public LabelEvent(JPanel node, JLabel soPhong, JLabel loaiPhong, JLabel trangThai) {
            this.node = node;
            this.soPhong = soPhong;
            this.loaiPhong = loaiPhong;
            this.trangThai = trangThai;
        }

        @Override
        public void mouseClicked(MouseEvent e) {

        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {
//            if (trangThai.getText().equalsIgnoreCase("Trạng thái: Trống")) {
//                panelPhong.removeAll();
//                panelPhong.setLayout(new GridBagLayout());
//                JButton btnChiTietPhong = new JButton();
//                btnChiTietPhong.setText("Chi tiết");
//                JButton btnDatPhong = new JButton();
//                btnDatPhong.setText("Đặt phòng");
//                panelPhong.add(btnChiTietPhong);
//                panelPhong.add(btnDatPhong);
//                panelPhong.validate();
//                panelPhong.repaint();
//            } else {
//                panelPhong.removeAll();
//                panelPhong.setLayout(new GridBagLayout());
//                JButton btnChiTietPhong = new JButton();
//                btnChiTietPhong.setText("Chi tiết");
//                JButton btnDatPhong = new JButton();
//                btnDatPhong.setText("Thanh toán");
//                panelPhong.add(btnChiTietPhong);
//                panelPhong.add(btnDatPhong);
//                panelPhong.validate();
//                panelPhong.repaint();
//            }
        }

        @Override
        public void mouseExited(MouseEvent e) {

        }

        @Override
        public void mouseDragged(MouseEvent e) {
        }

        @Override
        public void mouseMoved(MouseEvent e) {
        }

    }
}
