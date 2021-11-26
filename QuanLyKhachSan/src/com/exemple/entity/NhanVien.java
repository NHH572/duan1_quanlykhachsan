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
public class NhanVien {
    private String maNV;
    private String matKhau;
    private String hoTen;
    private Date ngaySinh;
    private boolean gioiTinh;
    private String CMND_CCCD;
    private String diaChi;
    private String soDienThoai;
    private boolean vaiTro;
    private String hinh;

    public NhanVien() {
    }

    public NhanVien(String maNV, String matKhau, String hoTen, Date ngaySinh, boolean gioiTinh, String CMND_CCCD, String diaChi, String soDienThoai, boolean vaiTro, String hinh) {
        this.maNV = maNV;
        this.matKhau = matKhau;
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
        this.gioiTinh = gioiTinh;
        this.CMND_CCCD = CMND_CCCD;
        this.diaChi = diaChi;
        this.soDienThoai = soDienThoai;
        this.vaiTro = vaiTro;
        this.hinh = hinh;
    }

    public String getTenVaiTro(){
        if(isVaiTro()){
            return "Nhân viên";
        }else{
            return "Quản lý";
        }
    }

    public String getHinh() {
        return hinh;
    }

    public void setHinh(String hinh) {
        this.hinh = hinh;
    }

    

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public boolean isGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(boolean gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getCMND_CCCD() {
        return CMND_CCCD;
    }

    public void setCMND_CCCD(String CMND_CCCD) {
        this.CMND_CCCD = CMND_CCCD;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public boolean isVaiTro() {
        return vaiTro;
    }

    public void setVaiTro(boolean vaiTro) {
        this.vaiTro = vaiTro;
    }
    
    
}
