<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title><s:property value="%{getText('file.find')}" /></title>
</head>
<body>

<s:component template="photobank/core/content_pre1.jsp" >
<s:param name="titleWidth" value="'150px'" />
</s:component>
<s:url id="defaultUrl" action="%{'file'}" includeParams="get" />
<span class="wintitl win_title" style="text-transform: uppercase;"> <s:property
	value="%{getText('file.find')}" escapeHtml="false" /> </span>
<s:component template="photobank/core/content_pre2.jsp" />

<s:form method="post">
	<s:textfield name="searchString" key="file.personality"
		value="%{searchString}"></s:textfield>
	<s:submit action="file!find" key="file.find.button"></s:submit>
</s:form>

<s:component template="photobank/core/list.jsp">
	<s:param name="pager" value="%{pager}" />
	<s:param name="pagerAction" value="'file!find'" />
	<s:param name="itemTemplate" value="'photobank/file/item.jsp'" />
</s:component>
<s:component template="photobank/file/delete_selected.jsp" />

<s:component template="photobank/core/content_post.jsp" />

</body>
</html>