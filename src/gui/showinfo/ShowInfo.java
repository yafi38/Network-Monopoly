package gui.showinfo;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class ShowInfo {
    static Stage window;
    static int playerNum;

    public ShowInfo(int pn) {
        window = new Stage(StageStyle.UNDECORATED);
        playerNum = pn;
        try {
            Parent root = FXMLLoader.load(getClass().getResource("ShowInfoFX.fxml"));
            Scene scene = new Scene(root, 400, 400);
            window.setScene(scene);
            window.initModality(Modality.APPLICATION_MODAL);
            window.showAndWait();
        } catch (Exception e) {
            System.out.println("While Showing Info:" + e);
        }
    }

    static void close() {
        window.close();
    }
}
