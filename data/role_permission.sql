CREATE DATABASE IF NOT EXISTS `demo`;

USE `demo`;

CREATE TABLE IF NOT EXISTS `role_permission` (
    `id` BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT,
    `rid` BIGINT(20) NOT NULL,
    `pid` BIGINT(20) NOT NULL,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='Role-Permission table';

INSERT INTO `role_permission` (`rid`, `pid`) VALUES 
(1, 1), (1, 2), (1, 3),
(2, 1), (2, 2), (3, 1);

SELECT * FROM `role_permission`;