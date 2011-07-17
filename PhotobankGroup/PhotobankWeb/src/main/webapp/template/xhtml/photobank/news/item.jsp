<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>

<table border="0" cellpadding="0" cellspacing="0"
	style="margin-bottom: 0px; vertical-align: top;">
	<tr>

		<td><s:url id="recordUrl" action="news!preview"
			includeParams="none">
			<s:param name="model.id" value="%{parameters.record.id}" />
		</s:url>

		<div class="win_data" style="margin-bottom: 15px;"><s:property
			value="%{parameters.record.time}" /></div>

		<div style="margin-bottom: 15px;"><s:a cssClass="wintitl"
			href="%{recordUrl}">
			<s:property value="%{parameters.record.title}" />
		</s:a></div>

		<s:if test="%{session.userRoles.contains('service_manager')}">
			<s:url id="editUrl" action="newsEdit!edit" includeParams="none">
				<s:param name="model.id" value="%{parameters.record.id}" />
			</s:url>
			<s:a href="%{editUrl}" cssClass="win1">
				<s:property value="%{getText('action.edit')}" /> &#187;&#187;</s:a>
			<br />
			<br />
			<br />
		</s:if></td>
	</tr>
	<tr>
		<td colspan="2" height="1" ></td>
	</tr>
</table>







