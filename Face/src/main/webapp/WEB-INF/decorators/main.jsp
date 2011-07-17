<!DOCTYPE html PUBLIC
	"-//W3C//DTD XHTML 1.1 Transitional//EN"
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="decorator"
	uri="http://www.opensymphony.com/sitemesh/decorator"%>
<%@taglib prefix="page" uri="http://www.opensymphony.com/sitemesh/page"%>
<%@taglib prefix="s" uri="/struts-tags"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><decorator:title default="Struts Starter" /></title>
<link href="<s:url value='/styles/main.css'/>" rel="stylesheet"
	type="text/css" media="all" />
<link href="<s:url value='/struts/niftycorners/niftyCorners.css'/>"
	rel="stylesheet" type="text/css" />
<link href="<s:url value='/struts/niftycorners/niftyPrint.css'/>"
	rel="stylesheet" type="text/css" media="print" />
<script language="JavaScript" type="text/javascript"
	src="<s:url value='/struts/niftycorners/nifty.js'/>"></script>
<script language="JavaScript" type="text/javascript">
	window.onload = function() {
		if (!NiftyCheck()) {
			return;
		}
		// perform niftycorners rounding
		// eg.
		// Rounded("blockquote","tr bl","#ECF1F9","#CDFFAA","smooth border #88D84F");
	}
</script>
<decorator:head />
</head>
<body id="page-home">
	<div id="page">
		<div id="header" class="clearfix">
			<table style="width: 100%">
				<tr>
					<td><h2>
							<s:property value="getText('site.name')" />
						</h2>
						<hr />
					</td>
					<td style="width: 15%;"><s:url id="switchToRULocaleLink"
							includeParams="all" includeContext="true">
							<s:param name="request_locale" value="%{'ru'}" />
						</s:url> <s:url id="switchToENLocaleLink" includeParams="all"
							includeContext="true">
							<s:param name="request_locale" value="%{'en'}" />
						</s:url> <s:url id="switchToAMLocaleLink" includeParams="all"
							includeContext="true">
							<s:param name="request_locale" value="%{'am'}" />
						</s:url> <s:a href="%{switchToRULocaleLink}">
							<s:property value="getText('locale.ru')" />
						</s:a> <s:a href="%{switchToENLocaleLink}">
							<s:property value="getText('locale.en')" />
						</s:a> <s:a href="%{switchToAMLocaleLink}">
							<s:property value="getText('locale.am')" />
						</s:a>
					</td>
				</tr>
			</table>
		</div>

		<div id="content" class="clearfix">
			<div id="main">
				<decorator:body />
				<hr />
			</div>

			<div id="nav">
				<div class="wrapper">
					<ul class="clearfix">
						<li><s:url id="homeUrl" value="/" /> <s:a href="%{homeUrl}">
								<s:property value="getText('menu.home')" />
							</s:a>
						</li>
						<li><s:url id="loginUrl" action="login" /> <s:a
								href="%{loginUrl}" key="Login">
								<s:property value="getText('menu.login')" />
							</s:a>
						</li>
						<li><s:url id="kbUrl" action="index" namespace="/services/kb" />
							<s:a href="%{kbUrl}" key="kb">
								<s:property value="getText('menu.knowledgebase')" />
							</s:a></li>
						<li><s:url id="discussionUrl" action="index"
								namespace="/services/discussion" /> <s:a
								href="%{discussionUrl}" key="discussion">
								<s:property value="getText('menu.discussion')" />
							</s:a>
						</li>
						<li><s:url id="dictionaryUrl" action="index"
								namespace="/services/dictionary" /> <s:a
								href="%{dictionaryUrl}" key="dictionary">
								<s:property value="getText('menu.dictionary')" />
							</s:a>
						</li>
						<li class="last"><a href="#">Menu 6</a></li>
					</ul>
				</div>
				<hr />
			</div>
		</div>

		<div id="footer" class="clearfix">----------------------------------------------------------------------------------------------------</div>

	</div>

	<div id="extra1">&nbsp;</div>
	<div id="extra2">&nbsp;</div>
</body>
</html>
