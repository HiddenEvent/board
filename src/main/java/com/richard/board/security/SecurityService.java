package com.richard.board.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Service;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.security.Key;
import java.util.Date;

@Service
public class SecurityService {
    private static final String SECRET_KEY = "dsfsdafjskadfjsdalkfjssdfjskadhfjskdafhkjfelkjfjkdlsjfhhsklja";

    public String createToken(String subject, long expTime) {
        if(expTime <= 0) {
            throw new RuntimeException("만료시간이 0보다 커야합니다.");
        }

        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;

        /* - secretKeyBytes
        * javax.xml.bind:jaxb-api 라이브러리를 사용 하여
        * String -> byte 로 변환 시켜준다
        * ex)  DatatypeConverter.parseBase64Binary(SECRET_KEY)
        * */
        byte[] secretKeyBytes = DatatypeConverter.parseBase64Binary(SECRET_KEY);
        /* java에서 사용하는 시크릿 key를 만들어주는 것...*/
        Key signingKey = new SecretKeySpec(secretKeyBytes, signatureAlgorithm.getJcaName());

        return Jwts.builder()
                .setSubject(subject) /* userId 값 */
                .signWith(signingKey, signatureAlgorithm) /* 시크릿 키 값*/
                .setExpiration(new Date(System.currentTimeMillis() + expTime)) /* 토큰 만료시간 설정 */
                .compact();
        /* Jwt 토큰 값
        eyJhbGciOiJIUzI1NiJ9.  --> Header 값이 들어감
        eyJzdWIiOiJrYW5nIiwiZXhwIjoxNjMzNjE1MTYyfQ. --> palyload(claim) 값이 들어감
        A0LZwmgfwxJd1WJCvI1QV_j7P0L9MNHYKo-1k20UZz0 --> 서명(암호화)값이 들어감

        1. 콤마를 구분자로 3개의 구문으로 생성됨

        */


    }
    public String getSubject(String token) {
        /* Claims : 페이로드된 데이터 정보를 가져오는 인텋페이스 */
        /* - 페이로드(payload)란?  전송되는 데이터를 의미합니다.
        데이터를 전송할 때, 헤더와 메타데이터, 에러 체크 비트 등과 같은 다양한 요소들을 함께 보내어,
        데이터 전송의 효율과 안정성을 높히게 됩니다. 이 때, 보내고자 하는 데이터 자체를 의미하는 것이 바로 페이로드입니다.
        */
        Claims claims = Jwts.parserBuilder()
                .setSigningKey(DatatypeConverter.parseBase64Binary(SECRET_KEY))
                .build()
                .parseClaimsJws(token)
                .getBody();
        return claims.getSubject();
    }
}
