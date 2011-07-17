<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<!-- Messages list -->
	<table>
		<s:iterator value="topics" id="topicIter">
			<tr>
				<td><s:url id="topicUrl" action="topic!list"
						includeParams="all">
						<s:param id="model.id" value="%{topicIter.id}"></s:param>
					</s:url> <s:a href="%{topicUrl}">
						<s:property value="%{topicIter.title}" />
					</s:a>
			</tr>
		</s:iterator>
	</table>
</body>
</html>