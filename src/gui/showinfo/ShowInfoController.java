package gui.showinfo;

import client.Main;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

public class ShowInfoController {
    @FXML
    public Label userNameLabel;
    @FXML
    public Label goldLabel;
    @FXML
    public ListView<String> ownedPropertyList;

    @FXML
    public void initialize() {
        userNameLabel.setText(Main.client.partyMembers.get(ShowInfo.playerNum));
        goldLabel.setText("Gold: " + Main.client.gameData[ShowInfo.playerNum].currentGold);
        ownedPropertyList.getItems().addAll(Main.client.gameData[ShowInfo.playerNum].ownedProperty);
    }

    @FXML
    public void closeButtonPressed() {
        ShowInfo.close();
    }
}
