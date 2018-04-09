package com.util;

/**
 * @Description:
 * @Author: Shihy
 * @Date: 2018/4/4 14:23
 */
public class EntityUtil {


    public static boolean isEmpty(String... str) {
        String string = null;
        for (int i = 0; i < str.length; i++) {
            if (null == str[i]) {
                return false;
            } else {
                string = str[i].trim();
                if ("".equals(string) || "null".equals(string)) {
                    return false;
                }
            }
        }
        return true;
    }


}
