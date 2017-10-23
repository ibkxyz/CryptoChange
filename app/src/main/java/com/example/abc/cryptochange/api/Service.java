package com.example.abc.cryptochange.api;

import com.example.abc.cryptochange.model.ItemResponse;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by abc on 16/09/2017.
 */

public interface Service {

    @GET("price?fsym=BTC&tsyms=NGR,EGP,KES,KWD,USD,AUD,IQD,CAD,EUR,ARS,MCO,ZAR,BSD,AED,GHS,NZD,JPY,INR,HKD,BRL&extraParams=Cryptochange")
    Call<ItemResponse> getItems();
}
