package AiBANK.dataB;

import java.io.Serializable;
import java.util.Date;

public class Deposit implements Serializable {
    private  String who;
    private int sum;
    private  int percent;
    private  int month;
    private Date date;

    public Deposit() {
    }

    public Deposit(String who, int sum, int percent, int month) {
        this.who = who;
        this.sum = sum;
        this.percent = percent;
        this.month = month;
    }

    public Deposit(String who, int sum, int percent, int month, Date date) {
        this.who = who;
        this.sum = sum;
        this.percent = percent;
        this.month = month;
        this.date = date;
    }

    public String getWho() {
        return who;
    }

    public int getSum() {
        return sum;
    }

    public int getPercent() {
        return percent;
    }

    public int getMonth() {
        return month;
    }

    public void setWho(String who) {
        this.who = who;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public void setPercent(int percent) {
        this.percent = percent;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return
                "who='" + who + '\'' +
                ", sum=" + sum +
                ", percent=" + percent +
                ", month=" + month +
                ", date=" + date;
    }
}
