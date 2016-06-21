package Servidor;


import Interfaces.Servidor_Interface;
import Telas.Servidor_Tela;
import java.awt.Color;
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
public class Servidor_Impl extends UnicastRemoteObject implements Servidor_Interface {
    
    public Servidor_Impl() throws RemoteException {
        
        super();
    }

    // Método remoto implementado.
    @Override
    public void imprimirMensagem(String mensagem) {
        String[] msg;
        msg = mensagem.trim().split("#");
        if (msg[0].contains("1")) {
            Servidor_Tela.incluirMesa(msg[1]);
        } else if(msg[0].contains("2")){
            Servidor_Tela.incluirPedido(msg[2], Double.parseDouble(msg[3]), Integer.parseInt(msg[4]), Integer.parseInt(msg[1]));
        }
//        
    }    
}
