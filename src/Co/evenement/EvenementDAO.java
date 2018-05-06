package Co.evenement;

import Co.AbstractDAO;
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
public class EvenementDAO extends AbstractDAO {

    Connection con;
    
    /**
    * Connexion.
     * @throws java.sql.SQLException
    */
    public EvenementDAO() throws SQLException {
        con = ConnectionFactory.getConnection();
    }

    /**
    * nom de l'objet.
     * @return evenement
    */
    @Override
    protected String getObjectName() {
        return "Evenement";
    }

    /**
     * Insert les évènements.
     * @param evt
     * @return l'objet 
     * @throws java.sql.SQLException 
     */
    public boolean insert(Evenement evt) throws SQLException {
        return super.insertSingle(evt);
    }

    /**
     * Retrourne tous les evenements.
     * @param position a partir d'ou
     * @param limit  cb
     * @return evenmt ou rien
     */
    public List<Evenement> getAllEvenement(int position, int limit) { 
        String sql = "SELECT * FROM " + getObjectName();
        if (limit > 0) {
            sql += "limit " + position + ", " + limit; //sql += "limit " +position +" OFFSET "+limit;
        }
        try {
            Statement statement = ConnectionFactory.getConnection().createStatement();
            ResultSet res = statement.executeQuery(sql);
            List<Evenement> evenmts = new ArrayList<>();
            while (res.next()) { //convertir
                Evenement evenmt = EvenementORM.convert(res);
                evenmts.add(evenmt);
            }
            res.close();
            return evenmts;
        } catch (SQLException e) {
            System.out.println("Erreur de connexion à la base: " + e);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null; //sinon affiche rien
    }

    /**
     * Retrourne le nombre d'evenements.
     * 
     * @return int
     * @throws java.sql.SQLException
     */
    public long getNbEvenement() throws SQLException {
        String sql = "SELECT count(*) FROM " + getObjectName(); //compte
        Statement statement = ConnectionFactory.getConnection().createStatement();
        ResultSet rs = statement.executeQuery(sql);
        rs.next();
        long res = rs.getLong(1); //resultat du nombre de ligne dans la 1ère colonne
        rs.close();
        return res;
    }

}
