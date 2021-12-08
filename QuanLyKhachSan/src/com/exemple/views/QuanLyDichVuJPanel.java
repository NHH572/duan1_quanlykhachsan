/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.exemple.views;

import com.exemple.controller.DichVuDAO;
import com.exemple.entity.DichVu;
import com.exemple.helper.MsgBox;
import com.exemple.helper.utilityHelper;
import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.ArrayList;
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
    String textSearch = "Nhập tên dịch vụ cần tìm...";

    public QuanLyDichVuJPanel() {
        initComponents();
        init();
    }

    void init() {
        fillToTable();
        placeHolder(txtSearch, textSearch);
    }

    private void placeHolder(JTextField txtFiled, String text) {
        txtFiled.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (txtFiled.getText().equals(text)) {
                    txtFiled.setText("");
                    txtFiled.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (txtFiled.getText().isEmpty()) {
                    txtFiled.setForeground(Color.GRAY);
                    txtFiled.setText(text);
                }
            }
        });
    }

    private void fillToTable() {
        DefaultTableModel model = (DefaultTableModel) tblDichVu.getModel();
        model.setRowCount(0);
        DichVuDAO dvDAO = new DichVuDAO();
        List<DichVu> list = null;
        if (txtSearch.getText().equalsIgnoreCase(textSearch)) {
            list = dvDAO.selectAll();
        } else {
            String tenDichVu = txtSearch.getText();
            list = dvDAO.selectSearch(tenDichVu);
        }
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

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
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
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnMoi = new javax.swing.JButton();
        txtSearch = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 51, 204));
        jLabel1.setText("QUẢN LÝ DỊCH VỤ");

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

        jPanel1.setLayout(new java.awt.GridLayout(1, 0, 5, 5));

        jPanel2.setLayout(new java.awt.GridBagLayout());

        txtMoTa.setName("Mô tả"); // NOI18N
        jScrollPane2.setViewportView(txtMoTa);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 489;
        gridBagConstraints.ipady = 69;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(18, 10, 11, 10);
        jPanel2.add(jScrollPane2, gridBagConstraints);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("Tên");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(28, 15, 0, 0);
        jPanel2.add(jLabel3, gridBagConstraints);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setText("Mô tả");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 10, 0, 0);
        jPanel2.add(jLabel5, gridBagConstraints);

        txtTenDichVu.setName("Tên dịch vụ"); // NOI18N
        txtTenDichVu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTenDichVuActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 4;
        gridBagConstraints.ipadx = 201;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(26, 23, 0, 0);
        jPanel2.add(txtTenDichVu, gridBagConstraints);

        txtGiaDichVu.setName("Giá dịch vụ"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 3;
        gridBagConstraints.ipadx = 222;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(24, 28, 0, 10);
        jPanel2.add(txtGiaDichVu, gridBagConstraints);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("Giá");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(26, 18, 0, 0);
        jPanel2.add(jLabel4, gridBagConstraints);

        btnThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/exemple/icon/add.png"))); // NOI18N
        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnSua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/exemple/icon/update.png"))); // NOI18N
        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnXoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/exemple/icon/deleteService.png"))); // NOI18N
        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btnMoi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/exemple/icon/new.png"))); // NOI18N
        btnMoi.setText("Mới");
        btnMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMoiActionPerformed(evt);
            }
        });

        txtSearch.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        txtSearch.setForeground(new java.awt.Color(102, 102, 102));
        txtSearch.setText("Nhập tên dịch vụ cần tìm...");
        txtSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearchActionPerformed(evt);
            }
        });
        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtSearchKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addGap(283, 283, 283)
                            .addComponent(jLabel1))
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addGap(32, 32, 32)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 665, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 665, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(96, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addGap(158, 158, 158)
                            .addComponent(btnThem)
                            .addGap(5, 5, 5)
                            .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(5, 5, 5)
                            .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(5, 5, 5)
                            .addComponent(btnMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(250, 250, 250)))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1)
                .addGap(10, 10, 10)
                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(77, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(422, 422, 422)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btnThem)
                        .addComponent(btnSua)
                        .addComponent(btnXoa)
                        .addComponent(btnMoi))
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        jTabbedPane1.addTab("Quản lý", jPanel3);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 744, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 502, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Đặt", jPanel4);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 749, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
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

    private void clearForm() {
        txtTenDichVu.setText("");
        txtGiaDichVu.setText("");
        txtMoTa.setText("");
        txtTenDichVu.setBackground(Color.white);
        txtGiaDichVu.setBackground(Color.white);
        txtMoTa.setBackground(Color.white);
    }
    private void btnMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMoiActionPerformed
        clearForm();
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

    private boolean checkNumber(JTextField txt) {
        try {
            Float.parseFloat(txt.getText());
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private boolean checkPrice() {
        if (checkNumber(txtGiaDichVu)) {
            if (Float.parseFloat(txtGiaDichVu.getText()) > 0) {
                txtGiaDichVu.setBackground(Color.white);
                return true;
            } else {
                txtGiaDichVu.setBackground(Color.pink);
                MsgBox.alert(this, txtGiaDichVu.getName() + " phải lớn hơn 0!");
                return false;
            }
        } else {
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
        if (checkNullTextFiled(txtTenDichVu) && checkNullTextFiled(txtGiaDichVu)&&utilityHelper.checkNumber(txtGiaDichVu) && checkNullEditorPane(txtMoTa)) {
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
                clearForm();
                MsgBox.alert(this, "Xóa thành công!");
            }
        } else {
            MsgBox.alert(this, "Xóa thất bại!");
        }
    }//GEN-LAST:event_btnXoaActionPerformed

    private void txtSearchKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyPressed

    }//GEN-LAST:event_txtSearchKeyPressed

    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased
        fillToTable();
        clearForm();
    }//GEN-LAST:event_txtSearchKeyReleased

    private void txtSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearchActionPerformed


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
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable tblDichVu;
    private javax.swing.JTextField txtGiaDichVu;
    private javax.swing.JEditorPane txtMoTa;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txtTenDichVu;
    // End of variables declaration//GEN-END:variables
}
