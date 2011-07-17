<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title><s:property
	value="%{getText('menu.userStatusConsideration')}" /></title>
</head>
<body>

<h3><s:property value="%{getText('menu.userStatusConsideration')}" /></h3>

<s:form method="post">
	<s:hidden name="model.id" value="%{model.id}" />

	<s:property value="%{getText('profile.login')}" />:
	<s:property value="%{model.login}" />
	<br />

	<s:property value="%{getText('profile.name')}" />:
	<s:property value="%{model.name}" />
	<br />

	<s:property value="%{getText('profile.email')}" />:
	<s:property value="%{model.email}" />
	<br />

	<s:property value="%{getText('profile.surname')}" />:
	<s:property value="%{model.surname}" />
	<br />

	<s:property value="%{getText('profile.address')}" />:
	<s:property value="%{model.address}" />
	<br />

	<s:property value="%{getText('profile.sortOfActivity')}" />:
	<s:property value="%{model.sortOfActivity}" />
	<br />

	<s:property value="%{getText('profile.password')}" />:
	<s:property value="%{model.password}" />
	<br />

	<s:property value="%{getText('profile.dateOfBirth')}" />:
	<s:property value="%{model.dateOfBirth}" />
	<br />

	<s:property value="%{getText('profile.phone')}" />:
	<s:property value="%{model.phones[0].number}" />
	<br />

	<s:property value="%{getText('defaultField.status')}" />:
	<s:property value="%{model.status}" />
	<br />

	<s:submit action="userStatusConsideration!approve"
		key="userStatusConsideration.approveAndInform" />
	<s:submit action="userStatusConsideration!reject"
		key="userStatusConsideration.rejectAndInform" />
</s:form>

</body>
</html>