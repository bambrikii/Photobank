<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@taglib prefix="sx" uri="/struts-dojo-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title><s:property value="%{getText('menu.user')}" /></title>
<sx:head />
</head>
<body>

<h3><s:property value="%{getText('menu.user')}" /></h3>

<s:form method="post">
	<s:hidden name="model.id" value="%{model.id}" />
	<s:textfield name="model.login" value="%{model.login}"
		key="profile.login" />
	<s:textfield name="model.email" value="%{model.email}"
		key="profile.email" />
	<s:textfield name="model.firstname" value="%{model.firstname}"
		key="profile.name" />
	<s:textfield name="model.surname" value="%{model.surname}"
		key="profile.surname" />
	<s:textfield name="model.patronymic" value="%{model.patronymic}"
		key="profile.patronymic" />
	<s:textarea name="model.address" value="%{model.address}"
		key="profile.address" />
	<s:select name="model.sortOfActivity"
		list="{

		new org.bambrikii.photobank.web.security.beans.SortOfActivity('Internet', getText('register.sortOfActivity.Internet')),
		new org.bambrikii.photobank.web.security.beans.SortOfActivity('TV', getText('register.sortOfActivity.TV')),
		new org.bambrikii.photobank.web.security.beans.SortOfActivity('Cinema', getText('register.sortOfActivity.Cinema')),
		new org.bambrikii.photobank.web.security.beans.SortOfActivity('Other', getText('register.sortOfActivity.Other'))

		}"
		listKey="key" listValue="value" value="%{model.sortOfActivity}"
		key="profile.sortOfActivity"></s:select>
	<s:textarea name="model.organization" value="%{model.organization}"
		key="profile.organization" />
	<s:textfield name="model.password" value="%{model.password}"
		key="profile.password" />

	<sx:datetimepicker name="model.dateOfBirth"
		value="%{model.dateOfBirth}" key="profile.dateOfBirth" />

	<s:select name="model.language.id" list="%{availableLanguages}"
		listKey="id" listValue="name" value="%{model.language.id}"
		key="profile.locale">
	</s:select>
	<s:textfield name="model.phones[0].number"
		value="%{model.phones[0].number}" key="profile.phone" />
	<s:select name="model.status" value="%{model.status}"
		list="userStatusList" />
	<s:submit action="user!save" key="action.save" />
	<s:submit action="user!delete" key="action.delete" />
</s:form>

</body>
</html>