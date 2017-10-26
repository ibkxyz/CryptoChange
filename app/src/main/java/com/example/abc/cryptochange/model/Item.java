package com.example.abc.cryptochange.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by abc on 16/09/2017.
 */

public class Item {

    @SerializedName("curCode")
    @Expose
    private String curCode;

    @SerializedName("tSyms")
    @Expose
    private String tSyms;


    public Item(String curCode, String tSyms){
        this.curCode = curCode;
        this.tSyms= tSyms;
    }

    public String getCurCode(){
        return curCode;
    }
    public void setCurCode(){
        this.curCode = curCode;
    }


    public String getTsyms(){
        return tSyms;
    }

    public void settSyms(String tSyms){
        this.tSyms = tSyms;
    }

}
