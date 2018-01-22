package game;

import java.util.ArrayList;

public class GameData {
    String playerName;
    Double currentGold;
    ArrayList<String> ownedProperty;
    int curPos;

    GameData(String name) {
        playerName = name;
        currentGold = 500.0;
        ownedProperty = new ArrayList<>();
        curPos = 0;
    }
}
