package client;

import main.Main;

import java.io.IOException;
import java.io.ObjectInputStream;

public class ClientRead implements Runnable {
    private Client client;
    ObjectInputStream ois;

    public ClientRead(Client client) {
        this.client = client;
        try {
            this.ois = new ObjectInputStream(client.clientSocket.getInputStream());
        } catch (IOException e) {
            System.out.println("Creating Client Input Stream: " + e);
        }
    }

    public void run() {
        try {
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

    private void addOnlineUser() {
        Client c = readClient();
        if(c != null)
            Main.onlineUsers.add(c);
    }

    private void removeOnlineUser() {
        Client c = readClient();
        if(c != null) {
            int totalUsers = Main.onlineUsers.size();
            for(int i=0; i<totalUsers; i++) {
                if(c.equals(Main.onlineUsers.get(i)))
                    Main.onlineUsers.remove(i);
            }
        }
    }
}
