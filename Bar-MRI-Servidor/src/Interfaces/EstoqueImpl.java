package Caixa;


import Interfaces.EstoqueInterface;
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
public class EstoqueImpl extends UnicastRemoteObject implements EstoqueInterface {
    
    public EstoqueImpl() throws RemoteException {
        
        super();
    }

    @Override
    public boolean inserirProdutoNoBanco(String produto) throws RemoteException {
        System.out.println("Inserido no banco");
        return true;
    }

    @Override
    public boolean atualizarProdutoNoBanco(String produto) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean buscarProdutosDoBanco() throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
}
