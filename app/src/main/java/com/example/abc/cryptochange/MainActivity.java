package com.example.abc.cryptochange;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Spinner allcurrency;
    TextView value;
    JSONObject jsonObject;
    JSONArray jsonArray;

    ArrayList<String> items = new ArrayList<String>();
    ArrayList<Item> itemm = new ArrayList<Item>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        allcurrency = (Spinner) findViewById(R.id.currencySpinner);

//        value = (TextView) findViewById(R.id.textValue);
        new cryptoConv().execute();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //Add Menu Item
        getMenuInflater().inflate(R.menu.menu_cryptochange, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // User clicked on a menu option in the app bar overflow menu
        switch (item.getItemId()) {
            // Respond to a click on the "Insert dummy data" menu option
            case R.id.action_refresh:
                // Do nothing for now
                return true;
            // Respond to a click on the "Delete all entries" menu option
            case R.id.action_about:
                // Do nothing for now
                return true;
        }
        return super.onOptionsItemSelected(item);
    }


    private class cryptoConv extends AsyncTask<Void, Void, Void> {


        @Override
        protected Void doInBackground(Void... params) {

            jsonObject = CurrencyAdapter.getJSON(CurrencyAdapter.BASE_URL + CurrencyAdapter.PRICE_URL);
            try {
                jsonArray = jsonObject.getJSONArray("tsyms");
                for (int i = 0; i < jsonArray.length(); i++) {
                    jsonObject = jsonArray.getJSONObject(i);

                    Item it = new Item();

                  //  it.setCurCode(jsonObject.optString("curCode"));
                    it.setTsyms(jsonObject.optString("tsyms"));
                    itemm.add(it);


                    items.add(jsonObject.optString("tsyms"));
                }

            } catch (JSONException e) {
                Log.e("Error", e.getMessage());
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPostExecute(Void args) {


            allcurrency.setAdapter(new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_spinner_dropdown_item, items));

        }

    }

}