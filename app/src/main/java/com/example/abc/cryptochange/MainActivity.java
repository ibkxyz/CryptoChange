package com.example.abc.cryptochange;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
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
}
