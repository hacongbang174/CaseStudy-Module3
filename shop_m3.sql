-- create database shop_M3;
-- use shop_M3;

CREATE TABLE `user`(
	user_id INT AUTO_INCREMENT NOT NULL,
	user_name VARCHAR(200) NULL,
	user_email VARCHAR(255) NOT NULL,
	user_pass VARCHAR(255) NOT NULL,
	isAdmin VARCHAR(50),
    PRIMARY KEY (user_id)
);
INSERT `user` (user_id, user_name, user_email, user_pass, isAdmin) 
VALUES 	(1, 'Admin', 'hacongbang174@gmail.com', 'congbang123', 'true'),
		(2, 'Đặng Văn Quang', 'quangdang92@gmail.com', '123456', 'false'),
		(3, 'Châu Văn Nghĩa', 'van_nghia1992@gmail.com', '123456', 'false'),
		(4, 'Bảo Thi', 'baothi_2k@gmail.com', '112233', 'false'),
		(5, 'Thư Lê', 'thuhamchoi123@gmail.com', '123123', 'false');

CREATE TABLE product (
	product_id VARCHAR(10) NOT NULL,
	category_id INT NOT NULL,
	product_name VARCHAR(255) NOT NULL,
	product_price DOUBLE NOT NULL,
	product_describe VARCHAR(255) NOT NULL,
	quantity INT NOT NULL,
	img VARCHAR(255) NOT NULL,
    PRIMARY KEY (product_id),
	CONSTRAINT fk_id_category_product FOREIGN KEY (category_id)
	REFERENCES category (category_id)
	ON DELETE NO ACTION
	ON UPDATE NO ACTION
);

INSERT product (product_id, category_id, product_name, product_price, product_describe, quantity, img) 
VALUES ('AP5413', 1, 'Áo Polo Nam Cafe Tổ Ong Phối 3 Màu', 379000.0, 'Áo polo nam cafe dệt tổ ong phối 3 màu độc đáo, đường kẻ chạy dọc vai. Có khả năng chống tia UV đến 98%', 186, 'https://bizweb.dktcdn.net/100/438/408/products/ao-polo-nam-apm5413-tpv-4.jpg?v=1678526379770'),
('AP6277', 1, 'Áo Polo Nam Mắt Chim Phối Màu Năng Động', 329000.0, 'Chất liệu: Mắt chim. Sử dụng Cotton USA - sợi cotton tốt nhất trên thế giới. Công nghệ nhuộm Solid Dyed tạo nên hiệu ứng bắt mắt', 410, 'https://bizweb.dktcdn.net/100/438/408/products/apm6277-xxm-17.jpg?v=1679031918350'),
('AP3681', 1, 'Áo Polo Nam Coolmax Phối Bo Kẻ', 399000.0, 'Áo Polo nam chất liệu Coolmax, thành phần 95% Coolmax + 5% Spandex. Vải Coolmax nhẹ, xốp, thoáng mát, truyền dẫn ẩm tốt', 49, 'https://bizweb.dktcdn.net/100/438/408/products/apm3681-cba-qjm3021-den-2-2.jpg?v=1677121919667'),
('AT2106', 2, 'Áo Thun Thể Thao Nam Run', 269000.0, 'Áo thun nam thể thao, thiết kế mới nhất dành cho nam giới. Chất vải mềm mại, co giãn cực tốt, thấm hút mồ hôi hiệu quả', 95, 'https://bizweb.dktcdn.net/100/438/408/products/ao-thun-nam-the-thao-stm6099-ghi-2-yody.jpg?v=1683536629313'),
('AT2109', 2, 'Áo Phông Thể Thao Nam Tanktop', 229000.0, 'Áo thun thể thao nam SPORT dáng ba lỗ khoẻ khoắn', 75, 'https://bizweb.dktcdn.net/100/438/408/products/ao-thun-the-thao-nam-stm6079-den-6.jpg?v=1681703010577'),
('AH2119', 4, 'Áo Gia Đình Thêu COFFEE', 529000.0, 'Chất liệu nỉ. Vải co giãn, giữ ấm, bề mặt vải mịn cùng màu sắc thanh lịch', 82, 'https://bizweb.dktcdn.net/100/438/408/products/atm5081-cb1-3.jpg?v=1668569133223'),
('SM2127', 3, 'Áo Sơ Mi Cộc Tay Nam Họa Tiết Nhí', 459000.0, 'Vải mềm mại, bền màu, có khả năng thấm hút tốt, bắt nhiệt lạnh nhanh tạo cảm giác mát mẻ cho người mặc. Cổ và nẹp áo giữ phom trong thời gian dài, cúc áo khắc logo YODY nổi bật', 94, 'https://bizweb.dktcdn.net/100/438/408/products/scm6073-tra.jpg?v=1680165705280'),
('SM2128', 3, 'Sơ Mi Dài Tay Nam In Connect', 599000.0, 'Áo sơ mi nam dài tay kẻ sọc thiết kế phom dáng thoải mái, trẻ trung. Cổ và nẹp áp được giữ phom cực tốt. Lá cổ có cài cúc, ngực in chữ Connect độc đáo', 62, 'https://bizweb.dktcdn.net/100/438/408/products/ao-so-mi-nam-smm6019-kny-3.jpg?v=1683187350837'),
('AK2129', 5, 'Áo Phao Nam 3s Plus', 699000.0, 'ÁO PHAO NAM 3S PLUS: Siêu nhẹ - Siêu ấm - Siêu gọn - Trượt nước', 102, 'https://bizweb.dktcdn.net/100/438/408/products/phm5017-xcv-05.jpg?v=1677142189040'),
('AK2130', 5, 'Áo Khoác Gió Nam 3C Plus Năng Động Chống Ngấm Nước, Cản Gió, Cản Bụi', 499000.0, 'Áo khoác nam 3C PLUS - Cản gió, Chống thấm nước vào mặt trong, Cản bụi. Cấu trúc 2 lớp cơ bản', 300, 'https://bizweb.dktcdn.net/100/438/408/products/akm5037-cam-2.jpg?v=1672285629307'),
('AH2131', 4, 'Áo Gia Đình Thêu Thỏ', 489000.0, 'Chất liệu nỉ co giãn, giữ ấm tốt, bề mặt vải mịn cùng màu sắc hiện đại có thể kết hợp cùng quần nỉ hoặc quần jeans vào mùa thu đông', 198, 'https://bizweb.dktcdn.net/100/438/408/products/atm5111-cba-6.jpg?v=1669965149437');


CREATE TABLE product_color(
	product_id VARCHAR(10) NOT NULL,
	color VARCHAR(50) NOT NULL,
	CONSTRAINT fk_id_product_color FOREIGN KEY (product_id)
	REFERENCES product (product_id)
	ON DELETE NO ACTION
);

INSERT product_color (product_id, color) 
VALUES  ('AP5413', 'TRẮNG PHỐI VÀNG'),
		('AP5413', 'VÀNG PHỐI NAVY'),
		('AP6277', 'XANH XÁM'),
		('AP6277', 'ĐEN'),
		('AP6277', 'XANH LỤC'),
		('AP3681', 'XANH'),
        ('AP3681', 'HỒNG'),
		('AP3681', 'ĐEN'),
		('AT2106', 'TRẮNG'),
		('AT2106', 'XANH ĐEN'),
		('AT2109', 'ĐEN'),
		('AT2109', 'TÍM THANG'),
		('AT2109', 'XANH'),
		('AH2119', 'XANH'),
		('SM2127', 'ĐEN'),
		('SM2127', 'TRẮNG'),
		('SM2128', 'ĐEN'),
		('SM2128', 'KẺ XANH'),
		('SM2128', 'TRẮNG'),
		('AK2129', 'XANH'),
		('AK2129', 'VÀNG'),
		('AK2129', 'CAM'),
		('AK2130', 'CAM'),
		('AK2130', 'ĐEN'),
		('AK2130', 'XANH THAN'),
		('AH2131', 'XANH');

CREATE TABLE product_size(
	product_id VARCHAR(10) NOT NULL,
	size VARCHAR(50) NOT NULL,
	CONSTRAINT fk_id_product_size FOREIGN KEY (product_id)
	REFERENCES product (product_id)
	ON DELETE NO ACTION
);

INSERT product_size (product_id, size) 
VALUES 	('AP5413', 'L'),
		('AP5413', 'XL'),
		('AP5413', 'XXL'),
		('AP6277', 'M'),
		('AP6277', 'L'),
		('AP6277', 'XL'),
		('AP6277', 'XXL'),
		('AP3681', 'S'),
		('AP3681', 'L'),
		('AP3681', 'XL'),
		('AT2106', 'M'),
		('AT2106', 'L'),
		('AT2106', 'XL'),
		('AT2106', 'XXL'),
		('AT2109', 'L'),
		('AT2109', 'XL'),
		('AT2109', 'XXL'),
		('AH2119', 'L'),
		('AH2119', 'XL'),
		('AH2119', 'XXL'),
		('SM2127', 'M'),
		('SM2127', 'L'),
		('SM2127', 'XL'),
		('SM2128', 'M'),
		('SM2128', 'L'),
		('SM2128', 'XL'),
		('SM2128', 'XXL'),
		('AK2129', 'M'),
		('AK2129', 'L'),
		('AK2129', 'XL'),
		('AK2129', 'XXL'),  
		('AK2130', 'L'),
		('AK2130', 'XL'),
		('AK2130', 'XXL'),
		('AH2131', 'L'),
		('AH2131', 'XL');

CREATE TABLE category(
	category_id INT AUTO_INCREMENT NOT NULL,
	category_name VARCHAR(255) NOT NULL,
    PRIMARY KEY (category_id)
);
INSERT category (category_id, category_name) 
VALUES 	(1, 'ÁO POLO'),
		(2, 'ÁO THUN'),
		(3, 'ÁO SƠ MI'),
		(4, 'ÁO NỈ'),
		(5, 'ÁO KHOÁC');

CREATE TABLE cart(
	cart_id INT AUTO_INCREMENT NOT NULL,
	product_id VARCHAR(10) NOT NULL,
	product_name VARCHAR(255) NOT NULL,
	product_img VARCHAR(255) NOT NULL,
	product_price DOUBLE NOT NULL,
	total DOUBLE NOT NULL,
	quantity INT NOT NULL,
	PRIMARY KEY (cart_id),
	CONSTRAINT fk_id_product_cart FOREIGN KEY (product_id)
	REFERENCES product (product_id)
	ON DELETE NO ACTION
	ON UPDATE NO ACTION
);

CREATE TABLE bill (
    bill_id INT AUTO_INCREMENT NOT NULL,
    user_id INT NOT NULL,
    total DOUBLE NOT NULL,
    payment VARCHAR(255) NOT NULL,
    address VARCHAR(255) NOT NULL,
    createDate DATETIME NOT NULL,
    phone VARCHAR(10) NOT NULL,
    PRIMARY KEY (bill_id),
    CONSTRAINT fk_id_user_bill FOREIGN KEY (user_id)
	REFERENCES `user` (user_id)
	ON DELETE NO ACTION	
	ON UPDATE NO ACTION
);

INSERT bill (bill_id, user_id, total, payment, address, createDate, phone) 
VALUES 	(1, 5, 379000.0, 'MOMO', 'Huế', '2023-04-28 16:40:00', '0919208356'),
		(2, 2, 1188000.0, 'COD', 'Huế', '2023-04-29 08:30:00', '0888195313'),
		(3, 4, 918000.0, 'MOMO', 'Huế', '2023-05-04 14:24:26', '0383298183'),
		(4, 3, 728000.0, 'COD', 'Đà Nẵng', '2023-05-07 09:00:00', '0988195563');


CREATE TABLE bill_detail(
	detail_id INT AUTO_INCREMENT NOT NULL,
	bill_id INT NOT NULL,
	product_id VARCHAR(10) NOT NULL,
	quantity INT NOT NULL,
	size CHAR(10) NOT NULL,
	color VARCHAR(150) NOT NULL,
	price DOUBLE NOT NULL,
    PRIMARY KEY (detail_id),
	CONSTRAINT fk_id_bill_bill_detail FOREIGN KEY (bill_id)
	REFERENCES bill (bill_id)
	ON DELETE NO ACTION
	ON UPDATE NO ACTION,
	CONSTRAINT fk_id_product_bill_detail FOREIGN KEY (product_id)
	REFERENCES product (product_id)
	ON DELETE NO ACTION
	ON UPDATE NO ACTION
);
  
INSERT bill_detail (detail_id, bill_id, product_id, quantity, size, color, price) 
VALUES  (1, 1,'AP5413', 1, 'L', 'TRẮNG PHỐI VÀNG', 379000.0),
		(2, 2, 'AK2129', 1, 'L', 'XANH', 699000.0),
		(3, 2, 'AH2131', 1, 'L', 'XANH', 489000.0),
		(4, 3, 'SM2127', 1, 'XL', 'ĐEN', 459000.0),
		(5, 3, 'SM2127', 1, 'XL', 'TRẮNG', 459000.0),
		(6, 4, 'AP6277', 1, 'L', 'ĐEN', 329000.0),
		(7, 4, 'AP3681', 1, 'L', 'ĐEN', 399000.0);

