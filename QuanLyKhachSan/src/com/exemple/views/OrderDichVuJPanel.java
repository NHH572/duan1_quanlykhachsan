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
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Minh Triet
 */
public class OrderDichVuJPanel extends javax.swing.JPanel {

    int row = 0;
    PhongDAO pdao = new PhongDAO();
    DichVuDAO dvdao = new DichVuDAO();
    LoadTableHoaDonDAO lthdDao = new LoadTableHoaDonDAO();
    OrderDichVuDAO oddvdao = new OrderDichVuDAO();
    String tenKhachHang;
    int maHoaDon;
    int maPhong;
    int madichvu;
    int soLanThue;
    int maChiTietHoaDon = -1;
    int rowDichVu = -1;
    boolean statusUpdate=true;
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
        if (list.isEmpty()) {
            HoaDonLoadTable hd = lthdDao.selectBySoPhong4(soPhong);
            tenKhachHang = hd.getTenKhachHang();
            maPhong = hd.getMaPhong();
            maHoaDon = hd.getMaHoaDon();
            maChiTietHoaDon = hd.getMaChiTietHoaDon();
        } else {
            int i = 1;
            for (HoaDonLoadTable hd : list) {
                tenKhachHang = hd.getTenKhachHang();
                maPhong = hd.getMaPhong();
                maHoaDon = hd.getMaHoaDon();
                madichvu = hd.getMaDichVu();
                soLanThue = hd.getSoLan();
                Object[] row = {
                    hd.getMaChiTietHoaDon(),
                    hd.getMaDichVu(),
                    hd.getTenDichVu(),
                    hd.getSoLan(),
                    hd.getGiaDichVu()
                };
                i++;
                model.addRow(row);
            }
        }

    }

    private boolean checkNumber(String number) {
        try {
            Integer.parseInt(number);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    void themDichVu2() {
        HoaDonLoadTable hd = new HoaDonLoadTable();
        if (rowDichVu == -1) {
            JOptionPane.showMessageDialog(this, "Chọn 1 dịch vụ!");
            return;
        } else {
            hd.setMaDichVu(Integer.parseInt(tblDichVu.getValueAt(rowDichVu, 0).toString()));
        }
        if (!checkNumber(txtSoLuong.getText())) {
            JOptionPane.showMessageDialog(this, "Số lần thuê phải là số");
            return;
        } else {
            if (Integer.parseInt(txtSoLuong.getText()) <= 0) {
                JOptionPane.showMessageDialog(this, "Số lần thuê phải lớn hơn 0");
                return;
            } else {
                hd.setSoLan(Integer.parseInt(txtSoLuong.getText()));
            }
        }
        if(maChiTietHoaDon!=-1){
            hd.setMaChiTietHoaDon(maChiTietHoaDon);
        }
        LoadTableHoaDonDAO dao = new LoadTableHoaDonDAO();
        dao.updateChiTietHoaDon2(hd);
        statusUpdate=false;
    }

    void themDichVu() {
        try {
            for (int row : tblDichVu.getSelectedRows()) {
                HoaDonLoadTable hd = new HoaDonLoadTable();
                String soLuong = txtSoLuong.getText();
                if (soLuong.equals("")) {
                    hd.setSoLan(soLanThue);
                } else {
                    hd.setSoLan(Integer.parseInt(txtSoLuong.getText()));
                }
                hd.setMaPhong(maPhong);
                hd.setMaHoaDon(maHoaDon);
                hd.setMaDichVu((int) tblDichVu.getValueAt(row, 0));

                lthdDao.insertChiTietHoaDon(hd);
            }
        } catch (Exception e) {
            e.printStackTrace();
            MsgBox.alert(this, "Lỗi hệ thống");
        }
    }

    void removeDichVuKhachHang() {
        int soPhong = Integer.parseInt(txtSoPhong.getText());
        if (MsgBox.confirm(this, "Bạn muốn xóa các học viên được chọn ?")) {
            for (int row : tblKhachHang.getSelectedRows()) {
                int maDichVu = (Integer) tblKhachHang.getValueAt(row, 1);
                oddvdao.delete(maDichVu, soPhong);
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
        btnThemDichVu = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtSoLuong = new javax.swing.JTextField();
        btnXoa = new javax.swing.JButton();
        txtSoPhong = new javax.swing.JTextField();

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 51, 204));
        jLabel1.setText("ORDER DỊCH VỤ");

        jLabel14.setText("Tên Khách Hàng");

        txtTenKhachHang1.setEditable(false);
        txtTenKhachHang1.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        txtTenKhachHang1.setName("Tên khách hàng"); // NOI18N

        jLabel16.setText("Số Phòng");

        tblKhachHang.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        tblKhachHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã chi tiết hóa đơn", "Mã dịch vụ", "Tên dịch vụ", "Số lượng ", "Giá"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblKhachHang);

        tblDichVu.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        tblDichVu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

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
        tblDichVu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDichVuMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblDichVu);

        btnThemDichVu.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnThemDichVu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/exemple/icon/add.png"))); // NOI18N
        btnThemDichVu.setText("THÊM");
        btnThemDichVu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemDichVuActionPerformed(evt);
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
                .addContainerGap()
                .addGroup(khachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(khachLayout.createSequentialGroup()
                        .addGap(0, 367, Short.MAX_VALUE)
                        .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2))
                .addGap(16, 16, 16)
                .addGroup(khachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(khachLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(10, 10, 10)
                        .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnThemDichVu, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 495, Short.MAX_VALUE)))
        );
        khachLayout.setVerticalGroup(
            khachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(khachLayout.createSequentialGroup()
                .addGroup(khachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 459, Short.MAX_VALUE)
                    .addComponent(jScrollPane2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addGroup(khachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(khachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(txtSoLuong, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btnThemDichVu, javax.swing.GroupLayout.Alignment.LEADING)
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
            .addComponent(JPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

    private void btnThemDichVuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemDichVuActionPerformed
        if (utilityHelper.checkNullText(txtSoPhong) && utilityHelper.checkNullText(txtTenKhachHang1)) {
            if (utilityHelper.checkNumber(txtSoPhong) && utilityHelper.checkName(txtTenKhachHang1)) {
                int soPhong = Integer.parseInt(txtSoPhong.getText());
                if (statusUpdate) {
                    this.themDichVu2();
                } else {
                    for(int i=0;i<tblKhachHang.getRowCount();i++){
                        int maDichVuBangKhachHang=Integer.parseInt(tblKhachHang.getValueAt(i, 1).toString());
                        int maDichVuBangDichVu=Integer.parseInt(tblDichVu.getValueAt(rowDichVu, 0).toString());
                        if(maDichVuBangDichVu==maDichVuBangKhachHang){
                            HoaDonLoadTable hd=new HoaDonLoadTable();                            
                            int maChiTietHoaDon=Integer.parseInt(tblKhachHang.getValueAt(i, 0).toString());
                            hd.setMaChiTietHoaDon(maChiTietHoaDon);
                            int soLanThue=Integer.parseInt(tblKhachHang.getValueAt(i, 3).toString())+Integer.parseInt(txtSoLuong.getText());
                            hd.setSoLan(soLanThue);
                            new LoadTableHoaDonDAO().updateChiTietHoaDon3(hd);
                            fillTableKhachHang(soPhong);
                            return;
                        }
                    }
                    this.themDichVu();
                    
                }
                this.fillTableKhachHang(soPhong);
            }
        }

    }//GEN-LAST:event_btnThemDichVuActionPerformed

    private void txtSoLuongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSoLuongActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSoLuongActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        this.removeDichVuKhachHang();
    }//GEN-LAST:event_btnXoaActionPerformed

    private void txtSoPhongFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSoPhongFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSoPhongFocusGained
    private boolean checkSoPhong(String number) {
        try {
            Integer.parseInt(number);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    private void txtSoPhongFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSoPhongFocusLost
        if (!checkSoPhong(txtSoPhong.getText())) {
            return;
        }
        int soPhong = Integer.parseInt(txtSoPhong.getText());
        fillTableKhachHang(soPhong);
        txtTenKhachHang1.setText(tenKhachHang);
    }//GEN-LAST:event_txtSoPhongFocusLost

    private void tblDichVuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDichVuMouseClicked
        rowDichVu = tblDichVu.getSelectedRow();
    }//GEN-LAST:event_tblDichVuMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel JPanel1;
    private javax.swing.JButton btnThemDichVu;
    private javax.swing.JButton btnXoa;
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
