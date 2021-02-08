CREATE DATABASE IF NOT EXISTS `demo`;

USE `demo`;

CREATE TABLE IF NOT EXISTS `user_role` (
    `id` BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT,
    `uid` BIGINT(20) NOT NULL,
    `rid` BIGINT(20) NOT NULL,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='User-Role table';

INSERT INTO `user_role` (`uid`, `rid`) VALUES (1, 1), (2, 2), (3, 3);

SELECT * FROM `user_role`;