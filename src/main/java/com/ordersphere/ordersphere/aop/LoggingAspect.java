package com.ordersphere.ordersphere.aop;

import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
    private static final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

//    @Before("execution(* com.ordersphere.ordersphere.controller.LoginController.login(..)) && args(loginRequestDto)")
//    public void logBefore(JoinPoint joinPoint, Object loginRequestDto) {
//        String username = ((com.ordersphere.ordersphere.dto.LoginRequestDto) loginRequestDto).getUsername();
//        logger.info("Login request received for username: {}", username);
//    }
//
//    @After("execution(* com.ordersphere.ordersphere.controller.LoginController.login(..))")
//    public void logAfter(JoinPoint joinPoint) {
//        logger.info("Login process completed.");
//    }
//
//    @AfterThrowing(pointcut = "execution(* com.ordersphere.ordersphere.controller.LoginController.login(..))", throwing = "exception")
//    public void logAfterThrowing(JoinPoint joinPoint, Throwable exception) {
//        String username = ((com.ordersphere.ordersphere.dto.LoginRequestDto) joinPoint.getArgs()[0]).getUsername();
//        logger.error("Login failed for username: {}. Error: {}", username, exception.getMessage());
//    }
}
