START TRANSACTION;

-- create table `address`

CREATE TABLE IF NOT EXISTS `address` (
  `id` int(11) PRIMARY KEY AUTO_INCREMENT,
  `country` varchar(255) NOT NULL,
  `state` varchar(255) NOT NULL,
  `city` varchar(255) NOT NULL,
  `pincode` int(11) NOT NULL,
  `area` varchar(255),
  `street` varchar(255) NOT NULL,
  `created_datetime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_datetime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- create table `cart`

CREATE TABLE IF NOT EXISTS `cart` (
  `id` int(11) PRIMARY KEY AUTO_INCREMENT,
  `created_datetime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_datetime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- create table `delivery`

CREATE TABLE IF NOT EXISTS `delivery` (
  `id` int(11) PRIMARY KEY AUTO_INCREMENT,
  `status` varchar(255) NOT NULL,
  `delivered_datetime` datetime,
  `created_datetime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_datetime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- create table `feature`

CREATE TABLE IF NOT EXISTS `feature` (
  `id` int(11) PRIMARY KEY AUTO_INCREMENT,
  `color` varchar(255),
  `ram` varchar(255),
  `storage` varchar(255),
  `battery` varchar(255),
  `screen_size` varchar(255),
  `processor` varchar(255),
  `operating_system` varchar(255),
  `touch_screen` tinyint(1),
  `created_datetime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_datetime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- create table `order`

CREATE TABLE IF NOT EXISTS `order` (
  `id` int(11) PRIMARY KEY AUTO_INCREMENT,
  `created_datetime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_datetime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- create table `product`

CREATE TABLE IF NOT EXISTS `product` (
  `id` int(11) PRIMARY KEY AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `price` int(25) NOT NULL,
  `desciption` varchar(500) NOT NULL,
  `dimensions` varchar(255),
  `image_url` varchar(255) NOT NULL,
  `expected_delivery_days` int(3) NOT NULL,
  `warranty` varchar(255),
  `created_datetime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_datetime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- create table `role`

CREATE TABLE IF NOT EXISTS `role` (
  `id` int(11) PRIMARY KEY AUTO_INCREMENT,
  `type` varchar(25) NOT NULL,
  `created_datetime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_datetime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- create table `user`

CREATE TABLE IF NOT EXISTS `user` (
  `id` int(11) PRIMARY KEY AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL UNIQUE,
  `password` varchar(255) NOT NULL,
  `security_question` varchar(255) NOT NULL,
  `answer` varchar(255) NOT NULL,
  `phone` varchar(30) NOT NULL UNIQUE,
  `created_datetime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_datetime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- create table `wish_list`

CREATE TABLE IF NOT EXISTS `wish_list` (
  `id` int(11) PRIMARY KEY AUTO_INCREMENT,
  `created_datetime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_datetime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- Adding Foreign Keys

-- `cart` Table
ALTER TABLE `cart` ADD `product_id` int(11) DEFAULT NULL;
ALTER TABLE `cart` ADD CONSTRAINT fk_product_id FOREIGN KEY (`product_id`) REFERENCES `product`(id);

ALTER TABLE `cart` ADD `user_id` int(11) DEFAULT NULL;
ALTER TABLE `cart` ADD CONSTRAINT fk_user_id FOREIGN KEY (`user_id`) REFERENCES `user`(id);

-- `delivery` table
ALTER TABLE `delivery` ADD `user_id` int(11) DEFAULT NULL;
ALTER TABLE `delivery` ADD CONSTRAINT fk_user_id FOREIGN KEY (`user_id`) REFERENCES `user`(id);

ALTER TABLE `delivery` ADD `order_id` int(11) DEFAULT NULL;
ALTER TABLE `delivery` ADD CONSTRAINT fk_order_id FOREIGN KEY (`order_id`) REFERENCES `order`(id);

ALTER TABLE `delivery` ADD `address_id` int(11) DEFAULT NULL;
ALTER TABLE `delivery` ADD CONSTRAINT fk_address_id FOREIGN KEY (`address_id`) REFERENCES `address`(id);

-- `order` table
ALTER TABLE `order` ADD `user_id` int(11) DEFAULT NULL;
ALTER TABLE `order` ADD CONSTRAINT fk_user_id FOREIGN KEY (`user_id`) REFERENCES `user`(id);

ALTER TABLE `order` ADD `product_id` int(11) DEFAULT NULL;
ALTER TABLE `order` ADD CONSTRAINT fk_product_id FOREIGN KEY (`product_id`) REFERENCES `product`(id);

ALTER TABLE `order` ADD `delivery_id` int(11) DEFAULT NULL;
ALTER TABLE `order` ADD CONSTRAINT fk_delivery_id FOREIGN KEY (`delivery_id`) REFERENCES `delivery`(id);

-- `user` table
ALTER TABLE `user` ADD `role_id` int(11) DEFAULT NULL;
ALTER TABLE `user` ADD CONSTRAINT fk_role_id FOREIGN KEY (`role_id`) REFERENCES `role`(id);

ALTER TABLE `user` ADD `delivery_id` int(11) DEFAULT NULL;
ALTER TABLE `user` ADD CONSTRAINT fk_delivery_id FOREIGN KEY (`delivery_id`) REFERENCES `delivery`(id);

-- `wish_list` table
ALTER TABLE `wish_list` ADD `product_id` int(11) DEFAULT NULL;
ALTER TABLE `wish_list` ADD CONSTRAINT fk_product_id FOREIGN KEY (`product_id`) REFERENCES `product`(id);

ALTER TABLE `wish_list` ADD `user_id` int(11) DEFAULT NULL;
ALTER TABLE `wish_list` ADD CONSTRAINT fk_user_id FOREIGN KEY (`user_id`) REFERENCES `user`(id);

COMMIT;