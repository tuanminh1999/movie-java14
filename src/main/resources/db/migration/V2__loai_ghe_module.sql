CREATE TABLE IF NOT EXISTS loai_ghe (

	id uuid,
	created_date timestamp,
	created_by varchar(36),
	modified_date timestamp,
	modified_by varchar(36),
	ten_loai_ghe varchar(255),
	mo_ta text,
	primary key (id)
);