<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>

<s:url id="recordUrl" action="category" includeParams="none">
	<s:param name="model.id" value="%{parameters.record.id}" />
</s:url>

<s:a title="%{parameters.record.description}" href="%{recordUrl}"
	class="wintitl">
	<s:if test="%{parameters.record.coverFile!=null}">
		<s:url id="coverFileUrl" action="photoPreview!small"
			includeParams="none">
			<s:param name="id" value="%{parameters.record.coverFile.id}" />
		</s:url>
		<img src="<s:property value="%{coverFileUrl}" />" width="100" />
		<br />
	</s:if>
	<span class="win_text"> <s:if
		test="%{parameters.record.description == null || parameters.record.description == ''}">
		N <s:property value="%{parameters.record.id}" />
	</s:if> <s:else>
		<s:property value="%{parameters.record.description}" />
	</s:else> </span>

</s:a>

<s:if test="%{session.userRoles.contains('service_manager')}">
	<br />
	<br />
	<s:url id="filesUrl" action="category!files" includeParams="none">
		<s:param name="model.id" value="%{parameters.record.id}" />
	</s:url>
	<s:a href="%{filesUrl}" cssClass="win1">&#187;Files</s:a>

	<s:url id="editUrl" action="categoryEdit" includeParams="none">
		<s:param name="model.id" value="%{parameters.record.id}" />
	</s:url>
	<s:a href="%{editUrl}" cssClass="win1">&#187;Edit</s:a>
	<br />
	<br />
	<br />
</s:if>
