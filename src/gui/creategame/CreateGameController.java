package gui.creategame;

import main.Main;

public class CreateGameController {
    public void cancel() {
        Main.window.setScene(Main.menuScene);
        Main.window.setFullScreen(true);
    }
}
