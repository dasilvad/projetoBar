/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clienteCaixaPER;

import Caixa.MetodoRemotoDoServidor;
import PacotePrincipal.Produto;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author daniel
 */
public class ProdutoPER {
    
    public boolean inserirProduto(Produto produto) throws RemoteException{
        MetodoRemotoDoServidor m = new MetodoRemotoDoServidor();
        return m.conectar().inserirProdutoNoBanco(produto);
            
    }
    
    public boolean atualizarProduto(Produto produto){
        return false;
    }
    
    public ArrayList<Produto> buscarProdutos() throws RemoteException {
        MetodoRemotoDoServidor m = new MetodoRemotoDoServidor();
        return m.conectar().buscarProdutos();
    }
}
