/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.exemple.entity;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Minh Triet
 */
public class DanhMucSoDoPhong {

    String chuThich;
    JPanel panel;
    JLabel soPhong;
    JLabel loaiPhong;
    JLabel trangThai;

    public DanhMucSoDoPhong() {
    }

    public DanhMucSoDoPhong(String chuThich, JPanel panel, JLabel soPhong, JLabel loaiPhong, JLabel trangThai) {
        this.chuThich = chuThich;
        this.panel = panel;
        this.soPhong = soPhong;
        this.loaiPhong = loaiPhong;
        this.trangThai = trangThai;
    }

    public String getChuThich() {
        return chuThich;
    }

    public void setChuThich(String chuThich) {
        this.chuThich = chuThich;
    }

    public JPanel getPanel() {
        return panel;
    }

    public void setPanel(JPanel panel) {
        this.panel = panel;
    }

    public JLabel getSoPhong() {
        return soPhong;
    }

    public void setSoPhong(JLabel soPhong) {
        this.soPhong = soPhong;
    }

    public JLabel getLoaiPhong() {
        return loaiPhong;
    }

    public void setLoaiPhong(JLabel loaiPhong) {
        this.loaiPhong = loaiPhong;
    }

    public JLabel getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(JLabel trangThai) {
        this.trangThai = trangThai;
    }

    public void setTextSoPhong(String text) {
        this.soPhong.setText(text);
    }

    public void setTextLoaiPhong(String text) {
        this.loaiPhong.setText("Loại: "+text);
    }

    public void setTextTrangThai(String text) {
        this.trangThai.setText("Trạng thái: "+text);
    }
    public void setBackgroundColorPanel(Color color){
        this.panel.setBackground(color);
    }

}
