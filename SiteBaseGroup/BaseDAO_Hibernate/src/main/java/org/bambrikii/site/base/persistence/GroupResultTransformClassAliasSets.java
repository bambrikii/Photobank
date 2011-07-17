package org.bambrikii.site.base.persistence;

import java.util.HashSet;
import java.util.Set;

public class GroupResultTransformClassAliasSets {
	private Class<?> type;
	private Set<String> aliases = new HashSet<String>();

	public GroupResultTransformClassAliasSets(Class<?> type, Set<String> aliases) {
		this.setType(type);
		this.setAliases(aliases);
	}

	public void setAliases(Set<String> aliases) {
		this.aliases = aliases;
	}

	public Set<String> getAliases() {
		return aliases;
	}

	public void setType(Class<?> type) {
		this.type = type;
	}

	public Class<?> getType() {
		return type;
	}
}