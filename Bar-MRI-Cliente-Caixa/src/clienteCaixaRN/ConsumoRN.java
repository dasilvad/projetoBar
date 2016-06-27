/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clienteCaixaRN;

import PacotePrincipal.Consumo;
import clienteCaixaPER.ConsumoPER;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 *
 * @author daniel
 */
public class ConsumoRN {

    public ArrayList<String> buscarMesas() throws RemoteException{
        ConsumoPER consumoPER = new ConsumoPER();
        return consumoPER.buscarMesas();
    }

    public ArrayList<Consumo> buscarConsumo(String id_mesa) throws RemoteException {
        ConsumoPER consumoPER = new ConsumoPER();
        return consumoPER.buscarConsumo(id_mesa);
    }
    
}
