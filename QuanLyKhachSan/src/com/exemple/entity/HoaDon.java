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
public class HoaDon {
    private int maHoaDon;
    private int ngayTao;
    private Date ngayNhanPhong;
    private Date ngayTraPhong;
    private float thanhToan;
    private String CMND_CCCD;
    private String maKhuyenMai;

    public HoaDon() {
    }

    public HoaDon(int maHoaDon, int ngayTao, Date ngayNhanPhong, Date ngayTraPhong, float thanhToan, String CMND_CCCD, String maKhuyenMai) {
        this.maHoaDon = maHoaDon;
        this.ngayTao = ngayTao;
        this.ngayNhanPhong = ngayNhanPhong;
        this.ngayTraPhong = ngayTraPhong;
        this.thanhToan = thanhToan;
        this.CMND_CCCD = CMND_CCCD;
        this.maKhuyenMai = maKhuyenMai;
    }

    public int getMaHoaDon() {
        return maHoaDon;
    }

    public void setMaHoaDon(int maHoaDon) {
        this.maHoaDon = maHoaDon;
    }

    public int getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(int ngayTao) {
        this.ngayTao = ngayTao;
    }

    public Date getNgayNhanPhong() {
        return ngayNhanPhong;
    }

    public void setNgayNhanPhong(Date ngayNhanPhong) {
        this.ngayNhanPhong = ngayNhanPhong;
    }

    public Date getNgayTraPhong() {
        return ngayTraPhong;
    }

    public void setNgayTraPhong(Date ngayTraPhong) {
        this.ngayTraPhong = ngayTraPhong;
    }

    public float getThanhToan() {
        return thanhToan;
    }

    public void setThanhToan(float thanhToan) {
        this.thanhToan = thanhToan;
    }

    public String getCMND_CCCD() {
        return CMND_CCCD;
    }

    public void setCMND_CCCD(String CMND_CCCD) {
        this.CMND_CCCD = CMND_CCCD;
    }

    public String getMaKhuyenMai() {
        return maKhuyenMai;
    }

    public void setMaKhuyenMai(String maKhuyenMai) {
        this.maKhuyenMai = maKhuyenMai;
    }
    
    
}
