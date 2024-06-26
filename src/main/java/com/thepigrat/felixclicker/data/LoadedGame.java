package com.thepigrat.felixclicker.data;

import com.thepigrat.felixclicker.Game;

import java.util.List;

public class LoadedGame {
    private final List<String> rawData;
    private long currency;

    public LoadedGame() {
        this.rawData = DataManager.load();
    }

    public void parse() {
        for (int i = 0; i < rawData.size(); i++) {
            String word = rawData.get(i);
            System.out.println(word);
            if (word.equals(Game.MONEY_KEY))
                this.currency = Long.parseLong(rawData.get(i+1));
        }
    }

    public boolean isLoaded() {
        return this.rawData != null;
    }

    public long getCurrency() {
        return currency;
    }
}
