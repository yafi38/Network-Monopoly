package main;

import javafx.application.Application;
import gui.mainmenu.Menu;
import gui.creategame.CreateGame;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    public static Stage window;
    public static Scene menuScene, createGameScene;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        window = primaryStage;
        loadAll();
        window.setScene(menuScene);
        window.setFullScreen(true);
        window.show();
    }

    private void loadAll() throws Exception {
        menuScene = new Menu().getMenuScene();
        createGameScene = new CreateGame().getCreateGameScene();
    }

}
