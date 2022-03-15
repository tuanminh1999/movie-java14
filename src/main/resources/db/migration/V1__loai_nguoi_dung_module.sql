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
		   ('cd335a35-fef9-4569-970a-95135b638802', null, '', null, '', 'nguyenvanc', 'Nguyễn Văn C', '$2a$10$ovoPySZ0mVog7YDDpnk8felVUf4IC7UUKHfLxqUKIvyjo0RCUGNde', 'nguyenvanc@gmail.com', '0333333333', 'KhachHang'),
		   ('8e854391-e82e-464b-860f-73a8da03c540', null, '', null, '', 'nguyenvand', 'Nguyễn Văn D', '$2a$10$ovoPySZ0mVog7YDDpnk8felVUf4IC7UUKHfLxqUKIvyjo0RCUGNde', 'nguyenvand@gmail.com', '0111111110', 'KhachHang'),
		   ('0aaeb5af-11d2-436e-98af-81ae71d2634d', null, '', null, '', 'nguyenvane', 'Nguyễn Văn E', '$2a$10$ovoPySZ0mVog7YDDpnk8felVUf4IC7UUKHfLxqUKIvyjo0RCUGNde', 'nguyenvane@gmail.com', '0222222221', 'KhachHang'),
		   ('a337a428-c3e4-41b7-b72b-31414b59ff2a', null, '', null, '', 'nguyenvanf', 'Nguyễn Văn F', '$2a$10$ovoPySZ0mVog7YDDpnk8felVUf4IC7UUKHfLxqUKIvyjo0RCUGNde', 'nguyenvanf@gmail.com', '0111111112', 'KhachHang'),
		   ('bdbc1c9f-6a13-4679-9e8d-7518eca80bb3', null, '', null, '', 'nguyenvang', 'Nguyễn Văn G', '$2a$10$ovoPySZ0mVog7YDDpnk8felVUf4IC7UUKHfLxqUKIvyjo0RCUGNde', 'nguyenvang@gmail.com', '0222222223', 'KhachHang'),
		   ('1353f77f-0818-468c-a949-2e6f72793ecb', null, '', null, '', 'nguyenvanh', 'Nguyễn Văn H', '$2a$10$ovoPySZ0mVog7YDDpnk8felVUf4IC7UUKHfLxqUKIvyjo0RCUGNde', 'nguyenvanh@gmail.com', '0111111114', 'KhachHang'),
		   ('7670d92b-45a0-4462-8c61-55d03eb39436', null, '', null, '', 'nguyenvani', 'Nguyễn Văn I', '$2a$10$ovoPySZ0mVog7YDDpnk8felVUf4IC7UUKHfLxqUKIvyjo0RCUGNde', 'nguyenvani@gmail.com', '0222222225', 'KhachHang'),
		   ('59c423a8-c946-4942-bfdb-af5d35baeb63', null, '', null, '', 'nguyenvanj', 'Nguyễn Văn J', '$2a$10$ovoPySZ0mVog7YDDpnk8felVUf4IC7UUKHfLxqUKIvyjo0RCUGNde', 'nguyenvanj@gmail.com', '0111111116', 'KhachHang'),
		   ('89d3bb1f-f596-43e0-8434-2b524de688e3', null, '', null, '', 'nguyenvank', 'Nguyễn Văn K', '$2a$10$ovoPySZ0mVog7YDDpnk8felVUf4IC7UUKHfLxqUKIvyjo0RCUGNde', 'nguyenvank@gmail.com', '0222222227', 'KhachHang'),
		   ('5925a019-a94f-4978-bd89-38f8fe8f0a9a', null, '', null, '', 'nguyenvanl', 'Nguyễn Văn L', '$2a$10$ovoPySZ0mVog7YDDpnk8felVUf4IC7UUKHfLxqUKIvyjo0RCUGNde', 'nguyenvanl@gmail.com', '0111111118', 'KhachHang'),
		   ('376ebc99-4e87-414a-a138-48af848871bd', null, '', null, '', 'nguyenvanm', 'Nguyễn Văn M', '$2a$10$ovoPySZ0mVog7YDDpnk8felVUf4IC7UUKHfLxqUKIvyjo0RCUGNde', 'nguyenvanm@gmail.com', '0222222229', 'KhachHang'),
		   ('d317e966-f598-45c8-8243-475d2d62e096', null, '', null, '', 'nguyenvann', 'Nguyễn Văn N', '$2a$10$ovoPySZ0mVog7YDDpnk8felVUf4IC7UUKHfLxqUKIvyjo0RCUGNde', 'nguyenvann@gmail.com', '0111111101', 'KhachHang'),
		   ('df73d394-96a4-4459-b33b-c5c46992a7a8', null, '', null, '', 'nguyenvano', 'Nguyễn Văn O', '$2a$10$ovoPySZ0mVog7YDDpnk8felVUf4IC7UUKHfLxqUKIvyjo0RCUGNde', 'nguyenvano@gmail.com', '0222222202', 'KhachHang'),
		   ('54ce2601-b47a-429d-abd3-66b4d3abe501', null, '', null, '', 'nguyenvanp', 'Nguyễn Văn P', '$2a$10$ovoPySZ0mVog7YDDpnk8felVUf4IC7UUKHfLxqUKIvyjo0RCUGNde', 'nguyenvanp@gmail.com', '0111111103', 'KhachHang'),
		   ('3e4a2b10-9547-43ad-89b8-28eec734b44e', null, '', null, '', 'nguyenvanq', 'Nguyễn Văn Q', '$2a$10$ovoPySZ0mVog7YDDpnk8felVUf4IC7UUKHfLxqUKIvyjo0RCUGNde', 'nguyenvanq@gmail.com', '0222222204', 'KhachHang'),
		   ('2ff2e5aa-8d7f-4c1d-a0a9-04a7ce589179', null, '', null, '', 'nguyenvanr', 'Nguyễn Văn R', '$2a$10$ovoPySZ0mVog7YDDpnk8felVUf4IC7UUKHfLxqUKIvyjo0RCUGNde', 'nguyenvanr@gmail.com', '0111111105', 'KhachHang'),
		   ('3835a511-2740-42f5-bf62-6820d22bf8aa', null, '', null, '', 'nguyenvans', 'Nguyễn Văn S', '$2a$10$ovoPySZ0mVog7YDDpnk8felVUf4IC7UUKHfLxqUKIvyjo0RCUGNde', 'nguyenvans@gmail.com', '0222222206', 'KhachHang'),
		   ('bbe3d80f-4421-4430-bb59-d09354dbfd3f', null, '', null, '', 'nguyenvant', 'Nguyễn Văn T', '$2a$10$ovoPySZ0mVog7YDDpnk8felVUf4IC7UUKHfLxqUKIvyjo0RCUGNde', 'nguyenvant@gmail.com', '0111111107', 'KhachHang'),
		   ('53e96c99-bb36-486f-80c4-8b9abd760a03', null, '', null, '', 'nguyenvanu', 'Nguyễn Văn U', '$2a$10$ovoPySZ0mVog7YDDpnk8felVUf4IC7UUKHfLxqUKIvyjo0RCUGNde', 'nguyenvanu@gmail.com', '0222222208', 'KhachHang'),
		   ('09da19ff-38df-408c-abdd-c508c18b3a4f', null, '', null, '', 'nguyenvanv', 'Nguyễn Văn V', '$2a$10$ovoPySZ0mVog7YDDpnk8felVUf4IC7UUKHfLxqUKIvyjo0RCUGNde', 'nguyenvanv@gmail.com', '0111111109', 'KhachHang'),
		   ('87356267-6dbf-4fd8-a644-681f6d52a19b', null, '', null, '', 'nguyenvanw', 'Nguyễn Văn W', '$2a$10$ovoPySZ0mVog7YDDpnk8felVUf4IC7UUKHfLxqUKIvyjo0RCUGNde', 'nguyenvanw@gmail.com', '0222222233', 'KhachHang'),
		   ('ab68f9db-ad14-4700-9c4b-8c9ff35689c4', null, '', null, '', 'nguyenvanx', 'Nguyễn Văn X', '$2a$10$ovoPySZ0mVog7YDDpnk8felVUf4IC7UUKHfLxqUKIvyjo0RCUGNde', 'nguyenvanx@gmail.com', '0111111144', 'KhachHang'),
		   ('ba9f3719-2038-48ba-8022-240d40c6e967', null, '', null, '', 'nguyenvany', 'Nguyễn Văn Y', '$2a$10$ovoPySZ0mVog7YDDpnk8felVUf4IC7UUKHfLxqUKIvyjo0RCUGNde', 'nguyenvany@gmail.com', '0222222255', 'KhachHang'),
		   ('23e2fcf3-b1ef-49d9-83bb-433ae84352a7', null, '', null, '', 'nguyenvanz', 'Nguyễn Văn Z', '$2a$10$ovoPySZ0mVog7YDDpnk8felVUf4IC7UUKHfLxqUKIvyjo0RCUGNde', 'nguyenvanz@gmail.com', '0111111166', 'KhachHang');