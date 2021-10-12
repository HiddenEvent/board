package com.richard.board.aspect;

import com.richard.board.security.SecurityService;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
@RequiredArgsConstructor
public class SecurityAspect {
    private final SecurityService securityService;

    @Before("@annotation(tokenRequired)")
    public void authenticateWithToken(TokenRequired tokenRequired) {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();

        String token = request.getHeader("token");
        if(ObjectUtils.isEmpty(token)){
            throw new IllegalArgumentException("token is empty");
        }

        if (securityService.getClaims(token) == null || securityService.getSubject(token) == null) {
            throw new IllegalArgumentException("token error!! claims or subject are null!!");
        }

        // subject 기반으로 자체인증로직~~~

    }

}
