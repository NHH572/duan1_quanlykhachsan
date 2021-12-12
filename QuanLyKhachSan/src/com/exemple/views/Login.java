/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.exemple.views;

import com.exemple.controller.KhachHangDAO;
import com.exemple.controller.MailSender;
import com.exemple.controller.NhanVienDAO;
import com.exemple.entity.GuiMailMaKhuyenMai;
import com.exemple.entity.KhachHang;
import com.exemple.entity.NhanVien;
import com.exemple.helper.Auth;
import com.exemple.helper.MsgBox;
import com.exemple.helper.utilityHelper;
import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author philong
 */
public class Login extends javax.swing.JFrame {

    String txtUser = "Enter UserName";
    String txtPassword = "Enter password";

    void init() {
        setLocationRelativeTo(null);
        setTitle("ĐĂNG NHẬP HỆ THỐNG");
        this.getRootPane().setDefaultButton(btnDangNhap);
    }

    public Login() {
        initComponents();
//         super(parent, modal);
        init();
        placeHolder(txtTendangnhap, txtUser);
        placeHolder(txtMatkhau, txtPassword);
    }

    private void placeHolder(JTextField txtFiled, String text) {
        txtFiled.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (txtFiled.getText().equals(text)) {
                    txtFiled.setText("");
                    txtFiled.setForeground(Color.white);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (txtFiled.getText().isEmpty()) {
                    txtFiled.setForeground(new Color(102, 102, 102));
                    txtFiled.setText(text);
                }
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtMatkhau = new javax.swing.JPasswordField();
        btnQRCode = new javax.swing.JButton();
        btnDangNhap = new javax.swing.JButton();
        btnThoat = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        txtTendangnhap = new javax.swing.JTextField();
        chkHienMatKhau = new javax.swing.JCheckBox();
        lblQuenMatKhau = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtMatkhau.setBackground(new java.awt.Color(0, 0, 0));
        txtMatkhau.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        txtMatkhau.setForeground(new java.awt.Color(153, 153, 153));
        txtMatkhau.setText("123456");
        txtMatkhau.setBorder(null);
        txtMatkhau.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtMatkhauKeyPressed(evt);
            }
        });
        jPanel1.add(txtMatkhau, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 193, 390, 30));

        btnQRCode.setBackground(new java.awt.Color(255, 255, 255));
        btnQRCode.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnQRCode.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/exemple/icon/qr.png"))); // NOI18N
        btnQRCode.setText("QR code");
        btnQRCode.setBorder(null);
        btnQRCode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQRCodeActionPerformed(evt);
            }
        });
        jPanel1.add(btnQRCode, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 340, -1, 40));

        btnDangNhap.setBackground(new java.awt.Color(255, 255, 255));
        btnDangNhap.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnDangNhap.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/exemple/icon/dangnhap.png"))); // NOI18N
        btnDangNhap.setText("Login");
        btnDangNhap.setBorder(null);
        btnDangNhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDangNhapActionPerformed(evt);
            }
        });
        jPanel1.add(btnDangNhap, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 340, 80, 40));

        btnThoat.setBackground(new java.awt.Color(255, 255, 255));
        btnThoat.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnThoat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/exemple/icon/thoat.png"))); // NOI18N
        btnThoat.setText("Exit");
        btnThoat.setBorder(null);
        btnThoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThoatActionPerformed(evt);
            }
        });
        jPanel1.add(btnThoat, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 340, 90, 40));

        jSeparator1.setBackground(new java.awt.Color(102, 102, 102));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 140, 470, 10));

        jSeparator2.setBackground(new java.awt.Color(102, 102, 102));
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 250, 470, 10));

        txtTendangnhap.setBackground(new java.awt.Color(0, 0, 0));
        txtTendangnhap.setFont(new java.awt.Font("Berlin Sans FB", 0, 18)); // NOI18N
        txtTendangnhap.setForeground(new java.awt.Color(102, 102, 102));
        txtTendangnhap.setText("hvanh");
        txtTendangnhap.setBorder(null);
        txtTendangnhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTendangnhapActionPerformed(evt);
            }
        });
        txtTendangnhap.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtTendangnhapKeyPressed(evt);
            }
        });
        jPanel1.add(txtTendangnhap, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 100, 390, 30));

        chkHienMatKhau.setBackground(new java.awt.Color(0, 0, 0));
        chkHienMatKhau.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        chkHienMatKhau.setForeground(new java.awt.Color(255, 255, 255));
        chkHienMatKhau.setText("Show password");
        chkHienMatKhau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkHienMatKhauActionPerformed(evt);
            }
        });
        jPanel1.add(chkHienMatKhau, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 290, 150, 30));

        lblQuenMatKhau.setFont(new java.awt.Font("Tahoma", 2, 14)); // NOI18N
        lblQuenMatKhau.setForeground(new java.awt.Color(255, 255, 255));
        lblQuenMatKhau.setText("Forgot password?");
        lblQuenMatKhau.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblQuenMatKhauMouseClicked(evt);
            }
        });
        jPanel1.add(lblQuenMatKhau, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 390, 170, 30));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("PASSWORD");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 160, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("USER NAME");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 70, -1, -1));

        jLabel4.setText("WELCOM TO HOTEL");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 60, 110, 30));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/exemple/icon/den_2.jpg"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 0, 490, 600));

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/exemple/icon/khachsan_sigin.png"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 380, 520));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/exemple/icon/xanhtroi.png"))); // NOI18N
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 0, 440, 600));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 907, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
public void dangnhap() {
        String manv = txtTendangnhap.getText();
        String matKhau = new String(txtMatkhau.getPassword());
        try {
            NhanVienDAO dao = new NhanVienDAO();
            NhanVien nhanVien = dao.selectById(manv);
            if (nhanVien != null) {
                String matKhau2 = nhanVien.getMatKhau();
                if (matKhau.equals(matKhau2)) {
                    Auth.user = nhanVien;
                    MsgBox.alert(this, "Đăng nhập thành công!");
                    this.dispose();
                    
                    new TrangChuJrame().setVisible(true);
                    
                } else {
                    MsgBox.alert(this, "Sai mật khẩu!");
                }
            } else {
                MsgBox.alert(this, "Sai tên đăng nhập!");
            }
        } catch (Exception e) {
            MsgBox.alert(this, "Lỗi truy vấn dữ liệu!");
            e.printStackTrace();
        }
    }

    private void dangNhap() {
        if (utilityHelper.checkNullText(txtTendangnhap)
                && utilityHelper.checkNullPass(txtMatkhau)) {
            this.dangnhap();
        }
    }
    private void btnDangNhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDangNhapActionPerformed
        dangNhap();
    }//GEN-LAST:event_btnDangNhapActionPerformed

    private void btnThoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThoatActionPerformed
        if (MsgBox.confirm(this, "Bạn có muốn thoát khỏi ứng dụng không?")) {
            System.exit(0);
        }
    }//GEN-LAST:event_btnThoatActionPerformed

    private void txtMatkhauKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMatkhauKeyPressed
        setEventPressEnter(evt);
    }//GEN-LAST:event_txtMatkhauKeyPressed

    private void chkHienMatKhauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkHienMatKhauActionPerformed
        if (chkHienMatKhau.isSelected()) {
            txtMatkhau.setEchoChar((char) 0);
        } else {
            txtMatkhau.setEchoChar('*');
        }
    }//GEN-LAST:event_chkHienMatKhauActionPerformed

    private void lblQuenMatKhauMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblQuenMatKhauMouseClicked
        new QuenMatKhauJDialog(this, true).setVisible(true);
    }//GEN-LAST:event_lblQuenMatKhauMouseClicked

    private void txtTendangnhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTendangnhapActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTendangnhapActionPerformed

    private void setEventPressEnter(java.awt.event.KeyEvent evt) {
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            dangNhap();
        }
    }
    private void txtTendangnhapKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTendangnhapKeyPressed
        setEventPressEnter(evt);
    }//GEN-LAST:event_txtTendangnhapKeyPressed

    private void btnQRCodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQRCodeActionPerformed
        new QRLogin().setVisible(true);
    }//GEN-LAST:event_btnQRCodeActionPerformed
//    private void getThangHienTai(){
//        Date date = new Date();
//        LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
//        int month = localDate.getMonthValue();
//    }
//    private void sendMailToCustomers() {
//        KhachHangDAO khDAO=new KhachHangDAO();
//        List<KhachHang> listKH=khDAO.selectAll();
//        for(KhachHang item:listKH){
//            
//        }
//        List<GuiMailMaKhuyenMai> listGuiMaKhuyenMai = new ArrayList<>();
//        listGuiMaKhuyenMai.add(new GuiMailMaKhuyenMai("abc", "trietpnmps17263@fpt.edu.vn", true, "Mã Khuyến Mãi"));
//        if (listGuiMaKhuyenMai.size() == 0) {
//            JOptionPane.showMessageDialog(this, "Thêm 1 địa chỉ Email muốn gửi!", "Thông báo", JOptionPane.CANCEL_OPTION);
//            return;
//        }
//        String from = "quanlykhachsan1@gmail.com";
//
//        int count = 0;
//        for (GuiMailMaKhuyenMai item : listGuiMaKhuyenMai) {
//            try {
//                Message msg = null;
//                String to = item.getEmail();
//                String hoTen = item.getHoTen();
//                String subject = "CHÚC MỪNG SINH NHẬT " + hoTen;
//                String body = "";
//                String maKhuyenMai = item.getMaKhuyenMai();
//
//                body = "CHÚC MỪNG SINH NHẬT " + hoTen
//                        + "\nPullman SaiGon Centre chúc bạn tuổi mới cầu gì được nấy, thần thái bừng bừng, luôn vui, luôn khỏe, may mắn vây quanh!"
//                        + "\nĐể kỷ niệm dịp đặc biệt này Pullman SaiGon Centre xin gửi tặng bạn"
//                        + "\nMã khuyến mãi:" + item.getMaKhuyenMai()
//                        + "\nThời hạn Khuyến mãi: 01/08/2020 - 31/08/2020"
//                        + "\n*Nếu có bất kỳ thay đổi nào, Pullman SaiGon Centre sẽ thông báo đến bạn trong thời gian sớm nhất."
//                        + "\nChúng tôi mong bạn cùng gia đình luôn giữ gìn sức khỏe trong giai đoạn mùa “Cô Vy” này và cảm ơn bạn đã luôn đồng hành cùng Pullman SaiGon Centre!";
//                Properties p = new Properties();
//                p.put("mail.smtp.auth", "true");
//                p.put("mail.smtp.starttls.enable", "true");
//                p.put("mail.smtp.host", "smtp.gmail.com");
//                p.put("mail.smtp.port", 587);
//                String accountName = "quanlykhachsan1@gmail.com";
//                String accountPassword = "Aa123456@";
//                Session s = Session.getInstance(p,
//                        new javax.mail.Authenticator() {
//                    protected PasswordAuthentication getPasswordAuthentication() {
//                        return new PasswordAuthentication(accountName, accountPassword);
//                    }
//                });
//                msg = new MimeMessage(s);
//                msg.setFrom(new InternetAddress(from));
//                msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
//                msg.setSubject(subject);
//                msg.setText(body);
////                Transport.send(msg);
//                MailSender.queue((MimeMessage) msg);
//                count++;
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//        JOptionPane.showMessageDialog(null, "Gửi Email thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
//    }

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDangNhap;
    private javax.swing.JButton btnQRCode;
    private javax.swing.JButton btnThoat;
    private javax.swing.JCheckBox chkHienMatKhau;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lblQuenMatKhau;
    private javax.swing.JPasswordField txtMatkhau;
    private javax.swing.JTextField txtTendangnhap;
    // End of variables declaration//GEN-END:variables

}
