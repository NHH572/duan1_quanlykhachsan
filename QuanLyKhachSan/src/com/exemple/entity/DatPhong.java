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
public class DatPhong {

    private int maDatPhong;
    private int maLoaiPhong;
    private Date ngayDat;
    private Date ngayNhanPhong;
    private Date ngayMuonTra;
    private int tamTinh;
    private String soCMT;
    private String hoTen;
    private boolean gioiTinh;
    private Date ngaySinh;
    private String soDienThoai;
    private String email;
    private String quocTich;
    private int maPhong;
    private String taiKhoanNV;

    public DatPhong() {
    }

    public DatPhong(int maDatPhong, int maLoaiPhong, Date ngayDat, Date ngayNhanPhong, Date ngayMuonTra, int tamTinh, String soCMT, String hoTen, boolean gioiTinh, Date ngaySinh, String soDienThoai, String email, String quocTich, int maPhong, String taiKhoanNV) {
        this.maDatPhong = maDatPhong;
        this.maLoaiPhong = maLoaiPhong;
        this.ngayDat = ngayDat;
        this.ngayNhanPhong = ngayNhanPhong;
        this.ngayMuonTra = ngayMuonTra;
        this.tamTinh = tamTinh;
        this.soCMT = soCMT;
        this.hoTen = hoTen;
        this.gioiTinh = gioiTinh;
        this.ngaySinh = ngaySinh;
        this.soDienThoai = soDienThoai;
        this.email = email;
        this.quocTich = quocTich;
        this.maPhong = maPhong;
        this.taiKhoanNV = taiKhoanNV;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public int getMaDatPhong() {
        return maDatPhong;
    }

    public void setMaDatPhong(int maDatPhong) {
        this.maDatPhong = maDatPhong;
    }

    public int getMaLoaiPhong() {
        return maLoaiPhong;
    }

    public void setMaLoaiPhong(int maLoaiPhong) {
        this.maLoaiPhong = maLoaiPhong;
    }

    public Date getNgayDat() {
        return ngayDat;
    }

    public void setNgayDat(Date ngayDat) {
        this.ngayDat = ngayDat;
    }

    public Date getNgayNhanPhong() {
        return ngayNhanPhong;
    }

    public void setNgayNhanPhong(Date ngayNhanPhong) {
        this.ngayNhanPhong = ngayNhanPhong;
    }

    public Date getNgayMuonTra() {
        return ngayMuonTra;
    }

    public void setNgayMuonTra(Date ngayMuonTra) {
        this.ngayMuonTra = ngayMuonTra;
    }

    public int getTamTinh() {
        return tamTinh;
    }

    public void setTamTinh(int tamTinh) {
        this.tamTinh = tamTinh;
    }

    public String getSoCMT() {
        return soCMT;
    }

    public void setSoCMT(String soCMT) {
        this.soCMT = soCMT;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public boolean isGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(boolean gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getQuocTich() {
        return quocTich;
    }

    public void setQuocTich(String quocTich) {
        this.quocTich = quocTich;
    }

    public int getMaPhong() {
        return maPhong;
    }

    public void setMaPhong(int maPhong) {
        this.maPhong = maPhong;
    }

    public String getTaiKhoanNV() {
        return taiKhoanNV;
    }

    public void setTaiKhoanNV(String taiKhoanNV) {
        this.taiKhoanNV = taiKhoanNV;
    }

}
