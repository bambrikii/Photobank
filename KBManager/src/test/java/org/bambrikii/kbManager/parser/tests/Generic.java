package org.bambrikii.kbManager.parser.tests;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class Generic<T> {
	public String classToString() {
		return getClass().toString();
	}

	public String toString() {
		Type type = getClass().getGenericSuperclass();
		return "Type Parameter  is " + type.toString() + ".";
	}

	@SuppressWarnings("unchecked")
	public T getInstance() throws InstantiationException,
			IllegalAccessException {
		Type type = getClass().getGenericSuperclass();
		T newInstance = (T) type.getClass().newInstance();
		return newInstance;
	}

	@SuppressWarnings("unchecked")
	public void info() {
		//Type t = getClass();
		//System.out.printf("%s\n", t.toString());
		//System.out.printf("%s\n", t.getClass().getGenericSuperclass().toString());
		//System.out.printf("%s\n", t.getClass().getGenericSuperclass().toString());
		
		 ParameterizedType superClass = (ParameterizedType) getClass().getGenericSuperclass();
        Class<T> type = (Class<T>) superClass.getActualTypeArguments()[0];

		
		System.out.printf("ParameterizedType: %s\n", type.toString());
	}
}