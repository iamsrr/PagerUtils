package org.github.iamsrr;

/**
 * @Explain:
 * @Description:
 * @Author: Shihy
 * @Date: 2019/6/25 17:23
 */
public class DoubleUtil {

    public static double formatDouble(double d, int length) {
        String format = null;
        if (length > 0) {
            format = "%." + length + "f";
        }
        return Double.parseDouble(String.format(format, d));
    }
}
