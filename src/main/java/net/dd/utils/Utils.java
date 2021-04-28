package net.dd.utils;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Objects;
import java.util.UUID;

public class Utils {

    public static void main(String[] args) {
        System.out.println(generateUUName("helloworld.mp4"));
    }

    public static String generateUUName(String fileName) {
        SimpleDateFormat fmt = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        return fmt.format(new Date()) + "-" + UUID.randomUUID().toString() + "." + getExtension(fileName);
    }

    public static String getExtension(String fileName) {
        if (!checkLeagle(fileName)) throw new InputMismatchException("文件名: " + fileName + "不合法");
        return fileName.substring(fileName.lastIndexOf(".") + 1);
    }

    private static boolean checkLeagle(String fileName) {
        assert fileName != null;
        fileName = fileName.trim();
        int dot = fileName.lastIndexOf(".");
        return dot != -1 && dot != 0 && dot + 1 != fileName.length();
    }

    public static boolean retBool(Integer insert) {
        return null != insert && insert >= 1;
    }

}
