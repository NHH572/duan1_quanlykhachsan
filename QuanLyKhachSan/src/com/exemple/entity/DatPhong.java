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
public class DatPhong {
    int maDatPhong;
    int ngayDat;
    int ngayHetHan;
    String thoiGianThue;
    int tamTinh;
    int maPhong;
    String CMND_CCCD;
    String maNV;
    int maLoaiPhong;

    public DatPhong() {
    }

    public DatPhong(int maDatPhong, int ngayDat, int ngayHetHan, String thoiGianThue, int tamTinh, int maPhong, String CMND_CCCD, String maNV, int maLoaiPhong) {
        this.maDatPhong = maDatPhong;
        this.ngayDat = ngayDat;
        this.ngayHetHan = ngayHetHan;
        this.thoiGianThue = thoiGianThue;
        this.tamTinh = tamTinh;
        this.maPhong = maPhong;
        this.CMND_CCCD = CMND_CCCD;
        this.maNV = maNV;
        this.maLoaiPhong = maLoaiPhong;
    }

    public int getMaDatPhong() {
        return maDatPhong;
    }

    public void setMaDatPhong(int maDatPhong) {
        this.maDatPhong = maDatPhong;
    }

    public int getNgayDat() {
        return ngayDat;
    }

    public void setNgayDat(int ngayDat) {
        this.ngayDat = ngayDat;
    }

    public int getNgayHetHan() {
        return ngayHetHan;
    }

    public void setNgayHetHan(int ngayHetHan) {
        this.ngayHetHan = ngayHetHan;
    }

    public String getThoiGianThue() {
        return thoiGianThue;
    }

    public void setThoiGianThue(String thoiGianThue) {
        this.thoiGianThue = thoiGianThue;
    }

    public int getTamTinh() {
        return tamTinh;
    }

    public void setTamTinh(int tamTinh) {
        this.tamTinh = tamTinh;
    }

    public int getMaPhong() {
        return maPhong;
    }

    public void setMaPhong(int maPhong) {
        this.maPhong = maPhong;
    }

    public String getCMND_CCCD() {
        return CMND_CCCD;
    }

    public void setCMND_CCCD(String CMND_CCCD) {
        this.CMND_CCCD = CMND_CCCD;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public int getMaLoaiPhong() {
        return maLoaiPhong;
    }

    public void setMaLoaiPhong(int maLoaiPhong) {
        this.maLoaiPhong = maLoaiPhong;
    }
}
