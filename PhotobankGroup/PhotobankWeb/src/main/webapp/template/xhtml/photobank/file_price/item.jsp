<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<table
	style="spacing: 0px; margin: 0px; padding: 0px;<s:if test="%{!parameters.record.active}"> color: #a8a8a8;</s:if>">
	<tr>
		<td style="vertical-align: top; width: 85px;"><s:property
			value="%{parameters.record.name}" /></td>
		<td style="width: 120px;"><s:iterator
			value="%{parameters.record.prices.entrySet()}">
			<s:if test="%{key.active}">
				<span> <s:property value="%{key.code}" />: <s:property
					value="%{value}" /> </span>
				<br />
			</s:if>
		</s:iterator></td>
		<td style="vertical-align: top; width: 85px;"><s:property
			value="%{parameters.record.maxDim}" /></td>
		<td><s:url id="edtUrl" action="filePrice!edit"
			includeParams="none">
			<s:param name="model.id" value="%{parameters.record.id}" />
		</s:url><s:a href="%{edtUrl}">
			<s:property value="%{getText('action.edit')}" />
		</s:a></td>

	</tr>
</table>