package gui.login;

import client.Client;
import main.Main;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class LoginController {
    @FXML
    TextField userNameField;

    public void loginButtonPressed() {
        Main.window.setScene(Main.menuScene);
        //Main.window.setFullScreen(true);
        String userName = userNameField.getText();
        Main.client = new Client(userName);
        Main.onlineUsers = new HashSet<>();
    }
}
