package com.thepigrat.felixclicker;

import com.thepigrat.felixclicker.upgrades.FatLunaUpgrade;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class MainController {
    @FXML
    public Label currency;

    @FXML
    protected void onHelloButtonClick() {
        Main.game.increaseCurrency();
        System.out.println(Main.game.purse.getCurrency());
        currency.setText(String.valueOf(Main.game.purse.getCurrency()));
    }

    @FXML
    public void onBuyButtonClick() {
        Main.game.buyupgrade(new FatLunaUpgrade());
        System.out.println("gay");
        Main.game.updatecurrency();
    }
}
