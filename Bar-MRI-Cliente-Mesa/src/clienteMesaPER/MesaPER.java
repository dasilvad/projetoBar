/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clienteMesaPER;

import Mesa.MetodoRemotoDoServidor;

/**
 *
 * @author daniel
 */
public class MesaPER {

    public boolean cadastrarMesa(String usuario) {
        MetodoRemotoDoServidor m = new MetodoRemotoDoServidor();
        try{
            return m.conectar().cadastrarMesa(usuario);
        }catch(Exception e){
            
            return false;
        }
    }
    
}
