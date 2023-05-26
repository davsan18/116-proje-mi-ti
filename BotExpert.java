
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
        //plays if its worth to play
        if (x==null) {
            int[] used = new int[4];
            for (Card c:hand) {
                int n = 0;
                for (Card t:cardsPlayed) {
                    if (t.equals(c)) {
                        used[n]++;
                    }
                }
                n++;
            }
            int arr[] = new int[cardsleft()];
            for (int i =0;i<4;i++) {
                int yy=0;
                if (!handUsed[i]) {
                    arr[yy] = hand[i].getValue();
                    yy++;
                }
            }
            int temp = 0;
            for (int i = 0; i < arr.length; i++) {

                    
                    if (temp < arr[i]) {

                        temp = arr[i];

                }
            }
            for (int i =0;i<hand.length-1;i++){
                if(hand[i].getValue()==temp){
                    handUsed[i]=true;
                    x=hand[i];
                }
            }
        }
        return x;
    }
    public int cardsleft() {
        int i=0;
        for (boolean b: handUsed) {
            if (!b) i++;
        }
        return i;
    }
}
