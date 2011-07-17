<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@taglib prefix="decorator"
	uri="http://www.opensymphony.com/sitemesh/decorator"%>


<table class="win_content"
	style="<s:if test="%{parameters.windowStyle!=null}"><s:property value="%{parameters.windowStyle}" /></s:if>">
	<tr>
		<td class="win_content_line"
			style="width: <s:if test="%{parameters.titleWidth!=null}"><s:property value="%{parameters.titleWidth}" /></s:if>
		<s:else>250px;</s:else>"></td>
		<td></td>
	</tr>
	<tr>
		<td class="win_content_title">
			<table>
				<tr>
					<td>