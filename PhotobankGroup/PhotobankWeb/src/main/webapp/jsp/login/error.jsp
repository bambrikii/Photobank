<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title><s:property value="%{getText('menu.login')}" /></title>
</head>
<body>

<h3><s:property value="%{getText('menu.login')}" /></h3>

<s:property value="%{getText('login.failed')}" />

<s:form method="post">
	<s:textfield name="login" key="login.login" />
	<s:password name="password" key="login.password" />
	<s:submit action="login!login" key="login.action" />
</s:form>
<s:actionerror />
<s:actionmessage />

<s:component template="photobank/user/restore_password_link.jsp">
</s:component>


</body>
</html>