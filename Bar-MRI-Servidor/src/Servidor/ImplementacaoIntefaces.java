package Servidor;
import Interfaces.ServidorInterface;
import PacotePrincipal.Produto;
import ServidorPER.ProdutoPER;
import java.rmi.RemoteException;
import java.rmi.server.*;
import java.util.ArrayList;


/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Adson
 */

// Classe responsável pela implementação dos métodos remotos definidos pela Interface
public class ImplementacaoIntefaces extends UnicastRemoteObject implements ServidorInterface {
    
    public ImplementacaoIntefaces() throws RemoteException {
        
        super();
    }

    

    @Override
    public boolean atualizarProduto(Produto produto) throws RemoteException {
        ProdutoPER produtoPER = new ProdutoPER();
        return produtoPER.atualizarProduto(produto);
    }

    @Override
    public boolean buscarProdutosDoBanco() throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int inserirProdutoNoBanco(Produto produto) {
        ProdutoPER produtoPER = new ProdutoPER();
        return produtoPER.inserirProduto(produto);
    }

    @Override
    public ArrayList<Produto> buscarProdutos() {
        ProdutoPER produtoPER = new ProdutoPER();
        return produtoPER.buscarProdutos();
    }

    @Override
    public boolean deletarProduto(int id_produto) {
        ProdutoPER produtoPER = new ProdutoPER();
        return produtoPER.deletarProduto(id_produto);
    }

   
}
