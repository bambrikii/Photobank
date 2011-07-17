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
		<s:property value="%{getText('kb.parsing.title')}" />
	</h3>

	<s:form method="post">
		<s:textarea rows="150" cols="750" wrap="false" name="text"
			key="kb.parsing.text" value="%{text}">

		</s:textarea>
		<s:submit key="kb.parsing.parse" action="parsing!parse"></s:submit>
	</s:form>

	<pre>
<s:property value="%{text}" />
</pre>

</body>
</html>