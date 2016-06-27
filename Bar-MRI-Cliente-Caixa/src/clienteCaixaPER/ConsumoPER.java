/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clienteCaixaPER;

import Caixa.MetodoRemotoDoServidor;
import PacotePrincipal.Consumo;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 *
 * @author daniel
 */
public class ConsumoPER{

    public ArrayList<String> buscarMesas() throws RemoteException{
        MetodoRemotoDoServidor m = new MetodoRemotoDoServidor();
        return m.conectar().buscarMesas();
    }

    public ArrayList<Consumo> buscarConsumo(String id_mesa) throws RemoteException {
        MetodoRemotoDoServidor m = new MetodoRemotoDoServidor();
        return m.conectar().buscarConsumo(id_mesa);
    }
    
}
