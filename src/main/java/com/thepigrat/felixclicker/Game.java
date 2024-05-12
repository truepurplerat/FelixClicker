package com.thepigrat.felixclicker;

import com.thepigrat.felixclicker.data.DataManager;
import com.thepigrat.felixclicker.upgrades.AnnoyingMateUpgrade;
import com.thepigrat.felixclicker.upgrades.FatLunaUpgrade;
import com.thepigrat.felixclicker.upgrades.Upgrade;
import com.thepigrat.felixclicker.producers.Producer;
import com.thepigrat.felixclicker.producers.Whip;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Game {
    public static final String MONEY_KEY = "$money";

    public Purse purse;
    MainController controller;
    //Set speichert immer nur einen Wert
    HashSet<Upgrade> activeupgrades;
    //Arraylist kann von jedem unendlich viel speichern
    ArrayList<Producer> activeproducers;


    public Game(MainController controller) {
        purse = new Purse();
        activeupgrades = new HashSet<>();
        activeproducers = new ArrayList<>();

       // activeupgrades.add(new AnnoyingMateUpgrade());
      //  activeupgrades.add(new FatLunaUpgrade());
       // activeproducers.add(new Whip());
        this.controller = controller;
    }

    public void generate() {
        var totfactor = 1;
        System.out.println(activeproducers);
        for (var producer : activeproducers) {
            totfactor = totfactor * producer.getfactor();
        }
        if (totfactor != 1) {
            purse.setCurrency(purse.getCurrency() + totfactor);
            updatecurrency();
        }
    }
    public void updatecurrency(){
        controller.currency.setText(String.valueOf(purse.getCurrency()));
    }

    public void increaseCurrency() {
        long totfactor = 1;
        for (var upgrade : activeupgrades) {
            totfactor = totfactor * upgrade.getfactor();
        }

        if (totfactor == 0) {
            purse.increaseCurrencyBy1();
        } else {
            purse.setCurrency(purse.getCurrency() + totfactor);
        }
    }

    public void save() {
        var toSave = new StringBuilder();
        var money = String.valueOf(this.purse.getCurrency());
        toSave.append(MONEY_KEY + " ").append(money);
        var x = DataManager.of(toSave.toString()).encode().save().data;
        System.out.println("saved: " + money);
    }

    public void buyupgrade(Upgrade upgrade) {
        var price= upgrade.getprice();
        var money= purse.getCurrency();
        if (money>=price){
            purse.setCurrency(money-price);
            activeupgrades.add(upgrade);
        }
    }
}
