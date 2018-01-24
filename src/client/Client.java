package client;

import database.Property;
import game.Game;
import game.GameData;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.Socket;
import java.util.ArrayList;

public class Client implements Serializable{
    public String name;
    private Socket clientSocket;
    public String lastOnline;
    public ClientRead cr;
    ObjectOutputStream oos;
    ObjectInputStream ois;
    public ArrayList<String> partyMembers;
    public GameData[] gameData;
    public int whosMove;
    public int myNum;
    public Property[] property;

    public Client(String name) {
        this.name = name;
        whosMove = 0;
        partyMembers = new ArrayList<>();
        partyMembers.add(name);
        property = new Property[40];
        property = Property.createProperty();
        try {
            this.clientSocket = new Socket("127.0.0.1", 38383);
            oos = new ObjectOutputStream(clientSocket.getOutputStream());
            ois = new ObjectInputStream(clientSocket.getInputStream());
            oos.writeObject(name);
            cr = new ClientRead(this);
            //new Game();
        } catch (IOException e) {
            System.out.println("Client Constructor: " + e);
        }
    }

    public void sendInvite(String name) {
        try {
            oos.writeObject("1");
            oos.writeObject(name);
        } catch(Exception e) {
            System.out.println("While Sending Invite(Client): " + e);
        }
    }

    public void inviteAccepted(String inviteeName) {           //I accepted someone's invite
        try {
            oos.writeObject("2");
            oos.writeObject(inviteeName);                      //Who's invite I accepted
        } catch (Exception e) {
            System.out.println("In inviteAccepted: " + e);
        }
    }

    public void createGame() {
        //System.out.println("Inside Client Create Game");
        myNum = 0;
        loadGameData();
        try {
            oos.writeObject("4");
            for(String s : Main.client.partyMembers) {
                oos.writeObject(s);
            }
        } catch(IOException e) {
            System.out.println("While creating new game in client" + e);
        }
    }

    public void loadGameData() {
        gameData = new GameData[4];
        for(int i=0; i<4; i++) {
            gameData[i] = new GameData(Main.client.partyMembers.get(i));
        }
    }

    public void diceRoll(int x) {
        try {
            //System.out.println("Dice roll sent");
            oos.writeObject("5");
            String s = "" + x;
            oos.writeObject(s);
        } catch (IOException e) {
            System.out.println("In Client Dice Roll: " + e);
        }
    }

    public void sendNewLandInfo(String landName, double price) {
        try {
            oos.writeObject("6");
            oos.writeObject("" + myNum);
            oos.writeObject(landName);
            oos.writeObject(price);
        } catch (IOException e) {
            System.out.println("While sending new land info " + e);
        }
    }

}
