package game;

import database.Property;

import java.util.ArrayList;

public class GameData {
    public String playerName;
    public Double currentGold;
    public ArrayList<String> ownedProperty;
    public int curPos;

    public GameData(String name) {
        playerName = name;
        currentGold = 500.0;
        ownedProperty = new ArrayList<>();
        curPos = 0;
    }
}
