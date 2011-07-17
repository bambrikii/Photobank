package org.bambrikii.site.base.persistence;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.HibernateException;
import org.hibernate.property.ChainedPropertyAccessor;
import org.hibernate.property.PropertyAccessor;
import org.hibernate.property.PropertyAccessorFactory;
import org.hibernate.property.Setter;
import org.hibernate.transform.ResultTransformer;

public class GroupResultTransformer implements ResultTransformer {

	private static final long serialVersionUID = 6886773196693023635L;

	private Map<String, Class<?>> aliasClassMap;
	private final List<GroupResultTransformClassAliasSets> resultClasses;
	private final ChainedPropertyAccessor propertyAccessor;
	private Setter[] setters;

	public GroupResultTransformer(
			List<GroupResultTransformClassAliasSets> resultClasses) {
		if (resultClasses == null) {
			throw new IllegalArgumentException("resultClasses cannot be null");
		}
		this.resultClasses = resultClasses;
		aliasClassMap = new LinkedHashMap<String, Class<?>>();
		PropertyAccessor[] acc = new PropertyAccessor[this.resultClasses.size() + 1];
		for (int i = 0; i < this.resultClasses.size(); i++) {
			GroupResultTransformClassAliasSets cass = this.resultClasses.get(i);
			for (String als : cass.getAliases()) {
				aliasClassMap.put(als, cass.getType());
			}
			acc[i] = PropertyAccessorFactory.getPropertyAccessor(
					cass.getType(), null);
		}
		acc[this.resultClasses.size()] = PropertyAccessorFactory
				.getPropertyAccessor("field");
		propertyAccessor = new ChainedPropertyAccessor(acc);
	}

	public Object transformTuple(Object[] tuple, String[] aliases) {

		Map<Class<?>, Object> results = new LinkedHashMap<Class<?>, Object>();

		try {
			if (setters == null) {
				setters = new Setter[aliases.length];
				for (int i = 0; i < aliases.length; i++) {
					String alias = aliases[i];
					if (alias != null) {
						Class<?> resultClass = aliasClassMap.get(alias);
						if (resultClass != null) {
							setters[i] = propertyAccessor.getSetter(
									resultClass, alias);
						}
					}
				}
			}
			for (int i = 0; i < aliases.length; i++) {
				Class<?> resultClass = aliasClassMap.get(aliases[i]);
				if (resultClass != null) {
					if (!results.containsKey(resultClass)) {
						results.put(resultClass, resultClass.newInstance());
					}
					Object result = results.get(resultClass);
					if (setters[i] != null) {
						setters[i].set(result, tuple[i], null);
					}
				}
			}
		} catch (InstantiationException e) {
			throw new HibernateException("Could not instantiate resultclass: ",
					e);
		} catch (IllegalAccessException e) {
			throw new HibernateException("Could not instantiate resultclass: ",
					e);
		}

		Object[] arr = results.values().toArray();
		return (resultClasses.size() == 1) ? arr[0] : arr;
	}

	public List transformList(List collection) {
		return collection;
	}

}
