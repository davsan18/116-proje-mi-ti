import java.util.ArrayList;
import java.util.Scanner;

class Game {
    public static void start(Player[] p,String b) {
        System.out.println("-----GAME START-----");
        Scanner s = new Scanner(System.in);
        ArrayList<Card> deck = Card.cutDeck(Card.shuffleDeck(Card.createDeck(b)),s);
        ArrayList<Card> ground = new ArrayList<Card>();
        int a = 0;
        while (true) {
            if (p[a].isEmpty()) {
                p[a].getCards(deck,4);

            }
            ground.add(p[a].playCard());
            if (ground.get(ground.size())==ground.get(ground.size()-1)) {
                for (Card x:ground) {
                    p[a].getPoints(x.getValue());
                    ground.clear();
                }
            }
            if (a==3) a=0;
            else a++;
            if (deck.isEmpty()) {
                break;
            }
        }
    }
}