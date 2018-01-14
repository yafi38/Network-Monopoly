package gui.login;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class Login {
    private Scene loginScene;

    public Login() throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("loginfx.fxml"));
        this.loginScene = new Scene(root);
    }

    public Scene getLoginScene() {
        return loginScene;
    }
}
