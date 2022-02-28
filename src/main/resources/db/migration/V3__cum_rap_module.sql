CREATE TABLE IF NOT EXISTS cum_rap(
	id uuid,
	created_date timestamp,
	created_by varchar(36),
	modified_date timestamp,
	modified_by varchar(36),
	ten_cum_rap varchar(255),
	primary key (id)
);

CREATE TABLE IF NOT EXISTS rap(
	id uuid,
	created_date timestamp,
	created_by varchar(36),
	modified_date timestamp,
	modified_by varchar(36),
	ten_rap varchar(255),
	cum_rap_id uuid,
	primary key (id)
);

ALTER TABLE rap 
	ADD CONSTRAINT fk_rap_cum_rap
	FOREIGN KEY (cum_rap_id) REFERENCES cum_rap(id);