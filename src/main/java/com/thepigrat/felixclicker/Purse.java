package com.thepigrat.felixclicker;

public class Purse {
    private int currency=0;

    public void setCurrency(int currency) {
        this.currency = currency;
    }

    public int getCurrency() {
        return currency;
    }
    public void increaseCurrencyBy1(){
        setCurrency(currency+1);
    }
}

