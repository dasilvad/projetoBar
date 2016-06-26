/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServidorPER;

import PacotePrincipal.ItemPedido;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author daniel
 */
public class PedidoPER {
    private Connection con = null;
    
    public boolean fazerPedido(ArrayList<ItemPedido> pedido, String usuario) {
        PreparedStatement pst;
        
        
        try{
            con=Connect.getInstace().connectDB();
            
            for (int i= 0; i < pedido.size(); i++){
                String sql;
                //--------------diminuir o estoque de produtos ----------------------------------
                sql = "select quantidade from PRODUTO where id_produto = "+pedido.get(i).getId_produto();
                pst = con.prepareStatement(sql);
                ResultSet rs = pst.executeQuery();
                if (rs.next()){
                    int quantidade = rs.getInt(1) - pedido.get(i).getQuantidade();
                    sql = "update PRODUTO set quantidade = "+quantidade+" where id_produto = "+pedido.get(i).getId_produto();
                    pst=con.prepareStatement(sql);
                    pst.executeUpdate();
                }
                //--------------------------------------------------------------------------------
                
                
                //----------atualizar ou inserir produto e mesa na tabela CONSUMO
                sql = "select quantidade from Consumo where id_mesa = '"+usuario+"' and id_produto = "+pedido.get(i).getId_produto();
                pst = con.prepareStatement(sql);
                rs = pst.executeQuery();
                if (rs.next()){
                    int quantidade = rs.getInt(1) + pedido.get(i).getQuantidade();
                    sql = "update Consumo set quantidade = "+quantidade+" where id_mesa = '"+usuario+"' and id_produto = "+pedido.get(i).getId_produto();
                    pst=con.prepareStatement(sql);
                    pst.executeUpdate();
                }else{
                    sql= "insert into Consumo (id_mesa, id_produto, quantidade) values ('"+usuario+"', "+pedido.get(i).getId_produto()+", "+ pedido.get(i).getQuantidade()+")";        
                    pst=con.prepareStatement(sql);
                    pst.executeUpdate();
                }
                
                //----------------------------------------------------------------------------------
            }
            return true;
           
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }
        
    }

    public boolean isDisponivelNoEstoque(ItemPedido item) {
        PreparedStatement pst;
        con=Connect.getInstace().connectDB();
        String sql;
        sql = "select quantidade from Produto where id_produto = "+item.getId_produto();
        try {
            pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
        
            if (rs.next()){
               int quantidade = rs.getInt(1);
               if (quantidade >= item.getQuantidade()){//item do pedido disponivel no estoque
                   return true;
               }else{//item indisponivel
                   return false;
               }
            }
            return false;//erro ao acessar o resultSet ou o produto foi deletado do estoque
        } catch (SQLException ex) {
            return false;//erro ao acessar o banco de dados
        }
        
    }
    
}
