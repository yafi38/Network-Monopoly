package client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.Socket;
import java.util.ArrayList;

public class Client implements Serializable{
    String name;
    private Socket clientSocket;
    public String lastOnline;
    public ClientRead cr;
    ObjectOutputStream oos;
    ObjectInputStream ois;
    public ArrayList<String> partyMembers;

    public Client(String name) {
        this.name = name;
        partyMembers = new ArrayList<>();
        partyMembers.add(name);
        try {
            this.clientSocket = new Socket("127.0.0.1", 38383);
            oos = new ObjectOutputStream(clientSocket.getOutputStream());
            ois = new ObjectInputStream(clientSocket.getInputStream());
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

    public void inviteAccepted(String inviteeName) {           //I accepted someone's invite
        try {
            oos.writeObject("2");
            oos.writeObject(inviteeName);                      //Who's invite I accepted
        } catch (Exception e) {
            System.out.println("In inviteAccepted: " + e);
        }
    }

}
