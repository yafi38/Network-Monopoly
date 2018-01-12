package server;

import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.HashMap;

public class ServerWrite implements Runnable {
    private HashMap<String, Socket> onlineUsers;
    private Thread thread;

    ServerWrite(HashMap<String, Socket> onlineUsers) {
        this.onlineUsers = onlineUsers;
        this.thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {

    }
}
