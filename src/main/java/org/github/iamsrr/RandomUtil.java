package org.github.iamsrr;

import java.util.ArrayList;
import java.util.List;

/**
 * @Explain:
 * @Description:
 * @Author: Shihy
 * @Date: 2018/12/29 14:30
 */
public class RandomUtil {

    public static String random(int lenth) {
        int f = 1;
        for (int i = 1; i < lenth; i++) {
            f *= 10;
        }
        int random = (int) ((Math.random() * 9 + 1) * f);
        return random + "";
    }

    public static List<String> genDiffentRandom(int count, int lenth) {

        List<String> list = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            while (true) {
                String random = RandomUtil.random(lenth);
                if (judgeDiffent(list, random)) {
                    continue;
                } else {
                    list.add(random);
                    break;
                }
            }

        }
        return list;
    }

    private static boolean judgeDiffent(List<String> list, String code) {
        for (String str : list) {
            if (str.equals(code)) {
                return true;
            }
        }
        return false;
    }

    public static String genCode(List<String> list, int lenth) {
        String random = null;
        boolean flag = true;
        while (true) {
            random = RandomUtil.random(lenth);
            for (String str : list) {
                if (random.equals(str)) {
                    flag = false;
                    break;
                }
            }

            if (flag) {
                break;
            }
        }
        return random;
    }

}
