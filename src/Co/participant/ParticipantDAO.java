package Co.participant;

import Co.AbstractDAO;
import Co.ConnectionFactory;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Requête SQL.
 * @author m-besnard
 */
public class ParticipantDAO extends AbstractDAO {

    Connection con;

    /**
    * Connexion.
     * @throws java.sql.SQLException
    */
    public ParticipantDAO() throws SQLException {
        con = ConnectionFactory.getConnection();
    }

    /**
    * Nom de l'objet.
     * @return participant
    */
    @Override
    protected String getObjectName() {
        return "Participant";
    }

    /**
    * Insert les participants.
     * @param lp liste des participants
     * @return la liste des participants
     * @throws java.sql.SQLException
    */
    public int insert(List<Participant> lp) throws SQLException {
        return super.insertList(lp);
    }
    
    /**
    * Fournit tout les participants dans la Map (= dico).
     * @return le dico des participants ou rien
    */
    public Map<Integer, Participant> getAllPArticipant(){
        String sql = "SELECT * FROM participant" ;    
        Map<Integer, Participant> map = new HashMap<>(); 
        try {         
            Statement statement = ConnectionFactory.getConnection().createStatement();
            ResultSet res = statement.executeQuery(sql);   
            Participant p = null;
            while(res.next()){
                p = ParticipantORM.convert(res);
                map.put(p.getIdparticipant(), p);   //dico par idparticipant          
            }
            res.close();
            return map;
        } catch (SQLException e) {
            System.out.println("Erreur de connexion à la base: " + e);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
}
