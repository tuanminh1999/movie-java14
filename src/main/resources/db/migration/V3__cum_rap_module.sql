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
	
-- INSERT HE THONG RAP

	INSERT INTO he_thong_rap(id, created_date, created_by, modified_date, modified_by, ten_he_thong_rap, bi_danh, logo)
	VALUES 	('BHDStar', null, 'BQN', null, 'BQN', 'BHD Star Cineplex' , 'bhd-star-cineplex', 'http://movie0706.cybersoft.edu.vn/hinhanh/bhd-star-cineplex.png'),
			('CGV', null, 'BQN', null, 'BQN', 'cgv', 'cgv', 'http://movie0706.cybersoft.edu.vn/hinhanh/cgv.png'),
			('CineStar', null, 'BQN', null, 'BQN', 'CineStar' , 'cinestar', 'http://movie0706.cybersoft.edu.vn/hinhanh/cinestar.png'),
			('Galaxy', null, 'BQN', null, 'BQN', 'Galaxy Cinema' , 'galaxy-cinema', 'http://movie0706.cybersoft.edu.vn/hinhanh/galaxy-cinema.png'),
			('LotteCinema', null, 'BQN', null, 'BQN', 'Lotte Cinema' , 'lotte-cinema', 'http://movie0706.cybersoft.edu.vn/hinhanh/lotte-cinema.png'),
			('MegaGS', null, 'BQN', null, 'BQN', 'MegaGS' , 'megags', 'http://movie0706.cybersoft.edu.vn/hinhanh/megags.png');
			
-- INSERT CUM RAP