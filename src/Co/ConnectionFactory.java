package Co;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Ici 2 Design Patern : Singleton + Factory.
 * 
 * Forme package : ORM > BD , DAO > SQL , Objet
 *
 * @author m-besnard
 * 
 * Class.forName + DriverManger postgresql et phpmyadmin pour différents lieux
 */
public class ConnectionFactory {  //Centre le code pour la connection. -> evite de chercher partout ou se trouve la connection.

    private static Connection con = null; //Singleton : évite d'instencier plusieurs fois

    public static Connection getConnection() throws SQLException { //fabrication de la connexion
        if (con == null) { //Singleton : évite d'instencier plusieurs fois
            try {
                /*Class.forName("com.mysql.jdbc.Driver"); //mySQL */
                Class.forName("org.postgresql.Driver"); //PostgreSQL 
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
            }
           con = DriverManager.getConnection("jdbc:postgresql://172.17.121.76/cvvenjava", "test", "test"); //lycéeLocal 
        }
        return con;
    }

}
