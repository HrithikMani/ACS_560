package com.example.hw2_rest_api.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    // Before Advice
    @Before("execution(public * com.example.hw2_rest_api.controller..*(..))")
    public void logBeforeMethod() {
        System.out.println("H.M.K: Before the method execution.");
    }

    // Around Advice
    @Around("execution(public * com.example.hw2_rest_api.services..*(..))")
    public Object logAroundMethod(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("H.M.K: Before proceeding the method.");
        Object result = joinPoint.proceed();
        System.out.println("H.M.K: After proceeding the method.");
        return result;
    }

    // After Returning Advice
    @AfterReturning(pointcut = "execution(public * com.example.hw2_rest_api.repositories..*(..))", returning = "result")
    public void logAfterReturning(Object result) {
        System.out.println("H.M.K: Method successfully executed, result: " + result);
    }

    // After Throwing Advice
    @AfterThrowing(pointcut = "execution(public * com.example.hw2_rest_api.services..*(..))", throwing = "exception")
    public void logAfterThrowing(Exception exception) {
        System.out.println("H.M.K: Exception thrown - " + exception.getMessage());
    }

    // After (Finally) Advice
    @After("execution(public * com.example.hw2_rest_api.controller..*(..))")
    public void logAfterMethod() {
        System.out.println("H.M.K: After the method execution (finally).");
    }
}
