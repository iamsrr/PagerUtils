package org.github.iamsrr;

import sun.misc.BASE64Decoder;

import java.io.*;

/**
 * @Explain:
 * @Description:
 * @Author: Shihy
 * @Date: 2019/1/29 13:33
 */
public class MyFileUtil {

    public static String encodeImgBase64(File file) {
        String image = null;
        try {
            FileInputStream fis = new FileInputStream(file);
            int available = fis.available();
            byte[] bytes = new byte[available];
            fis.read(bytes);
            fis.close();
            image = Base64Util.encode(bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return image;
    }

    public static boolean base64GenImg(String base64, String savePath) {   //对字节数组字符串进行Base64解码并生成图片
        if (null == base64 || base64.length() == 0) //图像数据为空
            return false;
        BASE64Decoder decoder = new BASE64Decoder();
        try {
            //Base64解码
            byte[] b = decoder.decodeBuffer(base64);
            for (int i = 0; i < b.length; ++i) {
                if (b[i] < 0) {//调整异常数据
                    b[i] += 256;
                }
            }
            //生成jpeg图片
            OutputStream out = new FileOutputStream(savePath);//savePath: flag = "c:/window/1.jpg";
            out.write(b);
            out.flush();
            out.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
