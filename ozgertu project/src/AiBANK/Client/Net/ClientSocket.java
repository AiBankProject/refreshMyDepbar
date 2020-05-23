package AiBANK.Client.Net;

import AiBANK.dataB.Deposit;
import AiBANK.dataB.Packet;
import AiBANK.dataB.User;
import AiBANK.dataB.Transfer;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

public class ClientSocket {
    private Socket socket = null;
    private ObjectOutputStream oos = null;
    private ObjectInputStream ois = null;

    public ClientSocket(){
        try{
            socket = new Socket("localhost", 1400);
            oos = new ObjectOutputStream(socket.getOutputStream());
            ois = new ObjectInputStream(socket.getInputStream());
        }
        catch(Exception e){e.printStackTrace();}
    }
    public void disconnect(){
        try{
            oos.close();
            ois.close();
            socket.close();
        }
        catch(Exception e){e.printStackTrace();}
    }

    public boolean toRegister(User user){
        String code = "";

        try{
            Packet packet = new Packet("REG", user);
            oos.writeObject(packet);

            Packet answerPacket = (Packet)ois.readObject();
            code = answerPacket.getCode();
        }
        catch(Exception e){e.printStackTrace();}

        if(code.equals("SUCCESS"))
            return true;

        return false;
    }
    public User toLogin(User user){
        User authUser = null;
        try{
            Packet packet = new Packet("LOGIN", user);
            oos.writeObject(packet);

            Packet answerPacket = (Packet)ois.readObject();
            authUser = (User)answerPacket.getData();

        }
        catch(Exception e){e.printStackTrace();}

        return authUser;
    }


    public ArrayList<Transfer> getAllUserTransfers(int userN){
        ArrayList<Transfer> transfers=null;
        Packet packet=new Packet("LIST_TRANSFERS", userN);
        try {
            oos.writeObject(packet);
            Packet response=(Packet)ois.readObject();
            transfers=(ArrayList<Transfer>)response.getData();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return transfers;
    }


    public boolean totransfer(Transfer transfer){
        String code = "";
        Packet packet=new Packet("transfer", transfer);
        try {
            oos.writeObject(packet);
            Packet answerPacket = (Packet)ois.readObject();
            code = answerPacket.getCode();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(code.equals("SUCCESS"))
            return true;

        return false;
    }

    public boolean toDeposit(Deposit deposit){
        String code = "";
        Packet packet=new Packet("TO_DEPOSIT", deposit);
        try {
            oos.writeObject(packet);

            Packet answerPacket = (Packet)ois.readObject();
            code = answerPacket.getCode();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(code.equals("SUCCESS"))
            return true;

        return false;
    }

    public int getAfterBal(int userN){
        int answer=0;
        Packet packet=new Packet("LIST_UsAfBa", userN);
        try {
            oos.writeObject(packet);

            Packet response=(Packet)ois.readObject();
            answer=(int)response.getData();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return answer;
    }

}
