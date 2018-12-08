package shyam.ram.advance.api;

import android.app.ProgressDialog;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AppConfig {
    private static boolean result;
    public static String serverIP = "http://49.50.70.41/CerrebroServiceV32/";
    private static String BASE_URL = serverIP;
    private static ProgressDialog progressDialog;
    public static Retrofit getRetrofit() {
        return new Retrofit.Builder()
                .baseUrl(AppConfig.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
}
