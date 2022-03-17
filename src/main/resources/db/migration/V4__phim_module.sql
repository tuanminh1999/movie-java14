CREATE TABLE IF NOT EXISTS phim(
	id uuid,
	created_date timestamp,
	created_by varchar(36),
	modified_date timestamp,
	modified_by varchar(36),
	ten_phim varchar(255) not null,
	bi_danh varchar(255) not null,
	trailer varchar(255) not null,
	hinh_anh varchar(255),
	mo_ta text,
	ngay_khoi_chieu timestamp not null,
	danh_gia int,
	primary key(id)
);
