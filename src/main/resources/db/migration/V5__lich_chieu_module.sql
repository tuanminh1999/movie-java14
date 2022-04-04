CREATE TABLE IF NOT EXISTS lich_chieu (
	id varchar(255),
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