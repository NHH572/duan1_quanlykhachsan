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
    private String maDoiTac;
    private String tenDoiTac;
    private String soDienThoai;
    private String danhGia;

    public DoiTac() {
    }

    public DoiTac(String maDoiTac, String tenDoiTac, String soDienThoai, String danhGia) {
        this.maDoiTac = maDoiTac;
        this.tenDoiTac = tenDoiTac;
        this.soDienThoai = soDienThoai;
        this.danhGia = danhGia;
    }

    public String getMaDoiTac() {
        return maDoiTac;
    }

    public void setMaDoiTac(String maDoiTac) {
        this.maDoiTac = maDoiTac;
    }

    public String getTenDoiTac() {
        return tenDoiTac;
    }

    public void setTenDoiTac(String tenDoiTac) {
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
    
       public String toString() {
        return this.tenDoiTac;
    }
    
    
}
