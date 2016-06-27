/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PacotePrincipal;

import java.io.Serializable;



/**
 *
 * @author daniel
 */
public class Consumo implements Serializable{
    private Produto produto;

    public Consumo() {
    }

    public Consumo(Produto produto, String id_mesa, int quantidade) {
        this.produto = produto;
        this.id_mesa = id_mesa;
        this.quantidade = quantidade;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public String getId_mesa() {
        return id_mesa;
    }

    public void setId_mesa(String id_mesa) {
        this.id_mesa = id_mesa;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    private String id_mesa;
    private int quantidade;
    
    
}
