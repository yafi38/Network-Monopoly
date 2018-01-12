package gui.creategame;

import client.Main;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

import java.util.HashSet;

public class CreateGameController {

    @FXML
    ListView<String> onlinePlayers;

    @FXML
    ListView<String> inParty;

    @FXML
    public void initialize() {

    }

    @FXML
    public void cancel() {
        Main.window.setScene(Main.menuScene);
        //Main.window.setFullScreen(true);
    }

    @FXML
    public void refresh() {
        onlinePlayers.getItems().addAll(Main.onlineUsers);
    }

}
