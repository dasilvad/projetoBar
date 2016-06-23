/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServidorPER;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author daniel
 */
public class Connect {
    

    private static Connect instance;
    private Connection con;

    private Connect() throws SQLException {
        try {
            Class.forName("org.postgresql.Driver");
            this.con = DriverManager.getConnection("jdbc:postgresql://localhost/bar", "postgres", "123");
        } catch (ClassNotFoundException e ) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public Connection connectDB(){
        return con;
    }

    public static Connect getInstace(){
        try {
            if (instance == null) {
                instance = new Connect();
            } else if (instance.connectDB().isClosed()) {
                instance = new Connect();
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Connect.class.getName()).log(Level.SEVERE, null, ex);
        }
        return instance;
    }
}
