package gui.gamegui;

import client.Main;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class GameGuiController {
    @FXML
    public Button playerOneButton;
    @FXML
    public Button playerTwoButton;
    @FXML
    public Button playerThreeButton;
    @FXML
    public Button playerFourButton;
    @FXML
    public Label playerTurn;

    @FXML
    public void initialize() {
        playerOneButton.setText(Main.client.partyMembers.get(0));
        playerTwoButton.setText(Main.client.partyMembers.get(1));
        playerThreeButton.setText(Main.client.partyMembers.get(2));
        playerFourButton.setText(Main.client.partyMembers.get(3));
        playerTurn.setText(Main.client.partyMembers.get(0) + "'s Turn");
    }
}
