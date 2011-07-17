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
	<s:property value="%{getText('menu.login')}" />
</span>
<s:component template="photobank/core/content_pre2.jsp" />


<s:property value="%{getText('login.loggedIn')}" />

<div style="margin-top: 15px;"><s:url id="logoutUrl"
	action="login!logout" /> <s:a href="%{logoutUrl}" cssClass="winl">
	<s:property value="%{getText('login.logOut')}" /> -&gt;</s:a></div>

<div style="margin-top: 15px;"><s:url id="profileUrl"
	action="profile" /> <s:a href="%{profileUrl}" cssClass="winl">
	<s:property value="%{getText('profile')}" /> -&gt;</s:a></div>

<s:component template="photobank/core/content_post.jsp" />

</body>
</html>