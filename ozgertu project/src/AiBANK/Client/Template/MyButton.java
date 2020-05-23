package AiBANK.Client.Template;

import javax.swing.*;
import java.awt.*;

public class MyButton extends JButton {

    public MyButton(String text, int x, int y){
        setText(text);
        setForeground(Color.darkGray);
        setBackground(Color.lightGray);
        setSize(100, 30);
        setLocation(x, y);
        setFont(new Font("Arial", Font.BOLD, 12));
    }
}
