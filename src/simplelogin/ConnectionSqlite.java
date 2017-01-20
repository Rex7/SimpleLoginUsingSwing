/*

 *     Rex
 */

package simplelogin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Regis
 */
public class ConnectionSqlite {
    String dbname="MainPage.db";
    public void createDatabase(){
        
        Connection connection;
        try {
            connection = DriverManager.getConnection("jdbc:sqlite:"+dbname);
            PreparedStatement pst = connection.prepareStatement("create table if not exists register"
                    + "( phoneNo Text,"
                    + "password Text,"
                    + "userName Text"
                    + ")");
           boolean flag= pst.execute();
            System.out.println(flag);
            System.out.println("c"+connection.getSchema());
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionSqlite.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        
    }
    public static void main(String[] args) {
       new  ConnectionSqlite().createDatabase();
    }
       

}
