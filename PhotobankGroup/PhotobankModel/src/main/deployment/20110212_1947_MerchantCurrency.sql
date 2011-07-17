ALTER TABLE `site_payment_system`
	ADD COLUMN `currency_id`
	INTEGER UNSIGNED NOT NULL AFTER `sort_order`
;

delete from `site_configuration`
	where `name` = '.ru.psfotos.robocash.merchantCurrency'
;

update `site_configuration`
	set		`value`		= '.ru.psfotos.approveOrder'
	where	`name`	= '.ru.psfotos.order.approve.mail.templateKey'
;

update	`site_email_template`
	set		`key`		= '.ru.psfotos.approveOrder'
	where	`key`		= '.ru.psfotos.appriveOrder'
;

update	`site_email_template`
	set		`key`		= '.ru.psfotos.approveOrder',
			`subject`	= 'Подтверждение заказа № $order.id',
			`body`		='Здравствуйте $firstname $surname !

Ниже находятся ссылки на файлы, входящие в заказ № $order.id.
Для скачки файлов необходимо аутентифицироваться.

#foreach($orderItem in $order.items)
   $downloadLink$orderItem.id
#end



Удачи!'
		where `key`		= '.ru.psfotos.approveOrder'
;

insert into `site_payment_system`
	set		`name`			= 'Roboxchange',
			`checkout_url`	= 'https://merchant.roboxchange.com/Index.aspx',
			`status`		= 'ENABLED',
			`default_merchant_login`	= 'Basko',
			`sort_order`	= 0,
			`currency_id`	= 6
;

update `site_payment_system`
	set `currency_id` = (	select `id`
							from `site_currency`
							where `code` = 'OceanBankR'
						)
	where `name` = 'Roboxchange'
;

update `site_currency`
	set		`display_name`	= 'руб.'
	where	`code`		= 'OceanBankR'
;
