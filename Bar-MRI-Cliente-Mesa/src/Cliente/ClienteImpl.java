package Cliente;

import Interfaces.ServidorInterface;
import Telas.Telas_Inicio;
import java.awt.Color;
import java.rmi.RemoteException;
import java.rmi.server.*;


/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Vinicius
 */
// Classe responsável pela implementação dos métodos remotos definidos pela Interface
public class ClienteImpl extends UnicastRemoteObject implements ServidorInterface {

    public ClienteImpl() throws RemoteException {

        super();
    }

    // Método remoto implementado.
    @Override
    public void imprimirMensagem(String mensagem) {
        String[] msg;
        msg = mensagem.trim().split("#");
        if (msg[0].contains("2")) {
            Telas_Inicio.getCardapio().addProdudo();
        }else if(msg[0].contains("3")){
            Telas_Inicio.getConsumo().addProduto(msg[2], msg[3], msg[4], msg[5]);
        }
    }
}
