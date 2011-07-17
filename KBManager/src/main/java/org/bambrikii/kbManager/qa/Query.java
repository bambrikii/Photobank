package org.bambrikii.kbManager.qa;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bambrikii.kbManager.parser.model.Knowledge;

public class Query {

	Map<String, String> filters = new HashMap<String, String>();

	public Query condition(String subject, String object) {
		filters.put(subject, object);
		return this;
	}

	public Query condition(String subject, Query object) {
		return this;
	}

	public List<Knowledge> list() {
		StringBuilder sb = new StringBuilder();
		sb.append(" from Knowledge kn1");
		if (filters.size() > 0) {
			sb.append(" where ");
			for (String sibject : filters.keySet()) {
				// sb.
			}
		}

		return null;
	}
}
