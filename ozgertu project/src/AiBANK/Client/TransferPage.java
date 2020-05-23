package AiBANK.Client;

import AiBANK.Client.Template.MyButton;
import AiBANK.Client.Template.MyLabel;
import AiBANK.Client.Template.MyTextField;
import AiBANK.dataB.Transfer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TransferPage extends Container {

    private MyButton transfB,backB;
    private MyLabel  toL,howL;
    private MyTextField toT,howT;
    private  BossFrame frame=null;

    public TransferPage(BossFrame frame){
        this.frame=frame;
        setSize(800,600);

        toL=new MyLabel("To whom?",100,200);
        add(toL);
        toT=new MyTextField(300,200);
        add(toT);


        howL=new MyLabel("How many?",100,250);
        add(howL);
        howT=new MyTextField(300,250);
        add(howT);

        transfB=new MyButton("translate",300,300);
        add(transfB);

        backB=new MyButton("back",200,400);
        add(backB);
        backB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.transferPage.setVisible(false);
                frame.menuPage.setVisible(true);

            }
        });



        transfB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(toT.getText().isEmpty() || howT.getText().isEmpty()){
                    JOptionPane.showMessageDialog(frame, "Fill all fields");
                }

                if (toT.getText().equalsIgnoreCase(String.valueOf(frame.currentUser.getNumberCard()))){
                    JOptionPane.showMessageDialog(frame, "Nelzia perevodit sevzia");

                }
                if (Integer.parseInt(howT.getText())>frame.currentUser.getBalance()){
                    JOptionPane.showMessageDialog(frame, "Dengi ne xbataet");

                }


                else {
                    int who = frame.currentUser.getNumberCard();
                    int towhom = Integer.parseInt(toT.getText());
                    int howmany = Integer.parseInt(howT.getText());

                    Transfer transfer = new Transfer(who, towhom, howmany, null);

                    boolean transfered = frame.clientSocket.totransfer(transfer);

                    if (transfered == true) {
                        JOptionPane.showMessageDialog(frame, "Successfully translated");
                        toT.setText("");
                        howT.setText("");


                    }
                }

            }
        });







    }
}