package com.thepigrat.felixclicker;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;

public class Main extends Application {
    public static Game game;

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("main.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("FelixClicker");
        stage.setScene(scene);
        stage.show();
        var controller = (MainController) fxmlLoader.getController();
        game = new Game(controller);
        Timeline timeline = new Timeline();
        timeline.setCycleCount(Timeline.INDEFINITE); // Execute indefinitely
        timeline.getKeyFrames().add(new KeyFrame(Duration.millis(10), event -> {
            game.generate();
        }));

        // Start the timeline
        timeline.play();
    }

    public static void main(String[] args) {
        launch();
    }
}









