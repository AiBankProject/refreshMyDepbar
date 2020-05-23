package AiBANK.Client;

import AiBANK.Client.Template.MyButton;
import AiBANK.Client.Template.MyLabel;
import AiBANK.Client.Template.MyTextField;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreditPage  extends Container {
    private MyButton okB,backB;
    private MyTextField sumT,srokT;
    private MyLabel sumL,srokL;


    private  BossFrame frame=null;
    public CreditPage(BossFrame frame){
        this.frame=frame;
        setSize(800,600);

        sumL=new MyLabel("skolko: ",100,100);
        add(sumL);

        srokL=new MyLabel("Srok: ",100,150);
        add(srokL);

        sumT=new MyTextField(200,100);
        add(sumT);

        srokT=new MyTextField(200,150);
        add(srokT);



        okB=new MyButton("to take",200,200);
        add(okB);
        okB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        backB=new MyButton("back",200,420);
        add(backB);
        backB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.creditPage.setVisible(false);
                frame.menuPage.setVisible(true);

            }
        });


    }
}