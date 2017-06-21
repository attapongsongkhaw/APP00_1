package com.kbank.lms.utils;

import java.util.Date;
import java.util.UUID;

import org.apache.log4j.Logger;
import com.kbank.lms.model.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class TokenUtil {
	
	private static final Logger logger = Logger.getLogger(TokenUtil.class);
	
	private TokenUtil() {	
	}

	public static String generateToken(User user) {
        String id = UUID.randomUUID().toString().replace("-", "");
        Date now = new Date();
        Date exp = new Date(System.currentTimeMillis() + (1000 * Constants.EXPIRETIMETOKEN)); // 30 seconds

        String token = Jwts.builder()
            .setId(id)
            .setSubject(user.getUsername())
            .claim("role", user.getRole())
            .setIssuedAt(now)
            .setNotBefore(now)
            .setExpiration(exp)
            .signWith(SignatureAlgorithm.HS256, Constants.BASE64SECRETBYTES)
            .compact();

        return token;
    }

	public static void verifyToken(String token) {
        Claims claims = Jwts.parser()
            .setSigningKey(Constants.BASE64SECRETBYTES)
            .parseClaimsJws(token).getBody();
        logger.info("ID: " + claims.getId());
        logger.info("Subject: " + claims.getSubject());
        logger.info("role: " + claims.get("role"));
        logger.info("Issuer: " + claims.getIssuer());
        logger.info("Expiration: " + claims.getExpiration());
    }
}
