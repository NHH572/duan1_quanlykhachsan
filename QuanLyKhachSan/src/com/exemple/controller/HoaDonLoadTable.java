/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.exemple.controller;

/**
 *
 * @author hp
 */
public class HoaDonLoadTable {
    private int SoPhong ;
    private String tenDichVu;
    private int soLan;
    private float giaDichVu;

    public HoaDonLoadTable() {
    }

    public HoaDonLoadTable(int SoPhong, String tenDichVu, int soLan, float giaDichVu) {
        this.SoPhong = SoPhong;
        this.tenDichVu = tenDichVu;
        this.soLan = soLan;
        this.giaDichVu = giaDichVu;
    }

    public int getSoPhong() {
        return SoPhong;
    }

    public void setSoPhong(int SoPhong) {
        this.SoPhong = SoPhong;
    }

  

    public String getTenDichVu() {
        return tenDichVu;
    }

    public void setTenDichVu(String tenDichVu) {
        this.tenDichVu = tenDichVu;
    }

    public int getSoLan() {
        return soLan;
    }

    public void setSoLan(int soLan) {
        this.soLan = soLan;
    }

    public float getGiaDichVu() {
        return giaDichVu;
    }

    public void setGiaDichVu(float giaDichVu) {
        this.giaDichVu = giaDichVu;
    }
    
    
}
