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

    public Purse purse = new Purse();
    MainController controller;
    Set<Upgrade> activeupgrades = new HashSet<>();
    ArrayList<Producer> activeproducers = new ArrayList<>();


    public Game(MainController controller) {
        activeupgrades.add(new AnnoyingMateUpgrade());
        activeupgrades.add(new FatLunaUpgrade());
        activeproducers.add(new Whip());
        this.controller = controller;
    }

    public void generate() {
        var totfactor = 1;
        for (var producer : activeproducers) {
            totfactor = totfactor * producer.getfactor();
        }
        if (totfactor != 0) {
            purse.setCurrency(purse.getCurrency() + totfactor);
            controller.currency.setText(String.valueOf(purse.getCurrency()));
        }
    }

    public void increaseCurrency() {
        var totfactor = 1;
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
        toSave.append(MONEY_KEY+" ").append(money);
        var x = DataManager.of(toSave.toString()).encode().save().data;
        System.out.println("saved: "+money);
    }
}