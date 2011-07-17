CREATE TABLE  `site_user_phone` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `user_id` int(10) unsigned DEFAULT NULL,
  `number` varchar(128) DEFAULT NULL,
  `phone_type` ENUM('MAIN', 'HOME','MOBILE','WORK') DEFAULT 'MAIN',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=cp1251;
