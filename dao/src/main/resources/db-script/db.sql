#系统表：以fs_开头，后面固定不变
CREATE TABLE `fs_register_enterprise` (
   `id` bigint unsigned NOT NULL AUTO_INCREMENT,
   `ent_code` varchar(30) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
   `ent_name` varchar(30) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
   `phone_number` varchar(30) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
   `ent_status` varchar(10) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
   `create_time` timestamp(6) NULL DEFAULT CURRENT_TIMESTAMP(6),
   `update_time` timestamp(6) NULL DEFAULT CURRENT_TIMESTAMP(6),
   PRIMARY KEY (`id`)
 ) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

CREATE TABLE `fs_register_table` (
   `id` bigint unsigned NOT NULL AUTO_INCREMENT,
   `ent_code` varchar(30) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
   `table_name` varchar(30) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
   `table_status` varchar(10) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
   `create_time` timestamp(6) NULL DEFAULT CURRENT_TIMESTAMP(6),
   `update_time` timestamp(6) NULL DEFAULT CURRENT_TIMESTAMP(6),
   PRIMARY KEY (`id`)
 ) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

CREATE TABLE `fs_register_table_meta` (
   `id` bigint unsigned NOT NULL AUTO_INCREMENT,
   `ent_code` varchar(30) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
   `table_name` varchar(30) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
   `table_status` varchar(10) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
   `create_time` timestamp(6) NULL DEFAULT CURRENT_TIMESTAMP(6),
   `update_time` timestamp(6) NULL DEFAULT CURRENT_TIMESTAMP(6),
   PRIMARY KEY (`id`)
 ) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

#客户业务表：以t_开头，业务固定表在中间，以动态ent_code结尾
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

