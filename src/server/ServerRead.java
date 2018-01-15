package server;

import java.util.HashMap;

public class ServerRead implements Runnable {
    private String userName;
    private Info info;
    private Thread thread;
    private HashMap<String, Info> onlineUsers;

    ServerRead(String userName, Info info, HashMap<String, Info> onlineUsers) {
        this.userName = userName;
        this.info = info;
        this.onlineUsers = onlineUsers;
        this.thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {
        try {
            while(true) {
                String str = readString();
                int command = Integer.parseInt(str);

                switch(command) {
                    case 1:
                        sendInvite();
                }
            }
        } catch(Exception e)  {
            System.out.println("In Server Read:" + e);
        }
    }

    private String readString() {
        String s = null;
        try {
            Object o;
            o = info.ois.readObject();
            if (o != null && o instanceof String) {
                s = (String) o;
            }
        } catch (Exception e) {
            System.out.println("While Reading String: " + e);
        }
        return s;
    }

    void sendInvite() {
        String inviteName = readString();
        Info inviteInfo = onlineUsers.get(inviteName);
        try {
            if (inviteInfo != null) {
                inviteInfo.oos.writeObject("4");
                inviteInfo.oos.writeObject(userName);
            }
        } catch(Exception e) {
            System.out.println("While Sending Invite(Server): " + e);
        }
    }
}
