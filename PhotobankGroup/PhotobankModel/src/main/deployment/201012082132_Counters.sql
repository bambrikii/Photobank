CREATE TABLE `site_counter` (
  `id` INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  `time` DATETIME NOT NULL,
  PRIMARY KEY (`id`)
)
ENGINE = MyISAM
CHARACTER SET utf8 COLLATE utf8_general_ci;


CREATE TABLE `_photobank_file_preview_counter` (
  `id` INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  `counter_id` INTEGER UNSIGNED NOT NULL,
  `file_id` INTEGER UNSIGNED NOT NULL,
  PRIMARY KEY (`id`)
)
ENGINE = MyISAM
CHARACTER SET utf8 COLLATE utf8_general_ci;
