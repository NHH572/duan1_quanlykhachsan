/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.exemple.views;

import com.exemple.controller.KhachHangDAO;
import com.exemple.controller.KhuyenMaiDAO;
import com.exemple.controller.MailSender;
import com.exemple.entity.KhachHang;
import com.exemple.entity.KhuyenMai;
import com.exemple.helper.MsgBox;
import com.exemple.helper.utilityHelper;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.ThreadLocalRandom;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.apache.commons.lang3.RandomStringUtils;

/**
 *
 * @author Minh Triet
 */
public class QuanLyKhuyenMaiJPanel extends javax.swing.JPanel {

    int row = 0;
    KhuyenMaiDAO dao = new KhuyenMaiDAO();
    int index = 0; // vị trí của nhân viên đang hiển thị trên form 
    List<KhachHang> listGuiMaKhuyenMai = new ArrayList<>();

    public QuanLyKhuyenMaiJPanel() {
        initComponents();
        filtable();
    }

    private void setForm(KhuyenMai kh) {
        txtMaKhuyenMai.setText(kh.getMaKhuyenMai());
        txtTenKhuyenMai.setText(kh.getTenKhuyenMai());
        txtGiaTri.setText(String.valueOf(kh.getGiaTri()));
        txtNgayBatDau.setDate(kh.getNgayBatDau());
        txtNgayHenHan.setDate(kh.getNgayHetHan());
    }

    private KhuyenMai getModel() {
        KhuyenMai kh = new KhuyenMai();
        kh.setMaKhuyenMai(txtMaKhuyenMai.getText());
        kh.setTenKhuyenMai(txtTenKhuyenMai.getText());
        kh.setGiaTri(Integer.parseInt(txtGiaTri.getText()));
        kh.setNgayBatDau(txtNgayBatDau.getDate());
        kh.setNgayHetHan(txtNgayHenHan.getDate());
        return kh;
    }

    private void insert() {
        KhuyenMai kh = getModel();
        try {
            dao.insert(kh);
            this.filtable();
            this.clearForm();
            MsgBox.alert(this, "Thêm thành công");
        } catch (Exception e) {
            e.printStackTrace();
            MsgBox.alert(this, "Thêm thất bại");
        }

    }

    void edit() {
        try {
            String makh = (String) tblKhuyenMai.getValueAt(this.index, 0);
            String maKm2 = String.valueOf(makh);
            KhuyenMai model = dao.selectById(maKm2);
            if (model != null) {
                this.setForm(model);
//                this.updateStatus(false);
            }
        } catch (Exception e) {
            MsgBox.alert(this, "Lỗi truy vấn dữ liệu!");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtMaKhuyenMai = new javax.swing.JTextField();
        txtTenKhuyenMai = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtGiaTri = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtNgayBatDau = new com.toedter.calendar.JDateChooser();
        txtNgayHenHan = new com.toedter.calendar.JDateChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblKhuyenMai = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        btnMoi = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        btnSendMail = new javax.swing.JButton();

        setBackground(new java.awt.Color(204, 204, 204));

        jLabel1.setText("Mã khuyến mãi");

        txtMaKhuyenMai.setName("Mã khuyến mãi"); // NOI18N
        txtMaKhuyenMai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaKhuyenMaiActionPerformed(evt);
            }
        });

        txtTenKhuyenMai.setName("Tên khuyến mãi"); // NOI18N
        txtTenKhuyenMai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTenKhuyenMaiActionPerformed(evt);
            }
        });

        jLabel2.setText("Tên khuyến mãi");

        txtGiaTri.setName("Giá trị"); // NOI18N
        txtGiaTri.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtGiaTriActionPerformed(evt);
            }
        });

        jLabel3.setText("Giá trị");

        jLabel4.setText("Ngày bắt đầu");

        jLabel5.setText("Ngày hết hạn");

        txtNgayBatDau.setDateFormatString("dd/MM/yyyy");

        txtNgayHenHan.setDateFormatString("dd/MM/yyyy");

        tblKhuyenMai.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã khuyến mãi", "Tên khuyến mãi", "Giá trị", "Ngày bắt đầu", "Ngày hết hạn"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblKhuyenMai.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblKhuyenMaiMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblKhuyenMai);

        jPanel1.setLayout(new java.awt.GridLayout(1, 0, 5, 0));

        btnMoi.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnMoi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/exemple/icon/new.png"))); // NOI18N
        btnMoi.setText("Mới");
        btnMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMoiActionPerformed(evt);
            }
        });
        jPanel1.add(btnMoi);

        btnSua.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnSua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/exemple/icon/update.png"))); // NOI18N
        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });
        jPanel1.add(btnSua);

        btnXoa.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnXoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/exemple/icon/deleteService.png"))); // NOI18N
        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });
        jPanel1.add(btnXoa);

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/exemple/icon/add.png"))); // NOI18N
        jButton1.setText("Thêm");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 51, 204));
        jLabel6.setText("Quản Lý Khuyến Mãi");

        btnSendMail.setBackground(new java.awt.Color(255, 102, 51));
        btnSendMail.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/exemple/icon/send.png"))); // NOI18N
        btnSendMail.setText("Gửi mail chúc mừng sinh nhật");
        btnSendMail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSendMailActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(txtMaKhuyenMai, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addGap(10, 10, 10)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtGiaTri, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtTenKhuyenMai, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(69, 69, 69)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(txtNgayBatDau, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addComponent(txtNgayHenHan, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(290, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addGap(0, 653, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 411, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSendMail)
                .addGap(41, 41, 41))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(txtMaKhuyenMai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtNgayBatDau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(txtTenKhuyenMai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(txtNgayHenHan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtGiaTri, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnSendMail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE))
                .addGap(31, 31, 31))
        );
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
        if (utilityHelper.checkNullText(txtMaKhuyenMai)
                && utilityHelper.checkNullText(txtTenKhuyenMai)
                && utilityHelper.checkNullText(txtGiaTri) && utilityHelper.checkNumber(txtGiaTri)) {
            this.insert();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        delete();
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMoiActionPerformed
        clearForm();    }//GEN-LAST:event_btnMoiActionPerformed

    private void tblKhuyenMaiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblKhuyenMaiMouseClicked
//        int row = tblKhuyenMai.getSelectedRow();
//        this.edit();

        if (evt.getClickCount() == 2) {
            this.index = tblKhuyenMai.rowAtPoint(evt.getPoint());
            if (this.index >= 0) {
                this.edit();
//                tabs.setSelectedIndex(0);
            }
        }
    }//GEN-LAST:event_tblKhuyenMaiMouseClicked

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        // TODO add your handling code here:
        if (utilityHelper.checkNullText(txtMaKhuyenMai)
                && utilityHelper.checkNullText(txtGiaTri) && utilityHelper.checkNumber(txtGiaTri)
                && utilityHelper.checkNullText(txtTenKhuyenMai)) {
            this.update();
        }
    }//GEN-LAST:event_btnSuaActionPerformed
    private int getMonth(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int month = cal.get(Calendar.MONTH) + 1;
        return month;
    }

    private String getRamdomString(int soKyTu) {
        return RandomStringUtils.randomAlphanumeric(soKyTu).toUpperCase();
    }

    private String getRanDom2Number() {
        return String.valueOf(ThreadLocalRandom.current().nextInt(10, 99));
    }

    private void addToListGuiMaKhuyenMai() {
        KhachHangDAO khDAO = new KhachHangDAO();
        int thangHienTai = getMonth(new Date());
        if (thangHienTai == 12) {
            listGuiMaKhuyenMai = khDAO.selectDanhSachSinhNhatThang1();
        } else {
            listGuiMaKhuyenMai = khDAO.selectDanhSachSinhNhatKhacThang1();
        }
    }
    private void insertKhuyenMaiSinhNhat(String maKhuyenMai,int thangSinhNhat){
        KhuyenMai km = new KhuyenMai();
        km.setMaKhuyenMai(maKhuyenMai);
        km.setTenKhuyenMai("Chúc mừng sinh nhật");
        km.setGiaTri(200);
        Date ngayBatDau=new Date();
        ngayBatDau.setMonth(thangSinhNhat-1);
        ngayBatDau.setDate(1);
        km.setNgayBatDau(ngayBatDau);
        Date ngayHetHan=new Date();
        ngayHetHan.setMonth(thangSinhNhat-1);
        ngayHetHan.setDate(30);
        km.setNgayHetHan(ngayHetHan);
        
        KhuyenMaiDAO kmDAO=new KhuyenMaiDAO();
        kmDAO.insert(km);
    }
    private void sendMailToCustomers() {
        addToListGuiMaKhuyenMai();
        if (listGuiMaKhuyenMai.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Không có khách hàng nào sinh vào tháng " + getMonth(new Date()), "Thông báo", JOptionPane.CANCEL_OPTION);
            return;
        }
        String from = "quanlykhachsan1@gmail.com";
        for (KhachHang item : listGuiMaKhuyenMai) {
            try {
                Message msg = null;
                String maKhuyenMai = getRamdomString(4) + getRanDom2Number();
                insertKhuyenMaiSinhNhat(maKhuyenMai, getMonth(item.getNgaySinh()));
                String to = item.getEmail();
                String hoTen = item.getTenKhachHang();
                String subject = "CHÚC MỪNG SINH NHẬT " + hoTen;
                String body = "";
                body = "<h1>Xin chào"+hoTen+"</h1>" + "<br>"
                        + "<h1>Mã khuyến mãi là:" + maKhuyenMai + "</h1>" + "<br>"
                        + "<u>Đây là tag u</u>" + "<br>"
                        + "<i>Đây là tag i</i>";
                Properties p = new Properties();
                p.put("mail.smtp.auth", "true");
                p.put("mail.smtp.starttls.enable", "true");
                p.put("mail.smtp.host", "smtp.gmail.com");
                p.put("mail.smtp.port", 587);
                String accountName = "quanlykhachsan1@gmail.com";
                String accountPassword = "Aa123456@";
                Session s = Session.getInstance(p,
                        new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(accountName, accountPassword);
                    }
                });
                msg = new MimeMessage(s);
                msg.setFrom(new InternetAddress(from));
                msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
                msg.setSubject(subject);
                msg.setText(body);
                msg.setContent(body, "text/html; charset=utf-8");
//                Transport.send(msg);
                MailSender.queue((MimeMessage) msg);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        JOptionPane.showMessageDialog(null, "Gửi Email chúc mừng sinh nhật thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
    }
    private void btnSendMailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSendMailActionPerformed
        sendMailToCustomers();
        filtable();
    }//GEN-LAST:event_btnSendMailActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnMoi;
    private javax.swing.JButton btnSendMail;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnXoa;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblKhuyenMai;
    private javax.swing.JTextField txtGiaTri;
    private javax.swing.JTextField txtMaKhuyenMai;
    private com.toedter.calendar.JDateChooser txtNgayBatDau;
    private com.toedter.calendar.JDateChooser txtNgayHenHan;
    private javax.swing.JTextField txtTenKhuyenMai;
    // End of variables declaration//GEN-END:variables

    private void filtable() {
        DefaultTableModel model = (DefaultTableModel) tblKhuyenMai.getModel();
        model.setRowCount(0);
        try {
            List<KhuyenMai> list = dao.selectAll();
            for (KhuyenMai Km : list) {
                Object[] row = {
                    Km.getMaKhuyenMai(),
                    Km.getTenKhuyenMai(),
                    Km.getGiaTri(),
                    Km.getNgayBatDau(),
                    Km.getNgayHetHan()

                };
                model.addRow(row);
            }
        } catch (Exception e) {
            MsgBox.alert(this, "Lỗi truy vấn dữ liệu!");
        }
    }

    private void update() {
        KhuyenMai km = getModel();

        try {
            dao.update(km);
            this.filtable();
            MsgBox.alert(this, "Update thành công!");
        } catch (Exception e) {
            MsgBox.alert(this, "Update thất bại!");
        }
    }

    private void clearForm() {
        KhuyenMai Km = new KhuyenMai();
        this.setForm(Km);
        this.row = -1;
//        this.updateStatus();
    }

    private void delete() {
        if (MsgBox.confirm(this, "Bạn thực sự muốn xóa Khuyen Mai này?")) {
            String maKhuyenMai = txtMaKhuyenMai.getText();
            try {
                dao.delete(maKhuyenMai);
                this.filtable();
                this.clearForm();
                MsgBox.alert(this, "Xóa thành công!");
            } catch (Exception e) {
                MsgBox.alert(this, "Xóa thất bại!");
                System.out.println(e);
                e.printStackTrace();
            }

        }
    }
}
