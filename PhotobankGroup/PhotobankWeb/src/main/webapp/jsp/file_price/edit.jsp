<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title><s:property value="%{getText('filePrice.price')}" /></title>
</head>
<body>

<h3><s:property value="%{getText('filePrice.price')}" /></h3>

<s:form method="post">
	<s:hidden name="model.id" value="%{model.id}" />
	<s:textfield name="model.name" value="%{model.name}"
		key="defaultField.name" />
	<s:textfield name="model.order" value="%{model.order}"
		key="defaultField.order" />
	<s:checkbox name="model.active" value="%{model.active}"
		key="defaultField.active" />
	<s:iterator value="%{allCurrencies}" id="currencyItem">
		<s:if test="%{model.prices.containsKey(#currencyItem)}">
			<s:textfield name="prices[%{#currencyItem.id}]" key="filePrice.price"
				value="%{prices[#currencyItem.id]}" />
		</s:if>
		<s:else>
			<s:textfield name="prices[%{#currencyItem.id}]" key="filePrice.price"
				value="%{prices[#currencyItem.id]}" />
			<s:label value="%{'No value yet!'}" />
		</s:else>

		<s:label
			value="%{ #currencyItem.id + ' / ' + #currencyItem.code + ' / ' + #currencyItem.name + ' / ' + #currencyItem.displayName}" />
	</s:iterator>
	<s:textfield name="model.maxDim" value="%{model.maxDim}"
		key="filePrice.maxDim" />
	<s:submit action="filePrice!save" key="action.save" />
	<s:if test="%{model!=null}">
		<s:submit action="filePrice!delete" key="action.delete" />
	</s:if>
</s:form>

<s:actionerror />
<s:actionmessage />


</body>
</html>