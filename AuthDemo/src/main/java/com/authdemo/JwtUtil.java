package com.authdemo;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtUtil {
    public static final String Secret="this-is-my-secret-key-for-java-project";

         public String generateToken(MyUser user){
             return Jwts.builder()
                     .setSubject(user.getPname())
                     .claim("role",user.getRole())
                     .setIssuedAt(new Date())
                     .setExpiration(new Date(System.currentTimeMillis()+1000*60*10))
                     .signWith(Keys.hmacShaKeyFor(Secret.getBytes()))
                     .compact();

         }

}
