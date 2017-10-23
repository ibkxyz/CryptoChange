package com.example.abc.cryptochange;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.abc.cryptochange.api.Client;
import com.example.abc.cryptochange.api.Service;
import com.example.abc.cryptochange.model.Item;
import com.example.abc.cryptochange.model.ItemResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    Spinner allcurrency;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loadJSON();
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


    private void loadJSON() {

        try {

            Client Client = new Client();
            Service apiService =

                    Client.getClient().create(Service.class);

            Call<ItemResponse> call = apiService.getItems();
            call.enqueue(new Callback<ItemResponse>() {

                @Override
                public void onResponse(Call<ItemResponse> call, Response<ItemResponse> response) {
                    List<Item> items = response.body().getItems();

                    // Populate items to the spinner
                    allcurrency = (Spinner) findViewById(R.id.currencySpinner);
                    ArrayAdapter<String> adapter = ArrayAdapter.createFromResource(this, android.R.layout.simple_spinner_item, items);
                    allcurrency.setAdapter(adapter);
                }


                @Override
                public void onFailure(Call<ItemResponse> call, Throwable t) {
                    Log.d("Error", t.getMessage());
                    Toast.makeText(getApplicationContext(), "Currency Load Failed", Toast.LENGTH_SHORT).show();
                }

            });
        } catch (Exception e) {
            Log.d("Error", e.getMessage());
            Toast.makeText(getApplicationContext(), e.toString(), Toast.LENGTH_SHORT).show();
        }

    }
}