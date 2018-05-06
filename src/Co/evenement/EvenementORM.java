
package Co.evenement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Convertir (factorise).
 * @author m-besnard
 */
public class EvenementORM {

    public static Evenement convert(ResultSet rs) {

        try {
            /*1 ligne de BD*/
            Evenement evenmt = new Evenement();
            evenmt.setIdevenement(rs.getInt("idevenement"));
            evenmt.setLibelle(rs.getString("libelle"));
            evenmt.setDescription(rs.getString("description"));
            evenmt.setOrganisateur(rs.getString("organisateur"));
            evenmt.setTypeevenement(rs.getString("typeevenement"));
            evenmt.setNbreparticipantmax(rs.getInt("nbreparticipantmax"));
            evenmt.setDatedebut(rs.getString("datedebut"));
            evenmt.setDatefin(rs.getString("datefin"));
            evenmt.setTheme(rs.getString("theme"));
            evenmt.setIdsalle(rs.getInt("idsalle"));
            return evenmt;
        } catch (SQLException ex) {
            Logger.getLogger(EvenementORM.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}