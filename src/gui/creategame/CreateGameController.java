package gui.creategame;

import main.Main;
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
        Main.window.setScene(Main.menuScene);
        //Main.window.setFullScreen(true);
    }


}
