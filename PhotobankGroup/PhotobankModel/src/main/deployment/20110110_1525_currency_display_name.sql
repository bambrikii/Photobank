ALTER TABLE `site_currency` ADD COLUMN `display_name` VARCHAR(72) NOT NULL AFTER `order`;
update site_currency set `display_name` = `name`;
update site_currency set `display_name` = 'RUR' where `code` = 'OceanBankR';
