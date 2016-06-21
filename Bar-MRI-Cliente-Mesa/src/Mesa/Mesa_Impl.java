package Mesa;

import Interfaces.Mesa_Interface;
import Telas.Mesa_Telas_Inicio;
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
public class Mesa_Impl extends UnicastRemoteObject implements Mesa_Interface {
    
    public Mesa_Impl() throws RemoteException {

        super();
    }

    // Método remoto implementado.
    @Override
    public void imprimirMensagem(String mensagem) {
        String[] msg;
        msg = mensagem.trim().split("#");
        if (msg[0].contains("5")) {
            Mesa_Telas_Inicio.setNumMesa(Integer.parseInt(msg[1]));
        }
    }
}
