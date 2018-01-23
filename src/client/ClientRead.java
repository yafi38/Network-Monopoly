package client;

import game.Game;
import gui.invite.InviteAlertBox;
import javafx.application.Platform;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ClientRead implements Runnable {
    private Client client;
    private Thread thread;


    public ClientRead(Client client) {
        this.client = client;
        this.thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {
        try {
            //this.oos = new ObjectOutputStream(client.clientSocket.getOutputStream());
            while (true) {
                Object o;
                o = Main.client.ois.readObject();
                String str = (String) o;
                int command = Integer.parseInt(str);

                switch (command) {
                    case 1:
                        addOnlineUser();
                        break;
                    case 2:
                        removeOnlineUser();
                        break;
                    case 3:
                        getAllOnlineUsers();
                        break;
                    case 4:
                        getInvite();
                        break;
                    case 5:
                        inviteGotAccepted();
                        break;
                    case 6:
                        getPartyList();
                        break;
                    case 7:
                        gameStarted();
                        break;
                    case 8:
                        getDiceRoll();
                        break;

                }
            }
        } catch (Exception e) {
            System.out.println("While Reading Command: " + e);
        }
    }

    private Client readClient() {
        Client c = null;
        try {
            Object o;
            o = Main.client.ois.readObject();
            if (o != null && o instanceof Client) {
                c = (Client) o;
            }
        } catch (Exception e) {
            System.out.println("While Reading Client: " + e);
        }
        return c;
    }

    private String readString() {
        String s = null;
        try {
            Object o;
            o = Main.client.ois.readObject();
            if (o != null && o instanceof String) {
                s = (String) o;
            }
        } catch (Exception e) {
            System.out.println("While Reading String: " + e);
        }
        return s;
    }

    private void addOnlineUser() {
        String s = readString();
        if (!s.equals(client.name)) {
            Main.onlineUsers.add(s);
            Main.createGameController.updateOnlinePlayers();
        }
    }

    private void removeOnlineUser() {
        String s = readString();
        Main.onlineUsers.remove(s);
    }

    private void getAllOnlineUsers() {
        try {
            while (true) {
                String s = readString();
                if (s.equals("0"))
                    break;
                else {
                    Main.onlineUsers.add(s);
                }
            }
        } catch (Exception e) {
            System.out.println("In getAllOnlineUsers: " + e);
        }

        Main.createGameController.updateOnlinePlayers();
    }

    private void getInvite() {
        String name;
        name = readString();
        //System.out.println("Got invite");
        Platform.runLater(() -> new InviteAlertBox(name));
    }

    private void inviteGotAccepted() {          //Someone accepted my invite
        String name = readString();
        Main.client.partyMembers.add(name);
        try {
            Main.client.oos.writeObject("3");
            for (String s : Main.client.partyMembers) {
                Main.client.oos.writeObject(s);
            }
            Main.client.oos.writeObject("0");
            //System.out.println("Sending party members to server");
        } catch (Exception e) {
            System.out.println("In inviteGotAccepted: " + e);
        }
    }

    private void getPartyList() {
        //System.out.println("Getting Party List");
        Main.client.partyMembers.clear();
        String s;
        while (true) {
            s = readString();
            if (s.equals("0"))
                break;
            Main.client.partyMembers.add(s);
        }

        Main.createGameController.updatePartyMember();
        Main.partyController.updatePartyLeader();
    }

    private void gameStarted() {
        Main.client.loadGameData();
        String s = readString();
        Main.client.myNum = Integer.parseInt(s);
        System.out.println("My Number: " + Main.client.myNum);
        new Game(Main.client.partyMembers);
    }

    private void getDiceRoll() {
        //System.out.println("got dice roll");
        String s = readString();
        int x = Integer.parseInt(s);
        Main.gameGuiController.updatePos(x);
    }
}
