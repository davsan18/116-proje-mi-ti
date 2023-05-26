import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.io.IOException;
import java.nio.file.Paths;

public class Card extends java.lang.Object {

    private int number;
    private String face;
    private int value;

    public Card(int number,String face,int value) {
        this.number =number;
        this.face = face;
        this.value = value;
    }
    @Override
    public String toString() {
        return number+face+value;
    }
    @Override
    public boolean equals(Object c) {
        if (this.toString().equals(c.toString())) return true;
        else return false;
    }
    public void setValue(int g) {value=g;}
    public int getNumber() {return number;}
    public String getFace() {return face;}
    public int getValue() {return value;}
    public String getInfo() {
        if (number==1) return "A"+face;
        if (number==10) return "T"+face;
        if (number==11) return "J"+face;
        if (number==12) return "Q"+face;
        if (number==13) return "K"+face;
        else return number+face;
    }

    public static ArrayList<Card> createDeck(String s) {
        int normalvalue = 1;
        ArrayList<Card> cards = new ArrayList<Card>();
        int h = 0;
        int k = 1;
        for(int i = 0;i<=51;i++) {
            if (h==0) {
                cards.add(new Card(k,"S",1));
            }
            if (h==1) {
                cards.add(new Card(k,"C",1));
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
            int number;
            String face;
            int value;
            String[] t = new String[3];
            String[] c = new String[2];
            String[] p;
            while (values.hasNextLine()) {
                p = values.nextLine().split(" ");
                c = p[0].split("");
                if (c[1].compareTo("*")==0) {number=0;}
                else if (c[1].compareTo("A")==0) {number=1;}
                else if (c[1].compareTo("T")==0) {number=10;}
                else if (c[1].compareTo("J")==0) {number=11;}
                else if (c[1].compareTo("Q")==0) {number=12;}
                else if (c[1].compareTo("K")==0) {number=13;}
                else {number = Integer.parseInt(c[1]);}
                face = c[0];
                value = Integer.parseInt(p[1]);
                if (face.equals("*")) {
                    if (number==0) {
                        for (Card g:cards) {
                            if (g.getValue()==1) {
                                g.setValue(value);
                            }
                        }
                        normalvalue=value;
                    }
                    else {
                        cards.set(cards.indexOf(new Card(number,"S",normalvalue)),new Card(number,"S",value));
                        cards.set(cards.indexOf(new Card(number,"C",normalvalue)),new Card(number,"C",value));
                        cards.set(cards.indexOf(new Card(number,"H",normalvalue)),new Card(number,"H",value));
                        cards.set(cards.indexOf(new Card(number,"D",normalvalue)),new Card(number,"D",value));
                    }
                }
                else if (face.equals("S")) {
                    if (t[1]=="*") {
                        for (int i=1;i<=13;i++) {
                            if (cards.indexOf(new Card(i,"H",normalvalue))!=-1) {cards.set(cards.indexOf(new Card(i,"S",normalvalue)),new Card(i,"S",value));}
                        }
                    }
                    else {
                        cards.set(cards.indexOf(new Card(number,face,normalvalue)),new Card(number,face,value));
                    }
                }
                else if (face.equals("C")) {
                    if (number==0) {
                        for (int i=1;i<=13;i++) {
                            if (cards.indexOf(new Card(i,"H",normalvalue))!=-1) {cards.set(cards.indexOf(new Card(i,"C",normalvalue)),new Card(i,"C",value));}
                        }
                    }
                    else {
                        cards.set(cards.indexOf(new Card(Integer.parseInt("+"+t[1]),face,normalvalue)),new Card(number,face,value));
                    }
                }
                else if (face.equals("H")) {
                    if (number==0) {
                        for (int i=1;i<=13;i++) {
                            if (cards.indexOf(new Card(i,"H",normalvalue))!=-1) {cards.set(cards.indexOf(new Card(i,"H",normalvalue)),new Card(i,"H",value));}
                        }
                    }
                    else {
                        cards.set(cards.indexOf(new Card(number,face,normalvalue)),new Card(number,face,value));
                    }
                }
                else if (face.equals("D")) {
                    if (number==0) {
                        for (int i=1;i<=13;i++) {
                            if (cards.indexOf(new Card(i,"H",normalvalue))!=-1) {cards.set(cards.indexOf(new Card(i,"D",normalvalue)),new Card(i,"D",value));}
                        }
                    }
                    else {
                        cards.set(cards.indexOf(new Card(number,face,normalvalue)),new Card(number,face,value));
                    }
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
