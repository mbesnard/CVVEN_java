package Co.salle;

import Co.ConnectionFactory;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Requête SQL.
 * @author m-besnard
 */
public class SalleDAO {

    Connection con;

    /**
    * Connexion.
    */
    public SalleDAO() throws SQLException {
        con = ConnectionFactory.getConnection();
    }

  
    /**
     * Retrourne toutes les salles.
     * @return les salles
     */
    public List<Salle> getAllSalles() {
        String sql = "SELECT * FROM salle" ;        
        try {
            List<Salle> salles = new ArrayList<>();
            Statement statement = ConnectionFactory.getConnection().createStatement();
            ResultSet res = statement.executeQuery(sql);   
            while(res.next()){
                salles.add(SalleORM.convert(res));
            }
            res.close();
            return salles;
        } catch (SQLException e) {
            System.out.println("Erreur de connexion à la base: " + e);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}


