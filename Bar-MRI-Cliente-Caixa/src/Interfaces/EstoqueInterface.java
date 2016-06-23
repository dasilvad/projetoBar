package Interfaces;


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
public interface EstoqueInterface extends Remote {
    public boolean inserirProdutoNoBanco(Produto produto) throws RemoteException;
    public boolean atualizarProdutoNoBanco(String produto) throws RemoteException;
    public boolean buscarProdutosDoBanco() throws RemoteException;
    public ArrayList<Produto> buscarProdutos() throws RemoteException;
}
