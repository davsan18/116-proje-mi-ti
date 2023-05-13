import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class BotNovice extends Player{

    public BotNovice(String name, String expertise) {
        super(name, expertise);
    }

    @Override
    public Card playCard(ArrayList<Card> cards,ArrayList<Card> cardsPlayed, Scanner s,Random r) {
        while (true) {
            int a = r.nextInt(4);
            if (!handUsed[a]) {
                handUsed[a]=true;
                return hand[a];
            }
        }
    }
}
