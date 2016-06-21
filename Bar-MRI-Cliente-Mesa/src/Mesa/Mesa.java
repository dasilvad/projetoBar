package Mesa;

import Interfaces.Mesa_Interface;
import Interfaces.Servidor_Interface;
import java.rmi.Naming;
import java.rmi.RemoteException;
import sun.rmi.registry.RegistryImpl;

/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */
/**
 *
 * @author Adson
 */
public class Mesa {

    private Servidor_Interface servidor;
    private Mesa_Interface cliente;


    
    public Mesa(){}
    
    public String Conectar(){
        try {

            RegistryImpl registryImpl = new RegistryImpl(12346);

            // Instanciando a classe ServidorImpl que é do tipo ServidorInterface.
            cliente = new Mesa_Impl();

            Naming.rebind("rmi://127.0.0.1:12346/Mesa", cliente);
            // Recuperando o objeto remoto.
            // Para obtê-lo é necessário indicar o IP, Porta e Nome do serviço (nome associado a instância do objeto remoto)
            servidor = (Servidor_Interface) Naming.lookup("rmi://127.0.0.1:12345/Servidor");

            servidor.imprimirMensagem("1#12346");
            // Utilização dos métodos remotos, bastante semelhante a utilização de métodos locais.

            //System.out.println("Mensagem recebida: "+ retorno);    
        } catch (Exception e) {
            return ("Erro: " + e.getMessage());
        }
        
        return "conectado";
    }
    
    public void enviarMensagem(String mensagem) throws RemoteException{
        servidor.imprimirMensagem("3#"+mensagem);
    }
    
}
