import java.util.ArrayList;
import java.util.Scanner;

public class Player {
    private String name;
    private Card[] hand;
    private int points;
    private String expertise;

    public Player(String name,String expertise) {
        this.name = name;
        this.expertise = expertise;
        hand = new Card[4];
        points = 0;
    }

    public String getName() {return name;}
    public int getPoints() {return points;}
    public String getExpertise() {return expertise;}

    public boolean isEmpty() {
        for (int i=0;i<=3;i++) {
            if  (hand[i]!=null) {
                return false;
            }
        }
        return true;
    }

    public Card playCard(ArrayList<Card> cards,Scanner s) {
        System.out.println("--------------------");
        for (Card c:cards) {
            System.out.print(c.getInfo()+" ");
        }
        System.out.println();
        if (hand[0]!=null)System.out.print(hand[0].getInfo()+" ");
        else System.out.print("   ");
        if (hand[1]!=null)System.out.print(hand[1].getInfo()+" ");
        else System.out.print("   ");
        if (hand[2]!=null)System.out.print(hand[2].getInfo()+" ");
        else System.out.print("   ");
        if (hand[3]!=null)System.out.println(hand[3].getInfo());
        else System.out.println("   ");
        int a = s.nextInt();
        Card b = hand[a];
        hand[a]=null;
        return b;
    }

    public void getCards(ArrayList<Card> deck,int x) {
        for (int i=0;i<x;i++) {
            hand[i]=(deck.get(deck.size()-i-1));
        }
    }

    public void getPoints(int p) {
        points += p;
    }
}
