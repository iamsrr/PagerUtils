package org.github.iamsrr.ecode;

import org.github.iamsrr.EntityUtil;

import java.io.UnsupportedEncodingException;

/**
 * @Description:
 * @Author: Shihy
 * @Date: 2018/1/11 17:10
 */
public class Ecode {

    private final String UTF_8 = "UTF-8";
    private final String GB2312 = "GB2312";
    private final String ISO_8859_1 = "ISO-8859-1";
    private final String GBK = "GBK";

    public static String charat(String str) {
        if (!EntityUtil.isEmpty(str)) {
            return null;
        }
        String s = str;
        try {
            s = new String(str.getBytes("ISO-8859-1"), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return s;
    }

    /**
     * 自动判断参数编码类型并且转换成UTF-8
     *
     * @param str
     * @return
     */
    public static String charatAuto(String str) {
        String encodType = new Ecode().getEncodType(str);
        String s = null;
        try {
            s = new String(str.getBytes(encodType), "utf-8");
        } catch (Exception e) {
            e.printStackTrace();
            return str;
        }
        return s;
    }

    /**
     * 自动判断参数编码类型
     *
     * @param str
     * @return
     */
    private String getEncodType(String str) {

        int count = 0;
        String type = null;

        try {
            if (str.equals(new String(str.getBytes(GB2312), GB2312))) {
                type = GB2312;
                count++;
            }
            if (str.equals(new String(str.getBytes(ISO_8859_1), ISO_8859_1))) {
                type = ISO_8859_1;
                count++;
            }
            /*if (str.equals(new String(str.getBytes(UTF_8), UTF_8))) {
                type = UTF_8;
            }*/
            if (str.equals(new String(str.getBytes(GBK), GBK))) {
                type = GBK;
                count++;
            }

        } catch (Exception exception3) {
            return "no charSet matched";
        }

        if (count > 1) {
            try {
                str.getBytes("utf-8");
                type = UTF_8;
            } catch (UnsupportedEncodingException e) {

            }
        }
        return type;
    }

}
