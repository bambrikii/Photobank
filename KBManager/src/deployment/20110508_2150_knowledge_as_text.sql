ALTER TABLE `kb_materialized_knowledge` RENAME TO `kb_knowledge_as_text`;

ALTER TABLE `kb_knowledge`
	ADD COLUMN `subject_id` INTEGER UNSIGNED NOT NULL AFTER `key`,
 	ADD COLUMN `object_id` INTEGER UNSIGNED NOT NULL AFTER `subject`
;
