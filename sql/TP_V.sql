use master;
create database Triple_V1;
-- tạo bảng sản phẩm
use Triple_V1;
create table SanPham (
	MaSP varchar(10) primary key not null,
	TenSP nvarchar(50) not null,
	MaDM varchar(10) not null,
	MaNSX varchar(10) not null,
	DonGia money not null,
	TrangThai int not null

);

insert into SanPham
values('SP001',N'Aó Thể Thao MU','G0001','A0001',150000,1),
('SP002',N'Áo bộ Thể Thao','G0002','B0001',120000,1),
('SP003',N'Aó bộ đẹp Thời trang','G0003','C0001',135000,1),
('SP004',N'Aó Thể Thao MC','G0004','D0001',150000,1),
('SP005',N'Áo bộ Bóng rổ','G0005','E0001',140000,0),
('SP006',N'Aó Thể thao Arsenal','G0006','F0001',160000,1),
('SP007',N'Aó Thể Thao Hà Nội FC','G0007','G0001',120000,0),
('SP008',N'Áo Thể Thao Chelsea','G0008','H0001',1200000,0),
('SP009',N'Áo Thể Thao Liverpool','G0009','L0001',1350000,1),
('SP0010',N'Aó Thể Thao Newcastle','G00010','M0001',1250000,1);

-- tạo bảng danh mục
create table DanhMuc(
	MaDM varchar(10) primary key not null,
	TenDM nvarchar(30) not null
);
insert into DanhMuc
values ('G0001',N'Áo Câu Lạc Bộ'),
('G0002',N'Aó Thể Thao Bộ'),
('G0003',N'Aó Thể Thao Thời Trang '),
('G0004',N'Áo Câu Lạc Bộ'),
('G0005',N'Áo Câu Lạc Bộ'),
('G0006',N'Áo Câu Lạc Bộ'),
('G0007',N'Áo Câu Lạc Bộ'),
('G0008',N'Áo Câu Lạc Bộ'),
('G0009',N'Áo Câu Lạc Bộ'),
('G00010',N'Áo Câu Lạc Bộ')
;

-- Tạo bảng màu sắc
create table MauSac (
	STT INT IDENTITY(1,1) primary key not null,
	TenMS nvarchar(30) not null
);
insert into MauSac (TenMS)
values (N'Đỏ Đen '),
(N'Xám '),
(N'Đen '),
(N'Xanh da trời '),
(N'Vàng Đen '),
(N'Đỏ Trắng '),
(N'Xanh Đen'),
(N'Xanh  '),
(N'Đỏ '),
(N'Đen trắng ');

--Tạo bảng Chất liệu
create table ChatLieu(
	STT INT IDENTITY(1,1) primary key not null,
	TenCL nvarchar(30) not null
);
insert into ChatLieu(TenCL)
values (N'Cotton'),
(N'Thun');

-- Tạo bảng nhà sản xuất
create table NhaSanXuat(
	MaNSX varchar(10) primary key not null,
	NSX nvarchar(20) not null
);

insert into NhaSanXuat
values ('A0001',N'Nike'),
('B0001',N'Adidas'),
('C0001',N'Adidas'),
('D0001',N'Nike'),
('E0001',N'Nike'),
('F0001',N'Nike'),
('G0001',N'Nike'),
('H0001',N'Nike'),
('L0001',N'Nike'),
('M0001',N'Nike')
;
-- tạo bảng chi tiết sản phẩm
create table ChiTietSanPham(
	MaCTSP varchar(10) primary key not null,
	MaSP varchar(10) not null,
	TenSP nvarchar(50) not null,
	ChatLieu nvarchar(20) not null,
	KichThuoc varchar(2) not null,
	Mau nvarchar(30) not null,
	SoLuong int,
	NhaSX nvarchar(20) not null,
	XuatXu nvarchar(30) not null,
	MoTa nvarchar(999) not null
);

insert into ChiTietSanPham
values ('CTSP001','SP001',N'Aó Thể Thao MU',N'Cotton','32',N'Đỏ Đen',25,N'Nike',N'Anh',N'Aó Thể Thao MU là một sản phẩm áo bóng đá phổ biến tại Việt Nam. Aó được làm từ chất liệu cotton cao cấp, bền bỉ, mang lại cảm giác thoải mái cho người sử dụng.'),
('CTSP002','SP002',N'Áo bộ Thể Thao',N'Thun','33',N'Xám',21,N'Adidas',N'Mỹ',N'Áo bộ Thể Thao là một sản phẩm Quần Aó nổi tiếng trên toàn thế giới. Quần Aó được làm từ chất liệu vải Thun cao cấp, bền bỉ, thoáng khí.Aó có thiết kế đơn giản, trẻ trung, năng động, phù hợp với mọi lứa tuổi.'),
('CTSP003','SP003',N'Aó bộ đẹp Thời Trang',N'Thun','34',N'Đen',12,N'Adidas',N'Hàn Quốc',N'Aó bộ đẹp là một kiểu áo kinh điển, sang trọng, thường được sử dụng trong các dịp trang trọng. Aó có thiết kế đơn giản, trẻ trung, năng động, phù hợp với mọi lứa tuổi.'),
('CTSP004','SP004',N'Aó Thể Thao MC',N'Cotton','32',N'Xanh da trời',25,N'Nike',N'Anh',N'Aó Thể Thao MU là một sản phẩm áo bóng đá phổ biến tại Việt Nam. Aó được làm từ chất liệu cotton cao cấp, bền bỉ, mang lại cảm giác thoải mái cho người sử dụng.'),
('CTSP005','SP005',N'Aó bộ Bóng rổ',N'Cotton','35',N'Vàng Đen',25,N'Nike',N'Anh',N'Aó Thể Thao MU là một sản phẩm áo bóng đá phổ biến tại Việt Nam. Aó được làm từ chất liệu cotton cao cấp, bền bỉ, mang lại cảm giác thoải mái cho người sử dụng.'),
('CTSP006','SP006',N'Aó Thể Thao Arsenal',N'Cotton','33',N'Đỏ Trắng',25,N'Nike',N'Anh',N'Aó Thể Thao MU là một sản phẩm áo bóng đá phổ biến tại Việt Nam. Aó được làm từ chất liệu cotton cao cấp, bền bỉ, mang lại cảm giác thoải mái cho người sử dụng.'),
('CTSP007','SP007',N'Aó Thể Thao Hà Nội FC',N'Cotton','30',N'Xanh Đen',25,N'Nike',N'Anh',N'Aó Thể Thao MU là một sản phẩm áo bóng đá phổ biến tại Việt Nam. Aó được làm từ chất liệu cotton cao cấp, bền bỉ, mang lại cảm giác thoải mái cho người sử dụng.'),
('CTSP008','SP008',N'Aó Thể Thao Chelsea',N'Cotton','34',N'Xanh',25,N'Nike',N'Anh',N'Aó Thể Thao MU là một sản phẩm áo bóng đá phổ biến tại Việt Nam. Aó được làm từ chất liệu cotton cao cấp, bền bỉ, mang lại cảm giác thoải mái cho người sử dụng.'),
('CTSP009','SP009',N'Aó Thể Thao Liverpool',N'Cotton','33',N'Đỏ',25,N'Nike',N'Anh',N'Aó Thể Thao MU là một sản phẩm áo bóng đá phổ biến tại Việt Nam. Aó được làm từ chất liệu cotton cao cấp, bền bỉ, mang lại cảm giác thoải mái cho người sử dụng.'),
('CTSP0010','SP0010',N'Aó Thể Thao Newcastle',N'Cotton','32',N'Đen trắng',25,N'Nike',N'Anh',N'Aó Thể Thao MU là một sản phẩm áo bóng đá phổ biến tại Việt Nam. Aó được làm từ chất liệu cotton cao cấp, bền bỉ, mang lại cảm giác thoải mái cho người sử dụng.');
-- xét ràng buộc giữa 3 bảng trên
ALTER TABLE SanPham
ADD CONSTRAINT fk_madm FOREIGN KEY (MaDM) REFERENCES DanhMuc(MaDM);
ALTER TABLE SanPham
ADD CONSTRAINT fk_mansx FOREIGN KEY (MaNSX) REFERENCES NhaSanXuat(MaNSX);
ALTER TABLE ChiTietSanPham
ADD CONSTRAINT fk_maspspct FOREIGN KEY (MaSP) REFERENCES SanPham(MaSP);

-- Tạo bảng nhân viên
create table NhanVien(
	MaNV varchar(10) primary key not null,
	TenNV nvarchar(42) not null,
	SDT varchar(10) not null,
	Email varchar(50) not null,
	GioiTinh nvarchar(3) not null,
	ChucVu nvarchar(20) not null,
	LuongCB money not null,
	DiaChi nvarchar(225) not null,
	TrangThai nvarchar(40) not null,
	TKNV varchar(10) not null
);
insert into NhanVien
values ('NV001',N'Phạm Văn Lưu','0912345678','Luupvph39811@fpt.edu.vn',N'Nam',N'Quản lý',15000000,N'Số 10, ngõ 82, Đường Di Ái- Di Trạch-Hoài Đức, Hà Nội',N'Đang làm việc','admin'),
('NV002',N'Nguyễn Thị Thu Huyền','0934567812','Huyennttph39598@fpt.edu.vn',N'Nữ',N'Nhân viên',8000000,N'Số 17, ngõ 178, Đường Hồ Tùng Mậu, Hà Nội',N'Đang làm việc','NV002'),
('NV003',N'Nguyễn Đức Việt','0819472536','Vietndph39784@fpt.edu.vn',N'Nam',N'Nhân viên',8500000,N'Số 47, ngõ 63, Đường Di Ái- Di Trạch-Hoài Đức, Hà Nội',N'Đang làm việc','NV003'),
('NV004',N'Phạm Ngọc Thắng','0948653145','Thangpnph39814@fpt.edu.vn',N'Nam',N'Nhân viên',8000000,N'Số 28, ngõ 75, Đường Châu Văn Liêm, Hà Nội',N'Đang làm việc','NV004'),
('NV005',N'Hà Nguyễn Minh Thành','0125698742','Thanhhnmph39897@fpt.edu.vn',N'Nam',N'Nhân viên',8500000,N'Số 75, ngõ 16, Đường Hoàng Văn Thụ, Hà Nội',N'Đang làm việc','NV005');

-- tạo bảng tài khoản
create table TaiKhoan (
	TKNV varchar(10) primary key not null,
	TenNV_SuDung nvarchar(42) not null,
	MatKhau varchar(20) not null,
	VaiTro bit not null
);
insert into TaiKhoan
values ('admin',N'Phạm Văn Lưu','admin123', 0),
('NV002',N'Nguyễn Thị Thu Huyền','admin123', 1),
('NV003',N'Nguyễn Đức Việt','admin123', 1),
('NV004',N'Phạm Ngọc Thắng','admin123', 1),
('NV005',N'Hà Nguyễn Minh Thành','admin123', 1);

ALTER TABLE NhanVien
ADD CONSTRAINT fk_tkNV FOREIGN KEY (TKNV) REFERENCES TaiKhoan(TKNV);


-- tạo bảng khuyến mãi

create table KhuyenMai(
	MaKM varchar(10) primary key not null,
	TenKM nvarchar(50) not null,
	DieuKien nvarchar(200) not null,
	NgayBatDau date not null,
	NgayKetThuc date not null,
	MucKhuyenMai varchar(10) not null,
	MoTa nvarchar(999),
	MaSP varchar(10),
);
ALTER TABLE KhuyenMai
ADD CONSTRAINT fk_km FOREIGN KEY (MaSP) REFERENCES SanPham(MaSP);
insert into KhuyenMai
values ('KM001',N'Mùa hè xanh',N'Vip','06/01/2023','06/26/2023','10%',N'Không có mô tả','SP001'),
('KM002',N'Ngày vàng',N'Đặc biệt','05/05/2023','05/05/2023','10%',N'Không có mô tả','SP002'),
('KM003',N'Mùa đông lạnh giá',N'Bình thường','11/25/2023','12/20/2023','15%',N'Không có mô tả','SP003'),
('KM004',N'Ngày đặc biệt',N'Bình thường','07/27/2023','07/27/2023','20%',N'Không có mô tả','SP003'),
('KM005',N'Black Friday',N'Bình thường','10/25/2023','10/30/2023','25%',N'Không có mô tả','SP002'),
('KM006',N'Solomon',N'Bình thường','06/25/2023','06/30/2023','20%',N'Không có mô tả','SP001'),
('KM007',N'Quốc tế lao động',N'Bình thường','04/25/2023','05/03/2023','20%',N'Không có mô tả','SP002');

-- Tạo bảng Khách hàng

create table KhachHang(
	MaKH varchar(10) primary key not null,
	HoTen nvarchar(42) not null,
	GioiTinh bit not null,
	SoDienThoai nvarchar(15) not null,
	Email varchar(50) not null,
	LoaiKH bit not null,
	TongChiTieu money not null
);
insert into KhachHang
values ('KH001',N'Nguyễn Hoàng Khánh Ly',1, '0123456789','lynhkph39452@fpt.edu.vn',0,20000000),
('KH002',N'Trần Anh Quân',0,'0111111111','quantaph40125@fpt.edu.vn',0,17000000),
('KH003',N'Phạm Ngọc Hải',0,'0122222222','haipnph40025@fpt.edu.vn',0,17200000),
('KH004',N'Nguyễn Quang Dự',0,'0123333333','dunqph40985@fpt.edu.vn',1,6500000),
('KH005',N'Trần Tuấn Anh',0,'0123444444','anhttph40022@fpt.edu.vn',1,7000000);

-- tạo bảng Hóa Đơn

create table HoaDon (
	MaHD varchar(10) primary key not null,
	MaKH varchar(10) ,
	NgayTao date not null,
	TongTien money not null
);
insert Into HoaDon
values ('HD001','','10/25/2023',2550000 ),
('HD002','','10/11/2023',2700000 ),
('HD003','','10/30/2023',1350000 );
-- Tạo bảng hóa đơn chi tiết
create table HoaDonCT (
	MaHDCT varchar(10) primary key not null,
	MaHD varchar(10) not null,
	TenKH nvarchar(42) not null ,
	MaSP varchar(10) not null,
	TenSP nvarchar(50) not null,
	DonGia money not null,
	SoLuong int not null,
	GhiChu nvarchar(999)
);
insert into HoaDonCT
values ('CT001','HD001',N'Khách mua lẻ','SP002',N'Aó Thể Thao MU',1500000,1,N'Không có ghi chú'),
('CT002','HD001',N'Khách mua lẻ','SP003',N'Áo bộ Thể Thao',1350000,1,N'Không có ghi chú'),
('CT003','HD002',N'Khách mua lẻ','SP001',N'Aó bộ đẹp',1500000,1,N'Không có ghi chú'),
('CT004','HD002',N'Khách mua lẻ','SP002',N'Áo bộ Thể Thao',1200000,1,N'Không có ghi chú'),
('CT005','HD003',N'Khách mua lẻ','SP003',N'Aó Thể Thao MU',1350000,1,N'Không có ghi chú')


--xét ràng buộc các bảng Hóa đơn, Hóa đơn chi tiết, sản phẩm
ALTER TABLE HoaDonCT
ADD CONSTRAINT fk_maHD FOREIGN KEY (MaHD) REFERENCES HoaDon(MaHD);
ALTER TABLE HoaDonCT
ADD CONSTRAINT fk_maSP FOREIGN KEY (MaSP) REFERENCES SanPham(MaSP);

