package AiBANK.Client;

import AiBANK.Client.Template.MyButton;
import AiBANK.Client.Template.MyLabel;
import AiBANK.Client.Template.MyTextField;
import AiBANK.dataB.Deposit;
import AiBANK.dataB.Transfer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DepozitPage extends Container {
    private MyButton backB,okB;
    private MyLabel skolkoL,stavkaL,monthL,persent;
    private MyTextField skolkoT,monthT;



    private  BossFrame frame=null;
    public DepozitPage(BossFrame frame){
        this.frame=frame;
        setSize(800,600);


        skolkoL=new MyLabel("skolko: ",100,50);
        add(skolkoL);

        stavkaL=new MyLabel("stavka%: ",100,100);
        add(stavkaL);
        persent=new MyLabel("12",200,100);
        add(persent);

        monthL=new MyLabel("month: ",100,150);
        add(monthL);

        skolkoT=new MyTextField(200,50);
        add(skolkoT);

        monthT=new MyTextField(200,150);
        add(monthT);

        okB=new MyButton("OK",300,200);
        add(okB);

        backB=new MyButton("back",300,420);
        add(backB);
        backB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.depozitPage.setVisible(false);
                frame.menuPage.setVisible(true);

            }
        });


        okB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(skolkoT.getText().isEmpty() || monthT.getText().isEmpty()){
                    JOptionPane.showMessageDialog(frame, "Zapolni!!!!");
                }

                if (Integer.parseInt(skolkoT.getText())>frame.currentUser.getBalance()){
                    JOptionPane.showMessageDialog(frame, "Dengi ne xbataet");

                }

                if (Integer.parseInt(skolkoT.getText())>12){
                    JOptionPane.showMessageDialog(frame, "tolko na 6 i 12month");

                }


                else {
                    String who = frame.currentUser.getName();
                    int sum = Integer.parseInt(skolkoT.getText());
                    int percent = Integer.parseInt(persent.getText());
                    int month = Integer.parseInt(monthT.getText());


                    Deposit deposit = new Deposit(who,sum,percent,month,null);

                    boolean deposited = frame.clientSocket.toDeposit(deposit);

                    if (deposited == true) {
                        JOptionPane.showMessageDialog(frame, "Successfully deposited");
                        skolkoT.setText("");
                        monthT.setText("");


                    }




                }



            }
        });
    }
}