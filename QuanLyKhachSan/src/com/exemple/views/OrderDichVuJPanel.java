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
            hd.setMaPhong(maPhong);
            hd.setMaHoaDon(maHoaDon);
            hd.setMaDichVu( (int) tblDichVu.getValueAt(row, 0));
            hd.setSoLan(soLanThue);
            lthdDao.insertChiTietHoaDon(hd);
        }} catch (Exception e) {
            e.printStackTrace();
            MsgBox.alert(this, "Lỗi hệ thống");
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JPanel1 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        txtTenKhachHang1 = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        khach = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblKhachHang = new javax.swing.JTable();
        dichvu = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDichVu = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        txtSoPhong = new javax.swing.JTextField();

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
                false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblKhachHang);

        javax.swing.GroupLayout khachLayout = new javax.swing.GroupLayout(khach);
        khach.setLayout(khachLayout);
        khachLayout.setHorizontalGroup(
            khachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 751, Short.MAX_VALUE)
        );
        khachLayout.setVerticalGroup(
            khachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(khachLayout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 471, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(72, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("KHÁCH HÀNG", new javax.swing.ImageIcon(getClass().getResource("/com/exemple/icon/icons8_user_48px.png")), khach); // NOI18N

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

        javax.swing.GroupLayout dichvuLayout = new javax.swing.GroupLayout(dichvu);
        dichvu.setLayout(dichvuLayout);
        dichvuLayout.setHorizontalGroup(
            dichvuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dichvuLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(dichvuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 727, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dichvuLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        dichvuLayout.setVerticalGroup(
            dichvuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dichvuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(79, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("DỊCH VỤ", new javax.swing.ImageIcon(getClass().getResource("/com/exemple/icon/icons8_food_service_30px_1.png")), dichvu); // NOI18N

        txtSoPhong.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        txtSoPhong.setName("Số phòng"); // NOI18N
        txtSoPhong.addFocusListener(new java.awt.event.FocusAdapter() {
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
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
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
                .addContainerGap()
                .addComponent(JPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(JPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if(utilityHelper.checkNullText(txtSoPhong)&& utilityHelper.checkNullText(txtTenKhachHang1)){
            if(utilityHelper.checkNumber(txtSoPhong)&&utilityHelper.checkName(txtTenKhachHang1)){
                this.themDichVu();
            }
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtSoPhongFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSoPhongFocusLost
        int soPhong = Integer.parseInt(txtSoPhong.getText());
        fillTableKhachHang(soPhong);
        txtTenKhachHang1.setText(tenKhachHang);
    }//GEN-LAST:event_txtSoPhongFocusLost


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel JPanel1;
    private javax.swing.JPanel dichvu;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JPanel khach;
    private javax.swing.JTable tblDichVu;
    private javax.swing.JTable tblKhachHang;
    private javax.swing.JTextField txtSoPhong;
    private javax.swing.JTextField txtTenKhachHang1;
    // End of variables declaration//GEN-END:variables
}
