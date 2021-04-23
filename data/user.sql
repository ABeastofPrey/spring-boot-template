CREATE DATABASE IF NOT EXISTS `demo`;

USE `demo`;

DROP TABLE IF EXISTS `users`;

CREATE TABLE IF NOT EXISTS `users` (
    `id` BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT,
    `username` VARCHAR(50) NOT NULL,
    `password` VARCHAR(50) NOT NULL,
    `phone` BIGINT(11),
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='User table';

INSERT INTO `users` (`username`, `password`, `phone`) VALUES 
('USER 0', '123456', 13585845436),
('USER 1', 'admin1', 13585845432), 
('USER 2', 'admin2', 13584854321), 
('USER 3', 'admin3', 13884832812);

SELECT * FROM `users`;