package com.zhafei.ums.util;

import com.zhafei.ums.exception.UmsException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 验证工具类
 * @author yyf
 */
public class ValidateUtil {
    /**
     * 验证手机号码
     * @param mobiles 手机号
     * @return 是true,反之false
     */
    public static boolean isMobileNo(String mobiles){
        try{
            String hkCheck = "^(5|6|8|9)\\d{7}$";
            String chinaCheck = "^((13[0-9])|(14[0,1,4-9])|(15[0-3,5-9])|(16[2,5,6,7])|(17[0-8])|(18[0-9])|(19[0-3,5-9]))\\d{8}$";
            final  Pattern hkPattern = Pattern.compile(hkCheck);
            final Pattern chinaPattern = Pattern.compile(chinaCheck);
            Matcher m = chinaPattern.matcher(mobiles);
            return m.matches()||hkPattern.matcher(mobiles).matches();
        }catch(Exception e){
            throw new UmsException(e);
        }
    }
    /**
     * 验证邮箱地址是否正确
     * @param email 邮箱
     * @return 是true,反之false
     */
    public static boolean checkEmail(String email){
        try{
            String check = "\\w[-\\w.+]*@([A-Za-z0-9][-A-Za-z0-9]+\\.)+[A-Za-z]{2,14}";
            Pattern regex = Pattern.compile(check);
            Matcher matcher = regex.matcher(email);
            return matcher.matches();
        }catch(Exception e){
            throw new UmsException(e);
        }
    }

    public static void main(String[] args) {
        String[] s = new String[]{
                "231@qq.com","23454541@qsq.com","212321@163.com","212321@126.com","212321@sina.com"
        };
        for (int i = 0; i < s.length; i++) {
            System.out.println(s[i]+":"+checkEmail(s[i]));
        }
    }
}
