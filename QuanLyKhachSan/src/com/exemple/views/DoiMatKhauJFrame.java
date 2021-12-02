/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.exemple.views;

import com.exemple.controller.NhanVienDAO;
import com.exemple.entity.NhanVien;
import com.exemple.helper.Auth;
import com.exemple.helper.MsgBox;
import com.exemple.helper.utilityHelper;

/**
 *
 * @author Minh Triet
 */
public class DoiMatKhauJFrame extends javax.swing.JFrame {

    NhanVienDAO dao = new NhanVienDAO();

    public DoiMatKhauJFrame() {
        initComponents();
        if (Auth.user == null) {
            return;
        } else {
            txtTendangnhap.setText(Auth.user.getMaNV());
        }
        init();
    }
    

        
                ;

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtTendangnhap = new javax.swing.JTextField();
        txtMatkhau = new javax.swing.JPasswordField();
        txtMatkhauNew = new javax.swing.JPasswordField();
        txtXacnhanMK = new javax.swing.JPasswordField();
        btnHuy = new javax.swing.JButton();
        btnXacnhan = new javax.swing.JButton();
        chkHienmatkhau = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Đổi Mật Khẩu");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/exemple/icon/lock2.jpg"))); // NOI18N

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 0, 102));
        jLabel5.setText("ĐỔI MẬT KHẨU");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Tên đăng nhập");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Mật khẩu");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Mật khẩu mới");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Xác nhận mật khẩu");

        txtTendangnhap.setBackground(new java.awt.Color(204, 204, 204));
        txtTendangnhap.setName("Tên đăng nhập"); // NOI18N

        txtMatkhau.setBackground(new java.awt.Color(204, 204, 204));
        txtMatkhau.setName("Mật khẩu"); // NOI18N

        txtMatkhauNew.setBackground(new java.awt.Color(204, 204, 204));
        txtMatkhauNew.setName("Mật khẩu mới"); // NOI18N

        txtXacnhanMK.setBackground(new java.awt.Color(204, 204, 204));
        txtXacnhanMK.setName("Xác nhận mật khẩu"); // NOI18N
        txtXacnhanMK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtXacnhanMKActionPerformed(evt);
            }
        });

        btnHuy.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        btnHuy.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/exemple/icon/thoat.png"))); // NOI18N
        btnHuy.setText("Hủy");
        btnHuy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuyActionPerformed(evt);
            }
        });

        btnXacnhan.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        btnXacnhan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/exemple/icon/xacnhan.png"))); // NOI18N
        btnXacnhan.setText("Xác nhận");
        btnXacnhan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXacnhanActionPerformed(evt);
            }
        });

        chkHienmatkhau.setFont(new java.awt.Font("Tahoma", 3, 11)); // NOI18N
        chkHienmatkhau.setText("Hiện mật khẩu");
        chkHienmatkhau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkHienmatkhauActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(93, Short.MAX_VALUE)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(109, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtTendangnhap, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(txtMatkhauNew, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMatkhau, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(chkHienmatkhau)
                    .addComponent(txtXacnhanMK, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(102, 102, 102)
                .addComponent(btnXacnhan)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnHuy, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTendangnhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtMatkhau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtMatkhauNew, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtXacnhanMK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(chkHienmatkhau)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnXacnhan)
                    .addComponent(btnHuy))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 3, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public void clear() {
        txtTendangnhap.setText("");
        txtMatkhau.setText("");
        txtMatkhauNew.setText("");
        txtXacnhanMK.setText("");
    }

    public void DoiMK() {
        String manv = txtTendangnhap.getText();
        NhanVien nhanvien = dao.selectById(manv);
        Auth.user = nhanvien;
        String matkhau = new String(txtMatkhau.getPassword());
        String matkhauNew = new String(txtMatkhauNew.getPassword());
        String matkhauNew2 = new String(txtXacnhanMK.getPassword());
        if (!manv.equalsIgnoreCase(Auth.user.getMaNV())) {
            MsgBox.alert(this, "Sai tên đăng nhập !");
        } else if (!matkhau.equals(Auth.user.getMatKhau())) {
            MsgBox.alert(this, "Sai mật khẩu !");
        } else if (!matkhauNew.equals(matkhauNew2)) {
            MsgBox.alert(this, "Xác nhận mật khẩu không đứng !");
        } else {
            Auth.user.setMatKhau(matkhauNew);
            dao.update(Auth.user);
            MsgBox.alert(this, "Đổi mật khẩu thành công ");
            this.clear();
        }
    }
    private void btnXacnhanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXacnhanActionPerformed
        // TODO add your handling code here:
        if (utilityHelper.checkNullText(txtTendangnhap)
                && utilityHelper.checkNullPass(txtMatkhau)
                && utilityHelper.checkNullPass(txtMatkhauNew)
                && utilityHelper.checkNullPass(txtXacnhanMK)) {
            if (utilityHelper.checkPass(txtMatkhauNew)) {
                this.DoiMK();
            }
        }
    }//GEN-LAST:event_btnXacnhanActionPerformed

    private void btnHuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyActionPerformed
        // TODO add your handling code here:
        this.clear();
    }//GEN-LAST:event_btnHuyActionPerformed

    private void txtXacnhanMKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtXacnhanMKActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtXacnhanMKActionPerformed

    private void chkHienmatkhauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkHienmatkhauActionPerformed
        // TODO add your handling code here:
        if (chkHienmatkhau.isSelected()) {
            txtMatkhau.setEchoChar((char) 0);
            txtMatkhauNew.setEchoChar((char) 0);
            txtXacnhanMK.setEchoChar((char) 0);
        } else {
            txtMatkhau.setEchoChar('*');
            txtMatkhauNew.setEchoChar('*');
            txtXacnhanMK.setEchoChar('*');

        }
    }//GEN-LAST:event_chkHienmatkhauActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DoiMatKhauJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DoiMatKhauJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DoiMatKhauJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DoiMatKhauJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DoiMatKhauJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHuy;
    private javax.swing.JButton btnXacnhan;
    private javax.swing.JCheckBox chkHienmatkhau;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField txtMatkhau;
    private javax.swing.JPasswordField txtMatkhauNew;
    private javax.swing.JTextField txtTendangnhap;
    private javax.swing.JPasswordField txtXacnhanMK;
    // End of variables declaration//GEN-END:variables
}
