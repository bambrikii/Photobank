<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@taglib prefix="sx" uri="/struts-dojo-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title><s:property value="%{getText('menu.news')}" /></title>
<sx:head />
</head>

<body>

<h3><s:property value="%{getText('menu.news')}" /></h3>

<s:form method="post">
	<s:hidden name="model.id" value="%{model.id}"></s:hidden>
	<s:textarea name="model.title" value="%{model.title}" key="news.title" />
	<tr>
		<td></td>
		<td><s:textarea name="model.content" value="%{model.content}"
			key="news.content" rows="150" cols="80" /></td>
	</tr>
	<sx:datetimepicker name="model.time" value="%{model.time}"
		key="news.time" />
	<s:select name="model.status" value="%{model.status}"
		list="statusesList" key="news.status" />
	<s:submit action="newsEdit!save" key="action.save" />
	<s:submit action="newsEdit!delete" key="action.delete" />
</s:form>

<s:actionerror />
<s:actionmessage />

</body>
</html>