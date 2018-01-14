package server;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Info {
    Socket clientSocket;
    ObjectInputStream ois;
    ObjectOutputStream oos;

    Info(Socket clientSocket) {
        this.clientSocket = clientSocket;
        try {
            this.ois = new ObjectInputStream(clientSocket.getInputStream());
            this.oos = new ObjectOutputStream(clientSocket.getOutputStream());
        } catch (Exception e) {
            System.out.println("In Info Constructor:" + e);
        }
    }
}
