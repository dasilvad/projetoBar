package Servidor;


import Interfaces.Servidor_Interface;
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
    

    public Servidor() throws IOException {
        try {
            // Registrando o serviço em uma determinada porta.
            RegistryImpl registryImpl = new RegistryImpl(12345);    
        
            // Instanciando a classe Servidor_Impl que é do tipo ServidorInterface.
            Servidor_Interface servidor = new Servidor_Impl();    
            
            // Possibilitando que a instância contendo métodos remotos fique visível aos clientes. Além do IP e PORTA, deve-se associar um nome a instância.
            // Parâmetros: String (IP, Porta e nome do serviço) e Objeto com métodos remotos.
            Naming.rebind("rmi://127.0.0.1:12345/Servidor", servidor); 
            
            
            
            
        } catch (Exception e) {
            
            System.out.println("Erro: " + e.getMessage());
        }
    }
}
