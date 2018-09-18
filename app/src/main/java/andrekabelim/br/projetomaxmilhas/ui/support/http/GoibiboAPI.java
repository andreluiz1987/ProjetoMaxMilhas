package andrekabelim.br.projetomaxmilhas.ui.support.http;

import java.util.Map;

import andrekabelim.br.projetomaxmilhas.ui.models.ResponseData;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

public interface GoibiboAPI {
    //@GET("/api/search/?app_id=ae7faa94&app_key=9668f2d698ebbce03d4ba3a0b8ad8ce5&format=json&source=CNF&destination=VIX&dateofdeparture=20180920&dateofarrival=20181019&seatingclass=E&adults=1&children=0&infants=0&counter=0")
    @GET("/api/search/")
    Call<ResponseData> getFlights(@QueryMap Map<String, String> filters);
}
