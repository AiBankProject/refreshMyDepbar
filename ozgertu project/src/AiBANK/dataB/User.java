package AiBANK.dataB;

import java.io.Serializable;

public class User implements Serializable {
    private Long id;
    private String login;
    private String password;
    private String name;
    private String role;
    private int numberCard;
    private  int cvc;
    private  int balance;

    public User() {}
    public User(Long id, String login, String password, String name, String role) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.name = name;
        this.role = role;
    }

    public User(Long id, String login, String password, String name, String role, int numberCard, int cvc, int balance) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.name = name;
        this.role = role;
        this.numberCard = numberCard;
        this.cvc = cvc;
        this.balance = balance;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getLogin() {
        return login;
    }
    public void setLogin(String login) {
        this.login = login;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }
    public int getNumberCard() {
        return numberCard;
    }
    public void setNumberCard(int numberCard) {
        this.numberCard = numberCard;
    }
    public int getCvc() {
        return cvc;
    }
    public void setCvc(int cvc) {
        this.cvc = cvc;
    }
    public int getBalance() {
        return balance;
    }
    public void setBalance(int balance) {
        this.balance = balance;
    }

//    @Override
//    public String toString() {
//        return "id=" + id +
//                ", login='" + login + '\'' +
//                ", password='" + password + '\'' +
//                ", name='" + name + '\'';
//    }


    @Override
    public String toString() {
        return
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", role='" + role + '\'' +
                ", numberCard=" + numberCard +
                ", cvc=" + cvc +
                ", balance=" + balance;
    }
}
