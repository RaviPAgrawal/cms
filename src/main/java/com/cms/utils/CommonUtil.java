package com.cms.utils;

import java.util.Collection;

public final class CommonUtil {

	private CommonUtil() {

	}

	public static boolean isNotNull(Object obj) {
		return (null != obj ? true : false);
	}

	public static boolean isNull(Object obj) {
		return (null == obj ? true : false);
	}
	
	public static boolean notNullAndEmpty(Collection<?> collection) {
        return collection != null && !collection.isEmpty();
    }

    public static boolean nullOrEmpty(Collection<?> collection) {
        return collection == null || collection.isEmpty();
    }

}
