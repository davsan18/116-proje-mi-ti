import java.util.ArrayList;
import java.util.Scanner;

class Game {
    public static void start(Player[] players,String b) {
        System.out.println("-----GAME START-----");
        Scanner s = new Scanner(System.in);
        ArrayList<Card> deck = Card.cutDeck(Card.shuffleDeck(Card.createDeck(b)),s);
        ArrayList<Card> ground = new ArrayList<Card>();
        int a = 0;
        int o = 1;
        for (int y=1;y<=4;y++) {
            ground.add(deck.get(deck.size()-y));
        }
        for (int y=1;y<=4;y++) {
            deck.remove(deck.size()-1);
        }
        while (true) {
            if (players[players.length-1].isEmpty()) {
                for (int u=0;u<=players.length-1;u++) {
                    players[u].getCards(deck,4);
                    for (int i=0;i<=3;i++) {
                        deck.remove(deck.size()-1);
                    }
                }
            }
            System.out.print("Round "+o+" [");
            for (int i=0;i<=players.length-1;i++) {
                System.out.print("|"+players[i].getName()+":");
                for (int j=0;j<=3;j++) {
                    if (players[i].getCard(j)!=null) {
                        System.out.print(players[i].getCard(j).getInfo());
                    }
                    if (j<3) System.out.print(" ");
                }
                System.out.print(": Score "+players[i].getPoints()+"|");
            }
            System.out.println("]");
            ground.add(players[a].playCard(ground,s));
            s.reset();
            if (ground.size()>1) {
                if (ground.get(ground.size()-1).getNumber()==11) {
                    for (Card x:ground) {
                        players[a].getPoints(x.getValue());
                    }
                    ground.clear();
                }
                else if (ground.get(ground.size()-1).getNumber()==ground.get(ground.size()-2).getNumber()) {
                    if (ground.size()==2) {
                        players[a].getPoints(5*(ground.get(ground.size()-1).getNumber()+ground.get(ground.size()-2).getNumber()));
                    }
                    else {
                        for (Card x:ground) {
                            players[a].getPoints(x.getValue());
                        }
                    }
                    ground.clear();
                }
            }
            if (a==players.length-1) {a=0;o++;}
            else a++;
            if (deck.isEmpty()&&players[players.length-1].isEmpty()) {
                break;
                
            }
        }
        for (Player p:players) {
            Leaderboard.points(p.getName(),String.valueOf(p.getPoints()),p.getExpertise());
        }
    }
}