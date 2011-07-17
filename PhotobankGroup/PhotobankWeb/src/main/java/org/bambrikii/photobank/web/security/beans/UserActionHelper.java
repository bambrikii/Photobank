package org.bambrikii.photobank.web.security.beans;

import org.bambrikii.site.base.auth.model.User;
import org.bambrikii.site.base.model.Language;
import org.bambrikii.site.base.struts2.security.beans.AuthBean;

import com.opensymphony.xwork2.ActionSupport;

public class UserActionHelper {
	public static void validate(ActionSupport action, User user) {
		if (user == null || user.getLogin() == null
				|| "".equals(user.getLogin())) {
			action.addFieldError("model.login",
					action.getText("profile.login.invalid"));
		}
		if (user == null || user.getEmail() == null
				|| !user.getEmail().matches(AuthBean.EMAIL_VALIDATION_PATTERN)) {
			action.addFieldError("model.email",
					action.getText("profile.email.invalid"));
		}
		if (user == null || user.getFirstname() == null
				|| "".equals(user.getFirstname())) {
			action.addFieldError("model.firstname",
					action.getText("profile.name.invalid"));
		}
		if (user == null || user.getSurname() == null
				|| "".equals(user.getSurname())) {
			action.addFieldError("model.surname",
					action.getText("profile.surname.invalid"));
		}
		if (user == null || user.getPatronymic() == null
				|| "".equals(user.getPatronymic())) {
			action.addFieldError("model.patronymic",
					action.getText("profile.patronymic.invalid"));
		}
		if (user == null || user.getOrganization() == null
				|| "".equals(user.getOrganization())) {
			action.addFieldError("model.organization",
					action.getText("profile.organization.invalid"));
		}
	}

	public static void copyData(AuthBean authBean, User src, User dst)
			throws Exception {
		dst.setEmail(src.getEmail());
		dst.setPassword(src.getPassword());
		dst.setFirstname(src.getFirstname());
		dst.setSurname(src.getSurname());
		dst.setAbout(src.getAbout());
		dst.setAddress(src.getAddress());
		dst.setDateOfBirth(src.getDateOfBirth());
		dst.setSortOfActivity(src.getSortOfActivity());
		if (src.getLanguage() != null) {
			Language language = authBean.getLanguageById(src.getLanguage()
					.getId());
			dst.setLanguage(language);
		}
		if (src.getPhones() != null && src.getPhones().size() > 0
				&& src.getPhones().get(0).getNumber() != null
				&& src.getPhones().get(0).getNumber().trim() != "") {
			authBean.setUserPhone(dst, src.getPhones().get(0).getNumber());
		}
		dst.setPatronymic(src.getPatronymic());
	}
}
