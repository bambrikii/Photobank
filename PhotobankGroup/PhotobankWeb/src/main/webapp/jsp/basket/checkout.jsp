<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title><s:property value="%{getText('basket.checkout')}" /></title>
</head>
<body>

<h3><s:property value="%{getText('basket.checkout')}" /></h3>

<s:property value="%{getText('payment.invoice')}" />
: #
<s:property value="%{robocashPaymentInfo.invId}" />
(
<s:property value="%{robocashPaymentInfo.invDesc}" />
)
<br />
<s:property value="%{getText('payment.outSum')}" />
:
<s:property value="%{robocashPaymentInfo.outSum}" />
<s:property value="%{robocashPaymentInfo.incCurrLabel}" />

<s:form id="robocashSubmitForm" method="post"
	action="%{robocashPaymentInfo.serviceUrl}">
	<s:hidden name="MrchLogin" value="%{robocashPaymentInfo.merchantLogin}" />
	<s:hidden name="InvId" value="%{robocashPaymentInfo.invId}" />
	<s:hidden name="Desc" value="%{robocashPaymentInfo.invDesc}" />
	<s:hidden name="Culture" value="%{robocashPaymentInfo.culture}" />
	<s:hidden name="SignatureValue"
		value="%{robocashPaymentInfo.signatureValue}" />
	<s:hidden name="EMail" value="%{robocashPaymentInfo.eMail}" />
	<s:hidden name="OutSum" value="%{robocashPaymentInfo.outSum}" />
	<s:hidden name="Encoding" value="%{robocashPaymentInfo.encoding}" />
	<s:submit value="%{getText('basket.completeCheckout')}" />
</s:form>

<script type="text/javascript">
	$("document").ready(function() {
		$("#robocashSubmitForm").bind("submit",
			function(){
				var ret	= false;
				$.ajax({
					method: "POST",
					async: false,
					url: "<s:url namespace="ajax" action="robocashAjax" method="confirmCurrentOrder" />",
					success: function(){
						ret	= true;
					},
					error: function(request, textStatus, ex){
						alert("Error: " +textStatus+"\n"+ex +"\n" + request.status + "("+request.statusText + " " + request.responseText+")");
						ret = false;
					}
				});
				return ret;
			}
		);
	});
</script>

</body>
</html>