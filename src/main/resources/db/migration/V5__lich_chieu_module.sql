CREATE TABLE IF NOT EXISTS lich_chieu (
	id serial,
	created_date timestamp,
	created_by varchar(36),
	modified_date timestamp,
	modified_by varchar(36),
	phim_id int,
	ngay_chieu_gio_chieu timestamp not null,
	rap_id varchar(255),
	gia_ve int not null,
	primary key(id)
);

ALTER TABLE lich_chieu 
	ADD CONSTRAINT fk_lich_chieu_rap
	FOREIGN KEY (rap_id) REFERENCES rap(id);

ALTER TABLE lich_chieu 
	ADD CONSTRAINT fk_lich_chieu_phim
	FOREIGN KEY (phim_id) REFERENCES phim(id);