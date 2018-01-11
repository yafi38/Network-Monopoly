package gui.settings;

import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import client.Client;

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
        Client.window.setScene(Client.menuScene);
        //Client.window.setFullScreen(true);
    }
}
