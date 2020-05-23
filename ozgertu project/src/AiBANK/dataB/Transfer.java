package AiBANK.dataB;

import java.io.Serializable;
import java.util.Date;

public class Transfer implements Serializable {
    private  int who;
    private  int towhom;
    private  int howmany;
    private Date date;


    public Transfer() {
    }

    public Transfer(int who, int towhom, int howmany, Date date) {
        this.who = who;
        this.towhom = towhom;
        this.howmany = howmany;
        this.date = date;
    }

    public Transfer(int towhom, int howmany, Date date) {
        this.towhom = towhom;
        this.howmany = howmany;
        this.date = date;
    }

    public Transfer(int towhom, int howmany) {
        this.towhom = towhom;
        this.howmany = howmany;
    }

    public int getWho() {
        return who;
    }

    public void setWho(int who) {
        this.who = who;
    }

    public int getTowhom() {
        return towhom;
    }

    public int getHowmany() {
        return howmany;
    }

    public Date getDate() {
        return date;
    }

    public void setTowhom(int towhom) {
        this.towhom = towhom;
    }

    public void setHowmany(int howmany) {
        this.howmany = howmany;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "towhom=" + towhom +
                ", howmany=" + howmany +
                ", date=" + date;
    }
}
