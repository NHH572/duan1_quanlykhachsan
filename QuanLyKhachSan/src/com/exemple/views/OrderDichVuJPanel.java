/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.exemple.views;

import com.exemple.controller.DichVuDAO;
import com.exemple.controller.LoadTableHoaDonDAO;
import com.exemple.controller.OrderDichVuDAO;
import com.exemple.controller.PhongDAO;
import com.exemple.entity.DichVu;
import com.exemple.entity.HoaDonLoadTable;
import com.exemple.helper.MsgBox;
import com.exemple.helper.utilityHelper;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Minh Triet
 */
public class OrderDichVuJPanel extends javax.swing.JPanel {

   int row =0;
    PhongDAO pdao = new PhongDAO();
    DichVuDAO dvdao = new DichVuDAO();
    LoadTableHoaDonDAO lthdDao = new LoadTableHoaDonDAO();
    OrderDichVuDAO oddvdao = new OrderDichVuDAO();
    String tenKhachHang ;
    int maHoaDon;
    int maPhong ;
    int madichvu;
    int soLanThue;
    public OrderDichVuJPanel() {
        initComponents();
        loadToTable();
    }

   void loadToTable() {
        DefaultTableModel model = (DefaultTableModel) tblDichVu.getModel();
        model.setRowCount(0);
        List<DichVu> list = dvdao.selectAll();
        for (int i = 0; i < list.size(); i++) {
            DichVu dv = list.get(i);
            model.addRow(new Object[]{dv.getMaDichVu(), dv.getTenDichVu(), dv.getGiaDichVu(), dv.getMoTa()});
        }
    }

    void fillTableKhachHang(int soPhong) {
        DefaultTableModel model = (DefaultTableModel) tblKhachHang.getModel();
        model.setRowCount(0);
        List<HoaDonLoadTable> list = lthdDao.selectBySoPhong1(soPhong);
        int i = 1;
        for (HoaDonLoadTable hd : list) {
            tenKhachHang = hd.getTenKhachHang();
            maPhong=hd.getMaPhong();
            maHoaDon = hd.getMaHoaDon();
            madichvu = hd.getMaDichVu();
            soLanThue = hd.getSoLan();
            Object[] row = {
                i,
                hd.getMaDichVu(),
                hd.getTenDichVu(),
                hd.getSoLan(),
                hd.getGiaDichVu()
            };
            i++;
            model.addRow(row);
        }
    }
    
    void themDichVu(){
        try {
        for(int row :tblDichVu.getSelectedRows()){
            HoaDonLoadTable hd = new HoaDonLoadTable();
            String soLuong = txtSoLuong.getText();
            if(soLuong.equals("")){
              hd.setSoLan(soLanThue);
            }
            else{
                hd.setSoLan(Integer.parseInt(txtSoLuong.getText()));
            }
            hd.setMaPhong(maPhong);
            hd.setMaHoaDon(maHoaDon);
            hd.setMaDichVu( (int) tblDichVu.getValueAt(row, 0));
            
            lthdDao.insertChiTietHoaDon(hd);
        }} catch (Exception e) {
            e.printStackTrace();
            MsgBox.alert(this, "Lỗi hệ thống");
        }
    }
    
    void removeDichVuKhachHang(){
            int soPhong = Integer.parseInt(txtSoPhong.getText());
            if(MsgBox.confirm(this, "Bạn muốn xóa các học viên được chọn ?")){
                for(int row : tblKhachHang.getSelectedRows()){
                    int maDichVu = (Integer) tblKhachHang.getValueAt(row, 1);
                    oddvdao.delete(maDichVu,soPhong);
                }
            }
            this.fillTableKhachHang(soPhong);
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        JPanel1 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        txtTenKhachHang1 = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        khach = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblKhachHang = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDichVu = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtSoLuong = new javax.swing.JTextField();
        btnXoa = new javax.swing.JButton();
        txtSoPhong = new javax.swing.JTextField();

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("ORDER DỊCH VỤ");

        jLabel14.setText("Tên Khách Hàng");

        txtTenKhachHang1.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        txtTenKhachHang1.setName("Tên khách hàng"); // NOI18N

        jLabel16.setText("Số Phòng");

        tblKhachHang.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        tblKhachHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "STT", "Mã dịch vụ", "Tên dịch vụ", "Số lượng ", "Giá"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, true, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblKhachHang);

        tblDichVu.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        tblDichVu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Mã dịch vụ", "Tên dịch vụ", "Giá dịch vụ", "Số lần"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblDichVu);

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/exemple/icon/add.png"))); // NOI18N
        jButton1.setText("THÊM");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setText("SỐ LƯỢNG : ");

        txtSoLuong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSoLuongActionPerformed(evt);
            }
        });

        btnXoa.setText("XÓA");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout khachLayout = new javax.swing.GroupLayout(khach);
        khach.setLayout(khachLayout);
        khachLayout.setHorizontalGroup(
            khachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(khachLayout.createSequentialGroup()
                .addGroup(khachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 466, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addGroup(khachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(khachLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(10, 10, 10)
                        .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 495, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        khachLayout.setVerticalGroup(
            khachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(khachLayout.createSequentialGroup()
                .addGroup(khachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 459, Short.MAX_VALUE)
                    .addComponent(jScrollPane2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addGroup(khachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(khachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(txtSoLuong, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jButton1, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel2))
                    .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jTabbedPane1.addTab("KHÁCH HÀNG", new javax.swing.ImageIcon(getClass().getResource("/com/exemple/icon/icons8_user_48px.png")), khach); // NOI18N

        txtSoPhong.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        txtSoPhong.setName("Số phòng"); // NOI18N
        txtSoPhong.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtSoPhongFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtSoPhongFocusLost(evt);
            }
        });

        javax.swing.GroupLayout JPanel1Layout = new javax.swing.GroupLayout(JPanel1);
        JPanel1.setLayout(JPanel1Layout);
        JPanel1Layout.setHorizontalGroup(
            JPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel16)
                .addGap(18, 18, 18)
                .addComponent(txtSoPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel14)
                .addGap(38, 38, 38)
                .addComponent(txtTenKhachHang1, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(79, 79, 79))
            .addComponent(jTabbedPane1)
        );
        JPanel1Layout.setVerticalGroup(
            JPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPanel1Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(JPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(txtTenKhachHang1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16)
                    .addComponent(txtSoPhong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 605, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(423, 423, 423)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(JPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(JPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 12, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if(utilityHelper.checkNullText(txtSoPhong)&& utilityHelper.checkNullText(txtTenKhachHang1)){
            if(utilityHelper.checkNumber(txtSoPhong)&&utilityHelper.checkName(txtTenKhachHang1)){
                this.themDichVu();
                int soPhong =Integer.parseInt(txtSoPhong.getText());
                this.fillTableKhachHang(soPhong);
            }
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtSoLuongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSoLuongActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSoLuongActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        this.removeDichVuKhachHang();
    }//GEN-LAST:event_btnXoaActionPerformed

    private void txtSoPhongFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSoPhongFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSoPhongFocusGained

    private void txtSoPhongFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSoPhongFocusLost
        int soPhong = Integer.parseInt(txtSoPhong.getText());
        fillTableKhachHang(soPhong);
        txtTenKhachHang1.setText(tenKhachHang);
    }//GEN-LAST:event_txtSoPhongFocusLost


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel JPanel1;
    private javax.swing.JButton btnXoa;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JPanel khach;
    private javax.swing.JTable tblDichVu;
    private javax.swing.JTable tblKhachHang;
    private javax.swing.JTextField txtSoLuong;
    private javax.swing.JTextField txtSoPhong;
    private javax.swing.JTextField txtTenKhachHang1;
    // End of variables declaration//GEN-END:variables
}
