/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clienteMesaPER;

import Mesa.MetodoRemotoDoServidor;
import PacotePrincipal.ItemPedido;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 *
 * @author daniel
 */
public class PedidoPER {

    public boolean fazerPedido(ArrayList<ItemPedido> pedido, String usuario) throws RemoteException {
        MetodoRemotoDoServidor m = new MetodoRemotoDoServidor();
        return m.conectar().fazerPedido(pedido, usuario);
        
    }
    
}
