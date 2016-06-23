/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServidorPER;

import PacotePrincipal.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;


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
            return false;
        }
    }

    public ArrayList<Produto> buscarProdutos() {
        PreparedStatement pst;
        ResultSet rs;
        ArrayList<Produto> lista = new ArrayList<>();
        try{
            con=Connect.getInstace().connectDB();
            String sql= "select * from produto where status = 'ativo'";        
            pst=con.prepareStatement(sql);
            rs= pst.executeQuery();
            
            
            while (rs.next()){
                Produto p;
                p = new Produto(rs.getString("nome"), rs.getString("categoria"), rs.getFloat("preco_venda"), rs.getInt("quantidade"));
                System.out.println(p.getNome());
                lista.add(p);                
            }
        }catch(Exception e){
            return null;
        }
        return lista;
    }
}
