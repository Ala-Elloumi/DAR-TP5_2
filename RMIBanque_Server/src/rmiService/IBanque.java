package rmiService;
import metier.Compte;
import java.rmi.Remote;
import java.rmi.RemoteException;
public interface IBanque extends Remote {
    public String creerCompte(Compte c) throws RemoteException;
    public String getInfoCompte(int code) throws RemoteException;
}
