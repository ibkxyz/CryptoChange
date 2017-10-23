package com.example.abc.cryptochange.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by abc on 16/09/2017.
 */

public class Client {

    public static final String BASE_URL = "https://min-api.cryptocompare.com/data/";
    public static Retrofit retrofit = null;

    public static Retrofit getClient(){

        if (retrofit == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
