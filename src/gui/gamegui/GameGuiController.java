package gui.gamegui;

import client.Main;
import database.Property;
import gui.buyland.BuyLand;
import gui.showinfo.ShowInfo;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class GameGuiController {
    @FXML
    public Button playerOneButton;
    @FXML
    public Button playerTwoButton;
    @FXML
    public Button playerThreeButton;
    @FXML
    public Button playerFourButton;
    @FXML
    public Button rollButton;

    @FXML
    public Label playerTurn;

    @FXML
    public ImageView diceOne;
    @FXML
    public ImageView diceTwo;
    @FXML
    public ImageView red;       //player1
    @FXML
    public ImageView green;     //player2
    @FXML
    public ImageView yellow;    //player3
    @FXML
    public ImageView blue;      //player4
    @FXML
    public Label myName;

    @FXML
    public void initialize() {
        playerOneButton.setText(Main.client.partyMembers.get(0));
        playerTwoButton.setText(Main.client.partyMembers.get(1));
        playerThreeButton.setText(Main.client.partyMembers.get(2));
        playerFourButton.setText(Main.client.partyMembers.get(3));
        playerTurn.setText(Main.client.partyMembers.get(0) + "'s Turn");
        myName.setText(Main.client.name);
        //Image img = new Image("gui/gamegui/dice/three.png");
        //diceTwo.setImage(img);
    }

    @FXML
    public void rollPressed() {
        if (Main.client.whosMove == Main.client.myNum) {
            int num1 = (int) Math.ceil(Math.random() * 6);
            int num2 = (int) Math.ceil(Math.random() * 6);

            diceOne.setImage(showDice(num1));
            diceTwo.setImage(showDice(num2));

            int x = num1 + num2;

            Main.client.gameData[Main.client.myNum].curPos = (Main.client.gameData[Main.client.myNum].curPos + x) % 40;
            if (Main.client.gameData[Main.client.myNum].curPos == 30)
                Main.client.gameData[Main.client.myNum].curPos = 10;

            updatePos(x);
            Main.client.diceRoll(x);

            int curPos = Main.client.gameData[Main.client.myNum].curPos;

            Property property = Main.client.property[curPos];
            System.out.println(property.owner);

            if (property.owner != Main.client.myNum - 1) {
                if (property.owner == 0) {
                    new BuyLand(property.name, property.price);
                } else if (property.owner == -1) {
                    if (curPos == 0)
                        Main.client.gameData[Main.client.myNum].currentGold += property.price;
                    else if (curPos == 30) {
                        Main.client.gameData[Main.client.myNum].currentGold -= property.price;
                    }

                } else if (property.owner == -2) {
                    Main.client.gameData[Main.client.myNum].currentGold -= property.price;
                }
            }
        }
    }

    private Image showDice(int x) {
        //System.out.println("In show dice");
        Image img;
        switch (x) {
            case 1:
                img = new Image("gui/gamegui/dice/one.png");
                break;
            case 2:
                img = new Image("gui/gamegui/dice/two.png");
                break;
            case 3:
                img = new Image("gui/gamegui/dice/three.png");
                break;
            case 4:
                img = new Image("gui/gamegui/dice/four.png");
                break;
            case 5:
                img = new Image("gui/gamegui/dice/five.png");
                break;
            case 6:
                img = new Image("gui/gamegui/dice/six.png");
                break;
            default:
                System.out.println("Wrong Dice Rolled");
                img = new Image("gui/gamegui/dice/six.png");
                break;
        }

        return img;
    }

    public void updatePos(int x) {

        switch (Main.client.whosMove) {
            case 0: {
                Platform.runLater(() -> {
                    red.setLayoutX(Main.client.property[Main.client.gameData[0].curPos].posX);
                    red.setLayoutY(Main.client.property[Main.client.gameData[0].curPos].posY);
                });
                break;
            }
            case 1: {
                Platform.runLater(() -> {
                    green.setLayoutX(Main.client.property[Main.client.gameData[1].curPos].posX);
                    green.setLayoutY(Main.client.property[Main.client.gameData[1].curPos].posY);
                });
                break;
            }
            case 2: {
                Platform.runLater(() -> {
                    yellow.setLayoutX(Main.client.property[Main.client.gameData[2].curPos].posX);
                    yellow.setLayoutY(Main.client.property[Main.client.gameData[2].curPos].posY);
                });
                break;
            }
            case 3: {
                Platform.runLater(() -> {
                    blue.setLayoutX(Main.client.property[Main.client.gameData[3].curPos].posX);
                    blue.setLayoutY(Main.client.property[Main.client.gameData[3].curPos].posY);
                });
                break;
            }
        }

        Main.client.whosMove = (Main.client.whosMove + 1) % 4;
        Platform.runLater(() -> playerTurn.setText(Main.client.partyMembers.get(Main.client.whosMove) + "'s Turn"));
        //System.out.println("Who's move: " + Main.client.whosMove);
    }

    @FXML
    public void playerOneButtonPressed() {
        new ShowInfo(0);
    }

    @FXML
    public void playerTwoButtonPressed() {
        new ShowInfo(1);
    }

    @FXML
    public void playerThreeButtonPressed() {
        new ShowInfo(2);
    }

    @FXML
    public void playerFourButtonPressed() {
        new ShowInfo(3);
    }
}
