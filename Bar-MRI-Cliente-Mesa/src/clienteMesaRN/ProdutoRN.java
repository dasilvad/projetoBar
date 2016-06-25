/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clienteMesaRN;

import PacotePrincipal.Produto;
import clienteMesaPER.ProdutoPER;
import java.util.ArrayList;

/**
 *
 * @author daniel
 */
public class ProdutoRN {

    public ArrayList<Produto> buscarCardapio() {
        ProdutoPER pper = new ProdutoPER();
        try{
            return pper.buscarCardapio();
        }catch (Exception e){
            return null;
        }
    }
    
}
