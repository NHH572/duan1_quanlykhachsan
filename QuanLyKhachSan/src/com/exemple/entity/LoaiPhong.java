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
public class LoaiPhong {
    private int maLoaiPhong;
    private String tenLoaiPhong;
    private int donGiaTheoNgay;
    private int donGiaTheoGio;
    private int giaSauMotGio;
    private int mucTangCuoiTuan;
    private int mucTangNgayLe;
    private String moTa;

    public LoaiPhong() {
    }

    public LoaiPhong(int maLoaiPhong, String tenLoaiPhong, int donGiaTheoNgay, int donGiaTheoGio, int giaSauMotGio, int mucTangCuoiTuan, int mucTangNgayLe, String moTa) {
        this.maLoaiPhong = maLoaiPhong;
        this.tenLoaiPhong = tenLoaiPhong;
        this.donGiaTheoNgay = donGiaTheoNgay;
        this.donGiaTheoGio = donGiaTheoGio;
        this.giaSauMotGio = giaSauMotGio;
        this.mucTangCuoiTuan = mucTangCuoiTuan;
        this.mucTangNgayLe = mucTangNgayLe;
        this.moTa = moTa;
    }

    public int getMaLoaiPhong() {
        return maLoaiPhong;
    }

    public void setMaLoaiPhong(int maLoaiPhong) {
        this.maLoaiPhong = maLoaiPhong;
    }

    public String getTenLoaiPhong() {
        return tenLoaiPhong;
    }

    public void setTenLoaiPhong(String tenLoaiPhong) {
        this.tenLoaiPhong = tenLoaiPhong;
    }

    public int getDonGiaTheoNgay() {
        return donGiaTheoNgay;
    }

    public void setDonGiaTheoNgay(int donGiaTheoNgay) {
        this.donGiaTheoNgay = donGiaTheoNgay;
    }

    public int getDonGiaTheoGio() {
        return donGiaTheoGio;
    }

    public void setDonGiaTheoGio(int donGiaTheoGio) {
        this.donGiaTheoGio = donGiaTheoGio;
    }

    public int getGiaSauMotGio() {
        return giaSauMotGio;
    }

    public void setGiaSauMotGio(int giaSauMotGio) {
        this.giaSauMotGio = giaSauMotGio;
    }

    public int getMucTangCuoiTuan() {
        return mucTangCuoiTuan;
    }

    public void setMucTangCuoiTuan(int mucTangCuoiTuan) {
        this.mucTangCuoiTuan = mucTangCuoiTuan;
    }

    public int getMucTangNgayLe() {
        return mucTangNgayLe;
    }

    public void setMucTangNgayLe(int mucTangNgayLe) {
        this.mucTangNgayLe = mucTangNgayLe;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    
    
}
