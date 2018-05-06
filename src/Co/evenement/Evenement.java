package Co.evenement;

import base.ToTable;

/**
 * Objet Evenement.
 * 
 * @author m-besnard
 */

public class Evenement implements ToTable {

    private Integer idevenement;
    private String libelle;
    private String description;
    private String organisateur;
    private String typeevenement;
    private Integer nbreparticipantmax;
    private String datedebut;
    private String datefin;
    private String theme;
    private Integer idsalle;

    /*constructeur vide essentiel*/
    public Evenement() {
    }
    
    /**
     * constructeur.
     * @param idevenement
     * @param libelle
     * @param description
     * @param organisateur
     * @param typeevenement
     * @param nbreparticipantmax
     * @param datedebut
     * @param datefin
     * @param theme
     * @param idsalle
    */
    public Evenement(Integer idevenement, String libelle, String description, String organisateur, String typeevenement, Integer nbreparticipantmax, String datedebut, String datefin, String theme, Integer idsalle) {
        this.idevenement = idevenement;
        this.libelle = libelle;
        this.description = description;
        this.organisateur = organisateur;
        this.typeevenement = typeevenement;
        this.nbreparticipantmax = nbreparticipantmax;
        this.datedebut = datedebut;
        this.datefin = datefin;
        this.theme = theme;
        this.idsalle = idsalle;
    }

    /**
     * getters.
    */
    public Integer getIdevenement() {
        return idevenement;
    }

    public String getLibelle() {
        return libelle;
    }

    public String getDescription() {
        return description;
    }

    public String getOrganisateur() {
        return organisateur;
    }

    public String getTypeevenement() {
        return typeevenement;
    }

    public Integer getNbreparticipantsmax() {
        return nbreparticipantmax;
    }

    public String getDatedebut() {
        return datedebut;
    }

    public String getDatefin() {
        return datefin;
    }

    public String getTheme() {
        return theme;
    }

    public Integer getIdsalle() {
        return idsalle;
    }
    
    /**
     * setters.
     */
    public void setIdevenement(Integer idevenement) {
        this.idevenement = idevenement;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setOrganisateur(String organisateur) {
        this.organisateur = organisateur;
    }

    public void setTypeevenement(String typeevenement) {
        this.typeevenement = typeevenement;
    }

    public void setNbreparticipantmax(Integer nbreparticipantmax) {
        this.nbreparticipantmax = nbreparticipantmax;
    }

    public void setDatedebut(String datedebut) {
        this.datedebut = datedebut;
    }

    public void setDatefin(String datefin) {
        this.datefin = datefin;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public void setIdsalle(Integer idsalle) {
        this.idsalle = idsalle;
    }

    /**
    * convertir l'objet en tableau d'objet pour la JTable (évènement).
    *
    * @return tab
    */    
    @Override
    public Object[] convertForTable() {
        Object[] tab = new Object[10];
        tab[0] = idevenement;
        tab[1] = libelle;
        tab[2] = description;
        tab[3] = organisateur;
        tab[4] = typeevenement;
        tab[5] = nbreparticipantmax;
        tab[6] = datedebut;
        tab[7] = datefin;
        tab[8] = theme;
        tab[9] = idsalle;
        return tab;
    }

    /**
     * nom des colonnes pour JTable.
     * @return tab
     */   
    @Override
    public String[] getColumsName() {
        String[] tab = new String[10];
        tab[0] = "idevenement";
        tab[1] = "libelle";
        tab[2] = "description";
        tab[3] = "organisateur";
        tab[4] = "typeevenement";
        tab[5] = "nbreparticipantmax";
        tab[6] = "datedebut";
        tab[7] = "datefin";
        tab[8] = "theme";
        tab[9] = "idsalle";
        return tab;
    }

    /**
     * Methode Auto-incrémente pour l'id.
     * 
     * @return idevenement
     */
    @Override
    public String getIdAutoIncrementName() {
        return "idevenement";
    }

}
