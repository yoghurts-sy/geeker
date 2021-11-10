package com.geeker.love;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
public class LoveApplicationTests {

    @Test
    public void jwtTest(){
        JwtBuilder jwtBuilder=Jwts.builder()
                .setId("208")
                .setSubject("geeKer")
                .setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS256,"shufan");
        String token=jwtBuilder.compact();
        System.out.println("token="+token);
        Claims claims=(Claims) Jwts.parser()
                .setSigningKey("shufan")
                .parse(token)
                .getBody();
        System.out.println(claims.getId()+"=="+claims.getSubject());

    }
}
