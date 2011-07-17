<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title><s:property value="%{getText('menu.event')}" /></title>
<style type="text/css">
.swfupload {
	vertical-align: top;
}
</style>
</head>
<body>

	<h3>
		<s:property value="%{getText('menu.event')}" />
	</h3>

	<s:form method="post">
		<s:hidden name="model.id" value="%{model.id}" />
		<s:hidden name="model.coverFile.id" value="%{model.coverFile.id}" />
		<s:hidden name="model.parent.id" value="%{model.parent.id}" />
		<s:textfield name="model.description" value="%{model.description}"
			key="category.description" />
		<s:textarea name="model.text" value="%{model.text}" key="event.text" />
		<s:select name="model.categoryType" value="%{model.categoryType}"
			list="categoryTypeList" />
		<s:checkbox name="model.active" value="%{model.active}"
			key="category.active" />
		<s:textfield name="model.order" value="%{model.order}"
			key="category.order" />
		<s:select name="coverFile.id" listKey="id" listValue="fileName"
			value="%{model.coverFile.id}" list="%{coverFiles}"
			emptyOption="false">
		</s:select>
		<s:submit action="eventEdit!save" key="action.save" />
		<s:submit action="eventEdit!delete" key="action.delete" />
	</s:form>

	<s:actionerror />
	<s:actionmessage />

</body>
</html>