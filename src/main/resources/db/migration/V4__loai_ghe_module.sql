CREATE TABLE IF NOT EXISTS ghe(
	id uuid,
	created_date timestamp,
	created_by varchar(36),
	modified_date timestamp,
	modified_by varchar(36),
	
	primary key (id)
);