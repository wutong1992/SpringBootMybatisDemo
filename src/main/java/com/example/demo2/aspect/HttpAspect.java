package com.example.demo2.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
public class HttpAspect {

    private static final Logger log = LoggerFactory.getLogger(HttpAspect.class);

    @Pointcut("execution(public * com.example.demo2.action.StudentController.*(..))")
    public void log() {

    }

    @Before("log()")
    public void doBefore(JoinPoint joinPoint) {
        log.info("My First Aspect Test Class start...");
        ServletRequestAttributes attributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        log.info("url={}",request.getRequestURL());
        log.info("method={}",request.getMethod());
        log.info("ip={}",request.getRemoteAddr());
        log.info("class_method={}",joinPoint.getSignature().getDeclaringTypeName() + "."+ joinPoint.getSignature().getName());
        log.info("args={}",joinPoint.getArgs());
    }

    @After("log()")
    public void doAfter() {
        log.info("My First Aspect Test Class end...");
    }

    @AfterReturning(returning = "object", pointcut = "log()")
    public void doAfterReturning(Object object) {
        log.info("response={}",object);
    }
}
