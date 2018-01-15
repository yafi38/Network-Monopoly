package client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.Socket;

public class Client implements Serializable{
    String name;
    Socket clientSocket;
    public String lastOnline;
    public ClientRead cr;
    ObjectOutputStream oos;

    public Client(String name) {
        this.name = name;
        try {
            this.clientSocket = new Socket("127.0.0.1", 38383);
            oos = new ObjectOutputStream(clientSocket.getOutputStream());
            oos.writeObject(name);
            cr = new ClientRead(this);
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

}
