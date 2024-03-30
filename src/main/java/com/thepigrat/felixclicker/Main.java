package com.thepigrat.felixclicker;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import util.ProducerThread;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicReference;

public class Main extends Application {
    public static AtomicReference <Game> game;
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("main.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("FelixClicker");
        stage.setScene(scene);
        stage.show();
        var controller= (MainController)fxmlLoader.getController();
        game=new AtomicReference<>(new Game(controller));
        var thread=new ProducerThread();
        thread.start();
    }

    public static void main(String[] args) {
        launch();
    }
}









