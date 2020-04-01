package org.github.iamsrr;

import java.io.*;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * @Description:
 * @Author: Shihy
 * @Date: 2018/5/8 16:26
 */
public class ZipUtils {

    public static String createZip(List<String> names, String sourcePath, String zipPath) {

        boolean result = false;

        //源文件目录路径
        //String sourcePath = "D:/test/";

        //生成后的压缩包名称
        String zipName = System.currentTimeMillis() + ".zip";

        //生成压缩包的目录
        //String zipPath = "D:/test/";

        File sourceFile = new File(sourcePath);
        FileInputStream fis;
        BufferedInputStream bis = null;
        FileOutputStream fos;
        ZipOutputStream zos = null;

        try {
            //组合压缩包名
            File zipFile = new File(zipPath + "/" + zipName);
            //获取该目录下的所有文件
            File[] sourceFiles = sourceFile.listFiles();

            File[] newSourceFiles = new File[names.size()];
            for (int i = 0; i < names.size(); i++) {
                String picName = names.get(i);
                for (int f = 0; f < sourceFiles.length; f++) {
                    if (picName.equals(sourceFiles[f].getName())) {
                        newSourceFiles[i] = sourceFiles[f];
                        break;
                    }
                }
            }

            sourceFiles = newSourceFiles;

            fos = new FileOutputStream(zipFile);
            zos = new ZipOutputStream(new BufferedOutputStream(fos));
            byte[] bufs = new byte[1024 * 10];
            for (int i = 0; i < sourceFiles.length; i++) {
                // create .zip and put pictures in
                ZipEntry zipEntry = new ZipEntry(sourceFiles[i].getName());
                zos.putNextEntry(zipEntry);
                // read documents and put them in the zip
                fis = new FileInputStream(sourceFiles[i]);
                bis = new BufferedInputStream(fis, 1024 * 10);
                int read = 0;
                while ((read = bis.read(bufs, 0, 1024 * 10)) != -1) {
                    zos.write(bufs, 0, read);
                }
            }
            result = true;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            try {
                if (null != bis)
                    bis.close();
                if (null != zos)
                    zos.close();
            } catch (IOException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
        }
        return zipName;
    }

    public boolean createCardImgZip(String sourcePath, String zipName) {
        boolean result = false;
        String zipPath = "D:/test/";
        File sourceFile = new File(sourcePath);
        FileInputStream fis = null;
        BufferedInputStream bis = null;
        FileOutputStream fos = null;
        ZipOutputStream zos = null;

        if (sourceFile.exists() == false) {
            System.out.println("File catalog:" + sourcePath + "not exist!");
        } else {
            try {
                if (!new File(zipPath).exists()) {
                    new File(zipPath).mkdirs();
                }
                File zipFile = new File(zipPath + "/" + zipName + ".zip");
                if (zipFile.exists()) {
                    System.out.println(zipPath + "Catalog File: " + zipName + ".zip" + "pack file.");
                } else {
                    File[] sourceFiles = sourceFile.listFiles();
                    if (null == sourceFiles || sourceFiles.length < 1) {
                        System.out.println("File Catalog:" + sourcePath + "nothing in there,don't hava to compress!");
                    } else {
                        fos = new FileOutputStream(zipFile);
                        zos = new ZipOutputStream(new BufferedOutputStream(fos));
                        byte[] bufs = new byte[1024 * 10];
                        for (int i = 0; i < sourceFiles.length; i++) {
                            // create .zip and put pictures in
                            ZipEntry zipEntry = new ZipEntry(sourceFiles[i].getName());
                            zos.putNextEntry(zipEntry);
                            // read documents and put them in the zip
                            fis = new FileInputStream(sourceFiles[i]);
                            bis = new BufferedInputStream(fis, 1024 * 10);
                            int read = 0;
                            while ((read = bis.read(bufs, 0, 1024 * 10)) != -1) {
                                zos.write(bufs, 0, read);
                            }
                        }
                        result = true;
                    }
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            } catch (IOException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            } finally {
                try {
                    if (null != bis)
                        bis.close();
                    if (null != zos)
                        zos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    throw new RuntimeException(e);
                }
            }
        }
        return result;
    }


}
