/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clienteMesaRN;

import clienteMesaPER.MesaPER;

/**
 *
 * @author daniel
 */
public class MesaRN {

    

    public boolean cadastrarMesa(String usuario) {
        MesaPER mesaPER = new MesaPER();
        return mesaPER.cadastrarMesa(usuario);
    }
    
}
