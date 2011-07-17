<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title><s:property value="%{getText('order.list')}" /></title>
</head>
<body>

<h3><s:property value="%{getText('order.list')}" /></h3>


<s:if
	test="%{session.userRoles.contains('root') && #parameters.alter==null || !'true'.equals(#parameters.alter[0])}">
	<div style="text-align: left; margin-bottom: 15px;"><s:url
		id="alterOrdersUrl" action="order" includeParams="get">
		<s:param name="alter" value="'true'" />
	</s:url> <s:a href="%{alterOrdersUrl}" cssClass="winl">Alter</s:a> <br />
	</div>
</s:if>

<table class="win_text"
	style="border: solid; border-width: 1px; border-space: 0; border-collapse: collapse; width: 100%;">
	<tr style="vertical-align: top; font-weight: bold;">
		<td width="50"><s:property
			value="%{getText('order.list.Number')}" /></td>
		<td width="85"><s:property
			value="%{getText('order.list.Customer')}" /></td>
		<td width="185"><s:property
			value="%{getText('order.list.Email')}" /></td>
		<td width="370" style="vertical-align: top;">
		<table
			style="border: none 0; border-space: 0; border-collapse: collapse; width: 100%;">
			<tr style="vertical-align: top; font-weight: bold;">
				<td width="141"><s:property
					value="%{getText('order.list.FileNumber')}" /></td>
				<td><s:property
					value="%{getText('order.list.FileDescription')}" /></td>
				<td width="50"><s:property
					value="%{getText('order.list.FileSize')}" /></td>
			</tr>
		</table>
		</td>
		<td width="150"><s:property
			value="%{getText('order.list.TotalOrderPrice')}" /></td>
		<td width="95"><s:property
			value="%{getText('order.list.OrderStatus')}" /></td>
	</tr>
</table>


<s:component template="photobank/core/list.jsp">
	<s:param name="pager" value="%{pager}" />
	<s:param name="pagerAction" value="'user'" />
	<s:param name="itemTemplate" value="'photobank/order/item.jsp'" />
</s:component>
<br />

</body>
</html>