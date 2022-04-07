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
	id serial,
	created_date timestamp,
	created_by varchar(36),
	modified_date timestamp,
	modified_by varchar(36),
	tai_khoan varchar(255) not null unique,
	ho_ten varchar(255) not null,
	mat_khau varchar(255) not null,
	email varchar(255) not null unique,
	so_dien_thoai varchar(255) not null unique,
	loai_nguoi_dung_id varchar(100) not null,
	primary key (id)
);

ALTER TABLE nguoi_dung
	ADD CONSTRAINT fk_nguoi_dung_loai_nguoi_dung
	FOREIGN KEY (loai_nguoi_dung_id) REFERENCES loai_nguoi_dung(id);
	
-- INSERT loai_nguoi_dung
	INSERT INTO loai_nguoi_dung(id, created_date, created_by, modified_date, modified_by, ten_loai_nguoi_dung)
	VALUES ('KhachHang', null, '', null, '', 'Khách Hàng'),
		   ('QuanTri', null, '', null, '', 'Quản Trị');

-- INSERT nguoi_dung (mat_khau:123456789)
	INSERT INTO nguoi_dung(created_date, created_by, modified_date, modified_by, 
						   tai_khoan, ho_ten, mat_khau, email, so_dien_thoai, loai_nguoi_dung_id)
	VALUES (null, '', null, '', 'tuanminh', 'Trương Tuấn Minh', '$2a$10$ovoPySZ0mVog7YDDpnk8felVUf4IC7UUKHfLxqUKIvyjo0RCUGNde', 'tuanminh01659889@gmail.com', '0359492889', 'QuanTri'),
		   (null, '', null, '', 'quocbinh', 'Nguyễn Quốc Bình', '$2a$10$ovoPySZ0mVog7YDDpnk8felVUf4IC7UUKHfLxqUKIvyjo0RCUGNde', 'quocbinh0612@gmail.com', '0784455664', 'QuanTri'),
		   (null, '', null, '', 'quocdat', 'Trần Hữu Quốc Đạt', '$2a$10$ovoPySZ0mVog7YDDpnk8felVUf4IC7UUKHfLxqUKIvyjo0RCUGNde', 'quocdattranhuu1606@gmail.com', '0773733727', 'QuanTri'),
		   (null, '', null, '', 'nguyenvana', 'Nguyễn Văn A', '$2a$10$ovoPySZ0mVog7YDDpnk8felVUf4IC7UUKHfLxqUKIvyjo0RCUGNde', 'nguyenvana@gmail.com', '0111111111', 'KhachHang'),
		   (null, '', null, '', 'nguyenvanb', 'Nguyễn Văn B', '$2a$10$ovoPySZ0mVog7YDDpnk8felVUf4IC7UUKHfLxqUKIvyjo0RCUGNde', 'nguyenvanb@gmail.com', '0222222222', 'KhachHang'),
		   (null, '', null, '', 'nguyenvanc', 'Nguyễn Văn C', '$2a$10$ovoPySZ0mVog7YDDpnk8felVUf4IC7UUKHfLxqUKIvyjo0RCUGNde', 'nguyenvanc@gmail.com', '0333333333', 'KhachHang'),
		   (null, '', null, '', 'nguyenvand', 'Nguyễn Văn D', '$2a$10$ovoPySZ0mVog7YDDpnk8felVUf4IC7UUKHfLxqUKIvyjo0RCUGNde', 'nguyenvand@gmail.com', '0111111110', 'KhachHang'),
		   (null, '', null, '', 'nguyenvane', 'Nguyễn Văn E', '$2a$10$ovoPySZ0mVog7YDDpnk8felVUf4IC7UUKHfLxqUKIvyjo0RCUGNde', 'nguyenvane@gmail.com', '0222222221', 'KhachHang'),
		   (null, '', null, '', 'nguyenvanf', 'Nguyễn Văn F', '$2a$10$ovoPySZ0mVog7YDDpnk8felVUf4IC7UUKHfLxqUKIvyjo0RCUGNde', 'nguyenvanf@gmail.com', '0111111112', 'KhachHang'),
		   (null, '', null, '', 'nguyenvang', 'Nguyễn Văn G', '$2a$10$ovoPySZ0mVog7YDDpnk8felVUf4IC7UUKHfLxqUKIvyjo0RCUGNde', 'nguyenvang@gmail.com', '0222222223', 'KhachHang'),
		   (null, '', null, '', 'nguyenvanh', 'Nguyễn Văn H', '$2a$10$ovoPySZ0mVog7YDDpnk8felVUf4IC7UUKHfLxqUKIvyjo0RCUGNde', 'nguyenvanh@gmail.com', '0111111114', 'KhachHang'),
		   (null, '', null, '', 'nguyenvani', 'Nguyễn Văn I', '$2a$10$ovoPySZ0mVog7YDDpnk8felVUf4IC7UUKHfLxqUKIvyjo0RCUGNde', 'nguyenvani@gmail.com', '0222222225', 'KhachHang'),
		   (null, '', null, '', 'nguyenvanj', 'Nguyễn Văn J', '$2a$10$ovoPySZ0mVog7YDDpnk8felVUf4IC7UUKHfLxqUKIvyjo0RCUGNde', 'nguyenvanj@gmail.com', '0111111116', 'KhachHang'),
		   (null, '', null, '', 'nguyenvank', 'Nguyễn Văn K', '$2a$10$ovoPySZ0mVog7YDDpnk8felVUf4IC7UUKHfLxqUKIvyjo0RCUGNde', 'nguyenvank@gmail.com', '0222222227', 'KhachHang'),
		   (null, '', null, '', 'nguyenvanl', 'Nguyễn Văn L', '$2a$10$ovoPySZ0mVog7YDDpnk8felVUf4IC7UUKHfLxqUKIvyjo0RCUGNde', 'nguyenvanl@gmail.com', '0111111118', 'KhachHang'),
		   (null, '', null, '', 'nguyenvanm', 'Nguyễn Văn M', '$2a$10$ovoPySZ0mVog7YDDpnk8felVUf4IC7UUKHfLxqUKIvyjo0RCUGNde', 'nguyenvanm@gmail.com', '0222222229', 'KhachHang'),
		   (null, '', null, '', 'nguyenvann', 'Nguyễn Văn N', '$2a$10$ovoPySZ0mVog7YDDpnk8felVUf4IC7UUKHfLxqUKIvyjo0RCUGNde', 'nguyenvann@gmail.com', '0111111101', 'KhachHang'),
		   (null, '', null, '', 'nguyenvano', 'Nguyễn Văn O', '$2a$10$ovoPySZ0mVog7YDDpnk8felVUf4IC7UUKHfLxqUKIvyjo0RCUGNde', 'nguyenvano@gmail.com', '0222222202', 'KhachHang'),
		   (null, '', null, '', 'nguyenvanp', 'Nguyễn Văn P', '$2a$10$ovoPySZ0mVog7YDDpnk8felVUf4IC7UUKHfLxqUKIvyjo0RCUGNde', 'nguyenvanp@gmail.com', '0111111103', 'KhachHang'),
		   (null, '', null, '', 'nguyenvanq', 'Nguyễn Văn Q', '$2a$10$ovoPySZ0mVog7YDDpnk8felVUf4IC7UUKHfLxqUKIvyjo0RCUGNde', 'nguyenvanq@gmail.com', '0222222204', 'KhachHang'),
		   (null, '', null, '', 'nguyenvanr', 'Nguyễn Văn R', '$2a$10$ovoPySZ0mVog7YDDpnk8felVUf4IC7UUKHfLxqUKIvyjo0RCUGNde', 'nguyenvanr@gmail.com', '0111111105', 'KhachHang'),
		   (null, '', null, '', 'nguyenvans', 'Nguyễn Văn S', '$2a$10$ovoPySZ0mVog7YDDpnk8felVUf4IC7UUKHfLxqUKIvyjo0RCUGNde', 'nguyenvans@gmail.com', '0222222206', 'KhachHang'),
		   (null, '', null, '', 'nguyenvant', 'Nguyễn Văn T', '$2a$10$ovoPySZ0mVog7YDDpnk8felVUf4IC7UUKHfLxqUKIvyjo0RCUGNde', 'nguyenvant@gmail.com', '0111111107', 'KhachHang'),
		   (null, '', null, '', 'nguyenvanu', 'Nguyễn Văn U', '$2a$10$ovoPySZ0mVog7YDDpnk8felVUf4IC7UUKHfLxqUKIvyjo0RCUGNde', 'nguyenvanu@gmail.com', '0222222208', 'KhachHang'),
		   (null, '', null, '', 'nguyenvanv', 'Nguyễn Văn V', '$2a$10$ovoPySZ0mVog7YDDpnk8felVUf4IC7UUKHfLxqUKIvyjo0RCUGNde', 'nguyenvanv@gmail.com', '0111111109', 'KhachHang'),
		   (null, '', null, '', 'nguyenvanw', 'Nguyễn Văn W', '$2a$10$ovoPySZ0mVog7YDDpnk8felVUf4IC7UUKHfLxqUKIvyjo0RCUGNde', 'nguyenvanw@gmail.com', '0222222233', 'KhachHang'),
		   (null, '', null, '', 'nguyenvanx', 'Nguyễn Văn X', '$2a$10$ovoPySZ0mVog7YDDpnk8felVUf4IC7UUKHfLxqUKIvyjo0RCUGNde', 'nguyenvanx@gmail.com', '0111111144', 'KhachHang'),
		   (null, '', null, '', 'nguyenvany', 'Nguyễn Văn Y', '$2a$10$ovoPySZ0mVog7YDDpnk8felVUf4IC7UUKHfLxqUKIvyjo0RCUGNde', 'nguyenvany@gmail.com', '0222222255', 'KhachHang'),
		   (null, '', null, '', 'nguyenvanz', 'Nguyễn Văn Z', '$2a$10$ovoPySZ0mVog7YDDpnk8felVUf4IC7UUKHfLxqUKIvyjo0RCUGNde', 'nguyenvanz@gmail.com', '0111111166', 'KhachHang');