CREATE DATABASE IF NOT EXISTS `demo`;

USE `demo`;

CREATE TABLE IF NOT EXISTS `permissions` (
    `id` BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT,
    `permissionname` VARCHAR(50) NOT NULL,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='Permission table';

INSERT INTO `permissions` (`permissionname`) VALUES ('admin'), ('assistant'), ('consumer');

SELECT * FROM `permissions`;