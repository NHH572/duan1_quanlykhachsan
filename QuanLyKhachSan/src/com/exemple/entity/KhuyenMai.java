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
public class KhuyenMai {
    private String maKhuyenMai;
    private String tenKhuyenMai;
    private int gaiTri;
    private Date ngayBatDau;
    private Date ngayKetThuoc;

    public KhuyenMai() {
    }

    public KhuyenMai(String maKhuyenMai, String tenKhuyenMai, int gaiTri, Date ngayBatDau, Date ngayKetThuoc) {
        this.maKhuyenMai = maKhuyenMai;
        this.tenKhuyenMai = tenKhuyenMai;
        this.gaiTri = gaiTri;
        this.ngayBatDau = ngayBatDau;
        this.ngayKetThuoc = ngayKetThuoc;
    }

    public String getMaKhuyenMai() {
        return maKhuyenMai;
    }

    public void setMaKhuyenMai(String maKhuyenMai) {
        this.maKhuyenMai = maKhuyenMai;
    }

    public String getTenKhuyenMai() {
        return tenKhuyenMai;
    }

    public void setTenKhuyenMai(String tenKhuyenMai) {
        this.tenKhuyenMai = tenKhuyenMai;
    }

    public int getGaiTri() {
        return gaiTri;
    }

    public void setGaiTri(int gaiTri) {
        this.gaiTri = gaiTri;
    }

    public Date getNgayBatDau() {
        return ngayBatDau;
    }

    public void setNgayBatDau(Date ngayBatDau) {
        this.ngayBatDau = ngayBatDau;
    }

    public Date getNgayKetThuoc() {
        return ngayKetThuoc;
    }

    public void setNgayKetThuoc(Date ngayKetThuoc) {
        this.ngayKetThuoc = ngayKetThuoc;
    }
    
    
}
