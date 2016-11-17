package com.ldxx.utils;

public class StringUtils {
	public static boolean isEmpty(String str) {
        if (null == str) {
            return true;
        }
        str = str.trim();
        return str.length() == 0;
    }
}
