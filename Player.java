import java.util.ArrayList;
import java.util.Scanner;

public class Player {
    private String name;
    private Card[] hand;
    private boolean[] handUsed;
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

    public Card playCard(ArrayList<Card> cards,Scanner s) {
        System.out.println("");
        System.out.print("ground = ");
        for (Card c:cards) {
            System.out.print(c.getInfo()+" ");
        }
        System.out.println();
        System.out.print("Hand = ");
        for (int m=0;m<=3;m++) {
            if (!handUsed[m])System.out.print(hand[m].getInfo()+" ");
            else System.out.print("   ");
        }
        System.out.println("   ");
        while (true) {
            try {
                String c = s.next();
                int a = Integer.valueOf(c)-1;
                if (a<=3&&0<=a) {
                    if (!handUsed[a]) {
                        handUsed[a]=true;
                        return hand[a];
                    }
                    else System.out.println("that card has been played");
                }
                else System.out.println("wrong number");
            }
            catch (NumberFormatException t) {
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

    public String getInfo() {
        return name+": {"+this.getCard(0).getInfo()+" "+this.getCard(1).getInfo()+" "+this.getCard(2).getInfo()+" "+this.getCard(3).getInfo()+"} Score "+this.getPoints();
    }
}
