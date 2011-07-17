<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>


<ul>
	<li><s:url id="dIndexUrl" action="index!find"
			namespace="/services/discussions" /> <s:a href="%{dIndexUrl}"
			key="kb.search.title">
			<s:property value="%{getText('discussions.title')}" />
		</s:a></li>

</ul>
