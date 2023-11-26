package rmiClient;

import rmiService.IBanque;
import metier.Compte;
import java.rmi.Naming;

public class BanqueClient {
    public static void main(String[] args){

        try {
            String resultat;

            // Obtention de référence à l'objet distant du serveur RMI
            IBanque banque = (IBanque) Naming.lookup("rmi://localhost:1099/BanqueService");

            // Création d'un objet de type Compte
            Compte compte = new Compte(111,2400.00);

            // Utilisation de la méthodes 'creerBanque()' de l'interface IBanque
            resultat= banque.creerCompte(compte);

            // Affichage pour verifier la création du compte
            System.out.println(resultat);

            // Utilisation de la méthodes 'getInfoCompte()' de l'interface IBanque pour un compte deja créer
            resultat = banque.getInfoCompte(111);

            // Affichage des informations du compte créé
            System.out.println(resultat);

            // Utilisation de la méthodes 'getInfoCompte()' de l'interface IBanque pour un compte n'existe pas
            resultat = banque.getInfoCompte(222);

            // Affichage pour verifier l'existance du compte
            System.out.println(resultat);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
