package com.thepigrat.felixclicker;

import com.thepigrat.felixclicker.upgrades.FatLunaUpgrade;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class MainController {
    @FXML
    public Label currency;

    @FXML
    protected void onHelloButtonClick() {
        Main.game.increaseCurrency();
        currency.setText(String.valueOf(Main.game.purse.getCurrency()));
    }

    @FXML
    public void onBuyFLUButtonClick() {
        Main.game.buyupgrade(new FatLunaUpgrade());
        Main.game.updatecurrency();
    }
}
