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
public class ChiTietHoaDon {
    private int maChiTietHoaDon;
    private int maPhong;
    private int maHoaDon;
    private int maDichVu;
    private int soLanThueDichVu;
    private float tongTien;

    public ChiTietHoaDon() {
    }

    public ChiTietHoaDon(int maChiTietHoaDon, int maPhong, int maHoaDon, int maDichVu, int soLanThueDichVu, float tongTien) {
        this.maChiTietHoaDon = maChiTietHoaDon;
        this.maPhong = maPhong;
        this.maHoaDon = maHoaDon;
        this.maDichVu = maDichVu;
        this.soLanThueDichVu = soLanThueDichVu;
        this.tongTien = tongTien;
    }

    public int getMaChiTietHoaDon() {
        return maChiTietHoaDon;
    }

    public void setMaChiTietHoaDon(int maChiTietHoaDon) {
        this.maChiTietHoaDon = maChiTietHoaDon;
    }

    public int getMaPhong() {
        return maPhong;
    }

    public void setMaPhong(int maPhong) {
        this.maPhong = maPhong;
    }

    public int getMaHoaDon() {
        return maHoaDon;
    }

    public void setMaHoaDon(int maHoaDon) {
        this.maHoaDon = maHoaDon;
    }

    public int getMaDichVu() {
        return maDichVu;
    }

    public void setMaDichVu(int maDichVu) {
        this.maDichVu = maDichVu;
    }

    public int getSoLanThueDichVu() {
        return soLanThueDichVu;
    }

    public void setSoLanThueDichVu(int soLanThueDichVu) {
        this.soLanThueDichVu = soLanThueDichVu;
    }

    public float getTongTien() {
        return tongTien;
    }

    public void setTongTien(float tongTien) {
        this.tongTien = tongTien;
    }
    
}
