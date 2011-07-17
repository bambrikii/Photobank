ALTER TABLE `_photobank_transactions` RENAME TO `site_order`;

ALTER TABLE `_photobank_transaction_files` RENAME TO `site_order_item`;
ALTER TABLE `site_order_item` ENGINE = MyISAM ROW_FORMAT = DYNAMIC;

CREATE TABLE `_photobank_order_item` (
  `id` INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  `order_item_id` INTEGER UNSIGNED NOT NULL,
  `file_id` INTEGER UNSIGNED NOT NULL,
  `file_dimension_id` INTEGER UNSIGNED NOT NULL,
  PRIMARY KEY (`id`)
)
ENGINE = MyISAM;

ALTER TABLE `site_order_item` DROP COLUMN `file_size_id`, DROP COLUMN `file_id`;

CREATE TABLE `_photobank_order` (
  `id` INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  `order_id` INTEGER UNSIGNED NOT NULL,
  PRIMARY KEY (`id`)
)
ENGINE = MyISAM;

ALTER TABLE `site_order_item` CHANGE COLUMN `transaction_id` `order_id` INT(11) NOT NULL DEFAULT 0;
