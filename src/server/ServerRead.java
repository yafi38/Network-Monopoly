package server;

import java.io.IOException;
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
                    case 4:
                        createGame();
                        break;
                    case 5:
                        diceRoll();
                        break;
                    case 6:
                        getAndSendNewLandInfo();
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
            e.printStackTrace();
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
                //System.out.println("Server Sent Invite From " + userName);
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
        }
    }

    private void sendPartyList() {
        String s;
        try {
            ArrayList<String> pm = new ArrayList<>();   //Get's party list from invitee and sends them to all other members
            while (true) {
                Object o = info.ois.readObject();
                if (o instanceof String) {
                    s = (String) o;
                    if (s.equals("0"))
                        break;
                    pm.add(s);
                }
            }

            int totalMembers = pm.size();
            for (int i = 0; i < totalMembers; i++) {
                Info members = onlineUsers.get(pm.get(i));
                members.oos.writeObject("6");
                for (String mem : pm)
                    members.oos.writeObject(mem);
                members.oos.writeObject("0");

            }
        } catch (Exception e) {
            System.out.println("In inviteAccepted " + e);
            //e.printStackTrace();
        }
    }

    private void createGame() {
        Server.partyMembers = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            String s = readString();
            Server.partyMembers.add(s);
        }

        try {
            for (int i = 1; i < 4; i++) {
                Info tempInfo = onlineUsers.get(Server.partyMembers.get(i));
                tempInfo.oos.writeObject("7");
                tempInfo.oos.writeObject("" + i);
            }
        } catch (IOException e) {
            System.out.println("In Create Game Server " + e);
        }
    }

    private void diceRoll() {
        try {
            //int x;
            String str = readString();
            //x = Integer.parseInt(str);
            //System.out.println("dice roll got from " + userName);

            for (String s : Server.partyMembers) {
                if (!s.equals(userName)) {
                    //System.out.println("Sending dice roll to " + s);
                    Info tempInfo = onlineUsers.get(s);
                    tempInfo.oos.writeObject("8");
                    tempInfo.oos.writeObject(str);
                }
            }
        } catch (IOException e) {
            System.out.println("In Server Dice Roll: " + e);
        }
    }

    private void getAndSendNewLandInfo() {
        String sender = readString();
        int senderNum = Integer.parseInt(sender);
        String landName = readString();
        Double price = 0.0;
        try {
            Object o = info.ois.readObject();
            if(o instanceof Double)
                price = (Double) o;
            for(int i=0; i<4; i++) {
                if(i != senderNum) {
                    Info tempInfo = onlineUsers.get(Server.partyMembers.get(i));
                    tempInfo.oos.writeObject("9");
                    tempInfo.oos.writeObject(sender);
                    tempInfo.oos.writeObject(landName);
                    tempInfo.oos.writeObject(price);
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("In get and send new land info: " + e);
        }
    }
}
