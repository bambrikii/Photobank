<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title><s:property value="%{getText('menu.event')}" /></title>
</head>
<body>

	<s:component template="photobank/event/list_container.jsp" />

	<s:if test="%{mainList==null}">
		<s:component template="photobank/core/content_pre1.jsp" />
		<s:url id="defaultUrl" action="%{'event'}" includeParams="get" />
		<s:a cssClass="wintitl" href="%{defaultUrl}"
			style="text-transform: uppercase;">
			<s:property value="%{category.description}" escapeHtml="false" />
		</s:a>
		<s:component template="photobank/core/content_pre2.jsp" />

		<s:component template="photobank/core/list.jsp">
			<s:param name="pager" value="%{pager}" />
			<s:param name="pagerAction" value="%{'event!briefList'}" />
			<s:param name="itemTemplate"
				value="'photobank/event/briefListItem.jsp'" />
		</s:component>

		<s:component template="photobank/core/content_post.jsp" />
	</s:if>

</body>
</html>