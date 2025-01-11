package com.ordersphere.ordersphere.aop;

import com.ordersphere.ordersphere.dto.LoginRequestDTO;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Aspect
@Component
public class LoggingAspect {

    private static final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

    @Before("execution(* com.ordersphere.ordersphere.controller.LoginController.login(..)) && args(loginRequestDTO)")
    public void logBefore(JoinPoint joinPoint, LoginRequestDTO loginRequestDTO) {
        String username = loginRequestDTO.getUsername();
        logger.info("Login request received for username: {}", username);
    }

    @After("execution(* com.ordersphere.ordersphere.controller.LoginController.login(..))")
    public void logAfter(JoinPoint joinPoint) {
        logger.info("Login process completed successfully.");
    }

    @AfterThrowing(pointcut = "execution(* com.ordersphere.ordersphere.controller.LoginController.login(..))", throwing = "exception")
    public void logAfterThrowing(JoinPoint joinPoint, Throwable exception) {
        String username = ((LoginRequestDTO) joinPoint.getArgs()[0]).getUsername();
        logger.error("Login failed for username: {}. Error: {}", username, exception.getMessage());
    }
}
