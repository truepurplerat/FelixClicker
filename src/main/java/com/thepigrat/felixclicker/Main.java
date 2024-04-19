package com.thepigrat.felixclicker;

import com.thepigrat.felixclicker.data.DataManager;
import com.thepigrat.felixclicker.data.LoadedGame;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.effect.Bloom;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.DataInput;
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

        // Load controller from main.fxml and create new game
        var controller = (MainController) fxmlLoader.getController();

        onStart(controller);

        runUpgrades();
        onExit();
    }

    public static void runUpgrades() {
        Timeline timeline = new Timeline();
        timeline.setCycleCount(Timeline.INDEFINITE); // Execute indefinitely
        timeline.getKeyFrames().add(new KeyFrame(Duration.millis(30), event -> {
            game.generate();
        }));
        // Start the timeline
        timeline.play();
    }

    public static void onExit() {
        Runtime.getRuntime().addShutdownHook(new Thread(() -> game.save()));
    }

    public static void onStart(MainController controller) {
        var loaded = new LoadedGame();
        loaded.parse();
        System.out.println(loaded.getCurrency());

        game = new Game(controller);
        if (loaded.isLoaded()) {
            game.purse.setCurrency(loaded.getCurrency());
        }
    }

    public static void main(String[] args) {
        launch();
    }
}
