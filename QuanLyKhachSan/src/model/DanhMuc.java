/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Minh Triet
 */
public class DanhMuc {

    private String kind;
    private JPanel jpn;
    private JLabel jlb;
    private JPanel obq;

    public DanhMuc() {
    }

    public DanhMuc(String kind, JPanel jpn, JLabel jlb, JPanel obq) {
        this.kind = kind;
        this.jpn = jpn;
        this.jlb = jlb;
        this.obq = obq;
    }

    public JPanel getObq() {
        return obq;
    }

    public void setObq(JPanel obq) {
        this.obq = obq;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public JPanel getJpn() {
        return jpn;
    }

    public void setJpn(JPanel jpn) {
        this.jpn = jpn;
    }

    public JLabel getJlb() {
        return jlb;
    }

    public void setJlb(JLabel jlb) {
        this.jlb = jlb;
    }
}
