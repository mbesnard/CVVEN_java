package Inscrire;

import Co.AbstractDAO;
import Co.ConnectionFactory;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Requêtes SQL.
 * @author m-besnard
 */
public class InscrireDAO extends AbstractDAO {

    Connection con;
    /**
     * Conexion.
     * @throws SQLException 
     */
    public InscrireDAO() throws SQLException {
        con = ConnectionFactory.getConnection();
    }
    
    /**
     * Nom de l'objet.
     * @return Inscrire
     */
   @Override
    protected String getObjectName() {
        return "Inscrire";
    }
    
    /**
     * Insert les inscriptions.
     * @param ins
     * @return l'objet
     * @throws SQLException 
     */
    public boolean insert(Inscrire ins) throws SQLException {
        return super.insertSingle(ins);
    }

 
}
