package game;

import client.Main;
import gui.gamegui.GameGui;
import javafx.application.Platform;
import javafx.scene.Scene;

import java.util.ArrayList;

public class Game {
    private GameData[] gameData;
    //private ArrayList<String> players;
    private Scene gameGuiScene;

    public Game(ArrayList<String> players) {
        gameData = new GameData[4];

        for(int i=0; i<4; i++) {
            gameData[i] = new GameData(players.get(i));
        }

        try {
            gameGuiScene = new GameGui().getGameGuiScene();
            Platform.runLater(() -> Main.window.setScene(gameGuiScene));
        } catch (Exception e) {
            System.out.println("While Creating Game: " + e);
        }

    }

    //for debugging
    public Game() {
        try {
            gameGuiScene = new GameGui().getGameGuiScene();
            Platform.runLater(() -> Main.window.setScene(gameGuiScene));
        } catch (Exception e) {
            System.out.println("While Creating Game: " + e);
        }
    }
}
