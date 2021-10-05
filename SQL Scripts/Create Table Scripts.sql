/*create user table*/
CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `security_question` varchar(255) NOT NULL,
  `phone` varchar(30) NOT NULL,
  `created_datetime` datetime NOT NULL DEFAULT current_timestamp(),
  `updated_datetime` datetime NOT NULL DEFAULT current_timestamp(),
  `role_id` int(11) DEFAULT NULL,
  `delivery_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

ALTER TABLE `user`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `email_unique` (`email`),
  ADD UNIQUE KEY `phone_unique` (`phone`);

ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;


/*create role table*/



/*create product table*/



/*create address table*/



/*create other table*/


