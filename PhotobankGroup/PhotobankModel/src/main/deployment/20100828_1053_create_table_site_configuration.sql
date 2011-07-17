CREATE TABLE `photobank_test`.`site_configuration` (
  `id` INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NOT NULL,
  `value` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `index_2_name`(`name`)
)
ENGINE = MyISAM
CHARACTER SET cp1251 COLLATE cp1251_general_ci;