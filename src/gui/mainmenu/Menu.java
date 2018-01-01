package gui.mainmenu;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Menu extends Application{
    static Scene menuScene;

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("menufx.fxml"));
        menuScene = new Scene(root);
        primaryStage.setScene(menuScene);
        primaryStage.setFullScreen(true);
        primaryStage.show();
    }
}
