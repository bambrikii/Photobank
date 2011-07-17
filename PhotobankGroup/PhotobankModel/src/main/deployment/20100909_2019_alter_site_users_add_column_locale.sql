ALTER TABLE `site_languages` ADD COLUMN `locale` VARCHAR(45) ;
UPDATE `site_languages` SET `locale` = 'en' WHERE `name` = 'english';
UPDATE `site_languages` SET `locale` = 'ru' WHERE `name` = 'russian';

ALTER TABLE `site_users` ADD COLUMN `language_id` INTEGER UNSIGNED;
