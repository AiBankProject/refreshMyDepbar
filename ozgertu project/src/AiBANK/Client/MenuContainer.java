package AiBANK.Client;

import AiBANK.Client.Template.MyButton;
import AiBANK.dataB.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class MenuContainer extends Container {
    private MyButton mybankB, transB,exitB,credB,depoB,historyB;
    private  BossFrame frame=null;

    public MenuContainer(BossFrame frame){
        this.frame=frame;
        setSize(600, 600);
        setBackground(Color.white);
        JLabel label = new JLabel("");
        label.setBounds(-38, 0, 420, 275);
        label.setVerticalAlignment(SwingConstants.TOP);
        label.setIcon(new ImageIcon(BossFrame.class.getResource("/AiBank/Client/Aib.png")));
        add(label);
        JLabel lblNewLabel = new JLabel("AiBank");
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblNewLabel.setForeground(new Color(16, 17, 17));
        lblNewLabel.setBackground(new Color(56, 27, 31));
        lblNewLabel.setBounds(139, 305, 84, 27);
        JLabel txt = new JLabel("...We've been expecting you...");
        txt.setHorizontalAlignment(SwingConstants.CENTER);
        txt.setForeground(new Color(16, 17, 17));
        txt.setBackground(new Color(56, 27, 31));
        txt.setFont(new Font("Tahoma", Font.PLAIN, 13));
        txt.setBounds(80, 343, 180, 27);
        add(txt);
        mybankB = new MyButton("My Bank",420,80);
        add(mybankB);
        mybankB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.menuPage.setVisible(false);
                frame.myBank.setVisible(true);

                frame.myBank.getCurrentUserDanny();
            }
        });
        transB = new MyButton("Transfer",420,150);
        add(transB);
        transB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.menuPage.setVisible(false);
                frame.transferPage.setVisible(true);
            }
        });

        historyB=new MyButton("history",420,220);
        add(historyB);
        historyB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.menuPage.setVisible(false);
                frame.historyPage.setVisible(true);
                frame.historyPage.updateTable2();
            }
        });

        depoB = new MyButton("Deposit",420,290);
        add(depoB);
        depoB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.menuPage.setVisible(false);
                frame.depozitPage.setVisible(true);
            }
        });


        credB = new MyButton("Credit",420,360);
        add(credB);
        credB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.menuPage.setVisible(false);
                frame.creditPage.setVisible(true);
            }
        });
        exitB = new MyButton("Log out",420,500);
        add(exitB);
        exitB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.currentUser=null;
                //owistka transfer usera
                frame.menuPage.setVisible(false);
                frame.logPage.setVisible(true);
            }
        });
        JLabel lbl_close = new JLabel("X");
        lbl_close.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {

                System.exit(0);
            }
        });
        lbl_close.setHorizontalAlignment(SwingConstants.CENTER);
        lbl_close.setForeground(new Color(241, 57, 83));
        lbl_close.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lbl_close.setBounds(555, 0, 37, 27);
        add(lbl_close);

    }





}