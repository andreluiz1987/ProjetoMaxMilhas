package andrekabelim.br.projetomaxmilhas.ui.helpers;

public class NumberHelpers {

    public static String formatToCurrentLocate(int value) {
        StringBuilder builder = new StringBuilder(String.valueOf(value));
        int x = 2;
        builder.insert(builder.length() - x, ".");
        return builder.toString();
    }
}
