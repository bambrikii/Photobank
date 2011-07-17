ALTER TABLE `_photobank_categories` MODIFY COLUMN `id_category_type` ENUM('MAIN','MAIN_NEWS','DEFAULT','SEARCH_RESTRICTED','MAIN_EVENT') DEFAULT 'DEFAULT';

UPDATE `_photobank_categories` SET `id_category_type` = 'MAIN_EVENT' WHERE `id_category_type` = 'MAIN_NEWS';

ALTER TABLE `_photobank_news` RENAME TO `_photobank_event`;
ALTER TABLE `_photobank_news_description` RENAME TO `_photobank_event_description`;
ALTER TABLE `_photobank_news_file` RENAME TO `_photobank_event_file`;

UPDATE `site_configuration` SET `name` = '.ru.psfotos.events.briefListMaxRecordsCount' where `name` = '.ru.psfotos.news.briefListMaxRecordsCount';