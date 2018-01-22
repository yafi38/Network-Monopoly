package game;

import client.Main;
import gui.gamegui.GameGui;
import javafx.application.Platform;
import javafx.scene.Scene;

import java.util.ArrayList;

public class Game {
    private ArrayList<String> players;
    private Scene gameGuiScene;

    public Game(ArrayList<String> players) {
        this.players = players;
        try {
            gameGuiScene = new GameGui().getGameGuiScene();
            Platform.runLater(() -> Main.window.setScene(gameGuiScene));
        } catch (Exception e) {
            System.out.println("While Creating Game: " + e);
        }

    }
}
