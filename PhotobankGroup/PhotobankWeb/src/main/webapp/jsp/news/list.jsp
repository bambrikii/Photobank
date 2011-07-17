<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title><s:property value="%{getText('menu.news')}" /></title>
</head>
<body>

<s:component template="photobank/core/content_pre1.jsp" >
<s:param name="titleWidth" value="'200px'" />
</s:component>
<span class="wintitl win_title" style="text-transform: uppercase;">
<s:property value="%{getText('menu.news')}" escapeHtml="false" /> </span>
<s:component template="photobank/core/content_pre2.jsp" />

<s:if test="%{session.userRoles.contains('service_manager')}">
	<div style="float: right;"><s:url id="addNewsLink"
		action="newsEdit!edit" includeParams="none">
	</s:url> <s:a href="%{addNewsLink}" cssClass="winl">Add news</s:a></div>
</s:if>

<s:component template="photobank/core/list.jsp">
	<s:param name="pager" value="%{pager}" />
	<s:param name="pagerAction" value="'news!list'" />
	<s:param name="itemTemplate" value="'photobank/news/item.jsp'" />
</s:component>

<s:component template="photobank/core/content_post.jsp" />

</body>
</html>