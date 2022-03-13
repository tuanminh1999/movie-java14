CREATE TABLE IF NOT EXISTS loai_nguoi_dung(
	id uuid,
	created_date timestamp,
	created_by varchar(36),
	modified_date timestamp,
	modified_by varchar(36),
	ten_loai_nguoi_dung varchar(255),
	primary key (id)
);