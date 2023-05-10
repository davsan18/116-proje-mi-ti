import java.util.ArrayList;

class Game {
    public static void start(Player[] p) {
        System.out.println("-----GAME START-----");
        ArrayList<Card> deck = new ArrayList<Card>();
        ArrayList<Card> ground = new ArrayList<Card>();
        int a = 0;
        while (!deck.isEmpty()) {
            if (!p[a].hasCards()) {
                p[a].getCards(deck);
            }
            ground.add(p[a].playCard());
            if (a==3) a=0;
            else a++;
        }
    }
}