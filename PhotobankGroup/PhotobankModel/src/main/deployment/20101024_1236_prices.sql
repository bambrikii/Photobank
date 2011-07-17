CREATE TABLE `site_item_price` (
  `id` INTEGER UNSIGNED NOT NULL,
  `value` FLOAT  NOT NULL,
  PRIMARY KEY (`id`)
)
ENGINE = MyISAM;

CREATE TABLE `site_product` (
  `id` INTEGER UNSIGNED NOT NULL
)
ENGINE = MyISAM;

ALTER TABLE `_photobank_file_size`
	ADD COLUMN `product_id` INTEGER UNSIGNED NOT NULL AFTER `max_dim`;

DROP TABLE `_photobank_file_size_price`;

ALTER TABLE `site_item_price`
	ADD COLUMN `currency_id` INTEGER  NOT NULL AFTER `value`,
	ADD COLUMN `product_id` INTEGER  NOT NULL AFTER `currency_id`
;

ALTER TABLE `_photobank_file_size`
	MODIFY COLUMN `id` INTEGER UNSIGNED NOT NULL AUTO_INCREMENT
;

ALTER TABLE `site_product`
	ADD PRIMARY KEY (`id`)
;


ALTER TABLE `site_product`
	ADD COLUMN `name` VARCHAR(255)  NOT NULL AFTER `id`,
	ADD COLUMN `active` BOOLEAN  NOT NULL AFTER `name`
;

ALTER TABLE `_photobank_file_size`
	DROP COLUMN `name`,
	DROP COLUMN `_active`
;

ALTER TABLE `site_product`
	MODIFY COLUMN `id` INTEGER UNSIGNED NOT NULL AUTO_INCREMENT
;

ALTER TABLE `site_item_price`
	MODIFY COLUMN `id` INTEGER UNSIGNED NOT NULL AUTO_INCREMENT
;

ALTER TABLE `_photobank_order`
	ADD COLUMN `comment` VARCHAR(512)  NOT NULL AFTER `order_id`
;

ALTER TABLE `_photobank_order`
	MODIFY COLUMN `comment` VARCHAR(512) DEFAULT NULL
;
