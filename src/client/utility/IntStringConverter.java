package client.utility;

import javafx.util.StringConverter;

/**
 * A class that coverts integer to string and otherwise.
 */
public class IntStringConverter extends StringConverter<Number> {
    /**
     * Converting integer to string.
     * @param number integer.
     * @return integer as string.
     */
    @Override
    public String toString(Number number) {
        return number == null || number.intValue() == 0 ? "" : number.toString();
    }

    /**
     * Converting string to integer.
     * @param s string.
     * @return string as integer.
     */
    @Override
    public Number fromString(String s) {
        try {
            return Integer.parseInt(s);
        } catch (Exception e) {
            return 0;
        }
    }
}