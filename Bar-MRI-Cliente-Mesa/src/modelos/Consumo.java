/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import java.util.ArrayList;

/**
 *
 * @author adson
 */
public class Consumo {
    private ArrayList<Produto> produtos = new ArrayList(); //Array
    private double total = 0;
    
    public Consumo(){
    }

    /**
     * @return the produtos
     */

    
    
    public void addProduto(Produto produto){
        produtos.add(produto);
    }
    /**
     * @return the total
     */
    public double getTotal() {
        for (Produto produto : produtos) {
            total = total + produto.getPreco() * produto.getQuantidade();
        }
        return total;
    }

    /**
     * @param total the total to set
     */
    public void setTotal(double total) {
        this.total = total;
    }
    
    
    
}
