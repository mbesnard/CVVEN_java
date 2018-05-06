import Co.utilisateur.Utilisateur;
import Co.utilisateur.UtilisateurDAO;
import java.sql.SQLException;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test Login User.
 * @author MaureenD
 */
public class TestLogin {

    public TestLogin() {
    }

    @Test
    public void testLoginOK() throws SQLException {
        String login = "toto";
        String password = "toto";

        UtilisateurDAO udao = new UtilisateurDAO();
        Utilisateur u = new Utilisateur();
        u.setLogin(login);
        u.setPassword(password);
        assertTrue(udao.isUserExist(u));
    }

    @Test
    public void testLoginKO() throws SQLException {
        String login = "toto1";
        String password = "toto";

        UtilisateurDAO udao = new UtilisateurDAO();
        Utilisateur u = new Utilisateur();
        u.setLogin(login);
        u.setPassword(password);
        assertFalse(udao.isUserExist(u));
    }

    @Test
    public void testInsertLogin() throws SQLException {
        String login = "usertest";
        String password = "usertest";

        UtilisateurDAO udao = new UtilisateurDAO();
        Utilisateur u = new Utilisateur();
        u.setLogin(login);
        u.setPassword(password);
        boolean res1 = udao.insert(u);
        boolean res2 = udao.isUserExist(u);
        boolean res3 = udao.deleteByLogin(u) > 0;      
        assertTrue(res1 && res2 && res3);

    }

}
