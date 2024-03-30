package com.thepigrat.felixclicker;

import com.thepigrat.felixclicker.upgrades.AnnoyingMateUpgrade;
import com.thepigrat.felixclicker.upgrades.FatLunaUpgrade;
import com.thepigrat.felixclicker.upgrades.Upgrade;
import producers.Producer;
import producers.Whip;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Game {

    public int currency = 0;
    MainController controller;
    Set<Upgrade> activeupgrades = new HashSet<>();
    ArrayList<Producer> activeproducers = new ArrayList<>();


    public Game(MainController controller) {
        activeupgrades.add(new AnnoyingMateUpgrade());
        activeupgrades.add(new FatLunaUpgrade());
        activeproducers.add(new Whip());
        this.controller= controller;
    }

    public void generate() {
        while (true) {
            var totfactor = 1;
            for (var producer : activeproducers) {
                totfactor = totfactor * producer.getfactor();
            }
            if (totfactor != 0) {
                currency = currency + totfactor;
                controller.currency.setText(String.valueOf(currency));


            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void increaseCurrency() {
        var totfactor = 1;
        for (var upgrade : activeupgrades) {
            totfactor = totfactor * upgrade.getfactor();
        }

        if (totfactor == 0) {
            currency++;
        } else {
            currency = currency + totfactor;
        }
    }
}













