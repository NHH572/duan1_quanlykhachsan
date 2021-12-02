USE MASTER --CHUYỂN CSDL MẶC ĐỊNH VỀ MASTER
GO
IF DB_ID('QuanLyKhachSan') IS NOT NULL --KIỂM TRA CSDL CẦN TẠO ĐÃ TỒN TẠI CHƯA
	DROP DATABASE QuanLyKhachSan --XÓA CSDL
GO
CREATE DATABASE QuanLyKhachSan;
GO
USE QuanLyKhachSan;
GO

-- TẠO BẢNG
CREATE TABLE LoaiPhong
(
  MaLoaiPhong INT IDENTITY(1,1),
  TenLoaiPhong NVARCHAR(30),
  DonGiaTheoNgay INT,
  DonGiaTheoGio INT,
  GiaSauMotGio INT,
  MucTangCuoiTuan INT,
  MucTangNgayLe INT,
  MoTa NVARCHAR(50),
  PRIMARY KEY (MaLoaiPhong)
);

CREATE TABLE Phong
(
  MaPhong INT IDENTITY(1,1),
  SoPhong INT,
  Lau INT,
  TrangThai NVARCHAR(20),
  MaLoaiPhong INT,
  PRIMARY KEY (MaPhong),
  FOREIGN KEY (MaLoaiPhong) REFERENCES LoaiPhong(MaLoaiPhong)
);

CREATE TABLE NhanVien
(
  TaiKhoanNV VARCHAR(20),
  MatKhauNV VARCHAR(30),
  HoTen NVARCHAR(100),
  NgaySinh DATE,
  GioiTinh BIT,
  SoCMT VARCHAR(20),
  DiaChi NVARCHAR(255),
  SoDienThoai VARCHAR(15),
  VaiTro BIT,
  Hinh varchar(255),
  PRIMARY KEY (TaiKhoanNV)
);

CREATE TABLE DichVu
(
  MaDichVu INT IDENTITY(1,1),
  TenDichVu NVARCHAR(50),
  GiaDichVu FLOAT,
  MoTa NVARCHAR(255),
  PRIMARY KEY (MaDichVu)
);

CREATE TABLE DoiTac
(
  MaDoiTac varchar(10),
  TenDoiTac NVARCHAR(50),
  SoDienThoai NVARCHAR(15),
  DanhGiaKhachSan NVARCHAR(300),
  PRIMARY KEY (MaDoiTac)
);

CREATE TABLE KhachHang
(
  SoCMTKhachHang VARCHAR(20),
  TenKhachHang NVARCHAR(50),
  NgaySinh DATE,
  GioiTinh BIT,  
  SoDienThoai VARCHAR(15),
  Email NVARCHAR(30),
  QuocTich NVARCHAR(20),
  SoLanThue INT,
  MaDoiTac varchar(10),
  PRIMARY KEY (SoCMTKhachHang),
  FOREIGN KEY (MaDoiTac) REFERENCES DoiTac(MaDoiTac)
);

CREATE TABLE KhuyenMai
(
	MaKhuyenMai VARCHAR(10) PRIMARY KEY,
	TenKhuyenMai NVARCHAR(30),
	GiaTri INT,
	NgayBatDau DATE,
	NgayHetHan DATE
);

CREATE TABLE HoaDon
(
  MaHoaDon INT IDENTITY(1,1),
  NgayTao DATETIME,
  NgayNhanPhong DATETIME,
  NgayTraPhong DATETIME,
  ThanhTien FLOAT,
  TaiKhoanNV VARCHAR(20),
  SoCMTKhachHang VARCHAR(20),
  MaKhuyenMai VARCHAR(10),
  PRIMARY KEY (MaHoaDon),
  FOREIGN KEY (TaiKhoanNV) REFERENCES NhanVien(TaiKhoanNV),
  FOREIGN KEY (MaKhuyenMai) REFERENCES KhuyenMai(MaKhuyenMai),
  FOREIGN KEY (SoCMTKhachHang) REFERENCES KhachHang(SoCMTKhachHang)
);

CREATE TABLE ChiTietHoaDon
(
  MaChiTietHoaDon INT IDENTITY(1,1),
  MaPhong INT,
  MaHoaDon INT,
  MaDichVu INT,
  SoLanThueDichVu INT,
  TongTien FLOAT,  
  PRIMARY KEY (MaChiTietHoaDon),
  FOREIGN KEY (MaPhong) REFERENCES Phong(MaPhong),
  FOREIGN KEY (MaHoaDon) REFERENCES HoaDon(MaHoaDon),
  FOREIGN KEY (MaDichVu) REFERENCES DichVu(MaDichVu)
);

CREATE TABLE VatDung
(
  MaVatDung INT IDENTITY(1,1),
  TenVatDung NVARCHAR(50),
  SoLuongKho INT,
  DonViTinh NVARCHAR(20),
  PRIMARY KEY (MaVatDung)
);

CREATE TABLE DatPhong
(
  MaDatPhong INT IDENTITY(1,1),
  NgayDat DATETIME,
  NgayHetHan DATE,
  NgayTraPhong DATE,
  TamTinh FLOAT,
  MaPhong INT,
  SoCMTKhachHang VARCHAR(20),
  TaiKhoanNV VARCHAR(20),
  MaLoaiPhong INT,
  PRIMARY KEY (MaDatPhong),
  FOREIGN KEY (MaPhong) REFERENCES Phong(MaPhong),
  FOREIGN KEY (SoCMTKhachHang) REFERENCES KhachHang(SoCMTKhachHang),
  FOREIGN KEY (TaiKhoanNV) REFERENCES NhanVien(TaiKhoanNV),
  FOREIGN KEY (MaLoaiPhong) REFERENCES LoaiPhong(MaLoaiPhong)
);

CREATE TABLE ChiTietVatDung
(
  MaVatDung INT,
  MaPhong INT,
  SoLuong INT,
  PRIMARY KEY (MaVatDung, MaPhong),
  FOREIGN KEY (MaVatDung) REFERENCES VatDung(MaVatDung),
  FOREIGN KEY (MaPhong) REFERENCES Phong(MaPhong)
);
GO
-- Thêm dữ liệu
--Loại Phòng
	INSERT INTO LoaiPhong(TenLoaiPhong,DonGiaTheoNgay,DonGiaTheoGio,GiaSauMotGio,MucTangNgayLe,MucTangCuoiTuan,MoTa)
	VALUES (N'Phòng đơn',500000,150000, 20000, 20,30,null),
	(N'Phòng đơn VIP 1',600000,200000, 25000, 20,30,N'Có ban công'),
	(N'Phòng đơn VIP 2',700000,300000, 35000, 20,30,N'Có ban công, View đẹp'),
	(N'Phòng đôi',800000,350000, 30000, 20,30,null),
	(N'Phòng đôi VIP',900000,450000, 45000, 20,30,N'Có ban công, View đẹp')
-- Phòng	
	INSERT INTO Phong(SoPhong,Lau,TrangThai,MaLoaiPhong)
	VALUES (101,1,N'Trống',1),
	(102,1,N'Trống',1),
	(103,1,N'Đang thuê',1),
	(104,1,N'Trống',1),
	(105,1,N'Đang thuê',1),
	(106,1,N'Đang thuê',3),
	(201,2,N'Trống',2),
	(202,2,N'Trống',2),
	(203,2,N'Đang thuê',3),
	(204,2,N'Trống',3),
	(205,2,N'Đang thuê',1),
	(206,2,N'Trống',4),
	(301,3,N'Trống',1),
	(302,3,N'Đang thuê',4),
	(303,3,N'Trống',4),
	(304,3,N'Trống',5),
	(305,3,N'Đang thuê',5),
	(306,3,N'Đang thuê',1),
	(401,4,N'Trống',2),
	(402,4,N'Trống',2),
	(403,4,N'Đang thuê',3),
	(404,4,N'Trống',3),
	(405,4,N'Trống',1),
	(406,4,N'Trống',3),
	(501,5,N'Trống',5),
	(502,5,N'Đang thuê',5),
	(503,5,N'Trống',5),
	(504,5,N'Đang thuê',3),
	(505,5,N'Trống',3),
	(506,5,N'Trống',1),
	(601,5,N'Đang thuê',5),
	(602,5,N'Trống',2),
	(603,5,N'Đang thuê',5),
	(604,5,N'Trống',4),
	(605,5,N'Trống',3),
	(606,5,N'Trống',1)
-- NHÂN VIÊN
	INSERT INTO NhanVien(TaiKhoanNV,MatKhauNV,HoTen,NgaySinh,GioiTinh,SoCMT,DiaChi,SoDienThoai,VaiTro)
	VALUES ('admin','admin',N'Lê Văn Phụng','1972/10/10',0,'765666271',N'12 Thái Thị Nhạn, Q.Tân Bình, TP. HCM','0393796446',0),
	('pnmtriet','123456',N'Phạm Nguyễn Minh Triết','1999/08/22',0,'272123456',N'1 Hồng Lạc, Q.Tân Bình, TP. HCM','0393796446',1),
	('nhhai','123456',N'Nguyễn Hoàng Hải','2001/01/01',0,'546728901',N'1 Trưng Vương, Q.Cầu Giấy, Hà Nội','0976253623',1),
	('ddcuong','123456',N'Đàm Đình Cường','2001/02/02',0,'276155678',N'125 Đinh Tiên Hoàng, Q.1, TP. HCM','0976251334',1),
	('hvanh','123456',N'Hoàng Việt Anh','2002/11/11',0,'876766721',N'12 Hoàng Văn Thụ, Q.Tân Bình, TP. HCM','0987263456',1),
	('lhthuat','123456',N'Lê Hoàng Thuật','2002/10/10',0,'287277980',N'3 Điện Biên Phủ, Q.3, TP. HCM','0987263456',1),
	('pplong','123456',N'Lê Hoàng Thuật','2002/10/10',0,'287277980',N'54 CMT8, Q.10, TP. HCM','0987654356',1)
-- VẬT DỤNG
	INSERT INTO VatDung(TenVatDung,SoLuongKho,DonViTinh)
	VALUES (N'Bàn chải đánh răng',400,N'cái'),
	(N'Kem đánh răng',350,N'cái'),
	(N'Khăn tắm',250,N'cái'),
	(N'Lược',200,N'cái'),
	(N'Máy sấy tóc',400,N'cái'),
	(N'Móc treo quần áo',1000,N'cái')
-- CHI TIẾT VẬT DỤNG
	INSERT INTO ChiTietVatDung
	VALUES (1,1,2),(1,2,2),(1,3,2),(1,4,2),(1,5,4),
	(1,6,4),(1,7,4),(1,8,4),(1,9,4),(1,10,4),
		   (1,11,4),(1,12,4),(1,13,4),(1,14,4),(1,15,4),
		   (1,16,4),(1,17,4),(1,18,4),(1,19,4),(1,20,4),
		   (1,21,4),(1,22,4),(1,23,4),(1,24,4),(1,25,4),
		   (2,1,2),(2,2,2),(2,3,2),(2,4,2),(2,5,4),
	    (2,6,4),(2,7,4),(2,8,4),(2,9,4),(2,10,4),
		   (2,11,4),(2,12,4),(2,13,4),(2,14,4),(2,15,4),
		   (2,16,4),(2,17,4),(2,18,4),(2,19,4),(2,20,4),
		   (2,21,4),(2,22,4),(2,23,4),(2,24,4),(2,25,4),
		   (4,1,2),(4,2,2),(4,3,2),(4,4,2),(4,5,2),
	    (4,6,2),(4,7,2),(4,8,4),(4,9,4),(4,10,4),
		   (4,11,4),(4,12,4),(4,13,4),(4,14,4),(4,15,4),
		   (4,16,4),(4,17,2),(4,18,2),(4,19,4),(4,20,2),
		   (4,21,4),(4,22,4),(4,23,2),(4,24,4),(4,25,4)
-- Khuyến mãi
	INSERT INTO KhuyenMai(MaKhuyenMai,TenKhuyenMai,GiaTri,NgayBatDau,NgayHetHan)
	VALUES ('KHTT1',N'Khách hàng thân thiết 1',10,'2021/11/11','2021/12/12'),
	('KHTT2',N'Khách hàng thân thiết 2',20,'2021/11/01','2021/12/31'),
	('KHTT3',N'Khách hàng thân thiết 3',50,'2021/11/01','2021/12/31'),
	('LGS21',N'Lễ giáng sinh',10,'2021/12/01','2021/12/31'),
	('NONE',null,0,null,null)
-- Đối tác
	INSERT INTO DoiTac(MaDoiTac,TenDoiTac,SoDienThoai,DanhGiaKhachSan)
	VALUES ('CTTP',N'Công ty du lịch Trường Phát','0123555555',N'Chất lượng tốt, đầy đủ tiện nghi'),
	('CTTT',N'Công ty du lịch Trung Thành','0989999999',N'Nhân viên chuyên nghiệp, view đẹp, tiện nghi'),
	('CTPT',N'Công ty du lịch Phát Tài','0777777777',N'Chất lượng khỏi phải chê, tiện nghi quá đầy đủ')
-- Khách hàng
	INSERT INTO KhachHang(SoCMTKhachHang,TenKhachHang,NgaySinh,GioiTinh,SoDienThoai,Email,QuocTich,SoLanThue,MaDoiTac)
	VALUES ('272433567',N'Phạm Nguyễn Minh Triết','1990/09/09',0,'0987263232','pnmtriet@gmail.com',N'Việt Nam',null,null),
	('767265819',N'John Tom','1982/01/01',0,'0987654221','jtom@gmail.com',N'Singapore',null,'CTTP'),
	('124567893',N'Nguyễn Hoàng Hải','1989/11/11',0,'0765289765','nhh@gmail.com',N'Việt Nam',2,'CTTT')
-- Dịch Vụ
	INSERT INTO DichVu(TenDichVu,GiaDichVu,MoTa)
	VALUES (N'Giặt ủi',20000,N'Giá theo kg'),
	(N'Ăn 1 buổi',30000,N'Giá theo bữa ăn'),
	(N'Ăn 3 buổi',80000,N'Giá 3 buổi ăn'),
	(N'Spa',500000,N'Full combo'),
	(N'Xe đưa đón',100000,N'Đưa đón từ bến xe đến khách sạn 1 lần'),
	(N'Vận chuyển hành lý',30000,N'Vận chuyển hành lý cho khách lên phòng hoặc ra xe 1 lần')
-- Hóa đơn
	INSERT INTO HoaDon(NgayTao,NgayNhanPhong,NgayTraPhong,ThanhTien,TaiKhoanNV,SoCMTKhachHang,MaKhuyenMai)
	VALUES ('2021/11/07','2021/11/05','2021/11/07',1000000,'pnmtriet','124567893','KHTT2'),
	('2021/11/07','2021/11/05','2021/11/07',2000000,'pnmtriet','272433567','NONE')
-- Chi tiết hóa đơn
	INSERT INTO ChiTietHoaDon(MaHoaDon,MaDichVu,MaPhong,SoLanThueDichVu,TongTien)
	VALUES (1,3,1,1,80000), (1,4,1,1,500000), (1,6,1,1,30000),
	(2,5,5,2,200000), (2,2,5,3,90000), (2,1,5,2,40000)
-- Đặt phòng
GO
	INSERT INTO
	DatPhong(NgayDat,NgayHetHan,NgayTraPhong,TamTinh,MaPhong,SoCMTKhachHang,TaiKhoanNV,MaLoaiPhong)
	VALUES
	('2021/11/22','2021/11/25','2021/11/30',1000000,null,'767265819',null,2),
	('2021/11/22','2021/11/25','2021/11/30',1000000,null,'767265819',null,3),
	('2021/11/22','2021/11/25','2021/11/29',1000000,null,'767265819',null,4),
	('2021/11/22','2021/11/25','2021/11/28',1000000,null,'767265819',null,5),
	('2021/11/22','2021/11/25','2021/11/27',1000000,null,'767265819',null,1),
	('2021/11/22','2021/11/25','2021/11/30',1000000,3,'124567893','pnmtriet',1),
	('2021/11/22','2021/11/25','2021/11/30',1000000,5,'272433567','nhhai',1)
-- TẠO PROC
--1
IF OBJECT_ID('sp_DoanhThuHoaDon') is not null
DROP PROC sp_DoanhThuHoaDon
GO
CREATE PROC sp_DoanhThuHoaDon(@thangBatDau INT, @thangKetThuc INT)
AS BEGIN
	SELECT hd.MaHoaDon, kh.TenKhachHang, hd.NgayTao, km.GiaTri,hd.ThanhTien
	FROM HoaDon hd,KhuyenMai km,KhachHang kh
	WHERE hd.SoCMTKhachHang = kh.SoCMTKhachHang
	AND hd.MaKhuyenMai = km.MaKhuyenMai
	AND MONTH(hd.NgayTao) >= @thangBatDau
	AND MONTH(hd.NgayTao) <= @thangKetThuc
END
--2
IF OBJECT_ID('sp_SoLuongKhachHang') is not null
DROP PROC sp_SoLuongKhachHang
GO
CREATE PROC sp_SoLuongKhachHang(@thangBatDau INT, @thangKetThuc INT)
AS BEGIN
	SELECT kh.SoCMTKhachHang, kh.TenKhachHang, kh.NgaySinh,kh.GioiTinh,kh.QuocTich
	FROM KhachHang kh
	inner join HoaDon hd
	on kh.SoCMTKhachHang=hd.SoCMTKhachHang
	WHERE MONTH(hd.NgayTao) >= @thangBatDau
	AND MONTH(hd.NgayTao) <= @thangKetThuc
END
--3
IF OBJECT_ID('sp_DoanhThuTienPhong') is not null
DROP PROC sp_DoanhThuTienPhong
GO
CREATE PROC sp_DoanhThuTienPhong(@thangBatDau INT, @thangKetThuc INT)
AS BEGIN
	SELECT p.SoPhong, lp.TenLoaiPhong, count(cthd.MaHoaDon) as 'SoLanThue', sum(cthd.TongTien) as 'TongTien'
	FROM Phong p
	inner join LoaiPhong lp
	on p.MaPhong=lp.MaLoaiPhong
	inner join ChiTietHoaDon cthd
	on cthd.MaPhong=p.MaPhong
	inner join HoaDon hd
	on hd.MaHoaDon=cthd.MaHoaDon	
	WHERE MONTH(hd.NgayTao) >= @thangBatDau
	AND MONTH(hd.NgayTao) <= @thangKetThuc
	GROUP BY p.SoPhong, lp.TenLoaiPhong
END
--4
IF OBJECT_ID('sp_DoanhThuDichVu') is not null
DROP PROC sp_DoanhThuDichVu
GO
CREATE PROC sp_DoanhThuDichVu(@thangBatDau INT, @thangKetThuc INT)
AS BEGIN
	SELECT dv.TenDichVu, kh.TenKhachHang,hd.TaiKhoanNV, hd.NgayTao, cthd.SoLanThueDichVu, dv.GiaDichVu
	FROM DichVu dv
	inner join ChiTietHoaDon cthd
	on cthd.MaDichVu=dv.MaDichVu
	inner join HoaDon hd
	on hd.MaHoaDon=cthd.MaHoaDon
	inner join KhachHang kh
	on hd.SoCMTKhachHang=kh.SoCMTKhachHang
	WHERE MONTH(hd.NgayTao) >= @thangBatDau
	AND MONTH(hd.NgayTao) <= @thangKetThuc
END
select * from HoaDon;
select * from ChiTietHoaDon;
update HoaDon set ThanhTien = '123' where MaKhuyenMai ='khtt2' 
