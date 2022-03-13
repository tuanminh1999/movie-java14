CREATE TABLE IF NOT EXISTS ghe(
	id uuid,
	created_date timestamp,
	created_by varchar(36),
	modified_date timestamp,
	modified_by varchar(36),
	so_thu_tu integer,
	kich_hoat integer,
	rap_id integer,
	loai_ghe_id uuid,
	primary key (id)
);

CREATE TABLE IF NOT EXISTS loai_ghe(
	id uuid,
	created_date timestamp,
	created_by varchar(36),
	modified_date timestamp,
	modified_by varchar(36),
	ten_loai_ghe varchar(255),
	mo_ta text,
	primary key (id)
);

ALTER TABLE ghe
	ADD CONSTRAINT fk_ghe_loai_ghe
	FOREIGN KEY (loai_ghe_id) REFERENCES loai_ghe(id);

