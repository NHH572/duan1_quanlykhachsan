/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.exemple.views;

import com.exemple.controller.ChuyenManHinhController;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;
import com.exemple.entity.DanhMuc;

/**
 *
 * @author Minh Triet
 */
public class TrangChuJrame extends javax.swing.JFrame {

    ChuyenManHinhController controller;
    public TrangChuJrame() {
        initComponents();
        init();
    }
     void init() {

        setLocationRelativeTo(null);
        setTitle("Phần mềm quản lý khách sạn");
//        new Timer(1000, new ActionListener() {
//            SimpleDateFormat format = new SimpleDateFormat("hh:mm:ss a");
//
//            public void actionPerformed(ActionEvent e) {
//                Dongho.setText(format.format(new Date()));
//            }
//        }).start();
//        this.openChao();
//        this.openDangNhap();
        controller=new ChuyenManHinhController(mainPanel);        
        controller.setView(panelPhong, lblPhong,Opaque1);
        List<DanhMuc> listDanhMuc=new ArrayList<>();
        listDanhMuc.add(new DanhMuc("QuanLyPhong",panelPhong,lblPhong,Opaque1));
        listDanhMuc.add(new DanhMuc("NhanVien",panelNhanVien,lblNhanVien,Opaque2));
        listDanhMuc.add(new DanhMuc("DichVu",panelDichVu,lblDichVu,Opaque3));
        listDanhMuc.add(new DanhMuc("HoaDon",panelHoaDon,lblHoaDon,Opaque4));
        listDanhMuc.add(new DanhMuc("DatPhong",panelDatPhong,lblDatPhong,Opaque5));
        listDanhMuc.add(new DanhMuc("DoiTac",panelDoiTac,lblDoiTac,Opaque6));
        listDanhMuc.add(new DanhMuc("KhoHang",panelKhoHang,lblKhoHang,Opaque7));
        listDanhMuc.add(new DanhMuc("KhuyenMai",panelKhuyenMai,lblKhuyenMai,Opaque8));
        listDanhMuc.add(new DanhMuc("DangXuat",panelDangXuat,lblDangXuat,Opaque9));
        listDanhMuc.add(new DanhMuc("Thoat",panelThoat,lblThoat,Opaque10));
        controller.setEvent(listDanhMuc);
    }
    void setColor(JPanel panel) {
        panel.setBackground(new Color(153, 153, 153));// Màu khi click vô
    }

    void resetColor(JPanel panel) {
        panel.setBackground(new Color(102, 102, 102));// Màu ban đầu, trùng với màu của SlidePanel
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

        jPanel1 = new javax.swing.JPanel();
        slidePanel = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        panelPhong = new javax.swing.JPanel();
        Opaque1 = new javax.swing.JPanel();
        lblPhong = new javax.swing.JLabel();
        panelNhanVien = new javax.swing.JPanel();
        Opaque2 = new javax.swing.JPanel();
        lblNhanVien = new javax.swing.JLabel();
        panelDichVu = new javax.swing.JPanel();
        Opaque3 = new javax.swing.JPanel();
        lblDichVu = new javax.swing.JLabel();
        panelHoaDon = new javax.swing.JPanel();
        Opaque4 = new javax.swing.JPanel();
        lblHoaDon = new javax.swing.JLabel();
        panelDatPhong = new javax.swing.JPanel();
        Opaque5 = new javax.swing.JPanel();
        lblDatPhong = new javax.swing.JLabel();
        panelDoiTac = new javax.swing.JPanel();
        Opaque6 = new javax.swing.JPanel();
        lblDoiTac = new javax.swing.JLabel();
        panelKhoHang = new javax.swing.JPanel();
        Opaque7 = new javax.swing.JPanel();
        lblKhoHang = new javax.swing.JLabel();
        panelKhuyenMai = new javax.swing.JPanel();
        Opaque8 = new javax.swing.JPanel();
        lblKhuyenMai = new javax.swing.JLabel();
        panelDangXuat = new javax.swing.JPanel();
        Opaque9 = new javax.swing.JPanel();
        lblDangXuat = new javax.swing.JLabel();
        panelThoat = new javax.swing.JPanel();
        Opaque10 = new javax.swing.JPanel();
        lblThoat = new javax.swing.JLabel();
        mainPanel = new javax.swing.JPanel();
        jToolBar1 = new javax.swing.JToolBar();
        jButton1 = new javax.swing.JButton();
        jSeparator5 = new javax.swing.JToolBar.Separator();
        jButton2 = new javax.swing.JButton();
        jSeparator4 = new javax.swing.JToolBar.Separator();
        jButton3 = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JToolBar.Separator();
        jButton4 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        jButton5 = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        jButton6 = new javax.swing.JButton();
        jSeparator8 = new javax.swing.JToolBar.Separator();
        jButton18 = new javax.swing.JButton();
        jSeparator7 = new javax.swing.JToolBar.Separator();
        jButton19 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        slidePanel.setBackground(new java.awt.Color(102, 102, 102));
        slidePanel.setLayout(new java.awt.GridBagLayout());

        jPanel2.setBackground(new java.awt.Color(102, 102, 102));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Chức năng");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 209, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 54, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel12)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        slidePanel.add(jPanel2, gridBagConstraints);

        panelPhong.setBackground(new java.awt.Color(102, 102, 102));
        panelPhong.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                panelPhongMousePressed(evt);
            }
        });
        panelPhong.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Opaque1.setEnabled(false);
        Opaque1.setOpaque(false);

        javax.swing.GroupLayout Opaque1Layout = new javax.swing.GroupLayout(Opaque1);
        Opaque1.setLayout(Opaque1Layout);
        Opaque1Layout.setHorizontalGroup(
            Opaque1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 3, Short.MAX_VALUE)
        );
        Opaque1Layout.setVerticalGroup(
            Opaque1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 46, Short.MAX_VALUE)
        );

        panelPhong.add(Opaque1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 3, -1));

        lblPhong.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        lblPhong.setForeground(new java.awt.Color(255, 255, 255));
        lblPhong.setText("Quản lý phòng");
        panelPhong.add(lblPhong, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 13, 142, -1));

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 77;
        gridBagConstraints.ipady = 11;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 0, 0, 0);
        slidePanel.add(panelPhong, gridBagConstraints);

        panelNhanVien.setBackground(new java.awt.Color(102, 102, 102));
        panelNhanVien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                panelNhanVienMousePressed(evt);
            }
        });
        panelNhanVien.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Opaque2.setEnabled(false);
        Opaque2.setOpaque(false);

        javax.swing.GroupLayout Opaque2Layout = new javax.swing.GroupLayout(Opaque2);
        Opaque2.setLayout(Opaque2Layout);
        Opaque2Layout.setHorizontalGroup(
            Opaque2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 3, Short.MAX_VALUE)
        );
        Opaque2Layout.setVerticalGroup(
            Opaque2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 46, Short.MAX_VALUE)
        );

        panelNhanVien.add(Opaque2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 3, -1));

        lblNhanVien.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        lblNhanVien.setForeground(new java.awt.Color(255, 255, 255));
        lblNhanVien.setText("Nhân viên");
        panelNhanVien.add(lblNhanVien, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 13, 142, -1));

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 77;
        gridBagConstraints.ipady = 11;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(13, 0, 0, 0);
        slidePanel.add(panelNhanVien, gridBagConstraints);

        panelDichVu.setBackground(new java.awt.Color(102, 102, 102));
        panelDichVu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                panelDichVuMousePressed(evt);
            }
        });
        panelDichVu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Opaque3.setEnabled(false);
        Opaque3.setOpaque(false);

        javax.swing.GroupLayout Opaque3Layout = new javax.swing.GroupLayout(Opaque3);
        Opaque3.setLayout(Opaque3Layout);
        Opaque3Layout.setHorizontalGroup(
            Opaque3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 3, Short.MAX_VALUE)
        );
        Opaque3Layout.setVerticalGroup(
            Opaque3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 46, Short.MAX_VALUE)
        );

        panelDichVu.add(Opaque3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 3, -1));

        lblDichVu.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        lblDichVu.setForeground(new java.awt.Color(255, 255, 255));
        lblDichVu.setText("Dịch vụ");
        panelDichVu.add(lblDichVu, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 13, 142, -1));

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 77;
        gridBagConstraints.ipady = 11;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 0, 0, 0);
        slidePanel.add(panelDichVu, gridBagConstraints);

        panelHoaDon.setBackground(new java.awt.Color(102, 102, 102));
        panelHoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                panelHoaDonMousePressed(evt);
            }
        });
        panelHoaDon.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Opaque4.setEnabled(false);
        Opaque4.setOpaque(false);

        javax.swing.GroupLayout Opaque4Layout = new javax.swing.GroupLayout(Opaque4);
        Opaque4.setLayout(Opaque4Layout);
        Opaque4Layout.setHorizontalGroup(
            Opaque4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 3, Short.MAX_VALUE)
        );
        Opaque4Layout.setVerticalGroup(
            Opaque4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 46, Short.MAX_VALUE)
        );

        panelHoaDon.add(Opaque4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 3, -1));

        lblHoaDon.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        lblHoaDon.setForeground(new java.awt.Color(255, 255, 255));
        lblHoaDon.setText("Hóa đơn");
        panelHoaDon.add(lblHoaDon, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 13, 142, -1));

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 77;
        gridBagConstraints.ipady = 11;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 0, 0, 0);
        slidePanel.add(panelHoaDon, gridBagConstraints);

        panelDatPhong.setBackground(new java.awt.Color(102, 102, 102));
        panelDatPhong.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                panelDatPhongMousePressed(evt);
            }
        });
        panelDatPhong.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Opaque5.setEnabled(false);
        Opaque5.setOpaque(false);

        javax.swing.GroupLayout Opaque5Layout = new javax.swing.GroupLayout(Opaque5);
        Opaque5.setLayout(Opaque5Layout);
        Opaque5Layout.setHorizontalGroup(
            Opaque5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 3, Short.MAX_VALUE)
        );
        Opaque5Layout.setVerticalGroup(
            Opaque5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 46, Short.MAX_VALUE)
        );

        panelDatPhong.add(Opaque5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 3, -1));

        lblDatPhong.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        lblDatPhong.setForeground(new java.awt.Color(255, 255, 255));
        lblDatPhong.setText("Đặt phòng");
        panelDatPhong.add(lblDatPhong, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 13, 142, -1));

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 77;
        gridBagConstraints.ipady = 11;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(13, 0, 0, 0);
        slidePanel.add(panelDatPhong, gridBagConstraints);

        panelDoiTac.setBackground(new java.awt.Color(102, 102, 102));
        panelDoiTac.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                panelDoiTacMousePressed(evt);
            }
        });
        panelDoiTac.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Opaque6.setEnabled(false);
        Opaque6.setOpaque(false);

        javax.swing.GroupLayout Opaque6Layout = new javax.swing.GroupLayout(Opaque6);
        Opaque6.setLayout(Opaque6Layout);
        Opaque6Layout.setHorizontalGroup(
            Opaque6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 3, Short.MAX_VALUE)
        );
        Opaque6Layout.setVerticalGroup(
            Opaque6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 46, Short.MAX_VALUE)
        );

        panelDoiTac.add(Opaque6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 3, -1));

        lblDoiTac.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        lblDoiTac.setForeground(new java.awt.Color(255, 255, 255));
        lblDoiTac.setText("Đối tác");
        panelDoiTac.add(lblDoiTac, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 13, 142, -1));

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 77;
        gridBagConstraints.ipady = 11;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 0, 0, 0);
        slidePanel.add(panelDoiTac, gridBagConstraints);

        panelKhoHang.setBackground(new java.awt.Color(102, 102, 102));
        panelKhoHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                panelKhoHangMousePressed(evt);
            }
        });
        panelKhoHang.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Opaque7.setEnabled(false);
        Opaque7.setOpaque(false);

        javax.swing.GroupLayout Opaque7Layout = new javax.swing.GroupLayout(Opaque7);
        Opaque7.setLayout(Opaque7Layout);
        Opaque7Layout.setHorizontalGroup(
            Opaque7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 3, Short.MAX_VALUE)
        );
        Opaque7Layout.setVerticalGroup(
            Opaque7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 46, Short.MAX_VALUE)
        );

        panelKhoHang.add(Opaque7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 3, -1));

        lblKhoHang.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        lblKhoHang.setForeground(new java.awt.Color(255, 255, 255));
        lblKhoHang.setText("Kho hàng");
        panelKhoHang.add(lblKhoHang, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 13, 142, -1));

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 77;
        gridBagConstraints.ipady = 11;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 0, 0, 0);
        slidePanel.add(panelKhoHang, gridBagConstraints);

        panelKhuyenMai.setBackground(new java.awt.Color(102, 102, 102));
        panelKhuyenMai.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                panelKhuyenMaiMousePressed(evt);
            }
        });
        panelKhuyenMai.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Opaque8.setEnabled(false);
        Opaque8.setOpaque(false);

        javax.swing.GroupLayout Opaque8Layout = new javax.swing.GroupLayout(Opaque8);
        Opaque8.setLayout(Opaque8Layout);
        Opaque8Layout.setHorizontalGroup(
            Opaque8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 3, Short.MAX_VALUE)
        );
        Opaque8Layout.setVerticalGroup(
            Opaque8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 46, Short.MAX_VALUE)
        );

        panelKhuyenMai.add(Opaque8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 3, -1));

        lblKhuyenMai.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        lblKhuyenMai.setForeground(new java.awt.Color(255, 255, 255));
        lblKhuyenMai.setText("Khuyến mãi");
        panelKhuyenMai.add(lblKhuyenMai, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 13, 142, -1));

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 77;
        gridBagConstraints.ipady = 11;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(13, 0, 0, 0);
        slidePanel.add(panelKhuyenMai, gridBagConstraints);

        panelDangXuat.setBackground(new java.awt.Color(102, 102, 102));
        panelDangXuat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                panelDangXuatMousePressed(evt);
            }
        });
        panelDangXuat.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Opaque9.setEnabled(false);
        Opaque9.setOpaque(false);

        javax.swing.GroupLayout Opaque9Layout = new javax.swing.GroupLayout(Opaque9);
        Opaque9.setLayout(Opaque9Layout);
        Opaque9Layout.setHorizontalGroup(
            Opaque9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 3, Short.MAX_VALUE)
        );
        Opaque9Layout.setVerticalGroup(
            Opaque9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 46, Short.MAX_VALUE)
        );

        panelDangXuat.add(Opaque9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 3, -1));

        lblDangXuat.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        lblDangXuat.setForeground(new java.awt.Color(255, 255, 255));
        lblDangXuat.setText("Đăng xuất");
        panelDangXuat.add(lblDangXuat, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 13, 142, -1));

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 77;
        gridBagConstraints.ipady = 11;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(13, 0, 0, 0);
        slidePanel.add(panelDangXuat, gridBagConstraints);

        panelThoat.setBackground(new java.awt.Color(102, 102, 102));
        panelThoat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                panelThoatMousePressed(evt);
            }
        });
        panelThoat.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Opaque10.setEnabled(false);
        Opaque10.setOpaque(false);

        javax.swing.GroupLayout Opaque10Layout = new javax.swing.GroupLayout(Opaque10);
        Opaque10.setLayout(Opaque10Layout);
        Opaque10Layout.setHorizontalGroup(
            Opaque10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 3, Short.MAX_VALUE)
        );
        Opaque10Layout.setVerticalGroup(
            Opaque10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 46, Short.MAX_VALUE)
        );

        panelThoat.add(Opaque10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 3, -1));

        lblThoat.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        lblThoat.setForeground(new java.awt.Color(255, 255, 255));
        lblThoat.setText("Thoát");
        panelThoat.add(lblThoat, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 13, 142, -1));

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 77;
        gridBagConstraints.ipady = 11;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(13, 0, 13, 0);
        slidePanel.add(panelThoat, gridBagConstraints);

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 702, Short.MAX_VALUE)
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addComponent(slidePanel, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(slidePanel, javax.swing.GroupLayout.PREFERRED_SIZE, 673, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 1, Short.MAX_VALUE))
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jToolBar1.setRollover(true);

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/exemple/icon/taikhoan.png"))); // NOI18N
        jButton1.setText("Tài khoản");
        jButton1.setFocusable(false);
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton1);
        jToolBar1.add(jSeparator5);

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/exemple/icon/phong.png"))); // NOI18N
        jButton2.setText("Phòng");
        jButton2.setFocusable(false);
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(jButton2);
        jToolBar1.add(jSeparator4);

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/exemple/icon/thanhtoan.png"))); // NOI18N
        jButton3.setText("Thanh toán");
        jButton3.setFocusable(false);
        jButton3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(jButton3);
        jToolBar1.add(jSeparator3);

        jButton4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/exemple/icon/nhanvien.png"))); // NOI18N
        jButton4.setText("Nhân viên");
        jButton4.setFocusable(false);
        jButton4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton4.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(jButton4);
        jToolBar1.add(jSeparator1);

        jButton5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/exemple/icon/doimk.png"))); // NOI18N
        jButton5.setText("Đổi mật khẩu");
        jButton5.setFocusable(false);
        jButton5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton5.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(jButton5);
        jToolBar1.add(jSeparator2);

        jButton6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/exemple/icon/thongke.png"))); // NOI18N
        jButton6.setText("Thống kê");
        jButton6.setFocusable(false);
        jButton6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton6.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton6);
        jToolBar1.add(jSeparator8);

        jButton18.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/exemple/icon/trogiup.png"))); // NOI18N
        jButton18.setText("Trợ giúp");
        jButton18.setFocusable(false);
        jButton18.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton18.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(jButton18);
        jToolBar1.add(jSeparator7);

        jButton19.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/exemple/icon/gioithieu.png"))); // NOI18N
        jButton19.setText("Giới thiệu");
        jButton19.setFocusable(false);
        jButton19.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton19.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(jButton19);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void panelPhongMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelPhongMousePressed


    }//GEN-LAST:event_panelPhongMousePressed

    private void panelNhanVienMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelNhanVienMousePressed

    }//GEN-LAST:event_panelNhanVienMousePressed

    private void panelDichVuMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelDichVuMousePressed

    }//GEN-LAST:event_panelDichVuMousePressed

    private void panelHoaDonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelHoaDonMousePressed

    }//GEN-LAST:event_panelHoaDonMousePressed

    private void panelDatPhongMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelDatPhongMousePressed

   
    }//GEN-LAST:event_panelDatPhongMousePressed

    private void panelDoiTacMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelDoiTacMousePressed

    }//GEN-LAST:event_panelDoiTacMousePressed

    private void panelKhoHangMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelKhoHangMousePressed
        
    }//GEN-LAST:event_panelKhoHangMousePressed

    private void panelKhuyenMaiMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelKhuyenMaiMousePressed
       
    }//GEN-LAST:event_panelKhuyenMaiMousePressed

    private void panelDangXuatMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelDangXuatMousePressed

    }//GEN-LAST:event_panelDangXuatMousePressed

    private void panelThoatMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelThoatMousePressed

    }//GEN-LAST:event_panelThoatMousePressed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton6ActionPerformed

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
            java.util.logging.Logger.getLogger(TrangChuJrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TrangChuJrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TrangChuJrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TrangChuJrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TrangChuJrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Opaque1;
    private javax.swing.JPanel Opaque10;
    private javax.swing.JPanel Opaque2;
    private javax.swing.JPanel Opaque3;
    private javax.swing.JPanel Opaque4;
    private javax.swing.JPanel Opaque5;
    private javax.swing.JPanel Opaque6;
    private javax.swing.JPanel Opaque7;
    private javax.swing.JPanel Opaque8;
    private javax.swing.JPanel Opaque9;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton19;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JToolBar.Separator jSeparator3;
    private javax.swing.JToolBar.Separator jSeparator4;
    private javax.swing.JToolBar.Separator jSeparator5;
    private javax.swing.JToolBar.Separator jSeparator7;
    private javax.swing.JToolBar.Separator jSeparator8;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JLabel lblDangXuat;
    private javax.swing.JLabel lblDatPhong;
    private javax.swing.JLabel lblDichVu;
    private javax.swing.JLabel lblDoiTac;
    private javax.swing.JLabel lblHoaDon;
    private javax.swing.JLabel lblKhoHang;
    private javax.swing.JLabel lblKhuyenMai;
    private javax.swing.JLabel lblNhanVien;
    private javax.swing.JLabel lblPhong;
    private javax.swing.JLabel lblThoat;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JPanel panelDangXuat;
    private javax.swing.JPanel panelDatPhong;
    private javax.swing.JPanel panelDichVu;
    private javax.swing.JPanel panelDoiTac;
    private javax.swing.JPanel panelHoaDon;
    private javax.swing.JPanel panelKhoHang;
    private javax.swing.JPanel panelKhuyenMai;
    private javax.swing.JPanel panelNhanVien;
    private javax.swing.JPanel panelPhong;
    private javax.swing.JPanel panelThoat;
    private javax.swing.JPanel slidePanel;
    // End of variables declaration//GEN-END:variables
}
