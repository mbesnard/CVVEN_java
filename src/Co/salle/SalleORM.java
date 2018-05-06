package Co.salle;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Convertir (factorise).
 * @author m-besnard
 */
public class SalleORM {

    public static Salle convert(ResultSet rs) {
        try {
            Salle salle = new Salle();
            salle.setIdsalle(rs.getInt("idsalle"));
            salle.setNomsalle(rs.getString("nomsalle"));
            salle.setDescription(rs.getString("description"));
            salle.setCapacite(rs.getInt("capacite"));
            return salle;
        } catch (SQLException ex) {
            Logger.getLogger(SalleORM.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
