INSERT INTO `site_configuration` (`name`, `value`) VALUES ('.ru.psfotos.site.url', 'http://localhost:8080/photobank');

INSERT INTO `site_configuration` (`name`, `value`) VALUES ('.ru.psfotos.order.approve.mail.templateKey', '.ru.psfotos.appriveOrder');
INSERT INTO `site_email_template` (`key`, `subject`, `body`, `content_type`) VALUES ('.ru.psfotos.appriveOrder', 'Order # $order.id confirmation', 'Hi $firstname $surname !

Here are your order # $order.id links:

#foreach($orderItem in $order.items)
   $downloadLink$orderItem.id
#end


Good luck!', 'TEXT_PLAIN');

INSERT INTO `site_configuration` (`name`, `value`) VALUES ('.ru.psfotos.order.reject.mail.templateKey', '.ru.psfotos.rejectOrder');
INSERT INTO `site_email_template` (`key`, `subject`, `body`, `content_type`) VALUES ('.ru.psfotos.rejectOrder', 'Order # $order.id reject', 'Hi $firstname $surname !

Your order # $order.id rejected:

#foreach($orderItem in $order.items)
   $orderItem.file.fileName (order id: $orderItem.id, file id: $orderItem.file.id)
#end

Good luck!', 'TEXT_PLAIN');
