package andrekabelim.br.projetomaxmilhas.ui.helpers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateHelpers {

    public static String formatDateToText(String date) {

        String strDate = "";

        try {

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd", java.util.Locale.getDefault());
            Date myDate = sdf.parse(date);

            sdf.applyPattern("EEE, d MMM yyyy");
            sdf.format(myDate);

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return strDate;
    }
}
