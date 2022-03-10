package cybersoft.javabackend.moviejava14.common.utils;

public class UrlConst {
	
	// LoaiNguoiDung
	public static final String GET_LOAI_NGUOI_DUNG = "/api/QuanLyLoaiNguoiDung/LayDanhSachLoaiNguoiDung";
	public static final String POST_LOAI_NGUOI_DUNG = "/api/QuanLyLoaiNguoiDung/ThemLoaiNguoiDung";
	public static final String PUT_LOAI_NGUOI_DUNG = "/api/QuanLyLoaiNguoiDung/CapNhatThongTinLoaiNguoiDung";
	public static final String DELETE_LOAI_NGUOI_DUNG = "/api//QuanLyLoaiNguoiDung/XoaLoaiNguoiDung";
	
	// NguoiDung
	public static final String GET_NGUOI_DUNG = "/api/QuanLyNguoiDung/LayDanhSachNguoiDung";
	public static final String POST_NGUOI_DUNG = "/api/QuanLyNguoiDung/ThemNguoiDung";
	public static final String REGISTER_NGUOI_DUNG = "/api/QuanLyNguoiDung/DangKy";
	public static final String LOGIN_NGUOI_DUNG = "api/QuanLyNguoiDung/DangNhap";
	public static final String PUT_NGUOI_DUNG = "/api/QuanLyNguoiDung/CapNhatThongTinNguoiDung";
	public static final String DELETE_NGUOI_DUNG = "/api/QuanLyNguoiDung/XoaNguoiDung";
	
	// CumRap
	public static final String GET_CUM_RAP = "/api/cum-rap";
	public static final String POST_CUM_RAP = "/api/cum-rap";
	public static final String PUT_CUM_RAP = "/api/cum-rap/{id}";
	public static final String DELETE_CUM_RAP = "/api/cum-rap/{id}";
	
	//Loai Ghe
	public static final String GET_LOAI_GHE = "/api/loai-ghe";
	public static final String POST_LOAI_GHE = "/api/loai-ghe";
	public static final String PUT_LOAI_GHE = "/api/loai-ghe/{id}";
	public static final String DELETE_LOAI_GHE = "/api/loai-ghe/{id}";
}
