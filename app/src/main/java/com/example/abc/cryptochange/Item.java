package com.example.abc.cryptochange;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by abc on 16/09/2017.
 */

public class Item {

    @SerializedName("curCode")
    @Expose
    private String curCode;

    @SerializedName("tsyms")
    @Expose
    private String tsyms;

//
//    public Item(String curCode, String tSyms){
//        this.curCode = curCode;
//        this.tSyms= tSyms;
//    }

    public String getCurCode(){
        return curCode;
    }
    public void setCurCode(String curCode){
        this.curCode = curCode;
    }


    public String getTsyms(){
        return tsyms;
    }

    public void setTsyms(String tsyms){
        this.tsyms = tsyms;
    }

}
