package server;

import client.Client;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class Server {
    private HashMap<String, Socket> onlineUsers;
    private ServerSocket serverSocket;

    Server() {
        onlineUsers = new HashMap<>();
        try {
            serverSocket = new ServerSocket(38383);
            new ServerWrite(onlineUsers);
            while(true) {
                Socket clientSocket = serverSocket.accept();
                //addNewClient(clientSocket);
            }
        } catch (Exception e) {
            System.out.println("In Server Constructor:" + e);
        }
    }

    private void addNewClient(Socket clientSocket) {
        try {
            String name;
            ObjectInputStream ois = new ObjectInputStream(clientSocket.getInputStream());
            Object o = ois.readObject();
            /*if(o != null && o instanceof String) {
                name = (String) o;
                onlineUsers.put(name, clientSocket);

                for (Map.Entry<String, Socket> user : onlineUsers.entrySet()) {
                    Socket socket = user.getValue();
                    ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
                    oos.writeObject("1");
                    oos.writeObject(name);
                }
            }*/

        } catch (Exception e) {
            System.out.println("In addNewClient: " + e);
        }
    }

    public static void main(String[] args) {
        new Server();
    }

}
