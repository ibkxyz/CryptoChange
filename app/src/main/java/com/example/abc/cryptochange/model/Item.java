package com.example.abc.cryptochange.model;

/**
 * Created by abc on 16/09/2017.
 */

public class Item {

    private String curCode;
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
