package gui.login;

import client.Client;
import main.Main;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.util.ArrayList;

public class LoginController {
    @FXML
    TextField userNameField;

    public void loginButtonPressed() {
        Main.window.setScene(Main.menuScene);
        //Main.window.setFullScreen(true);
        Main.userName = userNameField.getText();
        Main.client = new Client(Main.userName);
        Main.onlineUsers = new ArrayList<>();
    }
}
