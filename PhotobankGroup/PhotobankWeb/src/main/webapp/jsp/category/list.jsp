<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title><s:property value="%{getText('menu.category')}" /></title>
</head>
<body>

<h3><s:property value="%{getText('menu.category')}" /></h3>

<s:if test="%{model.id !=null}">
	<div style="float: right;"><s:if
		test="%{model.parent.id != null}">
		<s:url id="upperCategoryLink" action="category" includeParams="none">
			<s:param name="model.id" value="%{model.parent.id}"></s:param>
		</s:url>
		<s:a href="%{upperCategoryLink}">&#187;<s:property
				value="%{model.parent.description}" />
		</s:a>
		<br />
	</s:if> <s:url id="addCategoryLink" action="categoryEdit" includeParams="none">
		<s:param name="model.parent.id" value="%{model.id}"></s:param>
	</s:url> <s:a href="%{addCategoryLink}">Add category</s:a></div>
</s:if>

<s:component template="photobank/core/list.jsp">
	<s:param name="pager" value="%{pager}" />
	<s:param name="pagerAction" value="'category'" />
	<s:param name="itemTemplate" value="'photobank/category/item.jsp'" />
</s:component>
</body>
</html>