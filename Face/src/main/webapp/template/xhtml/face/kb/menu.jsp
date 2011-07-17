<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>


<ul>
	<li><s:url id="kbFindUrl" action="index!find"
			namespace="/services/kb" />
		<s:a href="%{kbFindUrl}" key="kb.search.title">
			<s:property value="%{getText('kb.search.find')}" />
		</s:a>
	</li>
	<li><s:url id="kbParsingUrl" action="parsing"
			namespace="/services/kb" />
		<s:a href="%{kbParsingUrl}" key="kb.parsing.parse">
			<s:property value="%{getText('kb.parsing.title')}" />
		</s:a>
	</li>


</ul>
