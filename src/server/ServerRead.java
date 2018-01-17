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
                        break;
                    case 2:
                        inviteAccepted();
                        break;
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
            s = (String) o;
        } catch (Exception e) {
            System.out.println("While Reading String: " + e);
        }
        return s;
    }

    private void sendInvite() {
        String inviteName = readString();
        Info inviteInfo = onlineUsers.get(inviteName);
        try {
            if (inviteInfo != null) {
                inviteInfo.oos.writeObject("4");
                inviteInfo.oos.writeObject(userName);
                System.out.println("Server Sent Invite");
            }
        } catch(Exception e) {
            System.out.println("While Sending Invite(Server): " + e);
        }
    }

    private void inviteAccepted() {         //This thread's client accepted the invite
        String inviteName = readString();   //The one who invited this client
        Info inviteInfo = onlineUsers.get(inviteName);
        try {
            if(inviteInfo != null) {
                inviteInfo.oos.writeObject("5");
                inviteInfo.oos.writeObject(userName);
                String[] partyMembers = (String[]) inviteInfo.ois.readObject();
                info.oos.writeObject("6");
                info.oos.writeObject(partyMembers);
            }
        } catch (Exception e) {
            System.out.println("In inviteAccepted " + e);
        }
    }
}
