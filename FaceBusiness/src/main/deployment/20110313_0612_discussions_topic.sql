CREATE TABLE `face_topic` (
  `id` INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(1024) NOT NULL,
  `parent_id` INTEGER UNSIGNED NOT NULL,
  `status` ENUM('OPEN','READONLY','CLOSED') NOT NULL DEFAULT 'OPEN',
  `modification_time` DATETIME NOT NULL,
  PRIMARY KEY (`id`)
)
ENGINE = MyISAM
CHARACTER SET utf8 COLLATE utf8_general_ci;


CREATE TABLE `face_message` (
  `id` INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(1024) NOT NULL,
  `text` TEXT NOT NULL,
  `status` ENUM('PUBLISHED') NOT NULL,
  `author_user_id` INTEGER UNSIGNED NOT NULL,
  `topic_id` INTEGER UNSIGNED NOT NULL,
  `modification_time` DATETIME NOT NULL,
  PRIMARY KEY (`id`)
)
ENGINE = MyISAM
CHARACTER SET utf8 COLLATE utf8_general_ci;

ALTER TABLE `face_topic` ADD COLUMN `author_user_id` INTEGER UNSIGNED NOT NULL AFTER `modification_time`;
ALTER TABLE `face_message` ADD COLUMN `parent_id` INTEGER UNSIGNED NOT NULL AFTER `modification_time`;
ALTER TABLE `face_message` MODIFY COLUMN `parent_id` INT(10) UNSIGNED DEFAULT NULL;
ALTER TABLE `face_message` RENAME TO `face_discussions_message`;
ALTER TABLE `face_topic` RENAME TO `face_discussions_topic`;
ALTER TABLE `face_discussions_topic` MODIFY COLUMN `parent_id` INT(10) UNSIGNED DEFAULT NULL;
ALTER TABLE `face_discussions_message` MODIFY COLUMN `topic_id` INT(10) UNSIGNED DEFAULT NULL;
