package gui.party;

import client.Main;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

public class PartyController {
    @FXML
    ListView<String> partyList;

    /*@FXML
    public void initialize() {
        updateParty2();
    }*/

    @FXML
    void leave() {
        Main.window.setScene(Main.menuScene);
    }

    /*private void updateParty2() {
        Runnable partyUpdater = () -> {
            //System.out.println("Inside Party Updater");
            while(true) {
                if(Main.isNewPartyMember2()) {
                    Platform.runLater(() -> partyList.getItems().clear());
                    Platform.runLater(() -> partyList.getItems().addAll(Main.client.partyMembers));
                    Main.newPartyMember2 = false;
                }
            }
        };

        Thread updatePartyThread2 = new Thread(partyUpdater);
        updatePartyThread2.setDaemon(true);
        updatePartyThread2.start();
    }*/

    public void updatePartyLeader() {
        Platform.runLater(() -> {
            partyList.getItems().clear();
            partyList.getItems().addAll(Main.client.partyMembers);
        });
    }
}
