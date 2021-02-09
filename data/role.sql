CREATE DATABASE IF NOT EXISTS `demo`;

USE `demo`;

CREATE TABLE IF NOT EXISTS `roles` (
    `id`   BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT,
    `rolename` VARCHAR(50) NOT NULL,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='Role table';

INSERT INTO `roles` (`rolename`) VALUES
('admin'),
('assistant'),
('consumer');

SELECT * FROM `roles` LIMIT 30;