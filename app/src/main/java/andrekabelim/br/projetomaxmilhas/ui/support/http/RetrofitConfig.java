package andrekabelim.br.projetomaxmilhas.ui.support.http;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitConfig {

    private static String BASE_URL = "https://developer.goibibo.com";

    private static Retrofit retrofit = null;

    public static Retrofit getRetrofit() {

        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit;
    }
}
