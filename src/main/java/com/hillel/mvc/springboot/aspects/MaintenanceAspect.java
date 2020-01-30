package com.hillel.mvc.springboot.aspects;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

@Component
@Aspect
@Slf4j
@ConditionalOnProperty(name = "maintenanceMode", havingValue = "true")
public class MaintenanceAspect {

    @Around("PointCuts.aroundAllPageControllers()")
    public Object getMaintenanceView(ProceedingJoinPoint proceedingJoinPoint) {
        MethodSignature signature = (MethodSignature) proceedingJoinPoint.getSignature();
        log.info("{}", proceedingJoinPoint.getSignature());
        try {
            if (signature.getReturnType().getSimpleName().equals("ModelAndView")) {
                ModelAndView modelAndView = new ModelAndView();
                modelAndView.setViewName("maintenancePage");
                return modelAndView;
            } else {
                return "maintenancePage";
            }
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            return null;
        }
    }
}
