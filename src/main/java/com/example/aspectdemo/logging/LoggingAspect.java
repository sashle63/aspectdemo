package com.example.aspectdemo.logging;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class LoggingAspect {

    @Pointcut(value = "execution(public * *(..))")
    public void anyPublicMethod() {
    }

    /**
     *
     * @param point
     *            - joinpoint
     * @param aroundLog
     *            - annotation
     * @return - returns the method return value
     * @throws Throwable
     */

    @Around("execution(public * *(..)) && @annotation(AroundLog)")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        long start = System.currentTimeMillis();
        Logger log = LoggerFactory.getLogger(point.getSignature().getDeclaringType().getName());
        Long duration = System.currentTimeMillis() - start;
        Object result = point.proceed();

        Signature signature = point.getSignature();
        String arguments = Arrays.toString(point.getArgs());
        log.info("method=" + signature.getName() + ",class=" + point.getTarget().getClass().getSimpleName()
                + ",request=" + arguments + ",response=" + (result != null ? result.toString() : null)
                + ",executionTime=" + duration.toString());
        return result;
    }

    /**
     *
     * @param point
     * @param beforeLog
     */
    @Before("execution(public * *(..)) && @annotation(beforeLog)")
    public void before(JoinPoint point, BeforeLog beforeLog) {

        Logger log = LoggerFactory.getLogger(point.getSignature().getDeclaringType().getName());
        logMethod(log, point);

    }

    /**
     *
     * @param point
     * @param afterLog
     */
    @After("execution(public * *(..)) && @annotation(afterLog)")
    public void after(JoinPoint point, AfterLog afterLog) {

        Logger log = LoggerFactory.getLogger(point.getSignature().getDeclaringType().getName());

        logMethod(log, point);

    }

    /**
     *
     * @param joinPoint
     * @param afterReturningLog
     */
    @AfterReturning("execution(public * *(..)) && @annotation(afterReturningLog)")
    public void afterReturning(JoinPoint joinPoint, AfterReturningLog afterReturningLog) {

    }

    /**
     *
     * @param log
     * @param point
     */
    private void logMethod(Logger log, JoinPoint point) {
        long start = System.currentTimeMillis();
        Signature signature = point.getSignature();
        String methodName = signature.getName();
        String arguments = Arrays.toString(point.getArgs());
        log.info("method: " + methodName + " with arguments " + arguments);

        Long duration = System.currentTimeMillis() - start;
        log.info("method=" + signature.getName() + ",class=" + point.getTarget().getClass().getSimpleName()
                + ",request=" + arguments + ",executionTime=" + duration.toString());

    }
}
