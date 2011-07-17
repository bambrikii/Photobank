<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title><s:property value="%{getText('menu.news')}" /></title>
<style type="text/css">
.swfupload {
	vertical-align: top;
}
</style>
</head>

<body>

<h3><s:property value="%{getText('menu.news')}" /></h3>

<h3><s:property value="%{model.title}" escapeHtml="false" /></h3>
<div class="win_data" style="margin-bottom: 15px;"><s:property
	value="%{model.time}" /></div>
<div class="win_text"><s:property value="%{model.content}"
	escapeHtml="false" /></div>


<s:if test="%{session.userRoles.contains('service_manager')}">
	<br />
	<br />

	<s:url id="editUrl" action="newsEdit!edit" includeParams="none">
		<s:param name="model.id" value="%{model.id}" />
	</s:url>
	<s:a href="%{editUrl}" cssClass="win1">Edit &#187;&#187;</s:a>
	<br />
	<br />
	<br />
</s:if>
</body>
</html>