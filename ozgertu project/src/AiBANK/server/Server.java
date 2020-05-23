package AiBANK.server;

import AiBANK.dataB.Deposit;
import AiBANK.dataB.User;
import AiBANK.dataB.Transfer;

import java.net.ServerSocket;
import java.net.Socket;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;

public class Server {
    public static Connection connection;

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db?useUnicode=true&serverTimezone=UTC","root", "");
            ServerSocket ss = new ServerSocket(1400);

            while(true){
                Socket s = ss.accept();
                ServerThread st = new ServerThread(s);
                st.start();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean registerUser(User user){
        int rows = 0;

        try{
            PreparedStatement statement = connection.prepareStatement("INSERT INTO users (id, login, password, name, role,numberCard,cvc,balance) VALUES (null, ?, ?, ?, ?,?,?,?)");
            statement.setString(1, user.getLogin());
            statement.setString(2, user.getPassword());
            statement.setString(3, user.getName());
            statement.setString(4, "USER");
            statement.setInt(5,user.getNumberCard());
            statement.setInt(6,user.getCvc());
            statement.setInt(7,0);

            rows = statement.executeUpdate();
            statement.close();
        }
        catch(Exception e){e.printStackTrace();}

        if(rows == 1)
            return true;

        return false;
    }

    public static User loginUser(User user){
        User authUser = null;

        try{
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM users WHERE login = ? AND password = ?");
            statement.setString(1, user.getLogin());
            statement.setString(2, user.getPassword());

            ResultSet result = statement.executeQuery();

            if(result.next()){
                authUser = new User(
                        result.getLong("id"),
                        result.getString("login"),
                        result.getString("password"),
                        result.getString("name"),
                        result.getString("role"),
                        result.getInt("numberCard"),
                        result.getInt("cvc"),
                        result.getInt("balance")
                );
            }
            statement.close();
        }
        catch(Exception e){e.printStackTrace();}

        return authUser;

    }


    public static ArrayList<Transfer> getAllUserTransfers(int un){
        ArrayList<Transfer> userbooks=new ArrayList<>();
        try {
            PreparedStatement statement=connection.prepareStatement("SELECT * FROM transfer WHERE who=?");
            statement.setInt(1, un);
            ResultSet resultSet=statement.executeQuery();

            while(resultSet.next()){
                int towhom=resultSet.getInt("towhom");
                int howmany=resultSet.getInt("howmany");
                Date date=resultSet.getTimestamp("date");

                userbooks.add(new Transfer(towhom, howmany, date));
            }
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userbooks;
    }

    public static boolean totransfer(Transfer transfer){
        int rows=0;
        try{
            PreparedStatement statement = connection.prepareStatement("INSERT INTO transfer (who, towhom, howmany, date) VALUES (?, ?, ?, NOW())");
            statement.setInt(1, transfer.getWho());
            statement.setInt(2, transfer.getTowhom());
            statement.setInt(3, transfer.getHowmany());

            statement.executeUpdate();
            statement.close();



            statement = connection.prepareStatement("UPDATE users SET balance=balance-? WHERE numberCard=?");
            statement.setInt(1,transfer.getHowmany());
            statement.setInt(2, transfer.getWho());

            statement.executeUpdate();
            statement.close();

            statement = connection.prepareStatement("UPDATE users SET balance=balance+? WHERE numberCard=?");
            statement.setInt(1,transfer.getHowmany());
            statement.setInt(2, transfer.getTowhom());

            statement.executeUpdate();
            statement.close();


        }
        catch(Exception e){e.printStackTrace();}
        if(rows == 0)
            return true;

        return false;
    }


    public static boolean todeposit(Deposit deposit){
        int rows=0;
        try{
            PreparedStatement statement = connection.prepareStatement("INSERT INTO deposit (who,sum,percent,month,date) VALUES (?, ?, ?,?, NOW())");
            statement.setString(1, deposit.getWho());
            statement.setInt(2, deposit.getSum());
            statement.setInt(3, deposit.getPercent());
            statement.setInt(4, deposit.getMonth());

            statement.executeUpdate();
            statement.close();



//            statement = connection.prepareStatement("UPDATE users SET balance=balance-? WHERE numberCard=?");
//            statement.setInt(1,transfer.getHowmany());
//            statement.setInt(2, transfer.getWho());
//
//            statement.executeUpdate();
//            statement.close();
//
//            statement = connection.prepareStatement("UPDATE users SET balance=balance+? WHERE numberCard=?");
//            statement.setInt(1,transfer.getHowmany());
//            statement.setInt(2, transfer.getTowhom());
//
//            statement.executeUpdate();
//            statement.close();


        }
        catch(Exception e){e.printStackTrace();}
        if(rows == 0)
            return true;

        return false;
    }

    public static int getAfterBal(int un){
        int b= 0;
        try {
            PreparedStatement statement=connection.prepareStatement("SELECT * FROM users WHERE numberCard=?");
            statement.setInt(1, un);
            ResultSet resultSet=statement.executeQuery();

            while(resultSet.next()){
                int bal=resultSet.getInt("balance");


                b=bal;
            }
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return b ;
    }



}
