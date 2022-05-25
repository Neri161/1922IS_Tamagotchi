package com.a1922is_tamagotchi;
import com.a1922is_tamagotchi.interfaces.consumirApi;
import com.a1922is_tamagotchi.model.mascota;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class consumoApi {
    public static String URL = "https://jsonplaceholder.typicode.com/";
    public static Retrofit varRetro;

    public void buscar(String codigo) {
        if (varRetro == null) {
            varRetro = new Retrofit.Builder().baseUrl(URL)
                    .addConverterFactory(GsonConverterFactory.create()).build();
            consumirApi consApi = varRetro.create(consumirApi.class);


            Call<mascota> call = consApi.find(codigo);
            call.enqueue(new Callback<mascota>() {
                @Override
                public void onResponse(Call<mascota> call, Response<mascota> response) {
                    try {
                        if (response.isSuccessful()) {
                            mascota m = response.body();
                            System.out.println(call);
                            System.out.println(m.getName());
                            System.out.println(m.getId());

                        }
                    } catch (Exception ex) {
                        System.out.println("UWUn't " + ex);
                    }
                }

                @Override
                public void onFailure(Call<mascota> call, Throwable t) {

                }
            });
        }
    }
}
