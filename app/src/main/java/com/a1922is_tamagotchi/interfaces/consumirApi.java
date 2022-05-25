package com.a1922is_tamagotchi.interfaces;

import com.a1922is_tamagotchi.model.mascota;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface consumirApi {
    @GET("users/{id}")
    public Call<mascota> find(@Path("id")String id);
}
