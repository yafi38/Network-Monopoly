package gui.login;

import client.Client;
import client.Main;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

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
        Main.client.lastOnline = null;
        System.out.println(userName);
    }
}
