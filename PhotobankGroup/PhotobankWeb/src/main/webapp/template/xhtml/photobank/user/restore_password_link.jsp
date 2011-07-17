<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<div style="margin-top: 15px;"><s:url id="passwordRestoreLink"
	action="restorePassword" includeParams="none" /> <s:a
	href="%{passwordRestoreLink}" cssClass="winl">
	<s:property
		value="%{getText('passwordRestoration.forgorYourPasswordQuestion')}" />
</s:a></div>

<div style="margin-top: 15px;"><s:url id="registerLink"
	action="registration/termsAndConditions" /> <s:a
	href="%{registerLink}" cssClass="winl">
	<s:property value="%{getText('register.registerIfNot')}" />
</s:a></div>
