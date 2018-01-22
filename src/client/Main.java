package client;

import gui.creategame.CreateGame;
import gui.creategame.CreateGameController;
import gui.login.Login;
import gui.mainmenu.Menu;
import gui.party.Party;
import gui.party.PartyController;
import gui.settings.Settings;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.util.HashSet;

public class Main extends Application {
    public static Stage window;
    public static Scene menuScene, createGameScene, settingsScene, loginScene, partyScene;
    public static int resX, resY;
    public static HashSet<String> onlineUsers;
    public static Client client;
    public static CreateGameController createGameController;
    public static PartyController partyController;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        //window.initStyle(StageStyle.UNDECORATED);
        loadAll();
        //new Game(new ArrayList<String>(4));
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
        CreateGame cg = new CreateGame();
        createGameScene = cg.getCreateGameScene();
        createGameController = cg.getCreateGameController();
        Party pt = new Party();
        partyScene = pt.getPartyScene();
        partyController = pt.getPartyController();
        settingsScene = new Settings().getSettingsScene();
    }
}