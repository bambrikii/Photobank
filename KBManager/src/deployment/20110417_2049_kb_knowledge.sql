ALTER TABLE `kb_knowledge` CHANGE COLUMN `name` `key` VARCHAR(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL;

CREATE TABLE `kb_materialized_knowledge` (
  `id` INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  `knowledge_id` INTEGER UNSIGNED NOT NULL,
  `title` VARCHAR(255) NOT NULL,
  `content` TEXT NOT NULL,
  PRIMARY KEY (`id`)
)
ENGINE = MyISAM
CHARACTER SET utf8 COLLATE utf8_general_ci;
