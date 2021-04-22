package com.zhafei.ums.util;


import java.security.MessageDigest;

/**
 * @author yyf
 * @version v1.0
 * @description MD5散列加密（MD5为不可逆加密）
 * @create 2021/4/22 11:07:55
 */
public class MD5Util {
    private static final String salt = "1a2b3c4d";

    private static final String[] HEX_DIGITS = { "0", "1", "2", "3", "4", "5",
            "6", "7", "8", "9", "a", "b", "c", "d", "e", "f" };

    private static String byteToHexString(byte b) {
        int n = b;
        if (n < 0) {
            n += 256;
        }
        int d1 = n / 16;
        int d2 = n % 16;
        return HEX_DIGITS[d1] + HEX_DIGITS[d2];
    }
    public static String byteArrayToHexString(byte[] b) {
        StringBuilder resultSb = new StringBuilder();
        for (byte value : b) {
            resultSb.append(byteToHexString(value));
        }
        return resultSb.toString();
    }
    public static String MD5Encode(String origin, String charsetName) {
        String resultString;
        try {
            resultString = new String(origin);
            MessageDigest md = MessageDigest.getInstance("MD5");
            if (charsetName == null || "".equals(charsetName)) {
                resultString = byteArrayToHexString(md.digest(resultString.getBytes()));
            } else {
                resultString = byteArrayToHexString(md.digest(resultString.getBytes(charsetName)));
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return resultString;
    }
    public static String MD5Encode(String origin) {
        return MD5Encode(origin,"utf-8");
    }

    public static String md5(String content,String salt){
        String str = salt.charAt(5)+salt.charAt(2)+salt.charAt(0)+content;
        return MD5Encode(str);
    }
    public static String md5Once(String content){
        return md5(content,salt);
    }

    public static String md5Twice(String md5Once,String salt){
        return md5(md5Once,salt);
    }

    public static void main(String[] args) {
//        01ceac78097a9cd365a9d0628d4f44c6
//        8da368a4a3752b3c86ac84e2dd380594
        System.out.println(md5Twice("123456",salt));
    }

}
