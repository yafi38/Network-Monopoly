package gui.party;

import client.Main;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

public class PartyController {
    @FXML
    ListView<String> partyList;

    @FXML
    void leave() {
        Main.window.setScene(Main.menuScene);
    }

    public void updatePartyLeader() {
        Platform.runLater(() -> {
            partyList.getItems().clear();
            partyList.getItems().addAll(Main.client.partyMembers);
        });
    }
}
