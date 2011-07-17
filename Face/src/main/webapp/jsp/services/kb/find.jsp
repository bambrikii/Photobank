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

	<s:component template="face/kb/menu.jsp" />

	<h3>
		<s:property value="%{getText('kb.search.title')}" />
	</h3>

	<s:form namespace="/services/kb">
		<s:textfield name="text" value="%{text}" key="kb.search.text"></s:textfield>
		<s:submit action="index!find" key="kb.search.find" />
	</s:form>

	<s:iterator value="%{foundItems}">
	</s:iterator>

</body>
</html>