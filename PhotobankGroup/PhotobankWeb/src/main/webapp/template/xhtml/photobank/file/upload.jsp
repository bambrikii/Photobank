<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>

<s:if
	test="%{model!=null && model.id!=null && legalOwners!=null && legalOwners.size>0}">

	<s:form method="post">
		<s:hidden name="model.id" value="%{model.id}" />
		<s:select name="legalOwner.id" list="%{legalOwners}" listKey="id"
			listValue="name" value="%{legalOwner.id}" key="legalOwner.list" />
		<s:submit value="SetLegalOwner" />
	</s:form>

	<script type="text/javascript"
		src="<s:url value='/scripts/swfupload/swfupload.js' includeParams="none" />"></script>
	<script type="text/javascript"
		src="<s:url value='/scripts/swfUploadHandlers.js' includeParams="none" />"></script>

	<script type="text/javascript">

var swfu;
window.onload = function () {
swfu = new SWFUpload(
			{

				// Backend Settings
				upload_url: "<s:url value="%{'/photoUpload!upload.action?category.id=' + model.id}" includeParams="none" />",
				post_params: {
//					"jsessionid": "<%=session.getId()%>",
					"legalOwner.id" : "<s:property value="%{legalOwner.Id}" />"
				},

				// File Upload Settings
				file_size_limit : "20 MB",
				file_types : "*.jpg",
				file_types_description : "JPG Images",
				file_upload_limit : "0",

				file_queue_error_handler : fileQueueError,
				file_dialog_complete_handler : fileDialogComplete,

				upload_start_handler : uploadStart,
				upload_progress_handler : uploadProgress,
				upload_error_handler : uploadError,
				upload_success_handler : uploadSuccess,
				upload_complete_handler : uploadComplete,

				button_image_url : "<s:url value='/images/SmallSpyGlassWithTransperancy_17x18.png' includeParams="none" />",
				button_placeholder_id : "spanButtonPlaceholder",
				button_width: 180,
				button_height: 18,
				button_text : '<span class="button">Select Images <span class="buttonSmall">(20 MB Max)</span></span>',
				button_text_style : '.button { font-family: Helvetica, Arial, sans-serif; font-size: 12pt; } .buttonSmall { font-size: 10pt; }',
				button_text_top_padding: 0,
				button_text_left_padding: 18,
				button_window_mode: SWFUpload.WINDOW_MODE.TRANSPARENT,
				button_cursor: SWFUpload.CURSOR.HAND,

				flash_url : "<s:url value='/scripts/swfupload/swfupload.swf' includeParams="none" />",

				custom_settings : {
					upload_target : "divFileProgressContainer"
//					cancelButtonId : "btnCancel"
				},

				debug: false
			});
};
</script>



	<div id="content">
		<form>
			<div
				style="display: inline; border: solid 1px; padding: 2px;">
				<span id="spanButtonPlaceholder"></span>
			</div>
		</form>
		<div id="divFileProgressContainer" style="height: 75px;"></div>
		<div id="thumbnails"></div>
	</div>

</s:if>