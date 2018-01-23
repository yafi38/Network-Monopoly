package server;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Server {
    private HashMap<String, Info> onlineUsers;
    private ServerSocket serverSocket;
    static ArrayList<String> partyMembers;

    private Server() {
        onlineUsers = new HashMap<>();
        partyMembers = new ArrayList<>();
        try {
            serverSocket = new ServerSocket(38383);
            while(true) {
                Socket clientSocket = serverSocket.accept();
                addNewClient(clientSocket);
            }
        } catch (Exception e) {
            System.out.println("In Server Constructor:" + e);
        }
    }

    private void addNewClient(Socket clientSocket) {
        try {
            String name;
            Info info = new Info(clientSocket);
            Object o = info.ois.readObject();
            info.oos.writeObject("3");

            if(o != null && o instanceof String) {
                name = (String) o;
                new ServerRead(name, info, onlineUsers);
                for (Map.Entry<String, Info> user : onlineUsers.entrySet()) {
                    Info tempInfo = user.getValue();
                    String userName = user.getKey();
                    tempInfo.oos.writeObject("1");
                    tempInfo.oos.writeObject(name);
                    //System.out.println(name);

                    info.oos.writeObject(userName);
                }
                onlineUsers.put(name, info);
            }

            info.oos.writeObject("0");

        } catch (Exception e) {
            System.out.println("In addNewClient: " + e);
        }
    }

    public static void main(String[] args) {
        new Server();
    }

}
