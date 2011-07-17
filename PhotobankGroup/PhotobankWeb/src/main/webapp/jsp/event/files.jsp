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

<s:component template="photobank/core/content_pre1.jsp">
	<s:param name="titleWidth" value="'200px'" />
</s:component>

<s:url id="localEventsUrl" action="%{'event'}" includeParams="none">
	<s:param name="model.id" value="%{model.parent.id}" />
</s:url>
<s:a cssClass="wintitl" href="%{localEventsUrl}"
	style="text-transform: uppercase;">
	<s:property value="%{model.parent.description}" escapeHtml="false" />
</s:a>
<s:component template="photobank/core/content_pre2.jsp" />

<h3><s:property value="%{model.description}" /></h3>
<div class="win_data" style="margin-bottom: 15px;"><s:property
	value="%{model.insertionTime}" /></div>
<div class="win_text" style="margin-bottom: 15px;"><s:property
	value="%{model.text}" /></div>

<s:component template="photobank/core/list.jsp">
	<s:param name="pager" value="%{filesPager}" />
	<s:param name="pagerAction" value="'event!files'" />
	<s:param name="itemTemplate" value="'photobank/file/item.jsp'" />
</s:component>
<s:component template="photobank/file/delete_selected.jsp" />

<s:component template="photobank/core/content_post.jsp" />

</body>
</html>