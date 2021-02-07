package com.lt.common.utils;

import com.lt.common.constant.JwtConstant;
import com.lt.common.constant.UserConstant;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * @author xiaohu
 * @version 1.0
 * @date 2021/2/5 15:55
 */
public class JwtUtils {

    //前台登录一天有效期或者该为一个月有效期
    public static final long EXPIRE = 1000 * 60 * 60 * 24;
   // public static final long EXPIREADMIN = 1000 * 60 * 60 * 30;//后台登录有效期30分钟
    public static final String APP_SECRET = "xiaohuXIAOXIAOKEXIANtengteng";
    //设置过期时间的token//考虑到token的可以后台删除存储到reids中//每次用户登录都重新存储到reids中

    public static String getJwtToken(String id, String username){

        String JwtToken = Jwts.builder()
                .setHeaderParam("typ", "JWT")
                .setHeaderParam("alg", "HS256")
                //setSubject可以随意设置
                .setSubject(JwtConstant.JWT_SUBJECT)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRE))
                .claim("id", id)
                .claim("username", username)
                .signWith(SignatureAlgorithm.HS256, APP_SECRET)
                .compact();

        return JwtToken;
    }

    /**
     * 此token可以存redis中，
     * 也可以校验
     * 二选一的形式
     * 判断token是否存在与有效
     * @param jwtToken
     * @return
     */
    public static boolean checkToken(String jwtToken) {
        if(StringUtils.isEmpty(jwtToken)){
            return false;
        }
        try {
            Jwts.parser().setSigningKey(APP_SECRET).parseClaimsJws(jwtToken);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * 判断token是否存在与有效
     * @param request
     * @return
     */
    public static boolean checkToken(HttpServletRequest request) {
        try {
            String jwtToken = request.getHeader(JwtConstant.JWT_TOCKEN);
            if(StringUtils.isEmpty(jwtToken)){
                return false;
            }
            //验证不通过就抛异常
            Jwts.parser().setSigningKey(APP_SECRET).parseClaimsJws(jwtToken);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * 根据token获取会员id与用户名
     * @param request
     * @return
     */
    public static String getMemberIdByJwtToken(HttpServletRequest request) {
        String jwtToken = request.getHeader(JwtConstant.JWT_TOCKEN);
        if(!StringUtils.hasText(jwtToken)) {
            return null;
        }
        return getString(jwtToken);
    }

    /**
     * 根据有token值获取
     * @param token
     * @return
     */
    public static String getMemberIdByNicknameJwtToken(String token) {
        return getString(token);
    }
    private static String getString(String jwtToken) {
        Jws<Claims> claimsJws = Jwts.parser().setSigningKey(APP_SECRET).parseClaimsJws(jwtToken);
        Claims claims = claimsJws.getBody();
        System.out.println(claims.get("id"));
        System.out.println(claims.get("username"));
        return claims.get("id")+"-"+claims.get("username");
    }

}
