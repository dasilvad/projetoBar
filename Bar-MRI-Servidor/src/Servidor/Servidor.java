package Servidor;


import Interfaces.*;
import Telas.TelaServidor;
import java.io.IOException;
import java.rmi.Naming;
import sun.rmi.registry.RegistryImpl;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Vinicius
 */
public class Servidor {
    

    public Servidor(){
        try {
            // Registrando o serviço em uma determinada porta.
            RegistryImpl registryImpl = new RegistryImpl(12345);    
        
            TelaServidor telaServidor = new TelaServidor();
            telaServidor.setVisible(true);
            
            ImplementacaoIntefaces servidor = new ImplementacaoIntefaces(telaServidor);    
            
            // Possibilitando que a instância contendo métodos remotos fique visível aos clientes. Além do IP e PORTA, deve-se associar um nome a instância.
            // Parâmetros: String (IP, Porta e nome do serviço) e Objeto com métodos remotos.
            Naming.rebind("rmi://127.0.0.1:12345/servicoServidor", servidor); 
            
            
        } catch (Exception e) {
            
            
        }
    }
    public static void main(String[] args){
        new Servidor();
    }
}
