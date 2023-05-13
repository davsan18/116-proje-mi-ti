import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class HumanPlayer extends Player{
    public HumanPlayer(String name, String expertise) {
        super(name, expertise);
    }

    @Override
    public Card playCard(ArrayList<Card> cards,ArrayList<Card> cardsPlayed,Scanner s,Random r) {
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
}
