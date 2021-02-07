CREATE DATABASE IF NOT EXISTS `school`;

USE `school`;

CREATE TABLE IF NOT EXISTS `roles` (
    `id`   BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(50) NOT NULL,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='Role table';

INSERT INTO `roles` (name) VALUES
('admin'),
('super'),
('normal');

SELECT * FROM `roles` LIMIT 30;