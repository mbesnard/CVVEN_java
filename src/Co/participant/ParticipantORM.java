package Co.participant;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *  Convertir (factorise).
 * @author m-besnard
 */
public class ParticipantORM {

    public static Participant convert(ResultSet rs) throws SQLException {
        
        /*1 ligne BD*/
        Participant p = new Participant();
        p.setAdresse(rs.getString("adresse"));
        p.setAdressemail(rs.getString("adressemail"));
        p.setCodepostal(rs.getInt("codepostal"));
        p.setDatenaissance(rs.getInt("datenaissance"));
        p.setEntreprise(rs.getString("entreprise"));
        p.setIdparticipant(rs.getInt("idparticipant"));
        p.setNom(rs.getString("nom"));
        p.setNumerotel(rs.getInt("numerotel"));
        p.setPrenom(rs.getString("prenom"));
        p.setVille(rs.getString("ville"));
        return p;
    }

    /**
    *  Convertir pour fichier CSV.
     * @param line ligne
     * @param separator ","
     * @return participants
    */
    public static Participant convert(String line, String separator) {
        Participant p = new Participant();

        /*morceaux > ce qu'il y a entre "" */
        String morceaux[] = line.split(separator);
        int i = 0;
        for (String value : morceaux) {
            morceaux[i] = value.replaceAll("\"", ""); //remplace par des ''
            i++;
        }
        i = 0;
        /*1 ligne CSV*/
        p.setIdparticipant(Integer.parseInt(morceaux[i++]));
        p.setNom(morceaux[i++]);
        p.setPrenom(morceaux[i++]);
        p.setDatenaissance(Integer.parseInt(morceaux[i++]));
        p.setAdresse(morceaux[i++]);
        p.setVille(morceaux[i++]);
        p.setCodepostal(Integer.parseInt(morceaux[i++]));
        p.setNumerotel(Integer.parseInt(morceaux[i++]));
        p.setAdressemail(morceaux[i++]);
        p.setEntreprise(morceaux[i++]);
        return p;
    }

}
