import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.io.IOException;
import java.nio.file.Paths;

public class Card {

    private int number;
    private String face;
    private int value;

    public Card(int number,String face,int value) {
        this.number =number;
        this.face = face;
        this.value = value;
    }
    public void setValue(int g) {value=g;}
    public int getNumber() {return number;}
    public String getFace() {return face;}
    public int getValue() {return value;}
    public String getInfo() {
        if (number==11) return "J"+face;
        if (number==12) return "Q"+face;
        if (number==13) return "K"+face;
        else return number+face;
    }

    public static ArrayList<Card> createDeck(String s) {
        ArrayList<Card> cards = new ArrayList<Card>();
        int h = 0;
        int k = 1;
        for(int i = 0;i<=51;i++) {
            if (h==0) {
                cards.add(new Card(k,"S",1));
            }
            if (h==1) {
                cards.add( new Card(k,"C",1));
            }
            if (h==2) {
                cards.add(new Card(k,"H",1));
            }
            if (h==3) {
                cards.add(new Card(k,"D",1));
                h=-1;
                k++;
            }
            h++;
        }
        try {
            Scanner values = new Scanner(Paths.get(s));
            String[] t = new String[3];
            String[] c;
            String[] p;
            while (values.hasNextLine()) {
                p = values.nextLine().split(" ");
                c = p[0].split("");
                t[0] = c[0];
                t[1] = c[1];
                t[2] = p[1];
                if (t[0]=="*") {
                    cards.set(cards.indexOf(new Card(Integer.parseInt(t[1]),"S",1)),new Card(Integer.parseInt(t[1]),"S",Integer.parseInt(t[2])));
                    cards.set(cards.indexOf(new Card(Integer.parseInt(t[1]),"C",1)),new Card(Integer.parseInt(t[1]),"C",Integer.parseInt(t[2])));
                    cards.set(cards.indexOf(new Card(Integer.parseInt(t[1]),"H",1)),new Card(Integer.parseInt(t[1]),"H",Integer.parseInt(t[2])));
                    cards.set(cards.indexOf(new Card(Integer.parseInt(t[1]),"D",1)),new Card(Integer.parseInt(t[1]),"D",Integer.parseInt(t[2])));
                }
                else if (t[0]=="S") {
                    if (t[1]=="*") {
                        for (int i=1;i<=13;i++) {
                            cards.set(cards.indexOf(new Card(i,"S",1)),new Card(i,"S",Integer.parseInt(t[2])));
                        }
                    }
                    else cards.set(cards.indexOf(new Card(Integer.parseInt(t[1]),t[0],1)),new Card(Integer.parseInt(t[1]),t[0],Integer.parseInt(t[2])));
                }
                else if (t[0]=="C") {
                    if (t[1]=="*") {
                        for (int i=0;i<=13;i++) {
                            cards.set(cards.indexOf(new Card(i,"C",1)),new Card(i,"C",Integer.parseInt(t[2])));
                        }
                    }
                    else cards.set(cards.indexOf(new Card(Integer.parseInt(t[1]),t[0],1)),new Card(Integer.parseInt(t[1]),t[0],Integer.parseInt(t[2])));
                }
                else if (t[0]=="H") {
                    if (t[1]=="*") {
                        for (int i=0;i<=13;i++) {
                            cards.set(cards.indexOf(new Card(i,"H",1)),new Card(i,"H",Integer.parseInt(t[2])));
                        }
                    }
                    else cards.set(cards.indexOf(new Card(Integer.parseInt(t[1]),t[0],1)),new Card(Integer.parseInt(t[1]),t[0],Integer.parseInt(t[2])));
                }
                else if (t[0]=="D") {
                    if (t[1]=="*") {
                        for (int i=0;i<=13;i++) {
                            cards.set(cards.indexOf(new Card(i,"D",1)),new Card(i,"D",Integer.parseInt(t[2])));
                        }
                    }
                    else cards.set(cards.indexOf(new Card(Integer.parseInt(t[1]),t[0],1)),new Card(Integer.parseInt(t[1]),t[0],Integer.parseInt(t[2])));
                }
            }
        }
        catch (IOException exception) {
            System.out.println("error coudnt get file");
        }
        return cards;
    }

    public static ArrayList<Card> cutDeck(ArrayList<Card> x,Scanner s) {
        int b=-1;
        String a;
        while (true) {
            System.out.print("select where to cut (1-52)=> ");
            try {
                a = s.next();
                b = Integer.parseInt(a);
            }
            catch (Exception e) {
            }
            finally {
                if (b<52&&b>0) {
                    break;
                }
                System.out.println("wrong number");
            }
        }
        s = null;
        ArrayList<Card> y = new ArrayList<Card>();
        for (int i = 0;i<=51;i++){
            if (b+i<=51) {
                y.add(x.get(i+b));
            }
            else {
                y.add(x.get(i+b-52));
            }
        }
        return (y);
    }

    public static ArrayList<Card> shuffleDeck(ArrayList<Card> c) {
        Collections.shuffle(c);
        return c;
    }
}
