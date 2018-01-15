package gui.party;

import client.Main;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

public class PartyController {
    @FXML
    ListView<String> partyMembers;

    @FXML
    public void initialize() {

    }

    @FXML
    void leave() {
        Main.window.setScene(Main.menuScene);
    }
}
