/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import com.exemple.controller.HoaDonDAO;
import com.exemple.entity.HoaDon;
import com.exemple.helper.MsgBox;
import java.awt.HeadlessException;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author hp
 */
public class Test extends javax.swing.JFrame {

    HoaDonDAO hddao = new HoaDonDAO();
    int row = 0;
    public Test() {
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtMaHoaDon = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jdcNgayNhanPhong = new com.toedter.calendar.JDateChooser();
        jdcNgayTraPhong = new com.toedter.calendar.JDateChooser();
        jdcNgayTao = new com.toedter.calendar.JDateChooser();
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
        txtCCCD = new javax.swing.JTextField();
        txtTKNV = new javax.swing.JTextField();
        txtMaKM = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Mã hóa đơn: ");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jLabel2.setText("Tài khoản NV: ");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, -1, -1));

        jLabel3.setText("CMND/CCCD: ");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, -1));

        jLabel4.setText("Mã Khuyến mãi: ");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, -1, -1));

        txtMaHoaDon.setName("mã khuyến mãi"); // NOI18N
        getContentPane().add(txtMaHoaDon, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 20, 260, -1));

        jLabel5.setText("Thành tiền: ");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 140, -1, -1));

        jLabel6.setText("Ngày trả phòng: ");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 100, -1, -1));

        jLabel7.setText("Ngày nhận phòng: ");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 60, -1, -1));

        jLabel8.setText("Ngày tạo: ");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 20, -1, -1));

        jdcNgayNhanPhong.setDateFormatString("dd-MM-yyyy hh:mm:ss");
        jdcNgayNhanPhong.setName("ngày nhận phòng"); // NOI18N
        getContentPane().add(jdcNgayNhanPhong, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 60, 250, -1));

        jdcNgayTraPhong.setDateFormatString("dd-MM-yyyy hh:mm:ss");
        jdcNgayTraPhong.setName("ngày trả phòng"); // NOI18N
        getContentPane().add(jdcNgayTraPhong, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 100, 250, -1));

        jdcNgayTao.setDateFormatString("dd-MM-yyyy hh:mm:ss");
        jdcNgayTao.setName("ngày tạo"); // NOI18N
        getContentPane().add(jdcNgayTao, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 20, 250, -1));

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

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 175, 910, 308));

        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });
        getContentPane().add(btnThem, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 501, -1, -1));

        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });
        getContentPane().add(btnXoa, new org.netbeans.lib.awtextra.AbsoluteConstraints(113, 501, -1, -1));

        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });
        getContentPane().add(btnSua, new org.netbeans.lib.awtextra.AbsoluteConstraints(206, 501, -1, -1));

        btnMoi.setText("Mới");
        btnMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMoiActionPerformed(evt);
            }
        });
        getContentPane().add(btnMoi, new org.netbeans.lib.awtextra.AbsoluteConstraints(299, 501, -1, -1));

        btnDau.setText("<|");
        btnDau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDauActionPerformed(evt);
            }
        });
        getContentPane().add(btnDau, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 500, -1, -1));

        btnTien.setText("<<");
        btnTien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTienActionPerformed(evt);
            }
        });
        getContentPane().add(btnTien, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 500, -1, -1));

        btnLui.setText(">>");
        btnLui.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLuiActionPerformed(evt);
            }
        });
        getContentPane().add(btnLui, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 500, -1, -1));

        btnCuoi.setText("|>");
        btnCuoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCuoiActionPerformed(evt);
            }
        });
        getContentPane().add(btnCuoi, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 500, -1, -1));

        txtThanhTien.setName("mã khuyến mãi"); // NOI18N
        getContentPane().add(txtThanhTien, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 140, 250, -1));

        txtCCCD.setName("mã khuyến mãi"); // NOI18N
        getContentPane().add(txtCCCD, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 60, 260, -1));

        txtTKNV.setName("mã khuyến mãi"); // NOI18N
        getContentPane().add(txtTKNV, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 100, 260, -1));

        txtMaKM.setName("mã khuyến mãi"); // NOI18N
        getContentPane().add(txtMaKM, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 140, 260, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        this.insert();
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        this.delete();
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        this.update();
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

    private void tblHoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblHoaDonMouseClicked
        if (evt.getClickCount() == 2) {
            this.row = tblHoaDon.rowAtPoint(evt.getPoint()); //lấy vị trí dòng được chọn
            if (this.row >= 0) {
                this.edit();
            }
        }
    }//GEN-LAST:event_tblHoaDonMouseClicked

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
            java.util.logging.Logger.getLogger(Test.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Test.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Test.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Test.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Test().setVisible(true);
            }
        });
    }

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
