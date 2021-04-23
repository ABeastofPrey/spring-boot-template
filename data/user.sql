CREATE DATABASE IF NOT EXISTS `demo`;

USE `demo`;

DROP TABLE IF EXISTS `users`;

CREATE TABLE IF NOT EXISTS `users` (
    `id` BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT,
    `username` VARCHAR(50) NOT NULL,
    `password` VARCHAR(60) NOT NULL,
    `phone` BIGINT(11),
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='User table';

INSERT INTO `users` (`username`, `password`, `phone`) VALUES 
('USER 0', '$2a$10$EmsokMb6Vkav7m61kY0PtO.ZCLe0h.uJqVAZW7YYBpSUxd/DMkZuG', 13585845436), -- password is crypted from 123456 by BCryptPasswordEncoder
('USER 1', 'admin1', 13585845432), 
('USER 2', 'admin2', 13584854321), 
('USER 3', 'admin3', 13884832812);

SELECT * FROM `users`;