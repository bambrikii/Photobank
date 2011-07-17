<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>

<s:url id="recordUrl" action="event!files" includeParams="none">
	<s:param name="model.id" value="%{parameters.record.id}" />
</s:url>

<div style="margin-bottom: 5px;"><span class="win_data"><s:property
	value="%{parameters.record.insertionTime}" /></span>, <s:a
	href="%{recordUrl}" cssClass="winl">
	<s:property value="%{parameters.record.description}" />
</s:a></div>

