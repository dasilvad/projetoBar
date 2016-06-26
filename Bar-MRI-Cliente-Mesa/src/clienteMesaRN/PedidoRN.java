/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clienteMesaRN;

import PacotePrincipal.ItemPedido;
import clienteMesaPER.PedidoPER;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 *
 * @author daniel
 */
public class PedidoRN {

    public boolean fazerPedido(ArrayList<ItemPedido> pedido, String usuario) throws RemoteException {
       PedidoPER pedidoPER = new PedidoPER();
       return pedidoPER.fazerPedido(pedido, usuario);
    }
    
}
