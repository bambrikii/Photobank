ALTER TABLE `_photobank_categories`
	MODIFY COLUMN `id_category_type` VARCHAR(17)
		CHARACTER SET cp1251 COLLATE cp1251_general_ci
		DEFAULT 2
;

		
UPDATE _photobank_categories
	SET id_category_type =
		CASE
			WHEN id_category_type='1' THEN 'MAIN'
			WHEN id_category_type='2' THEN 'DEFAULT'
			WHEN id_category_type='3' THEN 'SEARCH_RESTRICTED'
			ELSE 'DEFAULT'
		END
;


ALTER TABLE `personastars`.`_photobank_categories`
	MODIFY COLUMN `id_category_type`
		ENUM('MAIN','MAIN_NEWS','DEFAULT','SEARCH_RESTRICTED') DEFAULT 'DEFAULT'
;
