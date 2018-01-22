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
            new Game(Main.client.partyMembers);
        }
    }

    /*private void updateOnlinePlayers() {
        Runnable task = () -> {
            //System.out.println("Started");
            while(true) {
                if (Main.isMainLoaded()) {
                    onlinePlayers.getItems().addAll(Main.onlineUsers);
                    //System.out.println("Main is loaded");
                    break;
                }
            }

            while(true) {
                if (Main.isNewOnline()) {
                    //System.out.println("Loading People");
                    if (Main.client.lastOnline != null) {
                        Platform.runLater(() -> onlinePlayers.getItems().add(Main.client.lastOnline));
                    }
                    Main.newOnline = false;
                }
            }
        };

        Thread updateThread = new Thread(task);
        updateThread.setDaemon(true);
        updateThread.start();
    }*/

    /*private void updateParty1() {
        Runnable partyUpdater = () -> {
            System.out.println("Inside Party Updater Controller");
            while(true) {
                if(Main.isNewPartyMember1()) {
                    System.out.println("xkxkxkxk");
                    Platform.runLater(() -> partyList2.getItems().clear());
                    Platform.runLater(() -> partyList2.getItems().addAll(Main.client.partyMembers));
                    Main.newPartyMember1 = false;
                }
            }
        };

        Thread updatePartyThread1 = new Thread(partyUpdater);
        updatePartyThread1.setDaemon(true);
        updatePartyThread1.start();
    }*/

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
