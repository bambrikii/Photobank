ALTER TABLE `kb_artefact_relation`
	CHANGE COLUMN `target_id` `destination_id`
		INT(10)
		UNSIGNED
		NOT NULL
;

ALTER TABLE `kb_artefact_as_image`
	MODIFY COLUMN `id` INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
	ADD COLUMN `artefact_id` INTEGER UNSIGNED NOT NULL AFTER `bytes`;
