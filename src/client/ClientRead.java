package client;

import java.io.IOException;
import java.io.ObjectInputStream;

public class ClientRead implements Runnable {
    private Client client;
    ObjectInputStream ois;
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
                    case 3:
                        getAllOnlineUsers();

                    case 4:
                        getInvite();

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
    }
}
