package me.boujdi.metier.aspects;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class FirstAspect {
    @Pointcut("execution(* *.mainnnn(..))")
    public void mainMethod() {}
    @Before("mainMethod()")
    public void beforeMain() {
        //this is the advice that will be executed before the main method
        System.out.println("Before main method");
    }
    @After("mainMethod()")
    public void afterMain() {
        // this is the advice that will be executed after the main method

        System.out.println("After main method");
    }
}
