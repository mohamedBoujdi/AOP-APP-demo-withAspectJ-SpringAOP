package me.boujdi.metier.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Aspect
@Component
public class SecurityAspect {
    @Pointcut("execution(* me.boujdi.Main.run())")
    public void securityPointcut() {}

    @Around("securityPointcut()")
    public void security(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Veuillez saisir votre login");
        String login = scanner.nextLine();
        System.out.println("Veuillez saisir votre mot de passe");
        String password = scanner.nextLine();
        if (login.equals("admin") && password.equals("admin")) {
           proceedingJoinPoint.proceed();
        }else{
            System.out.println("Accès refusé");
            System.exit(0);
        }

    }

}
