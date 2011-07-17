<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>

<html>
<head>
<link href="<s:url value='/scripts/mootools/styles.css'/>"
	rel="stylesheet" type="text/css" media="all" />

<style type="text/css">
.topListImageItem {
	max-width: 150px;
	max-height: 150px;
	width: expression(this.width >
		   150 &&

		                  this.width >
		                       this.height ?
		                         "150px" :
		      true);
	height: expression(this.height >
		   150 &&

		                  this.width <
		                       this.height ?
		                         "150px" :
		      true);
	padding: 1px;
	border: 1px solid !important;
	vertical-align: middle;
	margin-right: 2px;
	margin-left: 2px;
	height: expression(this.height >
		   150 &&

		                  this.width <

		                       this.height ?
		                         "150px" :
		      true);
}
</style>
<script language="javascript" type="text/javascript"
	src="<s:url value="/scripts/mootools/mootools-1.2-core.js" />"></script>
<script language="javascript" type="text/javascript"
	src="<s:url value="/scripts/mootools/mootools-1.2-more.js" />"></script>
<script language="javascript" type="text/javascript"
	src="<s:url value="/scripts/mootools/SlideItMoo.js" />"></script>
<script language="javascript" type="text/javascript">

	window.addEvent('domready', function() {
		new SlideItMoo({
			thumbsContainer : 'thumbs',
			elementScrolled : 'thumb_container',
			overallContainer : 'gallery_container',
			containerSize : 912,
			autoSlide : 0
		});
	});
</script>

</head>
<body>

<br />
<table border="0" cellpadding="0" cellspacing="0" style="width: 100%;">
	<tr>
		<td width="160" height="1" ></td>
		<td width="760"></td>
	</tr>
	<tr>
		<td height="20" >
		<table border="0" align="center" cellpadding="0" cellspacing="0">
			<tr>
				<td ><span class="wintitl win_title"
					style="text-transform: uppercase;"> <s:property
					value="%{getText('file.topNFiles')}" /> </span></td>
			</tr>
			<tr>
				<td height="1" ></td>
			</tr>
		</table>
		</td>

		<td></td>
	</tr>
	<tr>
		<td  height="1"></td>
		<td height="1"></td>
	</tr>
	<tr>
		<td colspan="2"><s:if
			test="%{topFiles!=null && topFiles.size > 0}">

			<table cellpadding="0" cellspacing="0" border="0"
				style="margin-left: 17px;">
				<tr>
					<td>
					<div id="gallery_container">
					<div id="thumb_container">
					<div id="thumbs" style=""><s:iterator id="topItem"
						value="%{topFiles}">
						<a id="topFileItem_<s:property value="%{#topItem.id}" />"
							href="<s:if test="%{session.userRoles == null}"><s:url action="login" /></s:if><s:else>javascript://</s:else>"><img
							src="<s:url value="%{'/photoPreview!small.action?id=' + #topItem.id}" />"
							class="topListImageItem thumbnail" /></a>
						<s:if
							test="%{session.userRoles != null && session.userRoles.size>-1}">
							<script type="text/javascript">
								jQuery("document").ready(
										function(){
											jQuery("#topFileItem_<s:property value="%{#topItem.id}" />").photobank_basket_preview(
												{
													baseUrl: '<s:url value="/" />',
													action_add_title: '<s:property value="%{getText('action.add')}" />',
													action_delete_title: '<s:property value="%{getText('action.delete')}" />',
													action_update_title: '<s:property value="%{getText('action.update')}" />',
													action_back_title: '<s:property value="%{getText('action.back')}" />',
													file_event_title: '<s:property value="%{getText('file.event')}" />',
													file_description_title: "<s:property value="%{getText('file.personality')}" />",
													file_insertionTime_title: '<s:property value="%{getText('file.insertionTime')}" />',
													fileId: <s:property value="%{#topItem.id}" />
													}

												)});
							</script>
						</s:if>
					</s:iterator></div>
					</div>
					</div>
					</td>
				</tr>
			</table>
		</s:if></td>
	</tr>
	<tr>
		<td colspan="2" class="win_content_line"></td>
	</tr>

</table>
</body>