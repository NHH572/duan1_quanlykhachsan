/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.exemple.views;

import com.exemple.controller.KhuyenMaiDAO;
import com.exemple.entity.KhuyenMai;
import com.exemple.helper.MsgBox;

/**
 *
 * @author Minh Triet
 */
public class QuanLyKhuyenMaiJPanel extends javax.swing.JPanel {

    KhuyenMaiDAO dao = new KhuyenMaiDAO();
    public QuanLyKhuyenMaiJPanel() {
        initComponents();
    }

    private void setForm(KhuyenMai kh) {
        txtMaKhuyenMai.setText(kh.getMaKhuyenMai());
        txtTenKhuyenMai.setText(kh.getTenKhuyenMai());
        txtGiaTri.setText(String.valueOf(kh.getGiaTri()));
        txtNgayBatDau.setDate(kh.getNgayBatDau());
        txtNgayHenHan.setDate(kh.getNgayKetThuoc());
    }

    private KhuyenMai getModel() {
        KhuyenMai kh = new KhuyenMai();
        kh.setMaKhuyenMai(txtMaKhuyenMai.getText());
        kh.setTenKhuyenMai(txtTenKhuyenMai.getText());
        kh.setGiaTri(Integer.parseInt(txtGiaTri.getText()));
        kh.setNgayBatDau(txtNgayBatDau.getDate());
        kh.setNgayKetThuoc(txtNgayHenHan.getDate());
        return kh;
    }
    
    private void insert() {
        KhuyenMai kh = getModel();
        try {
            dao.insert(kh);
//            this.fillTableToTable();
//            this.clearForm();
            MsgBox.alert(this, "Thêm thành công");
        } catch (Exception e) {
            e.printStackTrace();
            MsgBox.alert(this, "Thêm thất bại");
        }

    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jLabel1 = new javax.swing.JLabel();
        txtMaKhuyenMai = new javax.swing.JTextField();
        txtTenKhuyenMai = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtGiaTri = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        txtNgayBatDau = new com.toedter.calendar.JDateChooser();
        txtNgayHenHan = new com.toedter.calendar.JDateChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();

        setLayout(new java.awt.GridBagLayout());

        jLabel1.setText("Mã khuyến mãi");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(57, 58, 0, 0);
        add(jLabel1, gridBagConstraints);

        txtMaKhuyenMai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaKhuyenMaiActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 8;
        gridBagConstraints.gridheight = 3;
        gridBagConstraints.ipadx = 124;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(54, 18, 0, 0);
        add(txtMaKhuyenMai, gridBagConstraints);

        txtTenKhuyenMai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTenKhuyenMaiActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 8;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 124;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 18, 0, 0);
        add(txtTenKhuyenMai, gridBagConstraints);

        jLabel2.setText("Tên khuyến mãi");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(21, 54, 0, 0);
        add(jLabel2, gridBagConstraints);

        txtGiaTri.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtGiaTriActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridwidth = 8;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 124;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 18, 0, 0);
        add(txtGiaTri, gridBagConstraints);

        jLabel3.setText("Giá trị");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.ipadx = 12;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(21, 54, 0, 0);
        add(jLabel3, gridBagConstraints);

        jLabel4.setText("Ngày bắt đầu");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 19;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(54, 30, 0, 0);
        add(jLabel4, gridBagConstraints);

        jLabel5.setText("Ngày hết hạn");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 19;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(24, 30, 0, 0);
        add(jLabel5, gridBagConstraints);

        jButton1.setText("Thêm");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 54, 28, 0);
        add(jButton1, gridBagConstraints);

        jButton2.setText("Xóa");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 1, 28, 0);
        add(jButton2, gridBagConstraints);

        jButton3.setText("Mới");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 10;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.gridwidth = 9;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 18, 28, 0);
        add(jButton3, gridBagConstraints);

        jButton4.setText("Sửa");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 18, 28, 0);
        add(jButton4, gridBagConstraints);

        txtNgayBatDau.setDateFormatString("dd/MM/yyyy");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 20;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridheight = 3;
        gridBagConstraints.ipadx = 128;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(54, 18, 0, 0);
        add(txtNgayBatDau, gridBagConstraints);

        txtNgayHenHan.setDateFormatString("dd/MM/yyyy");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 20;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 128;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 18, 0, 0);
        add(txtNgayHenHan, gridBagConstraints);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Mã khuyến mãi", "Tên khuyến mãi", "Giá trị", "Ngày bắt đầu", "Ngày hết hạn"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 22;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 555;
        gridBagConstraints.ipady = 142;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(11, 22, 0, 10);
        add(jScrollPane1, gridBagConstraints);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 204));
        jLabel6.setText("QUẢN LÝ KHUYẾN MÃI");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(11, 10, 0, 0);
        add(jLabel6, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void txtMaKhuyenMaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaKhuyenMaiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaKhuyenMaiActionPerformed

    private void txtTenKhuyenMaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTenKhuyenMaiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTenKhuyenMaiActionPerformed

    private void txtGiaTriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtGiaTriActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtGiaTriActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.insert();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txtGiaTri;
    private javax.swing.JTextField txtMaKhuyenMai;
    private com.toedter.calendar.JDateChooser txtNgayBatDau;
    private com.toedter.calendar.JDateChooser txtNgayHenHan;
    private javax.swing.JTextField txtTenKhuyenMai;
    // End of variables declaration//GEN-END:variables
}
