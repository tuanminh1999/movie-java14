CREATE TABLE IF NOT EXISTS lich_chieu (
	id serial,
	created_date timestamp,
	created_by varchar(36),
	modified_date timestamp,
	modified_by varchar(36),
	phim_id int not null,
	ngay_chieu_gio_chieu timestamp not null,
	rap_id varchar(255) not null,
	gia_ve int not null,
	thoi_luong int not null,
	primary key(id)
);

ALTER TABLE lich_chieu 
	ADD CONSTRAINT fk_lich_chieu_rap
	FOREIGN KEY (rap_id) REFERENCES rap(id);

ALTER TABLE lich_chieu 
	ADD CONSTRAINT fk_lich_chieu_phim
	FOREIGN KEY (phim_id) REFERENCES phim(id);

-- INSERT lich_chieu
INSERT INTO lich_chieu(created_date, created_by, modified_date, modified_by, phim_id, ngay_chieu_gio_chieu, rap_id, gia_ve, thoi_luong)
VALUES (null, '', null, '', 1, '5-5-2023 01:00:00', '451', 100000, 120),
	   (null, '', null, '', 1, '5-5-2023 10:00:00', '451', 100000, 120),
	   (null, '', null, '', 1, '5-5-2023 12:00:00', '451', 100000, 120),
	   (null, '', null, '', 2, '5-7-2023 20:00:00', '452', 150000, 120),
	   (null, '', null, '', 3, '5-10-2023 03:00:00', '511', 100000, 120),
	   (null, '', null, '', 4, '5-12-2023 04:00:00', '512', 100000, 120);