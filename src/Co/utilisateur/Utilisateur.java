package Co.utilisateur;

import base.ToTable;

/**
 * Objet Utilisateur.
 *
 * @author m-besnard
 */
public class Utilisateur implements ToTable {

    private Integer id;
    private String login;
    private String password;

    /**
     * constructeur vide
     **/
    public Utilisateur() {
    }

    /**
     *  constructeur
     * @param id
     * @param login
     * @param pwd
     **/
    public Utilisateur(Integer id, String login, String pwd) {
        this.id = id;
        this.login = login;
        this.password = pwd;
    }

    /**
     * getters.
     */
    public Integer getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public String getLogin() {
        return login;
    }
    
    /**
     * setters.
     */
    public void setId(Integer id) {
        this.id = id;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * nom des colonnes pour JTable.
     * @return tab
     */  
    @Override
    public String[] getColumsName() {
        String[] tab = new String[3];
        tab[0] = "id";
        tab[1] = "login";
        tab[2] = "password";
        return tab;
    }

    /**
    * convertir l'objet en tableau d'objet pour la JTable (utilisateur).
    *
    * @return tab
    */  
    @Override
    public Object[] convertForTable() {
        Object[] tab = new Object[3];
        tab[0] = getId();
        tab[1] = getLogin();
        tab[2] = getPassword();
        return tab;
    }
    
    /**
     * Methode Auto-incrémente pour l'id.
     * 
     * @return id
     */
    @Override
    public String getIdAutoIncrementName() {
        return "id";
    }

}
