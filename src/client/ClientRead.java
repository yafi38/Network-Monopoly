package client;

import main.Main;

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
            try {
                this.ois = new ObjectInputStream(client.clientSocket.getInputStream());
            } catch (IOException e) {
                System.out.println("Creating Client Input Stream: " + e);
            }
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
        if(s != null && !s.equals(client.name))
            Main.onlineUsers.add(s);
    }

    private void removeOnlineUser() {
        String s = readString();
        Main.onlineUsers.remove(s);
    }
}
