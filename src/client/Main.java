package client;

import gui.creategame.CreateGame;
import gui.creategame.CreateGameController;
import gui.gamegui.GameGuiController;
import gui.login.Login;
import gui.mainmenu.Menu;
import gui.party.Party;
import gui.party.PartyController;
import gui.settings.Settings;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.util.Duration;
import java.util.HashSet;

public class Main extends Application {
    public static Stage window;
    public static Scene menuScene, createGameScene, settingsScene, loginScene, partyScene;
    public static int resX, resY;
    public static HashSet<String> onlineUsers;
    public static Client client;
    public static CreateGameController createGameController;
    public static PartyController partyController;
    public static GameGuiController gameGuiController;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        //window.initStyle(StageStyle.UNDECORATED);
        loadAll();
        //new Game();
        window.setScene(loginScene);
        resX = 1600;
        resY = 900;
        window.setOnCloseRequest(e -> System.exit(0));
        window.setWidth(resX);
        window.setHeight(resY);
        window.setMaximized(true);
        window.show();
    }

    MediaPlayer musicPlayer; {
        Media mp3MusicFile = new Media(getClass().getResource("bensound-acousticbreeze.mp3").toExternalForm());

        musicPlayer = new MediaPlayer(mp3MusicFile);
        musicPlayer.setAutoPlay(true);
        musicPlayer.setVolume(1);

        musicPlayer.setOnEndOfMedia(new Runnable() {
            public void run() {
                musicPlayer.seek(Duration.ZERO);
            }
        });


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