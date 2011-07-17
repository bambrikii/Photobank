<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title><s:property value="%{getText('menu.user')}" /></title>
</head>
<body>


<h3><s:property value="%{getText('menu.user')}" /></h3>

<s:url id="addUserUrl" action="user!edit" />
<s:a href="%{addUserUrl}">
	<s:property value="%{getText('register')}" />
</s:a>
<br />

<s:component template="photobank/core/list.jsp">
	<s:param name="pager" value="%{pager}" />
	<s:param name="pagerAction" value="'user'" />
	<s:param name="itemTemplate" value="'photobank/user/item.jsp'" />
</s:component>

</body>
</html>