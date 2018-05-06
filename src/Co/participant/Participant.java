package Co.participant;

import base.ToTable;
import java.util.Objects;

/**
 * Objet Participant.
 *
 * @author m-besnard
 */
public class Participant implements ToTable {

    private Integer idparticipant;
    private String nom;
    private String prenom;
    private Integer datenaissance;
    private String adresse;
    private String ville;
    private Integer codepostal;
    private Integer numerotel;
    private String adressemail;
    private String entreprise;

    /**
     * constructeur vide.
     * */
    public Participant() {
    }

    /**
    * convertir l'objet en tableau d'objet pour la JTable (participant). 
    *
    * @return tab
    */  
    @Override
    public Object[] convertForTable() {
        Object[] tab = new Object[11];
        tab[0] = getIdparticipant();
        tab[1] = getNom();
        tab[2] = getPrenom();
        tab[3] = getDatenaissance();
        tab[4] = getAdresse();
        tab[5] = getVille();
        tab[6] = getCodepostal();
        tab[7] = getNumerotel();
        tab[8] = getAdressemail();
        tab[10] = getEntreprise();
        return tab;
    }

    /**
     * nom des colonnes pour JTable.
     * @return tab
     */  
    @Override
    public String[] getColumsName() {
        String[] tab = new String[10];
        tab[0] = "idparticipant";
        tab[1] = "nom";
        tab[2] = "prenom";
        tab[3] = "datenaissance";
        tab[4] = "adresse";
        tab[5] = "ville";
        tab[6] = "codepostal";
        tab[7] = "numerotel";
        tab[8] = "adressemail";
        tab[9] = "entreprise";
        return tab;
    }

    /**
     * getters.
     * */
    public Integer getIdparticipant() {
        return idparticipant;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public Integer getDatenaissance() {
        return datenaissance;
    }

    public String getAdresse() {
        return adresse;
    }

    public String getVille() {
        return ville;
    }

    public Integer getCodepostal() {
        return codepostal;
    }

    public Integer getNumerotel() {
        return numerotel;
    }

    public String getAdressemail() {
        return adressemail;
    }

    public String getEntreprise() {
        return entreprise;
    }

    /**
    *setters.
    **/
    public void setIdparticipant(Integer idparticipant) {
        this.idparticipant = idparticipant;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setDatenaissance(Integer datenaissance) {
        this.datenaissance = datenaissance;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public void setCodepostal(Integer codepostal) {
        this.codepostal = codepostal;
    }

    public void setNumerotel(Integer numerotel) {
        this.numerotel = numerotel;
    }

    public void setAdressemail(String adressemail) {
        this.adressemail = adressemail;
    }

    public void setEntreprise(String entreprise) {
        this.entreprise = entreprise;
    }

    @Override
    public String getIdAutoIncrementName() {
        return "idparticipant";
    }

    /**
     * Comparer la valeur de deux instances.
     * @param o objet
     * @return id du participant
     */
    @Override
    public boolean equals(Object o) {   //pour containsKey, l'id du participant
        if (o == null) {
            return false;
        }
        if (!(o instanceof Participant)) {
            return false;
        }
        Participant p = (Participant) o;
        return (Objects.equals(p.idparticipant, this.idparticipant));
    }

}
