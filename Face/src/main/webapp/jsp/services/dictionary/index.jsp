<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<s:component template="face/dictionary/menu.jsp" />

	<h3>
		<s:property value="%{getText('dictionary.search.title')}" />
	</h3>

	<s:form namespace="/services/dictionary" method="post">
		<s:textfield name="text" value="%{text}" key="dictionary.search.text"></s:textfield>
		<s:submit action="index!find" key="dictionary.search.find" />
	</s:form>

	<s:property value="%{pager.totalRecordsCount}" />
	<br />

	<table>
		<s:iterator id="pagerItem" value="%{pager.records}">
			<tr>
				<td><s:property value="%{#pagerItem.key}" /></td>
				<td><s:property value="%{#pagerItem.title}" /></td>
				<td><s:property value="%{#pagerItem..text}" /></td>
			</tr>
		</s:iterator>
	</table>
</body>
</html>