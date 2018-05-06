package base;

/**
 * Récupère les données pour les convertir en tableau.
 *  @author m-besnard
 */
public interface ToTable {
 
    public Object[] convertForTable();
    public String[] getColumsName();
    public String getIdAutoIncrementName();
}
