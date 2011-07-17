<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title><s:property value="%{getText('passwordRestoration')}" /></title>
</head>
<body>

<s:component template="photobank/core/content_pre1.jsp" >
<s:param name="titleWidth" value="'150px'" />
<s:param name="windowStyle" value="'width: 500px;'" />
</s:component>
<s:url id="defaultUrl" action="%{'restorePassword'}" includeParams="get" />
<span class="wintitl win_title" style="text-transform: uppercase;">
<s:property value="%{getText('passwordRestoration')}" /> </span>
<s:component template="photobank/core/content_pre2.jsp" />


<s:form method="post">
	<s:textfield name="login" key="profile.login" />
	<s:textfield name="email" key="profile.email" />
	<tr>
		<td></td>
		<td><img src="<s:url value="/kaptcha.jpg" />" /></td>
	</tr>
	<s:textfield name="captcha" value="%{captcha}" key="captcha"></s:textfield>
	<s:submit action="restorePassword!restore"
		key="passwordRestoration.restore.send" />
</s:form>
<s:actionerror />
<s:actionmessage />

<s:component template="photobank/core/content_post.jsp" />

</body>
</html>