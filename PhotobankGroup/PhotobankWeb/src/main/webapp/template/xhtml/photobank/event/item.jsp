<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>

<s:url id="recordUrl" action="event!files" includeParams="none">
	<s:param name="model.id" value="%{parameters.record.id}" />
</s:url>

<table border="0" cellpadding="0" cellspacing="0"
	style="margin-bottom: 0px; vertical-align: top;">
	<tr>
		<td style="height: 158px; width: 155px; vertical-align: top; margin: 0px;" align="center"><s:if
			test="%{parameters.record.coverFile != null && parameters.record.coverFile.fileName != null}">
			<s:url id="coverFileUrl" action="photoPreview!small"
				includeParams="none">
				<s:param name="id" value="%{parameters.record.coverFile.id}" />
			</s:url>
			<s:a href="%{recordUrl}" cssClass="winl">
				<img src="<s:property value="%{coverFileUrl}" />" class="imageItem" />
			</s:a>
		</s:if></td>
		<td style="vertical-align: top;">
		<div class="win_data" style="margin-bottom: 15px; margin-left:5px;"><s:property
			value="%{parameters.record.insertionTime}" /></div>
		<div class="win_text" style="margin-bottom: 15px; margin-left:5px;"><s:property
			value="%{parameters.record.description}" /> <br />
		</div>
		<div class="win_text" style="margin-left:5px;"><s:a href="%{recordUrl}" cssClass="winl">
			<s:property value="%{getText('defaultLink.detail')}" /> &gt;&gt;
		</s:a> <s:if test="%{session.userRoles.contains('service_manager')}">
			<s:url id="editUrl" action="eventEdit" includeParams="none">
				<s:param name="model.id" value="%{parameters.record.id}" />
			</s:url>
				&nbsp;
				<s:a href="%{editUrl}" cssClass="winl">
				<s:property value="%{getText('action.edit')}" /> &gt;&gt;
			</s:a>
		</s:if></div>
		</td>
	</tr>
	<tr>
		<td colspan="2" height="1"></td>
	</tr>
</table>


