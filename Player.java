import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public abstract class Player {
    private String name;
    protected Card[] hand;
    protected boolean[] handUsed;
    private int points;
    private String expertise;

    public Player(String name,String expertise) {
        this.name = name;
        this.expertise = expertise;
        hand = new Card[4];
        handUsed = new boolean[4];
        points = 0;
    }

    public String getName() {return name;}
    public int getPoints() {return points;}
    public String getExpertise() {return expertise;}
    public Card getCard(int i) {return hand[i];}

    public boolean isEmpty() {
        for (int i=0;i<=3;i++) {
            if  (handUsed[i]!=true) {
                return false;
            }
        }
        return true;
    }

    abstract public Card playCard(ArrayList<Card> cards,ArrayList<Card> cardsPlayed,Scanner s,Random r);

    public void getCards(ArrayList<Card> deck,int x) {
        for (int i=0;i<x;i++) {
            hand[i]=(deck.get(deck.size()-i-1));
        }
    }

    public void getPoints(int p) {
        points += p;
    }

    public String getInfo() {
        return name+": {"+this.getCard(0).getInfo()+" "+this.getCard(1).getInfo()+" "+this.getCard(2).getInfo()+" "+this.getCard(3).getInfo()+"} Score "+this.getPoints();
    }
}
