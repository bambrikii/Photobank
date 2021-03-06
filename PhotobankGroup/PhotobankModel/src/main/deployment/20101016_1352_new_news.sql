CREATE TABLE `_photobank_news` (
  `id` INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(255) NOT NULL,
  `content` TEXT NOT NULL,
  `time` DATETIME NOT NULL,
  `modification_time` DATETIME NOT NULL,
  `status` ENUM('PENDING','PUBLISHED','DISABLED') NOT NULL,
  PRIMARY KEY (`id`)
)
ENGINE = MyISAM;

CREATE TABLE `_photobank_news_localized` (
  `id` INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  `news_id` INTEGER UNSIGNED NOT NULL,
  `title` VARCHAR(255) NOT NULL,
  `content` TEXT NOT NULL,
  `language_id` INTEGER UNSIGNED NOT NULL,
  PRIMARY KEY (`id`)
)
ENGINE = MyISAM;
