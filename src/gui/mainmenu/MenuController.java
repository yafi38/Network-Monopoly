package gui.mainmenu;

import client.Client;

public class MenuController {
    public void showCreateGame() {
        Client.window.setScene(Client.createGameScene);
        //Client.window.setFullScreen(true);
    }

    public void showSettings() {
        //new SettingsController().setChoices();
        Client.window.setScene(Client.settingsScene);
        //Client.window.setFullScreen(true);
    }

    public void exit() {
        Client.window.close();
    }
}
