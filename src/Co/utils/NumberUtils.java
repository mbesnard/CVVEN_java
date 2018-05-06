package Co.utils;

/**
 * Si c'est un Int alors c'est bon, sinon c'est faux (= String).
 * @author mm-besnard
 */
public class NumberUtils {

    public static boolean isNumeric(String str) {
        try {
            double d = Integer.parseInt(str);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

}
