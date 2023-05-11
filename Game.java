import java.util.ArrayList;
import java.util.Scanner;

class Game {
    public static void start(String b) {
        Player[] players = new Player[4];
        Player aaa = new Player("abc","low");
        Player bbb = new Player("dsa","high");
        Player ccc = new Player("fgh","easy");
        Player ddd = new Player("qwe","hard");
        players[0] = aaa;
        players[1] = bbb;
        players[2] = ccc;
        players[3] = ddd;
        System.out.println("-----GAME START-----");
        Scanner s = new Scanner(System.in);
        ArrayList<Card> deck = Card.cutDeck(Card.shuffleDeck(Card.createDeck(b)),s);
        ArrayList<Card> ground = new ArrayList<Card>();
        int a = 0;
        while (true) {
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
        Leaderboard.points(players[0].getName(),String.valueOf(players[0].getPoints()),players[0].getExpertise());
        Leaderboard.points(players[1].getName(),String.valueOf(players[1].getPoints()),players[1].getExpertise());
        Leaderboard.points(players[2].getName(),String.valueOf(players[2].getPoints()),players[2].getExpertise());
        Leaderboard.points(players[3].getName(),String.valueOf(players[3].getPoints()),players[3].getExpertise());
    }
}