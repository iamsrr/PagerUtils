package org.github.iamsrr;

import java.util.Iterator;
import java.util.List;

/**
 * @Explain:
 * @Description:
 * @Author: Shihy
 * @Date: 2020/3/23 9:57
 * @tip:
 */
public class ArraysUtil {

    public static boolean isIn(List source, Object flag) {
        boolean b = false;
        Iterator<Object> it = source.iterator();
        while (it.hasNext()) {
            Object next = it.next();
            if (next.equals(flag) || next == flag) {
                b = true;
                break;
            }
        }
        return b;
    }
}
