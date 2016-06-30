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
import java.util.ArrayList;

/**
 *
 * @author daniel
 */
public class LoginPER {
    private Connection con=null;
    
    public boolean logar(String usuario) {
        
        PreparedStatement pst;
        ResultSet rs;
        
        try{
            con=Connect.getInstace().connectDB();
            String sql= "select id_mesa from Mesa where upper (id_mesa) = upper ('"+usuario+"')";        
            pst=con.prepareStatement(sql);
            rs= pst.executeQuery();
            
            if (rs.next()){//usuario ja existe
                return false;
            }
           
           
            
            return true;
        }catch (Exception e){
            return false;            
        }
    
    }
}
