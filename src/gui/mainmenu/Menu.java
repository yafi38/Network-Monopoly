package gui.mainmenu;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class Menu {
    private Scene menuScene;

    public Menu() throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("menufx.fxml"));
        this.menuScene = new Scene(root);
    }

    public Scene getMenuScene() {
        return menuScene;
    }
}
