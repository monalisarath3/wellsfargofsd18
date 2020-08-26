-- This file contains the db script for
-- Corona Kit Database


CREATE DATABASE coronaKitDb;

USE coronaKitDb;

CREATE TABLE productMaster(
	id int primary key,
	productName varchar(20) not null,
	costPrice decimal not null,
	productDescription varchar(20) not null
);

INSERT INTO productMaster VALUES
(1,"Mask",50,"Cloth"),
(2,"Sanitizer",100,"Liquid"),
(3,"TestKit",500,"Test it"),
(4,"Thermometer",300,"Plastic");


CREATE TABLE kit(
	id int PRIMARY KEY auto_increment,
	kitid int not null,
	productid int not null,
	quantity int not null,
	price int not null
	);
