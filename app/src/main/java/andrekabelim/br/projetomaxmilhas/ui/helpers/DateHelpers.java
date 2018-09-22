package andrekabelim.br.projetomaxmilhas.ui.helpers;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateHelpers {

    public static String formatDateToText(String date) {

        String strDate = "";

        try {

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd't'HHmm", java.util.Locale.getDefault());
            Date myDate = sdf.parse(date);

            sdf.applyPattern("EEE, d MMM yyyy");
            strDate = sdf.format(myDate);

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return strDate;
    }

    public static String formatDateToGiobibo(String date) {
        String[] arrDate = date.split("-");
        return arrDate[2] + arrDate[1] +arrDate[0];
    }
}
