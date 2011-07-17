<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<s:if test="%{topNews!=null && topNews.size > 0}">
	<table border="0" cellpadding="0" cellspacing="0">
		<tr>
			<td height="1" style="width: 178px;"></td>
			<td style="width: 60px;"></td>
		</tr>
		<tr>
			<td height="20">
				<table border="0" align="center" cellpadding="0" cellspacing="0">
					<tr>
						<td><s:url id="newsListUrl"
								action="news!list" /> <s:a cssClass="wintitl"
								href="%{newsListUrl}" style="text-transform: uppercase;">
								<s:property value="%{getText('menu.news')}" />
							</s:a></td>
					</tr>
					<tr>
						<td height="1" ></td>
					</tr>
				</table>
			</td>

			<td></td>
		</tr>
		<tr>
			<td height="1"></td>
			<td height="1"></td>
		</tr>
		<tr>
			<td colspan="2">
				<table width="100%" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td class="win_text">
							<div style="height: 550px;">
								<table cellpadding="0" cellspacing="10" style="margin: 10px;">
									<s:iterator id="topItem" value="%{topNews}">
										<tr>
											<td><s:url id="itemPreviewUrl" action="news!preview">
													<s:param name="model.id" value="%{#topItem.id}" />
												</s:url>
												<div class="win_data" style="margin-bottom: 15px;">
													<s:property value="%{#topItem.time}" />
												</div>
												<div class="win_text" style="margin-bottom: 15px;">
													<s:property value="%{#topItem.title}" />
												</div> <s:a cssClass="winl" href="%{itemPreviewUrl}"
													style="margin-bottom: 15px;">
													<s:property value="%{getText('defaultLink.detail')}" /> &gt;&gt;
								</s:a></td>
										</tr>
										<tr>
											<td colspan="2" height="1" ></td>
										</tr>
									</s:iterator>
									<s:if test="%{session.userRoles.contains('service_manager')}">
										<tr>
											<td>
												<div style="float: right;">
													<s:url id="addNewsLink" action="newsEdit!edit"
														includeParams="none">
													</s:url>
													<s:a href="%{addNewsLink}" cssClass="winl">Add news</s:a>
												</div>
											</td>
										</tr>
									</s:if>
								</table>
							</div>
						</td>
					</tr>
					<tr>
						<td colspan="2" class="win_content_line"></td>
					</tr>
				</table>
			</td>
		</tr>
	</table>
</s:if>
