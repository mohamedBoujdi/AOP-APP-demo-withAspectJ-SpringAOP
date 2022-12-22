package me.boujdi.metier;

import org.springframework.stereotype.Component;

@Component
public class Compte {
    private Long code;
    private double solde;

    public Compte(Long code, double solde) {
        this.code = code;
        this.solde = solde;
    }
    public Compte() {
    }
    public Long getCode() {
        return code;
    }
    public void setCode(Long code) {
        this.code = code;
    }
    public double getSolde() {
        return solde;
    }
    public void setSolde(double solde) {
        this.solde = solde;
    }

}
