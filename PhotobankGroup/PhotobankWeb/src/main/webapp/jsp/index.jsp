<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>PhotoBank</title>
</head>
<body>

<table style="width: 100%">
	<tr>
		<td style="width: 238px; vertical-align: top;"><s:component
			template="photobank/news/top_list.jsp" /></td>
		<td><s:component template="photobank/event/list_container.jsp" />
		</td>
	</tr>
</table>

<s:component template="photobank/file/top_list.jsp" />

</body>
</html>
