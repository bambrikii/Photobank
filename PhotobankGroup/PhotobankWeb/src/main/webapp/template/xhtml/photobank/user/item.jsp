<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>

<s:url id="editUrl" action="user!edit" includeParams="none">
	<s:param name="model.id" value="%{parameters.record.id}" />
</s:url>
<div>
<table class="win_text" cellpadding="0" cellspacing="0" border="0">
	<tr>
		<td width="110"><s:a href="%{editUrl}" cssClass="winl">
			<span
				<s:if test="%{parameters.record.status.toString().equals('DISABLED')}">
			style="text-decoration: none;  color: #555555;"
	</s:if>
				<s:elseif
		test="%{parameters.record.status.toString().equals('WAITING_CONSIDERATION')}">
			style="text-decoration: underline; font-weight: bold; color: #eeffee;"
	</s:elseif>
				<s:else>
		style="color: #ffffff;"
	</s:else>><s:property
				value="%{parameters.record.login}" /> </span>
		</s:a></td>
		<td width="230"><s:property value="%{parameters.record.email}" /></td>
		<td width="150"><s:property
			value="%{parameters.record.firstname}" /> <s:property
			value="%{parameters.record.surname}" /></td>
		<td width="50"><s:property value="%{parameters.record.status}" /></td>
	</tr>
</table>
</div>