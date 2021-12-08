/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.exemple.views;

import java.util.List;
import com.exemple.controller.thongKeDAO;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author philong
 */
public class thongke extends javax.swing.JFrame {

    thongKeDAO dao = new thongKeDAO();

    /**
     * Creates new form thongke
     */
    public thongke() {
        initComponents();
        fillComboBoxThagSLKH();
        fillComboBoxThagDTHD();
        fillComboBoxThagDTTP();
        fillComboBoxThagDTDV();
    }

    void fillComboBoxThagSLKH() {
        try {
            DefaultComboBoxModel mode = (DefaultComboBoxModel) cbo_bd1.getModel();
            DefaultComboBoxModel mode1 = (DefaultComboBoxModel) cbo_kt1.getModel();
            mode.removeAllElements();
            mode1.removeAllElements();

            List<Integer> list = dao.selectYear();
            for (Integer thang : list) {
                mode.addElement(thang);
                mode1.addElement(thang);

                this.fillTableSLKH();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void fillComboBoxThagDTHD() {
        try {
            DefaultComboBoxModel mode = (DefaultComboBoxModel) cbo_bd.getModel();
            DefaultComboBoxModel mode1 = (DefaultComboBoxModel) cbo_kt.getModel();
            mode.removeAllElements();
            mode1.removeAllElements();

            List<Integer> list = dao.selectYear();
            for (Integer thang : list) {
                mode.addElement(thang);
                mode1.addElement(thang);

                this.fillTableDoanhThu();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void fillComboBoxThagDTTP() {
        try {
            DefaultComboBoxModel mode = (DefaultComboBoxModel) cbo_bd2.getModel();
            DefaultComboBoxModel mode1 = (DefaultComboBoxModel) cbo_kt2.getModel();
            mode.removeAllElements();
            mode1.removeAllElements();

            List<Integer> list = dao.selectYear();
            for (Integer thang : list) {
                mode.addElement(thang);
                mode1.addElement(thang);

                this.fillTableSLKH();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void fillComboBoxThagDTDV() {
        try {
            DefaultComboBoxModel mode = (DefaultComboBoxModel) cbo_bd3.getModel();
            DefaultComboBoxModel mode1 = (DefaultComboBoxModel) cbo_kt3.getModel();
            mode.removeAllElements();
            mode1.removeAllElements();

            List<Integer> list = dao.selectYear();
            for (Integer thang : list) {
                mode.addElement(thang);
                mode1.addElement(thang);

                this.fillTableSLKH();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void fillTableDoanhThu() {
        try {
            DefaultTableModel model = (DefaultTableModel) tbl_DTHD.getModel();
            model.setRowCount(0);
            int nam_bd = Integer.parseInt(cbo_bd.getSelectedItem().toString());
            int nam_kt = Integer.parseInt(cbo_kt.getSelectedItem().toString());
            List<Object[]> list = dao.getDoanhThuHoaDon(nam_bd, nam_kt);
            for (Object[] row : list) {
                model.addRow(row);
            }

        } catch (Exception e) {
        }
    }

    void fillTableSLKH() {
        try {
            DefaultTableModel model = (DefaultTableModel) tbl_SLKH.getModel();
            model.setRowCount(0);
            int nam_bd = Integer.parseInt(cbo_bd1.getSelectedItem().toString());
            int nam_kt = Integer.parseInt(cbo_kt1.getSelectedItem().toString());
            List<Object[]> list = dao.getSLKH(nam_bd, nam_kt);
            for (Object[] row : list) {
                model.addRow(row);
            }

        } catch (Exception e) {
        }
    }

    void fillTableDoanhThuTienPhong() {
        try {
            DefaultTableModel model = (DefaultTableModel) tbl_DTTP.getModel();
            model.setRowCount(0);
            int nam_bd = Integer.parseInt(cbo_bd2.getSelectedItem().toString());
            int nam_kt = Integer.parseInt(cbo_kt2.getSelectedItem().toString());
            List<Object[]> list = dao.getDoanhThuTienPhong(nam_bd, nam_kt);
            for (Object[] row : list) {
                model.addRow(row);
            }

        } catch (Exception e) {
        }
    }

    void fillTableDoanhThuDichVu() {
        try {
            DefaultTableModel model = (DefaultTableModel) tbl_DTDV.getModel();
            model.setRowCount(0);
            int nam_bd = Integer.parseInt(cbo_bd3.getSelectedItem().toString());
            int nam_kt = Integer.parseInt(cbo_kt3.getSelectedItem().toString());
            List<Object[]> list = dao.getDoanhThuDichVu(nam_bd, nam_kt);
            for (Object[] row : list) {
                model.addRow(row);
            }

        } catch (Exception e) {
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

        jpane = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_DTHD = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        cbo_bd = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        cbo_kt = new javax.swing.JComboBox<>();
        btnInBaoCao = new javax.swing.JToggleButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_SLKH = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        cbo_bd1 = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        cbo_kt1 = new javax.swing.JComboBox<>();
        btnInBaoCao1 = new javax.swing.JToggleButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tbl_DTTP = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        cbo_bd2 = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        cbo_kt2 = new javax.swing.JComboBox<>();
        btnInBaoCao2 = new javax.swing.JToggleButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbl_DTDV = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        cbo_bd3 = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        cbo_kt3 = new javax.swing.JComboBox<>();
        btn_IHD = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tbl_DTHD.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã Hóa Đơn", "Khách Hàng", "Ngày Lập", "Giảm giá", "Tổng tiền"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tbl_DTHD);

        jLabel1.setText("THÁNG BẮT ĐẦU");

        cbo_bd.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));
        cbo_bd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbo_bdActionPerformed(evt);
            }
        });

        jLabel2.setText("THÁNG KẾT THÚC");

        cbo_kt.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));
        cbo_kt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbo_ktActionPerformed(evt);
            }
        });

        btnInBaoCao.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnInBaoCao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/exemple/icon/icons8_exe_30px.png"))); // NOI18N
        btnInBaoCao.setText("In báo báo");
        btnInBaoCao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInBaoCaoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbo_bd, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbo_kt, 0, 356, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnInBaoCao)
                .addGap(78, 78, 78))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cbo_bd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(cbo_kt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(btnInBaoCao)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jpane.addTab("DOANH THU HÓA ĐƠN", new javax.swing.ImageIcon(getClass().getResource("/com/exemple/icon/icons8_purchase_order_26px.png")), jPanel1); // NOI18N

        tbl_SLKH.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Số CMT khách hàng", "Tên Khách Hàng", "Ngày Sinh", "Giới Tính", "Quốc Tịch"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tbl_SLKH);

        jLabel3.setText("Tháng Bắt Đầu");

        cbo_bd1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));
        cbo_bd1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbo_bd1MouseClicked(evt);
            }
        });
        cbo_bd1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbo_bd1ActionPerformed(evt);
            }
        });

        jLabel4.setText("Tháng Kết Thúc");

        cbo_kt1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));
        cbo_kt1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbo_kt1MouseClicked(evt);
            }
        });
        cbo_kt1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbo_kt1ActionPerformed(evt);
            }
        });

        btnInBaoCao1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnInBaoCao1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/exemple/icon/icons8_exe_30px.png"))); // NOI18N
        btnInBaoCao1.setText("In báo báo");
        btnInBaoCao1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInBaoCao1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbo_bd1, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(cbo_kt1, 0, 354, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnInBaoCao1)
                .addGap(126, 126, 126))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cbo_bd1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(cbo_kt1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47)
                .addComponent(btnInBaoCao1)
                .addContainerGap(54, Short.MAX_VALUE))
        );

        jpane.addTab("SỐ LƯỢNG KHÁCH HÀNG", new javax.swing.ImageIcon(getClass().getResource("/com/exemple/icon/nhanvien.png")), jPanel2); // NOI18N

        tbl_DTTP.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tên Phòng", "Loại Phòng", "Số lần thuê", "Tổng tiền"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(tbl_DTTP);

        jLabel7.setText("Tháng Bắt Đầu");

        cbo_bd2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));
        cbo_bd2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbo_bd2ActionPerformed(evt);
            }
        });

        jLabel8.setText("Thấng Kết Thúc");

        cbo_kt2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));
        cbo_kt2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbo_kt2ActionPerformed(evt);
            }
        });

        btnInBaoCao2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnInBaoCao2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/exemple/icon/icons8_exe_30px.png"))); // NOI18N
        btnInBaoCao2.setText("In báo báo");
        btnInBaoCao2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInBaoCao2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbo_bd2, 0, 306, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel8)
                        .addGap(18, 18, 18)
                        .addComponent(cbo_kt2, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnInBaoCao2)
                .addGap(114, 114, 114))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(cbo_bd2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(cbo_kt2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(62, 62, 62)
                .addComponent(btnInBaoCao2)
                .addContainerGap(51, Short.MAX_VALUE))
        );

        jpane.addTab("DOANH THU TIỀN PHÒNG", new javax.swing.ImageIcon(getClass().getResource("/com/exemple/icon/thanhtoan2.png")), jPanel4); // NOI18N

        tbl_DTDV.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tên Dịch Vụ", "Khách hàng thuê", "Nhân viên", "Ngày thuê", "Số lần thuê", "Đơn giá"
            }
        ));
        jScrollPane3.setViewportView(tbl_DTDV);

        jLabel5.setText("THÁNG BẮT ĐẦU");

        cbo_bd3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));
        cbo_bd3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbo_bd3ActionPerformed(evt);
            }
        });

        jLabel6.setText("THÁNG KẾT THÚC");

        cbo_kt3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));
        cbo_kt3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbo_kt3ActionPerformed(evt);
            }
        });

        btn_IHD.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btn_IHD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/exemple/icon/icons8_billing_machine_24px.png"))); // NOI18N
        btn_IHD.setText("In hóa đơn");
        btn_IHD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_IHDActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(cbo_bd3, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(cbo_kt3, 0, 339, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_IHD)
                .addGap(60, 60, 60))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cbo_bd3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(cbo_kt3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(55, 55, 55)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(btn_IHD)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jpane.addTab("DOANH THU DỊCH VỤ", new javax.swing.ImageIcon(getClass().getResource("/com/exemple/icon/icons8_food_service_30px_1.png")), jPanel3); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpane, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 890, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jpane, javax.swing.GroupLayout.PREFERRED_SIZE, 386, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cbo_bdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbo_bdActionPerformed
        fillTableDoanhThu();
    }//GEN-LAST:event_cbo_bdActionPerformed

    private void cbo_bd1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbo_bd1MouseClicked

    }//GEN-LAST:event_cbo_bd1MouseClicked

    private void cbo_kt1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbo_kt1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_cbo_kt1MouseClicked

    private void cbo_bd1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbo_bd1ActionPerformed
        fillTableSLKH();
    }//GEN-LAST:event_cbo_bd1ActionPerformed

    private void cbo_kt1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbo_kt1ActionPerformed
        fillTableSLKH();
    }//GEN-LAST:event_cbo_kt1ActionPerformed

    private void cbo_ktActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbo_ktActionPerformed
        fillTableDoanhThu();
    }//GEN-LAST:event_cbo_ktActionPerformed

    private void cbo_bd2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbo_bd2ActionPerformed
        fillTableDoanhThuTienPhong();
    }//GEN-LAST:event_cbo_bd2ActionPerformed

    private void cbo_kt2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbo_kt2ActionPerformed
        fillTableDoanhThuTienPhong();
    }//GEN-LAST:event_cbo_kt2ActionPerformed

    private void cbo_bd3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbo_bd3ActionPerformed
        fillTableDoanhThuDichVu();
    }//GEN-LAST:event_cbo_bd3ActionPerformed

    private void cbo_kt3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbo_kt3ActionPerformed
        fillTableDoanhThuDichVu();
    }//GEN-LAST:event_cbo_kt3ActionPerformed

    private static void writeToExcell(JTable table) throws FileNotFoundException, IOException {
//        new WorkbookFactory();
        try {
            Workbook wb = new XSSFWorkbook(); //Excell workbook
            Sheet sheet = wb.createSheet(); //WorkSheet
            Row row = sheet.createRow(2); //Row created at line 3
            TableModel model = table.getModel(); //Table model

            Row headerRow = sheet.createRow(0); //Create row at line 0
            for (int headings = 0; headings < model.getColumnCount(); headings++) { //For each column
                headerRow.createCell(headings).setCellValue(model.getColumnName(headings));//Write column name
            }
            for (int rows = 0; rows < model.getRowCount(); rows++) { //For each table row
                for (int cols = 0; cols < table.getColumnCount(); cols++) { //For each table column
                    row.createCell(cols).setCellValue(model.getValueAt(rows, cols).toString()); //Write value
                }

                //Set the row to the next one in the sequence 
                row = sheet.createRow((rows + 3));
            }
            JFileChooser chooser = new JFileChooser();
            int i = chooser.showSaveDialog(chooser);
            if (i == JFileChooser.APPROVE_OPTION) {
                File file = chooser.getSelectedFile();
                try {
                    FileOutputStream out = new FileOutputStream(file + ".xlsx");
                    wb.write(out);
                    out.close();
                    JOptionPane.showMessageDialog(null, "Xuất file thành công!");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    private void btnInBaoCaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInBaoCaoActionPerformed
        try {
            writeToExcell(tbl_DTHD);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_btnInBaoCaoActionPerformed

    private void btnInBaoCao1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInBaoCao1ActionPerformed
        try {
            writeToExcell(tbl_SLKH);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_btnInBaoCao1ActionPerformed

    private void btnInBaoCao2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInBaoCao2ActionPerformed
        try {
            writeToExcell(tbl_DTTP);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_btnInBaoCao2ActionPerformed

    private void btn_IHDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_IHDActionPerformed
        try {
            writeToExcell(tbl_DTDV);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_btn_IHDActionPerformed

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
            java.util.logging.Logger.getLogger(thongke.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(thongke.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(thongke.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(thongke.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new thongke().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton btnInBaoCao;
    private javax.swing.JToggleButton btnInBaoCao1;
    private javax.swing.JToggleButton btnInBaoCao2;
    private javax.swing.JButton btn_IHD;
    private javax.swing.JComboBox<String> cbo_bd;
    private javax.swing.JComboBox<String> cbo_bd1;
    private javax.swing.JComboBox<String> cbo_bd2;
    private javax.swing.JComboBox<String> cbo_bd3;
    private javax.swing.JComboBox<String> cbo_kt;
    private javax.swing.JComboBox<String> cbo_kt1;
    private javax.swing.JComboBox<String> cbo_kt2;
    private javax.swing.JComboBox<String> cbo_kt3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jpane;
    private javax.swing.JTable tbl_DTDV;
    private javax.swing.JTable tbl_DTHD;
    private javax.swing.JTable tbl_DTTP;
    private javax.swing.JTable tbl_SLKH;
    // End of variables declaration//GEN-END:variables
}
