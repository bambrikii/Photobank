<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<table style="width: 100%;">
	<tr
		style="font-weight: bold; vertical-align: center;">
		<td width="45">N <s:property value="%{parameters.record[0].id}" /></td>
		<td colspan="3"><s:property
			value="%{parameters.record[0].status}" /></td>
	</tr>
	<s:if test="%{parameters.record[0].items.size > 0}">
		<s:iterator value="%{parameters.record[0].items}" id="itemRow">
			<tr>
				<td>
				<s:url id="imgUrl" action="photoPreview" method="small"
					includeParams="none">
					<s:param name="id" value="%{#itemRow.file.id}" />
				</s:url> <img src="<s:property value="%{imgUrl}" />" width="15" />
				</td>
				<td width="180"><s:property
					value="%{getReadableFileName(#itemRow.file.fileName)}" /></td>
				<td width="150"><s:property
					value="%{#itemRow.file.description}" /></td>
				<td><s:property value="%{#itemRow.dimension.name}" /></td>
			</tr>
		</s:iterator>
	</s:if>
	<tr>
		<td colspan="3"><s:property
			value="%{getText('basket.totalPrice')}" />: <s:property
			value="%{parameters.record[2]}" /> <s:property
			value="%{parameters.record[1].displayName}" /></td>
		<%--
		<td><s:if
			test="%{!parameters.record[0].status.toString().equals('REJECTED')}">
			<s:form method="post">
				<s:submit action="basketArchive!repay" key="basket.repay" />
			</s:form>
		</s:if></td>
		--%>
	</tr>
</table>
