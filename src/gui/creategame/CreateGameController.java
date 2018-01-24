package gui.creategame;

import client.Main;
import game.Game;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

public class CreateGameController {

    @FXML
    ListView<String> onlinePlayers;

    @FXML
    ListView<String> partyList2;

    @FXML
    public void invite() {
        String name = onlinePlayers.getSelectionModel().getSelectedItem();
        //System.out.println("Inviting " + name);
        Main.client.sendInvite(name);
    }

    @FXML
    public void cancel() {
        Main.window.setScene(Main.menuScene);
        //Main.window.setFullScreen(true);
    }

    @FXML
    public void startGame() {
        if (Main.client.partyMembers.size() == 4) {
            Main.client.createGame();
            new Game(Main.client.partyMembers);
        }
    }

    public void updateOnlinePlayers() {
        Platform.runLater(() -> {
            onlinePlayers.getItems().clear();
            onlinePlayers.getItems().addAll(Main.onlineUsers);
        });
    }

    public void updatePartyMember() {
        Platform.runLater(() -> {
            partyList2.getItems().clear();
            partyList2.getItems().addAll(Main.client.partyMembers);
        });
    }
}
