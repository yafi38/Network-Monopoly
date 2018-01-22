package gui.gamegui;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class GameGui {
    private Scene gameGuiScene;

    public GameGui() throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("GameGuiFX.fxml"));
        this.gameGuiScene = new Scene(root);
    }

    public Scene getGameGuiScene() {
        return gameGuiScene;
    }
}
