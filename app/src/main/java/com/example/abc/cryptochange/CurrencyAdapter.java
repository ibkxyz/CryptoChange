package com.example.abc.cryptochange;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.abc.cryptochange.model.Item;

import java.util.List;

/**
 * Created by abc on 23/10/2017.
 */

public class CurrencyAdapter extends ArrayAdapter<Item> {


    // Store a member variable for the currency
    private List<Item> items;
    private int it;

    // Pass in the contact array into the constructor
    public CurrencyAdapter(Context applicationContext, int it, List<Item> items) {
        super(applicationContext,it,items);
        this.items = items;
        this.it = it;
    }

    @Override
    public View getDropDownView(int position, View v, ViewGroup parent) {
        if (v == null) {
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inflater.inflate(it,parent,false);
        }
        Item item = items.get(position);
        if (item != null) {
            TextView txtValue = (TextView) v.findViewById(R.id.textValue);
            if (txtValue != null) {
                txtValue.setText(item.getTsyms());
            }
        }
        return v;
    }
}
