package org.bambrikii.site.base.struts2.core.crud;

public interface BaseCrudAction {
	public final String EDIT_RESULT = "edit";

	public abstract String save() throws Exception;

	public abstract String delete() throws Exception;

	public abstract String edit() throws Exception;
}
