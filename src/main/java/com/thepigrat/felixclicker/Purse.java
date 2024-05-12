package com.thepigrat.felixclicker;

public class Purse {
    private long currency;
//Konstuktor
    public Purse(){
       currency=0;
    }
    public void setCurrency(long currency) {
        this.currency = currency;
    }

    public long getCurrency() {
        return currency;
    }
    public void increaseCurrencyBy1(){
        setCurrency(currency+1);
    }
}

