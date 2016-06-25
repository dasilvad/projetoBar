/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clienteMesaPER;



import Mesa.MetodoRemotoDoServidor;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author daniel
 */
public class LoginPER {
    public boolean logar(String usuario) throws RemoteException{
        MetodoRemotoDoServidor m = new MetodoRemotoDoServidor();
        return m.conectar().logar(usuario);
        
    }
}
