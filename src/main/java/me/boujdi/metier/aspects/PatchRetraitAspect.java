package me.boujdi.metier.aspects;

import me.boujdi.metier.Compte;
import me.boujdi.metier.IMetier;
import me.boujdi.metier.IMetierBanqueImpl;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class PatchRetraitAspect {
    @Pointcut("execution(* me.boujdi.metier.IMetierBanqueImpl.retirer(..))")
    void patchRetraitPointcut() {}

    @Around("patchRetraitPointcut() && args(code, mt)")
    public Object patchRetrait(ProceedingJoinPoint proceedingJoinPoint, JoinPoint joinpoint ,long code, double mt) throws Throwable {
        IMetierBanqueImpl metierBanque = (IMetierBanqueImpl) proceedingJoinPoint.getTarget();
        Compte compte = metierBanque.consulter(code);
        if (compte.getSolde() < mt)  new RuntimeException("Solde insuffisant");
        return proceedingJoinPoint.proceed();
    }

}
