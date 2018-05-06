package Co;

import Co.utils.NumberUtils;
import base.ToTable;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 * Pour tout DAO crée il faut extends cette Classe. 
 *
 * @author MaureenD
 */
public abstract class AbstractDAO {

    protected abstract String getObjectName();

    /**
     * Permet d'inserer dans la base de donnees un object qui implemente ToTable.
     * @param totable un objet implementant totable
     * @return true si ca c'est bien inséré
     * @throws SQLException 
     */
    protected boolean insertSingle(ToTable totable) throws SQLException {
        //detourne req col:avant VALUES,  values vient après VALUES
        String[] cols = totable.getColumsName();
        Object[] values = totable.convertForTable();
        //evite + - dans boucle 
        StringBuilder sbCols = new StringBuilder();
        StringBuilder sbValues = new StringBuilder();
        for (int i = 0; i < cols.length; i++) {

            if (cols[i].equals(totable.getIdAutoIncrementName())) {
                continue;
            }

            //permet d'écrire la req
            sbCols.append(cols[i]);
            sbCols.append(",");

            if (values[i] != null && NumberUtils.isNumeric(values[i].toString())) {
                /*si chiffre alors c'est int, sinon string avec "" */
                sbValues.append(values[i]);
            } else if (values[i] == null) {
                sbValues.append("null");
                /*pas de valeur*/
            } else {
                sbValues.append("'");
                sbValues.append(values[i]);
                sbValues.append("'");
            }
            sbValues.append(',');
        }
        /*enlève la dernière virgule de la req*/
        sbCols = sbCols.delete(sbCols.length() - 1, sbCols.length());
        sbValues = sbValues.delete(sbValues.length() - 1, sbValues.length());

        String sql = "INSERT INTO " + getObjectName() + " (" + sbCols.toString() + ") VALUES (" + sbValues.toString() + ")";  //insert
        Statement statement = ConnectionFactory.getConnection().createStatement();
        int res = statement.executeUpdate(sql);
        statement.close();
        return res > 0;
    }

    
     /**
      * INSERT INTO table VALUES ('valeur 1', 'valeur 2', ...).
      * @param lp
      * @return
      * @throws SQLException 
      */
    protected int insertList(List<? extends ToTable> lp) throws SQLException { //? > n'importe quelle classe abstraite
        Statement statement = ConnectionFactory.getConnection().createStatement();
        for (ToTable toTable : lp) {
            String[] cols = toTable.getColumsName();
            Object[] values = toTable.convertForTable();

            StringBuilder sbCols = new StringBuilder();
            StringBuilder sbValues = new StringBuilder();
            for (int i = 0; i < cols.length; i++) { //dans table
                if (cols[i].equals(toTable.getIdAutoIncrementName())) {
                    continue;
                }
                sbCols.append(cols[i]);
                sbCols.append(",");

                if (values[i] != null && NumberUtils.isNumeric(values[i].toString())) { //valeur
                    sbValues.append(values[i]);
                } else if (values[i] == null) {
                    sbValues.append("null");
                } else {
                    sbValues.append("'");
                    sbValues.append(values[i]);
                    sbValues.append("'");
                }
                sbValues.append(',');

            }
            sbCols = sbCols.delete(sbCols.length() - 1, sbCols.length());
            sbValues = sbValues.delete(sbValues.length() - 1, sbValues.length());

            String sql = "INSERT INTO " + getObjectName() + " (" + sbCols.toString() + ") VALUES (" + sbValues.toString() + ")";
            statement.addBatch(sql); //tableau entier, remplir liste de req en 1 seul fois
        }

        int res[] = statement.executeBatch();
        statement.close();
        int total = 0;
        for (int r : res) {
            total += r;
        }
        return total;

    }

    /**
     * UPDATE table SET nom_colonne_1 = 'nouvelle valeur' WHERE condition.
     * @param tt valeur des lignes
     * @param where la condition
     * @return true si c'est bien à jour
     * @throws java.sql.SQLException
     */
    protected int updateSingle(ToTable tt, String where) throws SQLException {

        String[] cols = tt.getColumsName();
        Object[] values = tt.convertForTable();

        StringBuilder sbUpdate = new StringBuilder();
        for (int i = 0; i < cols.length; i++) { //dans table
            if (cols[i].equals(tt.getIdAutoIncrementName())) {
                continue;
            }
            sbUpdate.append(cols[i]);
            sbUpdate.append("=");

            if (values[i] != null && NumberUtils.isNumeric(values[i].toString())) { //valeur
                sbUpdate.append(values[i]);
            } else if (values[i] == null) {
                sbUpdate.append("null");
            } else {
                sbUpdate.append("'");
                sbUpdate.append(values[i]);
                sbUpdate.append("'");
            }
            sbUpdate.append(',');

        }
        sbUpdate = sbUpdate.delete(sbUpdate.length() - 1, sbUpdate.length());

        String sql = "UPDATE " + getObjectName() + " SET " + sbUpdate.toString() + " WHERE " + where;
        Statement statement = ConnectionFactory.getConnection().createStatement();
        int res = statement.executeUpdate(sql);
        statement.close();
        return res;
    }

    /**
     * DELETE FROM `table` WHERE condition.
     * @param totable
     * @param where la condition
     * @return true si c'est supprimé
     * @throws java.sql.SQLException
     **/
    protected int deleteObject(ToTable totable, String where) throws SQLException {
        String sql = "DELETE FROM " + getObjectName() + " WHERE " + where;
        Statement statement = ConnectionFactory.getConnection().createStatement();
        int res = statement.executeUpdate(sql);
        statement.close();
        return res;
    }

}
