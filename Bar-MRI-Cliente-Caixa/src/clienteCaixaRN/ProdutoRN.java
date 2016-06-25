/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clienteCaixaRN;

import PacotePrincipal.Produto;
import Telas.Caixa_Telas_Estoque;
import clienteCaixaPER.ProdutoPER;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author daniel
 */
public class ProdutoRN {
    
    /*-2: campos nao preenchidos incorretamente
    -1: erro ao salvar no banco de dados
     >=0: chave primaria do produto inserido*/
    public int inserirProduto(Produto produto) {
        ProdutoPER produtoPER = new ProdutoPER();
        if (produto.getNome().equals("") || produto.getCategoria().equals("") || produto.getQuantidade() < 1){
            return -2;
        }
        
        try {
            int lastId = produtoPER.inserirProduto(produto);
            return lastId;
        } catch (RemoteException ex) {
            return -1;
        }
         
    }

    public boolean deletarProduto(int id_produto) {
        ProdutoPER produtoPER = new ProdutoPER();
        if (produtoPER.deletarProduto(id_produto)){
            return true;
        }else{
            return false;
        }
    }
    
}
