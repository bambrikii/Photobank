ALTER TABLE `site_order` MODIFY COLUMN `status` ENUM('NEW','CONFIRMED_BY_CLIENT','PENDING','APPROVED','REJECTED','CANCELLED') DEFAULT 'NEW';