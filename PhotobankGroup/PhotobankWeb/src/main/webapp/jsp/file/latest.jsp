<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title><s:property value="%{getText('file.latest')}" /></title>
</head>
<body>

<table>
	<tr>
		<td style="width: 238px; vertical-align: top;"><s:component
			template="photobank/news/top_list.jsp" /></td>
		<td><s:component template="photobank/core/content_pre1.jsp" />
		<s:url id="defaultUrl" action="%{'file!latest'}" includeParams="get" />
		<s:a cssClass="wintitl" href="%{defaultUrl}"
			style="text-transform: uppercase;">
			<s:property value="%{getText('file.latest')}" />
		</s:a> <s:component template="photobank/core/content_pre2.jsp" /> <s:component
			template="photobank/core/list.jsp">
			<s:param name="pager" value="%{pager}" />
			<s:param name="pagerAction" value="'file!latest'" />
			<s:param name="itemTemplate" value="'photobank/file/item.jsp'" />
		</s:component><s:component template="photobank/file/delete_selected.jsp" /></td>
		<s:component template="photobank/core/content_post.jsp" />
	</tr>
</table>
</body>
</html>