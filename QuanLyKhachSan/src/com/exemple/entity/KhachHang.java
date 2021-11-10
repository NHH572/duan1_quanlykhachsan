/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.exemple.entity;

import java.util.Date;

/**
 *
 * @author hp
 */
public class KhachHang {
    private String CMND;
    private String tenKhachHang;
    private Date ngaySinh;
    private boolean gioiTinh;
    private String soDienThoai;
    private String quocTich;
    private int soLanThue;
    private int maDoiTac;

    public KhachHang() {
    }

    public KhachHang(String CMND, String tenKhachHang, Date ngaySinh, boolean gioiTinh, String soDienThoai, String quocTich, int soLanThue, int maDoiTac) {
        this.CMND = CMND;
        this.tenKhachHang = tenKhachHang;
        this.ngaySinh = ngaySinh;
        this.gioiTinh = gioiTinh;
        this.soDienThoai = soDienThoai;
        this.quocTich = quocTich;
        this.soLanThue = soLanThue;
        this.maDoiTac = maDoiTac;
    }

    public String getCMND() {
        return CMND;
    }

    public void setCMND(String CMND) {
        this.CMND = CMND;
    }

    public String getTenKhachHang() {
        return tenKhachHang;
    }

    public void setTenKhachHang(String tenKhachHang) {
        this.tenKhachHang = tenKhachHang;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public boolean isGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(boolean gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getQuocTich() {
        return quocTich;
    }

    public void setQuocTich(String quocTich) {
        this.quocTich = quocTich;
    }

    public int getSoLanThue() {
        return soLanThue;
    }

    public void setSoLanThue(int soLanThue) {
        this.soLanThue = soLanThue;
    }

    public int getMaDoiTac() {
        return maDoiTac;
    }

    public void setMaDoiTac(int maDoiTac) {
        this.maDoiTac = maDoiTac;
    }
    
    
}
