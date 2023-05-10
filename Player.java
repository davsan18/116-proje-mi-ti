import java.util.ArrayList;

public abstract class Player {
    private String name;
    private ArrayList<Card> hand;
    private int points;
    public Player(String name) {
        this.name = name;
        hand = new ArrayList<Card>();
        points = 0;
    }
    public boolean hasCards() {
        return !hand.isEmpty();
    }
    public Card playCard() {
        return null;
    }
    public void getCards(ArrayList<Card> deck) {
        for (int i=0;i<=4;i++) {
            hand.add(deck.get(deck.size()));
        }
    }
    public void getPoints(int p) {
        points += p;
    }
}
