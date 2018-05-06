package Co.utilisateur;

import Co.AbstractDAO;
import Co.ConnectionFactory;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Requêtes SQL.
 * @author m-besnard
 */
public class UtilisateurDAO extends AbstractDAO {

    Connection con;
    
    /**
    * Connexion.
    * @throws java.sql.SQLException
    **/
    public UtilisateurDAO() throws SQLException {
        con = ConnectionFactory.getConnection();
    }

    /**
     * Nom de l'objet.
     * @return utilisateur
     */
    @Override
    protected String getObjectName() {
        return "Utilisateur";
    }

    /**
     * Vérifie si l'utilisateur existe.
     * 
     * @param user
     * @return le résultat
     **/
    public boolean isUserExist(Utilisateur user) {
        String sql = "SELECT * FROM utilisateur where login='" + user.getLogin() + "' and password='" + user.getPassword() + "'";
        try {
            boolean resultat = false;
            Statement statement = ConnectionFactory.getConnection().createStatement();
            ResultSet res = statement.executeQuery(sql);
            resultat = res.next();
            res.close();
            return resultat;
        } catch (SQLException e) {
            System.out.println("Erreur de connexion à la base: " + e);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    /**
     * Insert l'utilisateur.
     * @param u
     * @return l'objet
     * @throws SQLException 
     */
    public boolean insert(Utilisateur u) throws SQLException {
        return super.insertSingle(u);
    }
    
    /**
     * Supprimer par l'id.
     * @param u
     * @return
     * @throws SQLException 
     */
    public int deleteById(Utilisateur u) throws SQLException {
        return super.deleteObject(u, "" + u.getIdAutoIncrementName() + "=" + u.getIdAutoIncrementName());
    }

    /**
     * Supprimer par le login.
     * @param u
     * @return
     * @throws SQLException 
     */
    public int deleteByLogin(Utilisateur u) throws SQLException {
        return super.deleteObject(u, "" + u.getLogin()+ "=" + u.getLogin());
    }

}
