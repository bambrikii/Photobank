ALTER TABLE `_photobank_accounts` MODIFY COLUMN `id` INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
 MODIFY COLUMN `surname` VARCHAR(45) NOT NULL,
 MODIFY COLUMN `firstname` VARCHAR(45) NOT NULL,
 MODIFY COLUMN `secondname` VARCHAR(45) NOT NULL
, CHARACTER SET utf8 COLLATE utf8_general_ci;


ALTER TABLE `_photobank_authors` MODIFY COLUMN `id` INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
 MODIFY COLUMN `surname` VARCHAR(45) NOT NULL,
 MODIFY COLUMN `firstname` VARCHAR(45) NOT NULL,
 MODIFY COLUMN `secondname` VARCHAR(45) NOT NULL,
 MODIFY COLUMN `organization` VARCHAR(45) NOT NULL,
 MODIFY COLUMN `personal_number` VARCHAR(45) DEFAULT NULL,
 MODIFY COLUMN `personal_photo` VARCHAR(255) DEFAULT NULL,
 MODIFY COLUMN `favourite_image` VARCHAR(255) DEFAULT NULL,
 MODIFY COLUMN `about` TEXT DEFAULT NULL
, CHARACTER SET utf8 COLLATE utf8_general_ci;


ALTER TABLE `_photobank_authors_best_files` CHARACTER SET utf8 COLLATE utf8_general_ci;


ALTER TABLE `_photobank_authors_description` CHARACTER SET utf8 COLLATE utf8_general_ci;


ALTER TABLE `_photobank_authors_description` MODIFY COLUMN `id` INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
 MODIFY COLUMN `surname` VARCHAR(45) NOT NULL,
 MODIFY COLUMN `firstname` VARCHAR(45) NOT NULL,
 MODIFY COLUMN `secondname` VARCHAR(45) NOT NULL,
 MODIFY COLUMN `about` TEXT NOT NULL
, CHARACTER SET utf8 COLLATE utf8_general_ci;


ALTER TABLE `_photobank_categories` MODIFY COLUMN `description` VARCHAR(255) NOT NULL,
 MODIFY COLUMN `id_category_type` ENUM('MAIN','MAIN_NEWS','DEFAULT','SEARCH_RESTRICTED','MAIN_EVENT') DEFAULT 'DEFAULT'
, CHARACTER SET utf8 COLLATE utf8_general_ci;



ALTER TABLE `_photobank_categories_description` MODIFY COLUMN `description` VARCHAR(255) NOT NULL
, CHARACTER SET utf8 COLLATE utf8_general_ci;



ALTER TABLE `_photobank_categories_types` MODIFY COLUMN `name` VARCHAR(255) NOT NULL
, CHARACTER SET utf8 COLLATE utf8_general_ci;


ALTER TABLE `_photobank_customers` MODIFY COLUMN `id` INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
 MODIFY COLUMN `surname` VARCHAR(45) NOT NULL,
 MODIFY COLUMN `firstname` VARCHAR(45) NOT NULL,
 MODIFY COLUMN `organization` VARCHAR(255) NOT NULL,
 MODIFY COLUMN `address` VARCHAR(255) NOT NULL,
 MODIFY COLUMN `miscelaneous_info` VARCHAR(255) NOT NULL,
 MODIFY COLUMN `email` VARCHAR(125) NOT NULL
, CHARACTER SET utf8 COLLATE utf8_general_ci;

 
ALTER TABLE `_photobank_event` MODIFY COLUMN `id_photobank_news` INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
 MODIFY COLUMN `text` TEXT NOT NULL,
 MODIFY COLUMN `-title` TEXT DEFAULT NULL
, CHARACTER SET utf8 COLLATE utf8_general_ci;



ALTER TABLE `_photobank_event_description` MODIFY COLUMN `text` TEXT NOT NULL,
 MODIFY COLUMN `title` TEXT NOT NULL
, CHARACTER SET utf8 COLLATE utf8_general_ci;




ALTER TABLE `_photobank_event_file` CHARACTER SET utf8 COLLATE utf8_general_ci;

ALTER TABLE `_photobank_file_categories` CHARACTER SET utf8 COLLATE utf8_general_ci;

ALTER TABLE `_photobank_file_content` MODIFY COLUMN `id` INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
 MODIFY COLUMN `file_id` INTEGER UNSIGNED NOT NULL,
 MODIFY COLUMN `name` VARCHAR(255) NOT NULL,
 MODIFY COLUMN `data` BLOB NOT NULL
, CHARACTER SET utf8 COLLATE utf8_general_ci;


ALTER TABLE `_photobank_file_dimensions` MODIFY COLUMN `id` INTEGER UNSIGNED NOT NULL AUTO_INCREMENT
, CHARACTER SET utf8 COLLATE utf8_general_ci;


ALTER TABLE `_photobank_file_iptc` MODIFY COLUMN `GroupName` VARCHAR(255) NOT NULL
, CHARACTER SET utf8 COLLATE utf8_general_ci;


ALTER TABLE `_photobank_file_iptc_field` MODIFY COLUMN `ID` INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
 MODIFY COLUMN `Name` VARCHAR(255) NOT NULL,
 MODIFY COLUMN `Value` VARCHAR(3048) NOT NULL
, CHARACTER SET utf8 COLLATE utf8_general_ci;


ALTER TABLE `_photobank_file_size` CHARACTER SET utf8 COLLATE utf8_general_ci;


ALTER TABLE `_photobank_files` MODIFY COLUMN `description` VARCHAR(127) NOT NULL,
 MODIFY COLUMN `file_name` VARCHAR(255) NOT NULL
, CHARACTER SET utf8 COLLATE utf8_general_ci;


ALTER TABLE `_photobank_files_transactions` CHARACTER SET utf8 COLLATE utf8_general_ci;


ALTER TABLE `_photobank_legalowner` MODIFY COLUMN `Name` VARCHAR(45) NOT NULL,
 MODIFY COLUMN `IPTCMarker1` VARCHAR(45) NOT NULL,
 MODIFY COLUMN `HomePage` VARCHAR(255) NOT NULL,
 MODIFY COLUMN `IPTCMarker2` VARCHAR(45) NOT NULL,
 MODIFY COLUMN `IPTCMarker2Name` VARCHAR(45) DEFAULT NULL,
 DROP PRIMARY KEY,
 ADD PRIMARY KEY (`ID`)
, CHARACTER SET utf8 COLLATE utf8_general_ci;



ALTER TABLE `_photobank_magazine_edition` MODIFY COLUMN `name` VARCHAR(255) NOT NULL
, CHARACTER SET utf8 COLLATE utf8_general_ci;



ALTER TABLE `_photobank_magazine_number` MODIFY COLUMN `name` VARCHAR(255) NOT NULL
, CHARACTER SET utf8 COLLATE utf8_general_ci;



ALTER TABLE `_photobank_news` MODIFY COLUMN `id` INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
 MODIFY COLUMN `title` VARCHAR(255) NOT NULL,
 MODIFY COLUMN `content` TEXT NOT NULL,
 MODIFY COLUMN `time` DATETIME NOT NULL,
 MODIFY COLUMN `modification_time` DATETIME NOT NULL,
 MODIFY COLUMN `status` ENUM('PENDING','PUBLISHED','DISABLED') NOT NULL
, CHARACTER SET utf8 COLLATE utf8_general_ci;



ALTER TABLE `_photobank_news_localized` MODIFY COLUMN `id` INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
 MODIFY COLUMN `news_id` INTEGER UNSIGNED NOT NULL,
 MODIFY COLUMN `title` VARCHAR(255) NOT NULL,
 MODIFY COLUMN `content` TEXT NOT NULL,
 MODIFY COLUMN `language_id` INTEGER UNSIGNED NOT NULL
, CHARACTER SET utf8 COLLATE utf8_general_ci;



ALTER TABLE `_photobank_order` MODIFY COLUMN `id` INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
 MODIFY COLUMN `order_id` INTEGER UNSIGNED NOT NULL,
 MODIFY COLUMN `comment` VARCHAR(512) CHARACTER SET utf8 COLLATE utf8_general_ci;

 
 ALTER TABLE `_photobank_order_item` MODIFY COLUMN `id` INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
 MODIFY COLUMN `order_item_id` INTEGER UNSIGNED NOT NULL,
 MODIFY COLUMN `file_id` INTEGER UNSIGNED NOT NULL,
 MODIFY COLUMN `file_dimension_id` INTEGER UNSIGNED NOT NULL
, CHARACTER SET utf8 COLLATE utf8_general_ci;




ALTER TABLE `_photobank_persons` MODIFY COLUMN `surname` VARCHAR(45) NOT NULL,
 MODIFY COLUMN `firstname` VARCHAR(45) NOT NULL,
 MODIFY COLUMN `secondname` VARCHAR(45) NOT NULL,
 DROP PRIMARY KEY,
 ADD PRIMARY KEY (`id`)
, CHARACTER SET utf8 COLLATE utf8_general_ci;



ALTER TABLE `_photobank_transaction_customer_info` MODIFY COLUMN `organization` VARCHAR(255) DEFAULT NULL,
 MODIFY COLUMN `email` VARCHAR(255) NOT NULL
, CHARACTER SET utf8 COLLATE utf8_general_ci;

ALTER TABLE `_photobank_transaction_customer_info` MODIFY COLUMN `id` INTEGER NOT NULL AUTO_INCREMENT,
 MODIFY COLUMN `email` VARCHAR(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL;

 
 ALTER TABLE `_photobank_transaction_file_property` MODIFY COLUMN `id` INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
 MODIFY COLUMN `name` VARCHAR(255) NOT NULL,
 MODIFY COLUMN `value` VARCHAR(255),
 MODIFY COLUMN `transaction_file_id` INTEGER UNSIGNED NOT NULL
, ENGINE = MyISAM
CHARACTER SET utf8 COLLATE utf8_general_ci
ROW_FORMAT = DYNAMIC;




ALTER TABLE `_photobank_transaction_magazine_properties` MODIFY COLUMN `magazine_edition_miscInfo` VARCHAR(255) DEFAULT NULL
, CHARACTER SET utf8 COLLATE utf8_general_ci;



ALTER TABLE `_photobank_uploaded_files` MODIFY COLUMN `file_name` VARCHAR(255) NOT NULL,
 DROP PRIMARY KEY,
 ADD PRIMARY KEY (`uploaded_file_id`)
, CHARACTER SET utf8 COLLATE utf8_general_ci;


ALTER TABLE `_photobank_uploaded_files` DROP PRIMARY KEY,
 ADD PRIMARY KEY  USING BTREE(`uploaded_file_id`);

 
ALTER TABLE `guestbook_message` MODIFY COLUMN `author_name` VARCHAR(255) NOT NULL,
 MODIFY COLUMN `email` VARCHAR(255) NOT NULL,
 MODIFY COLUMN `message` TEXT DEFAULT NULL
, CHARACTER SET utf8 COLLATE utf8_general_ci;



ALTER TABLE `site_action_results` MODIFY COLUMN `site_action_result_description` VARCHAR(45) NOT NULL,
 DROP PRIMARY KEY,
 ADD PRIMARY KEY (`site_action_result_id`)
, CHARACTER SET utf8 COLLATE utf8_general_ci;



ALTER TABLE `site_actions` MODIFY COLUMN `site_action_description` VARCHAR(45) NOT NULL,
 DROP PRIMARY KEY,
 ADD PRIMARY KEY  USING BTREE(`site_action_id`)
, CHARACTER SET utf8 COLLATE utf8_general_ci;



ALTER TABLE `site_announces` MODIFY COLUMN `site_announce_id` INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
 MODIFY COLUMN `site_announce_content` TEXT NOT NULL,
 MODIFY COLUMN `site_announce_title` VARCHAR(45) NOT NULL,
 DROP PRIMARY KEY,
 ADD PRIMARY KEY (`site_announce_id`)
, CHARACTER SET utf8 COLLATE utf8_general_ci;




ALTER TABLE `site_banners` MODIFY COLUMN `site_banner_url` TEXT NOT NULL,
 MODIFY COLUMN `id_site_banner_owner` TEXT DEFAULT NULL,
 DROP PRIMARY KEY,
 ADD PRIMARY KEY  USING BTREE(`site_banner_id`)
, CHARACTER SET utf8 COLLATE utf8_general_ci;



ALTER TABLE `site_banners_clicks` DROP PRIMARY KEY,
 ADD PRIMARY KEY  USING BTREE(`site_click_id`)
, CHARACTER SET utf8 COLLATE utf8_general_ci;




ALTER TABLE `site_banners_groups` MODIFY COLUMN `site_banners_group_description` VARCHAR(45) NOT NULL,
 DROP PRIMARY KEY,
 ADD PRIMARY KEY  USING BTREE(`site_banners_group_id`)
, CHARACTER SET utf8 COLLATE utf8_general_ci;


ALTER TABLE `site_banners_groups` MODIFY COLUMN `site_banners_group_id` INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
 MODIFY COLUMN `site_banners_group_description` VARCHAR(45) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL;

 
ALTER TABLE `site_banners_owners` MODIFY COLUMN `site_banner_owner_id` INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
 MODIFY COLUMN `site_banner_owner_title` VARCHAR(255) NOT NULL,
 DROP PRIMARY KEY,
 ADD PRIMARY KEY  USING BTREE(`site_banner_owner_id`)
, CHARACTER SET utf8 COLLATE utf8_general_ci;



ALTER TABLE `site_configuration` MODIFY COLUMN `id` INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
 MODIFY COLUMN `name` VARCHAR(255) NOT NULL,
 MODIFY COLUMN `value` VARCHAR(255) NOT NULL
, CHARACTER SET utf8 COLLATE utf8_general_ci;


update site_currency set `order` = 0 where `order` is null;

ALTER TABLE `site_currency` MODIFY COLUMN `name` VARCHAR(255) NOT NULL,
 MODIFY COLUMN `code` VARCHAR(45) NOT NULL,
 MODIFY COLUMN `sign` VARCHAR(150),
 MODIFY COLUMN `order` INTEGER UNSIGNED NOT NULL DEFAULT 0
, CHARACTER SET utf8 COLLATE utf8_general_ci;


 
ALTER TABLE `site_email_template` MODIFY COLUMN `id` INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
 MODIFY COLUMN `key` VARCHAR(45) NOT NULL,
 MODIFY COLUMN `subject` VARCHAR(255) NOT NULL,
 MODIFY COLUMN `body` TEXT,
 MODIFY COLUMN `content_type` ENUM('TEXT_PLAIN','TEXT_HTML') NOT NULL DEFAULT 'TEXT_PLAIN'
, CHARACTER SET utf8 COLLATE utf8_general_ci;



ALTER TABLE `site_groups` MODIFY COLUMN `name` VARCHAR(45) NOT NULL,
 MODIFY COLUMN `passwd` VARCHAR(45)
, CHARACTER SET utf8 COLLATE utf8_general_ci;



ALTER TABLE `site_groups_privileges` CHARACTER SET utf8 COLLATE utf8_general_ci;


ALTER TABLE `site_item_price` CHARACTER SET utf8 COLLATE utf8_general_ci;



ALTER TABLE `site_languages` MODIFY COLUMN `name` VARCHAR(128) NOT NULL,
 MODIFY COLUMN `sub_url` VARCHAR(128) NOT NULL,
 MODIFY COLUMN `character_encoding` VARCHAR(50) NOT NULL,
 MODIFY COLUMN `locale` VARCHAR(45) NOT NULL,
 DROP PRIMARY KEY,
 ADD PRIMARY KEY (`site_language_id`)
, CHARACTER SET utf8 COLLATE utf8_general_ci;



ALTER TABLE `site_log_queries` MODIFY COLUMN `site_log_query_id` INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
 MODIFY COLUMN `query` TEXT NOT NULL,
 MODIFY COLUMN `description` TEXT NOT NULL,
 DROP PRIMARY KEY,
 ADD PRIMARY KEY (`site_log_query_id`)
, CHARACTER SET utf8 COLLATE utf8_general_ci;


ALTER TABLE `site_menuitem` MODIFY COLUMN `name` VARCHAR(255) NOT NULL,
 MODIFY COLUMN `reMatch` VARCHAR(255) NOT NULL
, CHARACTER SET utf8 COLLATE utf8_general_ci
ROW_FORMAT = DYNAMIC;



ALTER TABLE `site_menuroot` MODIFY COLUMN `id` INTEGER NOT NULL AUTO_INCREMENT,
 MODIFY COLUMN `name` VARCHAR(255) NOT NULL,
 MODIFY COLUMN `reMatch` VARCHAR(255) NOT NULL
, CHARACTER SET utf8 COLLATE utf8_general_ci
ROW_FORMAT = DYNAMIC;



ALTER TABLE `site_menutype` CHARACTER SET utf8 COLLATE utf8_general_ci
ROW_FORMAT = DYNAMIC;



ALTER TABLE `site_order` CHARACTER SET utf8 COLLATE utf8_general_ci;

ALTER TABLE `site_order` MODIFY COLUMN `ip` VARCHAR(128) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL;

ALTER TABLE `site_order_item` MODIFY COLUMN `name` VARCHAR(255) NOT NULL
, CHARACTER SET utf8 COLLATE utf8_general_ci


ALTER TABLE `site_payment_system` MODIFY COLUMN `id` INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
 MODIFY COLUMN `name` VARCHAR(45) NOT NULL,
 MODIFY COLUMN `checkout_url` VARCHAR(1024) NOT NULL,
 MODIFY COLUMN `status` ENUM('ENABLED','DISABLED') NOT NULL,
 MODIFY COLUMN `default_merchant_login` VARCHAR(255) NOT NULL,
 MODIFY COLUMN `sort_order` INTEGER UNSIGNED NOT NULL
, CHARACTER SET utf8 COLLATE utf8_general_ci;



ALTER TABLE `site_phrases_keywords` MODIFY COLUMN `keyword` VARCHAR(255) NOT NULL,
 DROP PRIMARY KEY,
 ADD PRIMARY KEY (`site_phrase_keyword_id`)
, CHARACTER SET utf8 COLLATE utf8_general_ci;



ALTER TABLE `site_phrases_translated` MODIFY COLUMN `translation` TEXT NOT NULL,
 DROP PRIMARY KEY,
 ADD PRIMARY KEY  USING BTREE(`site_phrase_translated_id`)
, CHARACTER SET utf8 COLLATE utf8_general_ci;



ALTER TABLE `site_privileges` MODIFY COLUMN `site_privilege_id` INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
 MODIFY COLUMN `name` VARCHAR(15) NOT NULL
, CHARACTER SET utf8 COLLATE utf8_general_ci;



ALTER TABLE `site_product` MODIFY COLUMN `id` INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
 MODIFY COLUMN `name` VARCHAR(255) NOT NULL,
 MODIFY COLUMN `active` TINYINT(1) NOT NULL
, CHARACTER SET utf8 COLLATE utf8_general_ci;


ALTER TABLE `site_user_group` CHARACTER SET utf8 COLLATE utf8_general_ci;



ALTER TABLE `site_user_phone` MODIFY COLUMN `number` VARCHAR(128) DEFAULT NULL,
 MODIFY COLUMN `phone_type` ENUM('MAIN','HOME','MOBILE','WORK') DEFAULT 'MAIN'
, CHARACTER SET utf8 COLLATE utf8_general_ci;



ALTER TABLE `site_users` MODIFY COLUMN `id` INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
 MODIFY COLUMN `name` VARCHAR(45) NOT NULL,
 MODIFY COLUMN `passwd` VARCHAR(45) NOT NULL,
 MODIFY COLUMN `email` VARCHAR(45) NOT NULL,
 MODIFY COLUMN `address` VARCHAR(150) NOT NULL,
 MODIFY COLUMN `surname` VARCHAR(45) NOT NULL,
 MODIFY COLUMN `firstname` VARCHAR(45),
 MODIFY COLUMN `organization` VARCHAR(45),
 MODIFY COLUMN `sort_of_activity` VARCHAR(255) NOT NULL,
 MODIFY COLUMN `position` VARCHAR(255),
 MODIFY COLUMN `about` TEXT,
 MODIFY COLUMN `passwd_sha1` VARCHAR(41),
 MODIFY COLUMN `language_id` INTEGER UNSIGNED,
 MODIFY COLUMN `status` ENUM('DISABLED','WAITING_CONSIDERATION','ENABLED') NOT NULL DEFAULT 'WAITING_CONSIDERATION'
, CHARACTER SET utf8 COLLATE utf8_general_ci;




ALTER TABLE `user_privilege` MODIFY COLUMN `user_name` VARCHAR(45) DEFAULT NULL,
 MODIFY COLUMN `group_name` VARCHAR(45) DEFAULT NULL,
 MODIFY COLUMN `privilege_name` VARCHAR(15) DEFAULT NULL
, CHARACTER SET utf8 COLLATE utf8_general_ci;


















 