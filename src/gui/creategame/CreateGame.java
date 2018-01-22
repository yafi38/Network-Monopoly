package gui.creategame;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class CreateGame {
    private Scene createGameScene;
    private CreateGameController createGameController;

    public CreateGame() throws Exception{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("creategamefx.fxml"));
        Parent root = loader.load();
        createGameScene = new Scene(root);
        createGameController = loader.getController();
    }

    public Scene getCreateGameScene() {
        return createGameScene;
    }
    public CreateGameController getCreateGameController() {
        return createGameController;
    }
}
