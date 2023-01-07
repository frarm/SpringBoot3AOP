package com.domo.aop.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Configuration
@Aspect
public class LoggingAspect {

    private Logger logger = LoggerFactory.getLogger(getClass());

    // When
    @Before("com.domo.aop.aspects.CommonPoincutConfig.allPackageConfigUsingBean()")
    public void logMethodCallBeforeExecution(JoinPoint joinPoint) {
        // What
        logger.info("Before Aspect - {} is called with arguments: {}", joinPoint, joinPoint.getArgs());
    }

    @After("com.domo.aop.aspects.CommonPoincutConfig.dataPackageConfig()")
    public void logMethodCallAfterExecution(JoinPoint joinPoint) {
        // What
        logger.info("After Aspect - {} has executed", joinPoint);
    }

    @AfterThrowing(pointcut = "com.domo.aop.aspects.CommonPoincutConfig.businessAndDataPackageConfig()", throwing = "exception")
    public void logMethodCallAfterException(JoinPoint joinPoint, Exception exception) {
        // What
        logger.info("AfterThrowing Aspect - {} has throw an exception {}", joinPoint, exception);
    }

    @AfterReturning(pointcut = "com.domo.aop.aspects.CommonPoincutConfig.businessPackageConfig()", returning = "resultValue")
    public void logMethodCallAfterSuccessfulExecution(JoinPoint joinPoint, Object resultValue) {
        // What
        logger.info("AfterReturning Aspect - {} has returned {}", joinPoint, resultValue);
    }
}
