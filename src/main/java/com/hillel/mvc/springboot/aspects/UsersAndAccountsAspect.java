package com.hillel.mvc.springboot.aspects;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Slf4j
public class UsersAndAccountsAspect {

    private int createdUsersCounter = 0;
    private int removedUsersCounter = 0;

    private int createdAccountsCounter = 0;
    private int removedAccountsCounter = 0;

    @Before("com.hillel.mvc.springboot.aspects.PointCuts.allServiceOrRepositoryMethods()")
    public void logBeforeMethodCall(JoinPoint joinPoint){
        log.info("Entering method...");
        log.info("Class name {}", joinPoint.getSignature().getDeclaringTypeName());
        log.info("Method name {}", joinPoint.getSignature());
    }

    @After("com.hillel.mvc.springboot.aspects.PointCuts.allServiceOrRepositoryMethods()")
    public void logAfterMethodCall(JoinPoint joinPoint){
        log.info("Exiting method...");
        log.info("Class name {}", joinPoint.getSignature().getDeclaringTypeName());
        log.info("Method name {}", joinPoint.getSignature());
    }

    @AfterReturning(pointcut = "com.hillel.mvc.springboot.aspects.PointCuts.allServiceOrRepositoryMethods()",
            returning = "object")
    public void logMethodsResult(Object object){
        if(object != null) {
            log.info("Result: {}", object);
        }
    }

    @After("execution(void com.hillel.mvc.springboot.dao.userRepository.UserRepositoryImpl.save(..))")
    public void countNumberOfCreatedUsers(JoinPoint joinPoint){
        createdUsersCounter++;
        log.info("{} users have been created so far.", createdUsersCounter);
    }

    @After("execution(boolean com.hillel.mvc.springboot.dao.userRepository.UserRepositoryImpl.delete(..))")
    public void countNumberOfDeletedUsers(JoinPoint joinPoint){
        removedUsersCounter++;
        log.info("{} users have been removed so far.", removedUsersCounter);
    }

    @After("execution(boolean com.hillel.mvc.springboot.dao.accountRepository.AccountRepository.save(..))")
    public void countNumberOfCreatedAccounts(JoinPoint joinPoint){
        createdAccountsCounter++;
        log.info("{} accounts have been created so far.", createdAccountsCounter);
    }

    @After("execution(boolean com.hillel.mvc.springboot.dao.accountRepository.AccountRepository.delete(..))")
    public void countNumberOfDeletedAccounts(JoinPoint joinPoint){
        removedAccountsCounter++;
        log.info("{} accounts have been removed so far.", removedAccountsCounter);
    }
}
