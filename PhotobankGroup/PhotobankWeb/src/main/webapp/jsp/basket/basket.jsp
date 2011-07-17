<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title><s:property value="%{getText('menu.basket')}" /></title>
</head>
<body>

<s:component template="photobank/core/content_pre1.jsp" >
<s:param name="titleWidth" value="'150px'" />
</s:component>
<s:url id="defaultUrl" action="%{'basket'}" includeParams="get" />
<span class="wintitl win_title" style="text-transform: uppercase;">
<s:property value="%{getText('menu.basket')}" escapeHtml="false" /> </span>
<s:component template="photobank/core/content_pre2.jsp" />

<table class="win_text"
	style="border: solid; border-width: 1px; border-space: 0; border-collapse: collapse; width: 100%;">
	<tr style="vertical-align: top; font-weight: bold;">
		<td width="75"><s:property value="%{getText('file.preview')}" /></td>
		<td width="180"><s:property
			value="%{getText('order.list.FileNumber')}" /></td>
		<td width="180"><s:property
			value="%{getText('order.list.FileDescription')}" /></td>
		<td width="80"><s:property
			value="%{getText('order.list.FileSize')}" /></td>
		<td width="180"><s:property value="%{getText('filePrice.price')}" /></td>
		<td>&nbsp;</td>
	</tr>
</table>
<s:component template="photobank/core/list.jsp">
	<s:param name="pager" value="%{pager}" />
	<s:param name="pagerAction" value="'basket'" />
	<s:param name="itemTemplate" value="'photobank/basket/item.jsp'" />
</s:component>

<s:property value="%{getText('order.totalPrice')}" />
:
<s:iterator id="totalPriceIterator"
	value="%{basketSummary.prices.keySet()}">
	<s:property value="%{basketSummary.prices[#totalPriceIterator]}" />
	<s:property value="%{#totalPriceIterator.displayName}" />
</s:iterator>

<br />
<br />

<s:form method="post">
	<s:if test="%{pager.totalRecordsCount > 0}">
		<s:submit action="basket!checkout" key="basket.checkout" />
		<s:submit action="basket!empty" key="basket.empty" />
	</s:if>
	<s:if test="%{session.userRoles != null && session.userRoles.size>-1}">
		<s:submit action="basketArchive" key="menu.basketArchive" />
	</s:if>
</s:form>
<script type="text/javascript">
	$("document").ready(function(){
		$("input[name='action:basket!empty']").bind("click", function(){
			if(confirm("<s:property value="getText('basket.confirm.empty')" escape="false" />")){
				$.ajax({
					method: "POST",
					url: "<s:url namespace="ajax" action="basketAjax" method="empty" />",
					success: function(){
						location.reload();
					},
					error: function(request, textStatus, ex){
						alert("Error: " +textStatus+"\n"+ex +"\n" + request.status + "("+request.statusText + " " + request.responseText+")");
					}
				})
			}
			return false;
		});
	});
</script>

<s:component template="photobank/core/content_post.jsp" />

</body>
</html>