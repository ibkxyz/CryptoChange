package com.example.abc.cryptochange;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.abc.cryptochange.model.Item;

import java.util.ArrayList;

/**
 * Created by abc on 23/10/2017.
 */

public class CurrencyAdapter extends ArrayAdapter<Item> {


    // Store a member variable for the currency
    ArrayList <Item> itemss;

    private Activity it;

    // Pass in the contact array into the constructor
    public CurrencyAdapter(Activity it, int res, ArrayList<Item> itemss) {
        super(it,res,itemss);
        this.itemss = itemss;
        this.it = it;
    }


    @Override
    public View getView(int position, View view, ViewGroup parent){
        return super.getView(position, view, parent);
    }

    @Override
    public View getDropDownView(int position, View view, ViewGroup parent) {
        View v = view;
        if (v == null) {
            LayoutInflater inflater = it.getLayoutInflater();
            v = inflater.inflate(android.R.layout.simple_spinner_dropdown_item,parent,false);
        }

        Item item = itemss.get(position);
        if (item != null) {
            TextView txtValue = (TextView) v.findViewById(R.id.textValue);
            if (txtValue != null) {
                txtValue.setText(item.getTsyms());
            }
        }
        return v;
    }
}
