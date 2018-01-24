package gui.buyland;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class BuyLand {
    private static Stage window;
    static String landName;
    static double price;

    public BuyLand(String ln, double pr) {

        window = new Stage(StageStyle.UNDECORATED);
        landName = ln;
        price = pr;
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("BuyLandFX.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root, 800, 600);

            BuyLandController buyLandController = loader.getController();
            buyLandController.updateLabel();

            window.setScene(scene);
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
