/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServidorPER;

import PacotePrincipal.Consumo;
import PacotePrincipal.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author daniel
 */
public class ConsumoPER {
    private Connection con=null;
    
    public ArrayList<String> buscarMesas() {
        PreparedStatement pst;
        ResultSet rs;
        ArrayList<String> lista = new ArrayList<>();
        
        try{
            con=Connect.getInstace().connectDB();
            String sql= "select DISTINCT m.id_mesa as id_mesa from MESA m join CONSUMO c on m.id_mesa = c.id_mesa order by m.id_mesa";        
            pst=con.prepareStatement(sql);
            rs= pst.executeQuery();
            
            while (rs.next()){
                lista.add(rs.getString("id_mesa"));             
            }
        }catch(Exception e){
            return null;
        }
        return lista;
    }

    public ArrayList<Consumo> buscarConsumo(String id_mesa) {
        PreparedStatement pst;
        ResultSet rs;
        ArrayList<Consumo> lista = new ArrayList<>();
        try{
            con=Connect.getInstace().connectDB();
            String sql= "select p.id_produto as id_produto, p.nome as nome, p.categoria as categoria, p.quantidade as quantidade_produto, p.preco_venda as preco_venda, c.quantidade as quantidade_consumo from produto p, consumo c where c.id_mesa = '"+id_mesa+"' and c.id_produto = p.id_produto";        
            pst=con.prepareStatement(sql);
            rs= pst.executeQuery();
            
            
            while (rs.next()){
                Produto p;
                p = new Produto(rs.getString("nome"), rs.getString("categoria"), rs.getFloat("preco_venda"), rs.getInt("quantidade_produto"));
                int quantidade = rs.getInt("quantidade_consumo");
                p.setId(rs.getInt("id_produto"));
                Consumo c = new Consumo(p, id_mesa, quantidade);
                lista.add(c);
                               
            }
        }catch(Exception e){
            return null;
        }
        return lista;
    }

    public boolean fecharConta(String id_mesa) {
        try{
            PreparedStatement pst;
            con=Connect.getInstace().connectDB();
            String sql= "delete from CONSUMO where id_mesa = '"+id_mesa+"'";
            pst=con.prepareStatement(sql);
            pst.executeUpdate();
            
            sql= "delete from MESA where id_mesa = '"+id_mesa+"'";
            pst=con.prepareStatement(sql);
            pst.executeUpdate();
            
            
            
            return true;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }
    
}
