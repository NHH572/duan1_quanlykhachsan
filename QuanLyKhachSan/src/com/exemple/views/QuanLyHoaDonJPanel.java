/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.exemple.views;

<<<<<<< Updated upstream
=======
import com.exemple.controller.HoaDonDAO;
import com.exemple.entity.HoaDon;
import com.exemple.helper.MsgBox;
import com.exemple.helper.utilityHelper;
import java.awt.HeadlessException;
import java.util.List;
import javax.swing.table.DefaultTableModel;

>>>>>>> Stashed changes
/**
 *
 * @author Minh Triet
 */
public class QuanLyHoaDonJPanel extends javax.swing.JPanel {

    /**
     * Creates new form QuanLyHoaDonJPanel
     */
    public QuanLyHoaDonJPanel() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

<<<<<<< Updated upstream
=======
        jScrollPane1 = new javax.swing.JScrollPane();
        tblHoaDon = new javax.swing.JTable();
        btnThem = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnMoi = new javax.swing.JButton();
        btnDau = new javax.swing.JButton();
        btnTien = new javax.swing.JButton();
        btnLui = new javax.swing.JButton();
        btnCuoi = new javax.swing.JButton();
        txtThanhTien = new javax.swing.JTextField();
        jdcNgayTraPhong = new com.toedter.calendar.JDateChooser();
        jdcNgayNhanPhong = new com.toedter.calendar.JDateChooser();
        jdcNgayTao = new com.toedter.calendar.JDateChooser();
        jLabel8 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtMaKM = new javax.swing.JTextField();
        txtTKNV = new javax.swing.JTextField();
        txtCCCD = new javax.swing.JTextField();
        txtMaHoaDon = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        tblHoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã hóa đơn", "CMND/CCCD", "Tài khoản NV", "Ngày tạo", "Ngày nhận phòng", "Ngày trả phòng", "Mã khuyến mãi", "Thành tiền"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblHoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblHoaDonMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblHoaDon);

        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnMoi.setText("Mới");
        btnMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMoiActionPerformed(evt);
            }
        });

        btnDau.setText("<|");
        btnDau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDauActionPerformed(evt);
            }
        });

        btnTien.setText("<<");
        btnTien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTienActionPerformed(evt);
            }
        });

        btnLui.setText(">>");
        btnLui.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLuiActionPerformed(evt);
            }
        });

        btnCuoi.setText("|>");
        btnCuoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCuoiActionPerformed(evt);
            }
        });

        txtThanhTien.setName("Thành tiền"); // NOI18N

        jdcNgayTraPhong.setDateFormatString("dd-MM-yyyy hh:mm:ss");
        jdcNgayTraPhong.setName("ngày trả phòng"); // NOI18N

        jdcNgayNhanPhong.setDateFormatString("dd-MM-yyyy hh:mm:ss");
        jdcNgayNhanPhong.setName("ngày nhận phòng"); // NOI18N

        jdcNgayTao.setDateFormatString("dd-MM-yyyy hh:mm:ss");
        jdcNgayTao.setName("ngày tạo"); // NOI18N

        jLabel8.setText("Ngày tạo: ");

        jLabel7.setText("Ngày nhận phòng: ");

        jLabel6.setText("Ngày trả phòng: ");

        jLabel5.setText("Thành tiền: ");

        txtMaKM.setName("Mã khuyến mãi"); // NOI18N

        txtTKNV.setName("Tài khoản Nhân Viên"); // NOI18N

        txtCCCD.setName("CMND"); // NOI18N

        txtMaHoaDon.setName("Mã hóa đơn"); // NOI18N

        jLabel1.setText("Mã hóa đơn: ");

        jLabel3.setText("CMND/CCCD: ");

        jLabel2.setText("Tài khoản NV: ");

        jLabel4.setText("Mã Khuyến mãi: ");

>>>>>>> Stashed changes
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

<<<<<<< Updated upstream
=======
    private void tblHoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblHoaDonMouseClicked
        if (evt.getClickCount() == 2) {
            this.row = tblHoaDon.rowAtPoint(evt.getPoint()); //lấy vị trí dòng được chọn
            if (this.row >= 0) {
                this.edit();
            }
        }
    }//GEN-LAST:event_tblHoaDonMouseClicked

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
       if(utilityHelper.checkNullText(txtMaHoaDon)
               && utilityHelper.checkNullText(txtCCCD)
               && utilityHelper.checkNullText(txtMaKM)
               && utilityHelper.checkNullText(txtThanhTien)
               && utilityHelper.checkNullText(txtTKNV)){
           this.insert();
       }
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        this.delete();
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
         if(utilityHelper.checkNullText(txtMaHoaDon)
               && utilityHelper.checkNullText(txtCCCD)
               && utilityHelper.checkNullText(txtMaKM)
               && utilityHelper.checkNullText(txtThanhTien)
               && utilityHelper.checkNullText(txtTKNV)){
           this.update();
       }
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMoiActionPerformed
        this.clearForm();
    }//GEN-LAST:event_btnMoiActionPerformed

    private void btnDauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDauActionPerformed
        this.row=0;
        this.edit();
    }//GEN-LAST:event_btnDauActionPerformed

    private void btnTienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTienActionPerformed
        this.row--;
        this.edit();
    }//GEN-LAST:event_btnTienActionPerformed

    private void btnLuiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLuiActionPerformed
        this.row++;
        this.edit();
    }//GEN-LAST:event_btnLuiActionPerformed

    private void btnCuoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCuoiActionPerformed
        this.row = tblHoaDon.getRowCount() -1;
        this.edit();
    }//GEN-LAST:event_btnCuoiActionPerformed

>>>>>>> Stashed changes

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
