package client;

import gui.settings.Settings;
import gui.mainmenu.Menu;
import gui.creategame.CreateGame;
import gui.login.Login;
import server.Server;
import util.*;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.Serializable;

public class Client extends Application implements Serializable{
    public static Stage window;
    public static Scene menuScene, createGameScene, settingsScene, loginScene;
    public static String userName;
    public static int resX, resY;
    public static OnlinePlayersThread onlinePlayersThread;

    public static void createClient() {
        try {
            NetworkUtil nc = new NetworkUtil("127.0.0.1", 38383);
            new ReadThread(nc);
            new ClientWriteThread(nc, userName);
            onlinePlayersThread = new OnlinePlayersThread(nc, userName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        loadAll();
        resX = 1600;
        resY = 900;
        window.setScene(loginScene);
        //window.setResizable(true);
        //window.setFullScreen(true);
        window.setHeight(resY);
        window.setWidth(resX);
        window.show();
    }

    private void loadAll() throws Exception {
        menuScene = new Menu().getMenuScene();
        createGameScene = new CreateGame().getCreateGameScene();
        settingsScene = new Settings().getSettingsScene();
        loginScene = new Login().getLoginScene();
    }

}
