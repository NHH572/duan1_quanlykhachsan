/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.exemple.views;

import java.util.List;
import com.exemple.controller.thongKeDAO;
import com.exemple.entity.Thongke;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
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
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author philong
 */
public class thongke extends javax.swing.JFrame {

    thongKeDAO dao = new thongKeDAO();

    /**
     * Creates new form thongke
     */
    public thongke() throws SQLException {
        initComponents();
        fillComboBoxNam();

    }

    void fillComboBoxNam() {
        try {
            DefaultComboBoxModel mode = (DefaultComboBoxModel) cbo_Nam.getModel();
            DefaultComboBoxModel mode1 = (DefaultComboBoxModel) cbo_Nam1.getModel();
            DefaultComboBoxModel mode2 = (DefaultComboBoxModel) cbo_Nam2.getModel();
            DefaultComboBoxModel mode3 = (DefaultComboBoxModel) cbo_Nam3.getModel();
            mode.removeAllElements();
            mode1.removeAllElements();
            mode2.removeAllElements();
            mode3.removeAllElements();
            List<Integer> list = dao.selectYear();
            for (Integer nam : list) {
                mode.addElement(nam);
                mode1.addElement(nam);
                mode2.addElement(nam);
                mode3.addElement(nam);
                this.fillTableSLKH();
                this.fillTableDoanhThu();
                this.fillTableDoanhThuDichVu();
                this.fillTableDoanhThuTienPhong();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void fillTableDoanhThu() {
        try {
            DefaultTableModel model = (DefaultTableModel) tbl_DTHD.getModel();
            model.setRowCount(0);
            int thang_bd = Integer.parseInt(cbo_bd.getSelectedItem().toString());
            int thang_kt = Integer.parseInt(cbo_kt.getSelectedItem().toString());
            int nam = Integer.parseInt(cbo_Nam.getSelectedItem().toString());
            List<Object[]> list = dao.getDoanhThuHoaDon(thang_bd, thang_kt, nam);
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
            int thang_bd = Integer.parseInt(cbo_bd1.getSelectedItem().toString());
            int thang_kt = Integer.parseInt(cbo_kt1.getSelectedItem().toString());
            int nam = Integer.parseInt(cbo_Nam1.getSelectedItem().toString());
            List<Object[]> list = dao.getSLKH(thang_bd, thang_kt, nam);
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
            int thang_bd = Integer.parseInt(cbo_bd2.getSelectedItem().toString());
            int thang_kt = Integer.parseInt(cbo_kt2.getSelectedItem().toString());
            int nam = Integer.parseInt(cbo_Nam2.getSelectedItem().toString());
            List<Object[]> list = dao.getDoanhThuTienPhong(thang_bd, thang_kt, nam);
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
            int thang_bd = Integer.parseInt(cbo_bd3.getSelectedItem().toString());
            int thang_kt = Integer.parseInt(cbo_kt3.getSelectedItem().toString());
            int nam = Integer.parseInt(cbo_Nam3.getSelectedItem().toString());
            List<Object[]> list = dao.getDoanhThuDichVu(thang_bd, thang_kt, nam);
            for (Object[] row : list) {
                model.addRow(row);
            }

        } catch (Exception e) {
        }
    }

    public void setDataToChart1(JPanel jpnItem, int nam) {
        try {

            List<Thongke> listItem = dao.getDTHT(nam);

            DefaultCategoryDataset dataset = new DefaultCategoryDataset();
            if (listItem != null) {
                for (Thongke item : listItem) {
                    dataset.addValue(item.getSo_luong_khach_hang(), "khách hàng", item.getThang_dang_ky());
                }
            }

            JFreeChart barChart = ChartFactory.createBarChart(
                    "Biểu đồ thống kê doanh thu theo tháng".toUpperCase(),
                    "Thời gian", "Số lượng",
                    dataset, PlotOrientation.VERTICAL, false, true, false);

            ChartPanel chartPanel = new ChartPanel(barChart);
            chartPanel.setPreferredSize(new Dimension(jpnItem.getWidth(), 321));

            jpnItem.removeAll();
            jpnItem.setLayout(new CardLayout());
            jpnItem.add(chartPanel);
            jpnItem.validate();
            jpnItem.repaint();
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
        jLabel2 = new javax.swing.JLabel();
        btnInBaoCao = new javax.swing.JToggleButton();
        jLabel9 = new javax.swing.JLabel();
        cbo_Nam = new javax.swing.JComboBox<>();
        cbo_bd = new javax.swing.JComboBox<>();
        cbo_kt = new javax.swing.JComboBox<>();
        jPanel5 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_SLKH = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnInBaoCao1 = new javax.swing.JToggleButton();
        cbo_Nam1 = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        cbo_bd1 = new javax.swing.JComboBox<>();
        cbo_kt1 = new javax.swing.JComboBox<>();
        jPanel6 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tbl_DTTP = new javax.swing.JTable();
        btnInBaoCao2 = new javax.swing.JToggleButton();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        cbo_Nam2 = new javax.swing.JComboBox<>();
        cbo_bd2 = new javax.swing.JComboBox<>();
        cbo_kt2 = new javax.swing.JComboBox<>();
        jPanel7 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbl_DTDV = new javax.swing.JTable();
        btn_IHD = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        cbo_Nam3 = new javax.swing.JComboBox<>();
        cbo_bd3 = new javax.swing.JComboBox<>();
        cbo_kt3 = new javax.swing.JComboBox<>();
        jPanel8 = new javax.swing.JPanel();

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

        jLabel2.setText("THÁNG KẾT THÚC");

        btnInBaoCao.setText("in báo báo");
        btnInBaoCao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInBaoCaoActionPerformed(evt);
            }
        });

        jLabel9.setText("NĂM:");

        cbo_Nam.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));
        cbo_Nam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbo_NamActionPerformed(evt);
            }
        });

        cbo_bd.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));
        cbo_bd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbo_bdActionPerformed(evt);
            }
        });

        cbo_kt.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));
        cbo_kt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbo_ktActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 288, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 865, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbo_bd, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbo_kt, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbo_Nam, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44))))
            .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnInBaoCao)
                .addGap(79, 79, 79))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel9)
                        .addComponent(cbo_Nam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(jLabel2)
                        .addComponent(cbo_bd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cbo_kt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(26, 26, 26)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnInBaoCao)
                .addGap(18, 18, 18)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jpane.addTab("DOANH THU HÓA ĐƠN", jPanel1);

        tbl_SLKH.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Số CMT khách hàng", "Tên Khách Hàng", "Ngày Sinh", "Ngày tạo", "Giới Tính", "Quốc Tịch"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tbl_SLKH);

        jLabel3.setText("Tháng Bắt Đầu");

        jLabel4.setText("Tháng Kết Thúc");

        btnInBaoCao1.setText("in báo báo");
        btnInBaoCao1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInBaoCao1ActionPerformed(evt);
            }
        });

        cbo_Nam1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));
        cbo_Nam1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbo_Nam1ActionPerformed(evt);
            }
        });

        jLabel10.setText("NĂM:");

        cbo_bd1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));
        cbo_bd1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbo_bd1ActionPerformed(evt);
            }
        });

        cbo_kt1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));
        cbo_kt1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbo_kt1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 311, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 865, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(cbo_bd1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbo_kt1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbo_Nam1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnInBaoCao1)
                .addGap(126, 126, 126))
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel10)
                    .addComponent(cbo_Nam1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbo_bd1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbo_kt1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnInBaoCao1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jpane.addTab("SỐ LƯỢNG KHÁCH HÀNG", jPanel2);

        tbl_DTTP.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tên Phòng", "Loại Phòng", "Số lần thuê", "Tổng tiền", "Ngày tạo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(tbl_DTTP);

        btnInBaoCao2.setText("in báo báo");
        btnInBaoCao2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInBaoCao2ActionPerformed(evt);
            }
        });

        jLabel11.setText("Tháng Bắt Đầu");

        jLabel12.setText("Tháng Kết Thúc");

        jLabel13.setText("NĂM:");

        cbo_Nam2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));
        cbo_Nam2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbo_Nam2ActionPerformed(evt);
            }
        });

        cbo_bd2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));
        cbo_bd2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbo_bd2ActionPerformed(evt);
            }
        });

        cbo_kt2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));
        cbo_kt2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbo_kt2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 311, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 875, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnInBaoCao2)
                .addGap(114, 114, 114))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbo_bd2, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbo_kt2, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbo_Nam2, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
            .addComponent(jPanel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12)
                    .addComponent(jLabel13)
                    .addComponent(cbo_Nam2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbo_bd2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbo_kt2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnInBaoCao2)
                .addGap(3, 3, 3)
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jpane.addTab("DOANH THU TIỀN PHÒNG", jPanel4);

        tbl_DTDV.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tên Dịch Vụ", "Khách hàng thuê", "Nhân viên", "Ngày thuê", "Số lần thuê", "Đơn giá"
            }
        ));
        jScrollPane3.setViewportView(tbl_DTDV);

        btn_IHD.setText("In hóa đơn");
        btn_IHD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_IHDActionPerformed(evt);
            }
        });

        jLabel14.setText("Tháng Bắt Đầu");

        jLabel15.setText("Tháng Kết Thúc");

        jLabel16.setText("NĂM:");

        cbo_Nam3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));
        cbo_Nam3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbo_Nam3ActionPerformed(evt);
            }
        });

        cbo_bd3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));
        cbo_bd3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbo_bd3ActionPerformed(evt);
            }
        });

        cbo_kt3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));
        cbo_kt3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbo_kt3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 279, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_IHD, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 865, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbo_bd3, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbo_kt3, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbo_Nam3, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40))))
            .addComponent(jPanel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cbo_bd3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cbo_kt3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel15))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel14)
                        .addComponent(jLabel16)
                        .addComponent(cbo_Nam3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(26, 26, 26)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_IHD)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jpane.addTab("DOANH THU DỊCH VỤ", jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpane)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpane)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

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

    private void cbo_NamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbo_NamActionPerformed
        fillTableDoanhThu();
        try {
            int nam = Integer.parseInt(cbo_Nam.getSelectedItem().toString());
            setDataToChart1(jPanel5, nam);
        } catch (Exception e) {
        }
    }//GEN-LAST:event_cbo_NamActionPerformed

    private void cbo_Nam1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbo_Nam1ActionPerformed
        fillTableSLKH();
        try {
            int nam = Integer.parseInt(cbo_Nam1.getSelectedItem().toString());
            setDataToChart1(jPanel6, nam);
        } catch (Exception e) {
        }
    }//GEN-LAST:event_cbo_Nam1ActionPerformed

    private void cbo_Nam2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbo_Nam2ActionPerformed
        fillTableDoanhThuTienPhong();
        try {
            int nam = Integer.parseInt(cbo_Nam2.getSelectedItem().toString());
            setDataToChart1(jPanel7, nam);
        } catch (Exception e) {
        }
    }//GEN-LAST:event_cbo_Nam2ActionPerformed

    private void cbo_Nam3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbo_Nam3ActionPerformed
        fillTableDoanhThuDichVu();
        try {
            int nam = Integer.parseInt(cbo_Nam3.getSelectedItem().toString());
            setDataToChart1(jPanel8, nam);
        } catch (Exception e) {
        }
    }//GEN-LAST:event_cbo_Nam3ActionPerformed

    private void cbo_bdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbo_bdActionPerformed
        fillTableDoanhThu();
    }//GEN-LAST:event_cbo_bdActionPerformed

    private void cbo_ktActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbo_ktActionPerformed
        fillTableDoanhThu();
    }//GEN-LAST:event_cbo_ktActionPerformed

    private void cbo_bd1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbo_bd1ActionPerformed
        fillTableSLKH();
    }//GEN-LAST:event_cbo_bd1ActionPerformed

    private void cbo_kt1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbo_kt1ActionPerformed
        fillTableSLKH();
    }//GEN-LAST:event_cbo_kt1ActionPerformed

    private void cbo_bd3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbo_bd3ActionPerformed
        fillTableDoanhThuDichVu();
    }//GEN-LAST:event_cbo_bd3ActionPerformed

    private void cbo_kt3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbo_kt3ActionPerformed
        fillTableDoanhThuDichVu();
    }//GEN-LAST:event_cbo_kt3ActionPerformed

    private void cbo_bd2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbo_bd2ActionPerformed
        fillTableDoanhThuTienPhong();
    }//GEN-LAST:event_cbo_bd2ActionPerformed

    private void cbo_kt2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbo_kt2ActionPerformed
        fillTableDoanhThuTienPhong();
    }//GEN-LAST:event_cbo_kt2ActionPerformed

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
                try {
                    new thongke().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(thongke.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton btnInBaoCao;
    private javax.swing.JToggleButton btnInBaoCao1;
    private javax.swing.JToggleButton btnInBaoCao2;
    private javax.swing.JButton btn_IHD;
    private javax.swing.JComboBox<String> cbo_Nam;
    private javax.swing.JComboBox<String> cbo_Nam1;
    private javax.swing.JComboBox<String> cbo_Nam2;
    private javax.swing.JComboBox<String> cbo_Nam3;
    private javax.swing.JComboBox<String> cbo_bd;
    private javax.swing.JComboBox<String> cbo_bd1;
    private javax.swing.JComboBox<String> cbo_bd2;
    private javax.swing.JComboBox<String> cbo_bd3;
    private javax.swing.JComboBox<String> cbo_kt;
    private javax.swing.JComboBox<String> cbo_kt1;
    private javax.swing.JComboBox<String> cbo_kt2;
    private javax.swing.JComboBox<String> cbo_kt3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
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
