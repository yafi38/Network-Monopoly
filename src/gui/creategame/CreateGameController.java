package gui.creategame;

import client.Main;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

public class CreateGameController {

    @FXML
    ListView<String> onlinePlayers;

    @FXML
    ListView<String> inParty;

    @FXML
    public void initialize() {
        update();
    }

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

    private void update() {
        Runnable task = () -> {
            System.out.println("Started");
            while(true) {
                if (Main.isMainLoaded()) {
                    onlinePlayers.getItems().addAll(Main.onlineUsers);
                    System.out.println("Main is loaded");
                    break;
                }
            }

            while(true) {
                if (Main.isNewOnline()) {
                    System.out.println("Loading People");
                    if (Main.client.lastOnline != null) {
                        onlinePlayers.getItems().add(Main.client.lastOnline);
                    }
                    Main.newOnline = false;
                }
            }
        };

        Thread updateThread = new Thread(task);
        updateThread.setDaemon(true);
        updateThread.start();
    }

}
