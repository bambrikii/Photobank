<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>

<s:set name="isLoggedIn" value="false" />
<s:if test="%{session.userRoles != null && session.userRoles.size>-1}">
	<s:set name="isLoggedIn" value="true" />
	<ul>
		<s:if test="%{session.userRoles.contains('service_manager')}">
			<li><s:url id="categUrl" action="category" /><s:a
				href="%{categUrl}" cssClass="winl">
				<s:property value="%{getText('menu.category')}" />
			</s:a></li>
		</s:if>
		<s:if test="%{session.userRoles.contains('root')}">
			<li><s:url id="userUrl" action="user" /><s:a href="%{userUrl}"
				cssClass="winl">
				<s:property value="%{getText('menu.user')}" />
			</s:a></li>
			<li><s:url id="userStatusConsiderationUrl"
				action="userStatusConsideration" /><s:a
				href="%{userStatusConsiderationUrl}" cssClass="winl">
				<s:property value="%{getText('menu.userStatusConsideration')}" />
			</s:a></li>
		</s:if>
		<s:if test="%{session.userRoles.contains('service_manager')}">
			<li><s:url id="orderUrl" action="order" /><s:a
				href="%{orderUrl}" cssClass="winl">
				<s:property value="%{getText('order.list')}" />
			</s:a></li>
		</s:if>
		<s:if test="%{session.userRoles.contains('service_manager')}">
			<li><s:url id="filePriceUrl" action="filePrice" /><s:a
				href="%{filePriceUrl}" cssClass="winl">
				<s:property value="%{getText('filePrice.list')}" />
			</s:a></li>
		</s:if>
		<s:if test="%{session.userRoles.contains('service_manager')}">
			<li><s:url id="photoUploadUrl" action="photoUpload" /><s:a
				href="%{photoUploadUrl}" cssClass="winl">
				<s:property value="%{getText('menu.photoUpload')}" />
			</s:a></li>
		</s:if>
	</ul>
</s:if>
