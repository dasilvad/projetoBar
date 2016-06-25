/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clienteMesaRN;

import clienteMesaPER.LoginPER;
import java.rmi.RemoteException;

/**
 *
 * @author daniel
 */
public class LoginRN {

    public boolean logar(String usuario) throws RemoteException {
       LoginPER loginPER = new LoginPER();
       return loginPER.logar(usuario);
    }
    
}
