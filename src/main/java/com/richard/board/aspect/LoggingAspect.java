package com.richard.board.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component /* Aspect가 서버에 올라갈때 같이 올라간다.*/
public class LoggingAspect {
    /*execution() 은 페키지를 조햅해서 적는 란*/
    @Before("execution(* com.richard.board.service.*.get*(..))") /* get으로 시작되는 모든 메서드 */
    public void loggerBefore() {
        System.out.println("get 으로 시작되는 메서드 시작");
    }

    @After("execution(* com.richard.board.service.*.get*(..))") /* get으로 시작되는 모든 메서드 */
    public void loggerAfter() {
        System.out.println("get 으로 시작되는 메서드 끝");
    }

//    public Object loggerAround(ProceedingJoinPoint pjp) throws Throwable {
//        long beforeTimeMillis = System.currentTimeMillis();
//        System.out.println("[UserController] 실행시작 : "
//                + pjp.getSignature().getDeclaringTypeName() + "."
//                + pjp.getSignature().getName()
//        );
//        Object result = pjp.proceed();
//
//        long afterTimeMillis = System.currentTimeMillis() - beforeTimeMillis;
//        System.out.println(
//                "[UserController] 시"
//
//        );
//    }

}
