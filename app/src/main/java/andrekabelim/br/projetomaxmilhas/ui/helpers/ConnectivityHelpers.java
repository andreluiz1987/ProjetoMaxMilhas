package andrekabelim.br.projetomaxmilhas.ui.helpers;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class ConnectivityHelpers {

    public static boolean hasConnection(Context context){

        boolean hasConnection = false;
        try
        {
            ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo netInfo = cm.getActiveNetworkInfo();

            hasConnection = (netInfo != null && netInfo.isConnected());
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }

        return hasConnection;
    }
}
