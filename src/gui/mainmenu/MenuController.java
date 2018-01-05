package gui.mainmenu;

import gui.settings.SettingsController;
import main.Main;

public class MenuController {
    public void showCreateGame() {
        Main.window.setScene(Main.createGameScene);
        Main.window.setFullScreen(true);
    }

    public void showSettings() {
        //new SettingsController().setChoices();
        Main.window.setScene(Main.settingsScene);
        Main.window.setFullScreen(true);
    }

    public void exit() {
        Main.window.close();
    }
}
