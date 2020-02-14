package com.example.aspectdemo.logging;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class ExceptionAspect {

    /**
     * @param joinPoint
     *            - aspect method joinpoint
     * @param e
     *            - exception being thrown
     */
    @AfterThrowing(pointcut = "execution(public * *(..)) && @annotation(afterThrowingLog)", throwing = "e")
    public void afterThrowing(JoinPoint joinPoint, AfterThrowingLog afterThrowingLog, Throwable e) throws Throwable {

        Logger log = LoggerFactory.getLogger(joinPoint.getSignature().getDeclaringType().getName());

        Signature signature = joinPoint.getSignature();
        String arguments = Arrays.toString(joinPoint.getArgs());
        long start = System.currentTimeMillis();
        Long duration = System.currentTimeMillis() - start;

        log.error("method=" + signature.getName() + ",class=" + joinPoint.getTarget().getClass().getSimpleName()
                + ",request=" + arguments + ",exception=" + e.toString() + ",executionTime=" + duration.toString(), e);
    }
}
