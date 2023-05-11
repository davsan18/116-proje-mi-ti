import java.util.ArrayList;
import java.util.Scanner;

class Game {
    public static void start(Player[] players,String b) {
        System.out.println("-----GAME START-----");
        Scanner s = new Scanner(System.in);
        ArrayList<Card> deck = Card.cutDeck(Card.shuffleDeck(Card.createDeck(b)),s);
        ArrayList<Card> ground = new ArrayList<Card>();
        int a = 0;
        while (true) {
            System.out.println("["+players[0].getName()+":"+players[0].getPoints()+"/"+players[1].getName()+":"+players[1].getPoints()+"/"+players[2].getName()+":"+players[2].getPoints()+"/"+players[3].getName()+":"+players[3].getPoints()+"]");
            if (players[a].isEmpty()) {
                players[a].getCards(deck,4);
                for (int i=0;i<=3;i++) {
                    deck.remove(deck.size()-1);
                }
            }
            ground.add(players[a].playCard(ground,s));
            if (ground.size()>1) {
                if (ground.get(ground.size()-1).getNumber()==ground.get(ground.size()-2).getNumber()) {
                    for (Card x:ground) {
                        players[a].getPoints(x.getValue());
                    }
                    ground.clear();
                }
            }
            if (a==3) a=0;
            else a++;
            if (deck.isEmpty()) {
                break;
                
            }
        }
        for (Player p:players) {
            Leaderboard.points(p.getName(),String.valueOf(p.getPoints()),p.getExpertise());
        }
    }
}