package Servidor;
import Interfaces.EstoqueInterface;
import PacotePrincipal.Produto;
import ServidorPER.ProdutoPER;
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
public class ImplementacaoIntefaces extends UnicastRemoteObject implements EstoqueInterface {
    
    public ImplementacaoIntefaces() throws RemoteException {
        
        super();
    }

    

    @Override
    public boolean atualizarProdutoNoBanco(String produto) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean buscarProdutosDoBanco() throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean inserirProdutoNoBanco(Produto produto) {
        ProdutoPER produtoPER = new ProdutoPER();
        return produtoPER.inserirProduto(produto);
    }

   
}