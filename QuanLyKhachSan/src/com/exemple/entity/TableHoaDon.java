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
public class TableHoaDon {
    private int maHoaDon;
    private Date ngayTao ;
    private Date ngaynhanPhong ;
    private Date ngayTraPhong ;
    private Float thanhTien ;
    private String taiKhoanNV ;
    private String soCMND;
    private String maKhuyenMai ;
    private int soPhong ;

    public TableHoaDon() {
    }

    public TableHoaDon(int maHoaDon, Date ngayTao, Date ngaynhanPhong, Date ngayTraPhong, Float thanhTien, String taiKhoanNV, String soCMND, String maKhuyenMai, int soPhong) {
        this.maHoaDon = maHoaDon;
        this.ngayTao = ngayTao;
        this.ngaynhanPhong = ngaynhanPhong;
        this.ngayTraPhong = ngayTraPhong;
        this.thanhTien = thanhTien;
        this.taiKhoanNV = taiKhoanNV;
        this.soCMND = soCMND;
        this.maKhuyenMai = maKhuyenMai;
        this.soPhong = soPhong;
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

    public Date getNgaynhanPhong() {
        return ngaynhanPhong;
    }

    public void setNgaynhanPhong(Date ngaynhanPhong) {
        this.ngaynhanPhong = ngaynhanPhong;
    }

    public Date getNgayTraPhong() {
        return ngayTraPhong;
    }

    public void setNgayTraPhong(Date ngayTraPhong) {
        this.ngayTraPhong = ngayTraPhong;
    }

    public Float getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(Float thanhTien) {
        this.thanhTien = thanhTien;
    }

    public String getTaiKhoanNV() {
        return taiKhoanNV;
    }

    public void setTaiKhoanNV(String taiKhoanNV) {
        this.taiKhoanNV = taiKhoanNV;
    }

    public String getSoCMND() {
        return soCMND;
    }

    public void setSoCMND(String soCMND) {
        this.soCMND = soCMND;
    }

    public String getMaKhuyenMai() {
        return maKhuyenMai;
    }

    public void setMaKhuyenMai(String maKhuyenMai) {
        this.maKhuyenMai = maKhuyenMai;
    }

    public int getSoPhong() {
        return soPhong;
    }

    public void setSoPhong(int soPhong) {
        this.soPhong = soPhong;
    }

   
}
