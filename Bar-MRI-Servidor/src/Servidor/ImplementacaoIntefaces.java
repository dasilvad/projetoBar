package Servidor;

import Interfaces.ServidorInterface;
import PacotePrincipal.ItemPedido;
import PacotePrincipal.Produto;
import ServidorPER.LoginPER;
import ServidorPER.MesaPER;
import ServidorPER.PedidoPER;
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

    @Override
    public boolean logar(String usuario) throws RemoteException {
        LoginPER loginPER = new LoginPER();
        return loginPER.logar(usuario);
    }

    @Override
    public boolean fazerPedido(ArrayList<ItemPedido> pedido, String usuario) throws RemoteException {
        PedidoPER pedidoPER = new PedidoPER();
        return pedidoPER.fazerPedido(pedido, usuario);
    }

    @Override
    public boolean cadastrarMesa(String usuario) throws RemoteException {
        MesaPER mesaPER = new MesaPER();
        return mesaPER.cadastrarMesa(usuario);
    }

    @Override
    public boolean isDisponivelNoEstoque(ItemPedido item) throws RemoteException {
        PedidoPER pedidoPER = new PedidoPER();
        return pedidoPER.isDisponivelNoEstoque(item);
    }

 


   
}
