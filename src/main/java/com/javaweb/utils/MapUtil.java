package com.javaweb.utils;

import java.util.Map;

public class MapUtil {
	public static <T> T getObject(Map<String, Object> params, String key, Class<T> tClass) {
	    Object obj = params.get(key);
	    if (obj == null || obj.toString().trim().isEmpty()) {
	        return null;
	    }
	    if (tClass == Long.class) {
	        return tClass.cast(Long.valueOf(obj.toString()));
	    } else if (tClass == Integer.class) {
	        return tClass.cast(Integer.valueOf(obj.toString()));
	    } else if (tClass == String.class) {
	        return tClass.cast(obj.toString());
	    }
	    return null;
	}
}
