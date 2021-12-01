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
public class HoaDonLoadTable {
    private int SoPhong ;
    private String tenDichVu;
    private int soLan;
    private float giaDichVu;
    private String CMND_CCCD;
    private String maHoaDon;
    private String tenKhachHang;
    private Date ngayTao ;
    private String thuNgan ;
    private Date ngaynhanPhong ;
    private int maPhong ;
    private Date ngayTraPhong ;
    private String soDienThoai ;
    private float tienPhong ;
    private String maGiamGia;
    private float giamTien ;
    private String tongTien ;
    private int maDichVu;

    public HoaDonLoadTable() {
    }

public HoaDonLoadTable(int SoPhong, String tenDichVu, int soLan, float giaDichVu, String CMND_CCCD, String maHoaDon, String tenKhachHang, Date ngayTao, String thuNgan, Date ngaynhanPhong, int maPhong, Date ngayTraPhong, String soDienThoai, float tienPhong, String maGiamGia, float giamTien, String tongTien, int maDichVu) {
        this.SoPhong = SoPhong;
        this.tenDichVu = tenDichVu;
        this.soLan = soLan;
        this.giaDichVu = giaDichVu;
        this.CMND_CCCD = CMND_CCCD;
        this.maHoaDon = maHoaDon;
        this.tenKhachHang = tenKhachHang;
        this.ngayTao = ngayTao;
        this.thuNgan = thuNgan;
        this.ngaynhanPhong = ngaynhanPhong;
        this.maPhong = maPhong;
        this.ngayTraPhong = ngayTraPhong;
        this.soDienThoai = soDienThoai;
        this.tienPhong = tienPhong;
        this.maGiamGia = maGiamGia;
        this.giamTien = giamTien;
        this.tongTien = tongTien;
        this.maDichVu = maDichVu;
    }
    
    public float getTienPhong() {
        return tienPhong;
    }

    public void setTienPhong(float tienPhong) {
        this.tienPhong = tienPhong;
    }

    public String getCMND_CCCD() {
        return CMND_CCCD;
    }

    public void setCMND_CCCD(String CMND_CCCD) {
        this.CMND_CCCD = CMND_CCCD;
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

    public int getMaPhong() {
        return maPhong;
    }

    public void setMaPhong(int maPhong) {
        this.maPhong = maPhong;
    }

    public int getMaDichVu() {
        return maDichVu;
    }

    public void setMaDichVu(int maDichVu) {
        this.maDichVu = maDichVu;
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
