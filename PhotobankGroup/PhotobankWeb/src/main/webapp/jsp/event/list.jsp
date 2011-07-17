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
	<s:component template="photobank/core/content_pre1.jsp">
		<s:param name="titleWidth" value="'200px'" />
	</s:component>
	<span class="wintitl win_title" style="text-transform: uppercase;">
	<s:property value="%{category.description}" escapeHtml="false" /> </span>
	<s:component template="photobank/core/content_pre2.jsp" />

	<div style="margin-top: 5px; margin-bottom: 15px;"><s:url
		id="briefListUrl" action="event!briefList">
		<s:param name="model.id" value="%{model.id}" />
	</s:url> <s:a href="%{briefListUrl}" cssClass="winl">
		<s:property value="%{getText('event.briefList')}" /> &gt;&gt;
	</s:a></div>

	<s:if test="%{session.userRoles.contains('service_manager')}">
		<s:if test="%{model.id !=null}">
			<s:url id="addEventLink" action="eventEdit" includeParams="none">
				<s:param name="model.parent.id" value="%{model.id}"></s:param>
			</s:url>
			<s:a href="%{addEventLink}" cssClass="winl">Add event</s:a>
		</s:if>
	</s:if>

	<s:component template="photobank/core/list.jsp">
		<s:param name="pager" value="%{pager}" />
		<s:param name="pagerAction"
			value="%{'event!list' }" />
		<s:param name="itemTemplate" value="'photobank/event/item.jsp'" />
	</s:component>

	<s:component template="photobank/core/content_post.jsp" />
</s:if>

</body>
</html>