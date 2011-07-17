package org.bambrikii.site.base.auth.dao;

import java.util.List;

import org.bambrikii.site.base.auth.model.User;

public interface IPrivilegeDAO {

	public abstract List<String> getRolesList(User user);

}