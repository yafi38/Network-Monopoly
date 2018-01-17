package gui.invite;

import client.Main;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class InviteAlertBoxController {
    @FXML
    Label inviteMessage;

    @FXML
    public void initialize() {
        inviteMessage.setText(InviteAlertBox.invitedBy + "has invited you");
    }

    @FXML
    void accept() {
        Main.client.inviteAccepted(InviteAlertBox.invitedBy);
        InviteAlertBox.close();
    }

    @FXML
    void decline() {
        InviteAlertBox.close();
    }
}
