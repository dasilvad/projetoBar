/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PacotePrincipal;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author daniel
 */
public class ItemPedido implements Serializable{
    private int id_produto;
    private int quantidade;

    public ItemPedido(int id_produto, int quantidade) {
        this.id_produto = id_produto;
        this.quantidade = quantidade;
    }

    public int getId_produto() {
        return id_produto;
    }

    public void setId_produto(int id_produto) {
        this.id_produto = id_produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    
}
