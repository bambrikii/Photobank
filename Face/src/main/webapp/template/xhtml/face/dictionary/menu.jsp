<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>


<ul>

	<li><s:url id="dictionaryFindUrl" action="index!search"
			namespace="/services/dictionary" /> <s:a href="%{dictionaryFindUrl}"
			key="dictionary.search.title">
			<s:property value="%{getText('dictionary.search.find')}" />
		</s:a></li>

	<li><s:url id="dictionaryEditUrl" action="edit!find"
			namespace="/services/dictionary" /> <s:a href="%{dictionaryEditUrl}"
			key="dictionary.search.title">
			<s:property value="%{getText('dictionary.search.edit')}" />
		</s:a></li>

</ul>
