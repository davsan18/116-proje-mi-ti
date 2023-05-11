import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
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

    public int getNumber() {return number;}
    public String getFace() {return face;}
    public int getValue() {return value;}
    public String getInfo() {
        return number+face;
    }

    public static ArrayList<Card> createDeck(String s) {
        ArrayList<Card> cards = new ArrayList<Card>();
        int h = 0;
        int k = 1;
        for(int i = 0;i<=51;i++) {
            if (h==0) {
                cards.add(new Card(k,"s",1));
            }
            if (h==1) {
                cards.add( new Card(k,"c",1));
            }
            if (h==2) {
                cards.add(new Card(k,"h",1));
            }
            if (h==3) {
                cards.add(new Card(k,"d",1));
                h=-1;
                k++;
            }
            h++;
        }
        /**    try {
            Scanner values = new Scanner(Paths.get(s));
            String t;
            while (true) {
                t = values.nextLine();
            }
        }
        catch (IOException exception) {
            System.out.println("error");
        } */
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
