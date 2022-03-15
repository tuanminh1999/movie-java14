CREATE TABLE IF NOT EXISTS loai_nguoi_dung(
	id varchar(100),
	created_date timestamp,
	created_by varchar(36),
	modified_date timestamp,
	modified_by varchar(36),
	ten_loai_nguoi_dung varchar(255) not null unique,
	primary key (id)
);

CREATE TABLE IF NOT EXISTS nguoi_dung(
	id uuid,
	created_date timestamp,
	created_by varchar(36),
	modified_date timestamp,
	modified_by varchar(36),
	tai_khoan varchar(255) not null unique,
	ho_ten varchar(255) not null,
	mat_khau varchar(255) not null,
	email varchar(255) not null unique,
	so_dien_thoai varchar(255) not null unique,
	loai_nguoi_dung_id varchar(100),
	primary key (id)
);

ALTER TABLE nguoi_dung
	ADD CONSTRAINT fk_nguoi_dung_loai_nguoi_dung
	FOREIGN KEY (loai_nguoi_dung_id) REFERENCES loai_nguoi_dung(id);
	
-- INSERT loai_nguoi_dung
	INSERT INTO loai_nguoi_dung(id, created_date, created_by, modified_date, modified_by, ten_loai_nguoi_dung)
	VALUES ('KhachHang', null, '', null, '', 'Khách Hàng'),
		   ('QuanTri', null, '', null, '', 'Quản Trị');

-- INSERT nguoi_dung
	INSERT INTO nguoi_dung(id, created_date, created_by, modified_date, modified_by, 
						   tai_khoan, ho_ten, mat_khau, email, so_dien_thoai, loai_nguoi_dung_id)
	VALUES ('69eeab60-6a62-46a3-af6c-af42f550c658', null, '', null, '', 'tuanminh', 'Trương Tuấn Minh', '$2a$10$ovoPySZ0mVog7YDDpnk8felVUf4IC7UUKHfLxqUKIvyjo0RCUGNde', 'tuanminh01659889@gmail.com', '0359492889', 'QuanTri'),
		   ('d0a8553d-4ed5-428e-9700-8445e8ab8bb3', null, '', null, '', 'quocbinh', 'Nguyễn Quốc Bình', '$2a$10$ovoPySZ0mVog7YDDpnk8felVUf4IC7UUKHfLxqUKIvyjo0RCUGNde', 'quocbinh0612@gmail.com', '0784455664', 'QuanTri'),
		   ('3a1b604c-e99b-4254-8611-ff237d90b2d1', null, '', null, '', 'quocdat', 'Trần Hữu Quốc Đạt', '$2a$10$ovoPySZ0mVog7YDDpnk8felVUf4IC7UUKHfLxqUKIvyjo0RCUGNde', 'quocdattranhuu1606@gmail.com', '0773733727', 'QuanTri'),
		   ('ff68f913-c8d3-438f-8860-ee3275333c7d', null, '', null, '', 'nguyenvana', 'Nguyễn Văn A', '$2a$10$ovoPySZ0mVog7YDDpnk8felVUf4IC7UUKHfLxqUKIvyjo0RCUGNde', 'nguyenvana@gmail.com', '0111111111', 'KhachHang'),
		   ('7e3e4347-5184-4afa-9b12-12c36b49582e', null, '', null, '', 'nguyenvanb', 'Nguyễn Văn B', '$2a$10$ovoPySZ0mVog7YDDpnk8felVUf4IC7UUKHfLxqUKIvyjo0RCUGNde', 'nguyenvanb@gmail.com', '0222222222', 'KhachHang'),
		   ('cd335a35-fef9-4569-970a-95135b638802', null, '', null, '', 'nguyenvanc', 'Nguyễn Văn C', '$2a$10$ovoPySZ0mVog7YDDpnk8felVUf4IC7UUKHfLxqUKIvyjo0RCUGNde', 'nguyenvanc@gmail.com', '0333333333', 'KhachHang');