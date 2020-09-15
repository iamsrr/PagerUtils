package org.github.iamsrr;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Date: 2020/9/11 11:47
 * @Author: shy
 */
public class ListUtil {

    public static <T> List<T> castList(Object obj, Class<T> clazz) {
        List<T> result = new ArrayList<>();
        if (obj instanceof List<?>) {
            for (Object o : (List<?>) obj) {
                result.add(clazz.cast(o));
            }
            return result;
        }
        return null;
    }
}
