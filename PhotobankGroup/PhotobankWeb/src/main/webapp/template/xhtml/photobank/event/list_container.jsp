<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>

<s:if test="%{mainList!=null}">
	<table border="0" cellpadding="0" cellspacing="0">
		<tr>
			<s:iterator id="mainListItem" status="stat"
				value="%{mainList.keySet()}">
				<td style="width: <s:property value="%{100 / mainList.size}"/>%">
				<table border="0" cellpadding="0" cellspacing="0"
					style="margin-left: 5px; margin-right: 5px;">
					<tr>
						<td width="250" height="1"></td>
						<td width="650"></td>
					</tr>
					<tr>
						<td height="20">
						<table border="0" align="center" cellpadding="0" cellspacing="0">
							<tr>
								<td><s:url id="mainListItemUrl"
									action="event" includeParams="none">
									<s:param name="model.id" value="%{id}" />
								</s:url><s:a href="%{mainListItemUrl}" cssClass="wintitl"
									cssStyle="white-space: nowrap;">
									<s:property value="%{description}" />
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
						<tdheight="1"></td>
					</tr>
					<tr>
						<td colspan="2">
						<table width="100%" border="0" cellspacing="0" cellpadding="0">
							<tr>
								<td>


								<div style="height: 550px; overflow: auto;">
								<table cellpadding="0" cellspacing="10" style="margin: 10px;">
									<s:iterator id="mainEventItem"
										value="%{mainList.get(#mainListItem)}">
										<tr>
											<td><s:component template="photobank/event/item.jsp">
												<s:param name="record" value="%{#mainEventItem}" />
											</s:component></td>
										</tr>
									</s:iterator>
								</table>
								</div>
								</td>
							</tr>
						</table>
						</td>
					</tr>
					<tr>
						<td colspan="2" class="win_content_line"></td>
					</tr>
				</table>
				</td>
			</s:iterator>
		</tr>

	</table>
</s:if>
