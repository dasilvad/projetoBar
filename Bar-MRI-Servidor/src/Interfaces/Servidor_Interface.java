package Interfaces;


import java.rmi.*;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Vinicius
 */

// Interface responsável por conter as assinaturas dos métodos remotos.
// Obrigatóriamente esta interface deve herdar da classe Remote, esta do pacote RMI do Java.
public interface Servidor_Interface extends Remote {
    
    // Método remoto
    // Todos os métodos remotos podem gerar uma exceção RemoteException
    void imprimirMensagem(String mensagem) throws RemoteException;
}
