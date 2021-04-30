package net.dd.utils;


import net.dd.enums.ApiEnum;
import net.dd.exception.GlobalException;

import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Random;

public class MD5Util {

    private static final byte[] HEX = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 0xa, 0xb, 0xc, 0xd, 0xe, 0xf};

    /**
     * 可以把一段文字转换为MD5密钥
     * Can convert a file to MD5 key
     *
     * @param text
     * @return md5
     */
    public static String encode(String text) {
        if (text == null) throw new GlobalException(ApiEnum.FAILED);
        try {
            MessageDigest digest = MessageDigest.getInstance("md5");
            byte[] buffer = digest.digest(text.getBytes());
            // byte -128 ---- 127
            StringBuilder sb = new StringBuilder();
            for (byte b : buffer) {
                int a = b & 0xff;
                // Log.d(TAG, "" + a);
                String hex = Integer.toHexString(a);
                if (hex.length() == 1) {
                    hex = 0 + hex;
                }
                sb.append(hex);
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        throw new RuntimeException("MD5 encryption failed!");
    }

    /***
     * 任意文件转换成Md5密钥
     * Can convert a text to MD5 key
     * @param in
     * @return md5
     */
    public static String encode(InputStream in) {
        try {
            MessageDigest digester = MessageDigest.getInstance("MD5");
            byte[] bytes = new byte[8192];
            int byteCount;
            while ((byteCount = in.read(bytes)) > 0) {
                digester.update(bytes, 0, byteCount);
            }
            byte[] digest = digester.digest();

            // byte -128 ---- 127
            StringBuilder sb = new StringBuilder();
            for (byte b : digest) {
                int a = b & 0xff;
                // Log.d(TAG, "" + a);

                String hex = Integer.toHexString(a);

                if (hex.length() == 1) {
                    hex = 0 + hex;
                }

                sb.append(hex);
            }

            return sb.toString();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                in = null;
            }
        }
        throw new RuntimeException("MD5 encryption failed!");
    }

    /**
     * 加密算法
     **/
    public static String convertMD5(String id, String password) {
        char[] salt = MD5Util.encode(id).toCharArray();
        char[] pw = password.toCharArray();
        for (int i = 0; i < pw.length; i++) {
            pw[i] = (char) (salt[i] | pw[i] & salt[i]);
        }
        return new String(pw).replace(" ", "")
                .replace("'", "")
                .replace("\"", "")
                .replace("{", "")
                .replace("}", "")
                .replace("(", "")
                .replace(")", "")
                .replace(";", "")
                .replace("=", "");
    }

    public static boolean checkPwd(String rawPassword, String encodePassword) {
        return encodePassword.equals(rawPassword);
    }

    public static void main(String[] args) {
        String encode = MD5Util.encode("123456");
        System.out.println("密码加密后密钥=>" + encode);
        String demo1 = MD5Util.convertMD5("1", encode);
        System.out.println("加密后=>" + demo1);
        String demo2 = MD5Util.convertMD5("3", encode);
        System.out.println("加密2=>" + demo2);
        System.out.println("用户1是否相同=>" + MD5Util.convertMD5("1", MD5Util.encode("123456")).equals(demo1));
    }
}