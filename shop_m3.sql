

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
VALUES ('AT533', 2, 'Champion Graphic Big Logo T-Shirt', 149000.0, 'Cổ Tròn, Vạt Ngang, Tay Ngắn, Hình In Trước', 186, 'images/AT533.png'),
('AT536', 2, 'Champion Change The World', 139000.0, 'Cổ Tròn, Vạt Ngang, Tay Ngắn, Hình Thêu Trước', 410, 'images/AT536.png'),
('T2099', 2, 'No Smile Tee Purple', 189000.0, 'Cổ Tròn, Tay Ngắn, Vạt Ngang, Hình Phía Trước Và Sau', 49, 'images/T2099.png'),
('T2106', 2, 'Shin-chan Tee', 229000.0, 'Cổ Tròn, Tay Ngắn, Vạt Ngang, Hình In Trước', 95, 'images/T2106.png'),
('T2109', 2, 'Tie Dye Orange Mint Tee', 290000.0, 'Cổ Tròn , Tay Ngắn, Vạt Ngang, Hình In Trước Và Sau, Tie Tye', 75, 'images/T2109.png'),
('T2119', 2, 'The Sun Tie Dye', 280000.0, 'Cổ Tròn,  Tay Ngắn, Vạt Ngang, Hình In Trước Và Sau, Tie Tye', 82, 'images/T2119.png'),
('T2127', 2, 'Fucking Awesome Tee In Black', 259000.0, 'Cổ Tròn, Tay Ngắn, Vạt Ngang, Hình Phía Trước Và Sau', 94, 'images/T2127.png'),
('T2128', 2, 'Fucking Awesome Tee', 259000.0, 'Cổ Tròn , Tay Ngắn, Vạt Ngang, Hình Phía Trước Và Sau', 62, 'images/T2128.png'),
('T2129', 2, 'I''m Not Psycho Tee', 270000.0, 'Cổ Tròn, Tay Ngắn, Vạt Ngang, Hình Phía Trước Và Sau', 102, 'images/T2129.png'),
('T2130', 2, 'Acid Washed Dark', 240000.0, 'Cổ Tròn, Tay Ngắn, Vạt Ngang, Stone Wash', 300, 'images/T2130.png'),
('T2131', 2, 'Exceptional Tee With Distressed', 250000.0, 'Cổ Tròn, Tay Ngắn, Vạt Ngang, Hình Phía Trước Và Sau, Stone Wash', 198, 'images/T2131.png'),
('TD481', 7, 'Sinner Sweater', 360000.0, 'Cổ Tròn, Vạt Ngang, Tay Dài Bo, Hình In Mặt Trước Và Sau ', 29, 'images/TD481.png'),
('TD509', 7, 'Champion Sweater', 169000.0, 'Cổ Tròn, Vạt Ngang, Tay Dài Bo, Hình Thêu Trước ', 447, 'images/TD509.png');


CREATE TABLE product_color(
	product_id VARCHAR(10) NOT NULL,
	color VARCHAR(50) NOT NULL,
	CONSTRAINT fk_id_product_color FOREIGN KEY (product_id)
	REFERENCES product (product_id)
	ON DELETE NO ACTION
);

INSERT product_color (product_id, color) 
VALUES  ('T2131', 'Grey'),
		('T2131', 'Blue'),
		('T2130', 'Grey'),
		('T2119', 'Pink'),
		('T2119', 'White'),
		('AT533', 'White'),
		('AT533', 'Black'),
		('AT536', 'Red'),
		('AT536', 'White'),
		('AT536', 'Black'),
		('AT536', 'Blue'),
		('TD509', 'Purple'),
		('TD509', 'Blue'),
		('TD509', 'Black'),
		('TD509', 'White'),
		('TD481', 'White'),
		('T2109', 'Orange'),
		('T2128', 'White'),
		('T2128', 'Green'),
		('T2127', 'Black'),
		('T2099', 'Purple'),
		('T2129', 'White'),
		('T2106', 'Yellow');

CREATE TABLE product_size(
	product_id VARCHAR(10) NOT NULL,
	size VARCHAR(50) NOT NULL,
	CONSTRAINT fk_id_product_size FOREIGN KEY (product_id)
	REFERENCES product (product_id)
	ON DELETE NO ACTION
);

INSERT product_size (product_id, size) 
VALUES 	('T2131', 'L'),
		('T2131', 'XL'),
		('T2131', 'XXL'),
		('T2130', 'S'),
		('T2130', 'L'),
		('T2119', 'L'),
		('T2119', 'XL'),
		('AT533', 'S'),
		('AT533', 'L'),
		('AT533', 'XL'),
		('AT536', 'S'),
		('AT536', 'L'),
		('AT536', 'XXL'),
		('TD509', 'S'),
		('TD509', 'L'),
		('TD509', 'XL'),
		('TD509', 'XXL'),
		('TD481', 'L'),
		('TD481', 'XL'),
		('T2109', 'L'),
		('T2109', 'XL'),
		('T2099', 'S'),
		('T2099', 'L'),
		('T2099', 'XL'),
		('T2128', 'XS'),
		('T2128', 'L'),
		('T2128', 'XL'),
		('T2127', 'L'),
		('T2129', 'XS'),
		('T2129', 'S'),
		('T2129', 'L'),
		('T2129', 'XL'),
		('T2106', 'S'),
		('T2106', 'L'),
		('T2106', 'XL'),
		('T2106', 'XXL'),
		('T2106', '3XL');

CREATE TABLE category(
	category_id INT AUTO_INCREMENT NOT NULL,
	category_name VARCHAR(255) NOT NULL,
    PRIMARY KEY (category_id)
);
INSERT category (category_id, category_name) 
VALUES 	(1, 'SHIRT'),
		(2, 'T-SHIRT'),
		(3, 'OUTERWEAR'),
		(4, 'HOODIES'),
		(5, 'SHORT&PANTS'),
		(6, 'ACCESSORIES'),
		(7, 'SWEATSHIRTS');

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
VALUES 	(1, 5, 648000.0, 'MOMO', 'Huế', '2023-04-28 16:40:00', '0919208356'),
		(2, 3, 298000.0, 'MOMO', 'Huế', '2023-04-29 08:30:00', '0888195313'),
		(3, 2, 378000.0, 'VNPAY', 'Huế', '2023-04-29 15:00:00', '0988195313'),
		(4, 4, 270000.0, 'Chua thanh toán (VNPAY)', 'Huế', '2023-05-04 14:24:26', '0383298183'),
		(5, 2, 417000.0, 'Chua thanh toán (VNPAY)', 'Huế', '2023-05-05 09:15:00', '0888195313'),
		(6, 5, 567000.0, 'COD', 'Đà Nẵng', '2023-05-07 09:00:00', '0988195563'),
		(7, 5, 278000.0, 'MOMO', 'Huế', '2023-05-08 13:00:00', '0984565123'),
		(8, 4, 189000.0, 'COD', 'Quảng Trị', '2023-05-08 15:16:17', '0352486515'),
		(9, 2, 259000.0, 'MOMO', 'Huế', '2023-05-09 08:20:00', '0919208356'),
		(10, 2, 270000.0, 'VNPAY', 'Huế', '2023-05-09 11:20:00', '0969624868');

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
VALUES  (1, 1,'T2129', 1, 'XS', 'White', 270000.0),
		(2, 2, 'T2099', 2, 'S', 'Purple', 378000.0),
		(3, 3, 'AT533', 2, 'S', 'White', 298000.0),
		(4, 4, 'T2099', 2, 'L', 'Purple', 378000.0),
		(5, 5, 'T2129', 1, 'XS', 'White', 270000.0),
		(6, 6, 'AT536', 3, 'S', 'Red', 417000.0),
		(7, 7, 'T2099', 3, 'S', 'Purple', 567000.0),
		(8, 8, 'AT536', 2, 'S', 'Red', 278000.0),
		(9, 9, 'T2099', 1, 'S', 'Purple', 189000.0),
		(10, 10, 'T2127', 1, 'L', 'Black', 259000.0);bill_detail

