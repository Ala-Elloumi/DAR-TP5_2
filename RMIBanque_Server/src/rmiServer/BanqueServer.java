package rmiServer;

import rmiService.BanqueImpl;
import rmiService.IBanque;
import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class BanqueServer {

    public static void main(String[] args){

        try {
            // Création de l'instance du serveur RMI
            IBanque banque = new BanqueImpl();

            // Création du registre RMI sur le port 1099
            LocateRegistry.createRegistry(1099);

            // Enregistrement de l'objet distant dans le registre RMI
            Naming.rebind("BanqueService", banque);

            // Affichage pour vérifier la l'activation du serveur RMI
            System.out.println("Le Serveur RMI est prêt.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
