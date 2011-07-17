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
	<script type="text/javascript">
		var message = "";

		function clickIE() {
			if (document.all) {
				(message);
				return false;
			}
		}
		function clickNS(e) {
			if (document.layers || (document.getElementById && !document.all)) {
				if (e.which == 2 || e.which == 3) {
					(message);
					return false;
				}
			}
		}
		if (document.layers) {
			document.captureEvents(Event.MOUSEDOWN);
			document.onmousedown = clickNS;
		} else {
			document.onmouseup = clickNS;
			document.oncontextmenu = clickIE;
		}

		document.oncontextmenu = new Function("return false")
	</script>

	<h3>
		<s:property value="%{getText('file.preview')}" />
	</h3>
	<s:component template="photobank/core/content_pre1.jsp" />
	<%
		if (Integer.parseInt(request.getAttribute("fileId").toString()) != 0) {
	%>
	<s:url id="defaultUrl" action="%{'basket!previewFile'}"
		includeParams="all" />
	<%
		} else if (Integer.parseInt(request.getAttribute("itemId")
				.toString()) != 0) {
	%><s:url id="defaultUrl" action="%{'basket!previewItem'}"
		includeParams="all" />
	<%
		}
	%>
	<s:a cssClass="wintitl" href="%{defaultUrl}"
		style="text-transform: uppercase;">
		<s:property value="%{getText('file.preview')}" />
	</s:a>
	<s:component template="photobank/core/content_pre2.jsp" />


	<s:form method="post">
		<s:url id="previewImgUrl" action="photoPreview!large"
			includeParams="none">
			<s:param name="id" value="%{file.id}" />
		</s:url>
		<img src="<s:property value="%{previewImgUrl}" />"
			title="<s:property value="%{file.category.description}" />"
			style="margin-bottom: 15px;" class="imageItem_Preview" />


		<div class="win_text">
			<s:property value="%{getText('file.personality')}" />
			:
			<s:property value="%{file.category.description}" />
		</div>

		<s:if test="%{contextCategory!=null}">

			<div class="win_text">
				<s:property value="%{getText('file.event')}" />
				:
				<s:property value="%{contextCategory.description}" />
			</div>
			<div class="win_text">
				<s:property value="%{getText('file.insertionTime')}" />
				: <span class="win_data"><s:property
						value="%{contextCategory.insertionTime}" /> </span>
			</div>

		</s:if>


		<s:select name="selectedDimensionId" list="%{dimensions}" listKey="id"
			listValue="%{name + ' / ' + getDimensionPricesSummary(id)}"
			value="%{item.dimension.id}" emptyOption="false"></s:select>
		<s:if test="%{fileId != 0}">
			<s:hidden name="fileId" value="%{file.id}" />
			<s:submit action="basket!addItem" key="action.add" />
		</s:if>
		<s:elseif test="%{itemId != 0 }">
			<s:hidden name="itemId" value="%{itemId}" />
			<s:submit action="basket!updateItem" key="action.update" />
			<s:submit action="basket!removeItem" key="action.delete" />
		</s:elseif>

		<s:submit key="action.back"
			onclick="javascript:history.back(-1);return false;" />
	</s:form>

	<s:component template="photobank/core/content_post.jsp" />

</body>
</html>