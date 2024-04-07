package com.thepigrat.felixclicker;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class MainController {
    @FXML
    public Label currency;

    @FXML
    protected void onHelloButtonClick() {
        Main.game.increaseCurrency();
        System.out.println(Main.game.currency);
        currency.setText(String.valueOf(Main.game.currency));
    }

}
