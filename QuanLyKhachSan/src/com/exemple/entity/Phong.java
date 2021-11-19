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
public class Phong {
    private int maPhong;
    private int soPhong;
    private int Lau;
    private String trangThai;
    private int maLoaiPhong;

    public Phong() {
    }

    public Phong(int maPhong, int soPhong, int Lau, String trangThai, int maLoaiPhong) {
        this.maPhong = maPhong;
        this.soPhong = soPhong;
        this.Lau = Lau;
        this.trangThai = trangThai;
        this.maLoaiPhong = maLoaiPhong;
    }

    public int getMaPhong() {
        return maPhong;
    }

    public void setMaPhong(int Phong) {
        this.maPhong = Phong;
    }

    public int getSoPhong() {
        return soPhong;
    }

    public void setSoPhong(int soPhong) {
        this.soPhong = soPhong;
    }

    public int getLau() {
        return Lau;
    }

    public void setLau(int Lau) {
        this.Lau = Lau;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public int getMaLoaiPhong() {
        return maLoaiPhong;
    }

    public void setMaLoaiPhong(int maLoaiPhong) {
        this.maLoaiPhong = maLoaiPhong;
    }
          @Override
     public String toString() {
        return this.trangThai;
    }
    
    
}
