CREATE TABLE IF NOT EXISTS he_thong_rap(
	id varchar(255),
	created_date timestamp,
	created_by varchar(36),
	modified_date timestamp,
	modified_by varchar(36),
	ten_he_thong_rap varchar(255),
	bi_danh varchar(255),
	logo varchar(255),
	primary key (id)
);

CREATE TABLE IF NOT EXISTS cum_rap(
	id varchar(255),
	created_date timestamp,
	created_by varchar(36),
	modified_date timestamp,
	modified_by varchar(36),
	ten_cum_rap varchar(255),
	dia_chi varchar(255),
	he_thong_rap_id varchar(255),
	primary key (id)
);

CREATE TABLE IF NOT EXISTS rap(
	id varchar(255),
	created_date timestamp,
	created_by varchar(36),
	modified_date timestamp,
	modified_by varchar(36),
	ten_rap varchar(255),
	cum_rap_id varchar(255),
	primary key (id)
);

ALTER TABLE cum_rap 
	ADD CONSTRAINT fk_cum_rap_he_thong_rap
	FOREIGN KEY (he_thong_rap_id) REFERENCES he_thong_rap(id);

ALTER TABLE rap 
	ADD CONSTRAINT fk_rap_cum_rap
	FOREIGN KEY (cum_rap_id) REFERENCES cum_rap(id);