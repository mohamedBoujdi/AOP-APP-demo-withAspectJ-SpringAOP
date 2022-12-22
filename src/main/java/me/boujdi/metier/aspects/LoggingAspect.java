package me.boujdi.metier.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;

@Aspect
@Component
public class LoggingAspect {
    private Logger logger = Logger.getLogger(LoggingAspect.class.getName());
    private long startTime;
    private long endTime;

    public LoggingAspect() throws IOException {
        logger.info("LoggingAspect created");

        logger.addHandler(new FileHandler("log.xml"));
        logger.setUseParentHandlers(false);
    }

    @Pointcut("execution(* me.boujdi.metier.IMetierBanqueImpl.*(..))")
    void loggingpointcut() {}


    @Before("loggingpointcut()")
    void loggingBefore(JoinPoint joinPoint) {
        logger.info("------------------------"+joinPoint.getArgs()+"------------------------------");
        startTime = System.currentTimeMillis();
        logger.info("Before method "+joinPoint.getSignature().getName());
        logger.info("-------------------------------------------------------");
    }


    @After("loggingpointcut()")
    void loggingAfter(JoinPoint joinPoint) {
        logger.info("-------------------------------------------------------");
        endTime = System.currentTimeMillis();
        logger.info("After method "+ joinPoint.getSignature().getName());
        System.out.println("Method execution time: "+(endTime-startTime)+" ms");
        logger.info("-------------------------------------------------------");
    }

    /*@Around("loggingpointcut()")
    public Object loggingAround(ProceedingJoinPoint proceedingJoinPoint,JoinPoint joinPoint) throws Throwable {
        logger.info("------------------------"+joinPoint.getArgs().toString()+"------------------------------");
        long startTime = System.currentTimeMillis();
        logger.info("Before method "+joinPoint.getSignature().getName());
        logger.info("-------------------------------------------------------");
        Object result=proceedingJoinPoint.proceed();
        logger.info("-------------------------------------------------------");
        long endTime = System.currentTimeMillis();
        logger.info("After method "+ joinPoint.getSignature().getName());
        System.out.println("Method execution time: "+(endTime-startTime)+" ms");
        logger.info("-------------------------------------------------------");
        return result;
    }*/

}
