import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class BotExpert extends BotRegular {

    public BotExpert(String name, String expertise) {
        super(name, expertise);
    }

    @Override
    public Card playCard(ArrayList<Card> cards,ArrayList<Card> cardsPlayed, Scanner s,Random r) {
        Card x = super.playCard(cards, cardsPlayed, s, r);
        if (x==null) {
            int[] used = new int[4];
            for (Card c:cards) {
                int n = 0;
                for (Card ç:cardsPlayed) {
                    if (ç.equals(c)) {
                        used[n]++;
                    }
                }
                n++;
            }
            for (Card c:cards) {
                if (c.compare(x)) {
                    x = c;
                }
            }
        }
    }
}
