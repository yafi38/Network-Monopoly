package gui.login;

import client.Client;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class LoginController {
    @FXML
    TextField userNameField;

    public void loginButtonPressed() {
        Client.window.setScene(Client.menuScene);
        //Client.window.setFullScreen(true);
        Client.userName = userNameField.getText();
        Client.createClient();
    }
}
