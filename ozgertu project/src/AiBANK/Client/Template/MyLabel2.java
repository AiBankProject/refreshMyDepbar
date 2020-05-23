package AiBANK.Client.Template;

import javax.swing.*;
import java.awt.*;

public class MyLabel2 extends JLabel {
    public MyLabel2(String text, int x, int y){
        setText(text);
        setForeground(Color.darkGray);
        setSize(100, 30);
        setLocation(x, y);
        setFont(new Font("SANS_SERIF", Font.BOLD, 16));
    }
}
