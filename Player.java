import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
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
        for (Card c:hand) {
            if (c!=null)System.out.print(c.getInfo()+" ");
            else System.out.print("   ");
        }
        System.out.println("   ");
        while (true) {
            try {
                int a = s.nextInt()-1;
                if (a<=3&&0<=a) {
                    if (hand[a]!=null) {
                        Card b = hand[a];
                        hand[a]=null;
                        return b;
                    }
                    else System.out.println("that card has been played");
                }
                else System.out.println("wrong number");
            }
            catch (InputMismatchException t) {
                System.out.println("wrong input");
            }
        }
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
