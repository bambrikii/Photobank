CREATE TABLE `_photobank_file_size_price` (
  `id` INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  `file_size_id` INTEGER UNSIGNED NOT NULL, 
  `currency_id` INTEGER UNSIGNED NOT NULL,
  `value` FLOAT NOT NULL,
  PRIMARY KEY (`id`)
)
ENGINE = MyISAM
CHARACTER SET cp1251 COLLATE cp1251_general_ci;