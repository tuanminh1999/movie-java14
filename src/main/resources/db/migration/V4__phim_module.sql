CREATE TABLE IF NOT EXISTS phim(
	id uuid,
	created_date timestamp,
	created_by varchar(36),
	modified_date timestamp,
	modified_by varchar(36),
	ten_phim varchar(255),
	bi_danh varchar(255),
	trailer varchar(255),
	hinh_anh varchar(255),
	mo_ta text,
	ngay_khoi_chieu timestamp,
	danh_gia int,
	primary key (id)
);

-- INSERT phim
INSERT INTO phim(id, created_date, created_by, modified_date, modified_by, ten_phim, bi_danh,
				 trailer, hinh_anh, mo_ta, ngay_khoi_chieu, danh_gia)
VALUES ('1994f049-2f47-4d34-a0fc-721f09cabb7a', null, '', null, '', 'Spider-Man: Homecoming', 'spider-man-homecoming',
		'https://www.youtube.com/watch?v=Pik8DPmrt2k', 'http://movie0706.cybersoft.edu.vn/hinhanh/nguoi-nhen_gp01.jpg',
		'là phim siêu anh hùng năm 2017 của Mỹ dựa trên nhân vật Peter Parker của truyện tranh Marvel. Bộ phim được sản xuất bởi Columbia Pictures và Marvel Studios, và được phân phối bởi Sony Pictures. Bộ phim có ý nghĩa khởi động lại dự án Spider-Man của Marvel sau nhiều năm nhượng quyền lại cho Sony Pictures. Bộ phim là bộ phim thứ 16 trong Vũ trụ điện ảnh Marvel (MCU).',
		null, 10);
