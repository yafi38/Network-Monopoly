package gui.party;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class Party {
    private Scene partyScene;

    public Party() throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("partyfx.fxml"));
        partyScene = new Scene(root);
    }

    public Scene getPartyScene() {
        return partyScene;
    }
}
