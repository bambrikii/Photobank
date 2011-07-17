<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<table
	style="width: 150px; height: 150px; text-align: center; vertical-align: top; margin-left: auto; margin-right: auto;">
	<tr>
		<td><s:url id="previewUrl" action="basket!previewFile"
			includeParams="none">
			<s:param name="fileId" value="%{parameters.record.id}" />
		</s:url> <a id="<s:property value="%{'fileItem_' + parameters.record.id}" />"
			href="<s:if test="%{session.userRoles == null}"><s:url action="login" /></s:if><s:else>javascript://</s:else>">
		<img
			src="<s:url value="%{'/photoPreview!small.action?id='+ parameters.record.id}" />"
			class="imageItem"
			title="<s:property value="%{parameters.record.description}" />" />
		</a> <s:if
			test="%{session.userRoles != null && session.userRoles.size>-1}">
			<script type="text/javascript">
	$("document").ready(
			function() {
				$("#fileItem_<s:property value="%{parameters.record.id}" />")
						.photobank_basket_preview({
							baseUrl: "<s:url value="/" />",
							action_add_title: "<s:property value="%{getText('action.add')}" />",
							action_delete_title: "<s:property value="%{getText('action.delete')}" />",
							action_update_title: "<s:property value="%{getText('action.update')}" />",
							action_back_title: "<s:property value="%{getText('action.back')}" />",
							file_event_title: "<s:property value="%{getText('file.event')}" />",
							file_description_title: "<s:property value="%{getText('file.personality')}" />",
							file_insertionTime_title: "<s:property value="%{getText('file.insertionTime')}" />",
							fileId: <s:property value="%{parameters.record.id}" />
							});
			});
</script>
		</s:if><br />
		<span class="win_text"> <s:property
			value="%{parameters.record.description}" /> </span> <s:if
			test="%{session.userRoles.contains('service_manager')}">
			<s:form method="post">
				<s:hidden name="model.id" value="%{parameters.record.id}" />
				<s:checkbox name="deleteFile" />
				<%--
				<s:submit action="photoEdit!delete"
					value="%{getText('action.delete')}" />
					--%>
			</s:form>
		</s:if></td>
	</tr>
</table>