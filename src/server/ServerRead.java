package server;

import java.util.ArrayList;
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
            while (true) {
                String str = readString();
                int command = Integer.parseInt(str);

                switch (command) {
                    case 1:
                        sendInvite();
                        break;
                    case 2:
                        inviteAccepted();
                        break;
                    case 3:
                        sendPartyList();
                        break;
                }
            }
        } catch (Exception e) {
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
                System.out.println("Server Sent Invite From " + userName);
            }
        } catch (Exception e) {
            System.out.println("While Sending Invite(Server): " + e);
        }
    }

    private void inviteAccepted() {         //This thread's client accepted the invite
        String inviteName = readString();
        Info invitee = onlineUsers.get(inviteName); //The one who invited this client
        try {
            invitee.oos.writeObject("5");
            invitee.oos.writeObject(userName);
        } catch (Exception e) {
            System.out.println("In inviteAccepted " + e);
            e.printStackTrace();
        }
    }

    private void sendPartyList() {
        String s;
        try {
            ArrayList<String> partyMembers = new ArrayList<>();
            while (true) {
                Object o = info.ois.readObject();
                if (o instanceof String) {
                    s = (String) o;
                    if (s.equals("0"))
                        break;
                    partyMembers.add(s);
                }
            }

            int totalMembers = partyMembers.size();
            for (int i = 0; i < totalMembers; i++) {
                Info members = onlineUsers.get(partyMembers.get(i));
                members.oos.writeObject("6");
                for (String mem : partyMembers)
                    members.oos.writeObject(mem);
                members.oos.writeObject("0");

            }
        } catch (Exception e) {
            System.out.println("In inviteAccepted " + e);
            e.printStackTrace();
        }
    }
}
