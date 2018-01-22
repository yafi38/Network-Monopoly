package gui.gamegui;

import client.Main;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class GameGui {
    private Scene gameGuiScene;

    public GameGui() throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("GameGuiFX.fxml"));
        Parent root = loader.load();
        this.gameGuiScene = new Scene(root);
        Main.gameGuiController = loader.getController();
    }

    public Scene getGameGuiScene() {
        return gameGuiScene;
    }
}
