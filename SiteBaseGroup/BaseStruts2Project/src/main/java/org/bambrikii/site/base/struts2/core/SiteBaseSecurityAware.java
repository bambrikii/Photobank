package org.bambrikii.site.base.struts2.core;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface SiteBaseSecurityAware {
	String[] allowedRoles() default {};
}
