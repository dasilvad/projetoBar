package Mesa;
import Interfaces.ServidorInterface;



import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.rmi.registry.RegistryImpl;

/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */
/**
 *
 * @author Adson
 */
public class MetodoRemotoDoServidor {
    private String NOME_SERVICO = "servicoServidor";
    private String PORTA = "12345";
    public ServidorInterface conectar(){
        try {
            ServidorInterface estoqueInterface = (ServidorInterface) Naming.lookup("//localhost:"+ this.PORTA+"/"+this.NOME_SERVICO);
            return estoqueInterface;
        } catch (NotBoundException ex) {
            Logger.getLogger(MetodoRemotoDoServidor.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(MetodoRemotoDoServidor.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RemoteException ex) {
            Logger.getLogger(MetodoRemotoDoServidor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
