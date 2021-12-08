/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.exemple.controller;

import com.exemple.helper.JdbcHelper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Sieu Nhan Bay
 */
public class thongKeDAO {

    /*
    thống kê số người học của trung tâm theo từng năm
    return 1 <Object[]> list : Năm - số lượng - ngày người đầu tiên đk - ngày người cc đk
     */
    public List<Object[]> getNguoiHoc() {
        String sql = "{CALL sp_ThongKeNguoiHoc}";
        String[] cols = {"Nam","SoLuong","DauTien","CuoiCung"};
        return this.getListOfArray(sql,cols);
    }

    /*
    bảng điểm của các học viên trong khóa học
    @param makh mã khóa học
    @return <Object[]> list : mã NH - họ và tên - điểm - xếp loại
     */
    public List<Object[]> getBangDiem(Integer makh) {
        String sql = "{CALL sp_BangDiem(?)}";
        String[] cols = {"MaNH","HoTen","Diem"};
        return this.getListOfArray(sql, cols, makh);
    }

    /*
    tổng hợp điểm của theo từng chuyên đề
    @return <Object[]> list : tên chuyên đề - số HV - điểm thấp nhất - điểm cao nhất - điểm trung bình
     */
    public List<Object[]> getDiemTheoChuyenDe() {
        String sql = "{CALL sp_ThongKeDiem}";
        String[] cols = {"ChuyenDe","SoHocVien","ThapNhat","CaoNhat","TB"};
        return this.getListOfArray(sql,cols);
    }

    /*
    tổng hợp doanh thu từng chuyên đề (theo từng năm)
    @param int nam
    @return <Object[]> list : tên chuyên đề - số KH - số HV - doanh thu - HP cao nhất - HP thấp nhất - HP trung bình
     */
    public List<Object[]> getDoanhThuHoaDon(int nam_bd,int nam_kt) {
        String sql = "{CALL sp_DoanhThuHoaDon(?,?)}";
        String[] cols = {"MaHoaDon","TenKhachHang","NgayTao","GiaTri","ThanhTien"};
        return this.getListOfArray(sql,cols,nam_bd,nam_kt);
    }
    public List<Object[]> getSLKH(int nam_bd,int nam_kt) {
        String sql = "{CALL sp_SoLuongKhachHang(?,?)}";
        String[] cols = {"SoCMTKhachHang","TenKhachHang","NgaySinh","GioiTinh","QuocTich"};
        return this.getListOfArray(sql,cols,nam_bd,nam_kt);
    }
    public List<Object[]> getDoanhThuTienPhong(int nam_bd,int nam_kt) {
        String sql = "{CALL sp_DoanhThuTienPhong(?,?)}";
        String[] cols = {"SoPhong","TenLoaiPhong","SoLanThue","TongTien"};
        return this.getListOfArray(sql,cols,nam_bd,nam_kt);
    }
    public List<Object[]> getDoanhThuDichVu(int nam_bd,int nam_kt) {
        String sql = "{CALL sp_DoanhThuDichVu(?,?)}";
        String[] cols = {"TenDichVu","TenKhachHang","TaiKhoanNV","NgayTao","SoLanThueDichVu","GiaDichVu"};
        return this.getListOfArray(sql,cols,nam_bd,nam_kt);
    }
//    public List<Integer> getNamKhaiGiang() {
//        List<Integer> list = new ArrayList<>();
//        try {
//            ResultSet rs = null;
//            try {
//                rs = jdbcHelper.executeQuery("select distinct year(NgayKG) as nam from KhoaHoc order by year(NgayKG) desc");
//                while (rs.next()) {
//                    int nam = rs.getInt(1);
//                    list.add(nam);
//                }
//            }finally{
//                rs.getStatement().getConnection().close();
//            }
//        } catch (SQLException ex) {
//            throw new RuntimeException(ex);
//        }
//        return list;
//    }
    public List<Integer> selectYear() {
        String sql = "SELECT DISTINCT month(Ngaytao) as Thang FROM HoaDon ORDER BY Thang ";
        List<Integer> list = new ArrayList<>();
        try {
            ResultSet rs = JdbcHelper.executeQuery(sql);
            while (rs.next()) {
                list.add(rs.getInt(1));
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
    private List<Object[]> getListOfArray(String sql,String[] cols, Object...args){
        try {
            List<Object[]> list = new ArrayList<>();
        ResultSet rs = JdbcHelper.executeQuery(sql, args);
        while (rs.next()) {            
            Object[] vals =new Object[cols.length];
            for (int i = 0; i < cols.length; i++) {
                vals[i] = rs.getObject(cols[i]);
            }
            list.add(vals);
        }
        rs.getStatement().getConnection().close();
        return list;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
            
        }
    }
}
