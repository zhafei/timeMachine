package com.zhafei.util;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

/**
 * DES对称加密
 */
public class DESUtil {

    private static String ENCODE_RULES = "com/zhafei";

    private static final String ALGORITHM = "DES";

    private static SecretKey secretKey = null;
    /**
     * 生成Key
     */
    static {
        try {
            KeyGenerator keyGenerator = KeyGenerator.getInstance(ALGORITHM);

            //生成一个56位的随机源,根据传入的字节数组
            SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
            random.setSeed(ENCODE_RULES.getBytes());
            keyGenerator.init(56, random);
            SecretKey originalKey = keyGenerator.generateKey();
            byte[] raw = originalKey.getEncoded();
            secretKey = new SecretKeySpec(raw, ALGORITHM);

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
    /**
     * 加密
     */
    public static String desEncrypt(String content){
        try {
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            byte[] byteEncode = content.getBytes("utf-8");
            byte[] bytes = cipher.doFinal(byteEncode);
            String encode = new String(new BASE64Encoder().encode(bytes));
            return encode;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        //如果有错就返加nulll
        return null;
    }
    /**
     * 解密
     */
    public static String desDecrypt(String content){
        try {
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            byte[] byteContent = new BASE64Decoder().decodeBuffer(content);
            /*
             * 解密
             */
            byte[] byteDecode = cipher.doFinal(byteContent);
            String decode = new String(byteDecode, "utf-8");
            return decode;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        }
        //如果有错就返加nulll
        return null;
    }
    public static void main(String[] args) throws NoSuchAlgorithmException {

        String[] keys = {
                "", "123456789"
        };
        System.out.println("key | DESEncode | DESDecode");
        for (String key : keys) {
            System.out.print(key + " | ");
            String encryptString = desEncrypt(key);
            System.out.print(encryptString + " | ");
            String decryptString = desDecrypt(encryptString);
            System.out.println(decryptString);
        }
    }
}
