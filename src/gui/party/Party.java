package gui.party;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class Party {
    private Scene partyScene;
    private PartyController partyController;

    public Party() throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("partyfx.fxml"));
        Parent root = loader.load();
        partyScene = new Scene(root);
        partyController = loader.getController();
    }

    public Scene getPartyScene() {
        return partyScene;
    }

    public PartyController getPartyController() {
        return partyController;
    }
}
