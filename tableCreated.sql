create database PT3_database;
use PT3_database;

create table client_table(
client_id int,
firstName varchar(50),
email varchar(50),
phoneNumber varchar(10));

create table order_table(
order_id int,
client_id int,
product_id int,
qty int);

create table product_table(
product_id int,
name varchar(50),
price int,
stock int);

create table orderDetails_table(
orderDetails_id int,
orderID int,
city varchar(50),
street varchar(10));
INSERT INTO pt3_database.product VALUES (1,'salam',4,10);
INSERT INTO pt3_database.orderdetails VALUES (1,1,'cluj','tasnad');
INSERT INTO pt3_database.order VALUES (1,2,1,10);

