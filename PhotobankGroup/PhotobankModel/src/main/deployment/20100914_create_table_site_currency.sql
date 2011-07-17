CREATE TABLE `site_currency` (
  `id` INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  `code` VARCHAR(45) NOT NULL,
  `name` VARCHAR(255) NOT NULL,
  `sign` VARCHAR(1),
  `order` INTEGER UNSIGNED,
  `active` BOOLEAN NOT NULL DEFAULT true,
  PRIMARY KEY (`id`)
)
ENGINE = MyISAM
CHARACTER SET cp1251 COLLATE cp1251_general_ci;

insert into `site_currency` (`name`, `active`, `code`, `sign`, `order`) values ('US Dollar', 1, 'USD', '$', 10);
insert into `site_currency` (`name`, `active`, `code`, `sign`, `order`) values ('Euro', 1, 'EUR', 'E', 20);
insert into `site_currency` (`name`, `active`, `code`, `sign`, `order`) values ('Russian Ruble', 1, 'RUR', 'R', 30);