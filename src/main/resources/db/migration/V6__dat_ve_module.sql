CREATE TABLE IF NOT EXISTS dat_ve (
	id serial,
	created_date timestamp,
	created_by varchar(36),
	modified_date timestamp,
	modified_by varchar(36),
	ngay_dat timestamp not null,
	ghe_id int not null,
	gia_ve int not null,
	lich_chieu_id int not null,
	nguoi_dung_id int not null,
	primary key(id)
);

ALTER TABLE dat_ve 
	ADD CONSTRAINT fk_dat_ve_ghe
	FOREIGN KEY (ghe_id) REFERENCES ghe(id);

ALTER TABLE dat_ve 
	ADD CONSTRAINT fk_dat_ve_lich_chieu
	FOREIGN KEY (lich_chieu_id) REFERENCES lich_chieu(id);

ALTER TABLE dat_ve 
	ADD CONSTRAINT fk_dat_ve_nguoi_dung
	FOREIGN KEY (nguoi_dung_id) REFERENCES nguoi_dung(id);