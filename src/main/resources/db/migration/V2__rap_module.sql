CREATE TABLE IF NOT EXISTS he_thong_rap(
	id varchar(255),
	created_date timestamp,
	created_by varchar(36),
	modified_date timestamp,
	modified_by varchar(36),
	ten_he_thong_rap varchar(255) not null unique,
	bi_danh varchar(255) not null unique,
	logo varchar(255),
	primary key (id)
);

CREATE TABLE IF NOT EXISTS cum_rap(
	id varchar(255),
	created_date timestamp,
	created_by varchar(36),
	modified_date timestamp,
	modified_by varchar(36),
	ten_cum_rap varchar(255) not null unique,
	dia_chi varchar(255) not null unique,
	he_thong_rap_id varchar(255) not null,
	primary key (id)
);

CREATE TABLE IF NOT EXISTS rap(
	id varchar(255),
	created_date timestamp,
	created_by varchar(36),
	modified_date timestamp,
	modified_by varchar(36),
	ten_rap varchar(255) not null,
	cum_rap_id varchar(255) not null,
	primary key (id)
);

ALTER TABLE cum_rap 
	ADD CONSTRAINT fk_cum_rap_he_thong_rap
	FOREIGN KEY (he_thong_rap_id) REFERENCES he_thong_rap(id);

ALTER TABLE rap 
	ADD CONSTRAINT fk_rap_cum_rap
	FOREIGN KEY (cum_rap_id) REFERENCES cum_rap(id);
	
-- INSERT HE THONG RAP
INSERT INTO he_thong_rap(id, created_date, created_by, modified_date, modified_by, ten_he_thong_rap, bi_danh,
				 logo)
VALUES ('BHDStar', null, '', null, '', 'BHD Star Cineplex', 'bhd-star-cineplex',
		null),
		('CGV', null, '', null, '', 'cgv', 'cgv',
		null);
--		('CineStar', null, '', null, '', 'CineStar', 'cinestar',
--		null),
--		('Galaxy', null, '', null, '', 'Galaxy Cinema', 'galaxy-cinema',
--		null),
--		('LotteCinima', null, '', null, '', 'Lotte Cinema', 'lotte-cinema',
--		null),
--		('MegaGS', null, '', null, '', 'MegaGS', 'megags',
--		null)

-- INSERT CUM RAP
INSERT INTO cum_rap(id, created_date, created_by, modified_date, modified_by, ten_cum_rap, dia_chi, he_thong_rap_id)
	VALUES ('bhd-star-cineplex-3-2', null, '', null, '', 'BHD Star Cineplex - 3/2', 'L5-Vincom 3/2, 3C Đường 3/2, Q.10', 'BHDStar'),
--		   ('bhd-star-cineplex-bitexco', null, '', null, '', 'BHD Star Cineplex - Bitexco', 'L3-Bitexco Icon 68, 2 Hải Triều, Q.1', 'BHDStar'),
--		   ('bhd-star-cineplex-pham-hung', null, '', null, '', 'BHD Star Cineplex - Phạm Hùng', 'L4-Satra Phạm Hùng, C6/27 Phạm Hùng, Bình Chánh', 'BHDStar'),
--		   ('bhd-star-cineplex-vincom-le-van-viet', null, '', null, '', 'BHD Star Cineplex - Vincom Lê Văn Việt', 'L4-Vincom Plaza, 50 Lê Văn Việt, Q.9', 'BHDStar'),
--		   ('bhd-star-cineplex-vincom-quang-trung', null, '', null, '', 'BHD Star Cineplex - Vincom Quang Trung', 'B1-Vincom QT, 190 Quang Trung, Gò Vấp', 'BHDStar'),
--		   ('bhd-star-cineplex-vincom-thao-dien', null, '', null, '', 'BHD Star Cineplex - Vincom Thảo Điền', 'L5-Megamall, 159 XL Hà Nội, Q.2', 'BHDStar'),
		   
		   ('cgv-aeon-binh-tan', null, '', null, '', 'CGV - Aeon Bình Tân', 'Tầng 3, TTTM Aeon Mall Bình Tân, Số 1 đường số 17A, khu phố 11, Bình Trị Đông B, Bình Tân', 'CGV'),
		   ('cgv-aeon-tan-phu', null, '', null, '', 'CGV - Aeon Tân Phú', '30 Bờ Bao Tân Thắng, Sơn Kỳ, Tân Phú', 'CGV');
--		   ('cgv-cgv-saigonres-nguyen-xi', null, '', null, '', 'CGV - CGV Saigonres Nguyễn Xí', 'Tầng 4-5, Saigonres Plaza, 79/81 Nguyễn Xí, P. 26, Bình Thạnh', 'CGV'),
--		   ('cgv-crescent-mall', null, '', null, '', 'CGV - Crescent Mall', 'Lầu 5, Crescent Mall, Đại lộ Nguyễn Văn Linh, Phú Mỹ Hưng, Q. 7', 'CGV'),
--		   ('cgv-ct-plaza', null, '', null, '', 'CGV - CT Plaza', '60A Trường Sơn,P. 2, Tân Bình', 'CGV'),
--		   ('cgv-golden-plaza', null, '', null, '', 'CGV - Golden Plaza', 'Tầng 4, Trung tâm thương mại Golden Plaza, 922 Nguyễn Trãi, P. 14, Q. 5', 'CGV');
		
-- INSERT RAP
INSERT INTO rap(id, created_date, created_by, modified_date, modified_by, ten_rap, cum_rap_id)
	VALUES ('451', null, '', null, '', 'Rạp 1', 'bhd-star-cineplex-3-2'),
		   ('452', null, '', null, '', 'Rạp 2', 'bhd-star-cineplex-3-2'),
--		   ('453', null, '', null, '', 'Rạp 3', 'bhd-star-cineplex-3-2'),
--		   ('454', null, '', null, '', 'Rạp 4', 'bhd-star-cineplex-3-2'),
--		   ('455', null, '', null, '', 'Rạp 5', 'bhd-star-cineplex-3-2'),
--		   ('456', null, '', null, '', 'Rạp 6', 'bhd-star-cineplex-3-2'),
--		   ('457', null, '', null, '', 'Rạp 7', 'bhd-star-cineplex-3-2'),
--		   ('458', null, '', null, '', 'Rạp 8', 'bhd-star-cineplex-3-2'),
--		   ('459', null, '', null, '', 'Rạp 9', 'bhd-star-cineplex-3-2'),
--		   ('460', null, '', null, '', 'Rạp 10', 'bhd-star-cineplex-3-2'),
	
		   ('511', null, '', null, '', 'Rạp 1', 'cgv-aeon-binh-tan'),
		   ('512', null, '', null, '', 'Rạp 2', 'cgv-aeon-binh-tan'),
--		   ('513', null, '', null, '', 'Rạp 3', 'cgv-aeon-binh-tan'),
--		   ('514', null, '', null, '', 'Rạp 4', 'cgv-aeon-binh-tan'),
--		   ('515', null, '', null, '', 'Rạp 5', 'cgv-aeon-binh-tan'),
--		   ('516', null, '', null, '', 'Rạp 6', 'cgv-aeon-binh-tan'),
--		   ('517', null, '', null, '', 'Rạp 7', 'cgv-aeon-binh-tan'),
--		   ('518', null, '', null, '', 'Rạp 8', 'cgv-aeon-binh-tan'),
--		   ('519', null, '', null, '', 'Rạp 9', 'cgv-aeon-binh-tan'),
--		   ('520', null, '', null, '', 'Rạp 10', 'cgv-aeon-binh-tan');
		   
		   ('521', null, '', null, '', 'Rạp 1', 'cgv-aeon-tan-phu'),
		   ('522', null, '', null, '', 'Rạp 2', 'cgv-aeon-tan-phu');
--		   ('513', null, '', null, '', 'Rạp 3', 'cgv-aeon-binh-tan'),
--		   ('514', null, '', null, '', 'Rạp 4', 'cgv-aeon-binh-tan'),
--		   ('515', null, '', null, '', 'Rạp 5', 'cgv-aeon-binh-tan'),
--		   ('516', null, '', null, '', 'Rạp 6', 'cgv-aeon-binh-tan'),
--		   ('517', null, '', null, '', 'Rạp 7', 'cgv-aeon-binh-tan'),
--		   ('518', null, '', null, '', 'Rạp 8', 'cgv-aeon-binh-tan'),
--		   ('519', null, '', null, '', 'Rạp 9', 'cgv-aeon-binh-tan'),
--		   ('520', null, '', null, '', 'Rạp 10', 'cgv-aeon-binh-tan');