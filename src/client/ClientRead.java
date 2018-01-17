package client;

import gui.invite.InviteAlertBox;
import javafx.application.Platform;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ClientRead implements Runnable {
    private Client client;
    private ObjectInputStream ois;
    //private ObjectOutputStream oos;
    private Thread thread;


    public ClientRead(Client client) {
        this.client = client;
        this.thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {
        try {
            this.ois = new ObjectInputStream(client.clientSocket.getInputStream());
            //this.oos = new ObjectOutputStream(client.clientSocket.getOutputStream());
            while (true) {
                Object o;
                o = ois.readObject();
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
            o = ois.readObject();
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
            o = ois.readObject();
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
        if(!s.equals(client.name)) {
            Main.onlineUsers.add(s);
            //System.out.println(s);
            Main.newOnline = true;
            Main.client.lastOnline = s;
        }
    }

    private void removeOnlineUser() {
        String s = readString();
        Main.onlineUsers.remove(s);
        Main.onlinePlayers.getItems().remove(s);
    }

    private void getAllOnlineUsers() {
        try {
            while(true) {
                String s = readString();
                if(s.equals("3"))
                    break;
                else {
                    Main.onlineUsers.add(s);
                    Main.onlinePlayers.getItems().add(s);
                }
            }
        } catch (Exception e) {
            System.out.println("In getAllOnlineUsers: " + e);
        }

        Main.isLoaded = true;
        /*System.out.println("Getting all online users");
        for(String h : Main.onlineUsers) {
            System.out.println(h);
        }
        System.out.println("End Getting");*/
    }

    private void getInvite() {
        String name;
        name = readString();
        System.out.println("Got invite");
        Platform.runLater(() ->new InviteAlertBox(name));
    }

    private void inviteGotAccepted() {          //Someone accepted my invite
        String name = readString();
        Main.client.partyMembers[Main.client.totalPartyMembers++] = name;
        try {
            Main.client.oos.writeObject(Main.client.partyMembers);
        } catch (IOException e) {
            System.out.println("In inviteGotAccepted: " + e);
        }
    }

    private void getPartyList() {

    }
}
