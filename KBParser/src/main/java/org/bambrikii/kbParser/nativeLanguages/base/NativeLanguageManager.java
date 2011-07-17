package org.bambrikii.kbParser.nativeLanguages.base;

import java.lang.reflect.InvocationTargetException;

public interface NativeLanguageManager<P> {
	public P parseText(String text) throws SecurityException, NoSuchMethodException, IllegalArgumentException, InstantiationException, IllegalAccessException, InvocationTargetException;
}
