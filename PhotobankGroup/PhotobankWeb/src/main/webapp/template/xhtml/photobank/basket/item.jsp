<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>


<table cellpadding="0" cellspacing="0" border="0" width="100%"
	id="<s:property value="%{'basketItemTable_' + parameters.record.id}" />">
	<tr>
		<td width="75"><s:a href="javascript://">
			<img
				src="photoPreview!small.action&#063;id=<s:property value="%{parameters.record.file.id}" />"
				width="45"
				title="<s:property value="%{parameters.record.file.description}" />" />
		</s:a></td>
		<td width="180"><s:property
			value="%{getReadableFileName(parameters.record.file.fileName)}" /></td>
		<td width="180"><s:property
			value="%{parameters.record.file.description}" /></td>
		<td width="80"><s:property
			value="%{parameters.record.dimension.name}" /></td>
		<td width="180"><s:iterator id="price"
			value="%{parameters.record.dimension.prices}">
			<s:a href="javascript://" cssClass="winl">
				<s:property value="%{#price.value}" />
				<s:property value="%{#price.currency.displayName}" />
			</s:a>
		</s:iterator></td>
		<td>
		<td><s:form method="post">
			<s:hidden name="itemId" value="%{parameters.record.id}" />
			<s:submit action="basket!removeItem" key="action.delete" />
		</s:form><script type="text/javascript">
			$("document").ready(function(){

				$("a", $("#<s:property value="%{'basketItemTable_' + parameters.record.id}" />"))
					.photobank_basket_preview({
						baseUrl: "<s:url value="/" />",
						action_add_title: "<s:property value="%{getText('action.add')}" />",
						action_delete_title: "<s:property value="%{getText('action.delete')}" />",
						action_update_title: "<s:property value="%{getText('action.update')}" />",
						action_back_title: "<s:property value="%{getText('action.back')}" />",
						file_event_title: "<s:property value="%{getText('file.event')}" />",
						file_description_title: "<s:property value="%{getText('file.personality')}" />",
						file_insertionTime_title: "<s:property value="%{getText('file.insertionTime')}" />",
						itemId: $("input[name='itemId']", $("#<s:property value="%{'basketItemTable_' + parameters.record.id}" />")).val(),
						successEvent: function(){
							location.reload();
						}
					});


				$("input[name='action:basket!removeItem']", $("#<s:property value="%{'basketItemTable_' + parameters.record.id}" />")).bind("click", function(){
					$.ajax({
						method: "POST",
						url: "<s:url namespace="ajax" action="basketAjax" method="removeItem" />",
						data: "itemId=" + $("input[name='itemId']", $("#<s:property value="%{'basketItemTable_' + parameters.record.id}" />")).val(),
						success: function(){
							location.reload();
						},
						error: function(request, textStatus, ex){
							alert("Error: " +textStatus+"\n"+ex +"\n" + request.status + "("+request.statusText + " " + request.responseText+")");
						}
					});
					return false;
				});
			});
		</script></td>
	</tr>
</table>
