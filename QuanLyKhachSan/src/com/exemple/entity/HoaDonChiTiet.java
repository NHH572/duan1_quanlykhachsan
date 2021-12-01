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
public class HoaDonChiTiet {
    private String maHoaDon;
    private String tenKhachHang;
    private Date ngayTao ;
    private String thuNgan ;
    private Date ngaynhanPhong ;
    private String diaChi ;
    private Date ngayTraPhong ;
    private String soDienThoai ;
    private String ghiChu ;
    private String maGiamGia;
    private float giamTien ;
    private String tongTien ;

    public HoaDonChiTiet() {
    }

    public HoaDonChiTiet(String maHoaDon, String tenKhachHang, Date ngayTao, String thuNgan, Date ngaynhanPhong, String diaChi, Date ngayTraPhong, String soDienThoai, String ghiChu, String maGiamGia, float giamTien, String tongTien) {
        this.maHoaDon = maHoaDon;
        this.tenKhachHang = tenKhachHang;
        this.ngayTao = ngayTao;
        this.thuNgan = thuNgan;
        this.ngaynhanPhong = ngaynhanPhong;
        this.diaChi = diaChi;
        this.ngayTraPhong = ngayTraPhong;
        this.soDienThoai = soDienThoai;
        this.ghiChu = ghiChu;
        this.maGiamGia = maGiamGia;
        this.giamTien = giamTien;
        this.tongTien = tongTien;
    }

    public String getMaHoaDon() {
        return maHoaDon;
    }

    public void setMaHoaDon(String maHoaDon) {
        this.maHoaDon = maHoaDon;
    }

    public String getTenKhachHang() {
        return tenKhachHang;
    }

    public void setTenKhachHang(String tenKhachHang) {
        this.tenKhachHang = tenKhachHang;
    }

    public Date getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }

    public String getThuNgan() {
        return thuNgan;
    }

    public void setThuNgan(String thuNgan) {
        this.thuNgan = thuNgan;
    }

    public Date getNgaynhanPhong() {
        return ngaynhanPhong;
    }

    public void setNgaynhanPhong(Date ngaynhanPhong) {
        this.ngaynhanPhong = ngaynhanPhong;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public Date getNgayTraPhong() {
        return ngayTraPhong;
    }

    public void setNgayTraPhong(Date ngayTraPhong) {
        this.ngayTraPhong = ngayTraPhong;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public String getMaGiamGia() {
        return maGiamGia;
    }

    public void setMaGiamGia(String maGiamGia) {
        this.maGiamGia = maGiamGia;
    }

    public float getGiamTien() {
        return giamTien;
    }

    public void setGiamTien(float giamTien) {
        this.giamTien = giamTien;
    }

    public String getTongTien() {
        return tongTien;
    }

    public void setTongTien(String tongTien) {
        this.tongTien = tongTien;
    }
    
    
}
