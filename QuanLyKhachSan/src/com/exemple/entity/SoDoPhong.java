/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.exemple.entity;

/**
 *
 * @author Minh Triet
 */
public class SoDoPhong {

    private int soPhong;
    private String tenLoaiPhong;
    private String trangThai;
    public SoDoPhong() {
    }

    public SoDoPhong(int soPhong, String tenLoaiPhong, String trangThai) {
        this.soPhong = soPhong;
        this.tenLoaiPhong = tenLoaiPhong;
        this.trangThai = trangThai;
    }

    public int getSoPhong() {
        return soPhong;
    }

    public void setSoPhong(int soPhong) {
        this.soPhong = soPhong;
    }

    public String getTenLoaiPhong() {
        return tenLoaiPhong;
    }

    public void setTenLoaiPhong(String tenLoaiPhong) {
        this.tenLoaiPhong = tenLoaiPhong;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

}
