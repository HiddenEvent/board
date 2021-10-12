package com.richard.board.aspect;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


@Retention(RetentionPolicy.RUNTIME) /*@ Retention = 언제 적용시킬 것 인가*/
@Target(ElementType.METHOD) /*@Target = 타겟설정*/
public @interface TokenRequired { /* @interface : annotation 만들어짐*/
    
}
