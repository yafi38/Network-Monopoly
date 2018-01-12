package client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.net.Socket;

public class Client implements Serializable{
    String name;
    Socket clientSocket;

    public Client(String name) {
        this.name = name;
        try {
            this.clientSocket = new Socket("127.0.0.1", 38383);
            new ClientRead(this);
        } catch (IOException e) {
            System.out.println("Client Constructor: " + e);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Client client = (Client) o;

        return name != null ? name.equals(client.name) : client.name == null;
    }

}
