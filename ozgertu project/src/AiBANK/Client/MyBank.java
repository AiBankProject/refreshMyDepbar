package AiBANK.Client;

import AiBANK.Client.Template.MyButton;
import AiBANK.Client.Template.MyLabel;
import AiBANK.Client.Template.MyLabel2;
import AiBANK.Client.Template.MyTextField;
import AiBANK.dataB.Transfer;
import AiBANK.dataB.User;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyBank extends Container {
    private MyButton backB,refB;
    private MyLabel availableL,numberCardL,yourl;
    private MyLabel2 yourT,availableT,numberCartT;


    private  BossFrame frame=null;
    public MyBank(BossFrame frame){
        this.frame=frame;
        setSize(800, 600);



        refB=new MyButton("refresh",350,350);
        add(refB);
        refB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ansBal();

            }
        });

        backB=new MyButton("back",50,400);
        add(backB);
        backB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.myBank.setVisible(false);
                frame.menuPage.setVisible(true);

            }
        });


        yourl=new MyLabel("Your User: ",100,100);
        add(yourl);

        availableL=new MyLabel("Balance:",100,200);
        add(availableL);

        numberCardL=new MyLabel("Number Card:",100,300);
        add(numberCardL);

        yourT=new MyLabel2("",220,100);
        add(yourT);

        availableT=new MyLabel2("",220,200);
        add(availableT);

        numberCartT=new MyLabel2("",220,300);
        add(numberCartT);



    }




    public  void getCurrentUserDanny(){
        yourT.setText(frame.currentUser.getName());
        availableT.setText(String.valueOf(frame.currentUser.getBalance()));
        numberCartT.setText(String.valueOf(frame.currentUser.getNumberCard()));
    }


    public void  ansBal(){
        int ansBal=frame.clientSocket.getAfterBal(frame.currentUser.getNumberCard());
        availableT.setText(String.valueOf(ansBal));
    }


}
