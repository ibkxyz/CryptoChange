package com.example.abc.cryptochange;

import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by abc on 23/10/2017.
 */

public class CurrencyAdapter {

    static final String BASE_URL = "https://min-api.cryptocompare.com/data/";
    static final String PRICE_URL = "price?fsym=BTC&tsyms=NGR,EGP,KES,KWD,USD,AUD,IQD,CAD,EUR,ARS,MCO,ZAR,BSD,AED,GHS,NZD,JPY,INR,HKD,BRL&extraParams=Cryptochange";


    public static JSONObject getJSON(String ur) {

        String response;
        JSONObject jsonArray = null;


        try {
            URL url = new URL(BASE_URL + PRICE_URL);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
                StringBuilder stringBuilder = new StringBuilder();
                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    stringBuilder.append(line).append("\n");
                }
                bufferedReader.close();
                response = stringBuilder.toString();
            } finally {
                urlConnection.disconnect();
            }
        } catch (Exception e) {
            Log.e("ERROR", e.getMessage(), e);
            return null;
        }

        try {
            jsonArray = new JSONObject(response);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jsonArray;
    }


}
