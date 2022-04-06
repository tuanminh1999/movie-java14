CREATE TABLE IF NOT EXISTS phim(
	id serial,
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
INSERT INTO phim(created_date, created_by, modified_date, modified_by, ten_phim, bi_danh,
				 trailer, hinh_anh, mo_ta, ngay_khoi_chieu, danh_gia)
VALUES (null, '', null, '', 'Spider-Man', 'spider-man',
		'https://www.youtube.com/watch?v=Pik8DPmrt2k', 'https://movie0706.cybersoft.edu.vn/hinhanh/aquamannnnnn_gp09.png',
		'là phim siêu anh hùng năm 2017 của Mỹ dựa trên nhân vật Peter Parker của truyện tranh Marvel. Bộ phim được sản xuất bởi Columbia Pictures và Marvel Studios, và được phân phối bởi Sony Pictures. Bộ phim có ý nghĩa khởi động lại dự án Spider-Man của Marvel sau nhiều năm nhượng quyền lại cho Sony Pictures. Bộ phim là bộ phim thứ 16 trong Vũ trụ điện ảnh Marvel (MCU).',
		'5-3-2022', 10),
	   (null, '', null, '', 'The Witch Diners', 'the-witch-s-diners',
		'https://www.youtube.com/watch?v=h3WKvtgz1Ng', 'https://movie0706.cybersoft.edu.vn/hinhanh/avatar_gp09.jpg',
		'Bàn tiệc của phù thủy là bộ phim truyền hình chiếu mạng của Hàn Quốc năm 2021 với sự góp mặt của các ngôi sao chính là Song Ji-hyo, Nam Ji-hyun và Chae Jong-hyeop. Phim được công chiếu lần đầu trên kênh TVING vào ngày 16 tháng 7, 2021 với lịch phát sáng là thứ 6 hàng tuần lúc 16:00.',
		'5-5-2022', 10),
	   (null, '', null, '', 'Red Notices', 'red-notices',
		'https://www.youtube.com/watch?v=Pj0wz7zu3Ms', 'https://movie0706.cybersoft.edu.vn/hinhanh/bad-boy-2022-_gp09.jpg',
		'Thông báo đỏ là một bộ phim hài hành động của Mỹ năm 2021 do Rawson Marshall Thurber viết kịch bản, đạo diễn và sản xuất. Dwayne Johnson, người cũng từng là nhà sản xuất, đóng vai một đặc vụ FBI, người miễn cưỡng hợp tác với một tên trộm nghệ thuật nổi tiếng để bắt một tên tội phạm khét tiếng hơn.',
		'5-30-2022', 10),
	   (null, '', null, '', 'Loki', 'loki',
		'https://www.youtube.com/watch?v=nW948Va-l10', 'https://movie0706.cybersoft.edu.vn/hinhanh/bloodshot_gp09.jpg',
		'Loki là sê-ri phim truyền hình Mỹ ra mắt năm 2021, phát độc quyền trên nền tảng trực tuyến Disney+ của đạo diễn Michael Waldron. Phim dựa trên nhân vật cùng tên từ truyện tranh Marvel Comics. Lấy bối cảnh trong Vũ trụ Điện ảnh Marvel, phim phát triển nội dung sau các sự kiện xảy ra sự kiện trong Avengers: Hồi kết.',
		'12-3-2022', 10);
