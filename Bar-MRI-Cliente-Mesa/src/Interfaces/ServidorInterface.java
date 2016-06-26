package Interfaces;


import PacotePrincipal.ItemPedido;
import PacotePrincipal.Produto;
import java.rmi.*;
import java.util.ArrayList;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Adson
 */

// Interface responsável por conter as assinaturas dos métodos remotos.
// Obrigatóriamente esta interface deve herdar da classe Remote, esta do pacote RMI do Java.
public interface ServidorInterface extends Remote {
    public int inserirProdutoNoBanco(Produto produto) throws RemoteException;
    public boolean atualizarProduto(Produto produto) throws RemoteException;
    public boolean buscarProdutosDoBanco() throws RemoteException;
    public ArrayList<Produto> buscarProdutos() throws RemoteException;
    public boolean deletarProduto(int id_produto) throws RemoteException;
    public boolean logar(String usuario) throws RemoteException;

    public boolean  fazerPedido(ArrayList<ItemPedido> pedido, String usuario) throws RemoteException;

    public boolean cadastrarMesa(String usuario) throws RemoteException;

    public boolean isDisponivelNoEstoque(ItemPedido item) throws RemoteException;
}
