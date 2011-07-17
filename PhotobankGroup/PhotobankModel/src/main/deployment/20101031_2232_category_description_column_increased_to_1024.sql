ALTER TABLE `_photobank_categories` MODIFY COLUMN `description` VARCHAR(330)  CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL;
ALTER TABLE `_photobank_files` MODIFY COLUMN `description` VARCHAR(3000)  CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL;
