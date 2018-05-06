package Inscrire;

import base.ToTable;

/**
 * Objet Inscrire.
 * @author m-besnard
 */
public class Inscrire implements ToTable {
      
    private Integer idparticipant;
    private Integer idevenement;
    private Boolean hebergement;
    private Boolean restauration;
    

    /**
     * constructeur vide essentiel.
     **/
    public Inscrire() {
    }

    /**
    * Getters.
    **/
    public Integer getIdparticipant() {
        return idparticipant;
    }

    public Integer getIdevenement() {
        return idevenement;
    }

    public Boolean getHebergement() {
        return hebergement;
    }

    public Boolean getRestauration() {
        return restauration;
    }
    
    /**
    * Setters.
    **/

    public void setIdparticipant(Integer idparticipant) {
        this.idparticipant = idparticipant;
    }

    public void setIdevenement(Integer idevenement) {
        this.idevenement = idevenement;
    }

    public void setHebergement(Boolean hebergement) {
        this.hebergement = hebergement;
    }

    public void setRestauration(Boolean restauration) {
        this.restauration = restauration;
    }
        
    /**
    * convertir l'objet en tableau d'objet pour la JTable (évènement).
    * @return tab
    */ 
    @Override
    public Object[] convertForTable() {
        Object[] tab = new Object[4];
        tab[0] = idparticipant;
        tab[1] = idevenement;
        tab[2] = hebergement;
        tab[3] = restauration;
        return tab;
    }

    /**
     * nom des colonnes pour JTable.
     * @return tab
     */     
    @Override
    public String[] getColumsName() {
        String[] tab = new String[4];
        tab[0] = "idparticipant";
        tab[1] = "idevenement";
        tab[2] = "hebergement";
        tab[3] = "restauration";
        return tab;
    }
    
    /**
     * Methode Auto-incrémente pour l'id.
     * 
     * @return 
     */
    @Override
    public String getIdAutoIncrementName() {        
        return "";
    }

}
