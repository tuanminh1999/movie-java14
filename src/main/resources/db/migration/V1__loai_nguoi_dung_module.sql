CREATE TABLE IF NOT EXISTS loai_nguoi_dung(
	id uuid,
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
	ho_ten varchar(255) not null unique,
	mat_khau varchar(255) not null,
	email varchar(255) not null unique,
	so_dien_thoai varchar(255) not null unique,
	loai_nguoi_dung_id uuid not null,
	primary key (id)
);

ALTER TABLE nguoi_dung
	ADD CONSTRAINT fk_nguoidung_loai_nguoi_dung
	FOREIGN KEY (loai_nguoi_dung_id) REFERENCES loai_nguoi_dung(id);