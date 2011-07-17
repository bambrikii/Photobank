<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title><s:property value="%{getText('register')}" /></title>
</head>
<body>

	<s:component template="photobank/core/content_pre1.jsp">
		<s:param name="titleWidth" value="'150px'" />
	</s:component>
	<span class="wintitl win_title" style="text-transform: uppercase;">
		<s:property value="%{getText('register')}" /> </span>
	<s:component template="photobank/core/content_pre2.jsp" />

	<s:property value="%{getText('register.terms_and_conditions.text')}"
		escapeHtml="false" />

	<s:form method="post">
		<s:checkbox name="acceptTermsAndConditions"
			key="registration.acceptTermsAndConditions" />
		<s:submit action="termsAndConditions!accept" key="action.register" />
	</s:form>

	<s:actionerror />
	<s:actionmessage />

	<s:component template="photobank/core/content_post.jsp" />

</body>
</html>