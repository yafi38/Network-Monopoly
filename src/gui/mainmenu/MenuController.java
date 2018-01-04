package gui.mainmenu;

import main.Main;

public class MenuController {
    public void showCreateGame() {
        Main.window.setScene(Main.createGameScene);
        Main.window.setFullScreen(true);
    }

    public void exit() {
        Main.window.close();
    }
}
