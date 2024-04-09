package com.example.metaversebackend.utils;

public class StringUtil {

    public static String trim(String value, char charToTrim) {
        value = trimStart(value, charToTrim);
        value = trimEnd(value, charToTrim);
        return value;
    }

    public static String trimStart(String value, char charToTrim) {
        while (value.charAt(0) == charToTrim) value = value.substring(1);
        return value;
    }

    public static String trimEnd(String value, char charToTrim) {
        int lastIndex = value.length() - 1;
        while (value.charAt(lastIndex) == charToTrim) {
            value = value.substring(0, lastIndex);
            lastIndex = value.length() - 1;
        }
        return value;
    }

    public static String toSnakeCase(String camelCaseString) {
        return camelCaseString.replaceAll("([a-z])([A-Z])", "$1_$2").toLowerCase();
    }

}
