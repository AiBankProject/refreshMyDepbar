package AiBANK.Client;

import AiBANK.Client.Net.ClientSocket;
import AiBANK.dataB.User;

import javax.swing.*;

public class BossFrame extends JFrame {
    public HelloPage helloPage;
    public RegisterPage regPage;
    public LoginPage logPage;
    public ClientSocket clientSocket;
    public MenuContainer menuPage;
    public MyBank myBank;
    public TransferPage transferPage;
    public  CreditPage creditPage;
    public  CreditContainer creditContainer;
    public DepozitPage depozitPage;
    public HistoryPage historyPage;


    public User currentUser = null;

    public BossFrame(){
        clientSocket = new ClientSocket();

        setBounds(100,50,600, 600);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        helloPage=new HelloPage(this);
        add(helloPage);
        helloPage.setVisible(true);

        regPage = new RegisterPage(this);
        add(regPage);
        regPage.setVisible(false);

        logPage = new LoginPage(this);
        add(logPage);
        logPage.setVisible(false);

        menuPage = new MenuContainer(this);
        add(menuPage);
        menuPage.setVisible(false);

        myBank = new MyBank(this);
        add(myBank);
        myBank.setVisible(false);

        transferPage = new TransferPage(this);
        add(transferPage);
        transferPage.setVisible(false);

        creditPage = new CreditPage(this);
        add(creditPage);
        creditPage.setVisible(false);

        creditContainer = new CreditContainer(this);
        add(creditContainer);
        creditContainer.setVisible(false);

        depozitPage = new DepozitPage(this);
        add(depozitPage);
        depozitPage.setVisible(false);

        historyPage = new HistoryPage(this);
        add(historyPage);
        historyPage.setVisible(false);

    }
}
