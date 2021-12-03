/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.exemple.views;

import com.exemple.controller.DichVuDAO;
import com.exemple.controller.LoadTableHoaDonDAO;
import com.exemple.controller.PhongDAO;
import com.exemple.controller.TableHoaDonDAO;
import com.exemple.entity.HoaDonLoadTable;
import com.exemple.entity.Phong;
import com.exemple.entity.TableHoaDon;
import com.exemple.helper.MsgBox;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Hashtable;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;
import test.OrderDichVu;

public class QuanLyHoaDonJPanel extends javax.swing.JPanel {

    Connection con;
    PreparedStatement pst;
    DichVuDAO dvdao = new DichVuDAO();
    PhongDAO pdao = new PhongDAO();
    LoadTableHoaDonDAO lthdDao = new LoadTableHoaDonDAO();
    TableHoaDonDAO tblhddao = new TableHoaDonDAO();
    private int maPhong;
    private int maDichVu;
    private int maCHiTietHoaDOn ;
    int index;

    public QuanLyHoaDonJPanel() {
        initComponents();
        init();
    }

    void init() {
        fillComboBoxPhong();
        loadToTable();
    }

    

    private void fillComboBoxPhong() {
        try {
            DefaultComboBoxModel model = (DefaultComboBoxModel) cboPhong.getModel();
            model.removeAllElements();
            List<Phong> list = pdao.selectByTrangThai();
            for (Phong p : list) {
                model.addElement(p.getSoPhong());
            }
            this.fillTableDichVuByClickCombox();
            this.editByCombox();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void clear() {
        this.setModel(new HoaDonLoadTable());
    }

    void setModel(HoaDonLoadTable hd) {
        maCHiTietHoaDOn = hd.getMaChiTietHoaDon();
        maDichVu = hd.getMaDichVu();
        maPhong = hd.getMaPhong();
        txtThuNgan.setText(hd.getThuNgan());
        jdcNgayNhan.setDate(hd.getNgaynhanPhong());
        jdcNgayTao.setDate(hd.getNgayTao());
        jdcNgayTra.setDate(hd.getNgayTraPhong());
        txtCCCD.setText(hd.getCMND_CCCD());
        txtSoHoaDon.setText(String.valueOf(hd.getMaHoaDon()));
        txtKhachHang.setText(hd.getTenKhachHang());
        txtSoDienThoai.setText(hd.getSoDienThoai());
        txtGiamTien.setText(String.valueOf(hd.getGiamTien()));
        txtMaGiamGia.setText(hd.getMaGiamGia());
        txtTienPhong.setText(String.valueOf(hd.getTienPhong()));
    }

    HoaDonLoadTable getModel() {
        HoaDonLoadTable hd = new HoaDonLoadTable();
        hd.setMaChiTietHoaDon(maCHiTietHoaDOn);
        hd.setMaHoaDon(Integer.parseInt(txtSoHoaDon.getText()));
        hd.setMaPhong(maPhong);
        hd.setMaDichVu(maDichVu);
        hd.setNgayTao(jdcNgayNhan.getDate());
        hd.setNgayTraPhong(jdcNgayTra.getDate());
        hd.setNgaynhanPhong(jdcNgayNhan.getDate());
        hd.setTienPhong(Float.parseFloat(txtTienPhong.getText()));
        hd.setThuNgan(txtThuNgan.getText());
        hd.setCMND_CCCD(txtCCCD.getText());
        hd.setMaGiamGia(txtMaGiamGia.getText());
        hd.setTongTien(txtTongTien.getText());
        int soPhong = (int) cboPhong.getSelectedItem();
        System.out.println("So phong : " + soPhong);
        System.out.println("Tong tien : "+ txtTongTien.getText());
        hd.setSoPhong(soPhong);
        return hd;
    }

//    void insert() {
//        HoaDonLoadTable hd = getModel();
//        lthdDao.insertHoaDon(hd);
//        lthdDao.insertChiTietHoaDon(hd);
//    }

    void update() {
        try {
            HoaDonLoadTable hd = getModel();
            lthdDao.updateHoaDon(hd);
            lthdDao.updateChiTietHoaDon(hd);
        } catch (Exception e) {
            e.printStackTrace();
            MsgBox.alert(this, "Lỗi hệ thống");
        }

    }

    void editByCombox() {
        int soPhong = (int) cboPhong.getSelectedItem();
        String soPhong2 = String.valueOf(soPhong);
        edit(soPhong2);
    }

    void editClickTable() {
        int soPhong = (int) tblHoaDon.getValueAt(this.index, 1);
        String soPhong2 = String.valueOf(soPhong);
        edit(soPhong2);

    }

    void edit(String sophong) {
        try {
            HoaDonLoadTable hd = lthdDao.selectById(sophong);
            if (hd != null) {

                this.setModel(hd);
            } else {
                this.clear();
            }
        } catch (Exception e) {
            e.printStackTrace();
            MsgBox.alert(this, "Lỗi truy vấn");
        }
    }

    private void fillTableDichVuByClickCombox() {
        int soPhong = (int) cboPhong.getSelectedItem();
        fillTable(soPhong);
    }

    private void fillTableDichVuByCickTableHoaDon() {
        int soPhong = (int) tblHoaDon.getValueAt(this.index, 1);
        fillTable(soPhong);
    }

    void fillTable(int soPhong) {
        try {
            DefaultTableModel model = (DefaultTableModel) tblDichVu.getModel();
            model.setRowCount(0);
            List<HoaDonLoadTable> list = lthdDao.selectBySoPhong1(soPhong);
            HoaDonLoadTable dv = null;
            for (int i = 0; i < list.size(); i++) {
                dv = list.get(i);
                model.addRow(new Object[]{i + 1, dv.getSoPhong(), dv.getMaDichVu(), dv.getTenDichVu(), dv.getSoLan(), dv.getGiaDichVu()});
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("error" + e.getMessage());
        }
    }
void loadToTable() {
        DefaultTableModel model = (DefaultTableModel) tblHoaDon.getModel();
        model.setRowCount(0);
        List<TableHoaDon> list = tblhddao.selectAll();
        for (TableHoaDon hd : list) {
            Object[] row = {
                hd.getMaHoaDon(),
                hd.getSoPhong(),
                hd.getSoCMND(),
                hd.getNgayTao(),
                hd.getNgaynhanPhong(),
                hd.getNgayTraPhong(),
                hd.getTaiKhoanNV(),
                hd.getMaKhuyenMai()
            };
            model.addRow(row);
        }
    }
    float tinhtien(int soPhong) {
        List<HoaDonLoadTable> hd = (List<HoaDonLoadTable>) lthdDao.selectBySoPhong1(soPhong);
        float count = 0;
        float tienphong = 0;
        float tiengiam = 0;
        for (HoaDonLoadTable hoaDonLoadTable : hd) {
            tiengiam = hoaDonLoadTable.getGiamTien();
            tienphong = hoaDonLoadTable.getTienPhong();
            float gia = hoaDonLoadTable.getGiaDichVu();
            count = count + gia;
        }
        count = count + tienphong - tiengiam;
        System.out.println(count);
        return count;
    }

    float tinhTienbByCombox() {
        int soPhong = (int) cboPhong.getSelectedItem();
        String soPhong2 = String.valueOf(soPhong);
        return tinhtien(soPhong);
    }

    float tinhTienbByClickHoaDon() {
        int soPhong = (int) tblHoaDon.getValueAt(this.index, 1);
        System.out.println("so phong : " + soPhong);
        String soPhong2 = String.valueOf(soPhong);
        return tinhtien(soPhong);
    }

    public void XuatHoaDon() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=QuanLyKhachSan;user=sa;password=admin");

            Hashtable map = new Hashtable();
            JasperReport report = JasperCompileManager.compileReport("C:\\Users\\hp\\OneDrive\\Máy tính\\hehe\\duan1_quanlykhachsan\\QuanLyKhachSan\\src\\test\\report1.jrxml");
            int soPhong = (int) cboPhong.getSelectedItem();
            map.put("SoPhong", soPhong);
            JasperPrint p = JasperFillManager.fillReport(report, map, con);
            JasperViewer.viewReport(p);
            JasperExportManager.exportReportToPdfFile(p, "test.pdf");
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println(ex.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tabs = new javax.swing.JTabbedPane();
        pnlEdit = new javax.swing.JPanel();
        pnlSanPham = new javax.swing.JPanel();
        cboPhong = new javax.swing.JComboBox<>();
        pnlHoaDon = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtSoHoaDon = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtCCCD = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txtTienPhong = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtSoDienThoai = new javax.swing.JTextField();
        txtKhachHang = new javax.swing.JTextField();
        jdcNgayTao = new com.toedter.calendar.JDateChooser();
        jdcNgayNhan = new com.toedter.calendar.JDateChooser();
        jdcNgayTra = new com.toedter.calendar.JDateChooser();
        txtThuNgan = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDichVu = new javax.swing.JTable();
        pnlTTHoaDon = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        txtMaGiamGia = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtGiamTien = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jTextField11 = new javax.swing.JTextField();
        jTextField12 = new javax.swing.JTextField();
        txtTongTien = new javax.swing.JTextField();
        btnThanhToan = new javax.swing.JButton();
        btnTaoMoi = new javax.swing.JButton();
        txtThanhTien = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblHoaDon = new javax.swing.JTable();

        pnlSanPham.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        cboPhong.setForeground(new java.awt.Color(255, 51, 102));
        cboPhong.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboPhongItemStateChanged(evt);
            }
        });
        cboPhong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboPhongActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlSanPhamLayout = new javax.swing.GroupLayout(pnlSanPham);
        pnlSanPham.setLayout(pnlSanPhamLayout);
        pnlSanPhamLayout.setHorizontalGroup(
            pnlSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlSanPhamLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cboPhong, 0, 201, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlSanPhamLayout.setVerticalGroup(
            pnlSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSanPhamLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cboPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(474, Short.MAX_VALUE))
        );

        pnlHoaDon.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 204));
        jLabel1.setText("Ngày tạo");

        jLabel2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 204));
        jLabel2.setText("Số hóa đơn");

        jLabel5.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 204));
        jLabel5.setText("Ngày nhận phòng");

        jLabel6.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 204));
        jLabel6.setText("Thu ngân");

        jLabel7.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 204));
        jLabel7.setText("CMND/CCCD");

        jLabel8.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 204));
        jLabel8.setText("Ngày trả phòng");

        jLabel13.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 0, 204));
        jLabel13.setText("Số điện thoại");

        jLabel15.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 0, 204));
        jLabel15.setText("Tiền phòng");

        jLabel3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 204));
        jLabel3.setText("Khách hàng");

        txtKhachHang.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtKhachHangKeyReleased(evt);
            }
        });

        jdcNgayTao.setDateFormatString("dd-MM-yyyy hh:mm:ss a");

        jdcNgayNhan.setDateFormatString("dd-MM-yyyy hh:mm:ss a");

        jdcNgayTra.setDateFormatString("dd-MM-yyyy hh:mm:ss a");

        javax.swing.GroupLayout pnlHoaDonLayout = new javax.swing.GroupLayout(pnlHoaDon);
        pnlHoaDon.setLayout(pnlHoaDonLayout);
        pnlHoaDonLayout.setHorizontalGroup(
            pnlHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlHoaDonLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(txtThuNgan, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtSoHoaDon, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jdcNgayTao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(pnlHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING))
                .addGap(39, 39, 39)
                .addGroup(pnlHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(txtCCCD)
                    .addComponent(txtKhachHang, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jdcNgayNhan, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(pnlHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13)
                    .addComponent(jLabel8)
                    .addComponent(jLabel15))
                .addGap(18, 18, 18)
                .addGroup(pnlHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtTienPhong)
                    .addComponent(txtSoDienThoai)
                    .addComponent(jdcNgayTra, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnlHoaDonLayout.setVerticalGroup(
            pnlHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlHoaDonLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addGroup(pnlHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(pnlHoaDonLayout.createSequentialGroup()
                            .addGroup(pnlHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jdcNgayTao, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel1))
                            .addGap(16, 16, 16)
                            .addGroup(pnlHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtSoHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel2)
                                .addComponent(jLabel3))
                            .addGap(16, 16, 16)
                            .addGroup(pnlHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel6)
                                .addComponent(txtThuNgan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel7)))
                        .addGroup(pnlHoaDonLayout.createSequentialGroup()
                            .addGroup(pnlHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jdcNgayNhan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jdcNgayTra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel8))
                            .addGap(16, 16, 16)
                            .addGroup(pnlHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel13)
                                .addComponent(txtSoDienThoai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(16, 16, 16)
                            .addGroup(pnlHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtTienPhong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(pnlHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtCCCD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel15))))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tblDichVu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Số Phòng", "Mã dịch vụ", "Tên dịch vụ", "Số lần", "Giá dịch vụ"
            }
        ));
        jScrollPane1.setViewportView(tblDichVu);

        pnlTTHoaDon.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        jLabel4.setForeground(new java.awt.Color(255, 51, 204));
        jLabel4.setText("Mã giảm giá");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(51, 51, 255));
        jLabel10.setText("Tổng cộng");

        jLabel11.setForeground(new java.awt.Color(255, 102, 204));
        jLabel11.setText("Giảm tiền");

        txtGiamTien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtGiamTienActionPerformed(evt);
            }
        });

        jLabel9.setText("Thành tiền");

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 153, 0));
        jLabel12.setText("Khách trả");

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 153, 0));
        jLabel14.setText("Tiền dư");

        btnThanhToan.setText("Thanh toán");
        btnThanhToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThanhToanActionPerformed(evt);
            }
        });

        btnTaoMoi.setText("Tạo hóa đơn mới");
        btnTaoMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTaoMoiActionPerformed(evt);
            }
        });

        jButton1.setText("Thêm dịch vụ");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlTTHoaDonLayout = new javax.swing.GroupLayout(pnlTTHoaDon);
        pnlTTHoaDon.setLayout(pnlTTHoaDonLayout);
        pnlTTHoaDonLayout.setHorizontalGroup(
            pnlTTHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlTTHoaDonLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(pnlTTHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlTTHoaDonLayout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(pnlTTHoaDonLayout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(25, 25, 25)))
                .addGroup(pnlTTHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMaGiamGia, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(pnlTTHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlTTHoaDonLayout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addGroup(pnlTTHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(pnlTTHoaDonLayout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addGap(18, 18, 18)
                                .addComponent(txtGiamTien, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlTTHoaDonLayout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addGap(18, 18, 18)
                                .addComponent(jTextField12)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                        .addGroup(pnlTTHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlTTHoaDonLayout.createSequentialGroup()
                                .addComponent(jLabel14)
                                .addGap(31, 31, 31)
                                .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlTTHoaDonLayout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addGap(18, 18, 18)
                                .addComponent(txtThanhTien, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(pnlTTHoaDonLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnTaoMoi)
                        .addGap(310, 310, 310)
                        .addComponent(btnThanhToan)
                        .addGap(11, 11, 11)))
                .addGap(20, 20, 20))
        );
        pnlTTHoaDonLayout.setVerticalGroup(
            pnlTTHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTTHoaDonLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(pnlTTHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMaGiamGia, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel11)
                    .addComponent(jLabel9)
                    .addComponent(txtThanhTien, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtGiamTien, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlTTHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel12)
                    .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14)
                    .addComponent(jTextField12, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlTTHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlTTHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnTaoMoi, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
                        .addComponent(btnThanhToan, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE))
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout pnlEditLayout = new javax.swing.GroupLayout(pnlEdit);
        pnlEdit.setLayout(pnlEditLayout);
        pnlEditLayout.setHorizontalGroup(
            pnlEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlEditLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlSanPham, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1)
                    .addComponent(pnlHoaDon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlTTHoaDon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnlEditLayout.setVerticalGroup(
            pnlEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlEditLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(pnlSanPham, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnlEditLayout.createSequentialGroup()
                        .addComponent(pnlHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(pnlTTHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(6, 6, 6))
        );

        tabs.addTab("Cập nhập", pnlEdit);

        tblHoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "MÃ HÓA ĐƠN", "SỐ PHÒNG", "SỐ CMT KHÁCH", "NGÀY TẠO", "NGÀY NHẬN PHÒNG", "NGÀY TRẢ PHÒNG", "TÀI KHOẢN NV", "MÃ HÓA ĐƠN"
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
        jScrollPane2.setViewportView(tblHoaDon);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1128, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        tabs.addTab("Danh sách", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(tabs, javax.swing.GroupLayout.PREFERRED_SIZE, 1157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(tabs, javax.swing.GroupLayout.PREFERRED_SIZE, 569, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cboPhongItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboPhongItemStateChanged

    }//GEN-LAST:event_cboPhongItemStateChanged

    private void cboPhongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboPhongActionPerformed
        this.fillTableDichVuByClickCombox();
        this.editByCombox();
        txtThanhTien.setText(String.valueOf(tinhTienbByCombox()));
        txtTongTien.setText(String.valueOf(tinhTienbByCombox()));
    }//GEN-LAST:event_cboPhongActionPerformed

    private void txtKhachHangKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtKhachHangKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtKhachHangKeyReleased

    private void txtGiamTienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtGiamTienActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtGiamTienActionPerformed

    private void btnThanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThanhToanActionPerformed
        this.update();
        this.XuatHoaDon();
    }//GEN-LAST:event_btnThanhToanActionPerformed

    private void btnTaoMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTaoMoiActionPerformed
        this.clear();
        txtThanhTien.setText("");
        txtTongTien.setText("");
        DefaultTableModel model = (DefaultTableModel) tblDichVu.getModel();
        model.setRowCount(0);
    }//GEN-LAST:event_btnTaoMoiActionPerformed

    private void tblHoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblHoaDonMouseClicked
        if (evt.getClickCount() == 2) {
            this.index = tblHoaDon.rowAtPoint(evt.getPoint());
            if (this.index >= 0) {
                this.fillTableDichVuByCickTableHoaDon();
                this.editClickTable();
                txtThanhTien.setText(String.valueOf(tinhTienbByClickHoaDon()));
                txtTongTien.setText(String.valueOf(tinhTienbByClickHoaDon()));
                tabs.setSelectedIndex(0);
            }
        }
    }//GEN-LAST:event_tblHoaDonMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        new OrderDichVu().setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnTaoMoi;
    private javax.swing.JButton btnThanhToan;
    private javax.swing.JComboBox<String> cboPhong;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField12;
    private com.toedter.calendar.JDateChooser jdcNgayNhan;
    private com.toedter.calendar.JDateChooser jdcNgayTao;
    private com.toedter.calendar.JDateChooser jdcNgayTra;
    private javax.swing.JPanel pnlEdit;
    private javax.swing.JPanel pnlHoaDon;
    private javax.swing.JPanel pnlSanPham;
    private javax.swing.JPanel pnlTTHoaDon;
    private javax.swing.JTabbedPane tabs;
    private javax.swing.JTable tblDichVu;
    private javax.swing.JTable tblHoaDon;
    private javax.swing.JTextField txtCCCD;
    private javax.swing.JTextField txtGiamTien;
    private javax.swing.JTextField txtKhachHang;
    private javax.swing.JTextField txtMaGiamGia;
    private javax.swing.JTextField txtSoDienThoai;
    private javax.swing.JTextField txtSoHoaDon;
    private javax.swing.JTextField txtThanhTien;
    private javax.swing.JTextField txtThuNgan;
    private javax.swing.JTextField txtTienPhong;
    private javax.swing.JTextField txtTongTien;
    // End of variables declaration//GEN-END:variables
}
