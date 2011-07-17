package org.bambrikii.site.base.auth.dao;

import java.util.List;

import org.bambrikii.site.base.auth.model.User;
import org.bambrikii.site.base.auth.model.UserStatusEnum;

public interface IUserDAO {

	public abstract User getByLogin(String login);

	public abstract Integer getUsersCount();

	public abstract Integer getUsersCount(List<UserStatusEnum> statuses);

	public abstract List<User> getUsersList(List<UserStatusEnum> statuses,
			String order, Integer start, Integer length);

}