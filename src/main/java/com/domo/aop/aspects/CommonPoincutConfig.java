package com.domo.aop.aspects;

import org.aspectj.lang.annotation.Pointcut;

public class CommonPoincutConfig {

    @Pointcut("execution(* com.domo.aop.*.*.*(..))")
    public void businessAndDataPackageConfig() {
    }

    @Pointcut("execution(* com.domo.aop.business.*.*(..))")
    public void businessPackageConfig() {
    }

    @Pointcut("execution(* com.domo.aop.data.*.*(..))")
    public void dataPackageConfig() {
    }

    @Pointcut("bean(*Service*)")
    public void allPackageConfigUsingBean() {
    }

    @Pointcut("@annotation(com.domo.aop.annotations.TrackTime)")
    public void trackTimeAnnotation() {
    }
}
