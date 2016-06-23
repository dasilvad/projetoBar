/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServidorPER;

import PacotePrincipal.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;


/**
 *
 * @author daniel
 */
public class ProdutoPER {
    private Connection con=null;
    
    public boolean inserirProduto(Produto produto){
        PreparedStatement pst;
        con=Connect.getInstace().connectDB();         
        try{    
        String sql = "insert into produto(nome,categoria,preco_venda,quantidade,status)values('" + produto.getNome() + "','" + produto.getCategoria() + "'," + produto.getPreco() + "," + produto.getQuantidade()+ ","+"'ativo')";
        pst = con.prepareStatement(sql);
        pst.execute();
        return true;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }
}
