CREATE TABLE `t_user` (
   `user_code` varchar(30) COLLATE utf8mb4_unicode_ci DEFAULT '',
   `ent_code` varchar(30) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
   `user_name` varchar(30) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
   `phone_number` varchar(30) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
   `user_status` varchar(10) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
   `create_time` timestamp(6) NULL DEFAULT CURRENT_TIMESTAMP(6),
   `update_time` timestamp(6) NULL DEFAULT CURRENT_TIMESTAMP(6),
   PRIMARY KEY (`user_code`)
 ) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

