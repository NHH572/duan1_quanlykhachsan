/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.exemple.views;

import com.exemple.controller.DoiTacDAO;
import com.exemple.entity.DoiTac;
import com.exemple.helper.Auth;
import com.exemple.helper.JdbcHelper;
import static com.exemple.helper.JdbcHelper.dburl;
import static com.exemple.helper.JdbcHelper.password;
import static com.exemple.helper.JdbcHelper.username;
import com.exemple.helper.MsgBox;
import com.exemple.helper.utilityHelper;
import static java.awt.Color.pink;
import static java.awt.Color.white;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Minh Triet
 */
public class QuanLyDoiTacJPanel extends javax.swing.JPanel {

    /**
     * Creates new form QuanLyDoiTacJPanel
     */
    public QuanLyDoiTacJPanel() {
        initComponents();
        fillTable();
        txt_SLHT.disable();
    }

    int index = 0;
    DoiTacDAO dao = new DoiTacDAO();

    void fillTable() {
        DefaultTableModel model = (DefaultTableModel) tbl_DoiTac.getModel();
        model.setRowCount(0);   //đưa số dòng về 0 (xóa bảng)
        try {
            List<DoiTac> list = dao.selectAll();   //lấy tất cả nhân viên trong CSDL đưa vào list
            for (DoiTac dt : list) {
                Object[] row = {
                    dt.getMaDoiTac(),
                    dt.getTenDoiTac(),
                    dt.getSoDienThoai(),
                    dt.getDanhGia()
                };
                model.addRow(row);
            }
        } catch (Exception e) {
            MsgBox.alert(this, "Lỗi truy vấn dữ liệu!");
            e.printStackTrace();
        }
    }

    void setForm(DoiTac model) {
        txt_MaDT.setText(model.getMaDoiTac());
        txt_TenDT.setText(model.getTenDoiTac());
        txt_SDT.setText(model.getSoDienThoai());
        txt_DanhGia.setText(model.getDanhGia());
    }

    //return nhanVien
    //lấy thông tin trên form cho vào đt nhanVien
    DoiTac getForm() {
        DoiTac model = new DoiTac();
        model.setMaDoiTac(txt_MaDT.getText());
        model.setTenDoiTac(txt_TenDT.getText());
        model.setSoDienThoai(txt_SDT.getText());  //chuyển char[] thành String
        model.setDanhGia(txt_DanhGia.getText());
        return model;
    }

    void clear() {
        this.setForm(new DoiTac());
    }

    void insert() {
        DoiTac model = getForm();
        try {
            dao.insert(model);
            this.fillTable();
            this.clear();
            MsgBox.alert(this, "Thêm mới thành công!");
        } catch (Exception e) {
            MsgBox.alert(this, "Thêm mới thất bại!");
        }
    }

    void update() {
        DoiTac model = getForm();
        try {
            dao.update(model);
            this.fillTable();
            this.clear();
            MsgBox.alert(this, "Cập nhật thành công!");
        } catch (Exception e) {
            MsgBox.alert(this, "Cập nhật thất bại!");
        }
    }

    void delete() {
        if (MsgBox.confirm(this, "Bạn có muốn xóa hay không?")) {
            String macd = txt_MaDT.getText();
            try {
                dao.delete(macd);
                this.fillTable();
                this.clear();
                MsgBox.alert(this, "Xóa thành công!");
            } catch (Exception e) {
                MsgBox.alert(this, "Xóa thất bại!");
            }
        }
    }

    public void setTrang() {
        txt_MaDT.setBackground(white);
        txt_TenDT.setBackground(white);
        txt_SDT.setBackground(white);
        txt_DanhGia.setBackground(white);
    }

    void edit() {
        setTrang();
        try {
            txt_SLHT.setText("0");
            index = tbl_DoiTac.getSelectedRow();
            if (index >= 0) {
                String madt = (String) tbl_DoiTac.getValueAt(this.index, 0);
                DoiTac model = dao.selectById(madt);
                if (model != null) {
                    this.setForm(model);

                }
                SoLanHopTac();

            }
        } catch (Exception e) {
            MsgBox.alert(this, "Lỗi truy vấn dữ liệu!");
        }
    }

    public void SoLanHopTac() {
        try {
            Connection con = DriverManager.getConnection(dburl, username, password);
            index = tbl_DoiTac.getSelectedRow();
            if (index >= 0) {
                String maDT = (String) tbl_DoiTac.getValueAt(this.index, 0);
                String sql = "select Count(kh.MaDoiTac) as SoLuong from HoaDon hd inner join KhachHang kh on hd.SoCMTKhachHang = kh.SoCMTKhachHang inner join DoiTac dt on kh.MaDoiTac = dt.MaDoiTac where kh.MaDoiTac = ? group by hd.SoCMTKhachHang";
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setString(1, maDT);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    txt_SLHT.setText(rs.getString("SoLuong"));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
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

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_DoiTac = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        txt_TenDT = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lbDG = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txt_DanhGia = new javax.swing.JTextArea();
        txt_MaDT = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txt_SDT = new javax.swing.JTextField();
        txt_SLHT = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        btn_Xoa = new javax.swing.JButton();
        btn_Them = new javax.swing.JButton();
        btn_Sua = new javax.swing.JButton();
        btn_Moi = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 51, 204));
        jLabel1.setText("QUẢN LÝ ĐỐI TÁC");

        tbl_DoiTac.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã đối tác", "Tên đối tác", "Số đt", "Đánh giá"
            }
        ));
        tbl_DoiTac.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_DoiTacMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_DoiTac);

        jLabel2.setText("Mã đối tác");

        txt_TenDT.setName("Tên đối tác"); // NOI18N

        jLabel3.setText("Tên đối tác");

        jLabel5.setText("Số lần hợp tác");

        lbDG.setText("Đánh giá");

        txt_DanhGia.setColumns(20);
        txt_DanhGia.setRows(5);
        txt_DanhGia.setName("Đánh giá"); // NOI18N
        jScrollPane2.setViewportView(txt_DanhGia);

        txt_MaDT.setName("Mã đối tác"); // NOI18N

        jLabel6.setText("Số điện thoại");

        txt_SDT.setName("Số điện thoại"); // NOI18N

        jPanel1.setLayout(new java.awt.GridLayout(1, 0, 5, 0));

        btn_Xoa.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btn_Xoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/exemple/icon/deleteService.png"))); // NOI18N
        btn_Xoa.setText("Xóa");
        btn_Xoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_XoaActionPerformed(evt);
            }
        });
        jPanel1.add(btn_Xoa);

        btn_Them.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btn_Them.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/exemple/icon/add.png"))); // NOI18N
        btn_Them.setText("Thêm");
        btn_Them.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ThemActionPerformed(evt);
            }
        });
        jPanel1.add(btn_Them);

        btn_Sua.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btn_Sua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/exemple/icon/update.png"))); // NOI18N
        btn_Sua.setText("Sửa");
        btn_Sua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_SuaActionPerformed(evt);
            }
        });
        jPanel1.add(btn_Sua);

        btn_Moi.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btn_Moi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/exemple/icon/new.png"))); // NOI18N
        btn_Moi.setText("Mới");
        btn_Moi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_MoiActionPerformed(evt);
            }
        });
        jPanel1.add(btn_Moi);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel5))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_SLHT, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_SDT, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_TenDT, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_MaDT, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(125, 125, 125)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 816, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(lbDG)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 219, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 792, Short.MAX_VALUE)
                            .addContainerGap())
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addGap(484, 636, Short.MAX_VALUE)))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(267, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_MaDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_TenDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_SDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txt_SLHT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbDG)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel1)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(368, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btn_ThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ThemActionPerformed
        if (utilityHelper.checkNullText(txt_MaDT) && utilityHelper.checkMaDoitac(txt_MaDT)
                && utilityHelper.checkNullText(txt_SDT) && utilityHelper.checkSDT(txt_SDT)
                && utilityHelper.checkNullText(txt_TenDT) && utilityHelper.checkName(txt_TenDT)
                && utilityHelper.checkNullText2(txt_DanhGia)) {
            this.insert();

        }

    }//GEN-LAST:event_btn_ThemActionPerformed

    private void tbl_DoiTacMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_DoiTacMouseClicked
        this.edit();
    }//GEN-LAST:event_tbl_DoiTacMouseClicked

    private void btn_XoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_XoaActionPerformed
        if (!Auth.user.isVaiTro()) {
            delete();
        } else {
            MsgBox.alert(this, "Chỉ trưởng phòng mới được phép xóa");
        }
    }//GEN-LAST:event_btn_XoaActionPerformed

    private void btn_SuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_SuaActionPerformed
        if (utilityHelper.checkNullText(txt_MaDT) && utilityHelper.checkMaDoitac(txt_MaDT)
                && utilityHelper.checkNullText(txt_SDT) && utilityHelper.checkSDT(txt_SDT)
                && utilityHelper.checkNullText(txt_TenDT) && utilityHelper.checkName(txt_TenDT)
                && utilityHelper.checkNullText2(txt_DanhGia)) {
            this.update();

        }
    }//GEN-LAST:event_btn_SuaActionPerformed

    private void btn_MoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_MoiActionPerformed
        this.clear();
    }//GEN-LAST:event_btn_MoiActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Moi;
    private javax.swing.JButton btn_Sua;
    private javax.swing.JButton btn_Them;
    private javax.swing.JButton btn_Xoa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbDG;
    private javax.swing.JTable tbl_DoiTac;
    private javax.swing.JTextArea txt_DanhGia;
    private javax.swing.JTextField txt_MaDT;
    private javax.swing.JTextField txt_SDT;
    private javax.swing.JTextField txt_SLHT;
    private javax.swing.JTextField txt_TenDT;
    // End of variables declaration//GEN-END:variables
}
