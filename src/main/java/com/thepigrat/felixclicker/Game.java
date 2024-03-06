package com.thepigrat.felixclicker;

import com.thepigrat.felixclicker.upgrades.AnnoyingMateUpgrade;
import com.thepigrat.felixclicker.upgrades.FatLunaUpgrade;
import com.thepigrat.felixclicker.upgrades.Upgrade;

import java.util.ArrayList;
import java.util.List;

public class Game {

    public int currency = 0;
    List<Upgrade> activeupgrades = new ArrayList<>();


    public Game() {
        activeupgrades.add(new AnnoyingMateUpgrade());
        activeupgrades.add(new FatLunaUpgrade());
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













