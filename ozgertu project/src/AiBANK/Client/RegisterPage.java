package AiBANK.Client;

import AiBANK.Client.Template.MyButton;
import AiBANK.Client.Template.MyLabel;
import AiBANK.Client.Template.MyPasswordField;
import AiBANK.Client.Template.MyTextField;
import AiBANK.dataB.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterPage extends Container {
    private MyLabel nl, pl, ll,numl,cvcl;
    private MyTextField ntf, ltf,numtf,cvctf;
    private MyPasswordField ptf;
    private MyButton regb,back;
    private BossFrame frame = null;

    public RegisterPage(BossFrame frame){
        this.frame = frame;

        setSize(600, 600);
        setBackground(Color.white);

        nl = new MyLabel("name: ", 50, 50);
        add(nl);
        ntf = new MyTextField(150, 50);
        add(ntf);
        numl=new MyLabel("numberCard: ",50,100);
        add(numl);
        numtf=new MyTextField(150,100);
        add(numtf);
        cvcl=new MyLabel("cvc: ",50,150);
        add(cvcl);
        cvctf=new MyTextField(150,150);
        add(cvctf);
        ll = new MyLabel("login: ", 50, 200);
        add(ll);
        ltf = new MyTextField(150, 200);
        add(ltf);
        pl = new MyLabel("password: ", 50, 250);
        add(pl);
        ptf = new MyPasswordField(150, 250);
        add(ptf);
        back=new MyButton("back",150,400);
        add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.regPage.setVisible(false);
                frame.helloPage.setVisible(true);
            }
        });


        regb = new MyButton("Register", 150, 350);
        add(regb);

        regb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(ntf.getText().isEmpty() || ltf.getText().isEmpty() || ptf.getText().isEmpty()){
                    JOptionPane.showMessageDialog(frame, "Fill all fields");
                }
                else if(ltf.getText().length()<8||ptf.getText().length()<8){
                    JOptionPane.showMessageDialog(frame, "At least 8 symbols");

                }
                else{
                    User u = new User();
                    u.setLogin(ltf.getText());
                    u.setName(ntf.getText());
                    u.setPassword(ptf.getText());
                    u.setNumberCard(Integer.parseInt(numtf.getText()));
                    u.setCvc(Integer.parseInt(cvctf.getText()));

                    boolean registered = frame.clientSocket.toRegister(u);
                    if(registered == true){
                        JOptionPane.showMessageDialog(frame, "You are registered");
                        ntf.setText("");
                        ltf.setText("");
                        ptf.setText("");
                        numtf.setText("");
                        cvctf.setText("");

                        frame.regPage.setVisible(false);
                        frame.logPage.setVisible(true);
                    }
                }
            }
        });
    }
}
