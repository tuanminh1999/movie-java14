CREATE TABLE IF NOT EXISTS ghe(
	id serial,
	created_date timestamp,
	created_by varchar(36),
	modified_date timestamp,
	modified_by varchar(36),
	ten_ghe varchar(255),
	so_thu_tu int,
	kich_hoat boolean,
	rap_id varchar(255),
	loai_ghe_id varchar(255),
	primary key (id)
);

CREATE TABLE IF NOT EXISTS loai_ghe(
	id varchar(255),
	created_date timestamp,
	created_by varchar(36),
	modified_date timestamp,
	modified_by varchar(36),
	ten_loai_ghe varchar(255),
	mo_ta text,
	primary key (id)
);

ALTER TABLE ghe
	ADD CONSTRAINT fk_ghe_loai_ghe
	FOREIGN KEY (loai_ghe_id) REFERENCES loai_ghe(id);

ALTER TABLE ghe
	ADD CONSTRAINT fk_ghe_rap
	FOREIGN KEY (rap_id) REFERENCES rap(id);

-- INSERT loai_ghe
	INSERT INTO loai_ghe(id, created_date, created_by, modified_date, modified_by, ten_loai_ghe, mo_ta)
	VALUES ('Vip', null, '', null, '', 'Vip', 'Ghế này thường từ hàng ghế thứ 5 trở về sau (tính từ màn chiếu). Đây là những vị trí ngồi tốt nhất trong rạp.'),
		   ('Thuong', null, '', null, '', 'Thuong', 'Đây là loại ghế rẻ nhất vì nó sát với màn hình và rất khó để xem phim một cách thoải mái.');

-- INSERT ghe
	INSERT INTO ghe(created_date, created_by, modified_date, modified_by, ten_ghe, so_thu_tu, kich_hoat, rap_id, loai_ghe_id)
	VALUES (null, '', null, '', 'Ghế 1', 1, false, '451', 'Vip'),
		   (null, '', null, '', 'Ghế 2', 1, false, '451', 'Vip'),
		   (null, '', null, '', 'Ghế 3', 1, false, '451', 'Vip'),
		   (null, '', null, '', 'Ghế 4', 1, false, '451', 'Vip'),
		   (null, '', null, '', 'Ghế 5', 1, false, '451', 'Vip'),
		   (null, '', null, '', 'Ghế 6', 1, false, '451', 'Thuong'),
		   (null, '', null, '', 'Ghế 7', 1, false, '451', 'Thuong'),
		   (null, '', null, '', 'Ghế 8', 1, false, '451', 'Thuong'),
		   (null, '', null, '', 'Ghế 9', 1, false, '451', 'Thuong'),
		   (null, '', null, '', 'Ghế 10', 1, false, '451', 'Thuong'),
		   
		   (null, '', null, '', 'Ghế 1', 1, false, '452', 'Vip'),
		   (null, '', null, '', 'Ghế 2', 1, false, '452', 'Vip'),
		   (null, '', null, '', 'Ghế 3', 1, false, '452', 'Vip'),
		   (null, '', null, '', 'Ghế 4', 1, false, '452', 'Vip'),
		   (null, '', null, '', 'Ghế 5', 1, false, '452', 'Vip'),
		   (null, '', null, '', 'Ghế 6', 1, false, '452', 'Thuong'),
		   (null, '', null, '', 'Ghế 7', 1, false, '452', 'Thuong'),
		   (null, '', null, '', 'Ghế 8', 1, false, '452', 'Thuong'),
		   (null, '', null, '', 'Ghế 9', 1, false, '452', 'Thuong'),
		   (null, '', null, '', 'Ghế 10', 1, false, '452', 'Thuong'),
		   
		    (null, '', null, '', 'Ghế 1', 1, false, '511', 'Vip'),
		   (null, '', null, '', 'Ghế 2', 1, false, '511', 'Vip'),
		   (null, '', null, '', 'Ghế 3', 1, false, '511', 'Vip'),
		   (null, '', null, '', 'Ghế 4', 1, false, '511', 'Vip'),
		   (null, '', null, '', 'Ghế 5', 1, false, '511', 'Vip'),
		   (null, '', null, '', 'Ghế 6', 1, false, '511', 'Thuong'),
		   (null, '', null, '', 'Ghế 7', 1, false, '511', 'Thuong'),
		   (null, '', null, '', 'Ghế 8', 1, false, '511', 'Thuong'),
		   (null, '', null, '', 'Ghế 9', 1, false, '511', 'Thuong'),
		   (null, '', null, '', 'Ghế 10', 1, false, '511', 'Thuong'),
		   
		    (null, '', null, '', 'Ghế 1', 1, false, '512', 'Vip'),
		   (null, '', null, '', 'Ghế 2', 1, false, '512', 'Vip'),
		   (null, '', null, '', 'Ghế 3', 1, false, '512', 'Vip'),
		   (null, '', null, '', 'Ghế 4', 1, false, '512', 'Vip'),
		   (null, '', null, '', 'Ghế 5', 1, false, '512', 'Vip'),
		   (null, '', null, '', 'Ghế 6', 1, false, '512', 'Thuong'),
		   (null, '', null, '', 'Ghế 7', 1, false, '512', 'Thuong'),
		   (null, '', null, '', 'Ghế 8', 1, false, '512', 'Thuong'),
		   (null, '', null, '', 'Ghế 9', 1, false, '512', 'Thuong'),
		   (null, '', null, '', 'Ghế 10', 1, false, '512', 'Thuong');