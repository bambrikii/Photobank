<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title><s:property value="%{getText('security.login')}" />
</title>
</head>
<body>

	<h3>
		<s:property value="%{getText('security.login')}" />
	</h3>

	<s:form>
		<s:if
			test="%{ session.userRoles != null && session.userRoles.size > -1 }">
			<s:submit action="login!logout" key="security.login.logOut" />
		</s:if>
		<s:else>
			<s:textfield name="username" key="security.login.username"
				required="true" />
			<s:password name="password" key="sercurity.login.password"
				required="true" />
			<s:submit action="login!login" key="security.login.logIn" />
		</s:else>
	</s:form>

	<s:actionerror />
	<s:actionmessage />

</body>
</html>