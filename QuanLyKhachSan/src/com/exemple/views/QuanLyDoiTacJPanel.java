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
    public void SoLanHopTac(){  
        try {
            Connection con=DriverManager.getConnection(dburl, username, password);
            index = tbl_DoiTac.getSelectedRow();
            if (index >= 0) {
             String maDT = (String) tbl_DoiTac.getValueAt(this.index, 0);
            String sql = "select Count(kh.MaDoiTac) as SoLuong from HoaDon hd inner join KhachHang kh on hd.SoCMTKhachHang = kh.SoCMTKhachHang inner join DoiTac dt on kh.MaDoiTac = dt.MaDoiTac where kh.MaDoiTac = ? group by hd.SoCMTKhachHang";       
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, maDT);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
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

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_DoiTac = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        txt_TenDT = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btn_Them = new javax.swing.JButton();
        btn_Xoa = new javax.swing.JButton();
        btn_Sua = new javax.swing.JButton();
        lbDG = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txt_DanhGia = new javax.swing.JTextArea();
        txt_MaDT = new javax.swing.JTextField();
        btn_Moi = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        txt_SDT = new javax.swing.JTextField();
        txt_SLHT = new javax.swing.JTextField();

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("QUẢN LÝ ĐỐI TÁC");

        tbl_DoiTac.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
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

        btn_Them.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btn_Them.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/exemple/icon/add.png"))); // NOI18N
        btn_Them.setText("Thêm");
        btn_Them.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ThemActionPerformed(evt);
            }
        });

        btn_Xoa.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btn_Xoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/exemple/icon/deleteService.png"))); // NOI18N
        btn_Xoa.setText("Xóa");
        btn_Xoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_XoaActionPerformed(evt);
            }
        });

        btn_Sua.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btn_Sua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/exemple/icon/update.png"))); // NOI18N
        btn_Sua.setText("Sửa");
        btn_Sua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_SuaActionPerformed(evt);
            }
        });

        lbDG.setText("Đánh giá");

        txt_DanhGia.setColumns(20);
        txt_DanhGia.setRows(5);
        txt_DanhGia.setName("Đánh giá"); // NOI18N
        jScrollPane2.setViewportView(txt_DanhGia);

        txt_MaDT.setName("Mã đối tác"); // NOI18N

        btn_Moi.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btn_Moi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/exemple/icon/new.png"))); // NOI18N
        btn_Moi.setText("Mới");
        btn_Moi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_MoiActionPerformed(evt);
            }
        });

        jLabel6.setText("Số điện thoại");

        txt_SDT.setName("Số điện thoại"); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(220, 220, 220)
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(78, 78, 78)
                .addComponent(btn_Them)
                .addGap(18, 18, 18)
                .addComponent(btn_Xoa)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_Sua)
                .addGap(18, 18, 18)
                .addComponent(btn_Moi)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(lbDG)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(64, 64, 64)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_MaDT, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
                            .addComponent(txt_TenDT))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txt_SLHT, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                                .addComponent(txt_SDT, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(24, 24, 24))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(txt_MaDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel6)
                    .addComponent(txt_SDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txt_TenDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txt_SLHT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(6, 6, 6)))
                .addGap(9, 9, 9)
                .addComponent(lbDG)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_Them)
                    .addComponent(btn_Xoa)
                    .addComponent(btn_Sua)
                    .addComponent(btn_Moi))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btn_ThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ThemActionPerformed
  if(utilityHelper.checkNullText(txt_MaDT)
               && utilityHelper.checkNullText(txt_SDT)
               && utilityHelper.checkNullText(txt_TenDT)
               && utilityHelper.checkNullText2(txt_DanhGia)){
           if(utilityHelper.checkMaDoitac(txt_MaDT)
                   && utilityHelper.checkName(txt_TenDT)
                   && utilityHelper.checkSDT(txt_SDT)){
               this.insert();
           }
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
          if(utilityHelper.checkNullText(txt_MaDT)
               && utilityHelper.checkNullText(txt_SDT)
               && utilityHelper.checkNullText(txt_TenDT)
               && utilityHelper.checkNullText2(txt_DanhGia)){
           if(utilityHelper.checkMaDoitac(txt_MaDT)
                   && utilityHelper.checkName(txt_TenDT)
                   && utilityHelper.checkSDT(txt_SDT)){
               this.update();
           }
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
