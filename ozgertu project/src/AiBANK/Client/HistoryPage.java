package AiBANK.Client;

import AiBANK.Client.Template.MyButton;
import AiBANK.Client.Template.MyTable;
import AiBANK.dataB.Transfer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class HistoryPage extends Container {
    private  BossFrame frame=null;
    private MyButton backB;

    private MyTable table;
    private JScrollPane pane;
    private Object columns[] = {"To whom?", "How many?", "Date"};

    private ArrayList<Transfer> transfers = null;

    public  HistoryPage(BossFrame frame){
        this.frame=frame;
        setSize(800,600);

        table = new MyTable(columns);
        pane = new JScrollPane(table);
        pane.setBounds(0, 0, 600, 400);
        add(pane);
//        updateTable();

        backB=new MyButton("back",50,450);
        add(backB);
        backB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.historyPage.setVisible(false);
                frame.menuPage.setVisible(true);

            }
        });
    }


    public void updateTable2(){
        while (table.model.getRowCount() > 0){
            table.model.removeRow(0);
        }


        transfers = frame.clientSocket.getAllUserTransfers(frame.currentUser.getNumberCard());

        for(Transfer ub : transfers){
            table.model.addRow(new Object[]{ub.getTowhom(), ub.getHowmany(), ub.getDate()});
        }
    }

}