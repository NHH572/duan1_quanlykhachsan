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
    private int giaTri;
    private Date ngayBatDau;
    private Date NgayHetHan;

    public KhuyenMai() {
    }

    public KhuyenMai(String maKhuyenMai, String tenKhuyenMai, int giaTri, Date ngayBatDau, Date NgayHetHan) {
        this.maKhuyenMai = maKhuyenMai;
        this.tenKhuyenMai = tenKhuyenMai;
        this.giaTri = giaTri;
        this.ngayBatDau = ngayBatDau;
        this.NgayHetHan = NgayHetHan;
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

    public int getGiaTri() {
        return giaTri;
    }

    public void setGiaTri(int giaTri) {
        this.giaTri = giaTri;
    }

    public Date getNgayBatDau() {
        return ngayBatDau;
    }

    public void setNgayBatDau(Date ngayBatDau) {
        this.ngayBatDau = ngayBatDau;
    }

    public Date getNgayHetHan() {
        return NgayHetHan;
    }

    public void setNgayHetHan(Date NgayHetHan) {
        this.NgayHetHan = NgayHetHan;
    }

    
   
    
    
}
