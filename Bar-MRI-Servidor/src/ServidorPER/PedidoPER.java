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
import java.util.ArrayList;

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
                sql = "select quantidade from Consumo where id_mesa = '"+usuario+"' and id_produto = "+pedido.get(i).getId_produto();
                pst = con.prepareStatement(sql);
                ResultSet rs = pst.executeQuery();
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
            }
            return true;
           
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }
        
    }
    
}
