package server;

import client.Client;
import util.*;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;

public class Server {

    private ServerSocket serverSocket;
    //public int i = 1;
    public HashMap<String, NetworkUtil> clientMap;
    public ArrayList<Client> clientList;
    public static Server server;

    private Server() {
        clientMap = new HashMap<>();
        clientList = new ArrayList<>();
        try {
            serverSocket = new ServerSocket(38383);
            new ServerWriteThread(clientMap, "Server");
            while (true) {
                Socket clientSocket = serverSocket.accept();
                serve(clientSocket);
            }
        } catch (Exception e) {
            System.out.println("Server starts:" + e);
        }
    }

    public void serve(Socket clientSocket) {
        NetworkUtil nc = new NetworkUtil(clientSocket);
        Client client = (Client) nc.read();
        clientMap.put(client.userName, nc);
        clientList.add(client);
        new ReadThread(nc);
    }

    public static void main(String args[]) {
        server = new Server();
    }
}
