CREATE TABLE `site_payment_system` (
  `id` INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `checkout_url` VARCHAR(1024) NOT NULL,
  `default_merchant_login` VARCHAR(255) NOT NULL,
  `sort_order` INTEGER UNSIGNED NOT NULL,
  `status` ENUM('ENABLED','DISABLED') NOT NULL;
  PRIMARY KEY (`id`)
)
ENGINE = MyISAM
CHARACTER SET cp1251 COLLATE cp1251_general_ci;

ALTER TABLE `site_payment_system` ADD UNIQUE INDEX `index_name`(`name`);
