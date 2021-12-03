/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.exemple.views;

import com.exemple.controller.ChuyenManHinhController;
import com.exemple.entity.DanhMuc;
import com.exemple.entity.NhanVien;
import com.exemple.helper.Auth;
import com.exemple.helper.MsgBox;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Font;
import java.io.File;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

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
        controller = new ChuyenManHinhController(mainPanel);
        controller.setView(panelSoDoPhong, lblSoDoPhong, Opaque10);
        List<DanhMuc> listDanhMuc = new ArrayList<>();
        listDanhMuc.add(new DanhMuc("SoDoPhong", panelSoDoPhong, lblSoDoPhong, Opaque10));
        listDanhMuc.add(new DanhMuc("QuanLyPhong", panelPhong, lblPhong, Opaque1));
        listDanhMuc.add(new DanhMuc("NhanVien", panelNhanVien, lblNhanVien, Opaque2));
        listDanhMuc.add(new DanhMuc("DichVu", panelDichVu, lblDichVu, Opaque3));
        listDanhMuc.add(new DanhMuc("HoaDon", panelHoaDon, lblHoaDon, Opaque4));
        listDanhMuc.add(new DanhMuc("DatPhong", panelDatPhong, lblDatPhong, Opaque5));
        listDanhMuc.add(new DanhMuc("DoiTac", panelDoiTac, lblDoiTac, Opaque6));
        listDanhMuc.add(new DanhMuc("HoTro", panelKhoHang, lblKhoHang, Opaque7));
        listDanhMuc.add(new DanhMuc("KhuyenMai", panelKhuyenMai, lblKhuyenMai, Opaque8));
        controller.setEvent(listDanhMuc);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        mainPanel.setPreferredSize(new Dimension(1320, 700));
        setTxtXinChao();

    }

    private void setTxtXinChao() {
        if (Auth.user == null) {
            return;
        } else {
            lblXinChao.setText("Xin chào, " + Auth.user.getHoTen());
        }
    }

    void setColor(JPanel panel) {
        panel.setBackground(new Color(212, 187, 0));// Màu khi click vô
    }

    void resetColor(JPanel panel) {
        panel.setBackground(new Color(77, 73, 73));// Màu ban đầu, trùng với màu của SlidePanel
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        slidePanel = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        panelSoDoPhong = new javax.swing.JPanel();
        Opaque10 = new javax.swing.JPanel();
        lblSoDoPhong = new javax.swing.JLabel();
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
        mainPanel = new javax.swing.JPanel();
        jToolBar1 = new javax.swing.JToolBar();
        btnTaiKhoan = new javax.swing.JButton();
        btnDoiMatKhau = new javax.swing.JButton();
        jSeparator6 = new javax.swing.JToolBar.Separator();
        btnThongKe = new javax.swing.JButton();
        jSeparator8 = new javax.swing.JToolBar.Separator();
        btnHoTro = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        btnGioiThieu = new javax.swing.JButton();
        jSeparator9 = new javax.swing.JToolBar.Separator();
        btnDangXuat = new javax.swing.JButton();
        lblXinChao = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(77, 73, 73));

        slidePanel.setBackground(new java.awt.Color(77, 73, 73));
        slidePanel.setMaximumSize(new java.awt.Dimension(209, 700));
        slidePanel.setLayout(new java.awt.GridLayout(0, 1));

        jPanel2.setBackground(new java.awt.Color(77, 73, 73));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Chức năng");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        slidePanel.add(jPanel2);

        panelSoDoPhong.setBackground(new java.awt.Color(212, 187, 0));
        panelSoDoPhong.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                panelSoDoPhongMousePressed(evt);
            }
        });
        panelSoDoPhong.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Opaque10.setEnabled(false);
        Opaque10.setOpaque(false);

        javax.swing.GroupLayout Opaque10Layout = new javax.swing.GroupLayout(Opaque10);
        Opaque10.setLayout(Opaque10Layout);
        Opaque10Layout.setHorizontalGroup(
            Opaque10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );
        Opaque10Layout.setVerticalGroup(
            Opaque10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 70, Short.MAX_VALUE)
        );

        panelSoDoPhong.add(Opaque10, new org.netbeans.lib.awtextra.AbsoluteConstraints(-7, 0, 10, 70));

        lblSoDoPhong.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        lblSoDoPhong.setForeground(new java.awt.Color(255, 255, 255));
        lblSoDoPhong.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/exemple/icon/sodoPhong.png"))); // NOI18N
        lblSoDoPhong.setText("Sơ đồ phòng");
        panelSoDoPhong.add(lblSoDoPhong, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 13, 142, -1));

        slidePanel.add(panelSoDoPhong);

        panelPhong.setBackground(new java.awt.Color(77, 73, 73));
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
            .addGap(0, 70, Short.MAX_VALUE)
        );

        panelPhong.add(Opaque1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 70));

        lblPhong.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        lblPhong.setForeground(new java.awt.Color(255, 255, 255));
        lblPhong.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/exemple/icon/quanLyPhong2.png"))); // NOI18N
        lblPhong.setText("Quản lý phòng");
        panelPhong.add(lblPhong, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 13, 180, -1));

        slidePanel.add(panelPhong);

        panelNhanVien.setBackground(new java.awt.Color(77, 73, 73));
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
            .addGap(0, 70, Short.MAX_VALUE)
        );

        panelNhanVien.add(Opaque2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 3, 70));

        lblNhanVien.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        lblNhanVien.setForeground(new java.awt.Color(255, 255, 255));
        lblNhanVien.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/exemple/icon/quanLyNhanVien.png"))); // NOI18N
        lblNhanVien.setText("Nhân viên");
        panelNhanVien.add(lblNhanVien, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 13, 142, -1));

        slidePanel.add(panelNhanVien);

        panelDichVu.setBackground(new java.awt.Color(77, 73, 73));
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
            .addGap(0, 70, Short.MAX_VALUE)
        );

        panelDichVu.add(Opaque3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 3, 70));

        lblDichVu.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        lblDichVu.setForeground(new java.awt.Color(255, 255, 255));
        lblDichVu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/exemple/icon/quanLydichvu.png"))); // NOI18N
        lblDichVu.setText("Dịch vụ");
        panelDichVu.add(lblDichVu, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 13, 142, -1));

        slidePanel.add(panelDichVu);

        panelHoaDon.setBackground(new java.awt.Color(77, 73, 73));
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
            .addGap(0, 70, Short.MAX_VALUE)
        );

        panelHoaDon.add(Opaque4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 3, 70));

        lblHoaDon.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        lblHoaDon.setForeground(new java.awt.Color(255, 255, 255));
        lblHoaDon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/exemple/icon/hoadon2.png"))); // NOI18N
        lblHoaDon.setText("Hóa đơn");
        panelHoaDon.add(lblHoaDon, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 13, 142, -1));

        slidePanel.add(panelHoaDon);

        panelDatPhong.setBackground(new java.awt.Color(77, 73, 73));
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
            .addGap(0, 70, Short.MAX_VALUE)
        );

        panelDatPhong.add(Opaque5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 3, 70));

        lblDatPhong.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        lblDatPhong.setForeground(new java.awt.Color(255, 255, 255));
        lblDatPhong.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/exemple/icon/datPhong3.png"))); // NOI18N
        lblDatPhong.setText("Đặt phòng");
        panelDatPhong.add(lblDatPhong, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 13, 142, -1));

        slidePanel.add(panelDatPhong);

        panelDoiTac.setBackground(new java.awt.Color(77, 73, 73));
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
            .addGap(0, 10, Short.MAX_VALUE)
        );
        Opaque6Layout.setVerticalGroup(
            Opaque6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 70, Short.MAX_VALUE)
        );

        panelDoiTac.add(Opaque6, new org.netbeans.lib.awtextra.AbsoluteConstraints(-7, 0, 10, 70));

        lblDoiTac.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        lblDoiTac.setForeground(new java.awt.Color(255, 255, 255));
        lblDoiTac.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/exemple/icon/doitac2.png"))); // NOI18N
        lblDoiTac.setText("Đối tác");
        panelDoiTac.add(lblDoiTac, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 13, 142, -1));

        slidePanel.add(panelDoiTac);

        panelKhoHang.setBackground(new java.awt.Color(77, 73, 73));
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
            .addGap(0, 70, Short.MAX_VALUE)
        );

        panelKhoHang.add(Opaque7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 3, 70));

        lblKhoHang.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        lblKhoHang.setForeground(new java.awt.Color(255, 255, 255));
        lblKhoHang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/exemple/icon/hotro.png"))); // NOI18N
        lblKhoHang.setText("Hỗ trợ");
        panelKhoHang.add(lblKhoHang, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 13, 142, -1));

        slidePanel.add(panelKhoHang);

        panelKhuyenMai.setBackground(new java.awt.Color(77, 73, 73));
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
            .addGap(0, 70, Short.MAX_VALUE)
        );

        panelKhuyenMai.add(Opaque8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 3, 70));

        lblKhuyenMai.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        lblKhuyenMai.setForeground(new java.awt.Color(255, 255, 255));
        lblKhuyenMai.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/exemple/icon/khuyenmai.png"))); // NOI18N
        lblKhuyenMai.setText("Khuyến mãi");
        panelKhuyenMai.add(lblKhuyenMai, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 13, 142, -1));

        slidePanel.add(panelKhuyenMai);

        mainPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addComponent(slidePanel, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(slidePanel, javax.swing.GroupLayout.PREFERRED_SIZE, 708, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jToolBar1.setRollover(true);

        btnTaiKhoan.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnTaiKhoan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/exemple/icon/taikhoan.png"))); // NOI18N
        btnTaiKhoan.setText("Tài khoản");
        btnTaiKhoan.setFocusable(false);
        btnTaiKhoan.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnTaiKhoan.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnTaiKhoan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTaiKhoanActionPerformed(evt);
            }
        });
        jToolBar1.add(btnTaiKhoan);

        btnDoiMatKhau.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnDoiMatKhau.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/exemple/icon/doimk.png"))); // NOI18N
        btnDoiMatKhau.setText("Đổi mật khẩu");
        btnDoiMatKhau.setFocusable(false);
        btnDoiMatKhau.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnDoiMatKhau.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnDoiMatKhau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDoiMatKhauActionPerformed(evt);
            }
        });
        jToolBar1.add(btnDoiMatKhau);
        jToolBar1.add(jSeparator6);

        btnThongKe.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnThongKe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/exemple/icon/thongke.png"))); // NOI18N
        btnThongKe.setText("Thống kê");
        btnThongKe.setFocusable(false);
        btnThongKe.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnThongKe.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnThongKe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThongKeActionPerformed(evt);
            }
        });
        jToolBar1.add(btnThongKe);
        jToolBar1.add(jSeparator8);

        btnHoTro.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnHoTro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/exemple/icon/trogiup.png"))); // NOI18N
        btnHoTro.setText("Trợ giúp");
        btnHoTro.setFocusable(false);
        btnHoTro.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnHoTro.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnHoTro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHoTroActionPerformed(evt);
            }
        });
        jToolBar1.add(btnHoTro);
        jToolBar1.add(jSeparator1);

        btnGioiThieu.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnGioiThieu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/exemple/icon/gioithieu.png"))); // NOI18N
        btnGioiThieu.setText("Giới thiệu");
        btnGioiThieu.setFocusable(false);
        btnGioiThieu.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnGioiThieu.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnGioiThieu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGioiThieuActionPerformed(evt);
            }
        });
        jToolBar1.add(btnGioiThieu);
        jToolBar1.add(jSeparator9);

        btnDangXuat.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnDangXuat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/exemple/icon/dangxuat.png"))); // NOI18N
        btnDangXuat.setText("Đăng xuất");
        btnDangXuat.setFocusable(false);
        btnDangXuat.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnDangXuat.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnDangXuat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDangXuatActionPerformed(evt);
            }
        });
        jToolBar1.add(btnDangXuat);

        lblXinChao.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblXinChao.setForeground(new java.awt.Color(0, 51, 255));
        lblXinChao.setText("Xin chào, ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 732, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblXinChao)
                .addGap(83, 83, 83))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblXinChao)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
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

    private void panelSoDoPhongMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelSoDoPhongMousePressed

    }//GEN-LAST:event_panelSoDoPhongMousePressed

    private void btnTaiKhoanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTaiKhoanActionPerformed
        showInformationUser();
    }//GEN-LAST:event_btnTaiKhoanActionPerformed
    private void showInformationUser() {
        JLabel lblTaiKhoanNV = new JLabel(Auth.user.getMaNV());
        JLabel lblHoTen = new JLabel(Auth.user.getHoTen());
        JLabel lblDiaChi = new JLabel(Auth.user.getDiaChi());
        JLabel lblSoDienThoai = new JLabel(Auth.user.getSoDienThoai());
        JLabel lblNgaySinh = new JLabel(Auth.user.getNgaySinh().toString());
        JLabel lblCMT = new JLabel(Auth.user.getCMND_CCCD());
        JLabel lblVaiTro = new JLabel(Auth.user.getTenVaiTro());
        lblTaiKhoanNV.setForeground(Color.blue);
        lblHoTen.setForeground(Color.blue);
        lblDiaChi.setForeground(Color.blue);
        lblSoDienThoai.setForeground(Color.blue);
        lblNgaySinh.setForeground(Color.blue);
        lblCMT.setForeground(Color.blue);
        lblVaiTro.setForeground(Color.blue);
        lblTaiKhoanNV.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lblHoTen.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lblDiaChi.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lblSoDienThoai.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lblNgaySinh.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lblCMT.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lblVaiTro.setFont(new Font("Tahoma", Font.PLAIN, 13));
        Object[] object = {
            "Tên đăng nhập:", lblTaiKhoanNV,
            "Họ tên:", lblHoTen,
            "Số CMT:", lblCMT,
            "Ngày sinh:", lblNgaySinh,
            "Số điện thoại:", lblSoDienThoai,
            "Địa chỉ:", lblDiaChi,
            "Vai trò:", lblVaiTro
        };
        JOptionPane.showMessageDialog(this, object, "Thông tin tài khoản", JOptionPane.INFORMATION_MESSAGE);
    }
    private void btnThongKeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThongKeActionPerformed
        try {
            new thongke().setVisible(true);
        } catch (SQLException ex) {
        }
    }//GEN-LAST:event_btnThongKeActionPerformed

    private void btnDangXuatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDangXuatActionPerformed
        Auth.user = null;
        this.dispose();
        new Login().setVisible(true);

    }//GEN-LAST:event_btnDangXuatActionPerformed

    private void btnDoiMatKhauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDoiMatKhauActionPerformed
       new DoiMatKhauJFrame().setVisible(true);
    }//GEN-LAST:event_btnDoiMatKhauActionPerformed

    private void btnHoTroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHoTroActionPerformed
       new HoTroJDialog(this, true).setVisible(true);
    }//GEN-LAST:event_btnHoTroActionPerformed

    private void btnGioiThieuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGioiThieuActionPerformed
       try {
            Desktop.getDesktop().browse(new File("help/index.html").toURI());
        } catch (Exception e) {
            MsgBox.alert(this, "Không tìm thấy trang giới thiệu!");
        }
    }//GEN-LAST:event_btnGioiThieuActionPerformed

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
    private javax.swing.JButton btnDangXuat;
    private javax.swing.JButton btnDoiMatKhau;
    private javax.swing.JButton btnGioiThieu;
    private javax.swing.JButton btnHoTro;
    private javax.swing.JButton btnTaiKhoan;
    private javax.swing.JButton btnThongKe;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator6;
    private javax.swing.JToolBar.Separator jSeparator8;
    private javax.swing.JToolBar.Separator jSeparator9;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JLabel lblDatPhong;
    private javax.swing.JLabel lblDichVu;
    private javax.swing.JLabel lblDoiTac;
    private javax.swing.JLabel lblHoaDon;
    private javax.swing.JLabel lblKhoHang;
    private javax.swing.JLabel lblKhuyenMai;
    private javax.swing.JLabel lblNhanVien;
    private javax.swing.JLabel lblPhong;
    private javax.swing.JLabel lblSoDoPhong;
    private javax.swing.JLabel lblXinChao;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JPanel panelDatPhong;
    private javax.swing.JPanel panelDichVu;
    private javax.swing.JPanel panelDoiTac;
    private javax.swing.JPanel panelHoaDon;
    private javax.swing.JPanel panelKhoHang;
    private javax.swing.JPanel panelKhuyenMai;
    private javax.swing.JPanel panelNhanVien;
    private javax.swing.JPanel panelPhong;
    private javax.swing.JPanel panelSoDoPhong;
    private javax.swing.JPanel slidePanel;
    // End of variables declaration//GEN-END:variables
}
