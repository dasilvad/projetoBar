package Caixa;


import Interfaces.Caixa_Interface;
import java.rmi.RemoteException;
import java.rmi.server.*;


/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Adson
 */

// Classe responsável pela implementação dos métodos remotos definidos pela Interface
public class CaixaImpl extends UnicastRemoteObject implements Caixa_Interface {
    
    public CaixaImpl() throws RemoteException {
        
        super();
    }

    // Método remoto implementado.
    @Override
    public void imprimirMensagem(String mensagem) {
        
        // Receberá uma String do cliente e a imprimirá
        //ClienteTela.gravarLog(mensagem, Color.orange);
    }    
}
