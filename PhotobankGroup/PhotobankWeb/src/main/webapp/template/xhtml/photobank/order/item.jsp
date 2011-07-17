<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>

<table class="win_text"
	style="border: thin 1px; border-space: 0; border-collapse: collapse; width: 100%;">
	<tr style="vertical-align: top;">
		<td width="50">N <s:property value="%{parameters.record.id}" /></td>
		<td width="85"><s:property
			value="%{parameters.record.client.firstname}" /> <s:property
			value="%{parameters.record.client.surname}" /> (<s:property
			value="%{parameters.record.client.login}" />)</td>
		<td width="185"><s:property
			value="%{parameters.record.client.email}" /></td>

		<td width="370" style="vertical-align: top;">
		<table
			style="border: none 0; border-space: 0; border-collapse: collapse; width: 100%;">
			<s:if test="%{parameters.record.items.size > 0}">
				<s:bean name="org.apache.struts2.util.Counter" id="itemsCounter">
					<s:param name="first" value="0"></s:param>
					<s:param name="last" value="%{parameters.record.items.size - 1}" />
				</s:bean>
				<s:iterator value="%{itemsCounter}" id="itemRow">
					<s:url id="imageUrl" action="photoPreview!large">
						<s:param name="id"
							value="%{parameters.record.items[#itemRow].file.id}" />
					</s:url>
					<tr style="vertical-align: top;">
						<td width="141"><s:a href="%{imageUrl}"
							cssStyle="font-size: 8pt;">
							<s:property
								value="%{getReadableFileName(parameters.record.items[#itemRow].file.fileName)}" />
						</s:a></td>
						<td><s:property
							value="%{parameters.record.items[#itemRow].file.category.description}" />
						</td>
						<td width="50"><s:property
							value="%{parameters.record.items[#itemRow].dimension.name}" /></td>
					</tr>
				</s:iterator>
			</s:if>
		</table>
		</td>
		<td width="150"><s:set name="basketSummary"
			value="%{getBasketSummary(parameters.record)}" /> <s:iterator
			id="totalPriceIterator" value="%{#basketSummary.prices.keySet()}">
			<s:property value="%{#basketSummary.prices[#totalPriceIterator]}" />
			<s:property value="%{#totalPriceIterator.name}" />
		</s:iterator></td>
		<td width="95"><s:property
			value="%{getText('order.status.' + parameters.record.status.toString())}" />
		<s:if
			test="%{session.userRoles.contains('root') && 'true'.equals(#parameters.alter[0])}">
			<form method="post">
			<table>
				<s:hidden name="model.id" value="%{parameters.record.id}" />
				<s:select name="paymentSystemId" list="%{paymentSystems}"
					listKey="id" listValue="name" />
				<s:submit action="order!approve" key="order.approve" />
				<s:submit action="order!reject" key="order.reject" />
				<s:submit action="order!delete" key="order.delete" />
			</table>
			</form>
		</s:if></td>
	</tr>
</table>
