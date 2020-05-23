package AiBANK.Client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreditContainer extends Container {
    private  BossFrame frame=null;
    JLabel sumL,srok,stavka;
    JLabel stavkaL;
    JButton okC,oformit;
    JTextField sumT,srokT;
    JTextField sumMonth;
    public  CreditContainer(BossFrame frame){
        this.frame=frame;
        setSize(400,600);
        setLayout(null);
        sumL=new JLabel("I need the amounts:");
        sumL.setBounds(50,100,100,30);
        add(sumL);
        sumT=new JTextField();
        sumT.setBounds(50,170,100,30);
        add(sumT);
        srok=new JLabel("For a period:");
        srok.setBounds(200,100,100,30);
        add(srok);
        srokT=new JTextField();
        srokT.setBounds(200,170,100,30);
        add(srokT);
        stavkaL=new JLabel("15%");
        stavkaL.setBounds(320,170,50,30);
        add(stavkaL);
        okC=new JButton("ok");
        okC.setBounds(200,250,50,30);
        add(okC);
        okC.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int summa=Integer.parseInt(sumT.getText());
                int srokk=Integer.parseInt(srokT.getText());
                double s=(summa*1.15)/srokk;
                sumMonth.setText(Double.toString(s));
            }
        });
        sumMonth=new JTextField();
        sumMonth.setBounds(50,320,100,30);
        add(sumMonth);
        oformit=new JButton("Get a loan");
        oformit.setBounds(50,400,200,40);
        add(oformit);
        oformit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

    }
}