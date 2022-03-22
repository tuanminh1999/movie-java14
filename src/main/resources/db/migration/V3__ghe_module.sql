CREATE TABLE IF NOT EXISTS ghe(
	id uuid,
	created_date timestamp,
	created_by varchar(36),
	modified_date timestamp,
	modified_by varchar(36),
	ten_ghe varchar(255),
	so_thu_tu int,
	kich_hoat boolean,
	rap_id varchar(255),
	loai_ghe_id varchar(255),
	primary key (id)
);

CREATE TABLE IF NOT EXISTS loai_ghe(
	id varchar(255),
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

ALTER TABLE ghe
	ADD CONSTRAINT fk_ghe_rap
	FOREIGN KEY (rap_id) REFERENCES rap(id);

