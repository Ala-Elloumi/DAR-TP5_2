package rmiService;

import metier.Compte;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.Map;

public class BanqueImpl extends UnicastRemoteObject implements IBanque {

    // Map pour stocker les comptes avec leurs code
    private Map<Integer, Compte> comptes;

    public BanqueImpl() throws RemoteException {
        // Appelle le constructeur de la classe de base UnicastRemoteObject
        super();
        // Creation d'une HashMap pour stocker les compte créer
        comptes = new HashMap<>();
    }

    public String creerCompte(Compte c) throws RemoteException{
        // Creation du Compte
        comptes.put(c.getCode(), c);
        // Message de cration avec succée
        return "Le compte a été créé avec succès.";
    }
    public String getInfoCompte(int code) throws RemoteException{
        // Creation d'un code avec le code envoyer s'il existe
        Compte compte = comptes.get(code);
        if (compte != null) {
            return "Informations du compte : " + compte.toString();
        } else {
            return "Le compte avec le code " + code + " n'existe pas.";
        }
    }
}
