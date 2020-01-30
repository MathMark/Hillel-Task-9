package com.hillel.mvc.springboot.aspects;

import org.aspectj.lang.annotation.Pointcut;

public class PointCuts {

    @Pointcut("within(@org.springframework.stereotype.Repository *) || " +
            "within(@org.springframework.stereotype.Service *)")
    public void allServiceOrRepositoryMethods(){
    }

    @Pointcut("within(com.hillel.mvc.springboot.controllers.*)")
    public void aroundAllPageControllers() {
    }
}
