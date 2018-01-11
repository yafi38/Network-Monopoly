package gui.creategame;

import client.Client;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

public class CreateGameController {

    @FXML
    ListView<String> onlinePlayers;

    @FXML
    ListView<String> inParty;

    @FXML
    public void initialize() {
        onlinePlayers.getItems().addAll();
    }





    public void cancel() {
        Client.window.setScene(Client.menuScene);
        //Client.window.setFullScreen(true);
    }


}
