package com.zhafei.util;

import org.apache.tomcat.util.codec.binary.Base64;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.*;

/**
 * RSA非对称加密
 * 安全
 */
public class RSAUtil {
    private static final String ENCODE_RULES = "com/zhafei";

    private static final String ALGORITHM = "RSA";
    /**
     * 里面包含公钥、私钥
     */
    private static  KeyPair keyPair = null;
    /**
     * 生成Key.
     * @return
     */
    static  {
        try {
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(ALGORITHM);
            SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
            random.setSeed(ENCODE_RULES.getBytes());
            // RSA keys must be at least 512 bits long
            keyPairGenerator.initialize(512, random);
            // 生成一个密钥对，保存在keyPair中
            keyPair = keyPairGenerator.generateKeyPair();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 获取公钥
     * @return
     */
    public static String getPublic(){
        return new String(Base64.encodeBase64(keyPair.getPublic().getEncoded()));
    }
    /**
     * 加密
     */
    public static String rsaEncrypt(String content){
        try {
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(Cipher.ENCRYPT_MODE, keyPair.getPublic());
            byte[] byteEncode = content.getBytes("utf-8");
            byte[] bytes = cipher.doFinal(byteEncode);
            //这里用Base64Encoder中会找不到包
            //解决办法：
            //在项目的Build path中先移除JRE System Library，再添加库JRE System Library，重新编译后就一切正常了。
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
     * @param content
     * @return
     */
    public static String rsaDecrypt(String content){
        try {
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(Cipher.DECRYPT_MODE, keyPair.getPrivate());
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
        System.out.println("公钥："+getPublic());
        System.out.println("私钥："+new String(Base64.encodeBase64(keyPair.getPrivate().getEncoded())));
        String[] keys = {
                "", "123456789"
        };
        System.out.println("key | DESEncode | DESDecode");
        for (String key : keys) {
            System.out.print(key + " | ");
            String encryptString = rsaEncrypt(key);
            System.out.print(encryptString + " | ");
            String decryptString = rsaDecrypt(encryptString);
            System.out.println(decryptString);
        }
    }
}
