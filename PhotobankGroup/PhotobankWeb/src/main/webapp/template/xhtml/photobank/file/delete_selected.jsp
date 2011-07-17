<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<s:if test="%{session.userRoles.contains('service_manager')}">
	<input type="button" name="deleteFilesButton"
		value="<s:property value="%{getText('file.deleteSelectedFiles')}" />" />
	<input type="button" name="deleteFilesSelectUnselectAllButton"
		value="<s:property value="%{getText('action.selectOrUnselectAll')}" />" />
	<span id="deleteFilesConfirmationLabel" style="display: none;"><s:property
		value="%{getText('window.confirm.message')}" escapeHtml="true" /></span>
	<script type="text/javascript">
	$("document").ready(function() {
		$("input[type=button][name=deleteFilesButton]").bind("click", function(){
			if(confirm($("#deleteFilesConfirmationLabel").text())){
				var dataArr1 = new Array();
				$("input:checked[type=checkbox][name$='deleteFile']").each(function(){
				    dataArr1.push("itemIds=" + $(this).parents().find("form").find("input[type=hidden]").val() );
				});
				var data1 = dataArr1.join("&");
				$.ajax({
						type : "POST",
						url : "<s:url value="/ajax/photoEditAjax!delete.action" />",
						data : data1,
						context : document.body,
						success : function(){
									$("input:checked[type=checkbox][name$='deleteFile']").each(function(){
									    $(this).attr("checked", false);
									});
									location.reload();
								},
						error : function(request, textStatus, ex) {
									alert("Error: " + textStatus + "\n"	+ ex + "\n" + request.status + "(" + request.statusText + " " + request.responseText + ")");
								}
				});
			}
		});

		$("input[type=button][name=deleteFilesSelectUnselectAllButton]").bind("click", function(){
			if($("input:checked[type=checkbox][name$='deleteFile']").length>0){
				$("input:checked[type=checkbox][name$='deleteFile']").each(function(){
				    $(this).attr("checked", false);
				});
			}else{
				$("input[type=checkbox][name$='deleteFile']").each(function(){
				    $(this).attr("checked", true);
				});
			}
		});
	});
</script>
</s:if>