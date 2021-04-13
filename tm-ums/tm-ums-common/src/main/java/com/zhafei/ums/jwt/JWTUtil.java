package com.zhafei.ums.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Calendar;
import java.util.Map;

/**
 * JWT存在两个问题
 * 1.当用户信息更改时，无法实时同步到payload
 * 2.用户退出登录后，无法立即失效token
 * @author yyf
 */
public class JWTUtil {
    /**
     * 盐
     */
    private static final String SALT = "com/zhafei";
    /**
     * 过期时间
     */
    private static final int EXPIRES_TIME = 60 * 5;

    /**
     * 生成token
     * header.payload.sign
     *
     * @param payloads
     * @return
     */
    public static String createToken(Map<String, String> payloads) {
        final JWTCreator.Builder builder = JWT.create();
        //payload
        payloads.forEach(builder::withClaim);
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.SECOND, EXPIRES_TIME);

        return builder.withExpiresAt(calendar.getTime()).sign(Algorithm.HMAC256(SALT));
    }
    /**
     * 验证token合法性
     * @param token
     * @return
     */
    public static DecodedJWT verify(String token) {
        return JWT.require(Algorithm.HMAC256(SALT)).build().verify(token);
    }
}
