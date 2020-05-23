package AiBANK.Client;

import AiBANK.Client.BossFrame;
import AiBANK.Client.Template.MyButton;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class HelloPage extends Container {
    private JButton logB,regB;
    private BossFrame frame = null;
    private JPanel contentPane;
    public HelloPage(BossFrame frame) {
        this.frame=frame;
        setSize(800,600);
        JLabel lblNewLabel = new JLabel("AiBank");
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblNewLabel.setForeground(new Color(16, 17, 17));
        lblNewLabel.setBackground(new Color(56, 27, 31));
        lblNewLabel.setBounds(139, 305, 84, 27);
        add(lblNewLabel);
        JLabel label = new JLabel("");
        label.setBounds(-38, 0, 420, 275);
        label.setVerticalAlignment(SwingConstants.TOP);
        label.setIcon(new ImageIcon(BossFrame.class.getResource("/AiBank/Client/Aib.png")));
        add(label);

        JLabel txt = new JLabel("...We've been expecting you...");
        txt.setHorizontalAlignment(SwingConstants.CENTER);
        txt.setForeground(new Color(16, 17, 17));
        txt.setBackground(new Color(56, 27, 31));
        txt.setFont(new Font("Tahoma", Font.PLAIN, 13));
        txt.setBounds(80, 343, 180, 27);
        add(txt);
        logB = new JButton("log in");
        logB.setBounds(395, 135, 133, 30);
        logB.setForeground(Color.WHITE);
        logB.setBackground(new Color(56, 27, 31));
        add(logB);
//        regB=new MyButton("Register",350,250);
//        add(regB);
        regB = new JButton("Register");
        regB.setBounds(395, 205, 133, 30);
        regB.setForeground(Color.WHITE);
        regB.setBackground(new Color(56, 27, 31));
        add(regB);

        logB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.helloPage.setVisible(false);
                frame.logPage.setVisible(true);
            }
        });

        regB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.helloPage.setVisible(false);
                frame.regPage.setVisible(true);
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
