package cybersoft.javabackend.moviejava14.common.utils;

public class UrlConst {
	
	// LoaiNguoiDung
	public static final String GET_LOAI_NGUOI_DUNG = "/api/QuanLyLoaiNguoiDung/LayDanhSachLoaiNguoiDung";
	public static final String POST_LOAI_NGUOI_DUNG = "/api/QuanLyLoaiNguoiDung/ThemLoaiNguoiDung";
	public static final String PUT_LOAI_NGUOI_DUNG = "/api/QuanLyLoaiNguoiDung/CapNhatThongTinLoaiNguoiDung";
	public static final String DELETE_LOAI_NGUOI_DUNG = "/api/QuanLyLoaiNguoiDung/XoaLoaiNguoiDung";
	
	// NguoiDung
	public static final String GET_NGUOI_DUNG = "/api/QuanLyNguoiDung/LayDanhSachNguoiDung";
	public static final String POST_NGUOI_DUNG = "/api/QuanLyNguoiDung/ThemNguoiDung";
	public static final String REGISTER_NGUOI_DUNG = "/api/QuanLyNguoiDung/DangKy";
	public static final String LOGIN_NGUOI_DUNG = "api/QuanLyNguoiDung/DangNhap";
	public static final String PUT_NGUOI_DUNG = "/api/QuanLyNguoiDung/CapNhatThongTinNguoiDung";
	public static final String DELETE_NGUOI_DUNG = "/api/QuanLyNguoiDung/XoaNguoiDung";
	public static final String GET_NGUOI_DUNG_FROM_TAIKHOAN = "/api/QuanLyNguoiDung/ThongTinTaiKhoan";
	public static final String SEARCH_NGUOIDUNG = "/api/QuanLyNguoiDung/TimKiemNguoiDung";
	public static final String GET_NGUOIDUNG_PAGING = "/api/QuanLyNguoiDung/LayDanhSachNguoiDungPhanTrang";
	public static final String SEARCH_NGUOIDUNG_PAGING = "/api/QuanLyNguoiDung/TimKiemNguoiDungPhanTrang";
	
	// Rap
	public static final String GET_RAP = "/api/QuanLyRap/LayDanhSachRap";
	public static final String POST_RAP = "/api/QuanLyRap/ThemRap";
	public static final String PUT_RAP = "/api/QuanLyRap/CapNhatThongTinRap";
	public static final String DELETE_RAP = "/api/QuanLyRap/XoaRap";
	
	public static final String GET_THONG_TIN_LICH_CHIEU = "/api/QuanLyRap/LayThongTinLichChieuPhim";

	// CumRap
	public static final String GET_CUM_RAP = "/api/QuanLyCumRap/LayDanhSachCumRap";
	public static final String POST_CUM_RAP = "/api/QuanLyCumRap/ThemCumRap";
	public static final String PUT_CUM_RAP = "/api/QuanLyCumRap/CapNhatThongTinCumRap";
	public static final String DELETE_CUM_RAP = "/api/QuanLyCumRap/XoaCumRap";
	
	// HeThongRap
	public static final String GET_HT_RAP = "/api/QuanLyHeThongRap/LayDanhSachHeThongRap";
	public static final String POST_HT_RAP = "/api/QuanLyHeThongRap/ThemHeThongRap";
	public static final String PUT_HT_RAP = "/api/QuanLyHeThongRap/CapNhatThongTinHeThongRap";
	public static final String DELETE_HT_RAP = "/api/QuanLyHeThongRap/XoaHeThongRap";
	
	//Loai Ghe
	public static final String GET_LOAI_GHE = "/api/QuanLyLoaiGhe/LayDanhSachLoaiGhe";
	public static final String POST_LOAI_GHE = "/api/QuanLyLoaiGhe/ThemLoaiGhe";
	public static final String PUT_LOAI_GHE = "/api/QuanLyLoaiGhe/CapNhatThongTinLoaiGhe";
	public static final String DELETE_LOAI_GHE = "/api/QuanLyLoaiGhe/XoaLoaiGhe";
	
	//Phim
	public static final String GET_PHIM = "/api/QuanLyPhim/LayDanhSachPhim";
	public static final String POST_PHIM = "/api/QuanLyPhim/ThemPhim";
	public static final String POST_PHIM_UPLOAD_HINH = "/api/QuanLyPhim/ThemPhimUploadHinh";
	public static final String PUT_PHIM = "/api/QuanLyPhim/CapNhatPhim";
	public static final String DELETE_PHIM = "/api/QuanLyPhim/XoaPhim";
	public static final String GET_PHIM_PAGING = "/api/QuanLyPhim/LayDanhSachPhimPhanTrang";
	public static final String GET_PHIM_BY_DATE_PAGING = "/api/QuanLyPhim/LayDanhSachPhimTheoNgay";

	//Ghe
	public static final String GET_GHE = "/api/QuanLyLoaiGhe/LayDanhSachGhe";
	public static final String POST_GHE = "/api/QuanLyLoaiGhe/ThemGhe";
	public static final String PUT_GHE = "/api/QuanLyLoaiGhe/CapNhatThongTinGhe";
	public static final String DELETE_GHE = "/api/QuanLyLoaiGhe/XoaGhe";
	
	//Lich Chieu
	public static final String POST_LICH_CHIEU = "/api/QuanLyDatVe/TaoLichChieu";
	
}
