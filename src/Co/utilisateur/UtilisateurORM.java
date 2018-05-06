package Co.utilisateur;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Convertir (factorise).
 * @author m-besnard
 */
public class UtilisateurORM {

    public static Utilisateur convert(ResultSet rs) {
        try {
            Utilisateur user = new Utilisateur();
            user.setId(rs.getInt("id"));
            user.setLogin(rs.getString("login"));
            user.setPassword(rs.getString("password"));
            return user;
        } catch (SQLException ex) {
            Logger.getLogger(UtilisateurORM.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
