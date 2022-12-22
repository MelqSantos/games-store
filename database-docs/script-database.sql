create database db_gamemania;

use db_gamemania;

create table category(
	category_id int primary key auto_increment,
	description varchar(255)
);

create table product(
	product_id int primary key auto_increment,
    category_id int,
    img_url text,
    title varchar(255),
    stars int,
    price decimal(10, 2),
    foreign key (category_id) references category(category_id)
);


create table cart(
	cart_id int primary key auto_increment,
	product_id int,
	foreign key (product_id) references product(product_id)
);

create table favorites(
	favorite_id int primary key auto_increment,
	product_id int,
	foreign key (product_id) references product(product_id)
);

-- Inserts
insert into category(description) values
('Playstation'),
('Xbox'),
('Acessórios'),
('PC'),
('Clássicos'),
('Portáteis'),
('Todos');

select * from category;

insert into product(category_id, img_url, title, stars, price) values
(5, 'https://i.imgur.com/hs9vTCt.png', 'GTA San Andreas', 5, 49.00),
(5, 'https://i.imgur.com/WkdftVy.jpg', 'Resident Evil 4', 5, 49.99),
(5, 'https://i.imgur.com/084Bhx7.png', 'Bully', 5, 49.99),
(3, 'https://i.imgur.com/QIGWRqP.jpg', 'Monitor Concórdia', 4, 1399.90),
(3, 'https://i.imgur.com/tjp6GlA.jpg', 'Headset multilaser red', 4, 199.90),
(3, 'https://i.imgur.com/vucsOo1.jpg', 'Cadeira Gamer', 5, 1199.90),
(1, 'https://i.imgur.com/prQ6yvE.jpg', 'Resident Evil Vilage', 4, 249.99),
(1, 'https://i.imgur.com/l70Ux3V.jpg', 'God of war', 5, 249.99),
(1, 'https://i.imgur.com/Mtyp6Vk.jpg', 'The last of us II', 5, 249.99);

select * from product p 
inner join category c on p.category_id = c.category_id;


