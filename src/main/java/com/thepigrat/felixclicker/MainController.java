package com.thepigrat.felixclicker;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class MainController {
    @FXML
    public Label currency;

    @FXML
    protected void onHelloButtonClick() {
        Main.game.get().increaseCurrency();
        System.out.println(Main.game.get().currency);
        currency.setText(String.valueOf(Main.game.get().currency));
    }

}
