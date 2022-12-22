package me.boujdi.metier;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class IMetierBanqueImpl implements IMetier {
    private Map<Long,Compte> comptes=new HashMap();
    @Override
    public void addCompte(Compte c) {
       // System.out.println("addCompte method");
       comptes.put(c.getCode(),c);
    }
    @Override
    public void verser(double mt, Long code) {
        System.out.println("verser method");
        Compte cp=comptes.get(code);
        cp.setSolde(cp.getSolde()+mt);
    }
    @Override
    public void retirer(double mt, Long code) {
        System.out.println("retirer method");
        Compte cp=comptes.get(code);
        cp.setSolde(cp.getSolde()-mt);
    }
    @Override
    public Compte consulter(Long code) {
        System.out.println("consulter method");
        Compte cp=comptes.get(code);
        System.out.println("code: "+cp.getCode()+" solde: "+cp.getSolde());
        return cp;
    }
}

