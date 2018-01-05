package gui.settings;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class Settings {
    private Scene settingsScene;

    public Settings() throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("settingsfx.fxml"));
        this.settingsScene = new Scene(root);
    }

    public Scene getSettingsScene() {
        return settingsScene;
    }
}
