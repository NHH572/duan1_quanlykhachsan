/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.exemple.views;

import com.exemple.controller.PhongDAO;
import com.exemple.controller.SoDoPhongDAO;
import com.exemple.entity.SoDoPhong;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.SoftBevelBorder;

/**
 *
 * @author Minh Triet
 */
public class SoDoPhongJPanel2 extends javax.swing.JPanel {

    Color mauSoTang = new Color(23, 163, 184);
    Color mauPhongTrong = new Color(95, 184, 92);
    Color mauPhongDangThue = new Color(217, 83, 79);

    public SoDoPhongJPanel2() {
        initComponents();
        addElementSoDoPhong();
    }

    private void addElementSoDoPhong() {
        this.removeAll();
        int lauCaoNhat = new PhongDAO().selectLauCaoNhat();
        for (int i = 1; i <= lauCaoNhat; i++) {
            JPanel panelTang = new JPanel();
            JPanel panelSoTang = new JPanel();
            String soTang = "Tầng " + i;
            JLabel lblSoTang = new JLabel(soTang);
            lblSoTang.setFont(new Font("Tahoma", Font.BOLD, 15));
            lblSoTang.setHorizontalAlignment(JLabel.CENTER);
            
            panelSoTang.setLayout(new GridBagLayout());
            panelSoTang.add(lblSoTang);
            panelSoTang.setBackground(mauSoTang);
            panelSoTang.setBorder(new SoftBevelBorder(0));
            
            panelTang.setLayout(new GridLayout());
            panelTang.add(panelSoTang);
            List<SoDoPhong> listSoDoPhong = new SoDoPhongDAO().selectTop6SoDoPhong(i);
            for (SoDoPhong item : listSoDoPhong) {
                JPanel panelPhong = new JPanel();

                String soPhong = String.valueOf(item.getSoPhong());
                JLabel lblSoPhong = new JLabel(soPhong);
                lblSoPhong.setForeground(Color.white);
                lblSoPhong.setFont(new Font("Tahoma", Font.BOLD, 20));
                lblSoPhong.setHorizontalAlignment(JLabel.CENTER);

                String loaiPhong = "     Loại:" + item.getTenLoaiPhong();
                JLabel lblLoaiPhong = new JLabel(loaiPhong);
                lblLoaiPhong.setFont(new Font("Tahoma", Font.PLAIN, 15));

                String trangThai = "     Trạng thái:" + item.getTrangThai();
                JLabel lblTrangThai = new JLabel(trangThai);
                lblTrangThai.setFont(new Font("Tahoma", Font.PLAIN, 15));

                panelPhong.setLayout(new GridLayout(3, 1));
                panelPhong.add(lblSoPhong);
                panelPhong.add(lblLoaiPhong);
                panelPhong.add(lblTrangThai);
                if(item.getTrangThai().equalsIgnoreCase("Trống")){
                    panelPhong.setBackground(mauPhongTrong);
                }else{
                    panelPhong.setBackground(mauPhongDangThue);
                }
                panelPhong.setBorder(new SoftBevelBorder(0));
                
                panelTang.add(panelPhong);
            }
            this.setLayout(new GridLayout(lauCaoNhat, i));
            this.add(panelTang);
            this.validate();
            this.repaint();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
