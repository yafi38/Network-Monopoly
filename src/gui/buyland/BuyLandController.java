package gui.buyland;

import client.Main;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class BuyLandController {
    @FXML
    public Label label;

    public void updateLabel() {
        label.setText("Do you want to buy " + BuyLand.landName + " for $" + BuyLand.price + "?");
    }

    @FXML
    public void buyButtonPressed() {
        Main.client.gameData[Main.client.myNum].ownedProperty.add(BuyLand.landName);
        Main.client.gameData[Main.client.myNum].currentGold -= BuyLand.price;
        Main.client.property[Main.client.gameData[Main.client.myNum].curPos].owner = Main.client.myNum;
        System.out.println("Bought new property: " + BuyLand.landName);
        Main.client.sendNewLandInfo(BuyLand.landName, BuyLand.price);
        BuyLand.close();
    }

    @FXML
    public void cancelButtonPressed() {
        BuyLand.close();
    }
}
