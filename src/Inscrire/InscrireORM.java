package Inscrire;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Convertir (factorise).
 * @author m-besnard
 */
public class InscrireORM {
    
    public static Inscrire convert(ResultSet rs) {

        try {
            Inscrire insc = new Inscrire();
            insc.setIdparticipant(rs.getInt("idparticipant"));
            insc.setIdevenement(rs.getInt("idevenement"));
            insc.setHebergement(rs.getBoolean("hebergement"));
            insc.setRestauration(rs.getBoolean("restauration"));
            return insc;
        } catch (SQLException ex) {
            Logger.getLogger(InscrireORM.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}