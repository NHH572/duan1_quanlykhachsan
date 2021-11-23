/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.exemple.views;

import com.exemple.controller.HoaDonDAO;
import com.exemple.entity.HoaDon;
import com.exemple.helper.MsgBox;
import com.exemple.helper.utilityHelper;
import java.awt.HeadlessException;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Minh Triet
 */
public class QuanLyHoaDonJPanel extends javax.swing.JPanel {

    HoaDonDAO hddao = new HoaDonDAO();
    int row = 0;
    public QuanLyHoaDonJPanel() {
        initComponents();
        init();
    }
void init(){
        fillToTable();
    }
HoaDon getModel(){
        HoaDon hd = new HoaDon();
        hd.setCMND_CCCD(txtCCCD.getText());
        hd.setMaHoaDon(Integer.parseInt(txtMaHoaDon.getText()));
        hd.setMaKhuyenMai(txtMaKM.getText());
        hd.setNgayNhanPhong(jdcNgayNhanPhong.getDate());
        hd.setNgayTao(jdcNgayTao.getDate());
        hd.setNgayTraPhong(jdcNgayNhanPhong.getDate());
        hd.setTaiKhoanNV(txtTKNV.getText());
        hd.setThanhToan(Float.parseFloat(txtThanhTien.getText()));
        return hd;
    }
    
    void setModel(HoaDon hd){
        txtCCCD.setText(hd.getCMND_CCCD());
        txtMaHoaDon.setText(String.valueOf(hd.getMaHoaDon()));
        txtMaKM.setText(hd.getMaKhuyenMai());
        txtTKNV.setText(hd.getTaiKhoanNV());
        txtThanhTien.setText(String.valueOf(hd.getThanhToan()));
        jdcNgayNhanPhong.setDate(hd.getNgayNhanPhong());
        jdcNgayTao.setDate(hd.getNgayTao());
        jdcNgayTraPhong.setDate(hd.getNgayTraPhong());
        }
    private void fillToTable(){
        DefaultTableModel model = (DefaultTableModel) tblHoaDon.getModel();
        model.setRowCount(0);
        try {
            List<HoaDon> list = hddao.selectAll();
        for (HoaDon hd : list) {
            Object [] row ={
                hd.getMaHoaDon(),
                hd.getCMND_CCCD(),
                hd.getTaiKhoanNV(),
                hd.getNgayTao(),
                hd.getNgayNhanPhong(),
                hd.getNgayTraPhong(),
                hd.getMaKhuyenMai(),
                hd.getThanhToan()
            };
            model.addRow(row);
        }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    private void insert() {
        HoaDon kh = getModel();
        try {
            hddao.insert(kh);
            this.fillToTable();
            this.clearForm();
            MsgBox.alert(this, "Thêm thành công");
        } catch (Exception e) {
            e.printStackTrace();
            MsgBox.alert(this, "Thêm thất bại");
        }
    }
    private void update() {
        HoaDon kh = getModel();
        try {
            hddao.update(kh);
            this.fillToTable();
            this.clearForm();
            MsgBox.alert(this, "Sửa thành công");
        } catch (Exception e) {
            MsgBox.alert(this, "Sửa thất bại");
        }
    }

    private void delete() {
        if (MsgBox.confirm(this, "Bạn thực sự muốn xóa người học này?")) {
            int mahd = Integer.parseInt(txtMaHoaDon.getText());
            String mahd2 = String.valueOf(mahd);
            try {
                hddao.delete(mahd2);
                this.fillToTable();
                this.clearForm();
                MsgBox.alert(this, "Xóa thành công!");
            } catch (HeadlessException e) {
                MsgBox.alert(this, "Xóa thất bại!");
            }
        }
    }
    
    
    private void clearForm(){
        HoaDon hd = new HoaDon();
        this.setModel(hd);
        updateStatus(true);
        jdcNgayNhanPhong.setCalendar(null);
        jdcNgayTao.setCalendar(null);
        jdcNgayTraPhong.setCalendar(null);
        txtThanhTien.setText("");
        txtMaHoaDon.setText("");
    }
    void edit() {
        try {
            Integer makh = (Integer) tblHoaDon.getValueAt(this.row, 0);
            String manv2 = String.valueOf(makh);
            HoaDon model = hddao.selectById(manv2);
            if (model != null) {
                this.setModel(model);
                this.updateStatus(false);
            }
        } catch (Exception e) {
            MsgBox.alert(this, "Lỗi truy vấn dữ liệu!");
        }
    }
    
    void updateStatus(boolean insertable) {
        txtMaHoaDon.setEnabled(insertable);
        btnThem.setEnabled(insertable);
        btnSua.setEnabled(!insertable);
        btnXoa.setEnabled(!insertable);
        boolean first = this.row > 0;
        boolean last = this.row < tblHoaDon.getRowCount() - 1;
        btnDau.setEnabled(!insertable && first);
        btnTien.setEnabled(!insertable && first);
        btnLui.setEnabled(!insertable && last);
        btnCuoi.setEnabled(!insertable && last);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

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

        txtTKNV.setName("Tài khoản"); // NOI18N

        txtCCCD.setName("CMND"); // NOI18N

        txtMaHoaDon.setName("Mã hóa đơn"); // NOI18N

        jLabel1.setText("Mã hóa đơn: ");

        jLabel3.setText("CMND/CCCD: ");

        jLabel2.setText("Tài khoản NV: ");

        jLabel4.setText("Mã Khuyến mãi: ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 912, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addGap(40, 40, 40)
                            .addComponent(txtMaHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(160, 160, 160)
                            .addComponent(jLabel8)
                            .addGap(66, 66, 66)
                            .addComponent(jdcNgayTao, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(34, 34, 34)
                            .addComponent(txtCCCD, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(160, 160, 160)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(20, 20, 20)
                            .addComponent(jdcNgayNhanPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addGap(34, 34, 34)
                            .addComponent(txtTKNV, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(160, 160, 160)
                            .addComponent(jLabel6)
                            .addGap(31, 31, 31)
                            .addComponent(jdcNgayTraPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(23, 23, 23)
                            .addComponent(txtMaKM, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(160, 160, 160)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(59, 59, 59)
                            .addComponent(txtThanhTien, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 910, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(btnThem)
                            .addGap(21, 21, 21)
                            .addComponent(btnXoa)
                            .addGap(21, 21, 21)
                            .addComponent(btnSua)
                            .addGap(21, 21, 21)
                            .addComponent(btnMoi)
                            .addGap(209, 209, 209)
                            .addComponent(btnDau)
                            .addGap(28, 28, 28)
                            .addComponent(btnTien)
                            .addGap(18, 18, 18)
                            .addComponent(btnLui)
                            .addGap(18, 18, 18)
                            .addComponent(btnCuoi)))
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 558, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel1)
                        .addComponent(txtMaHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel8)
                        .addComponent(jdcNgayTao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel3)
                        .addComponent(txtCCCD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel7)
                        .addComponent(jdcNgayNhanPhong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel2)
                        .addComponent(txtTKNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel6)
                        .addComponent(jdcNgayTraPhong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel4)
                        .addComponent(txtMaKM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5)
                        .addComponent(txtThanhTien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(13, 13, 13)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(17, 17, 17)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btnDau)
                        .addComponent(btnTien)
                        .addComponent(btnLui)
                        .addComponent(btnCuoi)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(1, 1, 1)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(btnThem)
                                .addComponent(btnXoa)
                                .addComponent(btnSua)
                                .addComponent(btnMoi))))
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCuoi;
    private javax.swing.JButton btnDau;
    private javax.swing.JButton btnLui;
    private javax.swing.JButton btnMoi;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnTien;
    private javax.swing.JButton btnXoa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private com.toedter.calendar.JDateChooser jdcNgayNhanPhong;
    private com.toedter.calendar.JDateChooser jdcNgayTao;
    private com.toedter.calendar.JDateChooser jdcNgayTraPhong;
    private javax.swing.JTable tblHoaDon;
    private javax.swing.JTextField txtCCCD;
    private javax.swing.JTextField txtMaHoaDon;
    private javax.swing.JTextField txtMaKM;
    private javax.swing.JTextField txtTKNV;
    private javax.swing.JTextField txtThanhTien;
    // End of variables declaration//GEN-END:variables
}
