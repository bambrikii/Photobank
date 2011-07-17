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

<s:component template="photobank/core/content_pre1.jsp" >
<s:param name="titleWidth" value="'150px'" />
<s:param name="windowStyle" value="'width: 500px;'" />
</s:component>
<s:url id="defaultUrl" action="%{'login'}" includeParams="get" />
<span class="wintitl win_title" style="text-transform: uppercase;">
<s:property value="%{getText('menu.login')}" /> </span>
<s:component template="photobank/core/content_pre2.jsp" />


<s:form method="post">
	<s:textfield name="login" key="login.login" required="true" />
	<s:password name="password" key="login.password" required="true" />
	<s:submit action="login!login" key="login.action" />
</s:form>
<s:actionerror />
<s:actionmessage />

<s:component template="photobank/user/restore_password_link.jsp">
</s:component>

<s:component template="photobank/core/content_post.jsp" />

</body>
</html>