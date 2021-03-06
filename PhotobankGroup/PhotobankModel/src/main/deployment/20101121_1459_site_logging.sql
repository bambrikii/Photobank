CREATE TABLE `site_log_source` (
  `id` INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`)
)
ENGINE = MyISAM
CHARACTER SET utf8 COLLATE utf8_general_ci;

CREATE TABLE `site_log` (
  `id` INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(1024) NOT NULL,
  `value` TEXT NOT NULL,
  `level` INTEGER UNSIGNED NOT NULL,
  `source_id` INTEGER UNSIGNED NOT NULL,
  PRIMARY KEY (`id`)
)
ENGINE = MyISAM
CHARACTER SET utf8 COLLATE utf8_general_ci;

ALTER TABLE `site_log` MODIFY COLUMN `level` ENUM('INFO','WARNING','ERROR') NOT NULL;

ALTER TABLE `site_log` CHANGE COLUMN `value` `text` TEXT CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL;

ALTER TABLE `site_log` ADD COLUMN `time` DATETIME NOT NULL AFTER `source_id`;