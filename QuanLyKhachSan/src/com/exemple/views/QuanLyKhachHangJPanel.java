/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.exemple.views;

import com.exemple.controller.DoiTacDAO;
import com.exemple.controller.KhachHangDAO;
import com.exemple.entity.KhachHang;
import com.exemple.helper.MsgBox;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import com.exemple.helper.utilityHelper;

/**
 *
 * @author Minh Triet
 */
public class QuanLyKhachHangJPanel extends javax.swing.JPanel {

    KhachHangDAO dao = new KhachHangDAO();
    int index = 0;  // vị trí của nhân viên đang hiển thị trên form 
    int row = 0;
    DoiTacDAO dtdao = new DoiTacDAO();

    public QuanLyKhachHangJPanel() {
        initComponents();
        filltable();
    }

    private void filltable() {
        DefaultTableModel model = (DefaultTableModel) tblKhachHang.getModel();
        model.setRowCount(0);

        try {

            List<KhachHang> list = dao.selectAll();
            for (KhachHang Kh : list) {
                Object[] row = {
                    Kh.getCMND(),
                    Kh.getTenKhachHang(),
                    Kh.getNgaySinh(),
                    Kh.isGioiTinh() ? "Nam" : "Nữ",
                    Kh.getSoDienThoai(),
                    Kh.getEmail(),
                    Kh.getQuocTich(),
                    Kh.getSoLanThue(),
                    Kh.getMaDoiTac()

                };
                model.addRow(row);
            }
        } catch (Exception e) {
            MsgBox.alert(this, "Lỗi truy vấn dữ liệu!");
            e.printStackTrace();
        }
    }

    public void setForm(KhachHang kh) {
        txtSoCmt.setText(kh.getCMND());
        txtTenKhachHang.setText(kh.getTenKhachHang());
        txtNgaySinh.setDate(kh.getNgaySinh());
        rdNam.setSelected(kh.isGioiTinh());
        rdNu.setSelected(!kh.isGioiTinh());
        txtSdt.setText(kh.getSoDienThoai());
        txtEmail.setText(kh.getEmail());
        txtQuocTich.setText(kh.getQuocTich());
        txtSolanThue.setText(String.valueOf(kh.getSoLanThue()));
        txtMaDoiTac.setText(kh.getMaDoiTac());

        Integer i = Integer.valueOf(txtSolanThue.getText());
        if (i == 0) {
            lblKhachHang.setText("Khách vãng lai");
        } else if (0 < i && i < 5) {
            lblKhachHang.setText("Khách hàng tiềm năng");
        } else {
            lblKhachHang.setText("Khách VIP");
        }

    }

    public void clearForm() {
        KhachHang kh = new KhachHang();
        this.setForm(kh);
        lblKhachHang.setText("");
        this.row = -1;
        updateStatus();
    }

    KhachHang getForm() {
        KhachHang model = new KhachHang();
        model.setCMND(txtSoCmt.getText());
        model.setTenKhachHang(txtTenKhachHang.getText());
        model.setNgaySinh(txtNgaySinh.getDate());
        if (rdNam.isSelected()) {
            model.setGioiTinh(rdNam.isSelected());
        } else if (rdNu.isSelected()) {
            model.setGioiTinh(rdNu.isSelected());
        }
        model.setSoDienThoai(txtSdt.getText());
        model.setEmail(txtEmail.getText());
        model.setQuocTich(txtQuocTich.getText());        
        model.setSoLanThue(0);
        model.setMaDoiTac(txtMaDoiTac.getText());
        return model;
    }

    void updateStatus() {
        boolean edit = (this.row >= 0);
        boolean first = (this.row == 0);
        boolean last = (this.row == tblKhachHang.getRowCount() - 1);
        txtSoCmt.setEditable(!edit);
        btnThem.setEnabled(!edit);
        btnSua.setEnabled(edit);
        btnXoa.setEnabled(edit);
        btnFirst.setEnabled(edit && !first);
        btnPrev.setEnabled(edit && !first);
        btnNext.setEnabled(edit && !last);
        btnLast.setEnabled(edit && !last);
    }

    public void edit() {
        String soCMT = (String) tblKhachHang.getValueAt(this.row, 0);
        String soCMT2 = String.valueOf(soCMT);
        KhachHang model = dao.selectById(soCMT2);
        if (model != null) {
            this.setForm(model);
            updateStatus();
        }
    }

//    public void fillComboBoxDoiTac() {
//        DefaultComboBoxModel model = (DefaultComboBoxModel) cboDoiTac.getModel();
//          model.removeAllElements();
//        List<DoiTac> list = dtdao.selectAll();
//        for (DoiTac dt : list) {
//            model.addElement(dt);
//        }
//    }
//    public void selectComBobox() {
//        try {  
//            DoiTac doiTac = (DoiTac) cboDoiTac.getSelectedItem();
//            txtMaDoiTac.setText(doiTac.getMaDoiTac());
//            this.row = -1;
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//    }
    public void Insert() {
        KhachHang kh = getForm();
        try {
            if(txtMaDoiTac.getText().isEmpty()){
                dao.insertKhongMaDoiTac(kh);
            }else{
                dao.insert(kh);
            }            
            this.filltable();
            this.clearForm();
            MsgBox.alert(this, "Thêm mới thành công");
        } catch (Exception e) {
            MsgBox.alert(this, "Thêm mới thất bại ");
            e.printStackTrace();
        }

    }

    public void Delete() {
        if (MsgBox.confirm(this, "Bạn có muốn xóa hay không?")) {
            String soCMT = txtSoCmt.getText();
            try {
                dao.delete(soCMT);
                this.filltable();
                this.clearForm();
                MsgBox.alert(this, "Xóa thành công!");
            } catch (Exception e) {
                MsgBox.alert(this, "Xóa thất bại!");
            }
        }
    }

    void update() {
        KhachHang model = getForm();
        try {
            dao.update(model);
            this.filltable();
            this.clearForm();
            MsgBox.alert(this, "Cập nhật thành công!");
        } catch (Exception e) {
            MsgBox.alert(this, "Cập nhật thất bại!");
        }
    }

    void first() {
        row = 0;
        edit();

    }

    void prev() {
        if (row > 0) {
            row--;
            edit();

        }
    }

    void next() {
        if (row < tblKhachHang.getRowCount() - 1) {
            row++;
            edit();

        }
    }

    void last() {
        row = tblKhachHang.getRowCount() - 1;
        edit();

    }

    private String getTextFromTable(int col) {
        return String.valueOf(tblKhachHang.getValueAt(row, col));
    }

    private void fillKhachChuaThue() {
        DefaultTableModel model = (DefaultTableModel) tblKhachHang.getModel();
        model.setRowCount(0);

        try {

            List<KhachHang> list = dao.selectKhachChuaThue();
            for (KhachHang Kh : list) {
                Object[] row = {
                    Kh.getCMND(),
                    Kh.getTenKhachHang(),
                    Kh.getNgaySinh(),
                    Kh.isGioiTinh() ? "Nam" : "Nữ",
                    Kh.getSoDienThoai(),
                    Kh.getEmail(),
                    Kh.getQuocTich(),
                    Kh.getSoLanThue(),
                    Kh.getMaDoiTac()

                };
                model.addRow(row);
            }
        } catch (Exception e) {
            MsgBox.alert(this, "Lỗi truy vấn dữ liệu!");
            e.printStackTrace();
        }
    }

    private void fillKhachTiemNang() {
        DefaultTableModel model = (DefaultTableModel) tblKhachHang.getModel();
        model.setRowCount(0);

        try {

            List<KhachHang> list = dao.selectKhachTiemNang();
            for (KhachHang Kh : list) {
                Object[] row = {
                    Kh.getCMND(),
                    Kh.getTenKhachHang(),
                    Kh.getNgaySinh(),
                    Kh.isGioiTinh() ? "Nam" : "Nữ",
                    Kh.getSoDienThoai(),
                    Kh.getEmail(),
                    Kh.getQuocTich(),
                    Kh.getSoLanThue(),
                    Kh.getMaDoiTac()

                };
                model.addRow(row);
            }
        } catch (Exception e) {
            MsgBox.alert(this, "Lỗi truy vấn dữ liệu!");
            e.printStackTrace();
        }
    }

    private void fillKhachVIP() {
        DefaultTableModel model = (DefaultTableModel) tblKhachHang.getModel();
        model.setRowCount(0);

        try {

            List<KhachHang> list = dao.selectKhachVip();
            for (KhachHang Kh : list) {
                Object[] row = {
                    Kh.getCMND(),
                    Kh.getTenKhachHang(),
                    Kh.getNgaySinh(),
                    Kh.isGioiTinh() ? "Nam" : "Nữ",
                    Kh.getSoDienThoai(),
                    Kh.getEmail(),
                    Kh.getQuocTich(),
                    Kh.getSoLanThue(),
                    Kh.getMaDoiTac()

                };
                model.addRow(row);
            }
        } catch (Exception e) {
            MsgBox.alert(this, "Lỗi truy vấn dữ liệu!");
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        tabs = new javax.swing.JTabbedPane();
        JPanel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtSoCmt = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtTenKhachHang = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtNgaySinh = new com.toedter.calendar.JDateChooser();
        jLabel5 = new javax.swing.JLabel();
        txtSdt = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtSolanThue = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        rdNam = new javax.swing.JRadioButton();
        rdNu = new javax.swing.JRadioButton();
        txtQuocTich = new javax.swing.JTextField();
        txtMaDoiTac = new javax.swing.JTextField();
        lblKhachHang = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btnThem = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnMoi = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        btnLast = new javax.swing.JButton();
        btnNext = new javax.swing.JButton();
        btnPrev = new javax.swing.JButton();
        btnFirst = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblKhachHang = new javax.swing.JTable();
        jLabel12 = new javax.swing.JLabel();
        cboLoaiKhach = new javax.swing.JComboBox<>();

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 51, 204));
        jLabel1.setText("QUẢN LÝ KHÁCH HÀNG");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("CMND/CCCD");

        txtSoCmt.setName("CMND"); // NOI18N
        txtSoCmt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSoCmtActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Tên Khách Hàng");

        txtTenKhachHang.setName("Tên khách hàng"); // NOI18N

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Ngày Sinh");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Số Điện Thoại");

        txtSdt.setName("Số điện thoại"); // NOI18N

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Email");

        txtEmail.setName("Email"); // NOI18N
        txtEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmailActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("Quốc Tịch");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("Số Lần Thuê");

        txtSolanThue.setName("Số lần thuê"); // NOI18N

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setText("Mã Đối Tác");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setText("Giới Tính");

        buttonGroup1.add(rdNam);
        rdNam.setText("Nam ");

        buttonGroup1.add(rdNu);
        rdNu.setText("Nữ");

        txtQuocTich.setName("Quốc tịch"); // NOI18N

        lblKhachHang.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblKhachHang.setForeground(new java.awt.Color(0, 0, 204));

        jPanel1.setLayout(new java.awt.GridLayout(1, 0, 5, 0));

        btnThem.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/exemple/icon/add.png"))); // NOI18N
        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });
        jPanel1.add(btnThem);

        btnXoa.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnXoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/exemple/icon/deleteService.png"))); // NOI18N
        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });
        jPanel1.add(btnXoa);

        btnSua.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnSua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/exemple/icon/update.png"))); // NOI18N
        btnSua.setText("Cập Nhật");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });
        jPanel1.add(btnSua);

        btnMoi.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnMoi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/exemple/icon/new.png"))); // NOI18N
        btnMoi.setText("Mới");
        btnMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMoiActionPerformed(evt);
            }
        });
        jPanel1.add(btnMoi);

        jPanel3.setLayout(new java.awt.GridLayout(1, 0, 6, 0));

        btnLast.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/exemple/icon/Last.png"))); // NOI18N
        btnLast.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLastActionPerformed(evt);
            }
        });
        jPanel3.add(btnLast);

        btnNext.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/exemple/icon/next.png"))); // NOI18N
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });
        jPanel3.add(btnNext);

        btnPrev.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/exemple/icon/previous.png"))); // NOI18N
        btnPrev.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrevActionPerformed(evt);
            }
        });
        jPanel3.add(btnPrev);

        btnFirst.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/exemple/icon/First.png"))); // NOI18N
        btnFirst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFirstActionPerformed(evt);
            }
        });
        jPanel3.add(btnFirst);

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setText("Loại khách hàng:");

        javax.swing.GroupLayout JPanelLayout = new javax.swing.GroupLayout(JPanel);
        JPanel.setLayout(JPanelLayout);
        JPanelLayout.setHorizontalGroup(
            JPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPanelLayout.createSequentialGroup()
                .addGroup(JPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JPanelLayout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(JPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 487, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(JPanelLayout.createSequentialGroup()
                                .addGap(75, 75, 75)
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(JPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(JPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4)
                            .addComponent(jLabel10)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9)
                            .addComponent(jLabel11))
                        .addGap(24, 24, 24)
                        .addGroup(JPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(JPanelLayout.createSequentialGroup()
                                .addComponent(rdNam)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rdNu))
                            .addGroup(JPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(txtMaDoiTac, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtSolanThue, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtQuocTich, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtEmail, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtSdt, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtNgaySinh, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 470, Short.MAX_VALUE)
                                .addComponent(txtSoCmt, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lblKhachHang, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtTenKhachHang, javax.swing.GroupLayout.Alignment.LEADING)))))
                .addContainerGap(497, Short.MAX_VALUE))
        );
        JPanelLayout.setVerticalGroup(
            JPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JPanelLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(JPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtTenKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(JPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtSoCmt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(JPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(txtNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(JPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(rdNam)
                    .addComponent(rdNu))
                .addGap(19, 19, 19)
                .addGroup(JPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtSdt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(JPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JPanelLayout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addGroup(JPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtQuocTich, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtSolanThue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(JPanelLayout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addComponent(jLabel7)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(JPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(txtMaDoiTac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(JPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel11)
                    .addComponent(lblKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        tabs.addTab("Cập Nhật", new javax.swing.ImageIcon(getClass().getResource("/com/exemple/icon/Edit.png")), JPanel); // NOI18N

        tblKhachHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "số cmt Khách Hàng", "Tên Khách Hàng", "Ngày Sinh", "Giới Tính ", "Số Điên Thoại", "Email", "Quốc Tịch", "Số Lần Thuê", "Mã Đối Tác"
            }
        ));
        tblKhachHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblKhachHangMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblKhachHang);

        jLabel12.setText("Loại Khách Hàng");

        cboLoaiKhach.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "null", "Khách chưa thuê", "Khách hàng tiềm năng", "Khách VIP" }));
        cboLoaiKhach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboLoaiKhachActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1103, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12)
                .addGap(18, 18, 18)
                .addComponent(cboLoaiKhach, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(cboLoaiKhach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tabs.addTab("Danh Sách", new javax.swing.ImageIcon(getClass().getResource("/com/exemple/icon/Scroll list.png")), jPanel2); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(tabs)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tabs)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtSoCmtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSoCmtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSoCmtActionPerformed

    private void txtEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmailActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        // TODO add your handling code here:
        if (utilityHelper.checkNullText(txtTenKhachHang) && utilityHelper.checkName(txtTenKhachHang)
                && utilityHelper.checkNullText(txtSoCmt) && utilityHelper.checkCMT(txtSoCmt)
                && utilityHelper.checkNullText(txtSdt) && utilityHelper.checkSDT(txtSdt)
                && utilityHelper.checkNullText(txtEmail) && utilityHelper.checkEmail(txtEmail)
                && utilityHelper.checkNumber(txtSolanThue)
                && utilityHelper.checkNullText(txtQuocTich)) {
            this.Insert();
        }
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        // TODO add your handling code here:
        Delete();
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        // TODO add your handling code here:
        if (utilityHelper.checkNullText(txtTenKhachHang) && utilityHelper.checkName(txtTenKhachHang)
                && utilityHelper.checkNullText(txtSoCmt) && utilityHelper.checkCMT(txtSoCmt)
                && utilityHelper.checkNullText(txtSdt) && utilityHelper.checkSDT(txtSdt)
                && utilityHelper.checkNullText(txtEmail) && utilityHelper.checkEmail(txtEmail)
                && utilityHelper.checkNumber(txtSolanThue)
                && utilityHelper.checkNullText(txtQuocTich)) {
            this.update();
        }
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMoiActionPerformed
        // TODO add your handling code here:
        clearForm();
    }//GEN-LAST:event_btnMoiActionPerformed

    private void btnFirstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFirstActionPerformed
        // TODO add your handling code here:
        first();
    }//GEN-LAST:event_btnFirstActionPerformed

    private void btnPrevActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrevActionPerformed
        // TODO add your handling code here:
        prev();
    }//GEN-LAST:event_btnPrevActionPerformed

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        // TODO add your handling code here:
        next();
    }//GEN-LAST:event_btnNextActionPerformed

    private void btnLastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLastActionPerformed
        // TODO add your handling code here:
        last();
    }//GEN-LAST:event_btnLastActionPerformed

    private void tblKhachHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblKhachHangMouseClicked
        // TODO add your handling code here:
        this.row = tblKhachHang.getSelectedRow();
        this.edit();
        tabs.setSelectedIndex(0);
    }//GEN-LAST:event_tblKhachHangMouseClicked

    private void cboLoaiKhachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboLoaiKhachActionPerformed
        // TODO add your handling code here:
        int index = cboLoaiKhach.getSelectedIndex();
        if (index == 0) {
            filltable();
        }
        if (index == 1) {
            fillKhachChuaThue();
        }
        if (index == 2) {
            fillKhachTiemNang();
        }
        if (index == 3) {
            fillKhachVIP();
        }
    }//GEN-LAST:event_cboLoaiKhachActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel JPanel;
    private javax.swing.JButton btnFirst;
    private javax.swing.JButton btnLast;
    private javax.swing.JButton btnMoi;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnPrev;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnXoa;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cboLoaiKhach;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblKhachHang;
    private javax.swing.JRadioButton rdNam;
    private javax.swing.JRadioButton rdNu;
    private javax.swing.JTabbedPane tabs;
    private javax.swing.JTable tblKhachHang;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtMaDoiTac;
    private com.toedter.calendar.JDateChooser txtNgaySinh;
    private javax.swing.JTextField txtQuocTich;
    private javax.swing.JTextField txtSdt;
    private javax.swing.JTextField txtSoCmt;
    private javax.swing.JTextField txtSolanThue;
    private javax.swing.JTextField txtTenKhachHang;
    // End of variables declaration//GEN-END:variables
}
