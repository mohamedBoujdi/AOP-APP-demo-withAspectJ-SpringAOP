package me.boujdi;

import me.boujdi.metier.Compte;
import me.boujdi.metier.Config;
import me.boujdi.metier.IMetier;
import me.boujdi.metier.IMetierBanqueImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        new Main().run();
    }
    public void run() {
        try {
        System.out.println("demarrage de l'application");
        Scanner scanner=new Scanner(System.in);
        System.out.println("1-ajouter code d'un compte");
        Long code=scanner.nextLong();
        System.out.println("2-ajouter un montant");
        double mt=scanner.nextDouble();
        ApplicationContext ctx = new AnnotationConfigApplicationContext(Config.class);
        IMetier metier = ctx.getBean(IMetier.class);
        metier.addCompte(new Compte(code,mt));
        while(true){
            System.out.println("Type d'operation: 1-versement 2-retrait 3-consultation");

                int type=scanner.nextInt();
                switch (type){
                    case 1:
                        System.out.println("1-ajouter code d'un compte");
                        code=scanner.nextLong();
                        System.out.println("2-ajouter un montant");
                        mt=scanner.nextDouble();
                        metier.verser(mt,code);
                        break;
                    case 2:
                        System.out.println("1-ajouter code d'un compte");
                        code=scanner.nextLong();
                        System.out.println("2-ajouter un montant");
                        mt=scanner.nextDouble();
                        metier.retirer(mt,code);
                        break;
                    case 3:
                        System.out.println("1-ajouter code d'un compte");
                        code=scanner.nextLong();
                        metier.consulter(code);
                        break;
                    default:
                        System.out.println("operation non valide");
                        break;
                }
        }
        }catch (Exception e){
            System.out.println("erreur: "+e.getMessage());
        }
    }
}
