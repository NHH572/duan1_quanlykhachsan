/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.exemple.views;

import com.exemple.controller.DatPhongDAO;
import com.exemple.controller.KhachHangDAO;
import com.exemple.controller.LoaiPhongDAO;
import com.exemple.controller.PhongDAO;
import com.exemple.entity.DatPhong;
import com.exemple.entity.KhachHang;
import com.exemple.entity.LoaiPhong;
import com.exemple.entity.Phong;
import com.exemple.helper.Auth;
import com.exemple.helper.MsgBox;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Minh Triet
 */
public class QuanLyDatPhongJPanel extends javax.swing.JPanel {

    private LoaiPhongDAO lpDAO = new LoaiPhongDAO();
    private List<LoaiPhong> listLoaiPhong = lpDAO.getAll();
    private String textDefault = "Tìm kiếm theo số chứng minh nhân dân....";
    private int rowDatPhong = -1;
    private int maPhong = -1;
    private int maDatPhong = -1;

    public QuanLyDatPhongJPanel() {
        initComponents();
        init();
    }

    private void init() {
        fillComboBoxLoaiPhong();
        placeHolder(txtSearch, textDefault);
        addToModelDatPhong(0, "");
        lblTrangThai.setText("");
        setColorTableDatPhong();
        enableButton();
        disposeLabelSoPhong();
    }
    private void disposeLabelSoPhong(){
        lblSoPhong1.setVisible(false);
        lblSoPhong.setVisible(false);
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

    private void fillToTableDatPhong() {
        if (txtSearch.getText().equalsIgnoreCase(textDefault) || txtSearch.getText().isEmpty()) {
            addToModelDatPhong(cbbLoai.getSelectedIndex(), "");
        } else {
            addToModelDatPhong(cbbLoai.getSelectedIndex(), txtSearch.getText());
        }
    }

    private void setColorTableDatPhong() {
//        tblDatPhong.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
//            @Override
//            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
//                final Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
//                c.setBackground(row % 2 == 0 ? Color.LIGHT_GRAY : Color.WHITE);
//                return c;
//            }
//        });
    }

    private void addToModelDatPhong(int indexCbb, String txtSearch) {
        DefaultTableModel model = (DefaultTableModel) tblDatPhong.getModel();
        model.setRowCount(0);
        List<DatPhong> list;
        if (indexCbb == 0) {
            DatPhongDAO dpDAO = new DatPhongDAO();
            list = dpDAO.selectFollowSearch(txtSearch);
        } else if (indexCbb == 1) {
            DatPhongDAO dpDAO = new DatPhongDAO();
            list = dpDAO.selectFollowComboBox("null", txtSearch);
        } else {
            DatPhongDAO dpDAO = new DatPhongDAO();
            list = dpDAO.selectFollowComboBox("not null", txtSearch);
        }
        for (DatPhong dp : list) {
            Object[] row = {
                dp.getMaDatPhong(),
                dp.getSoCMT(),
                dp.getNgayDat(),
                dp.getNgayNhanPhong(),
                dp.getNgayMuonTra(),
                dp.getTamTinh() * lpDAO.selectByDonGiaTheoNgay(dp.getMaLoaiPhong()),
                lpDAO.getTenLoaiPhong(dp.getMaLoaiPhong()),
                dp.getTaiKhoanNV(),
                dp.getMaPhong()
            };
            model.addRow(row);
        }
    }

    private void fillComboBoxLoaiPhong() {
        try {
            DefaultComboBoxModel model = (DefaultComboBoxModel) cbbLoaiPhong.getModel();
            model.removeAllElements();
            for (LoaiPhong lp : listLoaiPhong) {
                model.addElement(lp.getTenLoaiPhong());
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

        buttonGroupGioiTinh = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        Tabs = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        txtSearch = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDatPhong = new javax.swing.JTable();
        cbbLoai = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        btnThem = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnMoi = new javax.swing.JButton();
        btnLast = new javax.swing.JButton();
        btnNext = new javax.swing.JButton();
        btnFirst = new javax.swing.JButton();
        btnPrevious = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        txtSoCMTKH = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtHoTen = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        lblGioiTinh = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        txtSoDienThoai = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        txtQuocTich = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        txtNgaySinh = new com.toedter.calendar.JDateChooser();
        rdoNam = new javax.swing.JRadioButton();
        rdoNu = new javax.swing.JRadioButton();
        btnDatPhong = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        lblTrangThai = new javax.swing.JLabel();
        cbbLoaiPhong = new javax.swing.JComboBox<>();
        txtNgayDat = new com.toedter.calendar.JDateChooser();
        jLabel17 = new javax.swing.JLabel();
        txtNgayNhanPhong = new com.toedter.calendar.JDateChooser();
        jLabel18 = new javax.swing.JLabel();
        txtNgayMuonTra = new com.toedter.calendar.JDateChooser();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblPhongTrong = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        txtTamTinh = new javax.swing.JLabel();
        lblSoPhong1 = new javax.swing.JLabel();
        lblSoPhong = new javax.swing.JLabel();

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 51, 153));
        jLabel1.setText("QUẢN LÝ ĐẶT PHÒNG");

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tìm kiếm", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        txtSearch.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        txtSearch.setForeground(new java.awt.Color(102, 102, 102));
        txtSearch.setText("Tìm kiếm theo số chứng minh nhân dân....");
        txtSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearchActionPerformed(evt);
            }
        });
        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchKeyReleased(evt);
            }
        });

        jButton5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton5.setText("Tìm");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtSearch)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton5)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        tblDatPhong.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã đặt phòng", "Số CMT Khách hàng", "Ngày đặt", "Ngày nhận", "Ngày trả", "Tạm tính", "Loại phòng", "Nhân viên đặt", "Mã phòng"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblDatPhong.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDatPhongMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblDatPhong);

        cbbLoai.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cbbLoai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất cả", "Chưa đặt", "Đã đặt" }));
        cbbLoai.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbbLoaiItemStateChanged(evt);
            }
        });
        cbbLoai.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbbLoaiMouseClicked(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 153, 153));
        jLabel6.setText("Loại");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbbLoai, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 708, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbbLoai, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 514, Short.MAX_VALUE))
        );

        Tabs.addTab("Danh sách", jPanel1);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Tạm tính:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("Loại phòng:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setText("Ngày đặt:");

        btnThem.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/exemple/icon/add.png"))); // NOI18N
        btnThem.setText("Thêm ");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnXoa.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnXoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/exemple/icon/deleteService.png"))); // NOI18N
        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btnSua.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnSua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/exemple/icon/update.png"))); // NOI18N
        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnMoi.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnMoi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/exemple/icon/new.png"))); // NOI18N
        btnMoi.setText("Mới");
        btnMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMoiActionPerformed(evt);
            }
        });

        btnLast.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnLast.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/exemple/icon/Last.png"))); // NOI18N
        btnLast.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLastActionPerformed(evt);
            }
        });

        btnNext.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnNext.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/exemple/icon/next.png"))); // NOI18N
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });

        btnFirst.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnFirst.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/exemple/icon/First.png"))); // NOI18N
        btnFirst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFirstActionPerformed(evt);
            }
        });

        btnPrevious.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnPrevious.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/exemple/icon/previous.png"))); // NOI18N
        btnPrevious.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPreviousActionPerformed(evt);
            }
        });

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Thông tin khách hàng"));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setText("Số CMND KH:");

        txtSoCMTKH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSoCMTKHActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel10.setText("Họ tên:");

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel12.setText("Giới tính:");

        lblGioiTinh.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel14.setText("Số điện thoại:");

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel15.setText("Email:");

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel16.setText("Quốc tịch");

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel19.setText("Ngày sinh:");

        buttonGroupGioiTinh.add(rdoNam);
        rdoNam.setText("Nam");

        buttonGroupGioiTinh.add(rdoNu);
        rdoNu.setText("Nữ");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19)
                    .addComponent(jLabel14)
                    .addComponent(jLabel15)
                    .addComponent(jLabel16))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtHoTen)
                            .addComponent(txtNgaySinh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtQuocTich, javax.swing.GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE)
                            .addComponent(txtSoDienThoai)
                            .addComponent(txtEmail)
                            .addComponent(txtSoCMTKH)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(rdoNam)
                        .addGap(26, 26, 26)
                        .addComponent(rdoNu)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblGioiTinh, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtSoCMTKH, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblGioiTinh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(0, 2, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rdoNam)
                            .addComponent(rdoNu))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtNgaySinh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSoDienThoai, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtQuocTich, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        btnDatPhong.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnDatPhong.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/exemple/icon/datPhong2.png"))); // NOI18N
        btnDatPhong.setText("Đặt phòng");
        btnDatPhong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDatPhongActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Trạng thái:");

        lblTrangThai.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblTrangThai.setForeground(new java.awt.Color(0, 204, 0));
        lblTrangThai.setText("Trạng thái");

        cbbLoaiPhong.setName("Loại phòng"); // NOI18N
        cbbLoaiPhong.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbbLoaiPhongItemStateChanged(evt);
            }
        });

        txtNgayDat.setName("Ngày đặt phòng"); // NOI18N

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel17.setText("Ngày nhận phòng:");

        txtNgayNhanPhong.setName("Ngày nhận phòng"); // NOI18N
        txtNgayNhanPhong.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                txtNgayNhanPhongPropertyChange(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel18.setText("Ngày muốn trả:");

        txtNgayMuonTra.setName("Ngày muốn trả"); // NOI18N
        txtNgayMuonTra.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                txtNgayMuonTraPropertyChange(evt);
            }
        });

        tblPhongTrong.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã phòng", "Tên phòng", "Lầu", "Trạng thái"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblPhongTrong.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPhongTrongMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblPhongTrong);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 204, 51));
        jLabel4.setText("Danh sách các phòng trống");

        txtTamTinh.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtTamTinh.setForeground(new java.awt.Color(0, 51, 204));
        txtTamTinh.setText("Tạm tính");

        lblSoPhong1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblSoPhong1.setText("Số phòng:");

        lblSoPhong.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblSoPhong.setForeground(new java.awt.Color(153, 0, 153));
        lblSoPhong.setText("Số phòng");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane2)
                        .addContainerGap())
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(txtNgayMuonTra, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(txtNgayNhanPhong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(txtNgayDat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(cbbLoaiPhong, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addGap(36, 36, 36))
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(lblTrangThai)
                                                    .addComponent(txtTamTinh)
                                                    .addComponent(lblSoPhong))
                                                .addGap(0, 0, Short.MAX_VALUE))))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addGap(199, 199, 199)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(lblSoPhong1, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28))))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(213, 213, 213)
                        .addComponent(btnFirst)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnPrevious)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnNext)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnLast))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(145, 145, 145)
                        .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(293, 293, 293)
                        .addComponent(btnDatPhong)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(cbbLoaiPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(11, 11, 11)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtNgayDat, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtNgayNhanPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel17))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtNgayMuonTra, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel18))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtTamTinh))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTrangThai)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblSoPhong1)
                            .addComponent(lblSoPhong))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel4))
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLast)
                    .addComponent(btnNext)
                    .addComponent(btnPrevious)
                    .addComponent(btnFirst))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThem)
                    .addComponent(btnXoa)
                    .addComponent(btnSua)
                    .addComponent(btnMoi))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDatPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );

        Tabs.addTab("Cập nhập", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Tabs)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(238, 238, 238))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Tabs))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cbbLoaiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbbLoaiMouseClicked

    }//GEN-LAST:event_cbbLoaiMouseClicked

    private void cbbLoaiItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbbLoaiItemStateChanged
        String txt = txtSearch.getText();
        fillToTableDatPhong();
    }//GEN-LAST:event_cbbLoaiItemStateChanged

    private void txtSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearchActionPerformed

    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased
        fillToTableDatPhong();
    }//GEN-LAST:event_txtSearchKeyReleased
    private void showInformation() {
        try {
            int maDatPhong = (int) tblDatPhong.getValueAt(rowDatPhong, 0);
            DatPhongDAO dpDAO = new DatPhongDAO();
            DatPhong dp = dpDAO.selectById(maDatPhong);
            int maLoaiPhong = dp.getMaLoaiPhong();
            cbbLoaiPhong.setSelectedIndex(maLoaiPhong - 1);
            txtNgayDat.setDate(dp.getNgayDat());
            txtNgayNhanPhong.setDate(dp.getNgayNhanPhong());
            txtNgayMuonTra.setDate(dp.getNgayMuonTra());
            int tamTinh = dp.getTamTinh() * lpDAO.selectByDonGiaTheoNgay(maLoaiPhong);
            txtTamTinh.setText(String.valueOf(tamTinh));
            if (dp.getTaiKhoanNV() == null) {
                lblTrangThai.setText("Chưa xác nhận");
                lblTrangThai.setForeground(Color.red);
                btnDatPhong.setEnabled(true);
                disposeLabelSoPhong();
            } else {
                lblTrangThai.setText("Đã xác nhận");
                lblSoPhong1.setVisible(true);
                lblSoPhong.setVisible(true);
                Phong p=new PhongDAO().selectById(String.valueOf(dp.getMaPhong()));
                lblSoPhong.setText(String.valueOf(p.getSoPhong()));
                lblTrangThai.setForeground(new Color(0, 204, 0));
                btnDatPhong.setEnabled(false);
            }
            txtSoCMTKH.setText(dp.getSoCMT());
            txtHoTen.setText(dp.getHoTen());
            if (dp.isGioiTinh()) {
                rdoNu.setSelected(true);
            } else {
                rdoNam.setSelected(true);
            }
            txtNgaySinh.setDate(dp.getNgaySinh());
            txtSoDienThoai.setText(dp.getSoDienThoai());
            txtEmail.setText(dp.getEmail());
            txtQuocTich.setText(dp.getQuocTich());
            PhongDAO pDAO = new PhongDAO();
            List<Phong> listPhong = pDAO.selectByMaLoaiPhong(String.valueOf(maLoaiPhong));
            fillTotablePhongTrong(listPhong);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void fillTotablePhongTrong(List<Phong> listPhong) {
        DefaultTableModel model = (DefaultTableModel) tblPhongTrong.getModel();
        model.setRowCount(0);
        for (Phong p : listPhong) {
            Object[] row = {
                p.getMaPhong(),
                p.getSoPhong(),
                p.getLau(),
                p.getTrangThai()
            };
            model.addRow(row);
        }
    }
    private void tblDatPhongMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDatPhongMouseClicked
        if (evt.getClickCount() == 2) {
            rowDatPhong = tblDatPhong.rowAtPoint(evt.getPoint()); //lấy vị trí dòng được chọn
            maDatPhong = (int) tblDatPhong.getValueAt(rowDatPhong, 0);
            if (rowDatPhong >= 0) {
                showInformation();
                Tabs.setSelectedIndex(1);
            }
            enableButton();
        }
    }//GEN-LAST:event_tblDatPhongMouseClicked

    private void tblPhongTrongMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPhongTrongMouseClicked
        int row = tblPhongTrong.getSelectedRow();
        maPhong = (int) tblPhongTrong.getValueAt(row, 0);
    }//GEN-LAST:event_tblPhongTrongMouseClicked

    private void btnDatPhongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDatPhongActionPerformed
        if (maPhong == -1) {
            return;
        }
        DatPhongDAO dpDAO = new DatPhongDAO();
        /// Sửa lại tài khoản nhân viên        
        String taiKhoanNV = Auth.user.getMaNV();
        int maDatPhong = (int) tblDatPhong.getValueAt(rowDatPhong, 0);
        int maLoaiPhong = cbbLoaiPhong.getSelectedIndex() + 1;
        dpDAO.updateDatPhong(maPhong, taiKhoanNV, maDatPhong, maLoaiPhong);
        PhongDAO pDAO = new PhongDAO();
        pDAO.updateTrangThai(maPhong);
        JOptionPane.showMessageDialog(this, "Đặt phòng thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        fillToTableDatPhong();
        showInformation();
    }//GEN-LAST:event_btnDatPhongActionPerformed
    private void clearForm() {
        cbbLoaiPhong.setSelectedIndex(0);
        txtNgayDat.setDate(null);
        txtNgayNhanPhong.setDate(null);
        txtNgayMuonTra.setDate(null);
        lblTrangThai.setText("");
        txtSoCMTKH.setText("");
        txtHoTen.setText("");
        txtSoDienThoai.setText("");
        txtEmail.setText("");
        rdoNam.setSelected(true);
        txtNgaySinh.setDate(null);
        txtQuocTich.setText("");
        lblSoPhong.setVisible(false);
        lblSoPhong1.setVisible(false);
    }

    private void enableButton() {
        if (maDatPhong == -1) {
            btnThem.setEnabled(true);
            btnXoa.setEnabled(false);
            btnSua.setEnabled(false);
            btnDatPhong.setEnabled(false);
        } else {
            btnThem.setEnabled(false);
            btnXoa.setEnabled(true);
            btnSua.setEnabled(true);
        }

    }
    private void btnMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMoiActionPerformed
        maDatPhong = -1;
        clearForm();
        enableButton();
    }//GEN-LAST:event_btnMoiActionPerformed

    private void cbbLoaiPhongItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbbLoaiPhongItemStateChanged
        PhongDAO pDAO = new PhongDAO();
        List<Phong> listPhong = pDAO.selectByMaLoaiPhong(String.valueOf(cbbLoaiPhong.getSelectedIndex() + 1));
        if (listPhong != null) {
            fillTotablePhongTrong(listPhong);
            setTamTinh();
        }
    }//GEN-LAST:event_cbbLoaiPhongItemStateChanged
    private boolean insertDatPhong() {
        try {
            DatPhong dp = new DatPhong();
            Date ngayDat = new Date();
            dp.setNgayDat(ngayDat);
            dp.setNgayNhanPhong(txtNgayNhanPhong.getDate());
            dp.setNgayMuonTra(txtNgayMuonTra.getDate());
            dp.setTamTinh(Integer.valueOf(txtTamTinh.getText()));
            dp.setMaPhong(maPhong);
            dp.setSoCMT(txtSoCMTKH.getText());
            dp.setTaiKhoanNV(Auth.user.getMaNV());
            dp.setMaLoaiPhong(cbbLoaiPhong.getSelectedIndex() + 1);

            KhachHang kh = new KhachHang();
            kh.setCMND(txtSoCMTKH.getText());
            kh.setTenKhachHang(txtHoTen.getText());
            if (rdoNu.isSelected()) {
                kh.setGioiTinh(true);
            } else {
                kh.setGioiTinh(false);
            }
            kh.setNgaySinh(txtNgaySinh.getDate());
            kh.setSoDienThoai(txtSoDienThoai.getText());
            kh.setEmail(txtEmail.getText());
            kh.setQuocTich(txtQuocTich.getText());
            kh.setSoLanThue(0);
            if (!checkCMTTonTai()) {
                KhachHangDAO khDAO = new KhachHangDAO();
                khDAO.insert(kh);
            }
            new DatPhongDAO().insert(dp);
            PhongDAO pDAO = new PhongDAO();
            pDAO.updateTrangThai(maPhong);
            lblTrangThai.setText("Đã xác nhận");
            txtNgayDat.setDate(ngayDat);
            fillToTableDatPhong();
            updateDanhSachPhongTrong();
            rowDatPhong = -1;
            maPhong = -1;
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private void updateDanhSachPhongTrong() {
        List<Phong> listPhong = new PhongDAO().selectByMaLoaiPhong(String.valueOf(cbbLoaiPhong.getSelectedIndex() + 1));
        fillTotablePhongTrong(listPhong);
    }

    private boolean checkCMTTonTai() {
        KhachHangDAO khDAO = new KhachHangDAO();
        List<KhachHang> listKhachHang = khDAO.selectAll();
        for (KhachHang kh : listKhachHang) {
            if (txtSoCMTKH.getText().equals(kh.getCMND())) {
                return true;
            }
        }
        return false;
    }
    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        if (maPhong == -1) {
            JOptionPane.showMessageDialog(this, "Chọn một phòng trống!");
            return;
        }
        if (insertDatPhong()) {
            JOptionPane.showMessageDialog(this, "Thêm thành công!");
        } else {
            JOptionPane.showMessageDialog(this, "Thêm thất bại!", "Thông báo", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        if (rowDatPhong < tblDatPhong.getRowCount() - 1) {
            rowDatPhong++;
        } else {
            rowDatPhong = 0;
        }
        showInformation();
    }//GEN-LAST:event_btnNextActionPerformed

    private void btnPreviousActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPreviousActionPerformed
        if (rowDatPhong > 0) {
            rowDatPhong--;
        } else {
            rowDatPhong = tblDatPhong.getRowCount() - 1;
        }
        showInformation();
    }//GEN-LAST:event_btnPreviousActionPerformed

    private void btnFirstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFirstActionPerformed
        rowDatPhong = 0;
        showInformation();
    }//GEN-LAST:event_btnFirstActionPerformed

    private void btnLastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLastActionPerformed
        rowDatPhong = tblDatPhong.getRowCount() - 1;
        showInformation();
    }//GEN-LAST:event_btnLastActionPerformed

    private void txtSoCMTKHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSoCMTKHActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSoCMTKHActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        if (rowDatPhong == -1) {
            return;
        }
        if (updateDatPhong()) {
            JOptionPane.showMessageDialog(this, "Sửa thành công!");
        } else {
            JOptionPane.showMessageDialog(this, "Sửa thất bại!", "Thông báo", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnSuaActionPerformed
    private boolean updateDatPhong() {
        try {
            DatPhong dp = new DatPhong();
            dp.setMaDatPhong(maDatPhong);
            Date ngayDat = new Date();
            dp.setNgayDat(ngayDat);
            dp.setNgayNhanPhong(txtNgayNhanPhong.getDate());
            dp.setNgayMuonTra(txtNgayMuonTra.getDate());
            dp.setTamTinh(Integer.valueOf(txtTamTinh.getText()));
            if(maPhong==-1){
                dp.setMaPhong((int) tblDatPhong.getValueAt(rowDatPhong, 8));
            }else{
                dp.setMaPhong(maPhong);
            }            
            dp.setSoCMT(txtSoCMTKH.getText());
            dp.setTaiKhoanNV(Auth.user.getMaNV());
            dp.setMaLoaiPhong(cbbLoaiPhong.getSelectedIndex() + 1);

            KhachHangDAO khDAO = new KhachHangDAO();
            KhachHang kh = new KhachHang();
            kh.setCMND(txtSoCMTKH.getText());
            kh.setTenKhachHang(txtHoTen.getText());
            if (rdoNu.isSelected()) {
                kh.setGioiTinh(true);
            } else {
                kh.setGioiTinh(false);
            }
            kh.setNgaySinh(txtNgaySinh.getDate());
            kh.setSoDienThoai(txtSoDienThoai.getText());
            kh.setEmail(txtEmail.getText());
            kh.setQuocTich(txtQuocTich.getText());
            kh.setSoLanThue(0);            
            khDAO.update(kh);
            DatPhongDAO dpDAO = new DatPhongDAO();            
            DatPhong dpOld = dpDAO.selectById(maDatPhong);
            int maPhongOld = dpOld.getMaPhong();
            PhongDAO pDAO = new PhongDAO();
            pDAO.updateTrangThaiTrong(maPhongOld);
            
            dpDAO.update(dp);            
            pDAO.updateTrangThai(maPhong); 
            
            
            showInformation();
            updateDanhSachPhongTrong();
            fillToTableDatPhong();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private boolean xoaDatPhong() {
        try {
            DatPhongDAO dpDAO = new DatPhongDAO();
            DatPhong dp = dpDAO.selectById(maDatPhong);
            int maPhong = dp.getMaPhong();
            if (maPhong == 0) {
                dpDAO.delete(maDatPhong);
            } else {
                new PhongDAO().updateTrangThaiTrong(maPhong);
                dpDAO.delete(maDatPhong);
            }
            updateDanhSachPhongTrong();
            fillToTableDatPhong();
            clearForm();
            rowDatPhong = -1;
            maDatPhong = -1;
            enableButton();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        if (rowDatPhong == -1) {
            return;
        }
        int confirm = JOptionPane.showConfirmDialog(this, "Bạn có muốn xóa không?");
        if (confirm == JOptionPane.YES_OPTION) {
            if (xoaDatPhong()) {
                JOptionPane.showMessageDialog(this, "Xóa thành công!");
            } else {
                JOptionPane.showMessageDialog(this, "Xóa thất bại!", "Thông báo", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnXoaActionPerformed
    private int getDifferenceDays(Date d1, Date d2) {
        long diff = d2.getTime() - d1.getTime();
        //Trừ ra ngày
        return (int) diff / (60 * 60 * 1000 * 24);
    }

    private void setTamTinh() {
        if (txtNgayNhanPhong.getDate() == null || txtNgayMuonTra.getDate() == null) {
            txtTamTinh.setText("");
        } else {
            int soNgayThue = getDifferenceDays(txtNgayNhanPhong.getDate(), txtNgayMuonTra.getDate());
            if (soNgayThue < 0) {
                JOptionPane.showMessageDialog(this, txtNgayMuonTra.getName() + " phải lớn hơn " + txtNgayNhanPhong.getName());
                txtNgayMuonTra.setBackground(Color.pink);
                txtNgayMuonTra.setFocusable(true);
                return;
            }
            int tamTinh = listLoaiPhong.get(cbbLoaiPhong.getSelectedIndex()).getDonGiaTheoNgay() * soNgayThue;
            txtTamTinh.setText(String.valueOf(tamTinh));
        }
    }


    private void txtNgayMuonTraPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_txtNgayMuonTraPropertyChange
        setTamTinh();
    }//GEN-LAST:event_txtNgayMuonTraPropertyChange

    private void txtNgayNhanPhongPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_txtNgayNhanPhongPropertyChange
//        setTamTinh();
    }//GEN-LAST:event_txtNgayNhanPhongPropertyChange


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane Tabs;
    private javax.swing.JButton btnDatPhong;
    private javax.swing.JButton btnFirst;
    private javax.swing.JButton btnLast;
    private javax.swing.JButton btnMoi;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnPrevious;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnXoa;
    private javax.swing.ButtonGroup buttonGroupGioiTinh;
    private javax.swing.JComboBox<String> cbbLoai;
    private javax.swing.JComboBox<String> cbbLoaiPhong;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblGioiTinh;
    private javax.swing.JLabel lblSoPhong;
    private javax.swing.JLabel lblSoPhong1;
    private javax.swing.JLabel lblTrangThai;
    private javax.swing.JRadioButton rdoNam;
    private javax.swing.JRadioButton rdoNu;
    private javax.swing.JTable tblDatPhong;
    private javax.swing.JTable tblPhongTrong;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtHoTen;
    private com.toedter.calendar.JDateChooser txtNgayDat;
    private com.toedter.calendar.JDateChooser txtNgayMuonTra;
    private com.toedter.calendar.JDateChooser txtNgayNhanPhong;
    private com.toedter.calendar.JDateChooser txtNgaySinh;
    private javax.swing.JTextField txtQuocTich;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txtSoCMTKH;
    private javax.swing.JTextField txtSoDienThoai;
    private javax.swing.JLabel txtTamTinh;
    // End of variables declaration//GEN-END:variables

}
