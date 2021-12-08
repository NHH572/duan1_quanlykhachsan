/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.exemple.controller;

import com.exemple.entity.Thongke;
import com.exemple.helper.JdbcHelper;
import static com.exemple.helper.JdbcHelper.con;
import static com.exemple.helper.JdbcHelper.dburl;
import static com.exemple.helper.JdbcHelper.password;
import static com.exemple.helper.JdbcHelper.username;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
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
        String[] cols = {"Nam", "SoLuong", "DauTien", "CuoiCung"};
        return this.getListOfArray(sql, cols);
    }

    /*
    bảng điểm của các học viên trong khóa học
    @param makh mã khóa học
    @return <Object[]> list : mã NH - họ và tên - điểm - xếp loại
     */
    public List<Object[]> getBangDiem(Integer makh) {
        String sql = "{CALL sp_BangDiem(?)}";
        String[] cols = {"MaNH", "HoTen", "Diem"};
        return this.getListOfArray(sql, cols, makh);
    }

    /*
    tổng hợp điểm của theo từng chuyên đề
    @return <Object[]> list : tên chuyên đề - số HV - điểm thấp nhất - điểm cao nhất - điểm trung bình
     */
    public List<Object[]> getDiemTheoChuyenDe() {
        String sql = "{CALL sp_ThongKeDiem}";
        String[] cols = {"ChuyenDe", "SoHocVien", "ThapNhat", "CaoNhat", "TB"};
        return this.getListOfArray(sql, cols);
    }

    /*
    tổng hợp doanh thu từng chuyên đề (theo từng năm)
    @param int nam
    @return <Object[]> list : tên chuyên đề - số KH - số HV - doanh thu - HP cao nhất - HP thấp nhất - HP trung bình
     */
    public List<Object[]> getDoanhThuHoaDon(int thang_bd, int thang_kt, int nam) {
        String sql = "{CALL sp_DoanhThuHoaDon(?,?,?)}";
        String[] cols = {"MaHoaDon", "TenKhachHang", "NgayTao", "GiaTri", "ThanhTien"};
        return this.getListOfArray(sql, cols, thang_bd, thang_kt, nam);
    }

    public List<Object[]> getSLKH(int thang_bd, int thang_kt, int nam) {
        String sql = "{CALL sp_SoLuongKhachHang(?,?,?)}";
        String[] cols = {"SoCMTKhachHang", "TenKhachHang", "NgaySinh", "NgayTao", "GioiTinh", "QuocTich"};
        return this.getListOfArray(sql, cols, thang_bd, thang_kt, nam);
    }

    public List<Object[]> getDoanhThuTienPhong(int thang_bd, int thang_kt, int nam) {
        String sql = "{CALL sp_DoanhThuTienPhong(?,?,?)}";
        String[] cols = {"SoPhong", "TenLoaiPhong", "SoLanThue", "TongTien", "NgayTao"};
        return this.getListOfArray(sql, cols, thang_bd, thang_kt, nam);
    }

    public List<Object[]> getDoanhThuDichVu(int thang_bd, int thang_kt, int nam) {
        String sql = "{CALL sp_DoanhThuDichVu(?,?,?)}";
        String[] cols = {"TenDichVu", "TenKhachHang", "TaiKhoanNV", "NgayTao", "SoLanThueDichVu", "GiaDichVu"};
        return this.getListOfArray(sql, cols, thang_bd, thang_kt, nam);
    }

    public List<Integer> selectYear() {
        String sql = "SELECT DISTINCT Year(Ngaytao) as Thang FROM HoaDon ORDER BY Thang desc ";
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

    private List<Object[]> getListOfArray(String sql, String[] cols, Object... args) {
        try {
            List<Object[]> list = new ArrayList<>();
            ResultSet rs = JdbcHelper.executeQuery(sql, args);
            while (rs.next()) {
                Object[] vals = new Object[cols.length];
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

    public List<Thongke> getDTHT(int nam) throws SQLException {
        JdbcHelper.con = DriverManager.getConnection(dburl, username, password);
        String sql = "SELECT Month(ngaytao) as thang, COUNT(*) as so_luong FROM HoaDon where Year(ngaytao) = ? GROUP BY ngaytao";
        List<Thongke> list = new ArrayList<>();
        try {
            PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
            ps.setInt(1, nam);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Thongke tk = new Thongke();
                tk.setThang_dang_ky(rs.getString("thang"));
                tk.setSo_luong_khach_hang(rs.getInt("so_luong"));
                list.add(tk);
            }
            ps.close();
            con.close();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    

}
