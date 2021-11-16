/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.exemple.views;

import com.exemple.controller.DichVuDAO;
import com.exemple.entity.DichVu;
import com.exemple.helper.MsgBox;
import java.awt.Color;
import java.util.List;
import java.util.concurrent.ForkJoinTask;
import javax.swing.JEditorPane;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Minh Triet
 */
public class QuanLyDichVuJPanel extends javax.swing.JPanel {

    int row = -1;

    public QuanLyDichVuJPanel() {
        initComponents();
        init();
    }

    void init() {
        fillToTable();
    }

    private void fillToTable() {
        DefaultTableModel model = (DefaultTableModel) tblDichVu.getModel();
        model.setRowCount(0);
        DichVuDAO dvDAO = new DichVuDAO();
        List<DichVu> list = dvDAO.selectAll();
        for (DichVu dv : list) {
            Object[] row = {
                dv.getMaDichVu(),
                dv.getTenDichVu(),
                dv.getGiaDichVu(),
                dv.getMoTa()};
            model.addRow(row);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDichVu = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtMoTa = new javax.swing.JEditorPane();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtTenDichVu = new javax.swing.JTextField();
        txtGiaDichVu = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        btnMoi = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnThem = new javax.swing.JButton();

        setLayout(new java.awt.GridBagLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 51, 204));
        jLabel1.setText("QUẢN LÝ DỊCH VỤ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(11, 29, 0, 0);
        add(jLabel1, gridBagConstraints);

        tblDichVu.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tblDichVu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã dịch vụ ", "Tên dịch vụ", "Giá", "Mô tả"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true
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

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 9;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 734;
        gridBagConstraints.ipady = 135;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(11, 25, 0, 10);
        add(jScrollPane1, gridBagConstraints);

        jPanel1.setLayout(new java.awt.GridLayout(1, 0, 5, 5));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        add(jPanel1, gridBagConstraints);

        txtMoTa.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        txtMoTa.setName("Mô tả"); // NOI18N
        jScrollPane2.setViewportView(txtMoTa);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("Tên");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setText("Mô tả");

        txtTenDichVu.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        txtTenDichVu.setName("Tên dịch vụ"); // NOI18N
        txtTenDichVu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTenDichVuActionPerformed(evt);
            }
        });

        txtGiaDichVu.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        txtGiaDichVu.setName("Giá dịch vụ"); // NOI18N

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("Giá");

        btnMoi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/exemple/icon/new.png"))); // NOI18N
        btnMoi.setText("Mới");
        btnMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMoiActionPerformed(evt);
            }
        });

        btnXoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/exemple/icon/deleteService.png"))); // NOI18N
        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btnSua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/exemple/icon/update.png"))); // NOI18N
        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/exemple/icon/add.png"))); // NOI18N
        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jLabel3))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel5)))
                .addGap(23, 23, 23)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txtTenDichVu, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(67, 67, 67)
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(txtGiaDichVu, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 699, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnThem)
                .addGap(5, 5, 5)
                .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(btnMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(189, 189, 189))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jLabel3))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(txtGiaDichVu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGap(26, 26, 26)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtTenDichVu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel4)))))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(141, 141, 141))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnThem)
                    .addComponent(btnSua)
                    .addComponent(btnXoa)
                    .addComponent(btnMoi))
                .addContainerGap())
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 9;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 10, 0, 10);
        add(jPanel2, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void txtTenDichVuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTenDichVuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTenDichVuActionPerformed
    private String getTextFromTable(int col) {
        return String.valueOf(tblDichVu.getValueAt(row, col));
    }

    private void showInformation() {
        txtTenDichVu.setText(getTextFromTable(1));
        txtGiaDichVu.setText(getTextFromTable(2));
        txtMoTa.setText(getTextFromTable(3));
    }
    private void tblDichVuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDichVuMouseClicked
        row = tblDichVu.getSelectedRow();
        if (row >= 0) {
            showInformation();
        }
    }//GEN-LAST:event_tblDichVuMouseClicked
    private void clearText() {
        txtTenDichVu.setText("");
        txtGiaDichVu.setText("");
        txtMoTa.setText("");
    }
    private void btnMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMoiActionPerformed
        clearText();
    }//GEN-LAST:event_btnMoiActionPerformed
    private boolean checkNullTextFiled(JTextField txt) {
        if (txt.getText().trim().length() > 0) {
            txt.setBackground(Color.white);
            return true;
        } else {
            txt.setBackground(Color.pink);
            MsgBox.alert(this, "Không được để trống " + txt.getName() + "!");
            return false;
        }
    }

    private boolean checkNullEditorPane(JEditorPane txt) {
        if (txt.getText().trim().length() > 0) {
            txt.setBackground(Color.white);
            return true;
        } else {
            txt.setBackground(Color.pink);
            MsgBox.alert(this, "Không được để trống " + txt.getName() + "!");
            return false;
        }
    }
    private boolean checkNumber(JTextField txt){
        try{
            Float.parseFloat(txt.getText());
            return true;
        }catch(Exception e){
            return false;
        }
    }
    private boolean checkPrice() {
        if(checkNumber(txtGiaDichVu)){
            if (Float.parseFloat(txtGiaDichVu.getText()) > 0) {
            txtGiaDichVu.setBackground(Color.white);
            return true;
        } else {
            txtGiaDichVu.setBackground(Color.pink);
            MsgBox.alert(this, txtGiaDichVu.getName() + " phải lớn hơn 0!");
            return false;
        }
        }else{
            txtGiaDichVu.setBackground(Color.pink);
            MsgBox.alert(this, txtGiaDichVu.getName() + " phải là số!");
            return false;
            
        }
        
    }

    private boolean insertDichVu() {
        try {
            DichVuDAO dvDAO = new DichVuDAO();
            DichVu dv = new DichVu();
            dv.setTenDichVu(txtTenDichVu.getText());
            dv.setGiaDichVu(Float.valueOf(txtGiaDichVu.getText()));
            dv.setMoTa(txtMoTa.getText());
            dvDAO.insert(dv);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        if (checkNullTextFiled(txtTenDichVu) && checkNullTextFiled(txtGiaDichVu) && checkNullEditorPane(txtMoTa)) {
            if (checkPrice()) {
                if (insertDichVu()) {
                    fillToTable();
                    MsgBox.alert(this, "Thêm thành công!");
                } else {
                    MsgBox.alert(this, "Thêm thất bại!");
                }
            }
        }

    }//GEN-LAST:event_btnThemActionPerformed
    private boolean updateDichVu() {
        try {
            DichVuDAO dvDAO = new DichVuDAO();
            DichVu dv = new DichVu();
            int maDichVu = (int) tblDichVu.getValueAt(row, 0);
            dv.setMaDichVu(maDichVu);
            dv.setTenDichVu(txtTenDichVu.getText());
            dv.setGiaDichVu(Float.valueOf(txtGiaDichVu.getText()));
            dv.setMoTa(txtMoTa.getText());
            dvDAO.update(dv);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        if (updateDichVu()) {
            fillToTable();
            MsgBox.alert(this, "Sửa thành công!");
        } else {
            MsgBox.alert(this, "Sửa thất bại!");
        }
    }//GEN-LAST:event_btnSuaActionPerformed
    private boolean deleteDichVu() {
        try {
            DichVuDAO dvDAO = new DichVuDAO();
            int maDichVu = (int) tblDichVu.getValueAt(row, 0);
            dvDAO.delete(maDichVu);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        if (deleteDichVu()) {
            if (MsgBox.confirm(this, "Bạn có muốn xóa không?")) {
                fillToTable();
                clearText();
                MsgBox.alert(this, "Xóa thành công!");
            }
        } else {
            MsgBox.alert(this, "Xóa thất bại!");
        }
    }//GEN-LAST:event_btnXoaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnMoi;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblDichVu;
    private javax.swing.JTextField txtGiaDichVu;
    private javax.swing.JEditorPane txtMoTa;
    private javax.swing.JTextField txtTenDichVu;
    // End of variables declaration//GEN-END:variables
}
