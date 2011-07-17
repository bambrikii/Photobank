<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title><s:property
	value="%{getText('userStatusConsideration.awaitingConsiderationList')}" /></title>
</head>
<body>

<h3><s:property
	value="%{getText('userStatusConsideration.awaitingConsiderationList')}" /></h3>

<s:component template="photobank/core/list.jsp">
	<s:param name="pager" value="%{pager}" />
	<s:param name="pagerAction" value="'userStatusConsideration'" />
	<s:param name="itemTemplate" value="'photobank/user_status/item.jsp'" />
</s:component>

</body>
</html>