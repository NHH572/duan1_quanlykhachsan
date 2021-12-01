/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.exemple.entity;

import java.util.Date;


public class HoaDon {
    private int maHoaDon;
    private Date ngayTao;
    private Date ngayNhanPhong;
    private Date ngayTraPhong;
    private float thanhToan;
    private String CMND_CCCD;
    private String maKhuyenMai;
    private String TaiKhoanNV;

    public HoaDon() {
    }

    public HoaDon(int maHoaDon, Date ngayTao, Date ngayNhanPhong, Date ngayTraPhong, float thanhToan, String CMND_CCCD, String maKhuyenMai, String TaiKhoanNV) {
        this.maHoaDon = maHoaDon;
        this.ngayTao = ngayTao;
        this.ngayNhanPhong = ngayNhanPhong;
        this.ngayTraPhong = ngayTraPhong;
        this.thanhToan = thanhToan;
        this.CMND_CCCD = CMND_CCCD;
        this.maKhuyenMai = maKhuyenMai;
        this.TaiKhoanNV = TaiKhoanNV;
    }

    public int getMaHoaDon() {
        return maHoaDon;
    }

    public void setMaHoaDon(int maHoaDon) {
        this.maHoaDon = maHoaDon;
    }

    public Date getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(Date ngayTao) {
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

    public String getTaiKhoanNV() {
        return TaiKhoanNV;
    }

    public void setTaiKhoanNV(String TaiKhoanNV) {
        this.TaiKhoanNV = TaiKhoanNV;
    }

    
}
