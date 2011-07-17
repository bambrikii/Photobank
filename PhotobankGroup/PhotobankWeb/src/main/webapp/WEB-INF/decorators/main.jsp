<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="decorator"
	uri="http://www.opensymphony.com/sitemesh/decorator"%>
<%@taglib prefix="page" uri="http://www.opensymphony.com/sitemesh/page"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title><decorator:title default="Struts Starter" /></title>

<link href="<s:url value="/styles/main.css" />" rel="stylesheet"
	type="text/css" media="all" />

<link rel="shortcut icon" href="<s:url value="/favicon.gif" />" />


<link href="<s:url value="/scripts/jquery/css/dark-hive-photobank/jquery-ui-1.8.9.custom.css" />" rel="stylesheet"
	type="text/css" media="all" />
<script language="JavaScript" type="text/javascript"
	src="<s:url value="/scripts/jquery/js/jquery-1.4.4.min.js" />"></script>
<script language="JavaScript" type="text/javascript"
	src="<s:url value="/scripts/jquery/js/jquery-ui-1.8.9.custom.min.js" />"></script>

<script language="JavaScript" type="text/javascript"
	src="<s:url value="/scripts/jquery/jquery.dump.js" />"></script>

<script language="JavaScript" type="text/javascript"
	src="<s:url value="/scripts/jquery/jquery.photobank.ru.basket.plugin.js" />"></script>

<decorator:head />
<s:head theme="xhtml" />
<style type="text/css">
body {
    font-size: 11px;
    background-color: #aaa;
}
</style>


<style type="text/css">
.text {
}

.win_title {
}

.win_text {
}
.win_text_red {
}

A.winl:link {
}

A.winl:visited {
}

A.winl:active {
}

A.winl:hover {
}

A.wintitl:link {
}

A.wintitl:visited {
}

A.wintitl:active {
}

A.wintitl:hover {
}

.win_data {
}

A.pages:link {
}

A.pages:visited {
}

A.pages:active {
}

A.pages:hover {
}
</style>


<style type="text/css">
table.win_content {
	border: 0;
	padding: 0;
	border-spacing: 0;
	border-collapse: collapse;
	width: 100%;
	table-layout: fixed;
}
table.win_content tr td {
	padding: 0;
}
.win_content_line {
	height: 1;
}
.win_content_title_underline {
}
.win_content_title {
	height: 20px;
	text-align: center;
}
td.win_content_title table {
	border: 0;
	padding: 0;
	border-spacing: 0;
	border-collapse: collapse;
	text-align: center;
	margin-left: auto;
	margin-right: auto;

}
td.win_content_title table tr:last-child td, .underline {
	height: 1px;
}
</style>

<style type="text/css">
.imageScrl {
	border: 1px solid;
}
.imageItem {
	padding: 2px;
	border: 1px solid;
	vertical-align: absmiddle;

	max-width: 150px;
	max-height: 150px;
	width: expression(this.width > 150 && this.width > this.height? "150px" : true);
	height: expression(this.height > 150 && this.width < this.height ? "150px" : true);
}

.imageItem_Preview {
	padding: 4px;
	border: 2px solid #aaa;
	vertical-align: absmiddle;

	max-width: 500px;
	max-height: 500px;
	width: expression(this.width > 500 && this.width > this.height? "500px" : true);
	height: expression(this.height > 500 && this.width < this.height ? "500px" : true);
}

.pager {
	font-size: 12px;
}
</style>


</head>
<body id="page-home">
<script type="text/javascript">
	jQuery(document).ready(function(){
		jQuery("a").focus(function(){
			jQuery(this).blur();
		});
	});
</script>

<table cellpadding="0" cellspacing="0" border="0" width="100%" style="height: 100%; margin: 0px">
	<tr>
		<td style="width: 50%; margin: 0px" align="right" valign="bottom">
            <table width="127" border="0" cellpadding="0" cellspacing="0" style="height: 100%; margin: 0px">
                  <tr>
                    <td style="margin: 0px" align="right" valign="bottom"></td>
                  </tr>
                </table>
        </td>
        <td>
            <table id="mainTable" width="1000" border="0" cellpadding="0" cellspacing="0" style="height: 100%; margin: 0px">
                <tr>
                  <td>
                        <table id="m_head" width="1000" height="86" border="0" cellpadding="0" cellspacing="0">
        		<tr>
                    <td rowspan="4">
                        <s:url id="indexUrl" value="/"/><s:a href="%{indexUrl}">Logo</s:a></td>
                    <td>
                        </td>
                    <td rowspan="4">
                        </td>
                    <td rowspan="2">
                        <a href="<s:url value="/file.action"/>">Search</a></td>
                    <td rowspan="2">
                        <a href="<s:url value="/basket.action"/>">Basket</a></td>
                    <td>
                        <s:url id="switchToRuLocaleLink" includeParams="all" includeContext="true"><s:param name="request_locale" value="%{'ru'}"/></s:url>
                        <s:a href="%{switchToRuLocaleLink}">ru</s:a></td>
                    <td>
                    </td>
                </tr>
                <tr>
                    <td rowspan="2">

                    </td>
                    <td>
                        <s:url id="switchToEngLocaleLink" includeParams="all"><s:param name="request_locale" value="%{'en'}"/></s:url><s:a href="%{switchToEngLocaleLink}">en</s:a></td>
                    <td>
                        </td>
                </tr>
                <tr>
                    <td colspan="3" rowspan="2">
                        </td>
                    <td>
                        </td>
                </tr>
                <tr>
                    <td>
                        </td>
                    <td>
                        </td>
   		 	   </tr>
    </table>
</td>
	</tr>
			<tr style="vertical-align: top">
				<td><table width="1000" border="0" cellspacing="0" cellpadding="0"><tr>
				  <td></td>
				<td><a href="<s:url value="/index.action" />" >Main</a></td>
                <td></td>
				<td colspan="2"><a href="<s:url value="/event.action" />" >Events</a></td>
				<td></td>
				<td><a href="<s:url value="/news.action" />" >News</a></td>
				<td></td>
				<td><a href="<s:url value="/login.action" />" >Login</a></td>
				<td></td>
				<td><a href="<s:url value="/info.action?key=prices" />" >Prices</a></td>
				<td></td>
				<td colspan="3"><a href="<s:url value="/info.action?key=about" />" >About</a></td>
				<td></td>
				<td colspan="2"><a href="<s:url value="/info.action?key=faq" />">FAQ</a></td>
				<td></td>
				<td colspan="2"><a href="<s:url value="/info.action?key=contacts" />" >Contacts</a></td>
				<td></td>
			    </tr></table></td>
			</tr>
			<tr>
				<td></td>
			</tr>
			<tr>
			<td>
			<s:component template="photobank/menu.jsp" />
			</td>
            </tr>
			<tr style="height: 100%">
				<td style="vertical-align: top">
				<table style="width: 100%; margin: 0px"
					border="0" cellpadding="0" cellspacing="0">
					<tr>
						<td style="width: 28px"></td>
						<td align="center">

						<decorator:body />

						</td>
						<td style="width: 28px"></td>
					</tr>
				</table>
				</td>
			</tr>
			<tr>
				<td></td>
			</tr>
		</table>
</td>
		<td style="width: 50%; margin: 0px" align="left" valign="bottom">
            <table width="127" border="0" cellpadding="0" cellspacing="0" style="height: 100%; margin: 0px">
                  <tr>
                    <td style="margin: 0px" align="left" valign="bottom"></td>
                  </tr>
                </table>
        </td>
	</tr>
</table>
</body>
</html>