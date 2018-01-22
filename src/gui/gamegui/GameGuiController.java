package gui.gamegui;

import client.Main;
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
    public void initialize() {
        playerOneButton.setText(Main.client.partyMembers.get(0));
        playerTwoButton.setText(Main.client.partyMembers.get(1));
        playerThreeButton.setText(Main.client.partyMembers.get(2));
        playerFourButton.setText(Main.client.partyMembers.get(3));
        playerTurn.setText(Main.client.partyMembers.get(0) + "'s Turn");
        Image img = new Image("gui/gamegui/dice/three.png");
        diceTwo.setImage(img);
    }

    @FXML
    public void rollPressed() {
        if (Main.client.whosMove == Main.client.myNum) {
            int num1 = (int) (Math.random() * 6);
            int num2 = (int) (Math.random() * 6);

            diceOne.setImage(showDice(num1));
            diceTwo.setImage(showDice(num2));

            updatePos(num1 + num2);

            Main.client.diceRoll(num1 + num2);
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
            default:
                img = new Image("gui/gamegui/dice/six.png");
                break;
        }

        return img;
    }

    public void updatePos(int x) {
        Main.client.gameData[Main.client.whosMove].curPos = (Main.client.gameData[Main.client.whosMove].curPos + x) % 40;
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
                    green.setLayoutX(Main.client.property[Main.client.gameData[0].curPos].posX);
                    green.setLayoutY(Main.client.property[Main.client.gameData[0].curPos].posY);
                });
                break;
            }
            case 2: {
                Platform.runLater(() -> {
                    yellow.setLayoutX(Main.client.property[Main.client.gameData[0].curPos].posX);
                    yellow.setLayoutY(Main.client.property[Main.client.gameData[0].curPos].posY);
                });
                break;
            }
            case 3: {
                Platform.runLater(() -> {
                    blue.setLayoutX(Main.client.property[Main.client.gameData[0].curPos].posX);
                    blue.setLayoutY(Main.client.property[Main.client.gameData[0].curPos].posY);
                });
                break;
            }
        }

        Main.client.whosMove = (Main.client.whosMove + 1) % 4;
        System.out.println("Who's move: " + Main.client.whosMove);
    }
}
