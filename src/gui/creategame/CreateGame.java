package gui.creategame;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class CreateGame {
    private Scene createGameScene;

    public CreateGame() throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("creategamefx.fxml"));
        createGameScene = new Scene(root);
    }

    public Scene getCreateGameScene() {
        return createGameScene;
    }
}
