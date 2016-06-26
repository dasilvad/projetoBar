/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServidorPER;

import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author daniel
 */
public class MesaPER {
    private Connection con=null;
    
    public boolean cadastrarMesa(String usuario) {
        
  
        PreparedStatement stm;
        con=Connect.getInstace().connectDB();         
        try{    
            String sql = "insert into mesa (id_mesa) values('"+usuario+"')";
            stm = con.prepareStatement(sql);
            stm.executeUpdate();

            return true;
        
        }catch(Exception e){
            return false;
        }
    }
    
}
