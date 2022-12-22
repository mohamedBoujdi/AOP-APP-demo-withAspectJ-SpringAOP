package me.boujdi.metier;

public interface IMetier {
    public void addCompte(Compte c);
    public void verser(double mt, Long code);
    public void retirer(double mt, Long code);
    public Compte consulter(Long code);
}
