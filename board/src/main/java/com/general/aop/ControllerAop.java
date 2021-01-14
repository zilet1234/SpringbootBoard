package com.general.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;


/**
 * View를  사용하는 Controller 에서는 사용하지 않는게 좋을듯.
 * - Exception 을 Around 에서 Catch 하기 때문에 JSP 에서 결과값을 받아서 처리하기 어려움.
 */

@Slf4j
@Aspect
//@Component
public class ControllerAop {

    @Around("execution(* com.general.controller.home.MainController.*(..))")
    public Object processing(ProceedingJoinPoint joinPoint){
        Object object = null;
        try {
            LocalDateTime startTime = LocalDateTime.now();
            object = joinPoint.proceed();
            LocalDateTime endTime = LocalDateTime.now();
            log.info(" proceed time : {}", ChronoUnit.SECONDS.between(startTime, endTime));
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            return "/error/404";
        }

        return object;
    }

}
