package client;

import gui.login.Login;
import gui.settings.Settings;
import javafx.application.Application;
import gui.mainmenu.Menu;
import gui.creategame.CreateGame;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.util.HashSet;

public class Main extends Application {
    public static Stage window;
    public static Scene menuScene, createGameScene, settingsScene, loginScene;
    public static int resX, resY;
    public static HashSet<String> onlineUsers;
    public static Client client;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        window = primaryStage;
        loadAll();
        window.setScene(loginScene);
        resX = 1600;
        resY = 900;
        window.setWidth(resX);
        window.setHeight(resY);
        window.setMaximized(true);
        window.show();
    }

    private void loadAll() throws Exception {
        menuScene = new Menu().getMenuScene();
        createGameScene = new CreateGame().getCreateGameScene();
        settingsScene = new Settings().getSettingsScene();
        loginScene = new Login().getLoginScene();
    }

}