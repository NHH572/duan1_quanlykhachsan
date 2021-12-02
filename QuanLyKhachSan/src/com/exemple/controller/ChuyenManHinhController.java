/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.exemple.controller;

import com.exemple.views.DangnhapJDialog;
import com.exemple.views.QuanLyDatPhongJPanel;
import com.exemple.views.QuanLyDichVuJPanel;
import com.exemple.views.QuanLyDoiTacJPanel;
import com.exemple.views.QuanLyHoaDonJPanel;
import com.exemple.views.QuanLyKhoJPanel;

import com.exemple.views.QuanLyNhanVienJPanel;
import com.exemple.views.QuanLyPhongJPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.event.MouseInputListener;
import com.exemple.entity.DanhMuc;
import com.exemple.entity.DanhMucSoDoPhong;
import com.exemple.entity.SoDoPhong;
import com.exemple.views.HoTroJPanel;
import com.exemple.views.QuanLyKhuyenMaiJPanel;
import com.exemple.views.SoDoPhongJPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Minh Triet
 */
public class ChuyenManHinhController {

    public static Color colorDefault = new Color(77, 73, 73);
    public static Color colorChange = new Color(212, 187, 0);
    public static Color colorHover = new Color(212, 187, 0);
    private JPanel mainPanel;
    private String kindSelected = "";
    private List<DanhMuc> listDanhMuc = null;
    private List<DanhMucSoDoPhong> listDanhMucSoDoPhong = null;

    public ChuyenManHinhController(JPanel mainPanel) {
        this.mainPanel = mainPanel;
    }

    public void setView(JPanel jpnItem, JLabel jlbItem, JPanel opaque) {
        kindSelected = "SoDoPhong";
        jlbItem.setBackground(colorChange);
        jpnItem.setBackground(colorChange);
        opaque.setOpaque(true);
        mainPanel.removeAll();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(new SoDoPhongJPanel());
        mainPanel.validate();
        mainPanel.repaint();
    }

    public void setEvent(List<DanhMuc> listDanhMuc) {
        this.listDanhMuc = listDanhMuc;
        for (DanhMuc item : listDanhMuc) {
            item.getJlb().addMouseListener(new LabelEvent(item.getKind(), item.getJpn(), item.getJlb(), item.getObq()));
        }
    }   

    class LabelEvent implements MouseInputListener {

        private JPanel node;
        private String kind;
        private JPanel jpnItem;
        private JLabel jlbItem;
        private JPanel opaque;

        public LabelEvent(String kind, JPanel jpnItem, JLabel jlbItem, JPanel opaque) {
            this.kind = kind;
            this.jpnItem = jpnItem;
            this.jlbItem = jlbItem;
            this.opaque = opaque;
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            switch (kind) {
                case "SoDoPhong":
                    node = new SoDoPhongJPanel();
                    break;
                case "QuanLyPhong":
                    node = new QuanLyPhongJPanel();
                    break;
                case "NhanVien":
                    node = new QuanLyNhanVienJPanel();
                    break;
                case "DichVu":
                    node = new QuanLyDichVuJPanel();
                    break;
                case "HoaDon":
                    node = new QuanLyHoaDonJPanel();
                    break;
                case "DatPhong":
                    node = new QuanLyDatPhongJPanel();
                    break;
                case "DoiTac":
                    node = new QuanLyDoiTacJPanel();
                    break;
                case "HoTro":
                    node = new HoTroJPanel();
                    break;
                case "KhuyenMai":
                    node = new QuanLyKhuyenMaiJPanel();
                    break;
                case "DangXuat":
                    new DangnhapJDialog(null, true).setVisible(true);
                    break;
                default:
                    break;
            }
            mainPanel.removeAll();
            mainPanel.setLayout(new BorderLayout());
            mainPanel.add(node);
            mainPanel.validate();
            mainPanel.repaint();
            setChangeBackground(kind);

        }

        @Override
        public void mousePressed(MouseEvent e) {
            kindSelected = kind;
            jpnItem.setBackground(colorChange);
            jlbItem.setBackground(colorChange);
            opaque.setOpaque(true);
        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {
            jpnItem.setBackground(colorHover);
            jlbItem.setBackground(colorHover);
            opaque.setOpaque(true);
        }

        @Override
        public void mouseExited(MouseEvent e) {
            if (!kindSelected.equalsIgnoreCase(kind)) {
                jpnItem.setBackground(colorDefault);
                jlbItem.setBackground(colorDefault);
                opaque.setOpaque(false);
            }
        }

        @Override
        public void mouseDragged(MouseEvent e) {
        }

        @Override
        public void mouseMoved(MouseEvent e) {
        }

    }

    private void setChangeBackground(String kind) {
        for (DanhMuc item : listDanhMuc) {
            if (item.getKind().equalsIgnoreCase(kind)) {
                item.getJpn().setBackground(colorChange);
                item.getJlb().setBackground(colorChange);
                item.getObq().setOpaque(true);
            } else {
                item.getJpn().setBackground(colorDefault);
                item.getJlb().setBackground(colorDefault);
                item.getObq().setOpaque(false);
            }
        }
    }

}
