package client;

import util.NetworkUtil;

import java.util.ArrayList;

public class OnlinePlayersThread implements Runnable {
    private NetworkUtil nc;
    private Thread thread;
    private String clientName;
    private ArrayList<String> onlinePlayers;

    public OnlinePlayersThread(NetworkUtil nc, String name) {
        this.nc = nc;
        this.clientName = name;
        this.thread = new Thread(this);
        thread.start();
        onlinePlayers = new ArrayList<>();
    }

    public void run() {
        try {
            while(true) {
                Object object = nc.read();
                if (object != null && object instanceof String) {
                    String name = (String) object;
                    onlinePlayers.add(name);
                }
            }
        } catch (Exception e) {
            System.out.println("In OnlinePlayersThread: " + e);
        }
    }
}
