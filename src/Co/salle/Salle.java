package Co.salle;

import base.ToTable;

/**
 * Objetc Salle.
 * @author m-besnard
 */
public class Salle implements ToTable {

    private Integer idsalle;
    private String nomsalle;
    private String description;
    private Integer capacite;

    
    /**
     * constructeur vide.
     * */
    public Salle() {
    }

    /**
    * convertir l'objet en tableau d'objet pour la JTable (salle).
    *
    * @return tab
    */
    @Override
    public Object[] convertForTable() {
        Object[] tab = new Object[4];
        tab[0] = idsalle;
        tab[1] = nomsalle;
        tab[2] = description;
        tab[3] = capacite;
        return tab;
    }

    /**
     * nom des colonnes pour JTable.
     * @return tab
     */ 
    @Override
    public String[] getColumsName() {
        String[] tab = new String[4];
        tab[0] = "idsalle";
        tab[1] = "nomsalle";
        tab[2] = "description";
        tab[3] = "capacite";
        return tab;
    }

    /**
     * getters.
     */
    public Integer getIdsalle() {
        return idsalle;
    }

    public String getNomsalle() {
        return nomsalle;
    }

    public String getDescription() {
        return description;
    }

    public Integer getCapacite() {
        return capacite;
    }

    /**
     * setters.
    */
    public void setIdsalle(Integer idsalle) {
        this.idsalle = idsalle;
    }

    public void setNomsalle(String nomsalle) {
        this.nomsalle = nomsalle;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCapacite(Integer capacite) {
        this.capacite = capacite;
    }

   /**
    * méthode toString pour affiche tout dans le bouton.
    */
    @Override
    public String toString() {
        return idsalle + " - " + nomsalle;
    }
    
    /**
     * Methode Auto-incrémente pour l'id.
     * 
     * @return idsalle
     */
    @Override
    public String getIdAutoIncrementName() {
        return "idsalle";
    }

}
