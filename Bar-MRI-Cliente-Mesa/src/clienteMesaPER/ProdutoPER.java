/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clienteMesaPER;

import Mesa.MetodoRemotoDoServidor;
import PacotePrincipal.Produto;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 *
 * @author daniel
 */
public class ProdutoPER {

    public ArrayList<Produto> buscarCardapio() throws RemoteException {
        MetodoRemotoDoServidor m = new MetodoRemotoDoServidor();
        return m.conectar().buscarProdutos();
    }
    
}
