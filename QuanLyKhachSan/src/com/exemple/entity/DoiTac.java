/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.exemple.entity;

/**
 *
 * @author hp
 */
public class DoiTac {
    private int maDoiTac;
    private int tenDoiTac;
    private String soDienThoai;
    private String danhGia;

    public DoiTac() {
    }

    public DoiTac(int maDoiTac, int tenDoiTac, String soDienThoai, String danhGia) {
        this.maDoiTac = maDoiTac;
        this.tenDoiTac = tenDoiTac;
        this.soDienThoai = soDienThoai;
        this.danhGia = danhGia;
    }

    public int getMaDoiTac() {
        return maDoiTac;
    }

    public void setMaDoiTac(int maDoiTac) {
        this.maDoiTac = maDoiTac;
    }

    public int getTenDoiTac() {
        return tenDoiTac;
    }

    public void setTenDoiTac(int tenDoiTac) {
        this.tenDoiTac = tenDoiTac;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getDanhGia() {
        return danhGia;
    }

    public void setDanhGia(String danhGia) {
        this.danhGia = danhGia;
    }
    
    
}
