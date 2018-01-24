package gui.settings;

import client.Main;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;

public class SettingsController {
    @FXML
    ChoiceBox<String> resolutionChoice;
    @FXML
    ChoiceBox<String> soundChoice;
    @FXML
    ChoiceBox<String> musicChoice;

    @FXML
    public void initialize() {
        resolutionChoice.getItems().addAll("1920x1080", "1600x900", "1280x720");
        resolutionChoice.getSelectionModel().select("1600x900");
        soundChoice.getItems().addAll("On", "Off");
        soundChoice.getSelectionModel().select("On");
        musicChoice.getItems().addAll("On", "Off");
        musicChoice.getSelectionModel().select("On");
    }

    //void save()               //need to implement this

    @FXML
    void cancel() {
        Main.window.setScene(Main.menuScene);
        //Main.window.setFullScreen(true);
    }
}
