<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<s:if test="%{session.userRoles.contains('service_manager')}">
	<script type="text/javascript"
		src="<s:url value='/scripts/swfupload/swfupload.js' includeParams="none" />"></script>
	<script type="text/javascript"
		src="<s:url value='/scripts/swfUploadHandlers.js' includeParams="none" />"></script>

	<script type="text/javascript">

var swfu;
var swfu10x15;

window.onload = function () {
swfu = new SWFUpload(
			{
				upload_url: "<s:url value="%{'/photoUpload!massUpload.action'}" includeParams="none" />",
				post_params: {
				},

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
					upload_target : "divFileProgressContainer",
					result_target : "thumbnails",
					cancelButtonId : "btnCancel"
				},

				debug: false
			});

swfu10x15 = new SWFUpload(
		{
			upload_url: "<s:url value="%{'/photoUpload!massUpload10x15.action'}" includeParams="none" />",
			post_params: {
			},

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
			button_placeholder_id : "spanButtonPlaceholder10x15",
			button_width: 180,
			button_height: 18,
			button_text : '<span class="button">Select Images <span class="buttonSmall">(10x15 cm, 20 MB Max)</span></span>',
			button_text_style : '.button { font-family: Helvetica, Arial, sans-serif; font-size: 12pt; } .buttonSmall { font-size: 10pt; }',
			button_text_top_padding: 0,
			button_text_left_padding: 18,
			button_window_mode: SWFUpload.WINDOW_MODE.TRANSPARENT,
			button_cursor: SWFUpload.CURSOR.HAND,

			flash_url : "<s:url value='/scripts/swfupload/swfupload.swf' includeParams="none" />",

			custom_settings : {
				upload_target : "divFileProgressContainer10x15",
				result_target : "thumbnails10x15",
				cancelButtonId : "btnCancel10x15"
			},

			debug: false
		});

};
</script>


	<table style="width: 100%;">
		<tr style="vertical-align: top;">
			<td style="width: 50%;">
				<div id="content">
					<form>
						<div
							style="display: inline; border: solid 1px; padding: 2px;">
							<span id="spanButtonPlaceholder"></span>
						</div>
					</form>
					<input type="button" name="btnCancel"
						style="display: inline; border: solid 1px; padding: 2px; height: 19px;"
						value="Cancel" onclick="javascript:swfu.cancelQueue();"></input>
					<div id="divFileProgressContainer" style="height: 75px;"></div>
					<div id="thumbnails"></div>
				</div></td>
			<td style="width: 50%;">
				<div id="content10x15">
					<form>
						<div
							style="display: inline; border: solid 1px; padding: 2px;">
							<span id="spanButtonPlaceholder10x15"></span>
						</div>
					</form>
					<input type="button" name="btnCancel10x15"
						style="display: inline; border: solid 1px; padding: 2px; height: 19px;"
						value="Cancel" onclick="javascript:swfu10x15.cancelQueue();"></input>
					<div id="divFileProgressContainer10x15" style="height: 75px;"></div>
					<div id="thumbnails10x15"></div>
				</div></td>
		</tr>
	</table>
</s:if>