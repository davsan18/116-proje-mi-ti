import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class BotRegular extends BotNovice {
    public BotRegular(String name, String expertise) {
        super(name, expertise);
    }

    @Override
    public Card playCard(ArrayList<Card> cards,ArrayList<Card> cardsPlayed, Scanner s,Random r) {
        int points;
        if (cards.size()!=0) {
            points=0;
            for (int h=0;h<=3;h++) {
                if ((hand[h].getNumber()==11||cards.get(cards.size()-1).getNumber()==hand[h].getNumber())&&!handUsed[h]) {
                    for (Card c:cards) {points+=c.getValue();}
                    points+=hand[0].getValue();
                    if (points>0) {
                        return hand[h];
                    }
                }
            }
        }
        if (this.getExpertise()=="regular") {
            return super.playCard(cards,cardsPlayed,s,r);
        }
        else return null;
    }
}