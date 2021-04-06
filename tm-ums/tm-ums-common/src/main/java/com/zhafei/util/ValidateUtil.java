package com.zhafei.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateUtil {
    /**
     * 验证手机号码
     * @param mobiles
     * @return
     */
    public static boolean isMobileNO(String mobiles){
        boolean flag = false;
        try{
            final Pattern HK_PATTERN = Pattern.compile("^(5|6|8|9)\\d{7}$");
            final Pattern CHINA_PATTERN = Pattern.compile("^((13[0-9])|(14[0,1,4-9])|(15[0-3,5-9])|(16[2,5,6,7])|(17[0-8])|(18[0-9])|(19[0-3,5-9]))\\d{8}$");
            Matcher m = CHINA_PATTERN.matcher(mobiles);
            flag = m.matches()||HK_PATTERN.matcher(mobiles).matches();
        }catch(Exception e){
            throw new RuntimeException(e);
        }
        return flag;
    }
    /**
     * 验证邮箱地址是否正确
     * @param email
     * @return
     */
    public static boolean checkEmail(String email){
        boolean flag = false;
        try{
            String check = "\\w[-\\w.+]*@([A-Za-z0-9][-A-Za-z0-9]+\\.)+[A-Za-z]{2,14}";
            Pattern regex = Pattern.compile(check);
            Matcher matcher = regex.matcher(email);
            flag = matcher.matches();
        }catch(Exception e){
            throw new RuntimeException(e);
        }

        return flag;
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
