package gui.invite;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class InviteAlertBox {
    static String invitedBy;
    static Stage window;

    public InviteAlertBox(String s) {
        invitedBy = s;
        window = new Stage(StageStyle.UNDECORATED);
        try {
            Parent root = FXMLLoader.load(getClass().getResource("invitefx.fxml"));
            Scene scene = new Scene(root, 400, 400);
            window.setScene(scene);
            window.setTitle("New Invite!");
            window.initModality(Modality.APPLICATION_MODAL);
            window.showAndWait();
        } catch (Exception e) {
            System.out.println("While Creating Invite Box:" + e);
        }
    }

    static void close() {
        window.close();
    }
}
