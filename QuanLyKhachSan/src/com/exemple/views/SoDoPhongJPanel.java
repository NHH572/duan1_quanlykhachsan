/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.exemple.views;

import com.exemple.controller.ChuyenManHinhController;
import com.exemple.controller.SoDoPhongDAO;
import com.exemple.entity.DanhMucSoDoPhong;
import com.exemple.entity.SoDoPhong;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.LayoutStyle;
import org.netbeans.lib.awtextra.AbsoluteLayout;

/**
 *
 * @author Minh Triet
 */
public class SoDoPhongJPanel extends javax.swing.JPanel {

    private List<DanhMucSoDoPhong> listDanhMucSoDoPhong = new ArrayList<>();
    public static List<DanhMucSoDoPhong> listDanhMucSoDoPhongPublic = new ArrayList<>();
    public static int maPhong = -1;

    public SoDoPhongJPanel() {
        initComponents();
        init();
    }

    private void init() {
        SoDoPhongDAO sdpDAO = new SoDoPhongDAO();
        List<SoDoPhong> listDataDanhMucSoDoPhong = sdpDAO.selectSoDoPhong();
        addToListDanhMucSoDoPhong();
        sdpDAO.setInformationSoDoPhong(listDanhMucSoDoPhong, listDataDanhMucSoDoPhong);
        SoDoPhongDAO spDAO = new SoDoPhongDAO();
        spDAO.setEvent(listDanhMucSoDoPhong);
        for (DanhMucSoDoPhong item : listDanhMucSoDoPhong) {
            item.getPanelTam().setOpaque(false);
            item.getBtnChiTiet().setVisible(false);
            item.getBtnChucNang().setVisible(false);
        }

    }

    private void addToListDanhMucSoDoPhong() {
        listDanhMucSoDoPhong.add(new DanhMucSoDoPhong("T1P1", panel1, lblSoPhong1, lblLoai1, lblTrangThai1, panelTam1, btnChiTiet1, btnChucNang1));
        listDanhMucSoDoPhong.add(new DanhMucSoDoPhong("T1P2", panel2, lblSoPhong2, lblLoai2, lblTrangThai2, panelTam2, btnChiTiet2, btnChucNang2));
        listDanhMucSoDoPhong.add(new DanhMucSoDoPhong("T1P3", panel3, lblSoPhong3, lblLoai3, lblTrangThai3, panelTam3, btnChiTiet3, btnChucNang3));
        listDanhMucSoDoPhong.add(new DanhMucSoDoPhong("T1P4", panel4, lblSoPhong4, lblLoai4, lblTrangThai4, panelTam4, btnChiTiet4, btnChucNang4));
        listDanhMucSoDoPhong.add(new DanhMucSoDoPhong("T1P5", panel5, lblSoPhong5, lblLoai5, lblTrangThai5, panelTam5, btnChiTiet5, btnChucNang5));
        listDanhMucSoDoPhong.add(new DanhMucSoDoPhong("T1P6", panel31, lblSoPhong31, lblLoai31, lblTrangThai31, panelTam31, btnChiTiet31, btnChucNang31));
        listDanhMucSoDoPhong.add(new DanhMucSoDoPhong("T2P1", panel6, lblSoPhong6, lblLoai6, lblTrangThai6, panelTam6, btnChiTiet6, btnChucNang6));
        listDanhMucSoDoPhong.add(new DanhMucSoDoPhong("T2P2", panel7, lblSoPhong7, lblLoai7, lblTrangThai7, panelTam7, btnChiTiet7, btnChucNang7));
        listDanhMucSoDoPhong.add(new DanhMucSoDoPhong("T2P3", panel8, lblSoPhong8, lblLoai8, lblTrangThai8, panelTam8, btnChiTiet8, btnChucNang8));
        listDanhMucSoDoPhong.add(new DanhMucSoDoPhong("T2P4", panel9, lblSoPhong9, lblLoai9, lblTrangThai9, panelTam9, btnChiTiet9, btnChucNang9));
        listDanhMucSoDoPhong.add(new DanhMucSoDoPhong("T2P5", panel10, lblSoPhong10, lblLoai10, lblTrangThai10, panelTam10, btnChiTiet10, btnChucNang10));
        listDanhMucSoDoPhong.add(new DanhMucSoDoPhong("T2P6", panel32, lblSoPhong32, lblLoai32, lblTrangThai32, panelTam32, btnChiTiet32, btnChucNang32));
        listDanhMucSoDoPhong.add(new DanhMucSoDoPhong("T3P1", panel11, lblSoPhong11, lblLoai11, lblTrangThai11, panelTam11, btnChiTiet11, btnChucNang11));
        listDanhMucSoDoPhong.add(new DanhMucSoDoPhong("T3P2", panel12, lblSoPhong12, lblLoai12, lblTrangThai12, panelTam12, btnChiTiet12, btnChucNang12));
        listDanhMucSoDoPhong.add(new DanhMucSoDoPhong("T3P3", panel13, lblSoPhong13, lblLoai13, lblTrangThai13, panelTam13, btnChiTiet13, btnChucNang13));
        listDanhMucSoDoPhong.add(new DanhMucSoDoPhong("T3P4", panel14, lblSoPhong14, lblLoai14, lblTrangThai14, panelTam14, btnChiTiet14, btnChucNang14));
        listDanhMucSoDoPhong.add(new DanhMucSoDoPhong("T3P5", panel15, lblSoPhong15, lblLoai15, lblTrangThai15, panelTam15, btnChiTiet15, btnChucNang15));
        listDanhMucSoDoPhong.add(new DanhMucSoDoPhong("T3P6", panel33, lblSoPhong33, lblLoai33, lblTrangThai33, panelTam33, btnChiTiet33, btnChucNang33));
        listDanhMucSoDoPhong.add(new DanhMucSoDoPhong("T4P1", panel16, lblSoPhong16, lblLoai16, lblTrangThai16, panelTam16, btnChiTiet16, btnChucNang16));
        listDanhMucSoDoPhong.add(new DanhMucSoDoPhong("T4P2", panel17, lblSoPhong17, lblLoai17, lblTrangThai17, panelTam17, btnChiTiet17, btnChucNang17));
        listDanhMucSoDoPhong.add(new DanhMucSoDoPhong("T4P3", panel18, lblSoPhong18, lblLoai18, lblTrangThai18, panelTam18, btnChiTiet18, btnChucNang18));
        listDanhMucSoDoPhong.add(new DanhMucSoDoPhong("T4P4", panel19, lblSoPhong19, lblLoai19, lblTrangThai19, panelTam19, btnChiTiet19, btnChucNang19));
        listDanhMucSoDoPhong.add(new DanhMucSoDoPhong("T4P5", panel20, lblSoPhong20, lblLoai20, lblTrangThai20, panelTam20, btnChiTiet20, btnChucNang20));
        listDanhMucSoDoPhong.add(new DanhMucSoDoPhong("T4P6", panel34, lblSoPhong34, lblLoai34, lblTrangThai34, panelTam34, btnChiTiet34, btnChucNang34));
        listDanhMucSoDoPhong.add(new DanhMucSoDoPhong("T5P1", panel21, lblSoPhong21, lblLoai21, lblTrangThai21, panelTam21, btnChiTiet21, btnChucNang21));
        listDanhMucSoDoPhong.add(new DanhMucSoDoPhong("T5P2", panel22, lblSoPhong22, lblLoai22, lblTrangThai22, panelTam22, btnChiTiet22, btnChucNang22));
        listDanhMucSoDoPhong.add(new DanhMucSoDoPhong("T5P3", panel23, lblSoPhong23, lblLoai23, lblTrangThai23, panelTam23, btnChiTiet23, btnChucNang23));
        listDanhMucSoDoPhong.add(new DanhMucSoDoPhong("T5P4", panel24, lblSoPhong24, lblLoai24, lblTrangThai24, panelTam24, btnChiTiet24, btnChucNang24));
        listDanhMucSoDoPhong.add(new DanhMucSoDoPhong("T5P5", panel25, lblSoPhong25, lblLoai25, lblTrangThai25, panelTam25, btnChiTiet25, btnChucNang25));
        listDanhMucSoDoPhong.add(new DanhMucSoDoPhong("T5P6", panel35, lblSoPhong35, lblLoai35, lblTrangThai35, panelTam35, btnChiTiet35, btnChucNang35));
        listDanhMucSoDoPhong.add(new DanhMucSoDoPhong("T6P1", panel26, lblSoPhong26, lblLoai26, lblTrangThai26, panelTam26, btnChiTiet26, btnChucNang26));
        listDanhMucSoDoPhong.add(new DanhMucSoDoPhong("T6P2", panel27, lblSoPhong27, lblLoai27, lblTrangThai27, panelTam27, btnChiTiet27, btnChucNang27));
        listDanhMucSoDoPhong.add(new DanhMucSoDoPhong("T6P3", panel28, lblSoPhong28, lblLoai28, lblTrangThai28, panelTam28, btnChiTiet28, btnChucNang28));
        listDanhMucSoDoPhong.add(new DanhMucSoDoPhong("T6P4", panel29, lblSoPhong29, lblLoai29, lblTrangThai29, panelTam29, btnChiTiet29, btnChucNang29));
        listDanhMucSoDoPhong.add(new DanhMucSoDoPhong("T6P5", panel30, lblSoPhong30, lblLoai30, lblTrangThai30, panelTam30, btnChiTiet30, btnChucNang30));
        listDanhMucSoDoPhong.add(new DanhMucSoDoPhong("T6P6", panel36, lblSoPhong36, lblLoai36, lblTrangThai36, panelTam36, btnChiTiet36, btnChucNang36));
        listDanhMucSoDoPhongPublic.addAll(listDanhMucSoDoPhong);
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

        panelTang1 = new javax.swing.JPanel();
        panelTang = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        panel1 = new javax.swing.JPanel();
        lblSoPhong1 = new javax.swing.JLabel();
        lblLoai1 = new javax.swing.JLabel();
        lblTrangThai1 = new javax.swing.JLabel();
        panelTam1 = new javax.swing.JPanel();
        btnChiTiet1 = new javax.swing.JButton();
        btnChucNang1 = new javax.swing.JButton();
        panel2 = new javax.swing.JPanel();
        lblSoPhong2 = new javax.swing.JLabel();
        lblLoai2 = new javax.swing.JLabel();
        lblTrangThai2 = new javax.swing.JLabel();
        panelTam2 = new javax.swing.JPanel();
        btnChiTiet2 = new javax.swing.JButton();
        btnChucNang2 = new javax.swing.JButton();
        panel3 = new javax.swing.JPanel();
        lblSoPhong3 = new javax.swing.JLabel();
        lblLoai3 = new javax.swing.JLabel();
        lblTrangThai3 = new javax.swing.JLabel();
        panelTam3 = new javax.swing.JPanel();
        btnChiTiet3 = new javax.swing.JButton();
        btnChucNang3 = new javax.swing.JButton();
        panel4 = new javax.swing.JPanel();
        lblSoPhong4 = new javax.swing.JLabel();
        lblLoai4 = new javax.swing.JLabel();
        lblTrangThai4 = new javax.swing.JLabel();
        panelTam4 = new javax.swing.JPanel();
        btnChiTiet4 = new javax.swing.JButton();
        btnChucNang4 = new javax.swing.JButton();
        panel5 = new javax.swing.JPanel();
        lblSoPhong5 = new javax.swing.JLabel();
        lblLoai5 = new javax.swing.JLabel();
        lblTrangThai5 = new javax.swing.JLabel();
        panelTam5 = new javax.swing.JPanel();
        btnChiTiet5 = new javax.swing.JButton();
        btnChucNang5 = new javax.swing.JButton();
        panel31 = new javax.swing.JPanel();
        lblSoPhong31 = new javax.swing.JLabel();
        lblLoai31 = new javax.swing.JLabel();
        lblTrangThai31 = new javax.swing.JLabel();
        panelTam31 = new javax.swing.JPanel();
        btnChiTiet31 = new javax.swing.JButton();
        btnChucNang31 = new javax.swing.JButton();
        panelTang2 = new javax.swing.JPanel();
        panelTang3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        panel6 = new javax.swing.JPanel();
        lblSoPhong6 = new javax.swing.JLabel();
        lblLoai6 = new javax.swing.JLabel();
        lblTrangThai6 = new javax.swing.JLabel();
        panelTam6 = new javax.swing.JPanel();
        btnChiTiet6 = new javax.swing.JButton();
        btnChucNang6 = new javax.swing.JButton();
        panel7 = new javax.swing.JPanel();
        lblSoPhong7 = new javax.swing.JLabel();
        lblLoai7 = new javax.swing.JLabel();
        lblTrangThai7 = new javax.swing.JLabel();
        panelTam7 = new javax.swing.JPanel();
        btnChiTiet7 = new javax.swing.JButton();
        btnChucNang7 = new javax.swing.JButton();
        panel8 = new javax.swing.JPanel();
        lblSoPhong8 = new javax.swing.JLabel();
        lblLoai8 = new javax.swing.JLabel();
        lblTrangThai8 = new javax.swing.JLabel();
        panelTam8 = new javax.swing.JPanel();
        btnChiTiet8 = new javax.swing.JButton();
        btnChucNang8 = new javax.swing.JButton();
        panel9 = new javax.swing.JPanel();
        lblSoPhong9 = new javax.swing.JLabel();
        lblLoai9 = new javax.swing.JLabel();
        lblTrangThai9 = new javax.swing.JLabel();
        panelTam9 = new javax.swing.JPanel();
        btnChiTiet9 = new javax.swing.JButton();
        btnChucNang9 = new javax.swing.JButton();
        panel10 = new javax.swing.JPanel();
        lblSoPhong10 = new javax.swing.JLabel();
        lblLoai10 = new javax.swing.JLabel();
        lblTrangThai10 = new javax.swing.JLabel();
        panelTam10 = new javax.swing.JPanel();
        btnChiTiet10 = new javax.swing.JButton();
        btnChucNang10 = new javax.swing.JButton();
        panel32 = new javax.swing.JPanel();
        lblSoPhong32 = new javax.swing.JLabel();
        lblLoai32 = new javax.swing.JLabel();
        lblTrangThai32 = new javax.swing.JLabel();
        panelTam32 = new javax.swing.JPanel();
        btnChiTiet32 = new javax.swing.JButton();
        btnChucNang32 = new javax.swing.JButton();
        panelTang4 = new javax.swing.JPanel();
        panelTang5 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        panel11 = new javax.swing.JPanel();
        lblSoPhong11 = new javax.swing.JLabel();
        lblLoai11 = new javax.swing.JLabel();
        lblTrangThai11 = new javax.swing.JLabel();
        panelTam11 = new javax.swing.JPanel();
        btnChiTiet11 = new javax.swing.JButton();
        btnChucNang11 = new javax.swing.JButton();
        panel12 = new javax.swing.JPanel();
        lblSoPhong12 = new javax.swing.JLabel();
        lblLoai12 = new javax.swing.JLabel();
        lblTrangThai12 = new javax.swing.JLabel();
        panelTam12 = new javax.swing.JPanel();
        btnChiTiet12 = new javax.swing.JButton();
        btnChucNang12 = new javax.swing.JButton();
        panel13 = new javax.swing.JPanel();
        lblSoPhong13 = new javax.swing.JLabel();
        lblLoai13 = new javax.swing.JLabel();
        lblTrangThai13 = new javax.swing.JLabel();
        panelTam13 = new javax.swing.JPanel();
        btnChiTiet13 = new javax.swing.JButton();
        btnChucNang13 = new javax.swing.JButton();
        panel14 = new javax.swing.JPanel();
        lblSoPhong14 = new javax.swing.JLabel();
        lblLoai14 = new javax.swing.JLabel();
        lblTrangThai14 = new javax.swing.JLabel();
        panelTam14 = new javax.swing.JPanel();
        btnChiTiet14 = new javax.swing.JButton();
        btnChucNang14 = new javax.swing.JButton();
        panel15 = new javax.swing.JPanel();
        lblSoPhong15 = new javax.swing.JLabel();
        lblLoai15 = new javax.swing.JLabel();
        lblTrangThai15 = new javax.swing.JLabel();
        panelTam15 = new javax.swing.JPanel();
        btnChiTiet15 = new javax.swing.JButton();
        btnChucNang15 = new javax.swing.JButton();
        panel33 = new javax.swing.JPanel();
        lblSoPhong33 = new javax.swing.JLabel();
        lblLoai33 = new javax.swing.JLabel();
        lblTrangThai33 = new javax.swing.JLabel();
        panelTam33 = new javax.swing.JPanel();
        btnChiTiet33 = new javax.swing.JButton();
        btnChucNang33 = new javax.swing.JButton();
        panelTang6 = new javax.swing.JPanel();
        panelTang7 = new javax.swing.JPanel();
        jLabel34 = new javax.swing.JLabel();
        panel16 = new javax.swing.JPanel();
        lblSoPhong16 = new javax.swing.JLabel();
        lblLoai16 = new javax.swing.JLabel();
        lblTrangThai16 = new javax.swing.JLabel();
        panelTam16 = new javax.swing.JPanel();
        btnChiTiet16 = new javax.swing.JButton();
        btnChucNang16 = new javax.swing.JButton();
        panel17 = new javax.swing.JPanel();
        lblSoPhong17 = new javax.swing.JLabel();
        lblLoai17 = new javax.swing.JLabel();
        lblTrangThai17 = new javax.swing.JLabel();
        panelTam17 = new javax.swing.JPanel();
        btnChiTiet17 = new javax.swing.JButton();
        btnChucNang17 = new javax.swing.JButton();
        panel18 = new javax.swing.JPanel();
        lblSoPhong18 = new javax.swing.JLabel();
        lblLoai18 = new javax.swing.JLabel();
        lblTrangThai18 = new javax.swing.JLabel();
        panelTam18 = new javax.swing.JPanel();
        btnChiTiet18 = new javax.swing.JButton();
        btnChucNang18 = new javax.swing.JButton();
        panel19 = new javax.swing.JPanel();
        lblSoPhong19 = new javax.swing.JLabel();
        lblLoai19 = new javax.swing.JLabel();
        lblTrangThai19 = new javax.swing.JLabel();
        panelTam19 = new javax.swing.JPanel();
        btnChiTiet19 = new javax.swing.JButton();
        btnChucNang19 = new javax.swing.JButton();
        panel20 = new javax.swing.JPanel();
        lblSoPhong20 = new javax.swing.JLabel();
        lblLoai20 = new javax.swing.JLabel();
        lblTrangThai20 = new javax.swing.JLabel();
        panelTam20 = new javax.swing.JPanel();
        btnChiTiet20 = new javax.swing.JButton();
        btnChucNang20 = new javax.swing.JButton();
        panel34 = new javax.swing.JPanel();
        lblSoPhong34 = new javax.swing.JLabel();
        lblLoai34 = new javax.swing.JLabel();
        lblTrangThai34 = new javax.swing.JLabel();
        panelTam34 = new javax.swing.JPanel();
        btnChiTiet34 = new javax.swing.JButton();
        btnChucNang34 = new javax.swing.JButton();
        panelTang8 = new javax.swing.JPanel();
        panelTang9 = new javax.swing.JPanel();
        jLabel45 = new javax.swing.JLabel();
        panel21 = new javax.swing.JPanel();
        lblSoPhong21 = new javax.swing.JLabel();
        lblLoai21 = new javax.swing.JLabel();
        lblTrangThai21 = new javax.swing.JLabel();
        panelTam21 = new javax.swing.JPanel();
        btnChiTiet21 = new javax.swing.JButton();
        btnChucNang21 = new javax.swing.JButton();
        panel22 = new javax.swing.JPanel();
        lblSoPhong22 = new javax.swing.JLabel();
        lblLoai22 = new javax.swing.JLabel();
        lblTrangThai22 = new javax.swing.JLabel();
        panelTam22 = new javax.swing.JPanel();
        btnChiTiet22 = new javax.swing.JButton();
        btnChucNang22 = new javax.swing.JButton();
        panel23 = new javax.swing.JPanel();
        lblSoPhong23 = new javax.swing.JLabel();
        lblLoai23 = new javax.swing.JLabel();
        lblTrangThai23 = new javax.swing.JLabel();
        panelTam23 = new javax.swing.JPanel();
        btnChiTiet23 = new javax.swing.JButton();
        btnChucNang23 = new javax.swing.JButton();
        panel24 = new javax.swing.JPanel();
        lblSoPhong24 = new javax.swing.JLabel();
        lblLoai24 = new javax.swing.JLabel();
        lblTrangThai24 = new javax.swing.JLabel();
        panelTam24 = new javax.swing.JPanel();
        btnChiTiet24 = new javax.swing.JButton();
        btnChucNang24 = new javax.swing.JButton();
        panel25 = new javax.swing.JPanel();
        lblSoPhong25 = new javax.swing.JLabel();
        lblLoai25 = new javax.swing.JLabel();
        lblTrangThai25 = new javax.swing.JLabel();
        panelTam25 = new javax.swing.JPanel();
        btnChiTiet25 = new javax.swing.JButton();
        btnChucNang25 = new javax.swing.JButton();
        panel35 = new javax.swing.JPanel();
        lblSoPhong35 = new javax.swing.JLabel();
        lblLoai35 = new javax.swing.JLabel();
        lblTrangThai35 = new javax.swing.JLabel();
        panelTam35 = new javax.swing.JPanel();
        btnChiTiet35 = new javax.swing.JButton();
        btnChucNang35 = new javax.swing.JButton();
        panelTang10 = new javax.swing.JPanel();
        panelTang11 = new javax.swing.JPanel();
        jLabel46 = new javax.swing.JLabel();
        panel26 = new javax.swing.JPanel();
        lblSoPhong26 = new javax.swing.JLabel();
        lblLoai26 = new javax.swing.JLabel();
        lblTrangThai26 = new javax.swing.JLabel();
        panelTam26 = new javax.swing.JPanel();
        btnChiTiet26 = new javax.swing.JButton();
        btnChucNang26 = new javax.swing.JButton();
        panel27 = new javax.swing.JPanel();
        lblSoPhong27 = new javax.swing.JLabel();
        lblLoai27 = new javax.swing.JLabel();
        lblTrangThai27 = new javax.swing.JLabel();
        panelTam27 = new javax.swing.JPanel();
        btnChiTiet27 = new javax.swing.JButton();
        btnChucNang27 = new javax.swing.JButton();
        panel28 = new javax.swing.JPanel();
        lblSoPhong28 = new javax.swing.JLabel();
        lblLoai28 = new javax.swing.JLabel();
        lblTrangThai28 = new javax.swing.JLabel();
        panelTam28 = new javax.swing.JPanel();
        btnChiTiet28 = new javax.swing.JButton();
        btnChucNang28 = new javax.swing.JButton();
        panel29 = new javax.swing.JPanel();
        lblSoPhong29 = new javax.swing.JLabel();
        lblLoai29 = new javax.swing.JLabel();
        lblTrangThai29 = new javax.swing.JLabel();
        panelTam29 = new javax.swing.JPanel();
        btnChiTiet29 = new javax.swing.JButton();
        btnChucNang29 = new javax.swing.JButton();
        panel30 = new javax.swing.JPanel();
        lblSoPhong30 = new javax.swing.JLabel();
        lblLoai30 = new javax.swing.JLabel();
        lblTrangThai30 = new javax.swing.JLabel();
        panelTam30 = new javax.swing.JPanel();
        btnChiTiet30 = new javax.swing.JButton();
        btnChucNang30 = new javax.swing.JButton();
        panel36 = new javax.swing.JPanel();
        lblSoPhong36 = new javax.swing.JLabel();
        lblLoai36 = new javax.swing.JLabel();
        lblTrangThai36 = new javax.swing.JLabel();
        panelTam36 = new javax.swing.JPanel();
        btnChiTiet36 = new javax.swing.JButton();
        btnChucNang36 = new javax.swing.JButton();

        setLayout(new java.awt.GridLayout(6, 1));

        panelTang1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        panelTang1.setLayout(new java.awt.GridLayout(1, 0));

        panelTang.setBackground(new java.awt.Color(23, 163, 184));
        panelTang.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        panelTang.setLayout(new java.awt.GridBagLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Tầng 1");
        panelTang.add(jLabel2, new java.awt.GridBagConstraints());

        panelTang1.add(panelTang);

        panel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        panel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                panel1MouseEntered(evt);
            }
        });
        panel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblSoPhong1.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        lblSoPhong1.setForeground(new java.awt.Color(255, 255, 255));
        lblSoPhong1.setText("Số phòng");
        panel1.add(lblSoPhong1, new org.netbeans.lib.awtextra.AbsoluteConstraints(51, 9, -1, -1));

        lblLoai1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblLoai1.setText("Loại:");
        panel1.add(lblLoai1, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 37, -1, -1));

        lblTrangThai1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblTrangThai1.setText("Trạng thái:");
        panel1.add(lblTrangThai1, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 62, -1, -1));

        panelTam1.setLayout(new java.awt.GridBagLayout());

        btnChiTiet1.setText("Chi tiết");
        btnChiTiet1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChiTiet1ActionPerformed(evt);
            }
        });
        panelTam1.add(btnChiTiet1, new java.awt.GridBagConstraints());

        btnChucNang1.setText("Nút 2");
        panelTam1.add(btnChucNang1, new java.awt.GridBagConstraints());

        panel1.add(panelTam1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 150, 110));

        panelTang1.add(panel1);

        panel2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        panel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                panel2MouseEntered(evt);
            }
        });
        panel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblSoPhong2.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        lblSoPhong2.setForeground(new java.awt.Color(255, 255, 255));
        lblSoPhong2.setText("Số phòng");
        panel2.add(lblSoPhong2, new org.netbeans.lib.awtextra.AbsoluteConstraints(51, 9, -1, -1));

        lblLoai2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblLoai2.setText("Loại:");
        panel2.add(lblLoai2, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 37, -1, -1));

        lblTrangThai2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblTrangThai2.setText("Trạng thái:");
        panel2.add(lblTrangThai2, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 62, -1, -1));

        panelTam2.setLayout(new java.awt.GridBagLayout());

        btnChiTiet2.setText("Chi tiết");
        panelTam2.add(btnChiTiet2, new java.awt.GridBagConstraints());

        btnChucNang2.setText("Nút 2");
        panelTam2.add(btnChucNang2, new java.awt.GridBagConstraints());

        panel2.add(panelTam2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 150, 110));

        panelTang1.add(panel2);

        panel3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        panel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                panel3MouseEntered(evt);
            }
        });
        panel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblSoPhong3.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        lblSoPhong3.setForeground(new java.awt.Color(255, 255, 255));
        lblSoPhong3.setText("Số phòng");
        panel3.add(lblSoPhong3, new org.netbeans.lib.awtextra.AbsoluteConstraints(51, 9, -1, -1));

        lblLoai3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblLoai3.setText("Loại:");
        panel3.add(lblLoai3, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 37, -1, -1));

        lblTrangThai3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblTrangThai3.setText("Trạng thái:");
        panel3.add(lblTrangThai3, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 62, -1, -1));

        panelTam3.setLayout(new java.awt.GridBagLayout());

        btnChiTiet3.setText("Chi tiết");
        panelTam3.add(btnChiTiet3, new java.awt.GridBagConstraints());

        btnChucNang3.setText("Nút 2");
        panelTam3.add(btnChucNang3, new java.awt.GridBagConstraints());

        panel3.add(panelTam3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 150, 110));

        panelTang1.add(panel3);

        panel4.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        panel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                panel4MouseEntered(evt);
            }
        });
        panel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblSoPhong4.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        lblSoPhong4.setForeground(new java.awt.Color(255, 255, 255));
        lblSoPhong4.setText("Số phòng");
        panel4.add(lblSoPhong4, new org.netbeans.lib.awtextra.AbsoluteConstraints(51, 9, -1, -1));

        lblLoai4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblLoai4.setText("Loại:");
        panel4.add(lblLoai4, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 37, -1, -1));

        lblTrangThai4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblTrangThai4.setText("Trạng thái:");
        panel4.add(lblTrangThai4, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 62, -1, -1));

        panelTam4.setLayout(new java.awt.GridBagLayout());

        btnChiTiet4.setText("Chi tiết");
        panelTam4.add(btnChiTiet4, new java.awt.GridBagConstraints());

        btnChucNang4.setText("Nút 2");
        panelTam4.add(btnChucNang4, new java.awt.GridBagConstraints());

        panel4.add(panelTam4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 150, 110));

        panelTang1.add(panel4);

        panel5.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        panel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                panel5MouseEntered(evt);
            }
        });
        panel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblSoPhong5.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        lblSoPhong5.setForeground(new java.awt.Color(255, 255, 255));
        lblSoPhong5.setText("Số phòng");
        panel5.add(lblSoPhong5, new org.netbeans.lib.awtextra.AbsoluteConstraints(51, 9, -1, -1));

        lblLoai5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblLoai5.setText("Loại:");
        panel5.add(lblLoai5, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 37, -1, -1));

        lblTrangThai5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblTrangThai5.setText("Trạng thái:");
        panel5.add(lblTrangThai5, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 62, -1, -1));

        panelTam5.setLayout(new java.awt.GridBagLayout());

        btnChiTiet5.setText("Chi tiết");
        panelTam5.add(btnChiTiet5, new java.awt.GridBagConstraints());

        btnChucNang5.setText("Nút 2");
        panelTam5.add(btnChucNang5, new java.awt.GridBagConstraints());

        panel5.add(panelTam5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 150, 110));

        panelTang1.add(panel5);

        panel31.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        panel31.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                panel31MouseEntered(evt);
            }
        });
        panel31.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblSoPhong31.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        lblSoPhong31.setForeground(new java.awt.Color(255, 255, 255));
        lblSoPhong31.setText("Số phòng");
        panel31.add(lblSoPhong31, new org.netbeans.lib.awtextra.AbsoluteConstraints(51, 9, -1, -1));

        lblLoai31.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblLoai31.setText("Loại:");
        panel31.add(lblLoai31, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 37, -1, -1));

        lblTrangThai31.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblTrangThai31.setText("Trạng thái:");
        panel31.add(lblTrangThai31, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 62, -1, -1));

        panelTam31.setLayout(new java.awt.GridBagLayout());

        btnChiTiet31.setText("Chi tiết");
        panelTam31.add(btnChiTiet31, new java.awt.GridBagConstraints());

        btnChucNang31.setText("Nút 2");
        panelTam31.add(btnChucNang31, new java.awt.GridBagConstraints());

        panel31.add(panelTam31, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 150, 110));

        panelTang1.add(panel31);

        add(panelTang1);

        panelTang2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        panelTang2.setLayout(new java.awt.GridLayout(1, 0));

        panelTang3.setBackground(new java.awt.Color(23, 163, 184));
        panelTang3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        panelTang3.setLayout(new java.awt.GridBagLayout());

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Tầng 2");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(40, 46, 44, 53);
        panelTang3.add(jLabel4, gridBagConstraints);

        panelTang2.add(panelTang3);

        panel6.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        panel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                panel6MouseEntered(evt);
            }
        });
        panel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblSoPhong6.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        lblSoPhong6.setForeground(new java.awt.Color(255, 255, 255));
        lblSoPhong6.setText("Số phòng");
        panel6.add(lblSoPhong6, new org.netbeans.lib.awtextra.AbsoluteConstraints(51, 9, -1, -1));

        lblLoai6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblLoai6.setText("Loại:");
        panel6.add(lblLoai6, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 37, -1, -1));

        lblTrangThai6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblTrangThai6.setText("Trạng thái:");
        panel6.add(lblTrangThai6, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 62, -1, -1));

        panelTam6.setLayout(new java.awt.GridBagLayout());

        btnChiTiet6.setText("Chi tiết");
        panelTam6.add(btnChiTiet6, new java.awt.GridBagConstraints());

        btnChucNang6.setText("Nút 2");
        panelTam6.add(btnChucNang6, new java.awt.GridBagConstraints());

        panel6.add(panelTam6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 150, 110));

        panelTang2.add(panel6);

        panel7.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        panel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                panel7MouseEntered(evt);
            }
        });
        panel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblSoPhong7.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        lblSoPhong7.setForeground(new java.awt.Color(255, 255, 255));
        lblSoPhong7.setText("Số phòng");
        panel7.add(lblSoPhong7, new org.netbeans.lib.awtextra.AbsoluteConstraints(51, 9, -1, -1));

        lblLoai7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblLoai7.setText("Loại:");
        panel7.add(lblLoai7, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 37, -1, -1));

        lblTrangThai7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblTrangThai7.setText("Trạng thái:");
        panel7.add(lblTrangThai7, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 62, -1, -1));

        panelTam7.setLayout(new java.awt.GridBagLayout());

        btnChiTiet7.setText("Chi tiết");
        panelTam7.add(btnChiTiet7, new java.awt.GridBagConstraints());

        btnChucNang7.setText("Nút 2");
        panelTam7.add(btnChucNang7, new java.awt.GridBagConstraints());

        panel7.add(panelTam7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 150, 110));

        panelTang2.add(panel7);

        panel8.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        panel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                panel8MouseEntered(evt);
            }
        });
        panel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblSoPhong8.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        lblSoPhong8.setForeground(new java.awt.Color(255, 255, 255));
        lblSoPhong8.setText("Số phòng");
        panel8.add(lblSoPhong8, new org.netbeans.lib.awtextra.AbsoluteConstraints(51, 9, -1, -1));

        lblLoai8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblLoai8.setText("Loại:");
        panel8.add(lblLoai8, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 37, -1, -1));

        lblTrangThai8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblTrangThai8.setText("Trạng thái:");
        panel8.add(lblTrangThai8, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 62, -1, -1));

        panelTam8.setLayout(new java.awt.GridBagLayout());

        btnChiTiet8.setText("Chi tiết");
        panelTam8.add(btnChiTiet8, new java.awt.GridBagConstraints());

        btnChucNang8.setText("Nút 2");
        panelTam8.add(btnChucNang8, new java.awt.GridBagConstraints());

        panel8.add(panelTam8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 150, 110));

        panelTang2.add(panel8);

        panel9.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        panel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                panel9MouseEntered(evt);
            }
        });
        panel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblSoPhong9.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        lblSoPhong9.setForeground(new java.awt.Color(255, 255, 255));
        lblSoPhong9.setText("Số phòng");
        panel9.add(lblSoPhong9, new org.netbeans.lib.awtextra.AbsoluteConstraints(51, 9, -1, -1));

        lblLoai9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblLoai9.setText("Loại:");
        panel9.add(lblLoai9, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 37, -1, -1));

        lblTrangThai9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblTrangThai9.setText("Trạng thái:");
        panel9.add(lblTrangThai9, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 62, -1, -1));

        panelTam9.setLayout(new java.awt.GridBagLayout());

        btnChiTiet9.setText("Chi tiết");
        panelTam9.add(btnChiTiet9, new java.awt.GridBagConstraints());

        btnChucNang9.setText("Nút 2");
        panelTam9.add(btnChucNang9, new java.awt.GridBagConstraints());

        panel9.add(panelTam9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 150, 110));

        panelTang2.add(panel9);

        panel10.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        panel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                panel10MouseEntered(evt);
            }
        });
        panel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblSoPhong10.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        lblSoPhong10.setForeground(new java.awt.Color(255, 255, 255));
        lblSoPhong10.setText("Số phòng");
        panel10.add(lblSoPhong10, new org.netbeans.lib.awtextra.AbsoluteConstraints(51, 9, -1, -1));

        lblLoai10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblLoai10.setText("Loại:");
        panel10.add(lblLoai10, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 37, -1, -1));

        lblTrangThai10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblTrangThai10.setText("Trạng thái:");
        panel10.add(lblTrangThai10, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 62, -1, -1));

        panelTam10.setLayout(new java.awt.GridBagLayout());

        btnChiTiet10.setText("Chi tiết");
        panelTam10.add(btnChiTiet10, new java.awt.GridBagConstraints());

        btnChucNang10.setText("Nút 2");
        panelTam10.add(btnChucNang10, new java.awt.GridBagConstraints());

        panel10.add(panelTam10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 150, 110));

        panelTang2.add(panel10);

        panel32.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        panel32.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                panel32MouseEntered(evt);
            }
        });
        panel32.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblSoPhong32.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        lblSoPhong32.setForeground(new java.awt.Color(255, 255, 255));
        lblSoPhong32.setText("Số phòng");
        panel32.add(lblSoPhong32, new org.netbeans.lib.awtextra.AbsoluteConstraints(51, 9, -1, -1));

        lblLoai32.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblLoai32.setText("Loại:");
        panel32.add(lblLoai32, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 37, -1, -1));

        lblTrangThai32.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblTrangThai32.setText("Trạng thái:");
        panel32.add(lblTrangThai32, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 62, -1, -1));

        panelTam32.setLayout(new java.awt.GridBagLayout());

        btnChiTiet32.setText("Chi tiết");
        panelTam32.add(btnChiTiet32, new java.awt.GridBagConstraints());

        btnChucNang32.setText("Nút 2");
        panelTam32.add(btnChucNang32, new java.awt.GridBagConstraints());

        panel32.add(panelTam32, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 150, 110));

        panelTang2.add(panel32);

        add(panelTang2);

        panelTang4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        panelTang4.setLayout(new java.awt.GridLayout(1, 0));

        panelTang5.setBackground(new java.awt.Color(23, 163, 184));
        panelTang5.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        panelTang5.setLayout(new java.awt.GridBagLayout());

        jLabel23.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel23.setText("Tầng 3");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(45, 44, 39, 55);
        panelTang5.add(jLabel23, gridBagConstraints);

        panelTang4.add(panelTang5);

        panel11.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        panel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                panel11MouseEntered(evt);
            }
        });
        panel11.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblSoPhong11.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        lblSoPhong11.setForeground(new java.awt.Color(255, 255, 255));
        lblSoPhong11.setText("Số phòng");
        panel11.add(lblSoPhong11, new org.netbeans.lib.awtextra.AbsoluteConstraints(51, 9, -1, -1));

        lblLoai11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblLoai11.setText("Loại:");
        panel11.add(lblLoai11, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 37, -1, -1));

        lblTrangThai11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblTrangThai11.setText("Trạng thái:");
        panel11.add(lblTrangThai11, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 62, -1, -1));

        panelTam11.setLayout(new java.awt.GridBagLayout());

        btnChiTiet11.setText("Chi tiết");
        panelTam11.add(btnChiTiet11, new java.awt.GridBagConstraints());

        btnChucNang11.setText("Nút 2");
        panelTam11.add(btnChucNang11, new java.awt.GridBagConstraints());

        panel11.add(panelTam11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 150, 110));

        panelTang4.add(panel11);

        panel12.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        panel12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                panel12MouseEntered(evt);
            }
        });
        panel12.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblSoPhong12.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        lblSoPhong12.setForeground(new java.awt.Color(255, 255, 255));
        lblSoPhong12.setText("Số phòng");
        panel12.add(lblSoPhong12, new org.netbeans.lib.awtextra.AbsoluteConstraints(51, 9, -1, -1));

        lblLoai12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblLoai12.setText("Loại:");
        panel12.add(lblLoai12, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 37, -1, -1));

        lblTrangThai12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblTrangThai12.setText("Trạng thái:");
        panel12.add(lblTrangThai12, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 62, -1, -1));

        panelTam12.setLayout(new java.awt.GridBagLayout());

        btnChiTiet12.setText("Chi tiết");
        panelTam12.add(btnChiTiet12, new java.awt.GridBagConstraints());

        btnChucNang12.setText("Nút 2");
        panelTam12.add(btnChucNang12, new java.awt.GridBagConstraints());

        panel12.add(panelTam12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 150, 110));

        panelTang4.add(panel12);

        panel13.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        panel13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                panel13MouseEntered(evt);
            }
        });
        panel13.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblSoPhong13.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        lblSoPhong13.setForeground(new java.awt.Color(255, 255, 255));
        lblSoPhong13.setText("Số phòng");
        panel13.add(lblSoPhong13, new org.netbeans.lib.awtextra.AbsoluteConstraints(51, 9, -1, -1));

        lblLoai13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblLoai13.setText("Loại:");
        panel13.add(lblLoai13, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 37, -1, -1));

        lblTrangThai13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblTrangThai13.setText("Trạng thái:");
        panel13.add(lblTrangThai13, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 62, -1, -1));

        panelTam13.setLayout(new java.awt.GridBagLayout());

        btnChiTiet13.setText("Chi tiết");
        panelTam13.add(btnChiTiet13, new java.awt.GridBagConstraints());

        btnChucNang13.setText("Nút 2");
        panelTam13.add(btnChucNang13, new java.awt.GridBagConstraints());

        panel13.add(panelTam13, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 150, 110));

        panelTang4.add(panel13);

        panel14.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        panel14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                panel14MouseEntered(evt);
            }
        });
        panel14.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblSoPhong14.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        lblSoPhong14.setForeground(new java.awt.Color(255, 255, 255));
        lblSoPhong14.setText("Số phòng");
        panel14.add(lblSoPhong14, new org.netbeans.lib.awtextra.AbsoluteConstraints(51, 9, -1, -1));

        lblLoai14.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblLoai14.setText("Loại:");
        panel14.add(lblLoai14, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 37, -1, -1));

        lblTrangThai14.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblTrangThai14.setText("Trạng thái:");
        panel14.add(lblTrangThai14, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 62, -1, -1));

        panelTam14.setLayout(new java.awt.GridBagLayout());

        btnChiTiet14.setText("Chi tiết");
        panelTam14.add(btnChiTiet14, new java.awt.GridBagConstraints());

        btnChucNang14.setText("Nút 2");
        panelTam14.add(btnChucNang14, new java.awt.GridBagConstraints());

        panel14.add(panelTam14, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 150, 110));

        panelTang4.add(panel14);

        panel15.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        panel15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                panel15MouseEntered(evt);
            }
        });
        panel15.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblSoPhong15.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        lblSoPhong15.setForeground(new java.awt.Color(255, 255, 255));
        lblSoPhong15.setText("Số phòng");
        panel15.add(lblSoPhong15, new org.netbeans.lib.awtextra.AbsoluteConstraints(51, 9, -1, -1));

        lblLoai15.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblLoai15.setText("Loại:");
        panel15.add(lblLoai15, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 37, -1, -1));

        lblTrangThai15.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblTrangThai15.setText("Trạng thái:");
        panel15.add(lblTrangThai15, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 62, -1, -1));

        panelTam15.setLayout(new java.awt.GridBagLayout());

        btnChiTiet15.setText("Chi tiết");
        panelTam15.add(btnChiTiet15, new java.awt.GridBagConstraints());

        btnChucNang15.setText("Nút 2");
        panelTam15.add(btnChucNang15, new java.awt.GridBagConstraints());

        panel15.add(panelTam15, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 150, 110));

        panelTang4.add(panel15);

        panel33.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        panel33.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                panel33MouseEntered(evt);
            }
        });
        panel33.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblSoPhong33.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        lblSoPhong33.setForeground(new java.awt.Color(255, 255, 255));
        lblSoPhong33.setText("Số phòng");
        panel33.add(lblSoPhong33, new org.netbeans.lib.awtextra.AbsoluteConstraints(51, 9, -1, -1));

        lblLoai33.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblLoai33.setText("Loại:");
        panel33.add(lblLoai33, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 37, -1, -1));

        lblTrangThai33.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblTrangThai33.setText("Trạng thái:");
        panel33.add(lblTrangThai33, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 62, -1, -1));

        panelTam33.setLayout(new java.awt.GridBagLayout());

        btnChiTiet33.setText("Chi tiết");
        panelTam33.add(btnChiTiet33, new java.awt.GridBagConstraints());

        btnChucNang33.setText("Nút 2");
        panelTam33.add(btnChucNang33, new java.awt.GridBagConstraints());

        panel33.add(panelTam33, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 150, 110));

        panelTang4.add(panel33);

        add(panelTang4);

        panelTang6.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        panelTang6.setLayout(new java.awt.GridLayout(1, 0));

        panelTang7.setBackground(new java.awt.Color(23, 163, 184));
        panelTang7.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        panelTang7.setLayout(new java.awt.GridBagLayout());

        jLabel34.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel34.setText("Tầng 4");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(43, 45, 41, 54);
        panelTang7.add(jLabel34, gridBagConstraints);

        panelTang6.add(panelTang7);

        panel16.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        panel16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                panel16MouseEntered(evt);
            }
        });
        panel16.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblSoPhong16.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        lblSoPhong16.setForeground(new java.awt.Color(255, 255, 255));
        lblSoPhong16.setText("Số phòng");
        panel16.add(lblSoPhong16, new org.netbeans.lib.awtextra.AbsoluteConstraints(51, 9, -1, -1));

        lblLoai16.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblLoai16.setText("Loại:");
        panel16.add(lblLoai16, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 37, -1, -1));

        lblTrangThai16.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblTrangThai16.setText("Trạng thái:");
        panel16.add(lblTrangThai16, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 62, -1, -1));

        panelTam16.setLayout(new java.awt.GridBagLayout());

        btnChiTiet16.setText("Chi tiết");
        panelTam16.add(btnChiTiet16, new java.awt.GridBagConstraints());

        btnChucNang16.setText("Nút 2");
        panelTam16.add(btnChucNang16, new java.awt.GridBagConstraints());

        panel16.add(panelTam16, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 150, 110));

        panelTang6.add(panel16);

        panel17.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        panel17.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                panel17MouseEntered(evt);
            }
        });
        panel17.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblSoPhong17.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        lblSoPhong17.setForeground(new java.awt.Color(255, 255, 255));
        lblSoPhong17.setText("Số phòng");
        panel17.add(lblSoPhong17, new org.netbeans.lib.awtextra.AbsoluteConstraints(51, 9, -1, -1));

        lblLoai17.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblLoai17.setText("Loại:");
        panel17.add(lblLoai17, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 37, -1, -1));

        lblTrangThai17.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblTrangThai17.setText("Trạng thái:");
        panel17.add(lblTrangThai17, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 62, -1, -1));

        panelTam17.setLayout(new java.awt.GridBagLayout());

        btnChiTiet17.setText("Chi tiết");
        panelTam17.add(btnChiTiet17, new java.awt.GridBagConstraints());

        btnChucNang17.setText("Nút 2");
        panelTam17.add(btnChucNang17, new java.awt.GridBagConstraints());

        panel17.add(panelTam17, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 150, 110));

        panelTang6.add(panel17);

        panel18.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        panel18.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                panel18MouseEntered(evt);
            }
        });
        panel18.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblSoPhong18.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        lblSoPhong18.setForeground(new java.awt.Color(255, 255, 255));
        lblSoPhong18.setText("Số phòng");
        panel18.add(lblSoPhong18, new org.netbeans.lib.awtextra.AbsoluteConstraints(51, 9, -1, -1));

        lblLoai18.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblLoai18.setText("Loại:");
        panel18.add(lblLoai18, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 37, -1, -1));

        lblTrangThai18.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblTrangThai18.setText("Trạng thái:");
        panel18.add(lblTrangThai18, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 62, -1, -1));

        panelTam18.setLayout(new java.awt.GridBagLayout());

        btnChiTiet18.setText("Chi tiết");
        panelTam18.add(btnChiTiet18, new java.awt.GridBagConstraints());

        btnChucNang18.setText("Nút 2");
        panelTam18.add(btnChucNang18, new java.awt.GridBagConstraints());

        panel18.add(panelTam18, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 150, 110));

        panelTang6.add(panel18);

        panel19.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        panel19.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                panel19MouseEntered(evt);
            }
        });
        panel19.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblSoPhong19.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        lblSoPhong19.setForeground(new java.awt.Color(255, 255, 255));
        lblSoPhong19.setText("Số phòng");
        panel19.add(lblSoPhong19, new org.netbeans.lib.awtextra.AbsoluteConstraints(51, 9, -1, -1));

        lblLoai19.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblLoai19.setText("Loại:");
        panel19.add(lblLoai19, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 37, -1, -1));

        lblTrangThai19.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblTrangThai19.setText("Trạng thái:");
        panel19.add(lblTrangThai19, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 62, -1, -1));

        panelTam19.setLayout(new java.awt.GridBagLayout());

        btnChiTiet19.setText("Chi tiết");
        panelTam19.add(btnChiTiet19, new java.awt.GridBagConstraints());

        btnChucNang19.setText("Nút 2");
        panelTam19.add(btnChucNang19, new java.awt.GridBagConstraints());

        panel19.add(panelTam19, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 150, 110));

        panelTang6.add(panel19);

        panel20.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        panel20.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                panel20MouseEntered(evt);
            }
        });
        panel20.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblSoPhong20.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        lblSoPhong20.setForeground(new java.awt.Color(255, 255, 255));
        lblSoPhong20.setText("Số phòng");
        panel20.add(lblSoPhong20, new org.netbeans.lib.awtextra.AbsoluteConstraints(51, 9, -1, -1));

        lblLoai20.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblLoai20.setText("Loại:");
        panel20.add(lblLoai20, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 37, -1, -1));

        lblTrangThai20.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblTrangThai20.setText("Trạng thái:");
        panel20.add(lblTrangThai20, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 62, -1, -1));

        panelTam20.setLayout(new java.awt.GridBagLayout());

        btnChiTiet20.setText("Chi tiết");
        panelTam20.add(btnChiTiet20, new java.awt.GridBagConstraints());

        btnChucNang20.setText("Nút 2");
        panelTam20.add(btnChucNang20, new java.awt.GridBagConstraints());

        panel20.add(panelTam20, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 150, 110));

        panelTang6.add(panel20);

        panel34.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        panel34.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                panel34MouseEntered(evt);
            }
        });
        panel34.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblSoPhong34.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        lblSoPhong34.setForeground(new java.awt.Color(255, 255, 255));
        lblSoPhong34.setText("Số phòng");
        panel34.add(lblSoPhong34, new org.netbeans.lib.awtextra.AbsoluteConstraints(51, 9, -1, -1));

        lblLoai34.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblLoai34.setText("Loại:");
        panel34.add(lblLoai34, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 37, -1, -1));

        lblTrangThai34.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblTrangThai34.setText("Trạng thái:");
        panel34.add(lblTrangThai34, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 62, -1, -1));

        panelTam34.setLayout(new java.awt.GridBagLayout());

        btnChiTiet34.setText("Chi tiết");
        panelTam34.add(btnChiTiet34, new java.awt.GridBagConstraints());

        btnChucNang34.setText("Nút 2");
        panelTam34.add(btnChucNang34, new java.awt.GridBagConstraints());

        panel34.add(panelTam34, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 150, 110));

        panelTang6.add(panel34);

        add(panelTang6);

        panelTang8.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        panelTang8.setLayout(new java.awt.GridLayout(1, 0));

        panelTang9.setBackground(new java.awt.Color(23, 163, 184));
        panelTang9.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        panelTang9.setLayout(new java.awt.GridBagLayout());

        jLabel45.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel45.setText("Tầng 5");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(41, 46, 43, 53);
        panelTang9.add(jLabel45, gridBagConstraints);

        panelTang8.add(panelTang9);

        panel21.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        panel21.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                panel21MouseEntered(evt);
            }
        });
        panel21.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblSoPhong21.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        lblSoPhong21.setForeground(new java.awt.Color(255, 255, 255));
        lblSoPhong21.setText("Số phòng");
        panel21.add(lblSoPhong21, new org.netbeans.lib.awtextra.AbsoluteConstraints(51, 9, -1, -1));

        lblLoai21.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblLoai21.setText("Loại:");
        panel21.add(lblLoai21, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 37, -1, -1));

        lblTrangThai21.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblTrangThai21.setText("Trạng thái:");
        panel21.add(lblTrangThai21, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 62, -1, -1));

        panelTam21.setLayout(new java.awt.GridBagLayout());

        btnChiTiet21.setText("Chi tiết");
        panelTam21.add(btnChiTiet21, new java.awt.GridBagConstraints());

        btnChucNang21.setText("Nút 2");
        panelTam21.add(btnChucNang21, new java.awt.GridBagConstraints());

        panel21.add(panelTam21, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 150, 110));

        panelTang8.add(panel21);

        panel22.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        panel22.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                panel22MouseEntered(evt);
            }
        });
        panel22.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblSoPhong22.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        lblSoPhong22.setForeground(new java.awt.Color(255, 255, 255));
        lblSoPhong22.setText("Số phòng");
        panel22.add(lblSoPhong22, new org.netbeans.lib.awtextra.AbsoluteConstraints(51, 9, -1, -1));

        lblLoai22.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblLoai22.setText("Loại:");
        panel22.add(lblLoai22, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 37, -1, -1));

        lblTrangThai22.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblTrangThai22.setText("Trạng thái:");
        panel22.add(lblTrangThai22, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 62, -1, -1));

        panelTam22.setLayout(new java.awt.GridBagLayout());

        btnChiTiet22.setText("Chi tiết");
        panelTam22.add(btnChiTiet22, new java.awt.GridBagConstraints());

        btnChucNang22.setText("Nút 2");
        panelTam22.add(btnChucNang22, new java.awt.GridBagConstraints());

        panel22.add(panelTam22, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 150, 110));

        panelTang8.add(panel22);

        panel23.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        panel23.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                panel23MouseEntered(evt);
            }
        });
        panel23.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblSoPhong23.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        lblSoPhong23.setForeground(new java.awt.Color(255, 255, 255));
        lblSoPhong23.setText("Số phòng");
        panel23.add(lblSoPhong23, new org.netbeans.lib.awtextra.AbsoluteConstraints(51, 9, -1, -1));

        lblLoai23.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblLoai23.setText("Loại:");
        panel23.add(lblLoai23, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 37, -1, -1));

        lblTrangThai23.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblTrangThai23.setText("Trạng thái:");
        panel23.add(lblTrangThai23, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 62, -1, -1));

        panelTam23.setLayout(new java.awt.GridBagLayout());

        btnChiTiet23.setText("Chi tiết");
        panelTam23.add(btnChiTiet23, new java.awt.GridBagConstraints());

        btnChucNang23.setText("Nút 2");
        panelTam23.add(btnChucNang23, new java.awt.GridBagConstraints());

        panel23.add(panelTam23, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 150, 110));

        panelTang8.add(panel23);

        panel24.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        panel24.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                panel24MouseEntered(evt);
            }
        });
        panel24.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblSoPhong24.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        lblSoPhong24.setForeground(new java.awt.Color(255, 255, 255));
        lblSoPhong24.setText("Số phòng");
        panel24.add(lblSoPhong24, new org.netbeans.lib.awtextra.AbsoluteConstraints(51, 9, -1, -1));

        lblLoai24.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblLoai24.setText("Loại:");
        panel24.add(lblLoai24, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 37, -1, -1));

        lblTrangThai24.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblTrangThai24.setText("Trạng thái:");
        panel24.add(lblTrangThai24, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 62, -1, -1));

        panelTam24.setLayout(new java.awt.GridBagLayout());

        btnChiTiet24.setText("Chi tiết");
        panelTam24.add(btnChiTiet24, new java.awt.GridBagConstraints());

        btnChucNang24.setText("Nút 2");
        panelTam24.add(btnChucNang24, new java.awt.GridBagConstraints());

        panel24.add(panelTam24, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 150, 110));

        panelTang8.add(panel24);

        panel25.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        panel25.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                panel25MouseEntered(evt);
            }
        });
        panel25.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblSoPhong25.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        lblSoPhong25.setForeground(new java.awt.Color(255, 255, 255));
        lblSoPhong25.setText("Số phòng");
        panel25.add(lblSoPhong25, new org.netbeans.lib.awtextra.AbsoluteConstraints(51, 9, -1, -1));

        lblLoai25.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblLoai25.setText("Loại:");
        panel25.add(lblLoai25, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 37, -1, -1));

        lblTrangThai25.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblTrangThai25.setText("Trạng thái:");
        panel25.add(lblTrangThai25, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 62, -1, -1));

        panelTam25.setLayout(new java.awt.GridBagLayout());

        btnChiTiet25.setText("Chi tiết");
        panelTam25.add(btnChiTiet25, new java.awt.GridBagConstraints());

        btnChucNang25.setText("Nút 2");
        panelTam25.add(btnChucNang25, new java.awt.GridBagConstraints());

        panel25.add(panelTam25, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 150, 110));

        panelTang8.add(panel25);

        panel35.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        panel35.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                panel35MouseEntered(evt);
            }
        });
        panel35.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblSoPhong35.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        lblSoPhong35.setForeground(new java.awt.Color(255, 255, 255));
        lblSoPhong35.setText("Số phòng");
        panel35.add(lblSoPhong35, new org.netbeans.lib.awtextra.AbsoluteConstraints(51, 9, -1, -1));

        lblLoai35.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblLoai35.setText("Loại:");
        panel35.add(lblLoai35, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 37, -1, -1));

        lblTrangThai35.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblTrangThai35.setText("Trạng thái:");
        panel35.add(lblTrangThai35, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 62, -1, -1));

        panelTam35.setLayout(new java.awt.GridBagLayout());

        btnChiTiet35.setText("Chi tiết");
        panelTam35.add(btnChiTiet35, new java.awt.GridBagConstraints());

        btnChucNang35.setText("Nút 2");
        panelTam35.add(btnChucNang35, new java.awt.GridBagConstraints());

        panel35.add(panelTam35, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 150, 110));

        panelTang8.add(panel35);

        add(panelTang8);

        panelTang10.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        panelTang10.setLayout(new java.awt.GridLayout(1, 0));

        panelTang11.setBackground(new java.awt.Color(23, 163, 184));
        panelTang11.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        panelTang11.setLayout(new java.awt.GridBagLayout());

        jLabel46.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel46.setText("Tầng 6");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(41, 46, 43, 53);
        panelTang11.add(jLabel46, gridBagConstraints);

        panelTang10.add(panelTang11);

        panel26.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        panel26.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblSoPhong26.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        lblSoPhong26.setForeground(new java.awt.Color(255, 255, 255));
        lblSoPhong26.setText("Số phòng");
        panel26.add(lblSoPhong26, new org.netbeans.lib.awtextra.AbsoluteConstraints(51, 9, -1, -1));

        lblLoai26.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblLoai26.setText("Loại:");
        panel26.add(lblLoai26, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 37, -1, -1));

        lblTrangThai26.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblTrangThai26.setText("Trạng thái:");
        panel26.add(lblTrangThai26, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 62, -1, -1));

        panelTam26.setLayout(new java.awt.GridBagLayout());

        btnChiTiet26.setText("Chi tiết");
        panelTam26.add(btnChiTiet26, new java.awt.GridBagConstraints());

        btnChucNang26.setText("Nút 2");
        panelTam26.add(btnChucNang26, new java.awt.GridBagConstraints());

        panel26.add(panelTam26, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 150, 110));

        panelTang10.add(panel26);

        panel27.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        panel27.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblSoPhong27.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        lblSoPhong27.setForeground(new java.awt.Color(255, 255, 255));
        lblSoPhong27.setText("Số phòng");
        panel27.add(lblSoPhong27, new org.netbeans.lib.awtextra.AbsoluteConstraints(51, 9, -1, -1));

        lblLoai27.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblLoai27.setText("Loại:");
        panel27.add(lblLoai27, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 37, -1, -1));

        lblTrangThai27.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblTrangThai27.setText("Trạng thái:");
        panel27.add(lblTrangThai27, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 62, -1, -1));

        panelTam27.setLayout(new java.awt.GridBagLayout());

        btnChiTiet27.setText("Chi tiết");
        panelTam27.add(btnChiTiet27, new java.awt.GridBagConstraints());

        btnChucNang27.setText("Nút 2");
        panelTam27.add(btnChucNang27, new java.awt.GridBagConstraints());

        panel27.add(panelTam27, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 150, 110));

        panelTang10.add(panel27);

        panel28.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        panel28.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblSoPhong28.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        lblSoPhong28.setForeground(new java.awt.Color(255, 255, 255));
        lblSoPhong28.setText("Số phòng");
        panel28.add(lblSoPhong28, new org.netbeans.lib.awtextra.AbsoluteConstraints(51, 9, -1, -1));

        lblLoai28.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblLoai28.setText("Loại:");
        panel28.add(lblLoai28, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 37, -1, -1));

        lblTrangThai28.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblTrangThai28.setText("Trạng thái:");
        panel28.add(lblTrangThai28, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 62, -1, -1));

        panelTam28.setLayout(new java.awt.GridBagLayout());

        btnChiTiet28.setText("Chi tiết");
        panelTam28.add(btnChiTiet28, new java.awt.GridBagConstraints());

        btnChucNang28.setText("Nút 2");
        panelTam28.add(btnChucNang28, new java.awt.GridBagConstraints());

        panel28.add(panelTam28, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 150, 110));

        panelTang10.add(panel28);

        panel29.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        panel29.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblSoPhong29.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        lblSoPhong29.setForeground(new java.awt.Color(255, 255, 255));
        lblSoPhong29.setText("Số phòng");
        panel29.add(lblSoPhong29, new org.netbeans.lib.awtextra.AbsoluteConstraints(51, 9, -1, -1));

        lblLoai29.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblLoai29.setText("Loại:");
        panel29.add(lblLoai29, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 37, -1, -1));

        lblTrangThai29.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblTrangThai29.setText("Trạng thái:");
        panel29.add(lblTrangThai29, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 62, -1, -1));

        panelTam29.setLayout(new java.awt.GridBagLayout());

        btnChiTiet29.setText("Chi tiết");
        panelTam29.add(btnChiTiet29, new java.awt.GridBagConstraints());

        btnChucNang29.setText("Nút 2");
        panelTam29.add(btnChucNang29, new java.awt.GridBagConstraints());

        panel29.add(panelTam29, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 150, 110));

        panelTang10.add(panel29);

        panel30.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        panel30.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblSoPhong30.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        lblSoPhong30.setForeground(new java.awt.Color(255, 255, 255));
        lblSoPhong30.setText("Số phòng");
        panel30.add(lblSoPhong30, new org.netbeans.lib.awtextra.AbsoluteConstraints(51, 9, -1, -1));

        lblLoai30.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblLoai30.setText("Loại:");
        panel30.add(lblLoai30, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 37, -1, -1));

        lblTrangThai30.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblTrangThai30.setText("Trạng thái:");
        panel30.add(lblTrangThai30, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 62, -1, -1));

        panelTam30.setLayout(new java.awt.GridBagLayout());

        btnChiTiet30.setText("Chi tiết");
        panelTam30.add(btnChiTiet30, new java.awt.GridBagConstraints());

        btnChucNang30.setText("Nút 2");
        panelTam30.add(btnChucNang30, new java.awt.GridBagConstraints());

        panel30.add(panelTam30, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 150, 110));

        panelTang10.add(panel30);

        panel36.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        panel36.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                panel36MouseEntered(evt);
            }
        });
        panel36.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblSoPhong36.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        lblSoPhong36.setForeground(new java.awt.Color(255, 255, 255));
        lblSoPhong36.setText("Số phòng");
        panel36.add(lblSoPhong36, new org.netbeans.lib.awtextra.AbsoluteConstraints(51, 9, -1, -1));

        lblLoai36.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblLoai36.setText("Loại:");
        panel36.add(lblLoai36, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 37, -1, -1));

        lblTrangThai36.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblTrangThai36.setText("Trạng thái:");
        panel36.add(lblTrangThai36, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 62, -1, -1));

        panelTam36.setLayout(new java.awt.GridBagLayout());

        btnChiTiet36.setText("Chi tiết");
        panelTam36.add(btnChiTiet36, new java.awt.GridBagConstraints());

        btnChucNang36.setText("Nút 2");
        panelTam36.add(btnChucNang36, new java.awt.GridBagConstraints());

        panel36.add(panelTam36, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 150, 110));

        panelTang10.add(panel36);

        add(panelTang10);
    }// </editor-fold>//GEN-END:initComponents

    private void panel1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel1MouseEntered

    }//GEN-LAST:event_panel1MouseEntered

    private void panel2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel2MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_panel2MouseEntered

    private void panel3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel3MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_panel3MouseEntered

    private void panel4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel4MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_panel4MouseEntered

    private void panel5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel5MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_panel5MouseEntered

    private void panel6MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel6MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_panel6MouseEntered

    private void panel7MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel7MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_panel7MouseEntered

    private void panel8MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel8MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_panel8MouseEntered

    private void panel9MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel9MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_panel9MouseEntered

    private void panel10MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel10MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_panel10MouseEntered

    private void panel11MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel11MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_panel11MouseEntered

    private void panel12MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel12MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_panel12MouseEntered

    private void panel13MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel13MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_panel13MouseEntered

    private void panel14MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel14MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_panel14MouseEntered

    private void panel15MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel15MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_panel15MouseEntered

    private void panel16MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel16MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_panel16MouseEntered

    private void panel17MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel17MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_panel17MouseEntered

    private void panel18MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel18MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_panel18MouseEntered

    private void panel19MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel19MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_panel19MouseEntered

    private void panel20MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel20MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_panel20MouseEntered

    private void panel21MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel21MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_panel21MouseEntered

    private void panel22MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel22MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_panel22MouseEntered

    private void panel23MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel23MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_panel23MouseEntered

    private void panel24MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel24MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_panel24MouseEntered

    private void panel25MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel25MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_panel25MouseEntered

    private void btnChiTiet1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChiTiet1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnChiTiet1ActionPerformed

    private void panel31MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel31MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_panel31MouseEntered

    private void panel32MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel32MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_panel32MouseEntered

    private void panel33MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel33MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_panel33MouseEntered

    private void panel34MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel34MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_panel34MouseEntered

    private void panel35MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel35MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_panel35MouseEntered

    private void panel36MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel36MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_panel36MouseEntered


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnChiTiet1;
    private javax.swing.JButton btnChiTiet10;
    private javax.swing.JButton btnChiTiet11;
    private javax.swing.JButton btnChiTiet12;
    private javax.swing.JButton btnChiTiet13;
    private javax.swing.JButton btnChiTiet14;
    private javax.swing.JButton btnChiTiet15;
    private javax.swing.JButton btnChiTiet16;
    private javax.swing.JButton btnChiTiet17;
    private javax.swing.JButton btnChiTiet18;
    private javax.swing.JButton btnChiTiet19;
    private javax.swing.JButton btnChiTiet2;
    private javax.swing.JButton btnChiTiet20;
    private javax.swing.JButton btnChiTiet21;
    private javax.swing.JButton btnChiTiet22;
    private javax.swing.JButton btnChiTiet23;
    private javax.swing.JButton btnChiTiet24;
    private javax.swing.JButton btnChiTiet25;
    private javax.swing.JButton btnChiTiet26;
    private javax.swing.JButton btnChiTiet27;
    private javax.swing.JButton btnChiTiet28;
    private javax.swing.JButton btnChiTiet29;
    private javax.swing.JButton btnChiTiet3;
    private javax.swing.JButton btnChiTiet30;
    private javax.swing.JButton btnChiTiet31;
    private javax.swing.JButton btnChiTiet32;
    private javax.swing.JButton btnChiTiet33;
    private javax.swing.JButton btnChiTiet34;
    private javax.swing.JButton btnChiTiet35;
    private javax.swing.JButton btnChiTiet36;
    private javax.swing.JButton btnChiTiet4;
    private javax.swing.JButton btnChiTiet5;
    private javax.swing.JButton btnChiTiet6;
    private javax.swing.JButton btnChiTiet7;
    private javax.swing.JButton btnChiTiet8;
    private javax.swing.JButton btnChiTiet9;
    private javax.swing.JButton btnChucNang1;
    private javax.swing.JButton btnChucNang10;
    private javax.swing.JButton btnChucNang11;
    private javax.swing.JButton btnChucNang12;
    private javax.swing.JButton btnChucNang13;
    private javax.swing.JButton btnChucNang14;
    private javax.swing.JButton btnChucNang15;
    private javax.swing.JButton btnChucNang16;
    private javax.swing.JButton btnChucNang17;
    private javax.swing.JButton btnChucNang18;
    private javax.swing.JButton btnChucNang19;
    private javax.swing.JButton btnChucNang2;
    private javax.swing.JButton btnChucNang20;
    private javax.swing.JButton btnChucNang21;
    private javax.swing.JButton btnChucNang22;
    private javax.swing.JButton btnChucNang23;
    private javax.swing.JButton btnChucNang24;
    private javax.swing.JButton btnChucNang25;
    private javax.swing.JButton btnChucNang26;
    private javax.swing.JButton btnChucNang27;
    private javax.swing.JButton btnChucNang28;
    private javax.swing.JButton btnChucNang29;
    private javax.swing.JButton btnChucNang3;
    private javax.swing.JButton btnChucNang30;
    private javax.swing.JButton btnChucNang31;
    private javax.swing.JButton btnChucNang32;
    private javax.swing.JButton btnChucNang33;
    private javax.swing.JButton btnChucNang34;
    private javax.swing.JButton btnChucNang35;
    private javax.swing.JButton btnChucNang36;
    private javax.swing.JButton btnChucNang4;
    private javax.swing.JButton btnChucNang5;
    private javax.swing.JButton btnChucNang6;
    private javax.swing.JButton btnChucNang7;
    private javax.swing.JButton btnChucNang8;
    private javax.swing.JButton btnChucNang9;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel lblLoai1;
    private javax.swing.JLabel lblLoai10;
    private javax.swing.JLabel lblLoai11;
    private javax.swing.JLabel lblLoai12;
    private javax.swing.JLabel lblLoai13;
    private javax.swing.JLabel lblLoai14;
    private javax.swing.JLabel lblLoai15;
    private javax.swing.JLabel lblLoai16;
    private javax.swing.JLabel lblLoai17;
    private javax.swing.JLabel lblLoai18;
    private javax.swing.JLabel lblLoai19;
    private javax.swing.JLabel lblLoai2;
    private javax.swing.JLabel lblLoai20;
    private javax.swing.JLabel lblLoai21;
    private javax.swing.JLabel lblLoai22;
    private javax.swing.JLabel lblLoai23;
    private javax.swing.JLabel lblLoai24;
    private javax.swing.JLabel lblLoai25;
    private javax.swing.JLabel lblLoai26;
    private javax.swing.JLabel lblLoai27;
    private javax.swing.JLabel lblLoai28;
    private javax.swing.JLabel lblLoai29;
    private javax.swing.JLabel lblLoai3;
    private javax.swing.JLabel lblLoai30;
    private javax.swing.JLabel lblLoai31;
    private javax.swing.JLabel lblLoai32;
    private javax.swing.JLabel lblLoai33;
    private javax.swing.JLabel lblLoai34;
    private javax.swing.JLabel lblLoai35;
    private javax.swing.JLabel lblLoai36;
    private javax.swing.JLabel lblLoai4;
    private javax.swing.JLabel lblLoai5;
    private javax.swing.JLabel lblLoai6;
    private javax.swing.JLabel lblLoai7;
    private javax.swing.JLabel lblLoai8;
    private javax.swing.JLabel lblLoai9;
    private javax.swing.JLabel lblSoPhong1;
    private javax.swing.JLabel lblSoPhong10;
    private javax.swing.JLabel lblSoPhong11;
    private javax.swing.JLabel lblSoPhong12;
    private javax.swing.JLabel lblSoPhong13;
    private javax.swing.JLabel lblSoPhong14;
    private javax.swing.JLabel lblSoPhong15;
    private javax.swing.JLabel lblSoPhong16;
    private javax.swing.JLabel lblSoPhong17;
    private javax.swing.JLabel lblSoPhong18;
    private javax.swing.JLabel lblSoPhong19;
    private javax.swing.JLabel lblSoPhong2;
    private javax.swing.JLabel lblSoPhong20;
    private javax.swing.JLabel lblSoPhong21;
    private javax.swing.JLabel lblSoPhong22;
    private javax.swing.JLabel lblSoPhong23;
    private javax.swing.JLabel lblSoPhong24;
    private javax.swing.JLabel lblSoPhong25;
    private javax.swing.JLabel lblSoPhong26;
    private javax.swing.JLabel lblSoPhong27;
    private javax.swing.JLabel lblSoPhong28;
    private javax.swing.JLabel lblSoPhong29;
    private javax.swing.JLabel lblSoPhong3;
    private javax.swing.JLabel lblSoPhong30;
    private javax.swing.JLabel lblSoPhong31;
    private javax.swing.JLabel lblSoPhong32;
    private javax.swing.JLabel lblSoPhong33;
    private javax.swing.JLabel lblSoPhong34;
    private javax.swing.JLabel lblSoPhong35;
    private javax.swing.JLabel lblSoPhong36;
    private javax.swing.JLabel lblSoPhong4;
    private javax.swing.JLabel lblSoPhong5;
    private javax.swing.JLabel lblSoPhong6;
    private javax.swing.JLabel lblSoPhong7;
    private javax.swing.JLabel lblSoPhong8;
    private javax.swing.JLabel lblSoPhong9;
    private javax.swing.JLabel lblTrangThai1;
    private javax.swing.JLabel lblTrangThai10;
    private javax.swing.JLabel lblTrangThai11;
    private javax.swing.JLabel lblTrangThai12;
    private javax.swing.JLabel lblTrangThai13;
    private javax.swing.JLabel lblTrangThai14;
    private javax.swing.JLabel lblTrangThai15;
    private javax.swing.JLabel lblTrangThai16;
    private javax.swing.JLabel lblTrangThai17;
    private javax.swing.JLabel lblTrangThai18;
    private javax.swing.JLabel lblTrangThai19;
    private javax.swing.JLabel lblTrangThai2;
    private javax.swing.JLabel lblTrangThai20;
    private javax.swing.JLabel lblTrangThai21;
    private javax.swing.JLabel lblTrangThai22;
    private javax.swing.JLabel lblTrangThai23;
    private javax.swing.JLabel lblTrangThai24;
    private javax.swing.JLabel lblTrangThai25;
    private javax.swing.JLabel lblTrangThai26;
    private javax.swing.JLabel lblTrangThai27;
    private javax.swing.JLabel lblTrangThai28;
    private javax.swing.JLabel lblTrangThai29;
    private javax.swing.JLabel lblTrangThai3;
    private javax.swing.JLabel lblTrangThai30;
    private javax.swing.JLabel lblTrangThai31;
    private javax.swing.JLabel lblTrangThai32;
    private javax.swing.JLabel lblTrangThai33;
    private javax.swing.JLabel lblTrangThai34;
    private javax.swing.JLabel lblTrangThai35;
    private javax.swing.JLabel lblTrangThai36;
    private javax.swing.JLabel lblTrangThai4;
    private javax.swing.JLabel lblTrangThai5;
    private javax.swing.JLabel lblTrangThai6;
    private javax.swing.JLabel lblTrangThai7;
    private javax.swing.JLabel lblTrangThai8;
    private javax.swing.JLabel lblTrangThai9;
    private javax.swing.JPanel panel1;
    private javax.swing.JPanel panel10;
    private javax.swing.JPanel panel11;
    private javax.swing.JPanel panel12;
    private javax.swing.JPanel panel13;
    private javax.swing.JPanel panel14;
    private javax.swing.JPanel panel15;
    private javax.swing.JPanel panel16;
    private javax.swing.JPanel panel17;
    private javax.swing.JPanel panel18;
    private javax.swing.JPanel panel19;
    private javax.swing.JPanel panel2;
    private javax.swing.JPanel panel20;
    private javax.swing.JPanel panel21;
    private javax.swing.JPanel panel22;
    private javax.swing.JPanel panel23;
    private javax.swing.JPanel panel24;
    private javax.swing.JPanel panel25;
    private javax.swing.JPanel panel26;
    private javax.swing.JPanel panel27;
    private javax.swing.JPanel panel28;
    private javax.swing.JPanel panel29;
    private javax.swing.JPanel panel3;
    private javax.swing.JPanel panel30;
    private javax.swing.JPanel panel31;
    private javax.swing.JPanel panel32;
    private javax.swing.JPanel panel33;
    private javax.swing.JPanel panel34;
    private javax.swing.JPanel panel35;
    private javax.swing.JPanel panel36;
    private javax.swing.JPanel panel4;
    private javax.swing.JPanel panel5;
    private javax.swing.JPanel panel6;
    private javax.swing.JPanel panel7;
    private javax.swing.JPanel panel8;
    private javax.swing.JPanel panel9;
    private javax.swing.JPanel panelTam1;
    private javax.swing.JPanel panelTam10;
    private javax.swing.JPanel panelTam11;
    private javax.swing.JPanel panelTam12;
    private javax.swing.JPanel panelTam13;
    private javax.swing.JPanel panelTam14;
    private javax.swing.JPanel panelTam15;
    private javax.swing.JPanel panelTam16;
    private javax.swing.JPanel panelTam17;
    private javax.swing.JPanel panelTam18;
    private javax.swing.JPanel panelTam19;
    private javax.swing.JPanel panelTam2;
    private javax.swing.JPanel panelTam20;
    private javax.swing.JPanel panelTam21;
    private javax.swing.JPanel panelTam22;
    private javax.swing.JPanel panelTam23;
    private javax.swing.JPanel panelTam24;
    private javax.swing.JPanel panelTam25;
    private javax.swing.JPanel panelTam26;
    private javax.swing.JPanel panelTam27;
    private javax.swing.JPanel panelTam28;
    private javax.swing.JPanel panelTam29;
    private javax.swing.JPanel panelTam3;
    private javax.swing.JPanel panelTam30;
    private javax.swing.JPanel panelTam31;
    private javax.swing.JPanel panelTam32;
    private javax.swing.JPanel panelTam33;
    private javax.swing.JPanel panelTam34;
    private javax.swing.JPanel panelTam35;
    private javax.swing.JPanel panelTam36;
    private javax.swing.JPanel panelTam4;
    private javax.swing.JPanel panelTam5;
    private javax.swing.JPanel panelTam6;
    private javax.swing.JPanel panelTam7;
    private javax.swing.JPanel panelTam8;
    private javax.swing.JPanel panelTam9;
    private javax.swing.JPanel panelTang;
    private javax.swing.JPanel panelTang1;
    private javax.swing.JPanel panelTang10;
    private javax.swing.JPanel panelTang11;
    private javax.swing.JPanel panelTang2;
    private javax.swing.JPanel panelTang3;
    private javax.swing.JPanel panelTang4;
    private javax.swing.JPanel panelTang5;
    private javax.swing.JPanel panelTang6;
    private javax.swing.JPanel panelTang7;
    private javax.swing.JPanel panelTang8;
    private javax.swing.JPanel panelTang9;
    // End of variables declaration//GEN-END:variables
}
