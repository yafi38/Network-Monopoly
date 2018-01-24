package game;

import java.util.ArrayList;

public class GameData {
    public String playerName;
    public Double currentGold;
    public ArrayList<String> ownedProperty;
    public int curPos;

    public GameData(String name) {
        playerName = name;
        currentGold = 1500.0;
        ownedProperty = new ArrayList<>();
        curPos = 0;
    }
}
