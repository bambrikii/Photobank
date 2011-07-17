<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title><s:property value="%{getText('register')}" /></title>
</head>
<body>

<s:component template="photobank/core/content_pre1.jsp">
	<s:param name="titleWidth" value="'150px'" />
</s:component>
<span class="wintitl win_title" style="text-transform: uppercase;">
<s:property value="%{getText('register')}" /> </span>
<s:component template="photobank/core/content_pre2.jsp" />



<span id="label_text__organization_sortOfActivity_Internet"
	style="display: none;"><s:property
	value="%{getText('register.organization.sortOfActivity.Internet')}" />
</span>
<span id="label_text__organization_sortOfActivity_TV"
	style="display: none;"><s:property
	value="%{getText('register.organization.sortOfActivity.TV')}" /></span>
<span id="label_text__organization_sortOfActivity_Cinema"
	style="display: none;"><s:property
	value="%{getText('register.organization.sortOfActivity.TV')}" /></span>
<span id="label_text__organization_sortOfActivity_Other"
	style="display: none;"><s:property
	value="%{getText('register.organization.sortOfActivity.Other')}" /></span>

<script type="text/javascript">
	function setOrganizationField(elem) {
		switch (elem.val()) {
		case "Internet":
		case "TV":
		case "Cinema":
		case "Other":
			$("label[for='register_model_organization']").text(
					$("#label_text__organization_sortOfActivity_" + elem.val())
							.text().trim()).append(
					"<span class=\"required\">*</span>").append(":");
			elem.parent().parent().next().css("display", "");
			break;
		default:
			$("label[for='register_model_organization']").text("");
			elem.parent().parent().next().css("display", "none");
			break;
		}
	}
	$("document").ready(function() {
		setOrganizationField($("#register_model_sortOfActivity"));
	});
</script>
<s:form method="post">
	<s:textfield name="model.login" value="%{model.login}"
		key="profile.login" required="true" />
	<s:textfield name="model.email" value="%{model.email}"
		key="profile.email" required="true" />
	<s:textfield name="model.firstname" value="%{model.firstname}"
		key="profile.name" required="true" />
	<s:textfield name="model.surname" value="%{model.surname}"
		key="profile.surname" required="true" />
	<s:textfield name="model.patronymic" value="%{model.patronymic}"
		key="profile.patronymic" required="true" />
	<s:textarea name="model.address" value="%{model.address}"
		key="profile.address" />



	<s:select name="model.sortOfActivity"
		list="{

		new org.bambrikii.photobank.web.security.beans.SortOfActivity('Internet', getText('register.sortOfActivity.Internet')),
		new org.bambrikii.photobank.web.security.beans.SortOfActivity('TV', getText('register.sortOfActivity.TV')),
		new org.bambrikii.photobank.web.security.beans.SortOfActivity('Cinema', getText('register.sortOfActivity.Cinema')),
		new org.bambrikii.photobank.web.security.beans.SortOfActivity('Other', getText('register.sortOfActivity.Other'))

		}"
		listKey="key" listValue="value" value="%{model.sortOfActivity}"
		onchange="javascript:setOrganizationField($(this));"
		key="profile.sortOfActivity"></s:select>
	<s:textfield name="model.organization" value="%{model.organization}"
		key="profile.organization" required="true" />

	<s:password name="model.password" value="%{model.password}"
		key="profile.password" required="true" />

	<s:password name="passwordAgain" value="%{passwordAgain}"
		key="profile.passwordAgain" required="true" />

	<s:textfield name="model.phones[0].number"
		value="%{model.phones[0].number}" key="profile.phone" />
	<s:select name="model.language.id" list="%{availableLanguages}"
		listKey="id" listValue="name" value="%{model.language.id}"
		key="profile.locale">
	</s:select>

	<tr>
		<td></td>
		<td><img src="<s:url value="/kaptcha.jpg" />" /></td>
	</tr>
	<s:textfield name="captcha" value="%{captcha}" key="captcha"></s:textfield>
	<s:submit action="register!apply" key="action.register" />
</s:form>

<s:actionerror escape="true" />
<s:actionmessage escape="true" />
<s:component template="photobank/core/content_post.jsp" />
</body>
</html>