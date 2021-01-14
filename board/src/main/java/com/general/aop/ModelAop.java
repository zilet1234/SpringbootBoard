package com.general.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ModelAop {

    // pointcut 지정  방식
    @Pointcut("execution(* com.general.model.dao.*.*(..))")
    public void dao(){}

    @Pointcut("execution(* com.general.model.dto.*.*(..))")
    public void dto(){}

    @Around("dao()")
    public Object businessLogicDao(ProceedingJoinPoint joinPoint){
        Object object = null;
        try {
            object = joinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            return throwable.getMessage();
        }
        return object;
    }

    @Around("dto()")
    public Object businessLogicDto(ProceedingJoinPoint joinPoint){
        Object object = null;
        try {
            object = joinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            return throwable.getMessage();
        }
        return object;
    }



}
