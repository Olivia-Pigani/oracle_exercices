package org.me.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Aspect
public class LoggingAspect {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Pointcut("execution(* org.me.aop.service..*(..))")
    public void serviceMethods() {

    }


    @AfterReturning(value = "serviceMethods()", returning = "result")
    public void stoutLogWithReturn(JoinPoint joinPoint, Object result) {
        logger.info("params: " + Arrays.toString(joinPoint.getArgs()));
        logger.info("return: " + joinPoint.getSignature().getName() + " " + result);
    }
}
