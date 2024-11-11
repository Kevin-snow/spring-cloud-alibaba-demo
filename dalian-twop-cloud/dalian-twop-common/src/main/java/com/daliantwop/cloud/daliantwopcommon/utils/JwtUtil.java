package com.daliantwop.cloud.daliantwopcommon.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.daliantwop.cloud.daliantwopcommon.consts.Renum;
import com.daliantwop.cloud.daliantwopcommon.exption.TokenAuthenticationException;

import java.util.Date;

/**
 * @author Kevin
 * @date 2024/10/17 16:51
 */
public class JwtUtil {


    public static final long TOKEN_EXPIRE_TIME = 7200 * 1000;

    private static final String ISSUER = "cheng";

    /**
     * 生成Token
     *
     * @param username  用户标识（不一定是用户名，有可能是用户ID或者手机号什么的）
     * @param secretKey
     * @return
     */
    public static String generateToken(String username, String secretKey) {
        Algorithm algorithm = Algorithm.HMAC256(secretKey);
        Date now = new Date();
        Date expireTime = new Date(now.getTime() + TOKEN_EXPIRE_TIME);

        return JWT.create()
                .withIssuer(ISSUER)
                .withIssuedAt(now)
                .withExpiresAt(expireTime)
                .withClaim("username", username)
                .sign(algorithm);
    }

    /**
     * 校验Token
     *
     * @param token
     * @param secretKey
     * @return
     */
    public static void verifyToken(String token, String secretKey) throws TokenAuthenticationException {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secretKey);
            JWTVerifier jwtVerifier = JWT.require(algorithm).withIssuer(ISSUER).build();
            jwtVerifier.verify(token);
        } catch (JWTDecodeException jwtDecodeException) {
            throw new TokenAuthenticationException(Renum.INVALID_TOKEN.getMsg());
        } catch (SignatureVerificationException signatureVerificationException) {
            throw new TokenAuthenticationException(Renum.SIGNATURE_INVALID_TOKEN.getMsg());
        } catch (TokenExpiredException tokenExpiredException) {
            throw new TokenAuthenticationException(Renum.EXPIRED_TOKEN.getMsg());
        } catch (Exception ex) {
            throw new TokenAuthenticationException(Renum.UNKNOWN_ERROR.getMsg());
        }
    }

    /**
     * 从Token中提取用户信息
     *
     * @param token
     * @return
     */
    public static String getUserInfo(String token) {
        DecodedJWT decodedJWT = JWT.decode(token);
        return decodedJWT.getClaim("userName").asString();
    }

}
