package client;

import gui.creategame.CreateGame;
import gui.login.Login;
import gui.mainmenu.Menu;
import gui.party.Party;
import gui.settings.Settings;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.util.HashSet;

public class Main extends Application {
    public static Stage window;
    public static Scene menuScene, createGameScene, settingsScene, loginScene, partyScene;
    public static int resX, resY;
    public static HashSet<String> onlineUsers;
    public static Client client;
    public static boolean newOnline = false;
    public static boolean isLoaded = false;
    public static boolean newPartyMember1 = false;
    public static boolean newPartyMember2 = false;

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
        loginScene = new Login().getLoginScene();
        menuScene = new Menu().getMenuScene();
        createGameScene = new CreateGame().getCreateGameScene();
        settingsScene = new Settings().getSettingsScene();
        partyScene = new Party().getPartyScene();
    }

    synchronized public static boolean isMainLoaded() {
        if(isLoaded) {
            //System.out.println("Yes, loaded");
            return true;
        }
        //System.out.println("Nope");
        return false;
    }

    synchronized public static boolean isNewOnline() {
        return newOnline;
    }

    synchronized public static boolean isNewPartyMember1() {
        return newPartyMember1;
    }

    synchronized public static boolean isNewPartyMember2() {
        return newPartyMember2;
    }
}