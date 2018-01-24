package gui.mainmenu;

import client.Main;

public class MenuController {
    public void showCreateGame() {
        Main.window.setScene(Main.createGameScene);
        //Main.window.setFullScreen(true);
    }

    public void showSettings() {
        Main.window.setScene(Main.settingsScene);
        //Main.window.setFullScreen(true);
    }

    public void exit() {
        Main.window.close();
        System.exit(0);
    }
}
